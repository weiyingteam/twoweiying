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
    @POST("front/Commentary/getCommentList.do")
    @FormUrlEncoded
    Observable<ConstantBean> contant(@Field("mediaId") String mediaId);
}
