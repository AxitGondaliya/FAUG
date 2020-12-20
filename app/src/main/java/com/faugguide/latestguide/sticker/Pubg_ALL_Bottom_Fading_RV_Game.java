package com.faugguide.latestguide.sticker;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class Pubg_ALL_Bottom_Fading_RV_Game extends RecyclerView {
    public Pubg_ALL_Bottom_Fading_RV_Game(Context context) {
        super(context);
    }

    public Pubg_ALL_Bottom_Fading_RV_Game(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pubg_ALL_Bottom_Fading_RV_Game(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }
}
