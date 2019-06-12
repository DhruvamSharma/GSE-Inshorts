package com.dhruvam.gseinshorts.vertical_news;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import com.dhruvam.gseinshorts.R;


public class ScreenSlidePageFragment extends Fragment {
    private NewsToNetListener mCallback;
    private LinearLayout mActionLayout;
    private CardView mNewsHolder;

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
        //mPager.setPageTransformer(new DepthPageTransformer());
        mActionLayout = rootView.findViewById(R.id.main_bottom_action_layout);
        mViewModel.scrollPosition = mPager.getCurrentItem();
        if(null != getActivity()) {
            pagerAdapter = new ScreenVerticalSlideAdapter(new CardClickListener() {
                @Override
                public void onCardClick(int i) {
                    Log.d("here", "in interface");
                    onCardClickListener(i);
                }
            });
            mPager.setAdapter(pagerAdapter);
            mPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        }
    }


    private void onCardClickListener(int i) {
        View view = mPager.getChildAt(0);
        mNewsHolder = view.findViewById(R.id.news_item_layout);
        mNewsHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("here", "on card click");

                if(mActionLayout.getVisibility() == View.GONE) {
                    mActionLayout.setVisibility(View.VISIBLE);
                    ValueAnimator translateAnimToolbar = ObjectAnimator.ofFloat(mActionLayout, "translationY", 200f, 0f);
                    translateAnimToolbar.setDuration(250);

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(translateAnimToolbar);
                    animatorSet.start();
                } else {
                    ValueAnimator translateAnimToolbar = ObjectAnimator.ofFloat(mActionLayout, "translationY", 0f, 200f);
                    translateAnimToolbar.setDuration(250);

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(translateAnimToolbar);
                    animatorSet.start();
                    translateAnimToolbar.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mActionLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                }

            }
        });
    }

    /**
     * implemented inside card adapter
     */
    public interface NewsToNetListener {
        public void onFragmentSwipe();
    }


}
