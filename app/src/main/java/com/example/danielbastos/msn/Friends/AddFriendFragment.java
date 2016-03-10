package com.example.danielbastos.msn.Friends;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.example.danielbastos.msn.R;

/**
 * Created by danielbastos on 3/9/16.
 */
public class AddFriendFragment extends Fragment {
    ReturnListener mCallback;

    public static AddFriendFragment newInstance(int centerX, int centerY) {
        Bundle args = new Bundle();
        args.putInt("cx", centerX);
        args.putInt("cy", centerY);

        AddFriendFragment fragment = new AddFriendFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (ReturnListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement AddFriendFragment.ReturnListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.friends_add, container, false);


        v.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                v.removeOnLayoutChangeListener(this);

                int cx = getArguments().getInt("cx");
                int cy = getArguments().getInt("cy");

                // get the hypothenuse so the radius is from one corner to the other
                int radius = (int) Math.hypot(right, bottom);

                Animator reveal = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, radius*2);
                reveal.setDuration(1000);
                reveal.start();
            }
        });

        return v;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();

        if(mCallback != null){
            mCallback.onReturn(this);
        }
    }

    public interface ReturnListener{
        void onReturn(AddFriendFragment addFriend);
    }
}
