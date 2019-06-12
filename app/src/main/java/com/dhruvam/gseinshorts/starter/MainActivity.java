package com.dhruvam.gseinshorts.starter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.dhruvam.gseinshorts.DetailTab.DetailFragmentRight;
import com.dhruvam.gseinshorts.R;
import com.dhruvam.gseinshorts.SettingsTab.SettingsFragmentLeft;
import com.dhruvam.gseinshorts.util.NetworkConnectionStatus;
import com.dhruvam.gseinshorts.VerticalNews.ScreenSlidePageFragment;

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

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == MAIN_CONTENT_PAGE) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(MAIN_CONTENT_PAGE);
        }
    }

    private void pagerInit() {
        mPager = findViewById(R.id.main_content_holder);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setCurrentItem(MAIN_CONTENT_PAGE);
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
