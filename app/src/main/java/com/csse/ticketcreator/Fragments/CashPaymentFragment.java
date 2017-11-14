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
public class CashPaymentFragment extends Fragment {
    OnNextClickListener activityCallback;
    Button btnCashNext;

    public CashPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cash_payment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activityCallback = (OnNextClickListener) getContext();
        btnCashNext = (Button) getView().findViewById(R.id.btnCashNext);
    }
}
