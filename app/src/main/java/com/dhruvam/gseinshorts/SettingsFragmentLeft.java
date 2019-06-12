package com.dhruvam.gseinshorts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragmentLeft.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SettingsFragmentLeft extends Fragment {
    private SearchView mSearchView;
    private Toolbar mToolbar;
    private EditText mSerachText;
    private ImageButton mBackArrow;
    private LinearLayout mBottomLayout;

    private OnFragmentInteractionListener mListener;

    public SettingsFragmentLeft() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_settings_left, container, false);

        initSettingsFragment(rootView);

        return rootView;
    }

    private void initSettingsFragment(ViewGroup rootView) {
        mSearchView = rootView.findViewById(R.id.setting_search_bar);
        mToolbar = rootView.findViewById(R.id.setting_toolbar);
        mSerachText = rootView.findViewById(R.id.search_query_text);
        mBackArrow = rootView.findViewById(R.id.back_arrow_button);
        mBottomLayout = rootView.findViewById(R.id.setting_bottom_layout);
        mSearchView.setClickable(true);
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setVisibility(View.VISIBLE);

                ValueAnimator fadeAnimToolbar = ObjectAnimator.ofFloat(mToolbar, "translationY", -100f, 0f);
                fadeAnimToolbar.setDuration(250);

                ValueAnimator fadeAnimSearchView = ObjectAnimator.ofFloat(mSearchView, "alpha", 1f, 0f);
                fadeAnimSearchView.setDuration(250);

                ValueAnimator fadeAnimBottomLayout = ObjectAnimator.ofFloat(mBottomLayout, "alpha", 1f, 0f);
                fadeAnimBottomLayout.setDuration(250);

                ValueAnimator translateAnim = ObjectAnimator.ofFloat(mBottomLayout, "translationY", 0f, 100f);
                translateAnim.setDuration(250);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(translateAnim).with(fadeAnimBottomLayout).with(fadeAnimSearchView).with(fadeAnimToolbar);
                animatorSet.start();

                translateAnim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mSearchView.setVisibility(View.GONE);
                        mToolbar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        mSearchView.setVisibility(View.GONE);
                        mToolbar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.setVisibility(View.VISIBLE);

                ValueAnimator fadeAnimToolbar = ObjectAnimator.ofFloat(mToolbar, "translationY", 0f, -100f);
                fadeAnimToolbar.setDuration(250);

                ValueAnimator fadeAnimSearchView = ObjectAnimator.ofFloat(mSearchView, "alpha", 0f, 1f);
                fadeAnimSearchView.setDuration(250);

                ValueAnimator fadeAnimBottomLayout = ObjectAnimator.ofFloat(mBottomLayout, "alpha", 0f, 1f);
                fadeAnimBottomLayout.setDuration(250);

                ValueAnimator translateAnim = ObjectAnimator.ofFloat(mBottomLayout, "translationY", 100f, 0f);
                translateAnim.setDuration(250);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(translateAnim).with(fadeAnimSearchView).with(fadeAnimBottomLayout).with(fadeAnimToolbar);
                animatorSet.start();

                translateAnim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mSearchView.setVisibility(View.VISIBLE);
                        mToolbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        mSearchView.setVisibility(View.VISIBLE);
                        mToolbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
