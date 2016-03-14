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

        mDataset.add(new Mensagem(0, "abc", "rafael@mail.com", "daniel@mail.com", "Mensagem grande p" +
                "ra testar e ver como fica uma mensagem grande no chat do jeito que tá a mensagem gr" +
                "ande e grande que só o caramba beleza é grande a mensagem é grande", "11/09/89"));
        mDataset.add(new Mensagem(0, "abc", "daniel@mail.com", "rafael@mail.com", "Mensagem grande p" +
                "ra testar e ver como fica uma mensagem grande no chat do jeito que tá a mensagem gr" +
                "ande e grande que só o caramba beleza é grande a mensagem é grande", "11/09/89"));
        mDataset.add(new Mensagem(0, "abc", "rafael@mail.com", "daniel@mail.com", "Blz", "11/09/89"));
        mDataset.add(new Mensagem(0, "abc", "daniel@mail.com", "rafael@mail.com", "Beleza?", "11/09/89"));
        mDataset.add(new Mensagem(0, "abc", "rafael@mail.com", "daniel@mail.com", "Oi", "11/09/89"));
        mDataset.add(new Mensagem(0, "abc", "daniel@mail.com", "rafael@mail.com", "Oi", "11/09/89"));
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

        if(!msg.isMinhaMensagem("daniel@mail.com")){ // TODO Buscar meu e-mail e passar aqui
            holder.autor.setTextColor(ContextCompat.getColor(context, R.color.amber));
        }

        holder.msg.setText(msg.getMensagem());
    }

    public int getItemCount() {
        return mDataset.size();
    }
}
