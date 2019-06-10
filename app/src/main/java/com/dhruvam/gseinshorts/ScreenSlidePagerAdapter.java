package com.dhruvam.gseinshorts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private SettingsFragmentLeft settingsFragmentLeft;
    private ScreenSlidePageFragment screenSlidePageFragment;
    private DetailFragmentRight detailFragmentRight;

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
                fragment = getSettingsFragmentLeft();
                break;

            case 1:
                fragment = getScreenSlidePageFragment();
                break;

            case 2:
                fragment = getDetailFragmentRight();
                break;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    public DetailFragmentRight getDetailFragmentRight() {
        if(detailFragmentRight == null) {
            detailFragmentRight = new DetailFragmentRight();
        }
        return detailFragmentRight;
    }

    public ScreenSlidePageFragment getScreenSlidePageFragment() {
        if(screenSlidePageFragment == null) {
            screenSlidePageFragment = new ScreenSlidePageFragment();
        }
        return screenSlidePageFragment;
    }

    public SettingsFragmentLeft getSettingsFragmentLeft() {
        if(settingsFragmentLeft == null) {
            settingsFragmentLeft = new SettingsFragmentLeft();
        }
        return settingsFragmentLeft;
    }
}
