package me.teenyda.nCoV;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;
import me.teenyda.nCoV.base.mvp.ApplicationManager;
import me.teenyda.nCoV.model.home.base.HomeFrag;
import me.teenyda.nCoV.model.help.HelpFrag;
import me.teenyda.nCoV.model.news.base.NewsFrag;
import me.teenyda.nCoV.model.query.base.QueryFragment;

public class MainActivity extends AppCompatActivity{

    private FragmentManager mFragmentManager;

    private static Fragment currentFragment;

    private HomeFrag mHomeFrag;
    private NewsFrag mNewsFrag;
    private QueryFragment mQueryFragment;
    private HelpFrag mHelpFrag;


    public static View getView() {
        if (currentFragment != null) {
            return currentFragment.getView();
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationManager.addActivity(this);


        mHomeFrag = new HomeFrag();
        mQueryFragment = new QueryFragment();
        mNewsFrag = new NewsFrag();
        mHelpFrag = new HelpFrag();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.main_frame, mHomeFrag).commit();
        currentFragment = mHomeFrag;
//        iv_main_home.setSelected(true);

        PageNavigationView tab = (PageNavigationView) findViewById(R.id.tab);
        NavigationController navigationController = tab.material()
                .addItem(android.R.drawable.ic_menu_camera, "实时动态")
                .addItem(android.R.drawable.ic_menu_compass, "新闻")
                .addItem(android.R.drawable.ic_menu_search, "同程查询")
                .addItem(android.R.drawable.ic_menu_help, "帮助")
                .build();

        navigationController.addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {

                switch (index) {
                    case 0:
                        switchFragment(mHomeFrag);
                        break;
                    case 1:
                        switchFragment(mNewsFrag);
                        break;
                    case 2:
                        switchFragment(mQueryFragment);
                        break;
                    case 3:
                        switchFragment(mHelpFrag);
                        break;

                }
                //switchNavigationImg(index);
            }
        });

    }

    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(getResources().getColor(R.color.c_bfbfbf));
        normalItemView.setTextCheckedColor(getResources().getColor(R.color.c_5866fa));
        return normalItemView;
    }


    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (fragment == currentFragment) {
            return;
        }

        if (!fragment.isAdded()) {
            transaction.add(R.id.main_frame, fragment)
                    .hide(currentFragment)
                    .commit();

        } else {
            transaction.hide(currentFragment)
                    .show(fragment)
                    .commit();
        }

        currentFragment = fragment;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mQueryFragment.onActivityResult(requestCode,resultCode,data);
    }
}
