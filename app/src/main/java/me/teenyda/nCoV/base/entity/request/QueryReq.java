package me.teenyda.nCoV.base.entity.request;

import java.util.Map;

import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.NET_URL;

public class QueryReq extends BaseRequest {
    //用户自己的APIKEY
    public String key = NET_URL.TIANXING_APIKEY;
    //交通类型，默认飞机
    //1飞机，2火车，3地铁，4长途客车/大巴，5公交车，6出租车，7轮船，8其他公共场所
    public String type;
    public String date;
    //车次
    public String no;
    //到达地点
    public String arrive;
    //返回数量
    public String num;
    //翻页
    public String page;

    @Override
    public Map<String, String> build() {
        Map<String, String> build = super.build();
        build.put("key", key);
        build.put("type", type);
        build.put("date", date);
        build.put("no", no);
        build.put("arrive", arrive);
        build.put("num", num);
        build.put("page", page);
        return build;
    }
}
