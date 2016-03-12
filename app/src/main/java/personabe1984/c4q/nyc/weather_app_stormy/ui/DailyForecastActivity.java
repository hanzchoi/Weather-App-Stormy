package personabe1984.c4q.nyc.weather_app_stormy.ui;

import android.app.ListActivity;
import android.os.Bundle;

import personabe1984.c4q.nyc.weather_app_stormy.R;

public class DailyForecastActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        
    }
}
