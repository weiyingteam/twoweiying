package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;
import com.example.zdm.weiyingdemo.model.mdata.VideoDetailsData;
import com.example.zdm.weiyingdemo.model.mdata.VideoListData;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoListinterface;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoListView;

public class VideoListPresenter extends BasePresenter<IVideoListView<VideoListBean>> {
    private final VideoListData videoListData;

    public VideoListPresenter() {
        videoListData = new VideoListData();
    }

    public void  getDate(String uid) {
        videoListData.getData(uid, new VideoListinterface<VideoListBean>() {
            @Override
            public void onsucess(VideoListBean videoListBean) {
                getView().onsucess(videoListBean);
            }

            @Override
            public void erro() {

            }
        });

    }
}
