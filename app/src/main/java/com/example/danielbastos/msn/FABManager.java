package com.example.danielbastos.msn;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.danielbastos.msn.Friends.AddFriendFragment;


public class FABManager implements View.OnClickListener {
    public boolean isOpen;
    private FloatingActionButton mFab;
    private AppCompatActivity activity;

    public FloatingActionButton init(AppCompatActivity activity){
        this.activity = activity;
        this.mFab = (FloatingActionButton) activity.findViewById(R.id.fab);

        this.mFab.setOnClickListener(this);
        return this.mFab;
    }

    @Override
    public void onClick(View v){
        FloatingActionButton fab = (FloatingActionButton) v;
        fab.hide();

        int cx = v.getLeft() + v.getRight() / 2;
        int cy = v.getBottom() + v.getTop() / 2;

        Fragment addFriendFragment = AddFriendFragment.newInstance(cx, cy);

        activity
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerView, addFriendFragment)
                .addToBackStack(null)
                .commit();
    }
}
