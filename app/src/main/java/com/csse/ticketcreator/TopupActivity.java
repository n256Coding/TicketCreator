package com.csse.ticketcreator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.csse.ticketcreator.Controllers.FragmentHandler;
import com.csse.ticketcreator.Helpers.DatabaseHelper;
import com.csse.ticketcreator.Listeners.OnNextClickListener;
import com.csse.ticketcreator.Models.DBModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * @author Sampath
 * @version 1.0
 */
public class TopupActivity extends AppCompatActivity implements OnNextClickListener {
    FragmentHandler fragmentHandler;
    String travelCardId = "";
    DBModel dbModel = new DBModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentHandler = new FragmentHandler(getSupportFragmentManager(), R.id.fragment_container2);
        if (getIntent().hasExtra("travelCardId")) {
            travelCardId = getIntent().getExtras().getString("travelCardId");
        }

        final DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.getDBRefOfTravelCard(travelCardId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dbModel.setFirstName(dataSnapshot.child("firstName").getValue(String.class));
                dbModel.setLastName(dataSnapshot.child("lastName").getValue(String.class));
                dbModel.setAmount(Double.parseDouble(dataSnapshot.child("amount").getValue().toString()));
                dbModel.setNIC(dataSnapshot.child("nic").getValue(String.class));
                dbModel.setContactNo(dataSnapshot.child("contactNo").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        fragmentHandler.addFragment(7);
    }

    public DBModel getTravelCardInfo() {
        return this.dbModel;
    }

    @Override
    public void jumpToStep(int step) {
        if (step == 99) {
            finish();
        }
        fragmentHandler.replaceFragment(step);
    }
}
