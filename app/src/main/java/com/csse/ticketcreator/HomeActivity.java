package com.csse.ticketcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.csse.ticketcreator.Controllers.AccountController;
import com.csse.ticketcreator.Controllers.UserController;
import com.csse.ticketcreator.Models.User;

/**
 * This is the initial activity of the system. All processes starts from here
 *
 * @author Nishan
 * @version 3.5
 */
public class HomeActivity extends AppCompatActivity {
    ImageButton btnNewCard, btnTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnNewCard = (ImageButton) findViewById(R.id.btnNewCard);
        btnTopup = (ImageButton) findViewById(R.id.btnTopup);

        btnNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewCardActivity.class);
                AccountController.getInstance().resetInstance();
                startActivity(intent);
            }
        });

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ScannerActivity.class);
                AccountController.getInstance().resetInstance();
                startActivity(intent);
            }
        });
    }

}
