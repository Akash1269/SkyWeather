package com.example.android.skyweather;

import java.util.Date;

/**
 * Created by Jarvis on 03-01-2017.
 */

public class WeatherInfo {
    private String mCity;
    private String mCountryCode;

    private String mWeatherTitle;
    private String mWeatherDescription;

    private Date mDate;
    private Date mSunrise;
    private Date mSunset;

    private double mPressure;
    private double mHumidity;

    private double mWindSpeed;
    private double mWindDirection;

    private double mCloudiness;

    private double mLongitude;
    private double mLatitude;

    private double mTemperatue;

    public WeatherInfo(String city, double temperature) {
        mCity = city;
        mTemperatue = temperature;
    }

    public String getCity(){return mCity;}
    public double getTemperature(){return mTemperatue;}
}
