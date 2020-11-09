package com.example.agriculture.weather;

import com.example.agriculture.BuildConfig;

public class WeatherUrls {

    private static final String API_KEY = "ZDJAKmA42ibROOptIh5FGsbGOyG5pdGD";
    static String location_key_url = "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey="+API_KEY+"&q=";
    static String current_weather_base = "http://dataservice.accuweather.com/currentconditions/v1/";
    static String current_weather_key = "?apikey="+API_KEY;

    static  String hourly_weather = "http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/";

    static String days_weather = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";

}
