package com.example.zdm.weiyingdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.presenter.BasePresenter;
import com.example.zdm.weiyingdemo.view.activity.LiveActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * author:Created by WeiWeiFeng on 2018/7/14.
 */
public class LiveFragment extends BaseFragment {

    @BindView(R.id.start_live)
    ImageView startLive;
    @BindView(R.id.ijk)
    Button ijk;
    Unbinder unbinder;

    @Override
    protected BasePresenter setPresenter() {
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
        return R.layout.live_fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.start_live, R.id.ijk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_live:
                Intent intent = new Intent(getActivity(), LiveActivity.class);
                startActivity(intent);
                break;
            case R.id.ijk:
//                Intent intent1 = new Intent(getActivity(), IjkActivity.class);
//                startActivity(intent1);
                break;
        }
    }
}
