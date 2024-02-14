package com.example.kyc_verification.UI.Addressverification;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kyc_verification.R;
import com.google.android.material.textfield.TextInputEditText;

public class AdressVerify extends AppCompatActivity {

    TextInputEditText house,location,city,pincode,district,state;
    LinearLayout submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_verify);
        house=findViewById(R.id.House_No);
        location=findViewById(R.id.Location);
        city=findViewById(R.id.City);
        pincode=findViewById(R.id.Pin_Code);
        district=findViewById(R.id.District);
        state=findViewById(R.id.State);
        submit=findViewById(R.id.submit);
        verify_Address();
    }

    private void verify_Address() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String house_no = house.getText().toString();
                String location_city=location.getText().toString();
                String cit=city.getText().toString();
                String pin=pincode.getText().toString();
                String stas=state.getText().toString();
                String dist=district.getText().toString();


                Toast.makeText(AdressVerify.this,"house no"+" :-"+house_no+" "+"location_city"+" :-"+location_city+" "+" city"+" :-"+cit+" "+"pin"+" :-"+pin +" "+"stas"+" :-"+stas+""+"dist"+" :-"+dist,Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}