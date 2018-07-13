package com.example.zdm.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;


import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<AbBean.RetBean.ListBean> list;
    private OnItemClickListener mItemClickListener;

    public SpecialAdapter(Context context, List<AbBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.adapter_special, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.special_imgview.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams params = myViewHolder.special_imgview.getLayoutParams();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels / 2;//宽度为屏幕宽度一半
        //int height = data.getHeight()*width/data.getWidth();//计算View的高度

        params.height = (int) (width / 1.8);
        myViewHolder.special_imgview.setLayoutParams(params);

        if (!list.get(position).getChildList().get(0).getPic().equals("")&&!list.get(position).getTitle().equals("")){
            Glide.with(context).load(list.get(position).getChildList().get(0).getPic()).into(myViewHolder.special_imgview);
            myViewHolder.special_textview.setText(list.get(position).getTitle());
        }else {
            myViewHolder.itemView.setVisibility(View.GONE);
        }

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (list.size()==0){
            return 0;
        }
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView special_textview;
        private final ImageView special_imgview;

        public MyViewHolder(View itemView) {
            super(itemView);

            special_textview = itemView.findViewById(R.id.special_textview);
            special_imgview = itemView.findViewById(R.id.special_imgview);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
