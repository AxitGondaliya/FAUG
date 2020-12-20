package com.faugguide.latestguide.sticker;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.R;


public class Pubg_ALL_Holder_Preview_Capacitor_Games extends RecyclerView.Adapter<Game_Preview_View_Holder_Pubg_ALL> {

    @NonNull
    private Pubg_ALL_Pack_Of_Sicker_Game wa_stickerPack;
    private final int cellSize;
    private int cellLimit;
    private int cellPadding;
    private final int errorResource;
    private final LayoutInflater layoutInflater;

    Pubg_ALL_Holder_Preview_Capacitor_Games(
            @NonNull final LayoutInflater layoutInflater,
            final int errorResource,
            final int cellSize,
            final int cellPadding,
            @NonNull final Pubg_ALL_Pack_Of_Sicker_Game stickerPack) {
        this.cellSize = cellSize;
        this.cellPadding = cellPadding;
        this.cellLimit = 0;
        this.layoutInflater = layoutInflater;
        this.errorResource = errorResource;
        this.wa_stickerPack = stickerPack;
    }

    @NonNull
    @Override
    public Game_Preview_View_Holder_Pubg_ALL onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View itemView = layoutInflater.inflate(R.layout.adapter_preview_holder_pictures_pubg_all, viewGroup, false);
        Game_Preview_View_Holder_Pubg_ALL vh = new Game_Preview_View_Holder_Pubg_ALL(itemView);
        ViewGroup.LayoutParams layoutParams = vh.sd_sticPreviewView.getLayoutParams();
        layoutParams.height = cellSize;
        layoutParams.width = cellSize;
        vh.sd_sticPreviewView.setLayoutParams(layoutParams);
        vh.sd_sticPreviewView.setPadding(cellPadding, cellPadding, cellPadding, cellPadding);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final Game_Preview_View_Holder_Pubg_ALL stickerPreviewViewHolder, final int i) {
        stickerPreviewViewHolder.sd_sticPreviewView.setImageResource(errorResource);
        stickerPreviewViewHolder.sd_sticPreviewView.setImageURI(Pubg_ALL_Loader_Packages_Games.getStickerAssetUri(wa_stickerPack.identifier, wa_stickerPack.getStickers().get(i).st_imgFileName));
    }

    @Override
    public int getItemCount() {
        int numberOfPreviewImagesInPack;
        numberOfPreviewImagesInPack = wa_stickerPack.getStickers().size();
        if (cellLimit > 0) {
            return Math.min(numberOfPreviewImagesInPack, cellLimit);
        }
        return numberOfPreviewImagesInPack;
    }
}
