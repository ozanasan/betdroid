package com.exapmle.ozanasan.finaltwo;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ozanasan on 25/06/15.
 */
public class Match implements Parcelable {
    public String homeTeam;
    public String awayTeam;
    //private GeoPoint matchLocation;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        //this.matchLocation = matchLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
