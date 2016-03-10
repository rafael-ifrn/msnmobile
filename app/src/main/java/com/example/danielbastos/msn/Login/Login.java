package com.example.danielbastos.msn.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.danielbastos.msn.R;
import com.example.danielbastos.msn.Friends.FriendsActivity;

/**
 * A activity_login screen that offers activity_login via email/password.
 */
public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }
}

