package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;


public class PersonalInfoFragment extends Fragment {
    Button btnPersonInfoNext;
    OnNextClickListener activityCallback;
    String TAG = "PersonalInfoFragment";


    public PersonalInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            activityCallback = (OnNextClickListener) getContext();
            btnPersonInfoNext = (Button) getView().findViewById(R.id.btnPickCardNext);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Personal info fragment next button", ex);
        } catch (NullPointerException ex) {
            Log.e(TAG, "Next button resource id not found", ex);
        }

        btnPersonInfoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activityCallback.onStep1NextClick();
            }
        });
    }

}
