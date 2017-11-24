package com.csse.ticketcreator;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.csse.ticketcreator.Controllers.AccountController;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Scanner;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScannerActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler{
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
        if(result.getContents() != null){
            //if(accountController.checkAccountAvailability(result.getContents())){
            if(true){
                Intent intent = new Intent(ScannerActivity.this, TopupActivity.class);
                intent.putExtra("travelCardId", result.getContents());
                startActivity(intent);
            }
            else{
                //TODO: make alert dialog to show account id not found
                finish();
            }
        }
        else{
            //TODO: make alert dialog to show no content found
            finish();
        }
    }

}
