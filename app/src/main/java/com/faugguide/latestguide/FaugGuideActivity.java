package com.faugguide.latestguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class FaugGuideActivity extends AppCompatActivity {

    TextView tv_guide_1_ak;
    TextView tv_guide_2_pubg_animator;
    TextView tv_guide_3_new_bug;

    Toolbar toolbar;
    int[] page_one = {R.drawable.about_faug_game_one, R.drawable.about_faug_game_two, R.drawable.about_faug_game_three};
    int[] page_two = {R.drawable.about_faug_game_download_one, R.drawable.about_faug_game_download_two};
    int[] page_three = {R.drawable.fearless_and_united_one, R.drawable.fearless_and_united_two, R.drawable.fearless_and_united_three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faug_guide);

        toolbar = findViewById(R.id.guide_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv_guide_1_ak = findViewById(R.id.tv_bolly_star_AK);
        tv_guide_2_pubg_animator = findViewById(R.id.tv_pubg_animator);
        tv_guide_3_new_bug = findViewById(R.id.tv_new_bug);

        showGuide();
    }

    private void showGuide() {

        tv_guide_1_ak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaugGuideActivity.this, GuideDetailActivity.class);
                intent.putExtra("title_guide", "About FAUG Game App");
                intent.putExtra("pages", page_one);
                startActivity(intent);
            }
        });

        tv_guide_2_pubg_animator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaugGuideActivity.this, GuideDetailActivity.class);
                intent.putExtra("title_guide", "FAUG game App Download ( PUBG Animation )");
                intent.putExtra("pages", page_two);
                startActivity(intent);
            }
        });

        tv_guide_3_new_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaugGuideActivity.this, GuideDetailActivity.class);
                intent.putExtra("title_guide", "Fearless and United Guard FAU - G News Bugs");
                intent.putExtra("pages", page_three);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}