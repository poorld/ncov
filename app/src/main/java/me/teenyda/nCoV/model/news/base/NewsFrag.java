package me.teenyda.nCoV.model.news.base;

import android.content.Context;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.base.adapter.TabFragmentPagerAdapter;
import me.teenyda.nCoV.model.news.base.model.INewsModel;
import me.teenyda.nCoV.model.news.base.presenter.NewsPresenter;
import me.teenyda.nCoV.model.news.base.view.INewsView;
import me.teenyda.nCoV.model.news.broadcast.BroadcastFrag;
import me.teenyda.nCoV.model.news.knowledge.KnowledgeFrag;
import me.teenyda.nCoV.model.news.protect.ProtectFrag;

public class NewsFrag extends MvpFragment<INewsView, INewsModel, NewsPresenter> implements INewsView {

    private ArrayList<Fragment> mFragmentList;

    private ViewPager mViewPager;

    private TabFragmentPagerAdapter mAdapter;

    private SlidingTabLayout mTabLayout;

    private final String[] title = {"辟谣与防护","实时播报","疾病知识"};


    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_news;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {

        mViewPager = (ViewPager) $(R.id.news_vp);
        mTabLayout = (SlidingTabLayout) $(R.id.news_stl);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(ProtectFrag.getInstance());
        mFragmentList.add(BroadcastFrag.getInstance());
        mFragmentList.add(KnowledgeFrag.getInstance());

        mAdapter = new TabFragmentPagerAdapter(getChildFragmentManager(), mFragmentList);
        mTabLayout.setViewPager(mViewPager,title,getActivity(), mFragmentList);
    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
