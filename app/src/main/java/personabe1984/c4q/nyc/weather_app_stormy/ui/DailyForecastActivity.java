package personabe1984.c4q.nyc.weather_app_stormy.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import personabe1984.c4q.nyc.weather_app_stormy.R;
import personabe1984.c4q.nyc.weather_app_stormy.adapters.DayAdapter;
import personabe1984.c4q.nyc.weather_app_stormy.weather.Day;

public class DailyForecastActivity extends Activity {

    private Day[] mDays;
    @Bind(android.R.id.list) ListView mListView;
    @Bind(android.R.id.empty) TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);

        /*
        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                daysOfTheWeek);
        setListAdapter(adapter);
        */
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays );
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mEmptyTextView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek = mDays[position].getDayOfTheWeek();
                String conditions = mDays[position].getSummary();
                String highTemp = mDays[position].getTemperatureMax() + "";
                String message = String.format("On %s the high will be %s and it will be %s",
                        dayOfTheWeek,
                        conditions,
                        highTemp);
                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


    }

}
