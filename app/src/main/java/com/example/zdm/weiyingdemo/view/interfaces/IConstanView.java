package com.example.zdm.weiyingdemo.view.interfaces;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public interface IConstanView<T> extends IBaseView {
    void onsucess(T t);
    void onerro(T t);
}
