package me.teenyda.nCoV.model.home.area.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public interface IAreaView extends BaseView {
    void setProvinceData(List<ProvinceDataEntity> provinceList);
}
