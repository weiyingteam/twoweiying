package com.example.zdm.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.VideoListBean;

import java.util.List;

public class SpecialListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<VideoListBean.RetBean.ListBean> list;
    private OnItemClickListener mItemClickListener;
    public SpecialListAdapter(Context context, List<VideoListBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.adapter_speciallist, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.speciallist_imgview.setScaleType(ImageView.ScaleType.FIT_XY);
        myViewHolder.speciallist_textview.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(myViewHolder.speciallist_imgview);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView speciallist_imgview;
        private final TextView speciallist_textview;

        public MyViewHolder(View itemView) {
            super(itemView);

            speciallist_imgview = itemView.findViewById(R.id.speciallist_imgview);
            speciallist_textview = itemView.findViewById(R.id.speciallist_textview);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}

