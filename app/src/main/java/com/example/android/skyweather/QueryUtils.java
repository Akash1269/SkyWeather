package com.example.android.skyweather;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jarvis on 03-01-2017.
 */

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils(){}

    public static WeatherInfo parseJSON (String inputString){
        WeatherInfo response = null;

        try {
            JSONObject responseJSON =  new JSONObject(inputString);
            JSONObject main = responseJSON.getJSONObject("main");
            JSONObject weather = responseJSON.getJSONArray("weather").getJSONObject(0);
            JSONObject coordinates = responseJSON.getJSONObject("coord");
            JSONObject wind = responseJSON.getJSONObject("wind");
            JSONObject cloudPercent = responseJSON.getJSONObject("clouds");
            JSONObject details = responseJSON.getJSONObject("sys");

            response = new WeatherInfo(
                    responseJSON.getString("name"),
                    details.getString("country"),
                    weather.getString("main"),
                    weather.getString("description"),
                    responseJSON.getLong("dt"),
                    details.getLong("sunrise"),
                    details.getLong("sunset"),
                    main.getDouble("pressure"),
                    main.getDouble("humidity"),
                    wind.getDouble("speed"),
                    wind.getDouble("deg"),
                    cloudPercent.getDouble("all"),
                    coordinates.getDouble("lon"),
                    coordinates.getDouble("lat"),
                    main.getDouble("temp")
            );

        }catch (JSONException e){
            Log.e(LOG_TAG,"JSON exception occurred", e);
        }
        return response;
    }

}
