package com.exapmle.ozanasan.finaltwo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailMatchActivity extends ActionBarActivity {

    TextView matchHeader;
    Match currentMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_match);

        matchHeader = (TextView)findViewById(R.id.matchHeader);
        Bundle bundle = getIntent().getExtras();
        currentMatch = (Match)bundle.getSerializable("match");
        matchHeader.setText(currentMatch.homeTeam + " versus " + currentMatch.awayTeam);
    }



}
