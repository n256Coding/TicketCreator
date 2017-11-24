package com.csse.ticketcreator.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Helpers.ValidationHelper;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.DBModel;
import com.csse.ticketcreator.Models.TravelCard;
import com.csse.ticketcreator.NewCardActivity;
import com.csse.ticketcreator.R;
import com.csse.ticketcreator.TopupActivity;

/**
 * This is a fragment contains form to fill credit card details.
 *
 * @author Nishan
 * @version 2.3
 */
public class CardPaymentFragment extends Fragment {
    OnNextClickListener nextClickListener;
    AccountController accountController;
    Button btnCardNext, btnCardBack;
    EditText txtCardHolder, txtCardNumber, txtExpiryDate, txtCcv;
    //For use of logger
    private static final String TAG = "CardPaymentFrag";

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

        try {
            nextClickListener = (OnNextClickListener) getContext();
        } catch (ClassCastException ex) {
            Log.e(TAG, "Unable to get context of activity", ex);
        }

        btnCardNext = (Button) getView().findViewById(R.id.btnCardNext);
        btnCardBack = (Button) getView().findViewById(R.id.btnCardBack);
        txtCardHolder = (EditText) getView().findViewById(R.id.txtCardHolder);
        txtCardNumber = (EditText) getView().findViewById(R.id.txtCardNumber);
        txtExpiryDate = (EditText) getView().findViewById(R.id.txtExpiryDate);
        txtCcv = (EditText) getView().findViewById(R.id.txtCcv);
        accountController = AccountController.getInstance();

        btnCardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TravelCard travelCard = accountController.getTravelCard();
                travelCard.setCreditCardHolderName(txtCardHolder.getText().toString().trim());
                travelCard.setCreditCardNumber(txtCardNumber.getText().toString().trim());
                travelCard.setCreditCardExpiryDate(txtExpiryDate.getText().toString().trim());
                travelCard.setCreditCardCcv(txtCcv.getText().toString().trim());

                if (!ValidationHelper.validateCardInfo(txtCardHolder, txtCardNumber, txtExpiryDate, txtCcv)) {
                    return;
                }

                if (accountController.verifyCreditCardForPayments(travelCard).equals("success")) {
                    accountController.setTravelCardInformation(travelCard);

                    //If fragment is in New card creation process, do this
                    if(getActivity() instanceof NewCardActivity){
                        if (accountController.makeTravelCard()) {
                            //This is custom listener to communicate with main activity of this fragment
                            nextClickListener.jumpToStep(6);
                        }
                    }
                    //If fragment is in Top process, do this
                    else if(getActivity() instanceof TopupActivity){
                        TopupActivity activity = (TopupActivity) getActivity();
                        DBModel travelCardInfo = activity.getTravelCardInfo();
                        Double newAmount = travelCardInfo.getAmount() + accountController.getTravelCard().getAmount();
                        if(accountController.updateTravelCard(travelCardInfo.getNIC(), newAmount)){
                            new AlertDialog.Builder(getContext())
                                    .setTitle("Topup sccessfull")
                                    .setMessage("topup is succesfully compleated")
                                    .setCancelable(false)
                                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            nextClickListener.jumpToStep(99);
                                        }
                                    })
                                    .show();
                        }
                    }

                } else {
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
