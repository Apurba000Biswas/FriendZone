package com.example.apurba.friendzone.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.apurba.friendzone.R;

public class UserDetailsActivity extends AppCompatActivity {

    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        String name = getIntent().getStringExtra("Name");
        int imgId = getIntent().getIntExtra("ImgId", -1);

        TextView tvName = findViewById(R.id.tv_user_details_name);
        tvName.setText(name);
        ImageView ivImg = findViewById(R.id.iv_user_details_img);
        if (imgId != -1){
            ivImg.setImageResource(imgId);
        }

        rating = findViewById(R.id.rating);
        LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter
                (ContextCompat.getColor(this, R.color.colorPrimaryDark)
                        , PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public void onBackPressed() {
        float rate =  rating.getRating();
        if (rate != 0.0){
            Intent intent = new Intent();
            intent.putExtra("Rating", rate);
            setResult(RESULT_OK, intent);
            finish();
        }else{
            finish();
        }
    }
}
