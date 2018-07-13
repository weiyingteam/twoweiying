package com.example.zdm.weiyingdemo.model.http;

import com.example.zdm.weiyingdemo.app.Constant;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.bean.ConstantBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public interface RetrofitApi {
    @GET("front/homePageApi/homePage.do")
    Observable<AbBean> found();

    @POST("front/videoDetailApi/videoDetail.do")
    @FormUrlEncoded
    Observable<VideoDateilsBean> videoDateils(@Field("mediaId") String mediaId);

    @POST("front/columns/getVideoList.do")
    @FormUrlEncoded
    Observable<VideoListBean> getVideoList(@Field("catalogId") String catalogId, @Field("information") String information);
//http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e53843000b&information=null
//    1.首页接口
    //http://api.svipmovie.com/front/homePageApi/homePage.do


//    2. 频道列表
//    接口地址：http://api.svipmovie.com/columns/getVideoList.do 


//    3.详情接口
//    接口地址：http://api.svipmovie.com/front/videoDetailApi/videoDetail.do


//    4.获取用户信息
//    接口地址： http://api.svipmovie.com/front/searchKeyWordApi/getVideoListByKeyWord.do 


//            5.评论列表接口
//    接口地址：http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=CMCC_00000000000000001_621653189
}
