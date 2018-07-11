package com.example.zdm.weiyingdemo.model.mdata;

import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.http.RetrofitUtis;
import com.example.zdm.weiyingdemo.model.minterfaces.Foundinterface;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class TestData {

    private Observable<AbBean> Found;

    public TestData() {
        Found = RetrofitUtis.getinstance().retrofitAp().found();
    }

    public void getData(final Foundinterface<AbBean> foundinterface ) {

        Found.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<AbBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }


                    @Override
                    public void onNext(AbBean abBean) {
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
