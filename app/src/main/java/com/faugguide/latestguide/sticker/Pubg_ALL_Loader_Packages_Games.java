package com.faugguide.latestguide.sticker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.faugguide.latestguide.BuildConfig;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Pubg_ALL_Loader_Packages_Games {

    @NonNull
    public static ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> fetchStickerPacks(Context context) throws IllegalStateException {
        final Cursor cursor = context.getContentResolver().query(Pubg_ALL_Content_Rating_Provider_Game.AUTHORITY_URI, null, null, null, null);
        if (cursor == null) {
            throw new IllegalStateException("could not fetch from content provider, " + "com.faugguide.latestguide.stickercontentprovider");
        }
        HashSet<String> identifierSet = new HashSet<>();
        final ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList = fetchFromContentProvider(cursor);
        for (Pubg_ALL_Pack_Of_Sicker_Game stickerPack : stickerPackList) {
            if (identifierSet.contains(stickerPack.identifier)) {
                throw new IllegalStateException("sticker pack identifiers should be unique, there are more than one pack with identifier:" + stickerPack.identifier);
            } else {
                identifierSet.add(stickerPack.identifier);
            }
        }
        if (stickerPackList.isEmpty()) {
            throw new IllegalStateException("There should be at least one sticker pack in the app");
        }
        for (Pubg_ALL_Pack_Of_Sicker_Game stickerPack : stickerPackList) {
            final List<Games_Sticker_Parcelable_Pubg_ALL> stickers = getStickersForPack(context, stickerPack);
            stickerPack.setStickers(stickers);
            Latest_Game_Validator_Check_ListPubg_ALL.verifyStickerPackValidity(context, stickerPack);
        }
        return stickerPackList;
    }

    @NonNull
    private static List<Games_Sticker_Parcelable_Pubg_ALL> getStickersForPack(Context context, Pubg_ALL_Pack_Of_Sicker_Game stickerPack) {
        final List<Games_Sticker_Parcelable_Pubg_ALL> stickers = fetchFromContentProviderForStickers(stickerPack.identifier, context.getContentResolver());
        for (Games_Sticker_Parcelable_Pubg_ALL sticker : stickers) {
            final byte[] bytes;
            try {
                bytes = fetchStickerAsset(stickerPack.identifier, sticker.st_imgFileName, context.getContentResolver());
                if (bytes.length <= 0) {
                    throw new IllegalStateException("Asset file is empty, pack: " + stickerPack.name + ", sticker: " + sticker.st_imgFileName);
                }
                sticker.setSize(bytes.length);
            } catch (IOException | IllegalArgumentException e) {
                throw new IllegalStateException("Asset file doesn't exist. pack: " + stickerPack.name + ", sticker: " + sticker.st_imgFileName, e);
            }
        }
        return stickers;
    }


    @NonNull
    private static ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> fetchFromContentProvider(Cursor cursor) {
        ArrayList<Pubg_ALL_Pack_Of_Sicker_Game> stickerPackList = new ArrayList<>();
        cursor.moveToFirst();
        do {
            final String identifier = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_PACK_IDENTIFIER_IN_QUERY));
            final String name = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_PACK_NAME_IN_QUERY));
            final String publisher = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_PACK_PUBLISHER_IN_QUERY));
            final String trayImage = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_PACK_ICON_IN_QUERY));
            final String androidPlayStoreLink = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.ANDROID_APP_DOWNLOAD_LINK_IN_QUERY));
            final String iosAppLink = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.IOS_APP_DOWNLOAD_LINK_IN_QUERY));
            final String publisherEmail = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.PUBLISHER_EMAIL));
            final String publisherWebsite = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.PUBLISHER_WEBSITE));
            final String privacyPolicyWebsite = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.PRIVACY_POLICY_WEBSITE));
            final String licenseAgreementWebsite = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.LICENSE_AGREENMENT_WEBSITE));
            final Pubg_ALL_Pack_Of_Sicker_Game stickerPack = new Pubg_ALL_Pack_Of_Sicker_Game(identifier, name, publisher, trayImage, publisherEmail, publisherWebsite, privacyPolicyWebsite, licenseAgreementWebsite);
            stickerPack.setAndroidPlayStoreLink(androidPlayStoreLink);
            stickerPack.setIosAppStoreLink(iosAppLink);
            stickerPackList.add(stickerPack);
        } while (cursor.moveToNext());
        return stickerPackList;
    }

    @NonNull
    private static List<Games_Sticker_Parcelable_Pubg_ALL> fetchFromContentProviderForStickers(String identifier, ContentResolver contentResolver) {
        Uri uri = getStickerListUri(identifier);

        final String[] projection = {Pubg_ALL_Content_Rating_Provider_Game.STICKER_FILE_NAME_IN_QUERY, Pubg_ALL_Content_Rating_Provider_Game.STICKER_FILE_EMOJI_IN_QUERY};
        final Cursor cursor = contentResolver.query(uri, projection, null, null, null);
        List<Games_Sticker_Parcelable_Pubg_ALL> stickers = new ArrayList<>();
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                final String name = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_FILE_NAME_IN_QUERY));
                final String emojisConcatenated = cursor.getString(cursor.getColumnIndexOrThrow(Pubg_ALL_Content_Rating_Provider_Game.STICKER_FILE_EMOJI_IN_QUERY));
                stickers.add(new Games_Sticker_Parcelable_Pubg_ALL(name, Arrays.asList(emojisConcatenated.split(","))));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return stickers;
    }

    public static byte[] fetchStickerAsset(@NonNull final String identifier, @NonNull final String name, ContentResolver contentResolver) throws IOException {
        try (final InputStream inputStream = contentResolver.openInputStream(getStickerAssetUri(identifier, name));
             final ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            if (inputStream == null) {
                throw new IOException("cannot read sticker asset:" + identifier + "/" + name);
            }
            int read;
            byte[] data = new byte[16384];

            while ((read = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, read);
            }
            return buffer.toByteArray();
        }
    }

    private static Uri getStickerListUri(String identifier) {
        return new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority("com.faugguide.latestguide.stickercontentprovider").appendPath(Pubg_ALL_Content_Rating_Provider_Game.STICKERS).appendPath(identifier).build();
    }

    public static Uri getStickerAssetUri(String identifier, String stickerName) {
        return new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority("com.faugguide.latestguide.stickercontentprovider").appendPath(Pubg_ALL_Content_Rating_Provider_Game.STICKERS_ASSET).appendPath(identifier).appendPath(stickerName).build();
    }
}
