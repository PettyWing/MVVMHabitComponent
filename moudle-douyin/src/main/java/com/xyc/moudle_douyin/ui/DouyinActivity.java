package com.xyc.moudle_douyin.ui;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.xyc.moudle_douyin.BR;
import com.xyc.moudle_douyin.R;
import com.xyc.moudle_douyin.adapter.DouyinAdapter;
import com.xyc.moudle_douyin.databinding.DouyinActivityMainBinding;
import com.xyc.moudle_douyin.view.FullWindowVideoView;

import me.goldze.mvvmhabit.base.BaseActivity;


public class DouyinActivity extends BaseActivity<DouyinActivityMainBinding, DouyinViewModel> {

    private static final String TAG = "DouyinActivity";
    private DouyinLayoutManager layoutManager;
    private DouyinAdapter mAdapter;

    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.douyin_activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DouyinViewModel initViewModel() {
        initView();
        initListener();
        return super.initViewModel();
    }

    private void initView() {
        layoutManager = new DouyinLayoutManager(this, OrientationHelper.VERTICAL, false);
        mAdapter = new DouyinAdapter(this);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setAdapter(mAdapter);

    }

    private void initListener() {
        layoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(int position) {
                releaseVideo(position);
            }

            @Override
            public void onPageScroll(int position) {
                pauseVideo(position);
            }

            @Override
            public void onPageSelected(int position, boolean bottom) {
                Log.e(TAG, "选择位置:" + position + " 下一页:" + bottom);
                playVideo(position);
            }
        });
    }

    private void pauseVideo(int position){
        View itemView = layoutManager.findViewByPosition(position);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        videoView.pause();
    }

    private void releaseVideo(int position) {
        View itemView = layoutManager.findViewByPosition(position);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        videoView.stopPlayback();
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void playVideo(int position) {
        View itemView = layoutManager.findViewByPosition(position);
        final FullWindowVideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final RelativeLayout rootView = itemView.findViewById(R.id.root_view);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });

        videoView.start();

        imgThumb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(0.7f).start();
                    videoView.pause();
                } else {
                    imgPlay.animate().alpha(0f).start();
                    videoView.start();
                }
            }
        });
    }
}
