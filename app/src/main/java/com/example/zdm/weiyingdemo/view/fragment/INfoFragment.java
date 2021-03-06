package com.example.zdm.weiyingdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.presenter.BasePresenter;
import com.example.zdm.weiyingdemo.view.activity.VideodetailsActivity;
import com.example.zdm.weiyingdemo.view.adapter.INfoVideoDetailsAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

public class INfoFragment extends BaseFragment {
    private static final String TAG = "INfoFragment";
    private ExpandableTextView expandableTextView;
    private TextView textautor;
    private RecyclerView infoRecyclerView;
    List<VideoDateilsBean.RetBean.ListBean> listall = new ArrayList<>();

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();//从activity传过来的Bundle
        if (bundle != null) {
            textautor.setText("导演：" + "张东敏");
            Serializable serializable = bundle.getSerializable("===");
            VideoDateilsBean serializable1 = (VideoDateilsBean) serializable;
            String description = serializable1.getRet().getDescription();
            expandableTextView.setText("主演：" + description);
            infoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            final List<VideoDateilsBean.RetBean.ListBean> list = serializable1.getRet().getList();
            listall.addAll(list);
            INfoVideoDetailsAdapter iNfoVideoDetailsAdapter = new INfoVideoDetailsAdapter(listall, getActivity());
            infoRecyclerView.setAdapter(iNfoVideoDetailsAdapter);
            iNfoVideoDetailsAdapter.setOnItemClickListener(new INfoVideoDetailsAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(getActivity(), VideodetailsActivity.class);
                    intent.putExtra("uid", listall.get(0).getChildList().get(position).getDataId());
                    getActivity().startActivity(intent);
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.animator.in_from_right, R.animator.out_to_left);
                }

                @Override
                public void onItemLongClick(View view) {

                }
            });
        } else {
            Log.e(TAG, "initView: 失败" + "张东敏");
        }

    }

    @Override
    protected void initView(View inflate) {
        expandableTextView = inflate.findViewById(R.id.expandtext);
        textautor = inflate.findViewById(R.id.textautor);
        infoRecyclerView = inflate.findViewById(R.id.infoRecyclerView);
    }

    @Override
    protected int setChildView() {
        return R.layout.info_fragment;
    }

}
