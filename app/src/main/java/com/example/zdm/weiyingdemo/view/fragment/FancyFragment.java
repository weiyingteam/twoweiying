package com.example.zdm.weiyingdemo.view.fragment;

import android.view.View;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.presenter.MainPresenter;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;
import com.stone.card.library.CardSlidePanel;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class FancyFragment extends BaseFragment<MainPresenter> implements IfoundView<AbBean> {
    private static final String TAG = "FancyFragment";
    private CardSlidePanel slidePanel;
    private CardSlidePanel.CardSwitchListener cardSwitchListener;

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


        // 1. 左右滑动监听
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
//                Log.d("Card", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
//                Log.d("Card", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);


        // 2. 绑定Adapter
//        slidePanel.setAdapter(new CardAdapter() {
//            @Override
//            public int getLayoutId() {
//                return R.layout.card_item;
//            }
//
//            @Override
//            public int getCount() {
//                return dataList.size();
//            }
//
//            @Override
//            public void bindView(View view, int index) {
//                Object tag = view.getTag();
//                ViewHolder viewHolder;
//                if (null != tag) {
//                    viewHolder = (ViewHolder) tag;
//                } else {
//                    viewHolder = new ViewHolder(view);
//                    view.setTag(viewHolder);
//                }
//
//                viewHolder.bindData(dataList.get(index));
//            }
//
//            @Override
//            public Object getItem(int index) {
//                return dataList.get(index);
//            }
//
//            @Override
//            public Rect obtainDraggableArea(View view) {
//                // 可滑动区域定制，该函数只会调用一次
//                View contentView = view.findViewById(R.id.card_item_content);
//                View topLayout = view.findViewById(R.id.card_top_layout);
//                View bottomLayout = view.findViewById(R.id.card_bottom_layout);
//                int left = view.getLeft() + contentView.getPaddingLeft() + topLayout.getPaddingLeft();
//                int right = view.getRight() - contentView.getPaddingRight() - topLayout.getPaddingRight();
//                int top = view.getTop() + contentView.getPaddingTop() + topLayout.getPaddingTop();
//                int bottom = view.getBottom() - contentView.getPaddingBottom() - bottomLayout.getPaddingBottom();
//                return new Rect(left, top, right, bottom);
//            }
//        });
//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                prepareDataList();
//                slidePanel.getAdapter().notifyDataSetChanged();
//            }
//        }, 500);

        // 3. notifyDataSetChanged调用
//        findViewById(R.id.notify_change).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                appendDataList();
//                slidePanel.getAdapter().notifyDataSetChanged();
//            }
//        });


    }


    @Override
    protected int setChildView() {
        return R.layout.fancy_fragment;
    }

    @Override
    public void onsucess(AbBean abBean) {
//        Log.e(TAG, "onsucess: " + abBean.getMsg());
    }

    @Override
    public void onerro(AbBean abBean) {

    }


