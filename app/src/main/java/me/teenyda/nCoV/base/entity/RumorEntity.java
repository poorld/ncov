package me.teenyda.nCoV.base.entity;

public class RumorEntity {


    /**
     * id : 160
     * title : 温州确诊病例有 40% 是变异病毒？
     * mainSummary : 广州疾控中心辟谣：新型冠状病毒未发生明显的变异
     * summary :
     * body : 近日，「温州 490 例里有 40% 是全新变异的病毒，疾控中心现在要排查 3 万多人从温州回广东的这批人」这一谣言在广州地区用户微信群转发。广州疾控中心表示，我国最新研究表明：新型冠状病毒未发生明显的变异。对新型冠状病毒的密切监测也表明，不论是环境中分离的病毒，还是前期在人体中分离的病毒，再到近日分离的病毒，均未发现明显的变异。
     * sourceUrl :
     * score : 1000
     * rumorType : 0
     */

    private int id;
    private String title;
    private String mainSummary;
    private String summary;
    private String body;
    private String sourceUrl;
    private int score;
    private int rumorType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainSummary() {
        return mainSummary;
    }

    public void setMainSummary(String mainSummary) {
        this.mainSummary = mainSummary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRumorType() {
        return rumorType;
    }

    public void setRumorType(int rumorType) {
        this.rumorType = rumorType;
    }
}
