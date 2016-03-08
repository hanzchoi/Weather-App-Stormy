package personabe1984.c4q.nyc.weather_app_stormy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "b1d867ce8f77a9747acbcdc2a3054b92";
        double latitude = 37.8267;
        double longitude = -122.423;

        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        //Creating the okhttpclient object
        OkHttpClient client = new OkHttpClient();
        // creating a Request object that is from square http
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();

        // We put the request from the inside a call object
        // The request is wrapped up in a call object
        Call call = client.newCall(request);

        // All that is left is to execute the call
        // there is a method from the call class and returns a response object

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if(response.isSuccessful()){
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG,"Exception caught: ", e);
                }
            }
        });

        Log.d(TAG,"Main UI is running!");

    }
}
