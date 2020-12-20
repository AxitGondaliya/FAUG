package com.faugguide.latestguide;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

public class RubbyActivity extends AppCompatActivity {

    Toolbar toolbar;
    NestedScrollView nestedScrollView;
    ScrollView scrollView;
    TextView a,b,c,d,e,f;
    int scrollTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubby);

        toolbar = (Toolbar) findViewById(R.id.toolbar_rubby);
//        nestedScrollView =  findViewById(R.id.nested_rubby);
        scrollView =  findViewById(R.id.nested_rubby);
//        a =  findViewById(R.id.tv_1);
//        b =  findViewById(R.id.tv_2);
//        c =  findViewById(R.id.tv_3);
//        d =  findViewById(R.id.tv_4);
//        e =  findViewById(R.id.tv_5);
//        f =  findViewById(R.id.tv_6);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        nestedScrollView.fling(50);
//        nestedScrollView.smoothScrollTo(10, 10);
//        scrollView.fling(10);
//        scrollView.smoothScrollTo(0,7);


//        a.setMovementMethod(new ScrollingMovementMethod());
//        b.setMovementMethod(new ScrollingMovementMethod());
//        c.setMovementMethod(new ScrollingMovementMethod());
//        d.setMovementMethod(new ScrollingMovementMethod());
//        e.setMovementMethod(new ScrollingMovementMethod());
//        f.setMovementMethod(new ScrollingMovementMethod());
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}