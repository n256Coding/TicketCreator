package com.csse.ticketcreator.Models;

/**
 * Created by Nishan on 11/11/2017.
 * @author Nishan
 * @version 2.0
 */

public class User {
    private String firstName;
    private String lastName;
    private String contactNo;
    private String nicNo;

    public User(){

    }

    public User(String firstName, String lastName, String contactNo, String nicNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }
}
