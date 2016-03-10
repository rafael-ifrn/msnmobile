package com.example.danielbastos.msn.Friends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielbastos.msn.R;

/**
 * A fragment representing a list of Items.
 * <p>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p>
 * interface.
 */
public class ListFragment extends Fragment {

    private static final String PARAM_NAME = "listName";
    private int listType;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private RecyclerView.Adapter mAdapter;

    // TODO: Rename and change types of parameters
    public static ListFragment newInstance(int listType) {
        ListFragment fragment = new ListFragment();

        Bundle args = new Bundle();
        args.putInt(PARAM_NAME, listType);

        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        listType = getArguments().getInt(PARAM_NAME);
        mAdapter = new FriendsAdapter(listType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate View
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.friends_list, container, false);

        // Create LayoutManager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        // Configure view
        view.setAdapter(mAdapter);
        view.setLayoutManager(mLayoutManager);

        return view;
    }

}
