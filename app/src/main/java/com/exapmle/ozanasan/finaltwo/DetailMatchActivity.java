package com.exapmle.ozanasan.finaltwo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DetailMatchActivity extends ActionBarActivity implements View.OnClickListener {

    TextView matchHeader;
    Match currentMatch;
    private TextView open_map_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_match);
        open_map_link = (TextView)findViewById(R.id.open_map);
        open_map_link.setOnClickListener(this);

        matchHeader = (TextView)findViewById(R.id.matchHeader);
        Bundle bundle = getIntent().getExtras();
        currentMatch = (Match)bundle.getSerializable("match");
        matchHeader.setText(currentMatch.homeTeam + " versus " + currentMatch.awayTeam);
    }


    @Override
    public void onClick(View v) {
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=37.423156,-122.084917"));
        DetailMatchActivity.this.startActivity(mapIntent);
    }
}
