package com.xyc.moudle_douyin.ui;

/**
 * Created by xieyusheng on 2019/1/14.
 */

public interface OnViewPagerListener {
    /**
     * 初始化完成
     */
    void onInitComplete();

    /**
     * 释放的监听
     */
    void onPageRelease(int position);

    /**
     * 滑动开始的监听
     */
    void onPageScroll(int position);

    /**
     * 选中的监听以及判断是否滑动到底部
     */
    void onPageSelected(int position, boolean isBottom);
}
