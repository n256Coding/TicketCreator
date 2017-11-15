package com.csse.ticketcreator.Controllers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.csse.ticketcreator.Fragments.CardPaymentFragment;
import com.csse.ticketcreator.Fragments.CashPaymentFragment;
import com.csse.ticketcreator.Fragments.PaymentMethodFragment;
import com.csse.ticketcreator.Fragments.PersonalInfoFragment;
import com.csse.ticketcreator.Fragments.PickCardFragment;
import com.csse.ticketcreator.Fragments.SuccesfullPaymentFragment;
import com.csse.ticketcreator.R;

/**
 * @author Nishan
 * @version 1.0
 */

public class FragmentHandler {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public FragmentHandler(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void replaceFragment(int step) {
        fragmentTransaction = this.fragmentManager.beginTransaction();
        switch (step) {
            case 1:
                fragmentTransaction.replace(R.id.fragment_container, new PersonalInfoFragment());
                break;
            case 2:
                fragmentTransaction.replace(R.id.fragment_container, new PickCardFragment());
                break;
            case 3:
                fragmentTransaction.replace(R.id.fragment_container, new PaymentMethodFragment());
                break;
            case 4:
                fragmentTransaction.replace(R.id.fragment_container, new CashPaymentFragment());
                break;
            case 5:
                fragmentTransaction.replace(R.id.fragment_container, new CardPaymentFragment());
                break;
            case 6:
                fragmentTransaction.replace(R.id.fragment_container, new SuccesfullPaymentFragment());
                break;
            default:
                fragmentTransaction.replace(R.id.fragment_container, new PickCardFragment());
                break;
        }
        fragmentTransaction.commit();
    }

    public void addFragment(int step){
        fragmentTransaction = this.fragmentManager.beginTransaction();
        switch (step) {
            case 1:
                fragmentTransaction.add(R.id.fragment_container, new PersonalInfoFragment());
                break;
            case 2:
                fragmentTransaction.add(R.id.fragment_container, new PickCardFragment());
                break;
            case 3:
                fragmentTransaction.add(R.id.fragment_container, new PaymentMethodFragment());
                break;
            case 4:
                fragmentTransaction.add(R.id.fragment_container, new CashPaymentFragment());
                break;
            case 5:
                fragmentTransaction.add(R.id.fragment_container, new CardPaymentFragment());
                break;
            case 6:
                fragmentTransaction.add(R.id.fragment_container, new SuccesfullPaymentFragment());
                break;
            default:
                fragmentTransaction.add(R.id.fragment_container, new PickCardFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
