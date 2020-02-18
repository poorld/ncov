package me.teenyda.nCoV.base.net;

public class NET_URL {

    // RELEASE
    public static final String MODEL = "DEBUG";

    public static final String BASE_URL = "http://192.168.43.93:9000/";
    public static final String RELEASE_URL = "http://11.22.33.44/";


    public static final String API = "api/";

    public static final String get_book_list = "app/book/list";



    /**
     * 天行数据 api接口
     */
    public static final String TIANXING_APIKEY = "f9e6994ab4e90f93b1e4f22747468cf2";
    public static final String TIANXING_URL = "http://api.tianapi.com/txapi/ncovsame/index" + TIANXING_APIKEY;

    public static String getRequestUrl(String uri) {
        switch (MODEL) {
            case "DEBUG":
                return BASE_URL + API + uri;
            case "RELEASE":
                return RELEASE_URL + API + uri;
            default:
                return BASE_URL + API + uri;
        }
    }
}
