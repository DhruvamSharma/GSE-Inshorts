package com.dhruvam.gseinshorts.VerticalNews;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhruvam.gseinshorts.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopBottomFragment extends Fragment {


    public TopBottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_bottom, container, false);
    }

}
