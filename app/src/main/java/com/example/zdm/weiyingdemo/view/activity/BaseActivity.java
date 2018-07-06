package com.example.zdm.weiyingdemo.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.zdm.weiyingdemo.presenter.BasePresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IBaseView;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setChildView());

        initView();
        initBaseView();
        initData();

        //沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
    }

    private void initBaseView() {
        presenter = setPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        } else {
            try {
                throw new Exception("出错了！！！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract P setPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setChildView();
}
