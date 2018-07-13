package com.example.zdm.weiyingdemo.view.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.presenter.VideoDetailsPersenter;
import com.example.zdm.weiyingdemo.view.adapter.MyPagerAdapter;
import com.example.zdm.weiyingdemo.view.costom.TitleLayout;
import com.example.zdm.weiyingdemo.view.fragment.ConstantFragment;
import com.example.zdm.weiyingdemo.view.fragment.INfoFragment;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoDetailsView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

public class VideodetailsActivity extends BaseActivity<VideoDetailsPersenter> implements IVideoDetailsView<VideoDateilsBean> {
    private static final String TAG = "VideodetailsActivity";
    StandardGSYVideoPlayer videoPlayer;

    OrientationUtils orientationUtils;

    private ViewPager viewpager;
    private TabLayout viewById;
    private INfoFragment iNfoFragment;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> list_title;
    private ImageView imageView;
    private boolean isPlay;
    private boolean isPause;
    private TitleLayout videodetailstitle;
    private GSYVideoOptionBuilder gsyVideoOption;

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
        videodetailstitle = findViewById(R.id.videodetailstitle);
        videoPlayer.startPlayLogic();
        orientationUtils = new OrientationUtils(this, videoPlayer);
//初始化不打开外部的旋转
        orientationUtils.setEnable(false);
        imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //设置返回键
        videoPlayer.getBackButton().setVisibility(View.INVISIBLE);
        //设置旋转
        orientationUtils = new OrientationUtils(this, videoPlayer);
        gsyVideoOption = new GSYVideoOptionBuilder();
        fragmentList = new ArrayList<>();
        list_title = new ArrayList<>();
    }

    @Override
    protected int setChildView() {
        return R.layout.videodetails;
    }

    @Override
    public void onsucess(VideoDateilsBean videoDateilsBean) {
        iNfoFragment = new INfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("===",videoDateilsBean);
        iNfoFragment.setArguments(bundle);
        ConstantFragment constantFragment = new ConstantFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("---",videoDateilsBean.getRet().getDataID());
        constantFragment.setArguments(bundle1);
        fragmentList.add(iNfoFragment);
        fragmentList.add(constantFragment);
        list_title.add("简介");
        list_title.add("评论");
        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),VideodetailsActivity.this,fragmentList,list_title));
        viewById.setupWithViewPager(viewpager);//此方法就是让tablayout和ViewPage
        Glide.with(this).load( videoDateilsBean.getRet().getPic()).into(imageView);
        videodetailstitle.setTitle(videoDateilsBean.getRet().getTitle());
        gsyVideoOption.setThumbImageView(imageView)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setUrl( videoDateilsBean.getRet().getSmoothURL())
                .setCacheWithPlay(false)
                .setVideoAllCallBack(new GSYSampleCallBack() {


                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        orientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[0]);//title
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[1]);//当前非全屏player
                        if (orientationUtils != null) {
                            orientationUtils.backToProtVideo();
                        }
                    }
                }).setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        }).build(videoPlayer);

        videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                videoPlayer.startWindowFullscreen(VideodetailsActivity.this, true, true);
            }
        });

    }

    @Override
    public void onerro(VideoDateilsBean videoDateilsBean) {

    }
@Override
public void onBackPressed() {
    if (orientationUtils != null) {
        orientationUtils.backToProtVideo();
    }
    if (GSYVideoManager.backFromWindowFull(this)) {
        return;
    }
    super.onBackPressed();
}


    @Override
    protected void onPause() {
        videoPlayer.getCurrentPlayer().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        videoPlayer.getCurrentPlayer().onVideoResume(false);
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isPlay) {
            videoPlayer.getCurrentPlayer().release();
        }
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            videoPlayer.onConfigurationChanged(this, newConfig, orientationUtils, true, true);
        }
    }
}

