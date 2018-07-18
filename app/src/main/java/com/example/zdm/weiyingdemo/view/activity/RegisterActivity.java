package com.example.zdm.weiyingdemo.view.activity;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.presenter.RegisterPresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IRegisterView;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterView{


    @Override
    protected RegisterPresenter setPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setChildView() {
        return R.layout.activity_register;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onerror(Object o) {

    }
}
