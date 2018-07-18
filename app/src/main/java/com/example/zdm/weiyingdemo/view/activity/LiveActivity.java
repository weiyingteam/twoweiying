package com.example.zdm.weiyingdemo.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.zdm.weiyingdemo.R;
import com.example.zdm.weiyingdemo.presenter.LivePresenter;
import com.example.zdm.weiyingdemo.view.interfaces.ILiveView;
import com.yolo.livesdk.widget.publish_3.BeautySurfaceView;
import com.yolo.livesdk.widget.publish_controller.BeautyPublishController;
import com.yolo.livesdk.widget.publish_controller.BeautyPublisherCallback;

public class LiveActivity extends BaseActivity<LivePresenter> implements ILiveView {


    BeautySurfaceView mBeautyPreview;

    private BeautyPublishController mBeautyPublishController;

    String mRtmpUrl = YOLO_PUBLISH_URL_PILI;

    /**
     * 推流地址
     */
    static final String YOLO_PUBLISH_URL_PILI
            = "rtmp://172.17.8.100/live/xyj";

    private Button mBtnPlay;


    @Override
    protected LivePresenter setPresenter() {
        return new LivePresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initPreviewPublisher();
    }

    private void initPreviewPublisher() {
        // 现在这个没存pref,就是每场都默认开启麦克的
        mBeautyPreview = (BeautySurfaceView) findViewById(R.id.mBeautySurfaceView);
        mBtnPlay = (Button) findViewById(R.id.mBtnPlay);
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LiveActivity.this, PlayActivity.class));
                finish();
            }
        });
        mBeautyPublishController = mBeautyPreview.getController();
        mBeautyPublishController.audioOn(true);
        boolean initFrontCamera = true;
        boolean initUseBeauty = true;
        boolean initMirror = true;
        boolean portrait = true;
        mBeautyPublishController
                .initPrefs(initFrontCamera, initUseBeauty, initMirror,
                        portrait);

        findViewById(R.id.mBtnBeauty).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mBeautyPublishController.switchUseBeauty();
            }
        });
    }

    @Override
    protected int setChildView() {
        return R.layout.activity_live;
    }



    @Override
    protected void onStart() {
        super.onStart();
        startPublish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPublish();
    }

    private void stopPublish() {
        mBeautyPublishController.stopPublish();
    }

    private void startPublish() {
        mBeautyPublishController
                .startPublish(LiveActivity.this, mRtmpUrl, mBeautyPublisherCallback);
    }

    BeautyPublisherCallback mBeautyPublisherCallback = new BeautyPublisherCallback() {
        @Override
        public void onOpenCameraFail() {

        }

        @Override
        public void onCameraAccessFail() {

        }

        @Override
        public void onLiveStarted() {

        }

        @Override
        public void onInitPublishFail() {

        }

        @Override
        public void onStartPublishFail() {

        }

        @Override
        public void onSendError() {

        }

        @Override
        public void onSendErrorResume() {

        }

        @Override
        public void onPublishCpuIntence() {

        }

        @Override
        public void onRePublishError() {

        }

        @Override
        public void onFrame(byte[] yuvData, int width, int height, long timestampMs) {

        }
    };
}
