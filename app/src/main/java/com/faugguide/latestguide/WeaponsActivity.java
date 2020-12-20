package com.faugguide.latestguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.Adapter.WeaponAdapter;
import com.faugguide.latestguide.Modal.WeaponModal;

import java.util.ArrayList;
import java.util.List;

public class WeaponsActivity extends AppCompatActivity {

    Toolbar toolbar;
    private List<WeaponModal> weaponModalList;
    private WeaponAdapter mAdapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);

        toolbar = (Toolbar) findViewById(R.id.toolbar_Weapons);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerView_weapon);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        weaponModalList = new ArrayList<>();
        mAdapter = new WeaponAdapter(weaponModalList, this);
        recyclerView.setAdapter(mAdapter);
        data();
    }

    public void data() {
        WeaponModal weaponModal=new WeaponModal();
        weaponModal.setWeapon(R.drawable.weapon_one);
        weaponModalList.add(weaponModal);

        WeaponModal weaponModal1=new WeaponModal();
        weaponModal1.setWeapon(R.drawable.weapon_two);
        weaponModalList.add(weaponModal1);

        WeaponModal weaponModal2=new WeaponModal();
        weaponModal2.setWeapon(R.drawable.weapon_three);
        weaponModalList.add(weaponModal2);

        WeaponModal weaponModal3=new WeaponModal();
        weaponModal3.setWeapon(R.drawable.weapon_four);
        weaponModalList.add(weaponModal3);

        WeaponModal weaponModal4=new WeaponModal();
        weaponModal4.setWeapon(R.drawable.weapon_five);
        weaponModalList.add(weaponModal4);

        WeaponModal weaponModal5=new WeaponModal();
        weaponModal5.setWeapon(R.drawable.weapon_one);
        weaponModalList.add(weaponModal5);

        WeaponModal weaponModal6=new WeaponModal();
        weaponModal6.setWeapon(R.drawable.weapon_two);
        weaponModalList.add(weaponModal6);

        WeaponModal weaponModal7=new WeaponModal();
        weaponModal7.setWeapon(R.drawable.weapon_three);
        weaponModalList.add(weaponModal7);

        WeaponModal weaponModal8=new WeaponModal();
        weaponModal8.setWeapon(R.drawable.weapon_four);
        weaponModalList.add(weaponModal8);

        WeaponModal weaponModal9=new WeaponModal();
        weaponModal9.setWeapon(R.drawable.weapon_five);
        weaponModalList.add(weaponModal9);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}