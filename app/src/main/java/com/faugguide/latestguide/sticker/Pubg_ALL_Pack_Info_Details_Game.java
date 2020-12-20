package com.faugguide.latestguide.sticker;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.R;

import java.lang.ref.WeakReference;
public class Pubg_ALL_Pack_Info_Details_Game extends Pubg_Adding_Sticker_pubg {
    public static final String EXTRA_STICKER_PACK_ID = "sticker_pack_id";
    public static final String EXTRA_STICKER_PACK_AUTHORITY = "sticker_pack_authority";
    public static final String EXTRA_STICKER_PACK_NAME = "sticker_pack_name";
    public static final String EXTRA_STICKER_PACK_WEBSITE = "sticker_pack_website";
    public static final String EXTRA_STICKER_PACK_EMAIL = "sticker_pack_email";
    public static final String EXTRA_STICKER_PACK_PRIVACY_POLICY = "sticker_pack_privacy_policy";
    public static final String EXTRA_STICKER_PACK_TRAY_ICON = "sticker_pack_tray_icon";
    public static final String EXTRA_SHOW_UP_BUTTON = "show_up_button";
    public static final String EXTRA_STICKER_PACK_DATA = "sticker_pack";
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private Pubg_ALL_Holder_Preview_Capacitor_Games stickerPreviewAdapter;
    private int numColumns;
    private View addButton;
    private View alreadyAddedText;
    private Pubg_ALL_Pack_Of_Sicker_Game stickerPack;
    private View divider;
    private WhiteListCheckAsyncTask whiteListCheckAsyncTask;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pubgall_pack_details_inform_game);



        boolean showUpButton = getIntent().getBooleanExtra(EXTRA_SHOW_UP_BUTTON, false);
        stickerPack = getIntent().getParcelableExtra(EXTRA_STICKER_PACK_DATA);
        TextView packNameTextView = findViewById(R.id.pack_name);
        TextView packPublisherTextView = findViewById(R.id.author);
        ImageView packTrayIcon = findViewById(R.id.tray_image);
        TextView packSizeTextView = findViewById(R.id.pack_size);
        addButton = findViewById(R.id.add_to_whatsapp_button);
        alreadyAddedText = findViewById(R.id.already_added_text);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView = findViewById(R.id.sticker_list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(pageLayoutListener);
        recyclerView.addOnScrollListener(dividerScrollListener);
        divider = findViewById(R.id.divider);
        if (stickerPreviewAdapter == null) {
            stickerPreviewAdapter = new Pubg_ALL_Holder_Preview_Capacitor_Games(getLayoutInflater(), R.drawable.pubg_game_error_icon, getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_size), getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_padding), stickerPack);
            recyclerView.setAdapter(stickerPreviewAdapter);
        }
        packNameTextView.setText(stickerPack.name);
        packPublisherTextView.setText(stickerPack.publisher);
        packTrayIcon.setImageURI(Pubg_ALL_Loader_Packages_Games.getStickerAssetUri(stickerPack.identifier, stickerPack.trayImageFile));
        packSizeTextView.setText(Formatter.formatShortFileSize(this, stickerPack.getTotalSize()));
        addButton.setOnClickListener(v -> addStickerPackToWhatsApp(stickerPack.identifier, stickerPack.name));
        toolbar = (Toolbar) findViewById(R.id.toolbar_sticker_detail_two);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void launchInfoActivity(String publisherWebsite, String publisherEmail, String privacyPolicyWebsite, String trayIconUriString) {
        Intent intent = new Intent(Pubg_ALL_Pack_Info_Details_Game.this, Pubg_All_Bage_Pack_Infomation_game.class);
        intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_ID, stickerPack.identifier);
        intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_WEBSITE, publisherWebsite);
        intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_EMAIL, publisherEmail);
        intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_PRIVACY_POLICY, privacyPolicyWebsite);
        intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_TRAY_ICON, trayIconUriString);
        startActivity(intent);
    }


    private final ViewTreeObserver.OnGlobalLayoutListener pageLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            setNumColumns(recyclerView.getWidth() / recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_size));
        }
    };

    private void setNumColumns(int numColumns) {
        if (this.numColumns != numColumns) {
            layoutManager.setSpanCount(numColumns);
            this.numColumns = numColumns;
            if (stickerPreviewAdapter != null) {
                stickerPreviewAdapter.notifyDataSetChanged();
            }
        }
    }

    private final RecyclerView.OnScrollListener dividerScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull final RecyclerView recyclerView, final int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            updateDivider(recyclerView);
        }

        @Override
        public void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy) {
            super.onScrolled(recyclerView, dx, dy);
            updateDivider(recyclerView);
        }

        private void updateDivider(RecyclerView recyclerView) {
            boolean showDivider = recyclerView.computeVerticalScrollOffset() > 0;
            if (divider != null) {
                divider.setVisibility(showDivider ? View.VISIBLE : View.INVISIBLE);
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        whiteListCheckAsyncTask = new WhiteListCheckAsyncTask(this);
        whiteListCheckAsyncTask.execute(stickerPack);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (whiteListCheckAsyncTask != null && !whiteListCheckAsyncTask.isCancelled()) {
            whiteListCheckAsyncTask.cancel(true);
        }
    }

    private void updateAddUI(Boolean isWhitelisted) {
        if (isWhitelisted) {
            addButton.setVisibility(View.GONE);
            alreadyAddedText.setVisibility(View.VISIBLE);
        } else {
            addButton.setVisibility(View.VISIBLE);
            alreadyAddedText.setVisibility(View.GONE);
        }
    }

    static class WhiteListCheckAsyncTask extends AsyncTask<Pubg_ALL_Pack_Of_Sicker_Game, Void, Boolean> {
        private final WeakReference<Pubg_ALL_Pack_Info_Details_Game> stickerPackDetailsActivityWeakReference;

        WhiteListCheckAsyncTask(Pubg_ALL_Pack_Info_Details_Game stickerPackListActivity) {
            this.stickerPackDetailsActivityWeakReference = new WeakReference<>(stickerPackListActivity);
        }

        @Override
        protected final Boolean doInBackground(Pubg_ALL_Pack_Of_Sicker_Game... stickerPacks) {
            Pubg_ALL_Pack_Of_Sicker_Game stickerPack = stickerPacks[0];
            final Pubg_ALL_Pack_Info_Details_Game stickerPackDetailsActivity = stickerPackDetailsActivityWeakReference.get();
            //noinspection SimplifiableIfStatement
            if (stickerPackDetailsActivity == null) {
                return false;
            }
            return play_White_List_Checking_Latest_Game.isWhitelisted(stickerPackDetailsActivity, stickerPack.identifier);
        }

        @Override
        protected void onPostExecute(Boolean isWhitelisted) {
            final Pubg_ALL_Pack_Info_Details_Game stickerPackDetailsActivity = stickerPackDetailsActivityWeakReference.get();
            if (stickerPackDetailsActivity != null) {
                stickerPackDetailsActivity.updateAddUI(isWhitelisted);
            }
        }
    }
}
