package com.csse.ticketcreator.Helpers;

import com.csse.ticketcreator.Models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author Nishan
 * @version 1.0
 */

public class DatabaseHelper {

    public void addToDatabase() {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = database.child("users");
        DatabaseReference newUserRef = userRef.push();
        User user = new User("Michal", "Knight", "0745652548", "6584585426526");
        newUserRef.setValue(user);
    }
}
