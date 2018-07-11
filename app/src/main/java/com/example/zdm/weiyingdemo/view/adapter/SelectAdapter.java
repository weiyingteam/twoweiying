package com.example.zdm.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;

import java.util.List;

public class  SelectAdapter extends RecyclerView.Adapter{


    private Context context;
    private List<AbBean.RetBean.ListBean.ChildListBean> list;

    public SelectAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<AbBean.RetBean.ListBean.ChildListBean> list){
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.jingxuanlayout,null);
        JingCaiViewHolder jingCaiViewHolder = new JingCaiViewHolder(view);
        return jingCaiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JingCaiViewHolder jingCaiViewHolder= (JingCaiViewHolder) holder;
        jingCaiViewHolder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(jingCaiViewHolder.imageView);
        Log.e("TAG","mussessage"+jingCaiViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            Log.e("TAG","mussessage"+list.size());

            return list.size();
        }else{
            return 0;
        }
    }

    public class JingCaiViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public JingCaiViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.jingcairecy_img);
            textView=itemView.findViewById(R.id.jingcairecy_text);
        }
    }
}
