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

    /**
     * Test {@link PersonalInfoFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPersonalInfoFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        PersonalInfoFragment fragment = new PersonalInfoFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtFname));
        assertNotNull(fragment.getView().findViewById(R.id.txtLname));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardNext));
    }

    /**
     * Test {@link PickCardFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPickCardFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        PickCardFragment fragment = new PickCardFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.btnCard1000));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard750));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard500));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard250));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardNext));
    }

    /**
     * Test {@link PaymentMethodFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPaymentMethodFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        PaymentMethodFragment fragment = new PaymentMethodFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.rbCard));
        assertNotNull(fragment.getView().findViewById(R.id.rbCash));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentMethodBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentMethodNext));
    }

    /**
     * Test {@link CardPaymentFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testCardPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        CardPaymentFragment fragment = new CardPaymentFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtCardHolder));
        assertNotNull(fragment.getView().findViewById(R.id.txtCardNumber));
        assertNotNull(fragment.getView().findViewById(R.id.txtExpiryDate));
        assertNotNull(fragment.getView().findViewById(R.id.txtCcv));
        assertNotNull(fragment.getView().findViewById(R.id.btnCardBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnCardNext));
    }

    /**
     * Test {@link CashPaymentFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testCashPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        CashPaymentFragment fragment = new CashPaymentFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtAmount));
        assertNotNull(fragment.getView().findViewById(R.id.txtFullAmount));
        assertNotNull(fragment.getView().findViewById(R.id.btnCashBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnCashNext));
    }

    /**
     * Test {@link SuccesfullPaymentFragment} is launching into {@link NewCardActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testSuccessfullPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) newCardActivity.findViewById(R.id.fragment_container);
        assertNotNull(fragmentContainer);

        SuccesfullPaymentFragment fragment = new SuccesfullPaymentFragment();
        newCardActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.imgQrCode));
        assertNotNull(fragment.getView().findViewById(R.id.txtSuccesfullMessage));
        assertNotNull(fragment.getView().findViewById(R.id.txtTransactionNumber));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentFinish));
    }
}