package com.csse.ticketcreator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.csse.ticketcreator.Controllers.AccountController;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * @author Sampath
 * @version 1.2
 */
public class ScannerActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    ZBarScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(ScannerActivity.this,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(ScannerActivity.this,
                    android.Manifest.permission.CAMERA)) {
            } else {
                ActivityCompat.requestPermissions(ScannerActivity.this,
                        new String[]{android.Manifest.permission.CAMERA}, 1);
            }
        }
        scannerView = new ZBarScannerView(ScannerActivity.this);
        setContentView(scannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(ScannerActivity.this);
        scannerView.setAutoFocus(true);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        AccountController accountController = AccountController.getInstance();
        if (result.getContents() != null) {
            //if(accountController.checkAccountAvailability(result.getContents())){
            if (true) {
                Intent intent = new Intent(ScannerActivity.this, TopupActivity.class);
                intent.putExtra("travelCardId", result.getContents());
                startActivity(intent);
            } else {
                //TODO: make alert dialog to show account id not found
                finish();
            }
        } else {
            new AlertDialog.Builder(ScannerActivity.this)
                    .setCancelable(false)
                    .setTitle("No content found")
                    .setMessage("Please scan correct code")
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
        }
    }

}
