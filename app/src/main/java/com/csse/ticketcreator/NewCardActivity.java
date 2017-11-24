package com.csse.ticketcreator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.anton46.stepsview.StepsView;
import com.csse.ticketcreator.Controllers.FragmentHandler;
import com.csse.ticketcreator.Listeners.OnNextClickListener;

/**
 * This activity is to make a new account (Travel Card). User is given a wizard way steps to
 * make account. Its done by loading multiple fragments in this activity.
 *
 * @author Nishan
 * @version 2.2
 */
public class NewCardActivity extends AppCompatActivity implements OnNextClickListener {
    Button btnNext;
    StepsView stepsView;
    FragmentHandler fragmentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.btnPickCardNext);
        stepsView = (StepsView) findViewById(R.id.stepsView);

        //This fragment handler is a class which handles logic related to fragments
        fragmentHandler = new FragmentHandler(getSupportFragmentManager(), R.id.fragment_container);

        //Load initial fragment into activity
        fragmentHandler.addFragment(1);

        String[] steps = {"Step 1", "Step 2", "Step 3", "Step 4", "Step 5"};
        //noinspection deprecation
        stepsView.setLabels(steps)
                .setBarColorIndicator(NewCardActivity.this.getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(NewCardActivity.this.getResources().getColor(R.color.orange))
                .setLabelColorIndicator(NewCardActivity.this.getResources().getColor(R.color.orange))
                .setCompletedPosition(0)
                .drawView();
    }

    /**
     *
     * @param step the step that want to jump into
     *             Step 1 = Personal Info
     *             Step 2 = Pick a card
     *             Step 3 = Select payment method
     *             Step 4 = Pay by cash
     *             Step 5 = Pay by credit card
     *             Step 6 = Payment success and card creation
     */
    @Override
    public void jumpToStep(int step) {
        if (step == 99) {
            finish();
            return;
        }
        fragmentHandler.replaceFragment(step);

        //To handle IndexOutOfBoundException in StepViewer
        switch (step) {
            case 5:
                step--;
                break;
            case 6:
                step--;
                break;
        }
        stepsView.setCompletedPosition(step - 1)
                .drawView();
    }
}
