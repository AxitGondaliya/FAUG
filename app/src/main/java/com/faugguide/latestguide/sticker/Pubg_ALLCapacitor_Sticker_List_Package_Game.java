package com.faugguide.latestguide.sticker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.format.Formatter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.faugguide.latestguide.R;


import java.util.List;

public class Pubg_ALLCapacitor_Sticker_List_Package_Game extends RecyclerView.Adapter<ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL> {

    @NonNull
    private List<Pubg_ALL_Pack_Of_Sicker_Game> stickerPacks;

    @NonNull
    private final OnAddButtonClickedListener onAddButtonClickedListener;

    private int maxNumberOfStickersInARow;

    Pubg_ALLCapacitor_Sticker_List_Package_Game(@NonNull List<Pubg_ALL_Pack_Of_Sicker_Game> stickerPacks, @NonNull OnAddButtonClickedListener onAddButtonClickedListener) {
        this.stickerPacks = stickerPacks;
        this.onAddButtonClickedListener = onAddButtonClickedListener;
    }

    @NonNull
    @Override
    public ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final Context context = viewGroup.getContext();
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View stickerPackRow = layoutInflater.inflate(R.layout.latest_package_list_wasticker_item_adpater, viewGroup, false);
        return new ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL(stickerPackRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL viewHolder, final int index) {
        Pubg_ALL_Pack_Of_Sicker_Game pack = stickerPacks.get(index);
        final Context context = viewHolder.Pubg__publisherView_.getContext();
        viewHolder.Pubg__publisherView_.setText(pack.publisher);
        viewHolder.Pubg__filesizeView_.setText(Formatter.formatShortFileSize(context, pack.getTotalSize()));
        viewHolder.Pubg__titleView_.setText(pack.name);
        viewHolder.Pubg__container_.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Pubg_ALL_Pack_Info_Details_Game.class);
            intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_SHOW_UP_BUTTON, true);
            intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_DATA, pack);
            view.getContext().startActivity(intent);
        });
        viewHolder.Pubg__imageRowView_.removeAllViews();
        int actualNumberOfStickersToShow = Math.min(maxNumberOfStickersInARow, pack.getStickers().size());
        for (int i = 0; i < actualNumberOfStickersToShow; i++) {
            final SimpleDraweeView rowImage = (SimpleDraweeView) LayoutInflater.from(context).inflate(R.layout.pubg_all_adpate_list_item_pictures_game, viewHolder.Pubg__imageRowView_, false);
            rowImage.setImageURI(Pubg_ALL_Loader_Packages_Games.getStickerAssetUri(pack.identifier, pack.getStickers().get(i).st_imgFileName));
            final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) rowImage.getLayoutParams();
            final int marginBetweenImages = (viewHolder.Pubg__imageRowView_.getMeasuredWidth() - maxNumberOfStickersInARow * viewHolder.Pubg__imageRowView_.getContext().getResources().getDimensionPixelSize(R.dimen.sticker_pack_list_item_preview_image_size)) / (maxNumberOfStickersInARow - 1) - lp.leftMargin - lp.rightMargin;
            if (i != actualNumberOfStickersToShow - 1 && marginBetweenImages > 0) { //do not set the margin for the last image
                lp.setMargins(lp.leftMargin, lp.topMargin, lp.rightMargin + marginBetweenImages, lp.bottomMargin);
                rowImage.setLayoutParams(lp);
            }
            viewHolder.Pubg__imageRowView_.addView(rowImage);
        }
        setAddButtonAppearance(viewHolder.Pubg__addButton_, pack);
    }

    private void setAddButtonAppearance(ImageView addButton, Pubg_ALL_Pack_Of_Sicker_Game pack) {
        if (pack.getIsWhitelisted()) {
            addButton.setImageResource(R.drawable.pubg_gameker_right_click_img);
            addButton.setClickable(false);
            addButton.setOnClickListener(null);
            setBackground(addButton, null);
        } else {
            addButton.setImageResource(R.drawable.ic_baseline_add_24);
            addButton.setOnClickListener(v -> onAddButtonClickedListener.onAddButtonClicked(pack));
            TypedValue outValue = new TypedValue();
            addButton.getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            addButton.setBackgroundResource(outValue.resourceId);
        }
    }

    private void setBackground(View view, Drawable background) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    @Override
    public int getItemCount() {
        return stickerPacks.size();
    }

    void setMaxNumberOfStickersInARow(int maxNumberOfStickersInARow) {
        if (this.maxNumberOfStickersInARow != maxNumberOfStickersInARow) {
            this.maxNumberOfStickersInARow = maxNumberOfStickersInARow;
            notifyDataSetChanged();
        }
    }

    public void setStickerPackList(List<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList) {
        this.stickerPacks = stickerPackList;
    }

    public interface OnAddButtonClickedListener {
        void onAddButtonClicked(Pubg_ALL_Pack_Of_Sicker_Game stickerPack);
    }
}
