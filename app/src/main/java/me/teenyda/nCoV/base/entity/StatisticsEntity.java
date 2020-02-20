package me.teenyda.nCoV.base.entity;

import java.util.List;

public class StatisticsEntity {


    /**
     * id : 1
     * createTime : 1579537899000
     * modifyTime : 1582002267000
     * infectSource : 该字段已替换为说明2
     * passWay : 该字段已替换为说明3
     * imgUrl : https://img1.dxycdn.com/2020/0201/450/3394153392393266839-135.png
     * dailyPic : https://img1.dxycdn.com/2020/0211/763/3395998884005602079-135.png,https://img1.dxycdn.com/2020/0211/362/3395998896890788910-135.png,https://img1.dxycdn.com/2020/0211/365/3395998905480724211-135.png,https://img1.dxycdn.com/2020/0211/364/3395998916217859778-135.png,https://img1.dxycdn.com/2020/0211/922/3395998929103046444-135.png,https://img1.dxycdn.com/2020/0211/089/3395998939840182072-135.png
     * dailyPics : ["https://img1.dxycdn.com/2020/0211/763/3395998884005602079-135.png","https://img1.dxycdn.com/2020/0211/362/3395998896890788910-135.png","https://img1.dxycdn.com/2020/0211/365/3395998905480724211-135.png","https://img1.dxycdn.com/2020/0211/364/3395998916217859778-135.png","https://img1.dxycdn.com/2020/0211/922/3395998929103046444-135.png","https://img1.dxycdn.com/2020/0211/089/3395998939840182072-135.png"]
     * summary :
     * deleted : false
     * countRemark :
     * currentConfirmedCount : 57978
     * confirmedCount : 72530
     * suspectedCount : 6242
     * curedCount : 12682
     * deadCount : 1870
     * seriousCount : 11741
     * suspectedIncr : 1432
     * currentConfirmedIncr : -27
     * confirmedIncr : 1893
     * curedIncr : 1822
     * deadIncr : 98
     * seriousIncr : 1097
     * virus : 该字段已替换为说明1
     * remark1 : 易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病
     * remark2 : 潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见
     * remark3 : 宿主：野生动物，可能为中华菊头蝠
     * remark4 :
     * remark5 :
     * note1 : 病毒：SARS-CoV-2，其导致疾病命名 COVID-19
     * note2 : 传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。
     * note3 : 传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。
     * generalRemark : 疑似病例数来自国家卫健委数据，目前为全国数据，未分省市自治区等
     * abroadRemark :
     * marquee : [{"id":529,"marqueeLabel":"资讯","marqueeContent":"武昌医院院长因新冠肺炎去世","marqueeLink":"https://dxy.me/zaP0HU"}]
     * quanguoTrendChart : [{"imgUrl":"https://img1.dxycdn.com/2020/0218/592/3397287380636754478-135.png","title":"新增疑似/新增确诊"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/919/3397287393522086402-135.png","title":"确诊/疑似"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/281/3397287406406988895-135.png","title":"死亡/治愈"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/638/3397287419291462033-135.png","title":"病死率/治愈率"}]
     * hbFeiHbTrendChart : [{"imgUrl":"https://img1.dxycdn.com/2020/0218/144/3397287438619245257-135.png","title":"新增确诊"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/415/3397287449356234699-135.png","title":"确诊"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/142/3397287462241137240-135.png","title":"死亡/治愈"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/939/3397287477273690674-135.png","title":"病死率"},{"imgUrl":"https://img1.dxycdn.com/2020/0218/577/3397287490158593248-135.png","title":"治愈率"}]
     */

    private int id;
    private long createTime;
    private long modifyTime;
    private String infectSource;
    private String passWay;
    private String imgUrl;
    private String dailyPic;
    private String summary;
    private boolean deleted;
    private String countRemark;
    private int currentConfirmedCount;
    private int confirmedCount;
    private int suspectedCount;
    private int curedCount;
    private int deadCount;
    private int seriousCount;
    private int suspectedIncr;
    private int currentConfirmedIncr;
    private int confirmedIncr;
    private int curedIncr;
    private int deadIncr;
    private int seriousIncr;
    private String virus;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String note1;
    private String note2;
    private String note3;
    private String generalRemark;
    private String abroadRemark;
    private List<String> dailyPics;
    private List<MarqueeBean> marquee;
    private List<QuanguoTrendChartBean> quanguoTrendChart;
    private List<HbFeiHbTrendChartBean> hbFeiHbTrendChart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getInfectSource() {
        return infectSource;
    }

