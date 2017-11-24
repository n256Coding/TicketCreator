package com.csse.ticketcreator;

import android.support.test.rule.ActivityTestRule;
import android.widget.GridLayout;

import com.csse.ticketcreator.Fragments.CardPaymentFragment;
import com.csse.ticketcreator.Fragments.CashPaymentFragment;
import com.csse.ticketcreator.Fragments.PaymentMethodFragment;
import com.csse.ticketcreator.Fragments.PersonalInfoFragment;
import com.csse.ticketcreator.Fragments.PickCardFragment;
import com.csse.ticketcreator.Fragments.SuccesfullPaymentFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * This test cases or done to check fragments are correctly loaded or not
 *
 * @author Nishan
 * @version 2.0
 */
public class TestFragmentsLoading {
    private TestActivity testActivity;

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class);


    @Before
    public void setUp() throws Exception {
        testActivity = activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        testActivity = null;
    }

    /**
     * Test {@link PersonalInfoFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPersonalInfoFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        PersonalInfoFragment fragment = new PersonalInfoFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtFname));
        assertNotNull(fragment.getView().findViewById(R.id.txtLname));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardNext));
    }

    /**
     * Test {@link PickCardFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPickCardFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        PickCardFragment fragment = new PickCardFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.btnCard1000));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard750));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard500));
        assertNotNull(fragment.getView().findViewById(R.id.btnCard250));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnPickCardNext));
    }

    /**
     * Test {@link PaymentMethodFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testPaymentMethodFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        PaymentMethodFragment fragment = new PaymentMethodFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.rbCard));
        assertNotNull(fragment.getView().findViewById(R.id.rbCash));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentMethodBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentMethodNext));
    }

    /**
     * Test {@link CardPaymentFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testCardPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        CardPaymentFragment fragment = new CardPaymentFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtCardHolder));
        assertNotNull(fragment.getView().findViewById(R.id.txtCardNumber));
        assertNotNull(fragment.getView().findViewById(R.id.txtExpiryDate));
        assertNotNull(fragment.getView().findViewById(R.id.txtCcv));
        assertNotNull(fragment.getView().findViewById(R.id.btnCardBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnCardNext));
    }

    /**
     * Test {@link CashPaymentFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testCashPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        CashPaymentFragment fragment = new CashPaymentFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.txtAmount));
        assertNotNull(fragment.getView().findViewById(R.id.txtFullAmount));
        assertNotNull(fragment.getView().findViewById(R.id.btnCashBack));
        assertNotNull(fragment.getView().findViewById(R.id.btnCashNext));
    }

    /**
     * Test {@link SuccesfullPaymentFragment} is launching into {@link TestActivity} correctly
     *
     * @throws NullPointerException when view resources not found
     */
    @Test
    public void testSuccessfullPaymentFragment() throws NullPointerException{
        GridLayout fragmentContainer = (GridLayout) testActivity.findViewById(R.id.test_fragment_container);
        assertNotNull(fragmentContainer);

        SuccesfullPaymentFragment fragment = new SuccesfullPaymentFragment();
        testActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();
        assertNotNull(fragment.getView().findViewById(R.id.imgQrCode));
        assertNotNull(fragment.getView().findViewById(R.id.txtSuccesfullMessage));
        assertNotNull(fragment.getView().findViewById(R.id.txtTransactionNumber));
        assertNotNull(fragment.getView().findViewById(R.id.btnPaymentFinish));
    }
}