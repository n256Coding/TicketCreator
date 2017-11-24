package com.csse.ticketcreator.Controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.csse.ticketcreator.Fragments.CardPaymentFragment;
import com.csse.ticketcreator.Fragments.CashPaymentFragment;
import com.csse.ticketcreator.Fragments.PaymentMethodFragment;
import com.csse.ticketcreator.Fragments.PersonalInfoFragment;
import com.csse.ticketcreator.Fragments.PickCardFragment;
import com.csse.ticketcreator.Fragments.ReferenceNoRequestFragment;
import com.csse.ticketcreator.Fragments.SuccesfullPaymentFragment;

import java.util.HashMap;

/**
 * This class is to manipulate fragments inside a activity. This will coordinate fragments
 * and keep them in under control.
 *
 * @author Nishan
 * @version 2.0
 */

public class FragmentHandler {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int containerResId;

    //Keep key of current loaded fragment
    private String currentFragmentKey = "";

    //Keep fragments with a unique key
    private HashMap<String, Fragment> fragmentRegistry;

    public FragmentHandler(FragmentManager fragmentManager, int containerResId) {
        this.fragmentManager = fragmentManager;
        this.containerResId = containerResId;

        fragmentRegistry = new HashMap<>();
        fragmentRegistry.put("personalInfoFrag", new PersonalInfoFragment());
        fragmentRegistry.put("pickCardFrag", new PickCardFragment());
        fragmentRegistry.put("paymentMethodFrag", new PaymentMethodFragment());
        fragmentRegistry.put("cashPaymentFrag", new CashPaymentFragment());
        fragmentRegistry.put("cardPaymentFrag", new CardPaymentFragment());
        fragmentRegistry.put("successfulPaymentFrag", new SuccesfullPaymentFragment());
        fragmentRegistry.put("refNoRequestFrag", new ReferenceNoRequestFragment());
    }

    /**
     * To replace existing fragment with new fragment in placeholder
     *
     * @param step step number in wizard
     */
    public void replaceFragment(int step) {
        fragmentTransaction = this.fragmentManager.beginTransaction();
        switch (step) {
            case 1:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("personalInfoFrag"));
                currentFragmentKey = "personalInfoFrag";
                break;
            case 2:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("pickCardFrag"));
                currentFragmentKey = "pickCardFrag";
                break;
            case 3:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("paymentMethodFrag"));
                currentFragmentKey = "paymentMethodFrag";
                break;
            case 4:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("cashPaymentFrag"));
                currentFragmentKey = "cashPaymentFrag";
                break;
            case 5:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("cardPaymentFrag"));
                currentFragmentKey = "cardPaymentFrag";
                break;
            case 6:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("successfulPaymentFrag"));
                currentFragmentKey = "successfulPaymentFrag";
                break;
            case 7:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("refNoRequestFrag"));
                currentFragmentKey = "refNoRequestFrag";
            default:
                fragmentTransaction.replace(this.containerResId,
                        fragmentRegistry.get("personalInfoFrag"));
                currentFragmentKey = "personalInfoFrag";
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * To initialize new fragment into placeholder
     *
     * @param step the step want to jump
     */
    public void addFragment(int step) {
        fragmentTransaction = this.fragmentManager.beginTransaction();
        switch (step) {
            case 1:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("personalInfoFrag"));
                currentFragmentKey = "personalInfoFrag";
                break;
            case 2:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("pickCardFrag"));
                currentFragmentKey = "pickCardFrag";
                break;
            case 3:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("paymentMethodFrag"));
                currentFragmentKey = "paymentMethodFrag";
                break;
            case 4:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("cashPaymentFrag"));
                currentFragmentKey = "cashPaymentFrag";
                break;
            case 5:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("cardPaymentFrag"));
                currentFragmentKey = "cardPaymentFrag";
                break;
            case 6:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("successfulPaymentFrag"));
                currentFragmentKey = "successfulPaymentFrag";
                break;
            case 7:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("refNoRequestFrag"));
                currentFragmentKey = "refNoRequestFrag";
                break;
            default:
                fragmentTransaction.add(this.containerResId,
                        fragmentRegistry.get("personalInfoFrag"));
                currentFragmentKey = "personalInfoFrag";
                break;
        }
        fragmentTransaction.commit();
    }

    public HashMap<String, Fragment> getFragmentRegistry() {
        return this.fragmentRegistry;
    }

    public Fragment getCurrentFragment() {
        return fragmentRegistry.get(currentFragmentKey);
    }

    public String getCurrentFragmentKey() {
        return currentFragmentKey;
    }
}
