package com.example.zdm.weiyingdemo.view.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.bean.CardDataItem;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.activity.VideodetailsActivity;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;
import com.stone.card.library.CardAdapter;
import com.stone.card.library.CardSlidePanel;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class FancyFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean> {
    private static final String TAG = "FancyFragment";
    private CardSlidePanel slidePanel;
    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    private ArrayList<CardDataItem> dataList = new ArrayList<CardDataItem>();
    private Button huan;
    private List<AbBean.RetBean.ListBean> list;
    int d = 0;
    private List<AbBean.RetBean.ListBean.ChildListBean> childList;

    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        slidePanel = inflate.findViewById(R.id.image_slide_panel);
        huan = inflate.findViewById(R.id.huan);

        // 1. 左右滑动监听
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
                Log.d("Card", "正在显示-" + dataList.get(index).getTitle());
            }

            @Override
            public void onCardVanish(int index, int type) {
                Log.d("Card", "正在消失-" + dataList.get(index).getTitle() + " 消失type=" + type);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);


        // 2. 绑定Adapter
        slidePanel.setAdapter(new CardAdapter() {
            @Override
            public int getLayoutId() {
                return R.layout.card_item;
            }

            @Override
            public int getCount() {
                return dataList.size();
            }

            @Override
            public void bindView(View view, final int index) {
                Object tag = view.getTag();
                ViewHolder viewHolder;
                if (null != tag) {
                    viewHolder = (ViewHolder) tag;
                } else {
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                }
                viewHolder.maskView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Log.e(TAG, "onClick: "+dataList.get(index).getMediaId() );
                        Intent intent = new Intent(getActivity(), VideodetailsActivity.class);
                        intent.putExtra("uid",dataList.get(index).getMediaId());
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.animator.in_from_right, R.animator.out_to_left);
                    }
                });
                viewHolder.bindData(dataList.get(index));
            }

            @Override
            public Object getItem(int index) {
                return dataList.get(index);
            }

            @Override
            public Rect obtainDraggableArea(View view) {
                // 可滑动区域定制，该函数只会调用一次
                View contentView = view.findViewById(R.id.card_item_content);
                View topLayout = view.findViewById(R.id.card_top_layout);
                View bottomLayout = view.findViewById(R.id.card_bottom_layout);
                int left = view.getLeft() + contentView.getPaddingLeft() + topLayout.getPaddingLeft();
                int right = view.getRight() - contentView.getPaddingRight() - topLayout.getPaddingRight();
                int top = view.getTop() + contentView.getPaddingTop() + topLayout.getPaddingTop();
                int bottom = view.getBottom() - contentView.getPaddingBottom() - bottomLayout.getPaddingBottom();
                return new Rect(left, top, right, bottom);
            }
        });


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                prepareDataList();
                slidePanel.getAdapter().notifyDataSetChanged();
            }
        }, 200);

//         3. notifyDataSetChanged调用
        huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                appendDataList(d);
                if (d == list.size() - 1) {
                    d = 0;
                } else {
                    d++;
                }

                slidePanel.getAdapter().notifyDataSetChanged();
            }
        });


    }


    @Override
    protected int setChildView() {
        return R.layout.fancy_fragment;
    }

    @Override
    public void onsucess(AbBean abBean) {
        list = abBean.getRet().getList();
        childList = abBean.getRet().getList().get(2).getChildList();
        addData(childList);
    }

    private void addData(List<AbBean.RetBean.ListBean.ChildListBean> childList) {
        if (dataList.size() == 0) {
            for (int i = 0; i < childList.size(); i++) {
                String pic = childList.get(i).getPic();
                String title = childList.get(i).getTitle();
                String dataId = childList.get(i).getDataId();
                String description = childList.get(i).getDescription();

                CardDataItem cardDataItem = new CardDataItem(pic, title, dataId, description);
                dataList.add(cardDataItem);
            }

        }
    }

    @Override
    public void onerro(AbBean abBean) {

    }


    private void prepareDataList() {
    }

    private void appendDataList(int d) {

        dataList.clear();
        childList = list.get(d).getChildList();
        addData(childList);
    }

    class ViewHolder {

        ImageView imageView;
        View maskView;
        TextView userNameTv;
        TextView imageNumTv;
        TextView description;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.card_image_view);
            maskView = view.findViewById(R.id.maskView);
            userNameTv = (TextView) view.findViewById(R.id.card_user_name);
            imageNumTv = (TextView) view.findViewById(R.id.card_pic_num);
            description = (TextView) view.findViewById(R.id.card_other_description);
        }

        public void bindData(CardDataItem itemData) {

            Glide.with(getContext()).load(itemData.getPic()).into(imageView);
            userNameTv.setText(itemData.getTitle());
            description.setText("" + itemData.getDescription());
//            likeNumTv.setText(itemData.likeNum + "");


        }
    }
}
