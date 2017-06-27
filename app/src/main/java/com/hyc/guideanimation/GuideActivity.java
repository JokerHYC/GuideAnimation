package com.hyc.guideanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joker on 2017/6/27.
 */

public class GuideActivity extends AutoLayoutActivity {
    private static final String TAG = "GuideActivity";
    private ViewPager mViewPager;
    private InkPageIndicator mIndicator;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        mFragments = new ArrayList<>();
        mFragments.add(new GuideFragment1());
        mFragments.add(new GuideFragment2());
        mFragments.add(new GuideFragment3());
        mFragments.add(new GuideFragment4());
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

        mIndicator.setViewPager(mViewPager);
        mViewPager.setPageTransformer(false, new GuideTransformation());
    }
}
