package com.csse.ticketcreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csse.ticketcreator.Listeners.OnNextClickListener;

/**
 * This activity is to use in test cases.
 * All fragments are loaded into this activity for test successful loading of fragments
 */
public class TestActivity extends AppCompatActivity implements OnNextClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public void jumpToStep(int step) {

    }
}
