package com.example.kyc_verification.UI.documentverification;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kyc_verification.Adapter.CustomAdapter;
import com.example.kyc_verification.Model.Documents;
import com.example.kyc_verification.R;

import java.util.ArrayList;

public class documentsubmission extends AppCompatActivity {

    AutoCompleteTextView document_type;

    String[] document = {"Aadhar Card","Pan Card","Driving Licence","ID Card"} ;
    final ArrayList<Documents> arrayList = new ArrayList<Documents>();

    LinearLayout take_picture;
    ImageView display_picture;

    // Define the pic id
    private static final int pic_id = 123;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentsubmission);
        take_picture=findViewById(R.id.take_picture);
        display_picture=findViewById(R.id.display_picture);



        document_type = findViewById(R.id.document_type);

        arrayList.add(new Documents("Aadhar Card"));
        arrayList.add(new Documents("Pan Card"));
        arrayList.add(new Documents("Driving Licence"));
        arrayList.add(new Documents("Driving Licence"));

  take_picture();
        getDocumentSelected();
    }

    private void take_picture() {
        take_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent, and request pic id
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            display_picture.setImageBitmap(photo);
        }
    }

    private void getDocumentSelected() {
        document_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter adapter = new CustomAdapter(documentsubmission.this,  arrayList);

                document_type.setThreshold(1);// will start working from first character
                document_type.setAdapter(adapter);

                document_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Log.i("click function", String.valueOf(view));
                        String stringText = null;
                        // in normal case
                        stringText = ((TextView) view).getText().toString();
//                        Gender_Text = stringText;
                        Log.i("selected Region", stringText);

                    }
                });
            }
        });
    }
}