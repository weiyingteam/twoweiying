package com.example.zdm.weiyingdemo.model.mdata;

import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.http.RetrofitUtis;
import com.example.zdm.weiyingdemo.model.minterfaces.Foundinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class VideoDetailsData {

    private  Observable<VideoDateilsBean> videoDateils;

    public VideoDetailsData() {

    }

    public void getData(String vid,final VideoDetailsinterface<VideoDateilsBean> foundinterface ) {
        videoDateils = RetrofitUtis.getinstance().retrofitAp().videoDateils(vid);
        videoDateils.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<VideoDateilsBean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoDateilsBean abBean) {
                        foundinterface.onsucess(abBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });}
}
