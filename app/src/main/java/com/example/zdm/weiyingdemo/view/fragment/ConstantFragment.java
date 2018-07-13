package com.example.zdm.weiyingdemo.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.ConstantBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.presenter.BasePresenter;
import com.example.zdm.weiyingdemo.presenter.ConstantPersenter;
import com.example.zdm.weiyingdemo.view.adapter.COnstantAdapter;
import com.example.zdm.weiyingdemo.view.adapter.INfoVideoDetailsAdapter;
import com.example.zdm.weiyingdemo.view.interfaces.IConstanView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConstantFragment extends BaseFragment <ConstantPersenter> implements IConstanView<ConstantBean>{

    List<ConstantBean.RetBean.ListBean> listall=new ArrayList<>();
    private static final String TAG = "ConstantFragment";
    private COnstantAdapter cOnstantAdapter;

    @Override
    protected ConstantPersenter setPresenter() {
        return new ConstantPersenter();
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();//从activity传过来的Bundle
        if(bundle!=null){
            String uid = bundle.getString("---");
            presenter.getDate(uid);
    }
    }

    @Override
    protected void initView(View inflate) {
     RecyclerView constant_RecyclerView = inflate.findViewById(R.id.constant_RecyclerView);
        constant_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        cOnstantAdapter = new COnstantAdapter(listall, getActivity());
        constant_RecyclerView.setAdapter(cOnstantAdapter);
    }

    @Override
    protected int setChildView() {
        return R.layout.constant;
    }

    @Override
    public void onsucess(ConstantBean constantBean) {
        List<ConstantBean.RetBean.ListBean> list = constantBean.getRet().getList();
        listall.addAll(list);
        cOnstantAdapter.notifyDataSetChanged();
    }

    @Override
    public void onerro(ConstantBean constantBean) {

    }
}
