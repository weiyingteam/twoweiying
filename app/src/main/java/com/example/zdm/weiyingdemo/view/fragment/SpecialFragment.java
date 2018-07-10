package com.example.zdm.weiyingdemo.view.fragment;

import android.view.View;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class SpecialFragment extends BaseFragment<MainPresenter> {

    @Override
    protected MainPresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {

    }


    @Override
    protected int setChildView() {
        return R.layout.special_fragment;
    }
}
