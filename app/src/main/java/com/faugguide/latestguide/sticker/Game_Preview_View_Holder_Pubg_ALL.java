package com.faugguide.latestguide.sticker;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.faugguide.latestguide.R;


public class Game_Preview_View_Holder_Pubg_ALL extends RecyclerView.ViewHolder {

    public SimpleDraweeView sd_sticPreviewView;

    Game_Preview_View_Holder_Pubg_ALL(final View itemView) {
        super(itemView);
        sd_sticPreviewView = itemView.findViewById(R.id.sticker_preview);
    }

}