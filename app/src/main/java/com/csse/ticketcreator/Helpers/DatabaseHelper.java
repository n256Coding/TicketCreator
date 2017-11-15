package com.csse.ticketcreator.Helpers;

import com.csse.ticketcreator.Models.Account;
import com.csse.ticketcreator.Models.DBModel;
import com.csse.ticketcreator.Models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author Nishan
 * @version 1.4
 */

public class DatabaseHelper {
    private DatabaseReference temporaryReference;

    public DatabaseReference addUserToDatabase(User user){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = database.child("users");
        DatabaseReference newUserRef = userRef.push();
        newUserRef.setValue(user);
        return temporaryReference = newUserRef;
    }

    public DatabaseReference addAccountToUser(Account account){
        temporaryReference.setValue(account);
        return temporaryReference;
    }

    public DatabaseReference addToDatabase(DBModel dbModel){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = database.child("users");
        DatabaseReference newUserRef = userRef.push();
        newUserRef.setValue(dbModel);
        return temporaryReference = newUserRef;
    }

    public String getGeneratedKey(){
        return temporaryReference.getKey();
    }
}