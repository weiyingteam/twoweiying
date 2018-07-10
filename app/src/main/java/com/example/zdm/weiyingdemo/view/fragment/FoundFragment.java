package com.example.zdm.weiyingdemo.view.fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.SelectBean;
import com.example.zdm.weiyingdemo.presenter.SelectePresenter;
import com.example.zdm.weiyingdemo.view.interfaces.SelecteinterfacesV;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class FoundFragment extends Fragment implements SelecteinterfacesV {
    private View view;
    private SelectePresenter presenter;
    private List<SelectBean.RetBean.ListBean.ChildListBean> childList;
    private List<String> bannerlist=new ArrayList<>();
    private Banner banner;
    private RecyclerView jingcairecy;
    private List<SelectBean.RetBean.ListBean.ChildListBean> jingcailist;
   /* private SelectedAdapter jingCaiAdapter;*/
    private ScrollView shou_scroll;
    private TextView title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = View.inflate(getContext(), R.layout.found_fragment, null);

        banner = view.findViewById(R.id.banner);
        jingcairecy = view.findViewById(R.id.jingcairecy);
        shou_scroll = view.findViewById(R.id.shou_scroll);
        title = view.findViewById(R.id.title);

        presenter.toM();
        //scroll滑动监听
        scrollListenner();


        return view;
    }
    @TargetApi(Build.VERSION_CODES.M)
    private void scrollListenner() {
        shou_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
    }

    @Override
    public SelectePresenter selectioninterv(SelectBean.RetBean v, boolean b) {
        return new SelectePresenter(this);

    }
}
