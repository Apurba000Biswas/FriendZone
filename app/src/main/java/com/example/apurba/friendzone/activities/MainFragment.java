package com.example.apurba.friendzone.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apurba.friendzone.DataFactory;
import com.example.apurba.friendzone.DataModel;
import com.example.apurba.friendzone.DataRVClickedListener;
import com.example.apurba.friendzone.DataRecyclerAdapter;
import com.example.apurba.friendzone.R;

import java.util.List;


public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, null);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_fragment);
        List<DataModel> list = DataFactory.getUsers();

        recyclerView.setHasFixedSize(true); // This sittings to improve performance
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        DataRVClickedListener listener = (DataRVClickedListener)getActivity();
        DataRecyclerAdapter mAdapter = new DataRecyclerAdapter (list, listener);
        recyclerView.setAdapter(mAdapter);
        return rootView;
    }


    public void showGivenRating(float rating){
        if (rating == 0){
            Toast.makeText(getContext(), "You did not rate this user", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "You rated this user "
                    + rating + " star", Toast.LENGTH_SHORT).show();
        }

    }
}
