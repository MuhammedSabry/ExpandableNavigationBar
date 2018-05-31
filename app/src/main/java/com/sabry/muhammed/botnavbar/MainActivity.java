package com.sabry.muhammed.botnavbar;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sabry.muhammed.botnavbar.fragment.FirstPageFragment;
import com.sabry.muhammed.botnavbar.fragment.SecondPageFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout layout = findViewById(R.id.pager_include);

        //ViewPager setup
        viewPager = findViewById(R.id.pager);
        //We going to implement our ViewPager adapter to populate
        //pages with the right fragment
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? new FirstPageFragment() : new SecondPageFragment();
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        //Setup the dots indicating the current page
        final TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);

        //Animation Setup
        final ImageButton button = findViewById(R.id.expand_activities_button);
        tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross);
        crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);

        //animating and showing the expandable view on click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Util.isAnimating()) {
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
            }
        });
    }
}
