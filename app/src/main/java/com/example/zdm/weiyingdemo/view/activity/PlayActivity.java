package com.example.zdm.weiyingdemo.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zdm.weiyingdemo.R;
import com.yolo.livesdk.widget.watch.YoloWatchView;

public class PlayActivity extends AppCompatActivity {

    private YoloWatchView mWatchView;

    static final String YOLO_PLAY_URL_PILI
            = "rtmp://172.17.8.100/live/xyj";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
    }

    private void initView() {
        mWatchView = (YoloWatchView) findViewById(R.id.mWatchView);

        mWatchView.init(YOLO_PLAY_URL_PILI);
        mWatchView.start();

    }
}
