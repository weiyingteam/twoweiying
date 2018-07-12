package com.example.zdm.weiyingdemo.view.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.activity.VideoListActivity;
import com.example.zdm.weiyingdemo.view.adapter.SpecialAdapter;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class SpecialFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean> {
    private String catalogId;
    private RecyclerView rcv;
    private List<AbBean.RetBean.ListBean> list;
    ArrayList<AbBean.RetBean.ListBean> dataList = new ArrayList<AbBean.RetBean.ListBean>();
    private SpecialAdapter specialAdapter;

    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
//设置布局管理器
        rcv.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        //适配器
        specialAdapter = new SpecialAdapter(getActivity(), dataList);
        rcv.setAdapter(specialAdapter);

        specialAdapter.setItemClickListener(new SpecialAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(int position) {
//                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                String moreURL = list.get(position).getMoreURL();
                if (!moreURL.equals("")) {
                    String[] split = moreURL.split("=");
                    for (int i = 0; i < split.length; i++) {
                        String a = split[1];
                        String[] b = a.split("&");
                        for (int j = 0; j < b.length; j++) {
                            catalogId = b[0];
                        }
                    }
//                    Toast.makeText(getContext(), ""+catalogId, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), VideoListActivity.class);
                    intent.putExtra("catalogId",catalogId);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.animator.in_from_right, R.animator.out_to_left);
                } else {
                    Toast.makeText(getActivity(), "亲，暂时还木有数据", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initView(View inflate) {
        rcv = inflate.findViewById(R.id.special_recycler);
    }


    @Override
    protected int setChildView() {
        return R.layout.special_fragment;
    }

    @Override
    public void onsucess(AbBean abBean) {
        list = abBean.getRet().getList();
        dataList.addAll(list);
        specialAdapter.notifyDataSetChanged();
    }

    @Override
    public void onerro(AbBean abBean) {

    }
}
