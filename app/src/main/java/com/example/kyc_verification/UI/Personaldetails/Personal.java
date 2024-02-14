package com.example.kyc_verification.UI.Personaldetails;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kyc_verification.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Personal extends AppCompatActivity {

    TextInputEditText ClientID, name_as_per_kyc, aadhhar_number, date_of_birth, fathers_name, mobile_number;
    LinearLayout get_otp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ClientID = findViewById(R.id.Client_id);
        name_as_per_kyc = findViewById(R.id.name_as_per_kyc);
        aadhhar_number = findViewById(R.id.adhar_number);
        date_of_birth = findViewById(R.id.date_of_birth);
        fathers_name = findViewById(R.id.fathers_name);
        mobile_number = findViewById(R.id.mobile_number);


        get_otp = findViewById(R.id.get_otp_submit);

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        getFormData();

        Calendar calendardate = Calendar.getInstance();

        DatePickerDialog time = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 Calendar newdate = Calendar.getInstance();
                 newdate.set(year,month,day);
                date_of_birth.setText(dateFormat.format(newdate.getTime()));
            }
        },calendardate.get(Calendar.YEAR),calendardate.get(Calendar.MONTH),calendardate.get(Calendar.DAY_OF_MONTH));


        date_of_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.show();
            }
        });
    }

    private void getFormData()
    {
        get_otp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            try {
                String client = ClientID.getText().toString();
                String kyc = name_as_per_kyc.getText().toString();
                String aadhaar = aadhhar_number.getText().toString();
                String dob = date_of_birth.getText().toString();
                String fathers = fathers_name.getText().toString();
                String mobile = mobile_number.getText().toString();

              if(client.isEmpty()){
                  Toast.makeText(getApplicationContext(),"Client ID should not be blank",Toast.LENGTH_SHORT).show();
              }else{
                  if(isValidNumber(client)){
                      Toast.makeText(getApplicationContext(),"ID should be number",Toast.LENGTH_SHORT).show();
                  }else{
                      Toast.makeText(getApplicationContext(),"ID should not be number ",Toast.LENGTH_SHORT).show();
                  }
                  if(kyc.isEmpty()){
                      Toast.makeText(getApplicationContext(),"Please fill the Name",Toast.LENGTH_SHORT).show();
                  }else{
                      if(aadhaar.isEmpty()){
                          Toast.makeText(getApplicationContext(),"Please filled the Aadhar Number",Toast.LENGTH_SHORT).show();
                      }else{

                          if(aadhaar.isEmpty()){
                              Toast.makeText(getApplicationContext(),"Aadhar detail should not be blank",Toast.LENGTH_SHORT).show();
                          }else{
                              if(!validateAadharNumber(aadhaar)){
                                  Toast.makeText(getApplicationContext(),"Invalid Aadhar Number",Toast.LENGTH_SHORT).show();
                              }else{
                              Log.i("Aadhar","Valid Aadhar"+validateAadharNumber(aadhaar));

                              if(dob.isEmpty()){
                                  Toast.makeText(getApplicationContext(),"Please Filled the Date Of Birth",Toast.LENGTH_SHORT).show();
                              }else{

                                  if(fathers.isEmpty()){
                                      Toast.makeText(getApplicationContext(),"Please Filled the Father Number",Toast.LENGTH_SHORT).show();
                                  }else{
                                      if(mobile.isEmpty())
                                      {
                                          Toast.makeText(getApplicationContext(),"mobile number should not be blank",Toast.LENGTH_LONG).show();
                                      }
                                          if(!isValidMobile(mobile)){
                                              Log.i("Mobile","In Valid Mobile"+mobile);
                                              Toast.makeText(getApplicationContext(),"In Valid Mobile "+mobile,Toast.LENGTH_SHORT).show();

                                          }else{
                                              Toast.makeText(getApplicationContext(),"Valid Mobile "+mobile,Toast.LENGTH_SHORT).show();
                                          }

                                  }
                              }
                              }
                          }






                      }

                  }
              }





                Log.e("form data", client + " " + kyc + " " + dob + " " + aadhaar + " " + fathers + " " + mobile);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    });


    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // this function is called before text is edited
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // this function is called when text is edited
            if(count == 6){
                Toast.makeText(getApplicationContext(),"ID should not be number ",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            // this function is called after text is edited
        }
    };


    private boolean isValidMobile(String phone) {
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() > 6 && phone.length() <= 13;
        }
        return false;
    }

    public static boolean validateAadharNumber(String aadharNumber){

        Pattern aadharPattern = Pattern.compile("\\d{12}");
        boolean isValidAadhar = aadharPattern.matcher(aadharNumber).matches();

        if(isValidAadhar){
            return true;
        }else{
            return false;
        }

    }


    private boolean isValidNumber(String input) {
        // Regular expression to match only numbers
        String regex = "[0-9]+";
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        // Check if the input matches the pattern
        return input != null && pattern.matcher(input).matches();
    }
}