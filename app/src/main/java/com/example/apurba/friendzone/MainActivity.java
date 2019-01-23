package com.example.apurba.friendzone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataRVClickedListener{

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DataRecyclerAdapter mAdapter = new DataRecyclerAdapter (list, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(DataModel clickedData) {
        Toast.makeText(this, "Hi there", Toast.LENGTH_SHORT).show();
    }
}
