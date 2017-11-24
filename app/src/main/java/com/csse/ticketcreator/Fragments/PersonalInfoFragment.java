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
import android.widget.EditText;

import com.csse.ticketcreator.Controllers.UserController;
import com.csse.ticketcreator.Helpers.ValidationHelper;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.User;
import com.csse.ticketcreator.R;

/**
 * This is a UI fragment which contains form to enter
 * user information inorder to create travel card
 *
 * @author Nishan
 * @version 3.2
 */
public class PersonalInfoFragment extends Fragment {
    Button btnPersonInfoNext;
    EditText txtFname, txtLname, txtContactNo, txtNicNo;
    OnNextClickListener nextClickListener;
    UserController userController;

    //For use of android logger
    String TAG = "PersonalInfoFragment";


    public PersonalInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            nextClickListener = (OnNextClickListener) getContext();
            btnPersonInfoNext = (Button) getView().findViewById(R.id.btnPickCardNext);
            txtFname = (EditText) getView().findViewById(R.id.txtFname);
            txtLname = (EditText) getView().findViewById(R.id.txtLname);
            txtContactNo = (EditText) getView().findViewById(R.id.txtContactNo);
            txtNicNo = (EditText) getView().findViewById(R.id.txtNicNo);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Personal info fragment next button", ex);
        } catch (NullPointerException ex) {
            Log.e(TAG, "Next button resource id not found", ex);
        }

        btnPersonInfoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(txtFname.getText().toString().trim(),
                        txtLname.getText().toString().trim(),
                        txtContactNo.getText().toString().trim(),
                        txtNicNo.getText().toString().trim());
                userController = UserController.getInstance();


                if (ValidationHelper.validatePersonalInfo(txtFname, txtLname, txtContactNo, txtNicNo)
                        && userController.checkUserValidity(user)) {
                    userController.setUser(user);
                    nextClickListener.jumpToStep(2);
                } else {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Incorrect user info")
                            .setMessage("Please enter correct user information")
                            .setCancelable(true)
                            .setNeutralButton("OK", null)
                            .show();
                }
            }
        });
    }

}
