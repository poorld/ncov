package me.teenyda.nCoV.base.entity;

import java.util.List;

/**
 * 病患同行查询
 * https://www.tianapi.com/apiview/172
 * 返回字段type类型：1飞机，2火车，3地铁，4长途客车/大巴，5公交车，6出租车，7轮船，8其他公共场所
 */
public class QueryEntity {



    /**
     * code : 200
     * msg : success
     * newslist : [{"id":50,"date":"2020-01-23","start":"2020-01-23T01:57:00.000Z","end":"2020-01-23T15:59:59.000Z","type":4,"no":"南充川R60720","memo":"","no_sub":"","pos_start":"南充","pos_end":"武胜县烈面镇","source":"https://mp.weixin.qq.com/s/jEBlMLCgSTD9AcpcV1yRtg","who":"央视新闻","verified":1,"created_at":"2020-01-27T10:02:43.000Z","updated_at":"2020-01-27T10:02:43.000Z"},{"id":52,"date":"2020-01-23","start":"2020-01-23T00:14:00.000Z","end":"2020-01-23T00:28:00.000Z","type":5,"no":"锡林浩特市3路公交车","memo":"","no_sub":"","pos_start":"报社站","pos_end":"盟医院站","source":"https://mp.weixin.qq.com/s/jEBlMLCgSTD9AcpcV1yRtg","who":"央视新闻","verified":1,"created_at":"2020-01-27T10:04:52.000Z","updated_at":"2020-01-27T10:04:52.000Z"},{"id":53,"date":"2020-01-23","start":"2020-01-22T23:55:00.000Z","end":"2020-01-23T12:28:00.000Z","type":2,"no":"G1278","memo":"同车厢共有乘客53人","no_sub":"2号车厢","pos_start":"武汉","pos_end":"哈尔滨西","source":"https://mp.weixin.qq.com/s/jEBlMLCgSTD9AcpcV1yRtg","who":"央视新闻","verified":1,"created_at":"2020-01-27T10:06:36.000Z","updated_at":"2020-01-27T10:06:36.000Z"},{"id":61,"date":"2020-01-23","start":"2020-01-23T02:00:00.000Z","end":"2020-01-23T15:59:59.000Z","type":5,"no":"本溪28路公交车","memo":"","no_sub":"","pos_start":"顺山车站","pos_end":"本钢总院","source":"https://baijiahao.baidu.com/s?id=1656758480273984649&wfr=spider&for=pc","who":"中国日报网","verified":1,"created_at":"2020-01-27T10:56:54.000Z","updated_at":"2020-01-27T10:56:54.000Z"},{"id":121,"date":"2020-01-23","start":"2020-01-23T04:10:00.000Z","end":"2020-01-23T15:59:59.000Z","type":5,"no":"富平县陕ED0098号","memo":"","no_sub":"","pos_start":"富平县新华大厦门前","pos_end":"到贤镇","source":"http://news.hsw.cn/system/2020/0127/1149962.shtml","who":"富平县疾病预防控制中心","verified":1,"created_at":"2020-01-27T13:02:14.000Z","updated_at":"2020-01-27T13:02:14.000Z"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * id : 50
         * date : 2020-01-23
         * start : 2020-01-23T01:57:00.000Z
         * end : 2020-01-23T15:59:59.000Z
         * type : 4
         * no : 南充川R60720
         * memo :
         * no_sub :
         * pos_start : 南充
         * pos_end : 武胜县烈面镇
         * source : https://mp.weixin.qq.com/s/jEBlMLCgSTD9AcpcV1yRtg
         * who : 央视新闻
         * verified : 1
         * created_at : 2020-01-27T10:02:43.000Z
         * updated_at : 2020-01-27T10:02:43.000Z
         */

        private int id;
        private String date;
        private String start;
        private String end;
        private int type;
        private String no;
        private String memo;
        private String no_sub;
        private String pos_start;
        private String pos_end;
        private String source;
        private String who;
        private int verified;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getNo_sub() {
            return no_sub;
        }

        public void setNo_sub(String no_sub) {
            this.no_sub = no_sub;
        }

        public String getPos_start() {
            return pos_start;
        }

        public void setPos_start(String pos_start) {
            this.pos_start = pos_start;
        }

        public String getPos_end() {
            return pos_end;
        }

        public void setPos_end(String pos_end) {
            this.pos_end = pos_end;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public int getVerified() {
            return verified;
        }

        public void setVerified(int verified) {
            this.verified = verified;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
