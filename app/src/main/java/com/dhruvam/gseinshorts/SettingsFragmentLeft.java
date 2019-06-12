package com.dhruvam.gseinshorts;

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
        mSearchView.setClickable(true);
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.setVisibility(View.GONE);
                mToolbar.setVisibility(View.VISIBLE);
            }
        });

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.setVisibility(View.VISIBLE);
                mToolbar.setVisibility(View.GONE);
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
