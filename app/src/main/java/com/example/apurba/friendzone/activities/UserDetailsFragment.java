package com.example.apurba.friendzone.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
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
        final RatingBar ratingBar =rootView.findViewById(R.id.rating);
        ratingBar.setRating(0);
        ratingBar.setVisibility(View.GONE);
        LinearLayout layout = rootView.findViewById(R.id.root_container);
        TextView textView = new TextView(getContext());
        textView.setText("Done");
        textView.setId(R.id.done_text_view);
        textView.setVisibility(View.GONE);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment mainFragment =(MainFragment) getActivity()
                        .getSupportFragmentManager().findFragmentById(R.id.lsit_fragment);
                mainFragment.showGivenRating(ratingBar.getRating());
            }
        });
        layout.addView(textView);
        return rootView;
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        RatingBar ratingBar =rootView.findViewById(R.id.rating);
        ratingBar.setRating(0);
    }

    public void setRootView(DataModel clickedItem){
        ImageView imageView = rootView.findViewById(R.id.iv_user_details_img);
        imageView.setImageResource(clickedItem.getImgId());

        TextView nameTextView = rootView.findViewById(R.id.tv_user_details_name);
        nameTextView.setText(clickedItem.getName());

        RatingBar ratingBar = rootView.findViewById(R.id.rating);
        ratingBar.setRating(0);
        ratingBar.setVisibility(View.VISIBLE);

        TextView doneTextView = rootView.findViewById(R.id.done_text_view);
        doneTextView.setVisibility(View.VISIBLE);
    }


}
