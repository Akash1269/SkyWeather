package com.example.android.skyweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static private final String JSON_WEATHER = "{\"coord\":{\"lon\":73.86,\"lat\":18.52},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":9.65,\"pressure\":953,\"humidity\":80,\"temp_min\":9.65,\"temp_max\":9.65,\"sea_level\":1028.99,\"grnd_level\":953},\"wind\":{\"speed\":2.5,\"deg\":57.5014},\"clouds\":{\"all\":0},\"dt\":1483405444,\"sys\":{\"message\":0.008,\"country\":\"IN\",\"sunrise\":1483407451,\"sunset\":1483447243},\"id\":1259229,\"name\":\"Pune\",\"cod\":200}";
    static private final char DEGREE_SYMBOL = '\u00B0';
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherInfo output = QueryUtils.parseJSON(JSON_WEATHER);
        TextView textView;

        setTitle(output.getCity() + ", " + output.getCountryCode());

        textView = (TextView) findViewById(R.id.temperature);
        textView.setText(formatDecimals(output.getTemperature()) + DEGREE_SYMBOL);

        textView = (TextView) findViewById(R.id.weather_desc);
        textView.setText(output.getWeatherDescription());

        textView = (TextView) findViewById(R.id.wind_desc);
        textView.setText("Wind flowing at " + output.getWindSpeed() + "mph in the direction " + formatDecimals(output.getWindDirection()) + DEGREE_SYMBOL);

        Date date = new Date(output.getDate() * 1000);

        textView = (TextView) findViewById(R.id.day);
        textView.setText(formatDay(date));

        textView = (TextView) findViewById(R.id.date);
        textView.setText(formatDate(date) + ", " + formatTime(date));

        textView = (TextView) findViewById(R.id.pressure);
        textView.setText(formatDecimals(output.getPressure()));

        textView = (TextView) findViewById(R.id.humidity);
        textView.setText(formatDecimals(output.getHumidity()) + "%");

        textView = (TextView) findViewById(R.id.cloudiness);
        textView.setText(formatDecimals(output.getCloudiness()) + "%");

        date = new Date(output.getSunrise() * 1000);
        textView = (TextView) findViewById(R.id.sunrise_time);
        textView.setText("Sunrise at " + formatTime(date));

        date = new Date(output.getSunset() * 1000);
        textView = (TextView) findViewById(R.id.sunset_time);
        textView.setText("Sunset at " + formatTime(date));

    }

    private String formatDecimals (Double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0");
        return formatter.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatDay(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
