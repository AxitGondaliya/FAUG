package com.faugguide.latestguide.sticker;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.R;

public class ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL extends RecyclerView.ViewHolder {

    TextView Pubg__publisherView_;
    LinearLayout Pubg__imageRowView_;
    View Pubg__container_;
    TextView Pubg__filesizeView_;
    ImageView Pubg__addButton_;
    TextView Pubg__titleView_;

    ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL(final View itemView) {
        super(itemView);
        Pubg__container_ = itemView;
        Pubg__titleView_ = itemView.findViewById(R.id.sticker_pack_title);
        Pubg__publisherView_ = itemView.findViewById(R.id.sticker_pack_publisher);
        Pubg__filesizeView_ = itemView.findViewById(R.id.sticker_pack_filesize);
        Pubg__addButton_ = itemView.findViewById(R.id.add_button_on_list);
        Pubg__imageRowView_ = itemView.findViewById(R.id.sticker_packs_list_item_image_list);
    }
}