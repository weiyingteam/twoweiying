package com.example.zdm.weiyingdemo.view.costom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zdm.weiyingdemo.R;

import static com.example.zdm.weiyingdemo.R.color.style_color;

public class TitleLayout extends LinearLayout {

    private TextView tv_title;
    private LinearLayout titleLayout;

    public TitleLayout(Context context) {
        super(context, null);
    }

    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);

        //引入布局
        View inflate = LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        ImageView btnBack = (ImageView) inflate.findViewById(R.id.btnBack);
        ImageView btnEdit = (ImageView) inflate.findViewById(R.id.btnEdit);
        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
                ((Activity) getContext()).overridePendingTransition(R.animator.finish_in, R.animator.finish_to);
            }
        });

        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "编辑", Toast.LENGTH_SHORT).show();
            }
        });

        tv_title = (TextView) findViewById(R.id.tv_title);
        titleLayout = (LinearLayout) findViewById(R.id.title_layout);

    }

    //显示活的的标题
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
    }
    //显示活的的标题颜色
    public void setTitleColor(int color) {
        titleLayout.setBackgroundColor(color);
    }
}
