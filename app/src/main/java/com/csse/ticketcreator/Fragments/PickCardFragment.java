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
import android.widget.ImageButton;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.R;


/**
 * This is the fragment which show travel cards to pick
 *
 * @author Nishan
 * @version 1.0
 */
public class PickCardFragment extends Fragment {
    private OnNextClickListener nextClickListener;
    Button btnPickCardNext, btnPickCardBack;
    ImageButton btnCard1000, btnCard750, btnCard500, btnCard250;
    AccountController accountController;


    //For use with android logger
    String TAG = "PickCardFragment";


    public PickCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_card, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            nextClickListener = (OnNextClickListener) getContext();
            btnPickCardNext = (Button) getView().findViewById(R.id.btnPickCardNext);
            btnPickCardBack = (Button) getView().findViewById(R.id.btnPickCardBack);
            btnCard250 = (ImageButton) getView().findViewById(R.id.btnCard250);
            btnCard500 = (ImageButton) getView().findViewById(R.id.btnCard500);
            btnCard750 = (ImageButton) getView().findViewById(R.id.btnCard750);
            btnCard1000 = (ImageButton) getView().findViewById(R.id.btnCard1000);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Pick card fragment next button", ex);
        } catch (NullPointerException ex) {
            Log.e(TAG, "Next button resource id not found", ex);
        }

        accountController = AccountController.getInstance();

        btnPickCardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accountController.getTravelCard().getAmount() >= 250) {
                    nextClickListener.jumpToStep(3);
                } else {
                    new AlertDialog.Builder(getContext())
                            .setCancelable(true)
                            .setTitle("No Card Selected")
                            .setMessage("Please select a card")
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });

        btnPickCardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClickListener.jumpToStep(1);
            }
        });


        btnCard250.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {
                accountController.getTravelCard().setAmount(250);
                btnCard250.setBackground(getResources().getDrawable(R.drawable.card1_1_sel));
                btnCard500.setBackground(getResources().getDrawable(R.drawable.card1_2));
                btnCard750.setBackground(getResources().getDrawable(R.drawable.card1_3));
                btnCard1000.setBackground(getResources().getDrawable(R.drawable.card1_4));
            }
        });

        btnCard500.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {
                accountController.getTravelCard().setAmount(500);
                btnCard250.setBackground(getResources().getDrawable(R.drawable.card1_1));
                btnCard500.setBackground(getResources().getDrawable(R.drawable.card1_2_sel));
                btnCard750.setBackground(getResources().getDrawable(R.drawable.card1_3));
                btnCard1000.setBackground(getResources().getDrawable(R.drawable.card1_4));
            }
        });

        btnCard750.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {
                accountController.getTravelCard().setAmount(750);
                btnCard250.setBackground(getResources().getDrawable(R.drawable.card1_1));
                btnCard500.setBackground(getResources().getDrawable(R.drawable.card1_2));
                btnCard750.setBackground(getResources().getDrawable(R.drawable.card1_3_sel));
                btnCard1000.setBackground(getResources().getDrawable(R.drawable.card1_4));
            }
        });

        btnCard1000.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {
                accountController.getTravelCard().setAmount(1000);
                btnCard250.setBackground(getResources().getDrawable(R.drawable.card1_1));
                btnCard500.setBackground(getResources().getDrawable(R.drawable.card1_2));
                btnCard750.setBackground(getResources().getDrawable(R.drawable.card1_3));
                btnCard1000.setBackground(getResources().getDrawable(R.drawable.card1_4_sel));
            }
        });
    }
}
