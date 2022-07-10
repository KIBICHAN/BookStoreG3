package com.example.bookstoreg3.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bookstoreg3.R;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar;

    TextView tvGender,tvEmail,tvPhone,tvName,tvAddress, tvBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail =(TextView) findViewById(R.id.editEmail);
        tvName = (TextView) findViewById(R.id.editTextTextPersonName);
        tvPhone = (TextView) findViewById(R.id.editTextPhone);
        tvGender = (TextView) findViewById(R.id.textView4);
        tvAddress = (TextView) findViewById(R.id.editAddress);
        tvBalance = (TextView) findViewById(R.id.editBalance);
        toolbar = (Toolbar) findViewById(R.id.toobar);

        SharedPreferences sharedPreferences = getSharedPreferences("Account", MODE_PRIVATE);
        tvName.setText(sharedPreferences.getString("name", ""));
        tvEmail.setText(sharedPreferences.getString("gmail", ""));
        tvPhone.setText(sharedPreferences.getString("phone",""));
        tvAddress.setText(sharedPreferences.getString("address",""));
        //tvBalance.setText(sharedPreferences.getString("money",""));
        tvBalance.setText(""+sharedPreferences.getFloat("money", 0));
        if (sharedPreferences.getBoolean("gender", true)){
            tvGender.setText("Male");
        }else {
            tvGender.setText("Female");
        }
        ActionToolBar ();


    }

    private void ActionToolBar () {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
