package com.faugguide.latestguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class GuideDetailActivity extends AppCompatActivity {
    Intent intent_act;
    String title_t;
    CarouselView imageSlider;
    int[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_detail);

        intent_act = getIntent();
        title_t = intent_act.getStringExtra("title_guide");
        pages = intent_act.getIntArrayExtra("pages");

        Toolbar toolbar = (Toolbar) findViewById(R.id.guide_detail_toolbar);
        imageSlider = findViewById(R.id.slider);

        setSupportActionBar(toolbar);
        setTitle(title_t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageSlider.setPageCount(pages.length);
        imageSlider.setImageListener(imageListener);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            imageView.setImageResource(pages[position]);
            imageView.setPadding(0, 200, 0, 200);
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}