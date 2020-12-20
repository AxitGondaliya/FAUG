package com.faugguide.latestguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.Modal.VehicalModal;
import com.faugguide.latestguide.R;

import java.util.List;

public class VehicalAdapter extends RecyclerView.Adapter<VehicalAdapter.MyViewHolder> {
    private List<VehicalModal> vehicalModalList;
    Context context;

    public VehicalAdapter(List<VehicalModal> vehicalModalList,Context context) {
        this.vehicalModalList = vehicalModalList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vehical_layout, parent, false);
        return new VehicalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VehicalModal vehicalModal = vehicalModalList.get(position);
        holder.vehical.setImageResource(vehicalModal.getVehical());

    }

    @Override
    public int getItemCount() {
        return vehicalModalList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView vehical;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vehical = itemView.findViewById(R.id.img_vehical);
        }
    }
}
