package com.exapmle.ozanasan.finaltwo;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ozanasan on 25/06/15.
 */

public class Match implements Serializable {
    public String homeTeam;
    public String awayTeam;
    public String location = "geo:0,0?q=37.423156,-122.084917";
    //private GeoPoint matchLocation;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        //this.matchLocation = matchLocation;
    }

    /*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(homeTeam);
        dest.writeString(awayTeam);
    }

    public static final Parcelable.Creator<Match> CREATOR = new Parcelable.Creator<Match>() {

        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        public Match[] newArray(int size) {
            return new Match[size];
        }
    };
    */
}
