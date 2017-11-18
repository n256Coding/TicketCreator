package com.csse.ticketcreator.Models;

/**
 * Created by Nishan on 11/15/2017.
 */

public class DBModel {
    private String first_name;
    private String last_name;
    private String contact_number;
    private String nic_number;
    private double amount;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getNic_number() {
        return nic_number;
    }

    public void setNic_number(String nic_number) {
        this.nic_number = nic_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
