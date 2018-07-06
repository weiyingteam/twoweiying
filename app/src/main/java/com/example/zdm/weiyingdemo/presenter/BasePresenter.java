package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.view.interfaces.IBaseView;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class BasePresenter<V extends IBaseView> {
    private V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
