package com.csse.ticketcreator.Helpers;

import android.util.Log;

import com.csse.ticketcreator.Models.DBModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * This class is used to make connection with firebase database.
 *
 * @author Nishan
 * @version 2.0
 */

public class DatabaseHelper {
    private DatabaseReference temporaryReference;

    /**
     * Insert a new Travel Card into database
     *
     * @param DBModel object consists of relevant data of travel card to be mapped into database
     * @return reference to the created object in database
     */
    public DatabaseReference insertTravelCard(DBModel DBModel) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = database.child("Users").child(DBModel.getNIC());
        userRef.setValue(DBModel);
        return temporaryReference = userRef;
    }

    /**
     * Update amount of the database
     *
     * @param amount amount to be updated
     * @return reference to the created object in database
     */
    public DatabaseReference updateTravelAmount(String dbRefKey, Double amount){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = database.child("Users").child(dbRefKey).child("amount");
        userRef.setValue(amount);
        return temporaryReference = userRef;
    }

    /**
     * This method will return data of Travel Card
     *
     * @param travelCardId ID of the Travel Card
     * @return DBModel object consists Information of given Travel Card
     */
    public DBModel getTravelCard(String travelCardId) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(travelCardId);
        final DBModel databaseModel = new DBModel();
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                databaseModel.setAmount(Double.parseDouble(dataSnapshot.child("amount").getValue().toString()));
                databaseModel.setFirstName(dataSnapshot.child("firstName").getValue(String.class));
                databaseModel.setLastName(dataSnapshot.child("lastName").getValue(String.class));
                databaseModel.setNIC(dataSnapshot.child("nic").getValue(String.class));
                databaseModel.setContactNo(dataSnapshot.child("contactNo").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(databaseModel.getFirstName() == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e("TAG", "Thread stop");
            }
        }
        return databaseModel;
    }

    /**
     * Get database reference to specific Travel Card
     *
     * @param travelCardId ID of the travel card.
     * @return database reference to the given Travel Card
     */
    public DatabaseReference getDBRefOfTravelCard(String travelCardId) {
        return FirebaseDatabase.getInstance().getReference().child("Users").child(travelCardId);
    }

    public String getCardId() {
        return temporaryReference.getKey();
    }
}
