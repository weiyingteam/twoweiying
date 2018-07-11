package com.example.zdm.weiyingdemo.view.fragment;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
    public class FoundFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean> {


    private View inflate;
    private List<String> bannerlist=new ArrayList<>();
    private Banner banner;
    private RecyclerView jingcairecy;
    private SelectAdapter jingxuanAdapter;
    private List<AbBean.RetBean.ListBean.ChildListBean> jingcailist;
    private ScrollView shou_scroll;
    private TextView title;


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


        scrollListenner();
    }


    private void scrollListenner() {


    }

    @Override
    protected void initView(View inflate) {


    }

//    @Override
//    protected void initData() {
//
////        presenter.toM();
//        //scroll滑动监听
//        scrollListenner();
//    }
//
//
//
//    @Override
//    protected void initView(View inflate) {
//
//
////        findId();
//    }
//
//    private void findId() {
//
//    }


    @Override
    protected int setChildView() {
        return R.layout.found_fragment;
    }

//    @Override
//    public void selectioninterv(SelectBean.RetBean v, boolean b) {
//        if(b){
//            //banner
//            childList = v.getList().get(0).getChildList();
//            jingcailist = v.getList().get(2).getChildList();
//            for(int i = 0; i< this.childList.size(); i++){
//                String pic = this.childList.get(i).getPic();
//                if(pic!=null){
//                    bannerlist.add(pic);
//                }
//            }
//            banner.setImageLoader(new ImageBannerLoader());
//            banner.setImages(bannerlist);
//            banner.setDelayTime(2000);
//            banner.start();
//            //banner
//            //精彩推荐
//            if(jingxuanAdapter==null){
//                jingcairecy.setNestedScrollingEnabled(false);
//                jingxuanAdapter = new SelectAdapter(getActivity());
//                jingxuanAdapter.setList(jingcailist);
//                jingcairecy.setLayoutManager(new LinearLayoutManager(getActivity()));
//                jingcairecy.setAdapter(jingxuanAdapter);
//            }
//
//            //精彩推荐
//        }else{
//            Toast.makeText(getActivity(),"请求失败!",Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onsucess(AbBean abBean) {
        Log.e("TAG", "onsucess: "+abBean.getMsg() );
        List<AbBean.RetBean.ListBean> list = abBean.getRet().getList();
        List<AbBean.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();
        for(int i=0;i<childList.size();i++){
            bannerlist.add(childList.get(i).getPic());
        }
        banner.setImageLoader(new ImageBannerLoader());
        banner.setImages(bannerlist);
        banner.setDelayTime(2000);
        banner.start();

        jingxuanAdapter = new SelectAdapter(getActivity());

        jingxuanAdapter.setList(childList);
        jingcairecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        jingcairecy.setAdapter(jingxuanAdapter);



        //banner
            //精彩推荐
          /*  if(jingxuanAdapter==null){
                jingcairecy.setNestedScrollingEnabled(false);
                jingxuanAdapter = new SelectAdapter(getActivity());
                jingxuanAdapter.setList(jingcailist);
                jingcairecy.setLayoutManager(new LinearLayoutManager(getActivity()));
                jingcairecy.setAdapter(jingxuanAdapter);
            }*/

            //精彩推荐
        }


    @Override
    public void onerro(AbBean abBean) {

    }


    class ImageBannerLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
       }
    }

}
