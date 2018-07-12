package com.example.zdm.weiyingdemo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.view.activity.VideodetailsActivity;

import java.util.List;

public class INfoVideoDetailsAdapter extends Adapter{
    List<VideoDateilsBean.RetBean.ListBean> list;
    Context context;

    public INfoVideoDetailsAdapter(List<VideoDateilsBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.info_details, null);
        ViewHoder viewHoder = new ViewHoder(inflate);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHoder holder1 = (ViewHoder) holder;
            Glide.with(context).load(list.get(0).getChildList().get(position).getPic()).into(holder1.info_img);
            holder1.info_title.setText(list.get(0).getChildList().get(position).getTitle());
        holder1.info_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideodetailsActivity.class);
                intent.putExtra("uid",list.get(0).getChildList().get(position).getDataId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.get(0).getChildList().size();
    }
    class  ViewHoder extends RecyclerView.ViewHolder{

        private final ImageView info_img;
        private final TextView info_title;

        public ViewHoder(View itemView) {
            super(itemView);
            info_img = itemView.findViewById(R.id.info_img);
            info_title = itemView.findViewById(R.id.info_title);
        }
    }
}
