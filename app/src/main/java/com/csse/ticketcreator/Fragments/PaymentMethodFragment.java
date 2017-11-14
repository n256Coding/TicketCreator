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


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentMethodFragment extends Fragment {
    OnNextClickListener activityCallback;
    Button btnPaymentMethodNext;

    public PaymentMethodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_method, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activityCallback = (OnNextClickListener) getContext();
        btnPaymentMethodNext = (Button) getView().findViewById(R.id.btnPaymentMethodNext);

        btnPaymentMethodNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCallback.onStep3NextClick();
            }
        });
    }
}
