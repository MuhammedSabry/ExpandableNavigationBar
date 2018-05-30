package com.sabry.muhammed.botnavbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sabry.muhammed.botnavbar.fragment.MainFunctionalityFragment;
import com.sabry.muhammed.botnavbar.fragment.OtherFunctionalityFragment;

public class ExpandableFragmentPagerAdapter extends FragmentPagerAdapter {

    ExpandableFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? new MainFunctionalityFragment() : new OtherFunctionalityFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
