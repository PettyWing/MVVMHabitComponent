package com.xyc.moudle_douyin.adapter;

/**
 * Created by xieyusheng on 2019/1/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.xyc.base.utils.FileUtil;
import com.xyc.moudle_douyin.R;

public class DouyinAdapter extends RecyclerView.Adapter<DouyinAdapter.ViewHolder> {
    private int[] imgs = {R.mipmap.img_video_1, R.mipmap.img_video_2, R.mipmap.img_video_3, R.mipmap.img_video_4, R.mipmap.img_video_5, R.mipmap.img_video_6, R.mipmap.img_video_7, R.mipmap.img_video_8};
    private int[] videos = {R.raw.video_1, R.raw.video_2, R.raw.video_3, R.raw.video_4, R.raw.video_5, R.raw.video_6, R.raw.video_7, R.raw.video_8};
    private Context mContext;

    public DouyinAdapter(Context context) {
        this.mContext = context;
    }


    @Override
    public DouyinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.douyin_item_view_pager, parent, false);
        return new DouyinAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DouyinAdapter.ViewHolder holder, int position) {
        holder.img_thumb.setImageResource(imgs[position]);
        holder.videoView.setVideoURI(FileUtil.getFileFromRaw(mContext, videos[position]));
    }



    @Override
    public int getItemCount() {
        return videos.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_thumb;
        VideoView videoView;
        ImageView img_play;
        RelativeLayout rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            img_thumb = itemView.findViewById(R.id.img_thumb);
            videoView = itemView.findViewById(R.id.video_view);
            img_play = itemView.findViewById(R.id.img_play);
            rootView = itemView.findViewById(R.id.root_view);
        }
    }
}
