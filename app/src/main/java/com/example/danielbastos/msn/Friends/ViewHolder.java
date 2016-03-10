package com.example.danielbastos.msn.Friends;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielbastos.msn.Chat.ChatActivity;
import com.example.danielbastos.msn.R;

/**
 * Created by danielbastos on 3/9/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name;
    public TextView lastText;
    public ImageView picture;
    public View personItem;

    public ViewHolder(View v) {
        super(v);

        this.name = (TextView) v.findViewById(R.id.firstLine);
        this.lastText = (TextView) v.findViewById(R.id.secondLine);
        this.picture = (ImageView) v.findViewById(R.id.icon);
        this.personItem = v;

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Create Intent and navigate to ChatActivity
        Intent intent = new Intent(v.getContext(), ChatActivity.class);
        intent.putExtra("name", this.name.getText());
        v.getContext().startActivity(intent);
    }
}
