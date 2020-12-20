package com.faugguide.latestguide.sticker;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faugguide.latestguide.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pubg_ALL_of_Pack_Grid_View_list_Game extends Pubg_Adding_Sticker_pubg {
    public static final String EXTRA_STICKER_PACK_LIST_DATA = "sticker_pack_list";
    private static final int STICKER_PREVIEW_DISPLAY_LIMIT = 5;
    private LinearLayoutManager ll_packLayoutManager;
    private RecyclerView rv_packRecyclerView;
    private Pubg_ALLCapacitor_Sticker_List_Package_Game allStickerPacksListAdapter;
    private WhiteListCheckAsyncTask whiteListCheckAsyncTask;
    private ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> ar_stickerPackList;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pubg_all_list_of_grid_view_game);

        rv_packRecyclerView = findViewById(R.id.sticker_pack_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar_sticker_detail);

        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        ar_stickerPackList = getIntent().getParcelableArrayListExtra(EXTRA_STICKER_PACK_LIST_DATA);
        showStickerPackList(ar_stickerPackList);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        whiteListCheckAsyncTask = new WhiteListCheckAsyncTask(this);
        whiteListCheckAsyncTask.execute(ar_stickerPackList.toArray(new Pubg_ALL_Pack_Of_Sicker_Game[ar_stickerPackList.size()]));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (whiteListCheckAsyncTask != null && !whiteListCheckAsyncTask.isCancelled()) {
            whiteListCheckAsyncTask.cancel(true);
        }
    }

    private void showStickerPackList(List<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList) {
        allStickerPacksListAdapter = new Pubg_ALLCapacitor_Sticker_List_Package_Game(stickerPackList, onAddButtonClickedListener);
        rv_packRecyclerView.setAdapter(allStickerPacksListAdapter);
        ll_packLayoutManager = new LinearLayoutManager(this);
        ll_packLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                rv_packRecyclerView.getContext(),
                ll_packLayoutManager.getOrientation()
        );
        rv_packRecyclerView.addItemDecoration(dividerItemDecoration);
        rv_packRecyclerView.setLayoutManager(ll_packLayoutManager);
        rv_packRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this::recalculateColumnCount);
    }


    private final Pubg_ALLCapacitor_Sticker_List_Package_Game.OnAddButtonClickedListener onAddButtonClickedListener = new Pubg_ALLCapacitor_Sticker_List_Package_Game.OnAddButtonClickedListener() {
        @Override
        public void onAddButtonClicked(Pubg_ALL_Pack_Of_Sicker_Game pack) {
            Pubg_ALL_of_Pack_Grid_View_list_Game.this.addStickerPackToWhatsApp(pack.identifier, pack.name);
        }
    };

    private void recalculateColumnCount() {
        final int previewSize = getResources().getDimensionPixelSize(R.dimen.sticker_pack_list_item_preview_image_size);
        int firstVisibleItemPosition = ll_packLayoutManager.findFirstVisibleItemPosition();
        ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL viewHolder = (ALl_Sticerk_Recycler_View_List_Holder_Pubg_ALL) rv_packRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
        if (viewHolder != null) {
            final int max = Math.max(viewHolder.Pubg__imageRowView_.getMeasuredWidth() / previewSize, 1);
            int numColumns = Math.min(STICKER_PREVIEW_DISPLAY_LIMIT, max);
            allStickerPacksListAdapter.setMaxNumberOfStickersInARow(numColumns);
        }
    }


    static class WhiteListCheckAsyncTask extends AsyncTask<Pubg_ALL_Pack_Of_Sicker_Game, Void, List<Pubg_ALL_Pack_Of_Sicker_Game>> {
        private final WeakReference<Pubg_ALL_of_Pack_Grid_View_list_Game> stickerPackListActivityWeakReference;

        WhiteListCheckAsyncTask(Pubg_ALL_of_Pack_Grid_View_list_Game stickerPackListActivity) {
            this.stickerPackListActivityWeakReference = new WeakReference<>(stickerPackListActivity);
        }

        @Override
        protected final List<Pubg_ALL_Pack_Of_Sicker_Game> doInBackground(Pubg_ALL_Pack_Of_Sicker_Game... stickerPackArray) {
            final Pubg_ALL_of_Pack_Grid_View_list_Game stickerPackListActivity = stickerPackListActivityWeakReference.get();
            if (stickerPackListActivity == null) {
                return Arrays.asList(stickerPackArray);
            }
            for (Pubg_ALL_Pack_Of_Sicker_Game stickerPack : stickerPackArray) {
                stickerPack.setIsWhitelisted(play_White_List_Checking_Latest_Game.isWhitelisted(stickerPackListActivity, stickerPack.identifier));
            }
            return Arrays.asList(stickerPackArray);
        }

        @Override
        protected void onPostExecute(List<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList) {
            final Pubg_ALL_of_Pack_Grid_View_list_Game stickerPackListActivity = stickerPackListActivityWeakReference.get();
            if (stickerPackListActivity != null) {
                stickerPackListActivity.allStickerPacksListAdapter.setStickerPackList(stickerPackList);
                stickerPackListActivity.allStickerPacksListAdapter.notifyDataSetChanged();
            }
        }
    }
}
