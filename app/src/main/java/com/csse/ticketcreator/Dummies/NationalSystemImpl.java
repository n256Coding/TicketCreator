package com.csse.ticketcreator.Dummies;

/**
 * @author Nishan
 * @version 1.0
 */

public class NationalSystemImpl implements NationalSystem {
    @Override
    public boolean validateUser(String fname, String lname, String nic) {
        if(!fname.isEmpty() && !lname.isEmpty() && !nic.isEmpty())
            return true;
        else
            return false;
    }
}
