package com.exapmle.ozanasan.finaltwo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.OnClickListener;

/**
 * Created by ozanasan on 21/06/15.
 */




class Week {

    int weekCount;
    int userScore;
    String closeDate;

    public Week(int weekCount, int userScore, String closeDate){
        super();
        this.weekCount = weekCount;
        this.userScore = userScore;
        this.closeDate = closeDate;
    }
}



