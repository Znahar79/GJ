package com.example.nikit.getjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClickGoLogin(View view) {
        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
