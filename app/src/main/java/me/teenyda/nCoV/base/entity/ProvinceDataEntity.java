package me.teenyda.nCoV.base.entity;

import java.util.List;

public class ProvinceDataEntity {


    /**
     * provinceName : 湖北省
     * provinceShortName : 湖北
     * currentConfirmedCount : 50633
     * confirmedCount : 61682
     * suspectedCount : 0
     * curedCount : 9128
     * deadCount : 1921
     * comment :
     * locationId : 420000
     * cities : [{"cityName":"武汉","currentConfirmedCount":38020,"confirmedCount":44412,"suspectedCount":0,"curedCount":4895,"deadCount":1497,"locationId":420100},{"cityName":"孝感","currentConfirmedCount":2690,"confirmedCount":3344,"suspectedCount":0,"curedCount":572,"deadCount":82,"locationId":420900},{"cityName":"黄冈","currentConfirmedCount":1700,"confirmedCount":2844,"suspectedCount":0,"curedCount":1059,"deadCount":85,"locationId":421100},{"cityName":"荆州","currentConfirmedCount":1094,"confirmedCount":1541,"suspectedCount":0,"curedCount":409,"deadCount":38,"locationId":421000},{"cityName":"鄂州","currentConfirmedCount":1005,"confirmedCount":1343,"suspectedCount":0,"curedCount":301,"deadCount":37,"locationId":420700},{"cityName":"随州","currentConfirmedCount":1000,"confirmedCount":1280,"suspectedCount":0,"curedCount":254,"deadCount":26,"locationId":421300},{"cityName":"襄阳","currentConfirmedCount":913,"confirmedCount":1165,"suspectedCount":0,"curedCount":230,"deadCount":22,"locationId":420600},{"cityName":"黄石","currentConfirmedCount":696,"confirmedCount":983,"suspectedCount":0,"curedCount":262,"deadCount":25,"locationId":420200},{"cityName":"荆门","currentConfirmedCount":687,"confirmedCount":901,"suspectedCount":0,"curedCount":181,"deadCount":33,"locationId":420800},{"cityName":"宜昌","currentConfirmedCount":674,"confirmedCount":907,"suspectedCount":0,"curedCount":208,"deadCount":25,"locationId":420500},{"cityName":"咸宁","currentConfirmedCount":597,"confirmedCount":832,"suspectedCount":0,"curedCount":225,"deadCount":10,"locationId":421200},{"cityName":"十堰","currentConfirmedCount":472,"confirmedCount":638,"suspectedCount":0,"curedCount":164,"deadCount":2,"locationId":420300},{"cityName":"天门","currentConfirmedCount":402,"confirmedCount":486,"suspectedCount":0,"curedCount":73,"deadCount":11,"locationId":429006},{"cityName":"仙桃","currentConfirmedCount":394,"confirmedCount":562,"suspectedCount":0,"curedCount":149,"deadCount":19,"locationId":429004},{"cityName":"恩施州","currentConfirmedCount":150,"confirmedCount":249,"suspectedCount":0,"curedCount":96,"deadCount":3,"locationId":422800},{"cityName":"潜江","currentConfirmedCount":139,"confirmedCount":185,"suspectedCount":0,"curedCount":40,"deadCount":6,"locationId":429005},{"cityName":"神农架林区","currentConfirmedCount":0,"confirmedCount":10,"suspectedCount":0,"curedCount":10,"deadCount":0,"locationId":429021}]
     */

    private String provinceName;
    private String provinceShortName;
    private int currentConfirmedCount;
    private int confirmedCount;
    private int suspectedCount;
    private int curedCount;
    private int deadCount;
    private String comment;
    private int locationId;
    private List<CitiesBean> cities;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public List<CitiesBean> getCities() {
        return cities;
    }

    public void setCities(List<CitiesBean> cities) {
        this.cities = cities;
    }

    public static class CitiesBean {
        /**
         * cityName : 武汉
         * currentConfirmedCount : 38020
         * confirmedCount : 44412
         * suspectedCount : 0
         * curedCount : 4895
         * deadCount : 1497
         * locationId : 420100
         */

        private String cityName;
        private int currentConfirmedCount;
        private int confirmedCount;
        private int suspectedCount;
        private int curedCount;
        private int deadCount;
        private int locationId;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
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

        public int getLocationId() {
            return locationId;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }
    }
}
