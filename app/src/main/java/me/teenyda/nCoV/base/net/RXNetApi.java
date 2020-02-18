package me.teenyda.nCoV.base.net;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import me.teenyda.nCoV.base.exception.NetException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RXNetApi {

    enum Type {GET, POST, PUT, DELETE}

    public static final MediaType JSONTYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     *
     * @param isNewParam 是否是新加参数(true则拼接?，false拼接&)
     * http://xxx.xx?key=APIKEY false
     * http://xxx.xx true
     * @param useDefaultUrl false则直接使用url
     * @param req
     * @param url
     * @return
     */
    private static Request buildGetRequest(boolean useDefaultUrl, BaseRequest req, String url) {
        String formBody = "?";
        Map<String, String> map = req.build();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            if (!TextUtils.isEmpty(value)) {
                formBody += key + "=" + value + "&";
            }
        }

        url = url + formBody;

        Request request = new Request.Builder()
                .get()
                .url(useDefaultUrl ? NET_URL.getRequestUrl(url) : url)
                .build();
        return request;
    }

    private static Request buildPostRequest1(boolean isNewParam, boolean useDefaultUrl, BaseRequest req, String url) {
        /**
         * FromBody---表单提交 这种能满足大部分的需求
         * FromBody用于提交表单键值对,key-value,其作用类似于HTML中的<form>标记。比如username="LHX",age="21"等类似的键值对
         *
         * 作者：芒果味的你呀
         * 链接：https://www.jianshu.com/p/1133389c1f75
         * 来源：简书
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        FormBody.Builder builder = new FormBody.Builder();
        Map<String, String> map = req.build();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            if (!TextUtils.isEmpty(value)) {
                builder.add(key, value);
            }
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .post(formBody)
                .url(useDefaultUrl ? NET_URL.getRequestUrl(url) : url)
                .build();
        return request;
    }

    private static Request buildPostRequest2(boolean isNewParam, boolean useDefaultUrl, BaseRequest req, String url) {
        /**
         * RequestBody--json数据提交
         */
        Map<String, String> map = req.build();
        String jsonString = JSONObject.toJSONString(map);
        RequestBody requestBody = RequestBody.create(JSONTYPE, jsonString);
        Request request = new Request.Builder()
                .post(requestBody)
                .url(useDefaultUrl ? NET_URL.getRequestUrl(url) : url)
                .build();
        return request;
    }
    private static Request doGet(String url, BaseRequest requestForm) {
        return buildGetRequest(true, requestForm, url);
    }


    private static Request otherGet(String url, BaseRequest requestForm) {
        return buildGetRequest( false, requestForm, url);
    }

    private static Request buildReq(BaseRequest baseRequest,RXNetApi.Type type, String url) {
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
        return request;
    }

    private static Request buildOtherReq(BaseRequest baseRequest,RXNetApi.Type type, String url) {
        Request request = null;
        switch (type) {
            case GET:
                request = otherGet(url, baseRequest);
                break;
            case POST:
                break;
            case PUT:
                break;
            case DELETE:
                break;
        }
        return request;
    }

    /**
     * @param clazz
     * @param <T>
     * @param respParam
     * 我的返回格式：
     * {
     *  "code":200,
     *  "message":"success",
     *  "data": [] 或 {}
     * }
     * 第三方返回格式:
     * {
     * "code":200,
     * "msg":"success",
     * "newslist":[]
     * }
     * respParam的key分别要填入code,message,data
     * value为第三方返回的字段，使得
     * resp.code = jsonObject.getString(respParam.get("code"));
     * resp.message = jsonObject.getString(respParam.get("message"));
     * resp.data = jsonObject.getString(respParam.get("data"));
     * @return
     */
    public static <T extends BaseResponse> Observable apiQuery(Request request, final Class<T> clazz, final Map<String,String> respParam) {

        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(final ObservableEmitter emitter)  {

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

                                String code = jsonObject.getString(respParam.get("code"));
                                String message = jsonObject.getString(respParam.get("message"));
                                String data = jsonObject.getString(respParam.get("data"));

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

    public static  <T extends BaseResponse> Observable quackGet(BaseRequest baseRequest, String url){
        return quackGet(baseRequest,url,BaseResponse.class);
    }

    public static  <T extends BaseResponse> Observable quackGet(BaseRequest baseRequest, String url, Class<T> clazz){
        Map<String, String> respParam = new HashMap<>();
        respParam.put("code", "code");
        respParam.put("message", "message");
        respParam.put("data", "data");
        Request request = buildReq(baseRequest, Type.GET, url);
        return apiQuery(request, clazz, respParam);
    }


    public static <T extends BaseResponse> Observable otherQuery(BaseRequest baseRequest, RXNetApi.Type type, String url, Class<T> clazz, Map<String,String> respParam){
        Request request = buildOtherReq(baseRequest, type, url);
        return apiQuery(request, clazz, respParam);
    }
}
