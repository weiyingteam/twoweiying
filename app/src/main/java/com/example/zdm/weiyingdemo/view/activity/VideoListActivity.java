package com.example.zdm.weiyingdemo.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;
import com.example.zdm.weiyingdemo.presenter.VideoListPresenter;
import com.example.zdm.weiyingdemo.view.adapter.SpecialListAdapter;
import com.example.zdm.weiyingdemo.view.costom.TitleLayout;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoListView;

import java.util.List;

public class VideoListActivity extends BaseActivity<VideoListPresenter> implements IVideoListView<VideoListBean>{
    private static final String TAG = "VideoListActivity";
    private RecyclerView videolist_recycler;
    private TitleLayout title;

    @Override
    protected VideoListPresenter setPresenter() {
        return new VideoListPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String catalogId = intent.getStringExtra("catalogId");
        String title2 = intent.getStringExtra("title");
        title.setTitle(title2);
        title.setTitleColor(Color.BLUE);
        presenter.getDate(catalogId);
    }

    @Override
    protected void initView() {
        title = (TitleLayout) findViewById(R.id.title_videolist);
        videolist_recycler = findViewById(R.id.videolist_recycler);
        videolist_recycler.setLayoutManager(new GridLayoutManager(VideoListActivity.this,3, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected int setChildView() {
        return R.layout.activity_video_list;
    }


    @Override
    public void onsucess(VideoListBean videoListBean) {
//        Log.e(TAG, "onsucess: "+videoListBean.getRet().getList().get(0).getTitle() );
        final List<VideoListBean.RetBean.ListBean> list = videoListBean.getRet().getList();
        SpecialListAdapter videoListAdapter = new SpecialListAdapter(this, list);
        videolist_recycler.setAdapter(videoListAdapter);
        videoListAdapter.setItemClickListener(new SpecialListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String dataId = list.get(position).getDataId();
                Intent intent = new Intent(VideoListActivity.this, VideodetailsActivity.class);
                intent.putExtra("uid", dataId);
                startActivity(intent);
                overridePendingTransition(R.animator.in_from_right, R.animator.out_to_left);
            }
        });
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
