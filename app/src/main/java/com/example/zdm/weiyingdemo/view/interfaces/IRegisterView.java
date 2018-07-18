package com.example.zdm.weiyingdemo.view.interfaces;

/**
 * author:Created by WeiWeiFeng on 2018/7/18.
 */
public interface IRegisterView<T> extends IBaseView {
    void onSuccess(T t);
    void onerror(T t);
}
