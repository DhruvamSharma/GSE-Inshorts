package com.dhruvam.gseinshorts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    /**
     * The number of pages to show in this apk.
     */
    private static final int NUM_PAGES = 3;


    ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SettingsFragmentLeft();
                break;

            case 1:
                fragment = new ScreenSlidePageFragment();
                break;

            case 2:
                fragment = new DetailFragmentRight();
                break;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}
