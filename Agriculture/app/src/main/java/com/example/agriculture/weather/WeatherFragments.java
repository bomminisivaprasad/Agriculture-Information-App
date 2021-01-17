package com.example.agriculture.weather;

import android.Manifest;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.agriculture.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.LOCATION_SERVICE;


public class WeatherFragments extends Fragment {
//http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API%20key}
    LocationManager manager;
    String lati, longi;
    Retrofit retrofit;
    LottieAnimationView animationView;

    @Override
    public void onStart() {
        super.onStart();

        animationView.playAnimation();
        //Check

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather_fragments, container, false);
        animationView = v.findViewById(R.id.loadingAnimCustom);
        animationView.setRepeatCount(100);
        manager = (LocationManager)getContext().getSystemService(LOCATION_SERVICE);
        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                lati = String.valueOf(location.getLatitude());
                longi = String.valueOf(location.getLongitude());

                retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                WeatherService service = retrofit.create(WeatherService.class);
                Call<Example> response = service.getweatherData(lati,longi,"ebfcac32bda131ed5a160f2757938396");
                response.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Log.i("SIZE",""+response.body().getMain().getTemp());
                        String lat = String.valueOf(response.body().getCoord().getLat());
                        String lon = String.valueOf(response.body().getCoord().getLon());
                        String country = response.body().getSys().getCountry();
                        String des = response.body().getWeather().get(0).getDescription();
                        float temp_ = (float) (Float.parseFloat(response.body().getMain().getTemp().toString())-273.15);
                        String humidity = String.valueOf(response.body().getMain().getHumidity());
                        //String tempmin = String.valueOf((response.body().getMain().getTempMin())-273.15);
                        float tempmin = (float) (Float.parseFloat(response.body().getMain().getTempMin().toString())-273.15);
                        float tempmax = (float) (Float.parseFloat(response.body().getMain().getTempMax().toString())-273.15);
                        //String tempmax = String.valueOf((response.body().getMain().getTempMax())-273.15);
                        String speed = String.valueOf(response.body().getWind().getSpeed());
                        String deg = String.valueOf(response.body().getWind().getDeg());
                        String dt = String.valueOf(response.body().getDt());
                        int timegone = response.body().getTimezone();
                        String sunrise = String.valueOf(response.body().getSys().getSunrise());
                        String sunset = String.valueOf(response.body().getSys().getSunset());

                        String name = String.valueOf(response.body().getName());
                        TextView city_view = v.findViewById(R.id.cityNameCustom);
                        TextView temp_view = v.findViewById(R.id.temperatureCustom);
                        TextView tempmin_view  = v.findViewById(R.id.minTempCustom);
                        TextView tempmax_view = v.findViewById(R.id.maxTempCustom);
                        TextView desc = v.findViewById(R.id.weatherForecastCustom);
                        //TextView tv = v.findViewById(R.id.dateTimeCustom);
                        String celcius = " " + (char) 0x00B0+"C";
                        city_view.setText(name);
                        temp_view.setText(String.format("%.2f",temp_)+ celcius);
                        tempmin_view.setText(String.format("%.2f",tempmin)+ celcius);
                        tempmax_view.setText(String.format("%.2f",tempmax)+ celcius);
                        desc.setText(des);
                        animationView.setVisibility(View.INVISIBLE);
                        //linearLayout.setVisibility(View.VISIBLE);
                        animationView.cancelAnimation();
                       // tv.setText(sunrise+"\n"+sunset);


                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, listener);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1,listener);
        return v;
    }

    private String convertEPOCH(Integer integer) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        TimeZone InTimezone = TimeZone.getTimeZone("Asia/Kolkata");
        long x = integer.intValue();
        x *= 1000;
        Log.i("EPOCH : ",String.valueOf(x));
        Date date = new Date(x);
//        simpleDateFormat.setTimeZone(InTimezone);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String formatted = format.format(date);
        Log.i("Time Asia/Kolkata",formatted);
        return formatted;

    }
}