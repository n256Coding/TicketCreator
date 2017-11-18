package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentMethodFragment extends Fragment {
    OnNextClickListener nextClickListener;
    AccountController accountController;
    Button btnPaymentMethodNext, btnPaymentMethodBack;
    RadioButton rbCash, rbCreditCard;

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

        nextClickListener = (OnNextClickListener) getContext();
        btnPaymentMethodNext = (Button) getView().findViewById(R.id.btnPaymentMethodNext);
        btnPaymentMethodBack = (Button) getView().findViewById(R.id.btnPaymentMethodBack);
        rbCash = (RadioButton) getView().findViewById(R.id.rbCash);
        rbCreditCard = (RadioButton) getView().findViewById(R.id.rbCard);

        accountController = AccountController.getInstance();

        btnPaymentMethodNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbCash.isChecked()){
                    accountController.setPaymentType("cash");
                    nextClickListener.jumpToStep(4);
                }
                else if(rbCreditCard.isChecked()){
                    accountController.setPaymentType("card");
                    nextClickListener.jumpToStep(5);
                }
                else {
                    new AlertDialog.Builder(getContext())
                            .setCancelable(true)
                            .setTitle("No Option Selected")
                            .setMessage("Please select your preferred way to make payment")
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });

        btnPaymentMethodBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClickListener.jumpToStep(2);
            }
        });
    }
}
