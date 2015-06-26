package com.exapmle.ozanasan.finaltwo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;


public class DetailWeekActivity extends ActionBarActivity {

    private TextView headerTextView;
    private ListView listView;

    private String weekString;
    private Intent intentThatStartedMe;


    //private String[] data1 = {"HMmm", "Hello", "Myyyyy"};

    protected ArrayList<Match> matchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_week);
        setHeaderText();
        setMatchListView();
    }

    private void setMatchListView(){
        listView = (ListView)findViewById(R.id.listViewWeekDetail);
        listView.setAdapter(getListAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentForMatchDetail = new Intent(DetailWeekActivity.this, DetailMatchActivity.class);



                Match match = (Match)DetailWeekActivity.this.matchList.get(position);

                intentForMatchDetail.putExtra("match", match);
                startActivity(intentForMatchDetail);
                Log.i("Helooo: ", "On click oldu");
            }
        });
    }

    private ArrayAdapter getListAdapter(){
        return new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getMatchListForSimpleRow());
    }

    private void setHeaderText(){
        headerTextView = (TextView)findViewById(R.id.weakHeaderText);
        intentThatStartedMe = getIntent();
        weekString = intentThatStartedMe.getStringExtra(getString(R.string.week_count));
        headerTextView.setText("Week " + weekString);
    }

    private ArrayList<String> getMatchListForSimpleRow(){
        matchList = getMatchList();
        ArrayList<String> returnList = new ArrayList<String>();

        int index = 0;
        /*
        for(Iterator<Match> match = matchList.iterator(); match.hasNext(); ){
            Match item = match.next();
            returnList[index] = item.homeTeam + "   -   " + item.awayTeam;    //add(item.homeTeam + "   -   " + item.awayTeam);
            index++;
        }
        */

        for(Match match : matchList){
            returnList.add(match.homeTeam + "   -   " + match.awayTeam);    //add(item.homeTeam + "   -   " + item.awayTeam));
            index++;
        }


        //returnList.add("Hmmm");
        //returnList.add("Temam");

        return returnList;
    }

    private ArrayList<Match> getMatchList(){
        Match matchOne = new Match("Fenerbahce", "Galatasaray");
        Match matchTwo = new Match("Chelsea", "Manchester United");
        Match matchThe = new Match("Milan", "Rome");

        ArrayList<Match> result = new ArrayList<Match>();
        result.add(matchOne); result.add(matchTwo); result.add(matchThe);
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_week, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
