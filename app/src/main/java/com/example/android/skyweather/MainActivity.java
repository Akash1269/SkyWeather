package com.example.android.skyweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    static private final String JSON_WEATHER = "{\"coord\":{\"lon\":73.86,\"lat\":18.52},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":9.65,\"pressure\":953,\"humidity\":80,\"temp_min\":9.65,\"temp_max\":9.65,\"sea_level\":1028.99,\"grnd_level\":953},\"wind\":{\"speed\":2.5,\"deg\":57.5014},\"clouds\":{\"all\":0},\"dt\":1483405444,\"sys\":{\"message\":0.008,\"country\":\"IN\",\"sunrise\":1483407451,\"sunset\":1483447243},\"id\":1259229,\"name\":\"Pune\",\"cod\":200}";
    static private final char DEGREE_SYMBOL = '\u00B0';
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherInfo output = QueryUtils.parseJSON(JSON_WEATHER);

        TextView cityName = (TextView) findViewById(R.id.city_name);
        cityName.setText(output.getCity());
        
        TextView tempText = (TextView) findViewById(R.id.temperature);
        tempText.setText(formatMagnitude(output.getTemperature()) + DEGREE_SYMBOL + " C");

    }

    private String formatMagnitude (Double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }
}
