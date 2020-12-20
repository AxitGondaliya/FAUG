package com.faugguide.latestguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.Modal.WeaponModal;
import com.faugguide.latestguide.R;

import java.util.List;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.MyViewHolder> {
    private List<WeaponModal> weaponModalList;
    Context context;

    public WeaponAdapter(List<WeaponModal> weaponModalList, Context context) {
        this.weaponModalList = weaponModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weapon_layout, parent, false);
        return new WeaponAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final WeaponModal weaponModal = weaponModalList.get(position);
        holder.weapon.setImageResource(weaponModal.getWeapon());
    }

    @Override
    public int getItemCount() {
        return weaponModalList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView weapon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            weapon = itemView.findViewById(R.id.img_weapon);
        }
    }
}
