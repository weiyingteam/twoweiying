package com.example.zdm.weiyingdemo.view.fragment;

import android.util.Log;
import android.view.View;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class MyFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean> {

    private static final String TAG = "MyFragment";
    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {

    }


    @Override
    protected int setChildView() {
        return R.layout.my_fragment;
    }

    @Override
    public void onsucess(AbBean abBean) {
        Log.e(TAG, "onsucess: "+abBean.getMsg());
    }

    @Override
    public void onerro(AbBean abBean) {

    }
}
