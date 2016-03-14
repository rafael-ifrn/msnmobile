package com.example.danielbastos.msn.Friends;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielbastos.msn.Friends.Model.DummyContent;
import com.example.danielbastos.msn.Friends.Model.RequestListeners;
import com.example.danielbastos.msn.R;

import java.util.List;


public class FriendsAdapter extends RecyclerView.Adapter<ViewHolder> {
    // List Types Enumerations
    public static final int LISTA_AMIGOS = 0;
    public static final int LISTA_BLOQUEADOS = 1;
    public static final int LISTA_PEDIDOS = 2;


    private List<DummyContent.DummyItem> mDataset;

    private int listType;
    private Context context;

    public FriendsAdapter(int listType, Context context) {
        this.listType = listType;
        this.context = context;

        switch (listType){
            case FriendsAdapter.LISTA_AMIGOS: {
                mDataset = DummyContent.ITEMS;
                break;
            }
            case FriendsAdapter.LISTA_BLOQUEADOS: {
                mDataset = DummyContent.ITEMS;
                break;
            }
            case FriendsAdapter.LISTA_PEDIDOS: {
                mDataset = DummyContent.ITEMS;
                break;
            }
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;

        switch (listType){
            case FriendsAdapter.LISTA_AMIGOS:
                layoutId = R.layout.friends_list_item;
                break;
            case FriendsAdapter.LISTA_BLOQUEADOS:
                layoutId = R.layout.friends_blocked_item;
                break;
            case FriendsAdapter.LISTA_PEDIDOS:
                layoutId = R.layout.friends_request_item;
                break;
            default:
                layoutId = R.layout.friends_list_item;
        }

        // create a new view
        View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(layoutId, parent, false);

        ViewHolder vh = new ViewHolder(view, this.listType);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        DummyContent.DummyItem person = mDataset.get(position);

        if(this.listType == FriendsAdapter.LISTA_AMIGOS) {
            holder.lastText.setText(person.lastText);
        } else if (this.listType == FriendsAdapter.LISTA_PEDIDOS) {
            View v = holder.itemView;

            v.findViewById(R.id.add).setOnClickListener(RequestListeners.aceitar);
            v.findViewById(R.id.reject).setOnClickListener(RequestListeners.rejeitar);
        } else if(this.listType == FriendsAdapter.LISTA_BLOQUEADOS){
            View v = holder.itemView;

            v.findViewById(R.id.unblockBtn).setOnClickListener(RequestListeners.desbloquear);
        }

        holder.name.setText(person.name);
        holder.picture.setImageResource(person.picture);



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
