package com.example.zdm.weiyingdemo.model.mdata;

import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;
import com.example.zdm.weiyingdemo.model.http.RetrofitUtis;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoListinterface;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoListData {
    private Observable<VideoListBean> videolist;


    public void getData(String vid,final VideoListinterface<VideoListBean> videoListinterface ) {
        videolist = RetrofitUtis.getinstance().retrofitAp().getVideoList(vid,null);
        videolist.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<VideoListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        videoListinterface.onsucess(videoListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });}
}