//    private String imagePaths[] = {"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/04/25/1493111053637050552.jpg\n",
//            "http://i.imgur.com/idojSYm.png",
//            "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/20/1500545042468021174.jpg",
//            "http://i.imgur.com/idojSYm.png",
//            "http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png",
//            "http://i.imgur.com/idojSYm.png"}; // 12个图片资源
//
//    private String names[] = {"郭富城", "刘德华", "张学友", "李连杰", "成龙", "谢霆锋", "李易峰",
//            "霍建华", "胡歌", "曾志伟", "吴孟达", "梁朝伟"}; // 12个人名
//
//    private List<CardDataItem> dataList = new ArrayList<>();
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View inflate = View.inflate(getContext(), R.layout.fancy_fragment, null);
//        slidePanel = inflate.findViewById(R.id.image_slide_panel);
//        return inflate;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        initView();
//    }
//
//
//    private void initView() {
//        // 1. 左右滑动监听
//        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {
//
//            @Override
//            public void onShow(int index) {
//                Log.d("Card", "正在显示-" + dataList.get(index).userName);
//            }
//
//            @Override
//            public void onCardVanish(int index, int type) {
//                Log.d("Card", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
//            }
//        };
//        slidePanel.setCardSwitchListener(cardSwitchListener);
//
//
//        // 2. 绑定Adapter
//        slidePanel.setAdapter(new CardAdapter() {
//            @Override
//            public int getLayoutId() {
//                return R.layout.card_item;
//            }
//
//            @Override
//            public int getCount() {
//                return dataList.size();
//            }
//
//            @Override
//            public void bindView(View view, int index) {
//                Object tag = view.getTag();
//                ViewHolder viewHolder;
//                if (null != tag) {
//                    viewHolder = (ViewHolder) tag;
//                } else {
//                    viewHolder = new ViewHolder(view);
//                    view.setTag(viewHolder);
//                }
//
//                viewHolder.bindData(dataList.get(index));
//            }
//
//            @Override
//            public Object getItem(int index) {
//                return dataList.get(index);
//            }
//
//            @Override
//            public Rect obtainDraggableArea(View view) {
//                // 可滑动区域定制，该函数只会调用一次
//                View contentView = view.findViewById(R.id.card_item_content);
//                View topLayout = view.findViewById(R.id.card_top_layout);
//                View bottomLayout = view.findViewById(R.id.card_bottom_layout);
//                int left = view.getLeft() + contentView.getPaddingLeft() + topLayout.getPaddingLeft();
//                int right = view.getRight() - contentView.getPaddingRight() - topLayout.getPaddingRight();
//                int top = view.getTop() + contentView.getPaddingTop() + topLayout.getPaddingTop();
//                int bottom = view.getBottom() - contentView.getPaddingBottom() - bottomLayout.getPaddingBottom();
//                return new Rect(left, top, right, bottom);
//            }
//        });
//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                prepareDataList();
//                slidePanel.getAdapter().notifyDataSetChanged();
//            }
//        }, 500);
//
//        // 3. notifyDataSetChanged调用
////        findViewById(R.id.notify_change).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                appendDataList();
////                slidePanel.getAdapter().notifyDataSetChanged();
////            }
////        });
//    }

//    private void prepareDataList() {
//        for (int i = 0; i < 6; i++) {
//            CardDataItem dataItem = new CardDataItem();
//            dataItem.userName = names[i];
//            dataItem.imagePath = imagePaths[i];
//            dataItem.likeNum = (int) (Math.random() * 10);
//            dataItem.imageNum = (int) (Math.random() * 6);
//            dataList.add(dataItem);
//        }
//    }
//
//    private void appendDataList() {
//        for (int i = 0; i < 6; i++) {
//            CardDataItem dataItem = new CardDataItem();
//            dataItem.userName = "From Append";
//            dataItem.imagePath = imagePaths[8];
//            dataItem.likeNum = (int) (Math.random() * 10);
//            dataItem.imageNum = (int) (Math.random() * 6);
//            dataList.add(dataItem);
//        }
//    }
//
//    class ViewHolder {
//
//        ImageView imageView;
//        View maskView;
//        TextView userNameTv;
//        TextView imageNumTv;
//        TextView likeNumTv;
//
//        public ViewHolder(View view) {
//            imageView = (ImageView) view.findViewById(R.id.card_image_view);
//            maskView = view.findViewById(R.id.maskView);
//            userNameTv = (TextView) view.findViewById(R.id.card_user_name);
//            imageNumTv = (TextView) view.findViewById(R.id.card_pic_num);
//            likeNumTv = (TextView) view.findViewById(R.id.card_like);
//        }
//
//        public void bindData(CardDataItem itemData) {
////            Glide.with(getContext()).load("http://i.imgur.com/idojSYm.png").into(imageView);
//            Glide.with(getContext()).load(itemData.imagePath).into(imageView);
//            userNameTv.setText(itemData.userName);
//            imageNumTv.setText(itemData.imageNum + "");
//            likeNumTv.setText(itemData.likeNum + "");
//        }
//    }
}
