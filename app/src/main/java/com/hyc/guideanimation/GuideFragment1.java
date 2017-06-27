package com.hyc.guideanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.Arrays;

/**
 * Created by joker on 2017/6/27.
 */

public class GuideFragment1 extends Fragment {
    private KenBurnsView mKenBurnsView;
    private LoopViewPager loopViewPager;
    public static Integer[] res1 = new Integer[]{R.drawable.guide_1_1, R.drawable.guide_1_2, R.drawable.guide_1_3, R.drawable.guide_1_4};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_guide_1, container, false);
        AutoUtils.auto(inflate);
        return inflate;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mKenBurnsView = view.findViewById(R.id.burns);
        mKenBurnsView.setScaleType(ImageView.ScaleType.FIT_XY);
        mKenBurnsView.setSwapMs(2500);
        mKenBurnsView.setFadeInOutMs(500);
        mKenBurnsView.loadResourceIDs(Arrays.asList(res1));

        loopViewPager = new LoopViewPager(this.getContext(), res1.length, new LoopViewPager.LoopViewPagerListener() {
            @Override
            public View OnInstantiateItem(int page) {
                View counterText = new View(getContext());
                return counterText;
            }

            @Override
            public void onPageScrollChanged(int page) {

            }

            @Override
            public void onPageScroll(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mKenBurnsView.forceSelected(position);
            }
        });

        loopViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        loopViewPager.setOffscreenPageLimit(2);
        FrameLayout viewPagerFrame = view.findViewById(R.id.view_pager_frame);
        viewPagerFrame.addView(loopViewPager);

        mKenBurnsView.setPager(loopViewPager);

    }
}
