package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Controllers.UserController;
import com.csse.ticketcreator.Helpers.QRGenerator;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;
import com.google.zxing.WriterException;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuccesfullPaymentFragment extends Fragment {
    OnNextClickListener nextClickListener;
    AccountController accountController;
    UserController userController;
    ImageView qrCodeViewer;
    TextView txtTransactionDate, txtTransactionDetails, txtTransactionNumber, txtOrderTotal;
    Button btnPaymentFinish;
    String TAG = "SuccesfulPayFragment";

    public SuccesfullPaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_succesfull_payment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nextClickListener = (OnNextClickListener) getContext();
        qrCodeViewer = (ImageView) getView().findViewById(R.id.imgQrCode);
        txtTransactionDate = (TextView) getView().findViewById(R.id.txtTransactionDate);
        txtTransactionDetails = (TextView) getView().findViewById(R.id.txtTransactionDetails);
        txtTransactionNumber = (TextView) getView().findViewById(R.id.txtTransactionNumber);
        txtOrderTotal = (TextView) getView().findViewById(R.id.txtOrderTotal);
        btnPaymentFinish = (Button) getView().findViewById(R.id.btnPaymentFinish);

        accountController = AccountController.getInstance();
        userController = UserController.getInstance();
        try {
            qrCodeViewer.setImageBitmap(QRGenerator.getQRCodeBitmap(accountController.getTransactionId(), 150));
        } catch (WriterException e) {
            Log.e(TAG, "Error while generating QR Code", e);
        }

        txtTransactionDate.setText(new Date().toString());
        txtTransactionDetails.setText(userController.getUser().getFirstName());
        txtTransactionNumber.setText(accountController.getTransactionId());
        txtOrderTotal.setText(String.valueOf(accountController.getTotalCharge()));

        btnPaymentFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClickListener.jumpToStep(99);
            }
        });
    }
}
