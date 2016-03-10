package com.example.danielbastos.msn.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.danielbastos.msn.R;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        /*

            Retrieve User Data

         */

        String name = getIntent().getStringExtra("name");


        /*

            Toolbar Preparation

         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.chatToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        /*

            Name

         */

        TextView mTextView = (TextView) findViewById(R.id.friendName);
        mTextView.setText(name);

        /*

            TAB Management

         */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
