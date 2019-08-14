package com.shahab.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView txtshowname = findViewById(R.id.txtshowname);
        TextView txtshowfamily = findViewById(R.id.txtshowfamily);
        TextView txtshowage = findViewById(R.id.txtshowage);
        TextView txtshowphone = findViewById(R.id.txtshowphone);
        TextView txtshowaddress = findViewById(R.id.txtshowaddress);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnConfirm = findViewById(R.id.btnConfirm);


        Intent i = getIntent();
        final String Name = i.getStringExtra("Name");
        final String Family = i.getStringExtra("Family");
        final String Age = i.getStringExtra("Age");
        final String Phone = i.getStringExtra("Phone");
        final String Address = i.getStringExtra("Address");

        txtshowname.setText("your name is "+Name);
        txtshowfamily.setText("your family is "+Family);
        txtshowage.setText("your age is" + Age);
        txtshowphone.setText("your phone is " + Phone);
        txtshowaddress.setText("your address is " + Address);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent();
                setResult(Activity.RESULT_OK, h);
                finish();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("name",Name).apply();
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("family",Family).apply();
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("age",Age).apply();
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("phone",Phone).apply();
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("address",Address).apply();

                Intent g = new Intent();
                g.putExtra("Name",Name);
                setResult(Activity.RESULT_OK,g);

            }
        });




    }
}
