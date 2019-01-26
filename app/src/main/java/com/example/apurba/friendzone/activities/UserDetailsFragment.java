package com.example.apurba.friendzone.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apurba.friendzone.DataModel;
import com.example.apurba.friendzone.R;

public class UserDetailsFragment extends Fragment {

    private View rootView;

    public UserDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_user_details, null);
        return rootView;
    }

    public void setRootView(DataModel clickedItem){
        ImageView imageView = rootView.findViewById(R.id.iv_user_details_img);
        imageView.setImageResource(clickedItem.getImgId());

        TextView nameTextView = rootView.findViewById(R.id.tv_user_details_name);
        nameTextView.setText(clickedItem.getName());
    }


}
