package com.csse.ticketcreator.Listeners;

import com.csse.ticketcreator.NewCardActivity;

/**
 * This interface is to make communication between Activities and Fragments
 *
 * @author Nishan
 * @version 1.0
 */

public interface OnNextClickListener {
    /**
     * @param step the step that want to jump into
     *             Step 1 = Personal Info
     *             Step 2 = Pick a card
     *             Step 3 = Select payment method
     *             Step 4 = Pay by cash
     *             Step 5 = Pay by credit card
     *             Step 6 = Payment success and card creation
     * @see com.csse.ticketcreator.Controllers.FragmentHandler
     * @see NewCardActivity
     */
    void jumpToStep(int step);
}
