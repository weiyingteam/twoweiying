package com.example.zdm.weiyingdemo.model.http;

import android.util.Log;

import com.example.zdm.weiyingdemo.app.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class RetrofitUtis {
    private static RetrofitUtis retrofitUtis;
    private final RetrofitApi retrofitApi;

    private RetrofitUtis() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("TAG", "" + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        retrofitApi = retrofit.create(RetrofitApi.class);

    }

    public static RetrofitUtis getinstance() {
        if (retrofitUtis == null) {
            retrofitUtis = new RetrofitUtis();
        }
        return retrofitUtis;
    }


    public RetrofitApi retrofitAp(){
       return retrofitApi;
}
}