package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.TravelCard;
import com.csse.ticketcreator.R;
import com.csse.ticketcreator.TopupActivity;

/**
 * This is the activity to show topup amount
 *
 * @author Sampath
 * @version 1.0
 */
public class ReferenceNoRequestFragment extends Fragment {
    Button btnTopupValueNext;
    Spinner spinnerTopUpAmount;
    OnNextClickListener nextClickListener;
    AccountController accountController;

    public ReferenceNoRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reference_no_request, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        accountController = AccountController.getInstance();
        nextClickListener = (TopupActivity) getContext();
        btnTopupValueNext = (Button) getActivity().findViewById(R.id.btnTopupValueNext);
        spinnerTopUpAmount = (Spinner) getActivity().findViewById(R.id.spinnerTopupAmount);

        btnTopupValueNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TravelCard travelCard = new TravelCard();
                travelCard.setAmount(Double.parseDouble(spinnerTopUpAmount.getSelectedItem().toString()));
                accountController.setTravelCardInformation(travelCard);

                nextClickListener.jumpToStep(3);
            }
        });
    }
}
