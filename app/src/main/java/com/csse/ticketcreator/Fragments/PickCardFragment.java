package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csse.ticketcreator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PickCardFragment extends Fragment {


    public PickCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_card, container, false);
    }

}