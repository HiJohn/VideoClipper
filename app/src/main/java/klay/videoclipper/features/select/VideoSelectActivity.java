package klay.videoclipper.features.select;

import android.Manifest;
import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import iknow.android.utils.callback.SimpleCallback;
import iknow.android.utils.callback.SingleCallback;
import klay.videoclipper.R;
import klay.videoclipper.features.trim.VideoTrimmerActivity;
import klay.videoclipper.models.VideoInfo;
import klay.videoclipper.utils.TrimVideoUtil;
import klay.videoclipper.widget.SpacesItemDecoration;

/**
 * Author：J.Chou
 * Date：  2016.08.01 2:23 PM
 * Email： who_know_me@163.com
 * Describe:
 */
public class VideoSelectActivity extends AppCompatActivity implements View.OnClickListener {

//    private VideoSelectLayoutBinding mBinding;
    private VideoSelectAdapter mVideoSelectAdapter;
    private String mVideoPath;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        mBinding = DataBindingUtil.setContentView(this, R.layout.video_select_layout);
//
//        GridLayoutManager manager = new GridLayoutManager(this, 4);
//        mBinding.videoSelectRecyclerview.addItemDecoration(new SpacesItemDecoration(5));
//        mBinding.videoSelectRecyclerview.setHasFixedSize(true);
//
//        mBinding.videoSelectRecyclerview.setAdapter(mVideoSelectAdapter = new VideoSelectAdapter(this));
//        mBinding.videoSelectRecyclerview.setLayoutManager(manager);
//
//        mBinding.videoShoot.setOnClickListener(this);
//        mBinding.mBtnBack.setOnClickListener(this);
//        mBinding.nextStep.setOnClickListener(this);
//
//        mBinding.nextStep.setTextAppearance(this, R.style.gray_text_18_style);
//        mBinding.nextStep.setEnabled(false);
//
//        mVideoSelectAdapter.setItemClickCallback(new SingleCallback<Boolean, VideoInfo>() {
//            @Override
//            public void onSingleCallback(Boolean isSelected, VideoInfo video) {
//                if (video != null) mVideoPath = video.getVideoPath();
//                mBinding.nextStep.setEnabled(isSelected);
//                mBinding.nextStep.setTextAppearance(VideoSelectActivity.this, isSelected ? R.style.blue_text_18_style : R.style.gray_text_18_style);
//            }
//        });

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(granted -> {
            if (granted) { // Always true pre-M
                TrimVideoUtil.loadAllVideoFiles(this, new SimpleCallback() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public void success(Object obj) {
                        mVideoSelectAdapter.setVideoData((List<VideoInfo>) obj);
                    }
                });
            } else {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == mBinding.mBtnBack.getId()) {
//            finish();
//        } else if (v.getId() == mBinding.nextStep.getId()) {
//            VideoTrimmerActivity.call(VideoSelectActivity.this, mVideoPath);
//        }
    }
}
