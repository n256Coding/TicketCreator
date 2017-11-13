package com.csse.ticketcreator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anton46.stepsview.StepsView;

public class MainActivity extends AppCompatActivity {
    Button btnNext;
    StepsView stepsView;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.btnNext);
        stepsView = (StepsView) findViewById(R.id.stepsView);

        fragmentManager = getSupportFragmentManager();
        //fragmentTransaction = fragmentManager.beginTransaction();
        /*fragment = PersonalInfoFragment.newInstance("", "");

        fragmentTransaction.add(R.id.placeholderFragment, fragment);
        fragmentTransaction.commit();*/

        String[] steps = {"step 1", "Step2", "Step 3", "Step 4", "Step 5"};
        stepsView.setLabels(steps)
                .setBarColorIndicator(MainActivity.this.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setCompletedPosition(0)
                .drawView();
        stepsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepsView stepsView1 = (StepsView) view;
                Toast.makeText(MainActivity.this, "Clicked"+stepsView1.getCompletedPosition(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void doStuff(View view){
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
        String[] steps = {"step 1", "Step2", "Step 3", "Step 4", "Step 5"};
        stepsView.setLabels(steps)
                .setBarColorIndicator(MainActivity.this.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(MainActivity.this.getResources().getColor(R.color.orange))
                .setCompletedPosition(0)
                .drawView();
    }
}
