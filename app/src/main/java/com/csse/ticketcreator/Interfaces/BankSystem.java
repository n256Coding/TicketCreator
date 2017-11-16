package com.csse.ticketcreator.Interfaces;

/**
 * @author Nishan
 * @version 1.0
 */

public interface BankSystem {
    public boolean validateCardInfo(String holderName, String cardNumber, String expiryDate, String ccv);
    public boolean makeTransaction(String cardNumber, String ccv, String expiryDate);
}
