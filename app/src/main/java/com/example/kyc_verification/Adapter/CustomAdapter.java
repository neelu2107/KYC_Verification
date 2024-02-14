package com.example.kyc_verification.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kyc_verification.Model.Documents;
import com.example.kyc_verification.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Documents> {

    public CustomAdapter(@NonNull Context context, ArrayList<Documents> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.document_list, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Documents currentNumberPosition = getItem(position);



        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.document_item);
        textView1.setText(currentNumberPosition.getName());



        // then return the recyclable view
        return currentItemView;
    }
}
