package com.example.zdm.weiyingdemo.model.http;

import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.bean.SelectBean;
import com.example.zdm.weiyingdemo.presenter.SelecteinterfacesP;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelecTionModle {
    private SelecteinterfacesP selecTionInterP;

    public SelecTionModle(SelecteinterfacesP selecTionInterP) {
        this.selecTionInterP = selecTionInterP;
    }

    public void backP(){
        Observable<SelectBean> shouye =  RetrofitUtis.getinstance().retrofitAp().found();/*.getInstance().getApi().shouye();*/
        shouye.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SelectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SelectBean value) {
                        if(value.getCode().equals("200")){
                            selecTionInterP.selectioninterp(value.getRet());
                        }else{
                            selecTionInterP.errow(value.getRet());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });

    }
}
