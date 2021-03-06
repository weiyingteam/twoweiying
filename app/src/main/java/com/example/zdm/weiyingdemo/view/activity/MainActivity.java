package com.example.zdm.weiyingdemo.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.fragment.FancyFragment;
import com.example.zdm.weiyingdemo.view.fragment.FoundFragment;
import com.example.zdm.weiyingdemo.view.fragment.LiveFragment;
import com.example.zdm.weiyingdemo.view.fragment.MyFragment;
import com.example.zdm.weiyingdemo.view.fragment.SpecialFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity<MainPresenter> {
    private BottomTabBar mBottomTabBar;
    private TextView title,main_fenxiang;
    private static final String TAG = "MainActivity";

    @Override
    protected MainPresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        title = (TextView) findViewById(R.id.title_main);
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
         main_fenxiang = findViewById(R.id.main_fenxiang);
        main_fenxiang. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "发现一个看片神奇" + "\n"  + "\n" + "https://github.com/weiyingteam/twoweiying");
                sendIntent.setType("text/plain");
//                sendIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");//QQ好友或QQ群
                startActivityForResult(sendIntent, 200);
            }

        });
        mBottomTabBar
                .init(getSupportFragmentManager())//初始化方法，必须第一个调用；传入参数为V4包下的FragmentManager
                .setImgSize(25, 25)//设置ICON图片的尺寸
                .setFontSize(8)//设置文字的尺寸
                .setTabPadding(2, 4, 7)//设置ICON图片与上部分割线的间隔、图片与文字的间隔、文字与底部的间隔
                .setChangeColor(Color.RED, Color.DKGRAY)//设置选中的颜色、未选中的颜色
                .addTabItem("精选", R.mipmap.found_select, R.mipmap.found, FoundFragment.class)//设置文字、一张图片、fragment
                .addTabItem("专题", R.mipmap.special_select, R.mipmap.special, SpecialFragment.class)//设置文字、一张图片、fragment
                .addTabItem("直播", R.mipmap.special_select, R.mipmap.special, LiveFragment.class)//设置文字、一张图片、fragment
                .addTabItem("发现", R.mipmap.fancy_select, R.mipmap.fancy, FancyFragment.class)//设置文字、一张图片、fragment
                .addTabItem("我的", R.mipmap.my_select, R.mipmap.my, MyFragment.class)//设置文字、两张图片、fragment
                .isShowDivider(false)//设置是否显示分割线
//                .setTabBarBackgroundColor(Color.WHITE)//设置底部导航栏颜色
                .setTabBarBackgroundResource(R.mipmap.bottom_bg)//设置底部导航栏的背景图片【与设置底部导航栏颜色方法不能同时使用，否则会覆盖掉前边设置的颜色】
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    //添加选项卡切换监听
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        //这里不用说，你们也都看的懂了
                        //暂时就返回了这俩参数，如果还有什么用的比较多的参数，欢迎留言告诉我，我继续添加上
//                        Log.i("TGA", "位置：" + position + "      选项卡的文字内容：" + name);
                        title.setText(name);
                    }

                })
                .setCurrentTab(0);//设置当前选中的Tab，从0开始

    }

    @Override
    protected int setChildView() {
        return R.layout.activity_main;
    }

}
