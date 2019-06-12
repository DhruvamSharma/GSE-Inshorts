package com.dhruvam.gseinshorts.starter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.dhruvam.gseinshorts.DetailTab.DetailFragmentRight;
import com.dhruvam.gseinshorts.SettingsTab.SettingsFragmentLeft;
import com.dhruvam.gseinshorts.VerticalNews.ScreenSlidePageFragment;

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

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
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
            default:
                fragment = getScreenSlidePageFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    private DetailFragmentRight getDetailFragmentRight() {
        if(detailFragmentRight == null) {
            detailFragmentRight = new DetailFragmentRight();
        }
        return detailFragmentRight;
    }

    private ScreenSlidePageFragment getScreenSlidePageFragment() {
        if(screenSlidePageFragment == null) {
            screenSlidePageFragment = new ScreenSlidePageFragment();
        }
        return screenSlidePageFragment;
    }

    private SettingsFragmentLeft getSettingsFragmentLeft() {
        if(settingsFragmentLeft == null) {
            settingsFragmentLeft = new SettingsFragmentLeft();
        }
        return settingsFragmentLeft;
    }
}
