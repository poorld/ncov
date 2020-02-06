package me.teenyda.nCoV.base.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import me.teenyda.nCoV.base.exception.NetException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RXNetApi {

    enum Type {GET, POST, PUT, DELETE}

    private static Request doGet(String url, BaseRequest requestForm) {
        Map<String, String> form = requestForm.build();
        Set<String> keySet = form.keySet();
        String formBody = "?";
        for (String key : keySet) {
            String value = form.get(key);
            formBody += key + "=" + value + "&";
        }


        Request request = new Request.Builder()
                .get()
                .url(NET_URL.getRequestUrl(url))
                .build();
        return request;
    }

    public static <T extends BaseResponse> Observable quackQuery(final BaseRequest baseRequest, final RXNetApi.Type type, final String url, final Class<T> clazz) {


        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(final ObservableEmitter emitter)  {
                Request request = null;
                switch (type) {
                    case GET:
                        request = doGet(url, baseRequest);
                        break;
                    case POST:
                        break;
                    case PUT:
                        break;
                    case DELETE:
                        break;
                }

                OkHttpClient client = new OkHttpClient.Builder()
                        .readTimeout(5000, TimeUnit.MILLISECONDS)
                        .writeTimeout(5000, TimeUnit.MILLISECONDS)
                        .build();

                if (!emitter.isDisposed()) {

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            emitter.onError(new NetException(e.getMessage(), "40001"));
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try {
                                T resp = clazz.newInstance();

                                String responJson = response.body().string();

                                JSONObject jsonObject = JSON.parseObject(responJson);

                                String code = jsonObject.getString("code");
                                String message = jsonObject.getString("message");
                                String data = jsonObject.getString("data");

                                if ("40001".equals(code)) {
                                    emitter.onError(new NetException(message, code));
                                    return;
                                }

                                resp.code = code;
                                resp.message = message;
                                resp.data = data;

                                emitter.onNext(resp);

                                emitter.onComplete();


                            } catch (Exception e) {
                                emitter.onError(new NetException(e.getMessage(), "40001"));
                            }
                        }
                    });
                }
            }
        });
    }

}
