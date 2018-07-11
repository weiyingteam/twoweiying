package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.mdata.TestData;
import com.example.zdm.weiyingdemo.model.mdata.VideoDetailsData;
import com.example.zdm.weiyingdemo.model.minterfaces.Foundinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoDetailsView;

public class VideoDetailsPersenter extends BasePresenter<IVideoDetailsView<VideoDateilsBean>> {

    private final VideoDetailsData videoDetailsData;

    public VideoDetailsPersenter() {
        videoDetailsData = new VideoDetailsData();
    }

    public void  getDate(String uid) {
        videoDetailsData.getData(uid,new VideoDetailsinterface<VideoDateilsBean>() {
            @Override
            public void onsucess(VideoDateilsBean abBean) {
                getView().onsucess(abBean);
            }

            @Override
            public void erro() {

            }
        });

    }
}
