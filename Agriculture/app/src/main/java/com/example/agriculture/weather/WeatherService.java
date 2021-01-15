package com.example.agriculture.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
//http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API%20key}

    @GET("/data/2.5/weather")
    Call<Example> getweatherData(@Query("lat") String lat,
                                 @Query("lon") String lon,
                                 @Query("AppID") String AppID);
}
