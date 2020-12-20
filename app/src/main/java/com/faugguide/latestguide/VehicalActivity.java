package com.faugguide.latestguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.faugguide.latestguide.Adapter.VehicalAdapter;
import com.faugguide.latestguide.Adapter.WeaponAdapter;
import com.faugguide.latestguide.Modal.VehicalModal;
import com.faugguide.latestguide.Modal.WeaponModal;

import java.util.ArrayList;
import java.util.List;

public class VehicalActivity extends AppCompatActivity {

    Toolbar toolbar;
    private List<VehicalModal> vehicalModalList;
    private VehicalAdapter mAdapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehical);

        toolbar= (Toolbar) findViewById(R.id.toolbar_Vehicals);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerView_vehical);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        vehicalModalList = new ArrayList<>();
        mAdapter = new VehicalAdapter(vehicalModalList, this);
        recyclerView.setAdapter(mAdapter);
        data();
    }

    public  void data(){
        VehicalModal vehicalModal=new VehicalModal();
        vehicalModal.setVehical(R.drawable.vehical_one);
        vehicalModalList.add(vehicalModal);

        VehicalModal vehicalModal1=new VehicalModal();
        vehicalModal1.setVehical(R.drawable.vehical_two);
        vehicalModalList.add(vehicalModal1);

        VehicalModal vehicalModal2=new VehicalModal();
        vehicalModal2.setVehical(R.drawable.vehical_three);
        vehicalModalList.add(vehicalModal2);

        VehicalModal vehicalModal3=new VehicalModal();
        vehicalModal3.setVehical(R.drawable.vehical_four);
        vehicalModalList.add(vehicalModal3);

        VehicalModal vehicalModal4=new VehicalModal();
        vehicalModal.setVehical(R.drawable.vehical_one);
        vehicalModalList.add(vehicalModal);

        VehicalModal vehicalModal5=new VehicalModal();
        vehicalModal5.setVehical(R.drawable.vehical_two);
        vehicalModalList.add(vehicalModal5);

        VehicalModal vehicalModal6=new VehicalModal();
        vehicalModal6.setVehical(R.drawable.vehical_three);
        vehicalModalList.add(vehicalModal6);

        VehicalModal vehicalModal7=new VehicalModal();
        vehicalModal7.setVehical(R.drawable.vehical_four);
        vehicalModalList.add(vehicalModal7);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}