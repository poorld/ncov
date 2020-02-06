package me.teenyda.nCoV.base.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * author: teenyda
 * date: 2020/2/5
 * description:
 */
public class BannerEntity {

    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public BannerEntity(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public BannerEntity(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }



    public static List<BannerEntity> getTestData3() {
        List<BannerEntity> list = new ArrayList<>();
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/300/3394878936923352083-135.png", null, 1));
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/253/3394879100132420050-135.png", null, 1));
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/312/3394879301995899763-135.png", null, 1));
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/356/3394879357830479001-135.png", null, 1));
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/122/3394879495269001393-135.png", null, 1));
        list.add(new BannerEntity("https://img1.dxycdn.com/2020/0205/210/3394879553251507095-135.png", null, 1));
        return list;
    }
}
