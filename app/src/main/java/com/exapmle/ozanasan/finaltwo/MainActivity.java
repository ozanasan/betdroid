package com.exapmle.ozanasan.finaltwo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

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

            rowView.setClickable(true);
            rowView.setFocusable(true);

            Integer weekCountForString = weeksArrayList.get(position).weekCount;
            final String weekString = weekCountForString.toString();

            Integer userScoreForString = weeksArrayList.get(position).userScore;
            String scoreString = userScoreForString.toString();

            String dateString = weeksArrayList.get(position).closeDate;

            weekView.setText("Week " + weekString);
            scoreView.setText("Your Score : " + scoreString);
            dateView.setText("Closed At " + dateString);

            View.OnClickListener yourClickListener = new View.OnClickListener() {
                public void onClick(View v) {
                    Log.i("Hello: ", "I am here and my week value is: " + weekString);
                    Intent detailIntent = new Intent(MainActivity.this, DetailWeekActivity.class);
                    detailIntent.putExtra(getString(R.string.week_count), weekString);
                    startActivity(detailIntent);
                    //v.callOnClick();
                }
            };

            rowView.setOnClickListener(yourClickListener);
            return rowView;
        }

        @Override
        public boolean areAllItemsEnabled()
        {
            return true;
        }

        @Override
        public boolean isEnabled(int arg0)
        {
            return true;
        }
    }

    private ListView mListView1, mListView2;

    private Week thisWeek;

    private String [] data1 ={"Week 15"};
    private String [] data2 ={"Week 14", "Week 13", "Week 12", "Week 11", "Week 10", "Week 9", "Week 8", "Week 7", "Week 6", "Week 5", "Week 4", "Week 3", "Week 2", "Week 1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView1 = (ListView)findViewById(R.id.listView1);
        mListView2 = (ListView)findViewById(R.id.listView2);

        WeekAdapter weekAdapter = new WeekAdapter(this, getWeekList());

        mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1));
        mListView2.setAdapter(weekAdapter);

        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);


        Intent detailIntent = new Intent(this, DetailWeekActivity.class);

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Hey: ", "I am on list-1 listener");
                Toast myToast = Toast.makeText(MainActivity.this, "selected week", Toast.LENGTH_LONG);
                myToast.show();

            }
        });


        mListView2.setOnItemClickListener(selectWeek);
    }

    private AdapterView.OnItemClickListener selectWeek = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.i("Hey: ", "New on click listener for list 2");
        }
    };

    private ArrayList<Week> getWeekList(){
        ArrayList<Week> weeks = new ArrayList<Week>();
        weeks.add(new Week(14, 3000, "11/03/2105"));
        weeks.add(new Week(13, 2500, "2/03/2015"));
        weeks.add(new Week(12, 2700, "27/02/2015"));
        weeks.add(new Week(11, 1700, "27/02/2015"));
        weeks.add(new Week(10, 3200, "27/02/2015"));
        weeks.add(new Week(9, 8000, "27/02/2015"));
        weeks.add(new Week(8, 4200, "27/02/2015"));
        weeks.add(new Week(7, 3300, "27/02/2015"));
        weeks.add(new Week(6, 1100, "27/02/2015"));
        return weeks;
    }

    public static class ListUtils {



        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = MeasureSpec.makeMeasureSpec(mListView.getWidth(), MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}





