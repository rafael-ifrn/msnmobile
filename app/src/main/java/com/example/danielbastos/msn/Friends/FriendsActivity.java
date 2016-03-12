package com.example.danielbastos.msn.Friends;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.danielbastos.msn.Chat.ProfileActivity;
import com.example.danielbastos.msn.FABManager;
import com.example.danielbastos.msn.Friends.TabLayout.TabLayoutFragment;
import com.example.danielbastos.msn.R;

public class FriendsActivity extends AppCompatActivity implements AddFriendFragment.ReturnListener {
    private FloatingActionButton mFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        /*

            Toolbar Configuration

        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setLogo(R.drawable.ic_logo);


        /*

            TabLayoutView Preparation

        */

        TabLayoutFragment tabLayoutView = new TabLayoutFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerView, tabLayoutView)
                .commit();

        /*

            FAB Management

         */

        mFab = new FABManager().init(this);
    }

    @Nullable
    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return super.getDrawerToggleDelegate();
    }

    @Override
    public void onReturn(AddFriendFragment addFriend) {
        mFab.show();
    }

    public void goProfile(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}