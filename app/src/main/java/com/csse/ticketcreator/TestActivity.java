package com.csse.ticketcreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csse.ticketcreator.Listeners.OnNextClickListener;

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
