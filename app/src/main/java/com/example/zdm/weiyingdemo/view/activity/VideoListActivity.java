package com.example.zdm.weiyingdemo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;
import com.example.zdm.weiyingdemo.presenter.VideoListPresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoListView;

public class VideoListActivity extends BaseActivity<VideoListPresenter> implements IVideoListView<VideoListBean>{
    private static final String TAG = "VideoListActivity";
    @Override
    protected VideoListPresenter setPresenter() {
        return new VideoListPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String catalogId = intent.getStringExtra("catalogId");
        presenter.getDate(catalogId);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setChildView() {
        return R.layout.activity_video_list;
    }


    @Override
    public void onsucess(VideoListBean videoListBean) {
        Log.e(TAG, "onsucess: "+videoListBean.getRet().getList().get(0).getTitle() );
    }

    @Override
    public void onerro(VideoListBean videoListBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
