package com.example.apurba.friendzone.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.apurba.friendzone.DataModel;
import com.example.apurba.friendzone.DataRVClickedListener;
import com.example.apurba.friendzone.DataRecyclerAdapter;
import com.example.apurba.friendzone.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataRVClickedListener {
    private static final int REQ_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<DataModel> list = new ArrayList<>();
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));
        list.add(new DataModel("Brandon Stark", R.drawable.bran_stark));

        recyclerView.setHasFixedSize(true); // This sittings to improve performance
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        DataRecyclerAdapter mAdapter = new DataRecyclerAdapter (list, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(DataModel clickedData) {

        Intent userDetailsIntent = new Intent(this, UserDetailsActivity.class);
        userDetailsIntent.putExtra("Name", clickedData.getName());
        userDetailsIntent.putExtra("ImgId", clickedData.getImgId());
        startActivityForResult(userDetailsIntent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode
            , int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE){
            try{
                int givenRating = data.getIntExtra("Rating", -1);
                Toast.makeText(this, "You rated this user " + givenRating + " star", Toast.LENGTH_SHORT).show();
            }catch (NullPointerException e){
                Toast.makeText(this, "You did not rate this user", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
