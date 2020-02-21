package me.teenyda.nCoV.base.net;

public class NET_URL {

    // RELEASE
//    public static final String MODEL = "DEBUG";
    public static final String MODEL = "RELEASE";

    public static final String BASE_URL = "http://192.168.1.4:8080/";
    public static final String RELEASE_URL = "http://47.94.234.77:9000/";


    public static final String API = "api/";

    public static final String get_book_list = "app/book/list";



    /**
     * 天行数据 api接口
     */
    public static final String TIANXING_APIKEY = "f9e6994ab4e90f93b1e4f22747468cf2";
    public static final String TIANXING_URL = "http://api.tianapi.com/txapi/ncovsame/index";

    public static final String get_init_data = "init";
    /**
     * 所有数据
     */
    public static final String get_all_data = "getAllList";

    /**
     * 首页数据(患者人数，趋势图)
     */
    public static final String get_index_data = "getStatisticsService";

    /**
     * 省份人数
     */
    public static final String get_province_data = "getAreaStat";

    /**
     * 谣言
     */
    public static final String get_rumor_list = "getIndexRumorList";

    /**
     * 实时播报
     */
    public static final String get_broadcast = "getTimelineService";

    /**
     * 疾病知识
     */
    public static final String get_knowledge = "getWikiList";


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
