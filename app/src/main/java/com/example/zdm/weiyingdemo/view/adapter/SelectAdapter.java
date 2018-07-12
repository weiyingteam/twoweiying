package com.example.zdm.weiyingdemo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.view.activity.VideodetailsActivity;

import java.util.List;

public class SelectAdapter extends RecyclerView.Adapter {


    private Context context;
    private List<AbBean.RetBean.ListBean.ChildListBean> list;
    private OnItemClickListener mOnItemClickListener;

    public SelectAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<AbBean.RetBean.ListBean.ChildListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jingxuanlayout, null);
        JingCaiViewHolder jingCaiViewHolder = new JingCaiViewHolder(view);
        return jingCaiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        JingCaiViewHolder jingCaiViewHolder= (JingCaiViewHolder) holder;
        jingCaiViewHolder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(jingCaiViewHolder.imageView);

        jingCaiViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,position);
            }
        });
//        jingCaiViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                mOnItemClickListener.onItemLongClick(v);
//                return true;
//            }
//        });
        jingCaiViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideodetailsActivity.class);
                intent.putExtra("uid",list.get(position).getDataId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public class JingCaiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public JingCaiViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.jingcairecy_img);
            textView = itemView.findViewById(R.id.jingcairecy_text);
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view,int position);

        void onItemLongClick(View view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


}
