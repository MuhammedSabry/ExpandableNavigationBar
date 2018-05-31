package com.sabry.muhammed.botnavbar;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstraintLayout layout = findViewById(R.id.pager_include);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new ExpandableFragmentPagerAdapter(getSupportFragmentManager()));
        final TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);

        final ImageButton button = findViewById(R.id.expand_activities_button);

        tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross);
        crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatedVectorDrawable drawable;
                if (layout.getVisibility() == View.VISIBLE) {
                    Util.collapse(layout);
                    drawable = crossToTick;
                } else {
                    Util.expand(layout);
                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                    drawable = tickToCross;
                }
                drawable.start();
                button.setImageDrawable(drawable);
            }
        });
    }
}
