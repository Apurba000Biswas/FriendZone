package com.example.apurba.friendzone.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.apurba.friendzone.DataFactory;
import com.example.apurba.friendzone.DataModel;
import com.example.apurba.friendzone.DataRVClickedListener;
import com.example.apurba.friendzone.DataRecyclerAdapter;
import com.example.apurba.friendzone.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataRVClickedListener {
    private static final int REQ_CODE = 101;
    private int backPressedCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            // we are in portrait orientation
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            List<DataModel> list = DataFactory.getUsers();

            recyclerView.setHasFixedSize(true); // This sittings to improve performance
            GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);
            DataRecyclerAdapter mAdapter = new DataRecyclerAdapter (list, this);
            recyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onClick(DataModel clickedData) {

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            Intent userDetailsIntent = new Intent(this, UserDetailsActivity.class);
            userDetailsIntent.putExtra("Name", clickedData.getName());
            userDetailsIntent.putExtra("ImgId", clickedData.getImgId());
            startActivityForResult(userDetailsIntent, REQ_CODE);
        }else{
            UserDetailsFragment userDetailsFragment = (UserDetailsFragment)
                    this.getSupportFragmentManager().findFragmentById(R.id.user_details_fragment);
            userDetailsFragment.setRootView(clickedData);
        }
    }

    @Override
    protected void onActivityResult(int requestCode
            , int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE){
            try{
                float givenRating = data.getFloatExtra("Rating", -1);
                Toast.makeText(this, "You rated this user "
                        + givenRating + " star", Toast.LENGTH_SHORT).show();
            }catch (NullPointerException e){
                Toast.makeText(this, "You did not rate this user"
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        backPressedCount = 1;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (backPressedCount == 2){
            finish();
        }else{
            Toast.makeText(this, "Tap again to exit", Toast.LENGTH_SHORT).show();
            backPressedCount++;
        }
    }
}
