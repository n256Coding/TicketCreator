package com.csse.ticketcreator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;

public class CardPaymentFragment extends Fragment {
    OnNextClickListener activityCallback;
    Button btnCardNext;

    public CardPaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_payment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activityCallback = (OnNextClickListener) getContext();
        btnCardNext = (Button) getView().findViewById(R.id.btnCardNext);

        btnCardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCallback.jumpToStep(5);
            }
        });
    }
}
