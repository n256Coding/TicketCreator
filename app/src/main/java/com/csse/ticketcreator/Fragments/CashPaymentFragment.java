package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashPaymentFragment extends Fragment {
    private static final String TAG = "CashPaymentFrag";
    OnNextClickListener nextClickListener;
    AccountController accountController;
    Button btnCashNext, btnCashBack;
    TextView txtAmount, txtServiceCharge, txtFullAmount;

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

        nextClickListener = (OnNextClickListener) getContext();
        btnCashNext = (Button) getView().findViewById(R.id.btnCashNext);
        btnCashBack = (Button) getView().findViewById(R.id.btnCashBack);
        txtAmount = (TextView) getView().findViewById(R.id.txtAmount);
        txtServiceCharge = (TextView) getView().findViewById(R.id.txtServiceCharge);
        txtFullAmount = (TextView) getView().findViewById(R.id.txtFullAmount);
        accountController = AccountController.getInstance();

        txtAmount.setText(String.valueOf(accountController.getAccount().getAmount()));
        txtServiceCharge.setText(String.valueOf(accountController.getCashServiceCharge()));
        txtFullAmount.setText(String.valueOf(accountController.getTotalCharge()));

        btnCashNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(accountController.makeAccount()){
                    nextClickListener.jumpToStep(6);
                }
                else{
                    Log.e(TAG, "Error saving data to firebase");

                    new AlertDialog.Builder(getContext())
                            .setTitle("Transaction Error")
                            .setMessage("Transaction could not completed, Account not created.\nTry Again")
                            .setCancelable(true)
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });

        btnCashBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClickListener.jumpToStep(3);
            }
        });
    }
}
