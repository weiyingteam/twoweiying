package com.example.zdm.weiyingdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zdm.weiyingdemo.presenter.BasePresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IBaseView;

/**
 * author:Created by WeiWeiFeng on 2018/7/10.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView{
    public P presenter;
    private View inflate;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = View.inflate(getActivity(), setChildView(), null);
        initView(inflate);
        initBaseView();
        initData();
        return inflate;

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

    public P getPresenter() {
        return presenter;
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    public View getView(){
        return inflate;
    };

    protected abstract int setChildView();
}


