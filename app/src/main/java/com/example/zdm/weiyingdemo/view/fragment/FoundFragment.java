package com.example.zdm.weiyingdemo.view.fragment;


import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.adapter.SelectAdapter;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
    public class FoundFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean>, SwipeRefreshLayout.OnRefreshListener {


    private View inflate;
    private List<String> bannerlist=new ArrayList<>();
    private Banner banner;
    private RecyclerView jingcairecy;
    private SelectAdapter jingxuanAdapter;
    private List<AbBean.RetBean.ListBean.ChildListBean> jingcailist;
    private ScrollView shou_scroll;
    private TextView title;
    private SwipeRefreshLayout swip;
    private RelativeLayout ssjl;


    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        inflate = getView();
        banner = this.inflate.findViewById(R.id.banner);
        jingcairecy = this.inflate.findViewById(R.id.jingcairecy);
        shou_scroll = this.inflate.findViewById(R.id.shou_scroll);
        title = this.inflate.findViewById(R.id.title);
        swip = inflate.findViewById(R.id.swip);
        ssjl = inflate.findViewById(R.id.ssjl);



        swip.setOnRefreshListener(this);


        scrollListenner();
    }


    private void scrollListenner() {


    }

    @Override
    protected void initView(View inflate) {


    }



    @Override
    protected int setChildView() {
        return R.layout.found_fragment;
    }


    @Override
    public void onsucess(AbBean abBean) {
        Log.e("TAG", "onsucess: "+abBean.getMsg() );
        List<AbBean.RetBean.ListBean> list = abBean.getRet().getList();
        List<AbBean.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();
        List<AbBean.RetBean.ListBean.ChildListBean> childList1 = list.get(2).getChildList();
        for(int i=0;i<childList.size();i++){
            bannerlist.add(childList.get(i).getPic());
        }
        banner.setImageLoader(new ImageBannerLoader());
        banner.setImages(bannerlist);
        banner.setDelayTime(2000);
        banner.start();

        jingxuanAdapter = new SelectAdapter(getActivity());
        jingxuanAdapter.setList(childList1);
        jingcairecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        jingcairecy.setAdapter(jingxuanAdapter);

        }



    @Override
    public void onerro(AbBean abBean) {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //停止刷新
                swip.setRefreshing(false);
            }
        }, 1000);
    }


    class ImageBannerLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
       }
    }

}
