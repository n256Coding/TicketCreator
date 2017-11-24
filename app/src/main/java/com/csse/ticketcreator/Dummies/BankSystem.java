package com.csse.ticketcreator.Dummies;

/**
 * Interface of Bank System
 *
 * @author Nishan
 * @version 1.0
 */

public interface BankSystem {
    boolean validateCardInfo(String holderName, String cardNumber, String expiryDate, String ccv);

    boolean makeTransaction(String cardNumber, String ccv, String expiryDate);
}