    public void setInfectSource(String infectSource) {
        this.infectSource = infectSource;
    }

    public String getPassWay() {
        return passWay;
    }

    public void setPassWay(String passWay) {
        this.passWay = passWay;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDailyPic() {
        return dailyPic;
    }

    public void setDailyPic(String dailyPic) {
        this.dailyPic = dailyPic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCountRemark() {
        return countRemark;
    }

    public void setCountRemark(String countRemark) {
        this.countRemark = countRemark;
    }

    public int getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(int currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public int getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public int getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }

    public int getSeriousCount() {
        return seriousCount;
    }

    public void setSeriousCount(int seriousCount) {
        this.seriousCount = seriousCount;
    }

    public int getSuspectedIncr() {
        return suspectedIncr;
    }

    public void setSuspectedIncr(int suspectedIncr) {
        this.suspectedIncr = suspectedIncr;
    }

    public int getCurrentConfirmedIncr() {
        return currentConfirmedIncr;
    }

    public void setCurrentConfirmedIncr(int currentConfirmedIncr) {
        this.currentConfirmedIncr = currentConfirmedIncr;
    }

    public int getConfirmedIncr() {
        return confirmedIncr;
    }

    public void setConfirmedIncr(int confirmedIncr) {
        this.confirmedIncr = confirmedIncr;
    }

    public int getCuredIncr() {
        return curedIncr;
    }

    public void setCuredIncr(int curedIncr) {
        this.curedIncr = curedIncr;
    }

    public int getDeadIncr() {
        return deadIncr;
    }

    public void setDeadIncr(int deadIncr) {
        this.deadIncr = deadIncr;
    }

    public int getSeriousIncr() {
        return seriousIncr;
    }

    public void setSeriousIncr(int seriousIncr) {
        this.seriousIncr = seriousIncr;
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNote3() {
        return note3;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    public String getGeneralRemark() {
        return generalRemark;
    }

    public void setGeneralRemark(String generalRemark) {
        this.generalRemark = generalRemark;
    }

    public String getAbroadRemark() {
        return abroadRemark;
    }

    public void setAbroadRemark(String abroadRemark) {
        this.abroadRemark = abroadRemark;
    }

    public List<String> getDailyPics() {
        return dailyPics;
    }

    public void setDailyPics(List<String> dailyPics) {
        this.dailyPics = dailyPics;
    }

    public List<MarqueeBean> getMarquee() {
        return marquee;
    }

    public void setMarquee(List<MarqueeBean> marquee) {
        this.marquee = marquee;
    }

    public List<QuanguoTrendChartBean> getQuanguoTrendChart() {
        return quanguoTrendChart;
    }

    public void setQuanguoTrendChart(List<QuanguoTrendChartBean> quanguoTrendChart) {
        this.quanguoTrendChart = quanguoTrendChart;
    }

    public List<HbFeiHbTrendChartBean> getHbFeiHbTrendChart() {
        return hbFeiHbTrendChart;
    }

    public void setHbFeiHbTrendChart(List<HbFeiHbTrendChartBean> hbFeiHbTrendChart) {
        this.hbFeiHbTrendChart = hbFeiHbTrendChart;
    }

    public static class MarqueeBean {
        /**
         * id : 529
         * marqueeLabel : 资讯
         * marqueeContent : 武昌医院院长因新冠肺炎去世
         * marqueeLink : https://dxy.me/zaP0HU
         */

        private int id;
        private String marqueeLabel;
        private String marqueeContent;
        private String marqueeLink;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMarqueeLabel() {
            return marqueeLabel;
        }

        public void setMarqueeLabel(String marqueeLabel) {
            this.marqueeLabel = marqueeLabel;
        }

        public String getMarqueeContent() {
            return marqueeContent;
        }

        public void setMarqueeContent(String marqueeContent) {
            this.marqueeContent = marqueeContent;
        }

        public String getMarqueeLink() {
            return marqueeLink;
        }

        public void setMarqueeLink(String marqueeLink) {
            this.marqueeLink = marqueeLink;
        }
    }

    public static class QuanguoTrendChartBean {
        /**
         * imgUrl : https://img1.dxycdn.com/2020/0218/592/3397287380636754478-135.png
         * title : 新增疑似/新增确诊
         */

        private String imgUrl;
        private String title;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class HbFeiHbTrendChartBean {
        /**
         * imgUrl : https://img1.dxycdn.com/2020/0218/144/3397287438619245257-135.png
         * title : 新增确诊
         */

        private String imgUrl;
        private String title;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
