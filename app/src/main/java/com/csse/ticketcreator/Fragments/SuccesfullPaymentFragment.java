package com.csse.ticketcreator.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Controllers.UserController;
import com.csse.ticketcreator.Helpers.QRGenerator;
import com.csse.ticketcreator.R;
import com.google.zxing.WriterException;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuccesfullPaymentFragment extends Fragment {
    AccountController accountController;
    UserController userController;
    ImageView qrCodeViewer;
    TextView txtTransactionDate, txtTransactionDetails, txtTransactionNumber, txtOrderTotal;
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        qrCodeViewer = (ImageView) getView().findViewById(R.id.imgQrCode);
        accountController = AccountController.getInstance();
        userController = UserController.getInstance();

        try {
            qrCodeViewer.setImageBitmap(QRGenerator.getQRCodeBitmap(accountController.getTransactionId(), 150));
        } catch (WriterException e) {
            Log.e(TAG, "Error while generating QR Code", e);
        }

        txtTransactionDate = (TextView) getView().findViewById(R.id.txtTransactionDate);
        txtTransactionDetails = (TextView) getView().findViewById(R.id.txtTransactionDetails);
        txtTransactionNumber = (TextView) getView().findViewById(R.id.txtTransactionNumber);
        txtOrderTotal = (TextView) getView().findViewById(R.id.txtOrderTotal);

        txtTransactionDate.setText(new Date().toString());
        txtTransactionDetails.setText(userController.getUser().getFirstName());
        txtTransactionNumber.setText(accountController.getTransactionId());
        txtOrderTotal.setText(String.valueOf(accountController.getTotalCharge()));

        //TODO: Need to implement function for button - Account.clearInstance()
    }
}
