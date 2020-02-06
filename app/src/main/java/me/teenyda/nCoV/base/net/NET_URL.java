package me.teenyda.nCoV.base.net;

public class NET_URL {

    // RELEASE
    public static final String MODEL = "DEBUG";

    public static final String BASE_URL = "http://192.168.43.93:9000/";
    public static final String RELEASE_URL = "http://11.22.33.44/";

    public static final String API = "api/";

    public static final String get_book_list = "app/book/list";

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
