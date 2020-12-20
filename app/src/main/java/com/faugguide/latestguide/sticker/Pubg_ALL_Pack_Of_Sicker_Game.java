package com.faugguide.latestguide.sticker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pubg_ALL_Pack_Of_Sicker_Game implements Parcelable {
    String identifier;
    String name;
    String publisher;
    String trayImageFile;
    final String publisherEmail;
    final String publisherWebsite;
    final String privacyPolicyWebsite;
    final String licenseAgreementWebsite;

    String iosAppStoreLink;
    private List<Games_Sticker_Parcelable_Pubg_ALL> stickers;
    private long totalSize;
    String androidPlayStoreLink;
    private boolean isWhitelisted;

    Pubg_ALL_Pack_Of_Sicker_Game(String identifier, String name, String publisher, String trayImageFile, String publisherEmail, String publisherWebsite, String privacyPolicyWebsite, String licenseAgreementWebsite) {
        this.identifier = identifier;
        this.name = name;
        this.publisher = publisher;
        this.trayImageFile = trayImageFile;
        this.publisherEmail = publisherEmail;
        this.publisherWebsite = publisherWebsite;
        this.privacyPolicyWebsite = privacyPolicyWebsite;
        this.licenseAgreementWebsite = licenseAgreementWebsite;
    }

    void setIsWhitelisted(boolean isWhitelisted) {
        this.isWhitelisted = isWhitelisted;
    }

    boolean getIsWhitelisted() {
        return isWhitelisted;
    }

    protected Pubg_ALL_Pack_Of_Sicker_Game(Parcel in) {
        identifier = in.readString();
        name = in.readString();
        publisher = in.readString();
        trayImageFile = in.readString();
        publisherEmail = in.readString();
        publisherWebsite = in.readString();
        privacyPolicyWebsite = in.readString();
        licenseAgreementWebsite = in.readString();
        iosAppStoreLink = in.readString();
        stickers = in.createTypedArrayList(Games_Sticker_Parcelable_Pubg_ALL.CREATOR);
        totalSize = in.readLong();
        androidPlayStoreLink = in.readString();
        isWhitelisted = in.readByte() != 0;
    }

    public static final Creator<Pubg_ALL_Pack_Of_Sicker_Game> CREATOR = new Creator<Pubg_ALL_Pack_Of_Sicker_Game>() {
        @Override
        public Pubg_ALL_Pack_Of_Sicker_Game createFromParcel(Parcel in) {
            return new Pubg_ALL_Pack_Of_Sicker_Game(in);
        }

        @Override
        public Pubg_ALL_Pack_Of_Sicker_Game[] newArray(int size) {
            return new Pubg_ALL_Pack_Of_Sicker_Game[size];
        }
    };

    void setStickers(List<Games_Sticker_Parcelable_Pubg_ALL> stickers) {
        this.stickers = stickers;
        totalSize = 0;
        for (Games_Sticker_Parcelable_Pubg_ALL sticker : stickers) {
            totalSize += sticker.size;
        }
    }

    public void setAndroidPlayStoreLink(String androidPlayStoreLink) {
        this.androidPlayStoreLink = androidPlayStoreLink;
    }

    public void setIosAppStoreLink(String iosAppStoreLink) {
        this.iosAppStoreLink = iosAppStoreLink;
    }

    public List<Games_Sticker_Parcelable_Pubg_ALL> getStickers() {
        return stickers;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identifier);
        dest.writeString(name);
        dest.writeString(publisher);
        dest.writeString(trayImageFile);
        dest.writeString(publisherEmail);
        dest.writeString(publisherWebsite);
        dest.writeString(privacyPolicyWebsite);
        dest.writeString(licenseAgreementWebsite);
        dest.writeString(iosAppStoreLink);
        dest.writeTypedList(stickers);
        dest.writeLong(totalSize);
        dest.writeString(androidPlayStoreLink);
        dest.writeByte((byte) (isWhitelisted ? 1 : 0));
    }
}
