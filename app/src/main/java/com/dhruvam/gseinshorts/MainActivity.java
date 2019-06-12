package com.dhruvam.gseinshorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
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

    private MainActivityViewModel mViewModel;

    private NetworkConnectionStatus mReceiver = new NetworkConnectionStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        // Instantiate a ViewPager and a PagerAdapter.
        pagerInit();
        registerNetworkStatusListener();
    }

    private void registerNetworkStatusListener() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        this.registerReceiver(mReceiver, filter);
    }

    private void passDataToDetailFragment(int position) {
        if (position == MAIN_CONTENT_PAGE + 1) {
            int data = mViewModel.data;
            if (data != -1) {
                ScreenSlidePagerAdapter adapter = (ScreenSlidePagerAdapter) pagerAdapter;
                DetailFragmentRight fragment = (DetailFragmentRight) adapter.getItem(position);
                fragment.onNewData(data);
            }
        }
    }

    private void fetchingCurrentNewsItem(int state) {
        if (state == MAIN_CONTENT_PAGE) {
            ScreenSlidePagerAdapter adapter = (ScreenSlidePagerAdapter) pagerAdapter;
            ScreenSlidePageFragment fragment = (ScreenSlidePageFragment) adapter.getItem(state);
            int data = fragment.getItemData();
            if (data != -1)
            mViewModel.data = data;
            Log.d("current item", String.valueOf(data));
        }
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

    private void pagerInit() {
        mPager = findViewById(R.id.main_content_holder);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setCurrentItem(1);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                passDataToDetailFragment(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                fetchingCurrentNewsItem(state);
            }
        });
    }


    @Override
    public void onFragmentSwipe() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
