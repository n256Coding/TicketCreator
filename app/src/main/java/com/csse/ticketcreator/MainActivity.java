package com.csse.ticketcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.anton46.stepsview.StepsView;
import com.csse.ticketcreator.Controllers.FragmentHandler;
import com.csse.ticketcreator.Listeners.OnNextClickListener;

public class MainActivity extends AppCompatActivity
        implements OnNextClickListener {
    Button btnNext;
    StepsView stepsView;
    FragmentHandler fragmentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.btnPickCardNext);
        stepsView = (StepsView) findViewById(R.id.stepsView);

        fragmentHandler = new FragmentHandler(getSupportFragmentManager());

        //Load initial fragment into activity
        fragmentHandler.addFragment(1);

        String[] steps = {"Step 1", "Step 2", "Step 3", "Step 4", "Step 5"};
        stepsView.setLabels(steps)
                .setBarColorIndicator(MainActivity.this.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setCompletedPosition(0)
                .drawView();
    }

    public void doStuff(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        String[] steps = {"Step 1", "Step 2", "Step 3", "Step 4", "Step 5"};
        stepsView.setLabels(steps)
                .setBarColorIndicator(MainActivity.this.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setCompletedPosition(0)
                .drawView();
    }

    public void changeFragmentTo(int step) {
        fragmentHandler.replaceFragment(step);
        stepsView.setCompletedPosition(step - 1)
                .drawView();
    }

    @Override
    public void onStep1NextClick() {
        changeFragmentTo(2);
    }

    @Override
    public void onStep2NextClick() {
        changeFragmentTo(3);
    }

    @Override
    public void onStep3NextClick() {
        changeFragmentTo(4);
    }

    @Override
    public void onStep4NextClick() {
        changeFragmentTo(5);
    }

    @Override
    public void onStep5NextClick() {
        changeFragmentTo(6);
    }
}
