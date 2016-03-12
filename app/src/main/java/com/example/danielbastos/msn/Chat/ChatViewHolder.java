package com.example.danielbastos.msn.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielbastos.msn.R;

/**
 * Created by danielbastos on 3/12/16.
 */
public class ChatViewHolder extends RecyclerView.ViewHolder {
    public TextView autor;
    public TextView msg;
    public ImageView avatar; // TODO Fazer a imagem mudar dinamicamente

    public ChatViewHolder(View v) {
        super(v);

        this.autor = (TextView) v.findViewById(R.id.message_author);
        this.msg = (TextView) v.findViewById(R.id.message_text);
    }
}
