package com.example.zdm.weiyingdemo.model.mdata;

import com.example.zdm.weiyingdemo.model.bean.ConstantBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.http.RetrofitUtis;
import com.example.zdm.weiyingdemo.model.minterfaces.Constantinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class ConstantData {


    public ConstantData() {

    }

    public void getData(String vid,final Constantinterface<ConstantBean> foundinterface ) {
        Observable<ConstantBean> contant = RetrofitUtis.getinstance().retrofitAp().contant(vid);
        contant.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<ConstantBean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConstantBean abBean) {
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
