package com.csse.ticketcreator;

import android.support.test.rule.ActivityTestRule;
import android.widget.ImageButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * This test is to check home activity is working or not
 *
 * @author Nishan
 * @version 1.0
 */
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);
    private HomeActivity homeActivity;

    @Before
    public void setUp() throws Exception {
        homeActivity = activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        homeActivity = null;
    }

    /**
     * Test to check weather main buttons in home screen are available or not
     *
     * @throws Exception
     */
    @Test
    public void checkMainButtons() throws Exception {
        ImageButton btnNewCard = (ImageButton) homeActivity.findViewById(R.id.btnNewCard);
        ImageButton btnTopUp = (ImageButton) homeActivity.findViewById(R.id.btnTopup);

        assertNotNull(btnNewCard);
        assertNotNull(btnTopUp);
    }


}