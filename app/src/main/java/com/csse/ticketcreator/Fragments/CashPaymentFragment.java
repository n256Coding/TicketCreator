package com.csse.ticketcreator.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
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
import com.csse.ticketcreator.HomeActivity;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.DBModel;
import com.csse.ticketcreator.NewCardActivity;
import com.csse.ticketcreator.R;
import com.csse.ticketcreator.TopupActivity;
import com.google.zxing.integration.android.IntentResult;

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

        txtAmount.setText(String.valueOf(accountController.getTravelCard().getAmount()));
        txtServiceCharge.setText(String.valueOf(accountController.getCashServiceCharge()));
        txtFullAmount.setText(String.valueOf(accountController.getTotalCharge()));

        btnCashNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity() instanceof NewCardActivity){
                    if(accountController.makeTravelCard()){
                        nextClickListener.jumpToStep(6);
                    }
                    else{
                        Log.e(TAG, "Error saving data to firebase");

                        new AlertDialog.Builder(getContext())
                                .setTitle("Transaction Error")
                                .setMessage("Transaction could not completed, Travel Card not created.\nTry Again")
                                .setCancelable(true)
                                .setNeutralButton("OK", null)
                                .show();
                    }
                }
                else if(getActivity() instanceof TopupActivity){
                    TopupActivity topupActivity = (TopupActivity) getActivity();
                    DBModel cardInfo = topupActivity.getTravelCardInfo();
                    Double newAmount = cardInfo.getAmount() + accountController.getTravelCard().getAmount();

                    if(accountController.updateTravelCard(cardInfo.getNIC(), newAmount)){
                        new AlertDialog.Builder(getContext())
                                .setTitle("Topup Successful")
                                .setMessage("Topup completed successfully")
                                .setCancelable(true)
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(getContext(), HomeActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
                    else{
                        new AlertDialog.Builder(getContext())
                                .setTitle("Transaction Error")
                                .setMessage("Topup not compleated. Retry!")
                                .setCancelable(true)
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(getContext(), HomeActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
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
