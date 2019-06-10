package com.dhruvam.gseinshorts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenVerticalSlideAdapter extends FragmentStatePagerAdapter {
    /**
     * The number of pages to show in this apk.
     */
    private static final int NUM_PAGES = 3;


    public ScreenVerticalSlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TopBottomFragment();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
