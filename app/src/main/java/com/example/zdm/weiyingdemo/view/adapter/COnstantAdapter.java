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
import com.example.zdm.weiyingdemo.model.bean.ConstantBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.view.activity.VideodetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class COnstantAdapter extends Adapter{
    List<ConstantBean.RetBean.ListBean> list;
    Context context;

    public COnstantAdapter( List<ConstantBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.contant_fragment, null);
        ViewHoder viewHoder = new ViewHoder(inflate);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHoder holder1 = (ViewHoder) holder;
        holder1.constant_icon.setImageURI(list.get(position).getUserPic());
        holder1.constant_name.setText(list.get(position).getPhoneNumber());
        holder1.constant_time.setText(list.get(position).getTime());
        holder1.conatant_cons.setText(list.get(position).getMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  ViewHoder extends RecyclerView.ViewHolder{

        private SimpleDraweeView constant_icon;
        private TextView constant_name,constant_time,conatant_cons;

        public ViewHoder(View itemView) {
            super(itemView);
            constant_icon = itemView.findViewById(R.id.constant_icon);
            constant_name = itemView.findViewById(R.id.constant_name);
            constant_time = itemView.findViewById(R.id.constant_time);
            conatant_cons = itemView.findViewById(R.id.conatant_cons);
        }
    }
}
