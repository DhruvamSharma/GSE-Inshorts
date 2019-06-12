package com.dhruvam.gseinshorts;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;



public class ScreenSlidePageFragment extends Fragment {
    private NewsToNetListener mCallback;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next screen.
     */
    private ViewPager2 mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private ScreenVerticalSlideAdapter pagerAdapter;

    private NewsFragmentViewModel mViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            mCallback = (NewsToNetListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+ " must implement NewsToNetListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        // TODO Move viewmodel init somewhere so that it is not null while sending back result
        mViewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel.class);
        // Instantiate a ViewPager and a PagerAdapter.
        pagerInit(rootView);

        return rootView;
    }

    private void pagerInit(ViewGroup rootView) {
        mPager = rootView.findViewById(R.id.top_bottom_content_pager);
        mViewModel.scrollPosition = mPager.getCurrentItem();
        if(null != getActivity()) {
            pagerAdapter = new ScreenVerticalSlideAdapter();
            mPager.setAdapter(pagerAdapter);
            mPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        }

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mViewModel.scrollPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    int getItemData() {
        return mViewModel.scrollPosition;
    }

    /**
     * implemented inside card adapter
     */
    public interface NewsToNetListener {
        public void onFragmentSwipe();
    }


}
