package me.teenyda.nCoV.model.query.base.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.response.NcovSameEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

public interface IQueryView extends BaseView {

    void setncovSameData(List<NcovSameEntity> ncovSames);

}
