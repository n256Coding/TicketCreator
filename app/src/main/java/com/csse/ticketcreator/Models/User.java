package com.csse.ticketcreator.Models;

/**
 * Created by Nishan on 11/11/2017.
 * @author Nishan
 * @version 1.0
 */

public class User {
    public String firstName;
    public String lastName;
    public String contactNo;
    public String nicNo;

    public User(){

    }

    public User(String firstName, String lastName, String contactNo, String nicNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
    }
}
