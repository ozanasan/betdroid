package com.exapmle.ozanasan.finaltwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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


class WeekAdapter extends ArrayAdapter<Week>{
    private final Context context;
    private final ArrayList<Week> weeksArrayList;

    public WeekAdapter(Context context, ArrayList<Week> weeksArrayList){
        super(context, R.layout.week_row, weeksArrayList);
        this.context = context;
        this.weeksArrayList = weeksArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.weeks_row, parent, false);

        TextView weekView = (TextView) rowView.findViewById(R.id.weekText);
        TextView scoreView = (TextView) rowView.findViewById(R.id.scoreText);
        TextView dateView = (TextView) rowView.findViewById(R.id.dateText);

        Integer weekCountForString = weeksArrayList.get(position).weekCount;
        String weekString = weekCountForString.toString();

        Integer userScoreForString = weeksArrayList.get(position).userScore;
        String scoreString = userScoreForString.toString();

        String dateString = weeksArrayList.get(position).closeDate;

        weekView.setText("Week " + weekString);
        scoreView.setText("Your Score : " + scoreString);
        dateView.setText("Closed At " + dateString);

        return rowView;
    }
}
