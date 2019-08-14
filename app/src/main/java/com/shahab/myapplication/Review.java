package com.shahab.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtAge = findViewById(R.id.edtAge);
        final EditText edtPhone = findViewById(R.id.edtPhone);
        final EditText edtAddress = findViewById(R.id.edtAddress);
        Button btnReview = findViewById(R.id.btnReview);


        String Data = PreferenceManager.getDefaultSharedPreferences(Review.this).getString("name","Unknown User Name!");
        txtWellcome.setText("WellCome"+Data);


        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Review.this, Confirm.class);
                String Name = edtName.getText().toString();
                String Family = edtFamily.getText().toString();
                String Age = edtAge.getText().toString();
                String Phone = edtPhone.getText().toString();
                String Address = edtAddress.getText().toString();
                i.putExtra("Name",Name);
                i.putExtra("Family",Family);
                i.putExtra("Age",Age);
                i.putExtra("Phone",Phone);
                i.putExtra("Address",Address);
                startActivityForResult(i,100);


            }
        });
    }
    TextView txtWellcome = findViewById(R.id.txtWellcome);


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                String message = data.getStringExtra("Name");
                txtWellcome.setText("WellCome "+ message);

            }
        }
    }
}
