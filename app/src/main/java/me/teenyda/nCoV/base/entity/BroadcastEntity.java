package me.teenyda.nCoV.base.entity;

public class BroadcastEntity {


    /**
     * id : 5449
     * pubDate : 1582167016000
     * pubDateStr : 12分钟前
     * title : 钻石公主号2名新冠肺炎感染者死亡
     * summary : 据日本广播协会电视台20日报道，2名在“钻石公主”号邮轮上感染冠肺炎的患者死亡。这首次出现在“钻石公主”号邮轮感染新冠肺炎后死亡的病例。截至目前，日本国内新冠肺炎死亡病例增至3例。
     * infoSource : 人民日报
     * sourceUrl : http://m.weibo.cn/2803301701/4473995094751309
     * provinceId : 1
     * createTime : 1582167379000
     * modifyTime : 1582167379000
     * entryWay : 1
     * adoptType : 1
     * infoType : 1
     * dataInfoState : 0
     * dataInfoOperator :
     * dataInfoTime : 1582167379000
     * provinceName : 全国
     */

    private int id;
    private long pubDate;
    private String pubDateStr;
    private String title;
    private String summary;
    private String infoSource;
    private String sourceUrl;
    private String provinceId;
    private long createTime;
    private long modifyTime;
    private int entryWay;
    private int adoptType;
    private int infoType;
    private int dataInfoState;
    private String dataInfoOperator;
    private long dataInfoTime;
    private String provinceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubDateStr() {
        return pubDateStr;
    }

    public void setPubDateStr(String pubDateStr) {
        this.pubDateStr = pubDateStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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

    public int getEntryWay() {
        return entryWay;
    }

    public void setEntryWay(int entryWay) {
        this.entryWay = entryWay;
    }

    public int getAdoptType() {
        return adoptType;
    }

    public void setAdoptType(int adoptType) {
        this.adoptType = adoptType;
    }

    public int getInfoType() {
        return infoType;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public int getDataInfoState() {
        return dataInfoState;
    }

    public void setDataInfoState(int dataInfoState) {
        this.dataInfoState = dataInfoState;
    }

    public String getDataInfoOperator() {
        return dataInfoOperator;
    }

    public void setDataInfoOperator(String dataInfoOperator) {
        this.dataInfoOperator = dataInfoOperator;
    }

    public long getDataInfoTime() {
        return dataInfoTime;
    }

    public void setDataInfoTime(long dataInfoTime) {
        this.dataInfoTime = dataInfoTime;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
