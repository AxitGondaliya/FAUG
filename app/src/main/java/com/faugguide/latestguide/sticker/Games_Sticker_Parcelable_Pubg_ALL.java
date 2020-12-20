package com.faugguide.latestguide.sticker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

class Games_Sticker_Parcelable_Pubg_ALL implements Parcelable {
    String st_imgFileName;
    List<String> emojis;
    long size;

    Games_Sticker_Parcelable_Pubg_ALL(String imageFileName, List<String> emojis) {
        this.st_imgFileName = imageFileName;
        this.emojis = emojis;
    }

    protected Games_Sticker_Parcelable_Pubg_ALL(Parcel in) {
        st_imgFileName = in.readString();
        emojis = in.createStringArrayList();
        size = in.readLong();
    }

    public static final Creator<Games_Sticker_Parcelable_Pubg_ALL> CREATOR = new Creator<Games_Sticker_Parcelable_Pubg_ALL>() {
        @Override
        public Games_Sticker_Parcelable_Pubg_ALL createFromParcel(Parcel in) {
            return new Games_Sticker_Parcelable_Pubg_ALL(in);
        }

        @Override
        public Games_Sticker_Parcelable_Pubg_ALL[] newArray(int size) {
            return new Games_Sticker_Parcelable_Pubg_ALL[size];
        }
    };

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(st_imgFileName);
        dest.writeStringList(emojis);
        dest.writeLong(size);
    }
}
