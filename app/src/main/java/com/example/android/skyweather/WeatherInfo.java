package com.example.android.skyweather;

/**
 * Created by Jarvis on 03-01-2017.
 */

public class WeatherInfo {
    private String mCity;
    private String mCountryCode;

    private String mWeatherTitle;
    private String mWeatherDescription;

    private Long mDate;
    private Long mSunrise;
    private Long mSunset;

    private double mPressure;
    private double mHumidity;

    private double mWindSpeed;
    private double mWindDirection;

    private double mCloudiness;

    private double mLongitude;
    private double mLatitude;

    private double mTemperatue;

    public WeatherInfo(String city,String countryCode, String weatherTitle,String weatherDescription,
                       Long date, Long sunrise, Long sunset, double pressure,
                       double humidity,double windSpeed, double windDirection, double cloudiness,
                       double longitude, double latitude, double temperature) {
        mCity = city;
        mCountryCode = countryCode;

        mWeatherTitle = weatherTitle;
        mWeatherDescription = weatherDescription;

        mDate = date;
        mSunrise = sunrise;
        mSunset = sunset;

        mPressure = pressure;
        mHumidity = humidity;

        mWindSpeed = windSpeed;
        mWindDirection = windDirection;

        mCloudiness = cloudiness;

        mLongitude = longitude;
        mLatitude = latitude;

        mTemperatue = temperature;
    }

    public String getCity(){return mCity;}
    public String getCountryCode(){return mCountryCode;}

    public String getWeatherTitle(){return mWeatherTitle;}
    public String getWeatherDescription(){return mWeatherDescription;}

    public Long getDate(){return mDate;}
    public Long getSunrise(){return mSunrise;}
    public Long getSunset(){return mSunset;}

    public double getPressure(){return mPressure;}
    public double getHumidity(){return mHumidity;}

    public double getWindSpeed(){return mWindSpeed;}
    public double getWindDirection(){return mWindDirection;}

    public double getCloudiness(){return mCloudiness;}

    public double getLongitude(){return mLongitude;}
    public double getLatitude(){return mLatitude;}

    public double getTemperature(){return mTemperatue;}
}
