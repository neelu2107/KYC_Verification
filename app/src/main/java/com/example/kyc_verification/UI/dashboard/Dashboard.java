package com.example.kyc_verification.UI.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kyc_verification.R;
import com.example.kyc_verification.UI.Addressverification.AdressVerify;
import com.example.kyc_verification.UI.Personaldetails.Personal;
import com.example.kyc_verification.UI.documentverification.documentsubmission;

public class Dashboard extends AppCompatActivity {

    LinearLayout personal_details_verify,document_verify , address_verify;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        personal_details_verify = findViewById(R.id.personal_details_verify);
        document_verify = findViewById(R.id.document_verify);
        address_verify = findViewById(R.id.address_verify);


        personal_details_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Personal.class);
                startActivity(i);
            }
        });

        document_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), documentsubmission.class);
                startActivity(i);
            }
        });

        address_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AdressVerify.class);
                startActivity(i);
            }
        });
    }
}