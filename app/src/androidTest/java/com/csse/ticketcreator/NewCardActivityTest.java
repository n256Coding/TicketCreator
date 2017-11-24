package com.csse.ticketcreator;

import android.support.test.rule.ActivityTestRule;
import android.widget.GridLayout;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Controllers.FragmentHandler;
import com.csse.ticketcreator.Controllers.UserController;
import com.csse.ticketcreator.Fragments.CardPaymentFragment;
import com.csse.ticketcreator.Fragments.CashPaymentFragment;
import com.csse.ticketcreator.Fragments.PaymentMethodFragment;
import com.csse.ticketcreator.Fragments.PersonalInfoFragment;
import com.csse.ticketcreator.Fragments.PickCardFragment;
import com.csse.ticketcreator.Fragments.SuccesfullPaymentFragment;
import com.csse.ticketcreator.Models.TravelCard;
import com.csse.ticketcreator.Models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @author Nishan
 */
public class NewCardActivityTest {
    @Rule
    public ActivityTestRule<NewCardActivity> activityTestRule = new ActivityTestRule<NewCardActivity>(NewCardActivity.class);
    private NewCardActivity newCardActivity;
    private FragmentHandler fragmentHandler;

    @Before
    public void setUp() throws Exception {
        newCardActivity = activityTestRule.getActivity();
        fragmentHandler = new FragmentHandler(newCardActivity.getSupportFragmentManager(), R.id.fragment_container);
    }

    @After
    public void tearDown() throws Exception {
        newCardActivity = null;
        fragmentHandler = null;
    }

    /**
     * Test jumpToStep method is working or not
     */
    @Test
    public void testJumpToStep(){
        fragmentHandler.addFragment(1);
        GridLayout gridLayout = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(gridLayout);
        assertTrue(gridLayout.getChildCount() == 1);
    }

    /**
     * Test making new card
     */
    @Test
    public void testMakeNewCard(){
        AccountController accountController = AccountController.getInstance();
        UserController userController = UserController.getInstance();
        TravelCard travelCard = new TravelCard();
        User user = new User();

        travelCard.setAmount(1500);
        travelCard.setPaymentType("cash");
        travelCard.setCreditCardCcv("542");
        user.setFirstName("Test FirstName");
        user.setLastName("Test LastName");
        user.setContactNo("0745458562");
        user.setNicNo("452162548465V");

        accountController.setTravelCardInformation(travelCard);
        userController.setUser(user);

        boolean isAccountCreated = accountController.makeTravelCard();
        assertTrue(isAccountCreated);
    }


}