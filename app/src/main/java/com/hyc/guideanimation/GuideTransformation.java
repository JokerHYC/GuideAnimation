package com.hyc.guideanimation;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by joker on 2017/6/27.
 */

public class GuideTransformation implements ViewPager.PageTransformer {
    private static final String TAG = "GuideTransformation";
    private View layout;
    private ImageView mGuide21, mGuide22, mGuide31, mGuide32, mGuide33, mGuide34, mGuide41, mGuide42;

    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();
        int height = page.getHeight();
        layout = page.findViewById(R.id.layout);
        mGuide21 = page.findViewById(R.id.guide21);
        mGuide22 = page.findViewById(R.id.guide22);
        mGuide31 = page.findViewById(R.id.guide31);
        mGuide32 = page.findViewById(R.id.guide32);
        mGuide33 = page.findViewById(R.id.guide33);
        mGuide34 = page.findViewById(R.id.guide34);
        mGuide41 = page.findViewById(R.id.guide41);
        mGuide42 = page.findViewById(R.id.guide42);
//        //這裏只對右邊的view做了操作
//        if (position > 0 && position <= 1) {//right scorlling
//            //position是1.0->0,但是沒有等於0
//
//        } else if (position >= -1 && position < 0) {//left scrolling
//
//        } else {//center
//
//        }

        float ratio = (float) width / height;

        if (position < -1) { // [-Infinity,-1)

            // This page is way off-screen to the left.

        } else if (position <= 1) { // [-1,1]


            if (position > 0 && position <= 1) {

                if (mGuide21 != null && mGuide22 != null) {
                    mGuide21.setTranslationX((float) (width * (position) / 2 * 1.5));
                    mGuide22.setTranslationX((float) (width * (position) / 2 * 1.1));
                    mGuide22.setTranslationY((float) (width * (position) / 2 * 1.1));
                }

                if (mGuide31 != null && mGuide32 != null && mGuide33 != null && mGuide34 != null) {
                    mGuide31.setTranslationX(-(width * (position) / 5));
                    mGuide31.setTranslationY(-(float) (width * (position) / 2 * 1.1));
                    mGuide32.setTranslationX((width * (position) / 5));
                    mGuide32.setTranslationY(-(float) (width * (position) / 2 * 1.1));
                    mGuide33.setTranslationX(-(width * (position) / 5));
                    mGuide33.setTranslationY((float) (width * (position) / 2 * 1.1));
                    mGuide34.setTranslationX((width * (position) / 5));
                    mGuide34.setTranslationY((float) (width * (position) / 2 * 1.1));
                    mGuide31.setAlpha(1 - position);
                    mGuide32.setAlpha(1 - position);
                    mGuide33.setAlpha(1 - position);
                    mGuide34.setAlpha(1 - position);
                }

                if (mGuide41 != null && mGuide42 != null) {
                    mGuide41.setTranslationY((float) (width * (position) / 2 * 1.1));
                    mGuide42.setTranslationY((float) (width * (position) / 10));
                }


            } else if (position <= 0 && position > -1) {
                if (layout != null) {
                    layout.setTranslationX((float) (width * (position) / 2 * 1.5));
                }

                if (mGuide21 != null && mGuide22 != null) {
                    mGuide21.setTranslationX((float) (width * (position) / 2 * 1.5));
                }

                if (mGuide31 != null && mGuide32 != null && mGuide33 != null && mGuide34 != null) {
                    mGuide31.setTranslationX((width * (position)));
                    mGuide32.setTranslationX((width * (position)));
                    mGuide33.setTranslationX((width * (position) / 2));
                    mGuide34.setTranslationX((width * (position) / 2));
                }

            }


        } else {

            // (1,+Infinity]
            // This page is way off-screen to the right.

        }
    }
}
