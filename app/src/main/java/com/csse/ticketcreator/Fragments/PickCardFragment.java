package com.csse.ticketcreator.Fragments;


import android.graphics.Color;
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
 * @version 1.0
 * @author Nishan
 */
public class PickCardFragment extends Fragment {
    private OnNextClickListener nextClickListener;
    Button btnPickCardNext;
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
                if(accountController.getAccount().amount >= 250){
                    nextClickListener.jumpToStep(3);
                }
                else{
                    new AlertDialog.Builder(getContext())
                            .setCancelable(true)
                            .setTitle("No Card Selected")
                            .setMessage("Please select a card")
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });

        btnCard250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountController.getAccount().amount = 250;
                btnCard250.setBackgroundColor(Color.GREEN);
                btnCard500.setBackgroundColor(Color.LTGRAY);
                btnCard750.setBackgroundColor(Color.LTGRAY);
                btnCard1000.setBackgroundColor(Color.LTGRAY);
            }
        });

        btnCard500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountController.getAccount().amount = 500;
                btnCard250.setBackgroundColor(Color.LTGRAY);
                btnCard500.setBackgroundColor(Color.GREEN);
                btnCard750.setBackgroundColor(Color.LTGRAY);
                btnCard1000.setBackgroundColor(Color.LTGRAY);
            }
        });

        btnCard750.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountController.getAccount().amount = 750;
                btnCard250.setBackgroundColor(Color.LTGRAY);
                btnCard500.setBackgroundColor(Color.LTGRAY);
                btnCard750.setBackgroundColor(Color.GREEN);
                btnCard1000.setBackgroundColor(Color.LTGRAY);
            }
        });

        btnCard1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountController.getAccount().amount = 1000;
                btnCard250.setBackgroundColor(Color.LTGRAY);
                btnCard500.setBackgroundColor(Color.LTGRAY);
                btnCard750.setBackgroundColor(Color.LTGRAY);
                btnCard1000.setBackgroundColor(Color.GREEN);
            }
        });
    }
}
