package com.csse.ticketcreator;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.csse.ticketcreator.Controllers.FragmentHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Sampath
 * @version 1.0
 */
public class TopupActivityTest {
    @Rule
    public ActivityTestRule<TopupActivity> activityTestRule = new ActivityTestRule<TopupActivity>(TopupActivity.class);
    private TopupActivity topupActivity;
    private FragmentHandler fragmentHandler;

    @Before
    public void setUp() throws Exception {
        topupActivity = activityTestRule.getActivity();
    }

    @Test
    public void topUpLaunch() {
        View view = topupActivity.findViewById(R.id.fragment_container2);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        topupActivity = null;
        fragmentHandler = null;
    }

}