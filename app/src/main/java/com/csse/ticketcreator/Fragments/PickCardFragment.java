package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PickCardFragment extends Fragment {
    private static PickCardFragment pickCardFragment;
    private OnNextClickListener activityCallback;
    Button btnPickCardNext;

    //For use with android logger
    String TAG = "PickCardFragment";

    public PickCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_card, container, false);
    }

    public static PickCardFragment getInstance() {
        if (pickCardFragment == null) {
            pickCardFragment = new PickCardFragment();
        }
        return pickCardFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            activityCallback = (OnNextClickListener) getContext();
            btnPickCardNext = (Button) getView().findViewById(R.id.btnPickCardNext);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Pick card fragment next button", ex);
        } catch (NullPointerException ex) {
            Log.e(TAG, "Next button resource id not found", ex);
        }

        btnPickCardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCallback.onStep2NextClick();
            }
        });
    }
}
