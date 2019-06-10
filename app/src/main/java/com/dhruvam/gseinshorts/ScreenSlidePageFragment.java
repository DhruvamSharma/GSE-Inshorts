package com.dhruvam.gseinshorts;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

    @Override
    public void onAttach(Context context) {
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

        // Instantiate a ViewPager and a PagerAdapter.
        pagerInit(rootView);

        return rootView;
    }

    private void pagerInit(ViewGroup rootView) {
        mPager = rootView.findViewById(R.id.top_bottom_content_pager);
        if(null != getActivity()) {
            //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            pagerAdapter = new ScreenVerticalSlideAdapter();
            mPager.setAdapter(pagerAdapter);
            mPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        }

    }

    public int getItemData() {
        if(mPager != null)
            return mPager.getCurrentItem();
        else
            return -1;
    }

    /**
     * implemented inside card adapter
     */
    public interface NewsToNetListener {
        public void onFragmentSwipe();
    }


}
