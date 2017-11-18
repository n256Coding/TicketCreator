package com.csse.ticketcreator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.Account;
import com.csse.ticketcreator.R;

public class CardPaymentFragment extends Fragment {
    OnNextClickListener nextClickListener;
    AccountController accountController;
    Button btnCardNext, btnCardBack;
    EditText txtCardHolder, txtCardNumber, txtExpiryDate, txtCcv;

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

        nextClickListener = (OnNextClickListener) getContext();
        btnCardNext = (Button) getView().findViewById(R.id.btnCardNext);
        btnCardBack = (Button) getView().findViewById(R.id.btnCashBack);
        txtCardHolder = (EditText) getView().findViewById(R.id.txtCardHolder);
        txtCardNumber = (EditText) getView().findViewById(R.id.txtCardNumber);
        txtExpiryDate = (EditText) getView().findViewById(R.id.txtExpiryDate);
        txtCcv = (EditText) getView().findViewById(R.id.txtCcv);
        accountController = AccountController.getInstance();

        btnCardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account account = accountController.getAccount();
                account.setCardHolderName(txtCardHolder.getText().toString().trim());
                account.setCardNumber(txtCardNumber.getText().toString().trim());
                account.setExpiryDate(txtExpiryDate.getText().toString().trim());
                account.setCcv(txtCcv.getText().toString().trim());

                if (accountController.checkCardDetails(account.getCardHolderName(), account.getCardNumber(),
                        account.getExpiryDate(), account.getCcv()).equals("success")) {
                    accountController.setAccount(account);
                    if(accountController.makeAccount()){
                        //This is custom listener to communicate with main activity of this fragment
                        nextClickListener.jumpToStep(6);
                    }
                }
                else{
                    new AlertDialog.Builder(getContext())
                            .setTitle("Invalid Credit Card Information")
                            .setMessage("Credit card details you entered are invalid, " +
                                    "Please enter correct details")
                            .setCancelable(true)
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });

        btnCardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClickListener.jumpToStep(3);
            }
        });
    }
}
