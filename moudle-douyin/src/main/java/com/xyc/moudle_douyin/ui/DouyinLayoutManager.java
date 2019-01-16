package com.xyc.moudle_douyin.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;

/**
 * Created by xieyusheng on 2019/1/14.
 */

public class DouyinLayoutManager extends LinearLayoutManager implements RecyclerView.OnChildAttachStateChangeListener {

    private static final String TAG = "DouyinLayoutManager";
    private int mDrift;//位移，用来判断移动方向

    private PagerSnapHelper mPagerSnapHelper;
    private OnViewPagerListener mOnViewPagerListener;

    public DouyinLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        mPagerSnapHelper = new PagerSnapHelper();
    }

    public void setOnViewPagerListener(OnViewPagerListener mOnViewPagerListener) {
        this.mOnViewPagerListener = mOnViewPagerListener;
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        view.addOnChildAttachStateChangeListener(this);
        mPagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }

    @Override
    public void onChildViewAttachedToWindow(View view) {
        int position = getPosition(view);
        Log.d(TAG, "onChildViewAttachedToWindow: " + position);
        if (mOnViewPagerListener != null) {
            mOnViewPagerListener.onPageSelected(getPosition(view), false);
        }
    }

    @Override
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        if (mOnViewPagerListener != null)
            mOnViewPagerListener.onPageRelease(getPosition(view));
    }

    @Override
    public void onScrollStateChanged(int state) {
        if (state == SCROLL_STATE_DRAGGING) {
            mOnViewPagerListener.onPageScroll(findLastCompletelyVisibleItemPosition());
        }
        super.onScrollStateChanged(state);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = dy;
        Log.d(TAG, "scrollVerticallyBy: " + mDrift);
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }
}
