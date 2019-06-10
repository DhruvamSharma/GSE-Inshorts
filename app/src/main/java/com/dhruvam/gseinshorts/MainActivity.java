package com.dhruvam.gseinshorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
        implements ScreenSlidePageFragment.NewsToNetListener,
                    SettingsFragmentLeft.OnFragmentInteractionListener,
                    DetailFragmentRight.OnFragmentInteractionListener{

    private static final int MAIN_CONTENT_PAGE = 1;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next screen.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        pagerInit();
    }

    private void pagerInit() {
        mPager = findViewById(R.id.main_content_holder);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setCurrentItem(1);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("page scrolled", String.valueOf(position));
            }

            @Override
            public void onPageSelected(int position) {
                if (position == MAIN_CONTENT_PAGE) {
                    ScreenSlidePagerAdapter adapter = (ScreenSlidePagerAdapter) pagerAdapter;
                    ScreenSlidePageFragment fragment = (ScreenSlidePageFragment) adapter.getItem(position);
                    int data = fragment.getItemData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    @Override
    public void onFragmentSwipe() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
