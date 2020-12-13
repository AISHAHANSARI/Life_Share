package com.ansari.lifeshare.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.SignIn;

public class BackToSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_to_sign_in);
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(BackToSignIn.this, SignIn.class);
        startActivity(intent);
        finish();
    }
}