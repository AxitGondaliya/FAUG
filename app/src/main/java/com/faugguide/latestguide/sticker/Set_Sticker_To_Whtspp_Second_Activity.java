// WAStickerApps whatsapp sticker app
//    WAStickerApps whatsapp stickers free download
//    WAStickerApps funny stickers for whatsapp
//    WAStickerApps whatsapp sticker download
//    WAStickerApps good morning stickers for whatsapp
//    WAStickerApps whatsapp animated stickers
//    WAStickerApps emoji stickers for whatsapp
//    WAStickerApps birthday stickers for whatsapp
//    WAStickerApps whatsapp status sticker
//    WAStickerApps whatsapp stickers images
//    WAStickerApps new stickers for whatsapp
//    WAStickerApps whatsapp smiley stickers
//    WAStickerApps stickers for whatsapp status
//    WAStickerApps romantic stickers for whatsapp
//    WAStickerApps live stickers for whatsapp
//    WAStickerApps good night stickers for whatsapp
//    WAStickerApps tamil stickers for whatsapp
//    WAStickerApps whatsapp single stickers
//    WAStickerApps cricket stickers for whatsapp
//    WAStickerApps whatsapp sticker pic
//    WAStickerApps indian stickers for whatsapp
//    WAStickerApps animated love stickers for whatsapp
//    WAStickerApps whatsapp stickers free download for android
//    WAStickerApps whatsapp sticker apk
//    WAStickerApps how to download stickers for whatsapp
//    WAStickerApps hot stickers for whatsapp
//    WAStickerApps stickers for whatsapp free
//    WAStickerApps whatsapp stickers apk free download
//    WAStickerApps whatsapp new stickers download
//    WAStickerApps best sticker app for whatsapp
//    WAStickerApps send stickers on whatsapp
//    WAStickerApps live whatsapp stickers
//    WAStickerApps sticker download for whatsapp
//    WAStickerApps beautiful stickers for whatsapp
//    WAStickerApps hug stickers for whatsapp
//    WAStickerApps kiss stickers for whatsapp
//    WAStickerApps download love stickers for whatsapp
//    WAStickerApps motion stickers for whatsapp
//    WAStickerApps stickers free for whatsapp
//    WAStickerApps stickers whatsapp
//    WAStickerApps happy birthday sticker for whatsapp
package com.faugguide.latestguide.sticker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.faugguide.latestguide.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class Set_Sticker_To_Whtspp_Second_Activity extends Pubg_All_Base_WASticker_Games {

    static class Pubg_LoadList_AsyncTask extends AsyncTask<Void, Void, Pair<String, ArrayList<Pubg_ALL_Pack_Of_Sicker_Game>>> {
        private final WeakReference<Set_Sticker_To_Whtspp_Second_Activity> contextWeakReference;

        Pubg_LoadList_AsyncTask(Set_Sticker_To_Whtspp_Second_Activity activity) {
            this.contextWeakReference = new WeakReference<>(activity);
        }

        @SuppressLint("LongLogTag")
        @Override
        protected Pair<String, ArrayList<Pubg_ALL_Pack_Of_Sicker_Game>> doInBackground(Void... voids) {
            ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList;
            try {
                final Context context = contextWeakReference.get();
                if (context != null) {
                    stickerPackList = Pubg_ALL_Loader_Packages_Games.fetchStickerPacks(context);
                    if (stickerPackList.size() == 0) {
                        return new Pair<>("could not find any packs", null);
                    }
                    for (Pubg_ALL_Pack_Of_Sicker_Game stickerPack : stickerPackList) {
                        Latest_Game_Validator_Check_ListPubg_ALL.verifyStickerPackValidity(context, stickerPack);
                    }
                    return new Pair<>(null, stickerPackList);
                } else {
                    return new Pair<>("could not fetch sticker packs", null);
                }
            } catch (Exception e) {
                Log.e("Set_Sticker_To_Whtspp_Second_Activity", "error fetching sticker packs", e);
                return new Pair<>(e.getMessage(), null);
            }
        }

        @Override
        protected void onPostExecute(Pair<String, ArrayList<Pubg_ALL_Pack_Of_Sicker_Game>> stringListPair) {

            final Set_Sticker_To_Whtspp_Second_Activity entryActivity = contextWeakReference.get();
            if (entryActivity != null) {
                if (stringListPair.first != null) {
                    entryActivity.showErrorMessage(stringListPair.first);
                } else {
                    entryActivity.showStickerPack(stringListPair.second);
                }
            }
        }
    }

    private Pubg_LoadList_AsyncTask Pubg__loadList_AsyncTask;
    private View Pubg_View_Progress_Bar;

    Toolbar toolbar;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_second_whtspp_to_sticker_set);
        overridePendingTransition(0, 0);

        toolbar = (Toolbar) findViewById(R.id.toolbar_sticker);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Pubg_View_Progress_Bar = findViewById(R.id.entry_activity_progress);
        Pubg__loadList_AsyncTask = new Pubg_LoadList_AsyncTask(this);
        Pubg__loadList_AsyncTask.execute();
    }

    private void showStickerPack(ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList) {
        Pubg_View_Progress_Bar.setVisibility(View.GONE);
        if (stickerPackList.size() > 1) {
            final Intent intent = new Intent(this, Pubg_ALL_of_Pack_Grid_View_list_Game.class);
            intent.putParcelableArrayListExtra(Pubg_ALL_of_Pack_Grid_View_list_Game.EXTRA_STICKER_PACK_LIST_DATA, stickerPackList);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        } else {
            final Intent intent = new Intent(this, Pubg_ALL_Pack_Info_Details_Game.class);
            intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_SHOW_UP_BUTTON, false);
            intent.putExtra(Pubg_ALL_Pack_Info_Details_Game.EXTRA_STICKER_PACK_DATA, stickerPackList.get(0));
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @SuppressLint("LongLogTag")
    private void showErrorMessage(String errorMessage) {
        Pubg_View_Progress_Bar.setVisibility(View.GONE);
        Log.e("Set_Sticker_To_Whtspp_Second_Activity", "error fetching sticker packs, " + errorMessage);
        final TextView errorMessageTV = findViewById(R.id.error_message);
        errorMessageTV.setText(getString(R.string.error_message, errorMessage));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Pubg__loadList_AsyncTask != null && !Pubg__loadList_AsyncTask.isCancelled()) {
            Pubg__loadList_AsyncTask.cancel(true);
        }
    }
}
