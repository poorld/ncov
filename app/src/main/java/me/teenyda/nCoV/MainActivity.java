package me.teenyda.nCoV;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;
import me.teenyda.nCoV.base.mvp.ApplicationManager;
import me.teenyda.nCoV.model.home.base.HomeFrag;
import me.teenyda.nCoV.model.query.QueryFragment;
import me.teenyda.nCoV.model.help.HelpFrag;
import me.teenyda.nCoV.model.news.base.NewsFrag;

public class MainActivity extends AppCompatActivity{


    private RelativeLayout main_home;
    private RelativeLayout main_manager;
    private RelativeLayout main_message;
    private RelativeLayout main_my;

    private FragmentManager mFragmentManager;

    private Fragment currentFragment;

    private HomeFrag mHomeFrag;
    private NewsFrag mNewsFrag;
    private QueryFragment mQueryFragment;
    private HelpFrag mHelpFrag;

    private ImageView iv_main_home;
    private ImageView iv_main_manager;
    private ImageView iv_main_message;
    private ImageView iv_main_my;

    private TextView tv_main_home;
    private TextView tv_main_manager;
    private TextView tv_main_message;
    private TextView tv_main_my;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationManager.addActivity(this);



       /* main_home = findViewById(R.id.main_home);
        main_manager = findViewById(R.id.main_manager);
        main_message = findViewById(R.id.main_message);
        main_my = findViewById(R.id.main_my);


        iv_main_home = findViewById(R.id.iv_main_home);
        iv_main_manager = findViewById(R.id.iv_main_manager);
        iv_main_message = findViewById(R.id.iv_main_message);
        iv_main_my = findViewById(R.id.iv_main_department);

        tv_main_home = findViewById(R.id.tv_main_home);
        tv_main_manager = findViewById(R.id.tv_main_manager);
        tv_main_message = findViewById(R.id.tv_main_message);
        tv_main_my = findViewById(R.id.tv_main_my);*/


//        main_home.setOnClickListener(this);
//        main_manager.setOnClickListener(this);
//        main_message.setOnClickListener(this);
//        main_my.setOnClickListener(this);

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

    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_home:
                switchFragment(mHomeFrag);
                switchNavigationImg(0);
                break;
            case R.id.main_manager:
                switchFragment(mNewsFrag);
                switchNavigationImg(1);
                break;
            case R.id.main_message:
                switchFragment(mQueryFragment);
                switchNavigationImg(2);
                break;
            case R.id.main_my:
                switchFragment(mHelpFrag);
                switchNavigationImg(3);
                break;
        }
    }*/

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


    private void switchNavigationImg(int index) {
        tv_main_home.setTextColor(getResources().getColor(R.color.c_bfbfbf));
        tv_main_manager.setTextColor(getResources().getColor(R.color.c_bfbfbf));
        tv_main_message.setTextColor(getResources().getColor(R.color.c_bfbfbf));
        tv_main_my.setTextColor(getResources().getColor(R.color.c_bfbfbf));
        switch (index) {
            case 0:
                iv_main_home.setSelected(true);
                iv_main_manager.setSelected(false);
                iv_main_message.setSelected(false);
                iv_main_my.setSelected(false);

                tv_main_home.setTextColor(getResources().getColor(R.color.c_ffffff));

                break;
            case 1:
                iv_main_home.setSelected(false);
                iv_main_manager.setSelected(true);
                iv_main_message.setSelected(false);
                iv_main_my.setSelected(false);

                tv_main_manager.setTextColor(getResources().getColor(R.color.c_ffffff));

                break;
            case 2:
                iv_main_home.setSelected(false);
                iv_main_manager.setSelected(false);
                iv_main_message.setSelected(true);
                iv_main_my.setSelected(false);

                tv_main_message.setTextColor(getResources().getColor(R.color.c_ffffff));

                break;
            case 3:
                iv_main_home.setSelected(false);
                iv_main_manager.setSelected(false);
                iv_main_message.setSelected(false);
                iv_main_my.setSelected(true);

                tv_main_my.setTextColor(getResources().getColor(R.color.c_ffffff));
                break;
        }
    }
}
