package com.example.danielbastos.msn.Chat;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielbastos.msn.Chat.Model.Mensagem;
import com.example.danielbastos.msn.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by danielbastos on 3/12/16.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder>{
    private Context context;
    List<Mensagem> mDataset;

    public ChatAdapter(Context context, String amigoId){
        this.context = context;
        mDataset = new LinkedList<Mensagem>(); // TODO Buscar a lista no BD
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.chat_message, parent, false);

        return new ChatViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        Mensagem msg = mDataset.get(position);

        if(!msg.isMinhaMensagem("daniel@live.com")){ // TODO Buscar meu e-mail e passar aqui
            holder.autor.setTextColor(ContextCompat.getColor(context, R.color.amber));
        }

        holder.msg.setText(msg.getMensagem());
    }

    public int getItemCount() {
        return mDataset.size();
    }
}
