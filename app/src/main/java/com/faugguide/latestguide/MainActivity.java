package com.faugguide.latestguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.faugguide.latestguide.sticker.Set_Sticker_To_Whtspp_Second_Activity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button start_guid,stickers,weapons,vehical,rubby,tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar_Guide_main);
        start_guid=  findViewById(R.id.btn_start_guid);
        stickers=  findViewById(R.id.btn_stickers);
        weapons=  findViewById(R.id.btn_Weapons);
        vehical=  findViewById(R.id.btn_Vehicals);
        rubby=  findViewById(R.id.btn_Rubby);
        tips=  findViewById(R.id.btn_tips_tricks);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        click_event();

    }

    public void click_event(){
        start_guid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FaugGuideActivity.class);
                startActivity(intent);
            }
        });

        stickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Set_Sticker_To_Whtspp_Second_Activity.class);
                startActivity(intent);
            }
        });

        weapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WeaponsActivity.class);
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TipsTricksActivity.class);
                startActivity(intent);
            }
        });

        vehical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VehicalActivity.class);
                startActivity(intent);
            }
        });

        rubby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RubbyActivity.class);
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