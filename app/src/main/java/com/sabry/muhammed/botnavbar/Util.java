package com.sabry.muhammed.botnavbar;

import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Util {
    private int targetHeight ;

    public void setTargetHeight(int targetHeight) {
        this.targetHeight = targetHeight;
    }

    public static void expand(final View v) {
        v.setVisibility(View.VISIBLE);
        v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        v.requestLayout();
        final int targetHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height =
                        (interpolatedTime == 1) ?
                                WindowManager.LayoutParams.WRAP_CONTENT
                                :
                                (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density) * 4);
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.INVISIBLE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) * 4);
        v.startAnimation(a);
    }

}
