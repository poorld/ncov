package me.teenyda.nCoV.model.home.base.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.entity.StatisticsEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

public interface IHomeView extends BaseView {

    void setBook(BookEntity book);


    void setData(StatisticsEntity statistics);

    /**
     *
     * @param provinceList
     * @param total true累计确诊/false现存确诊
     */
    void setProvinceData(List<ProvinceDataEntity> provinceList, boolean total);
}
