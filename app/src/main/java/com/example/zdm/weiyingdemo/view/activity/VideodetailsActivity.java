package com.example.zdm.weiyingdemo.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.presenter.VideoDetailsPersenter;
import com.example.zdm.weiyingdemo.view.adapter.MyPagerAdapter;
import com.example.zdm.weiyingdemo.view.fragment.ConstantFragment;
import com.example.zdm.weiyingdemo.view.fragment.INfoFragment;
import com.example.zdm.weiyingdemo.view.fragment.MyFragment;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoDetailsView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.ArrayList;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

public class VideodetailsActivity extends BaseActivity<VideoDetailsPersenter> implements IVideoDetailsView<VideoDateilsBean> {
    private static final String TAG = "VideodetailsActivity";
    StandardGSYVideoPlayer videoPlayer;

    OrientationUtils orientationUtils;

    private ViewPager viewpager;
    private TabLayout viewById;
    private INfoFragment iNfoFragment;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> list_title;

    @Override
    protected VideoDetailsPersenter setPresenter() {
        return new VideoDetailsPersenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        if (uid!=null){
            presenter.getDate(uid);
        }

    }

    @Override
    protected void initView() {
        videoPlayer =  (StandardGSYVideoPlayer)findViewById(R.id.video_player);
        viewById = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.erweima);
        videoPlayer.setThumbImageView(imageView);
        //增加title
        videoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        //设置返回键
        videoPlayer.getBackButton().setVisibility(View.VISIBLE);
        //设置旋转
        orientationUtils = new OrientationUtils(this, videoPlayer);
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
            }
        });
        //是否可以滑动调整
        videoPlayer.setIsTouchWiget(true);
        //设置返回按键功能
        videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        videoPlayer.startPlayLogic();
        fragmentList = new ArrayList<>();
        list_title = new ArrayList<>();
    }

    @Override
    protected int setChildView() {
        return R.layout.videodetails;
    }

    @Override
    public void onsucess(VideoDateilsBean videoDateilsBean) {
        videoPlayer.setUp( videoDateilsBean.getRet().getSmoothURL(), true, videoDateilsBean.getRet().getTitle());
        iNfoFragment = new INfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("===",videoDateilsBean);
        iNfoFragment.setArguments(bundle);
        fragmentList.add(iNfoFragment);
        fragmentList.add(new ConstantFragment());
        list_title.add("简介");
        list_title.add("评论");
        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),VideodetailsActivity.this,fragmentList,list_title));
        viewById.setupWithViewPager(viewpager);//此方法就是让tablayout和ViewPage


    }

    @Override
    public void onerro(VideoDateilsBean videoDateilsBean) {

    }
    @Override
    protected void onPause() {
        super.onPause();
        videoPlayer.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoPlayer.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            videoPlayer.getFullscreenButton().performClick();
            return;
        }
        //释放所有
        videoPlayer.setVideoAllCallBack(null);
        super.onBackPressed();
    }
}

