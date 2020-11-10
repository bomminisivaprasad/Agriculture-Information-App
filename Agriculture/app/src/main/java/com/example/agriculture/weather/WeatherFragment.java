package com.example.agriculture.weather;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.agriculture.R;
import com.skyfishjy.library.RippleBackground;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static android.content.Context.LOCATION_SERVICE;


public class WeatherFragment extends Fragment {
    RequestQueue requestQueue;
    LocationManager manager;
    TextView c_location,w_mode,w_value;
    ImageView w_icon;
    ImageView imageView;
    String location_key,location_name;
    RippleBackground rippleBackground;
    ArrayList<HourlyPOJO> hourlyPOJOS;
    RecyclerView hourRecycler,daysRecycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        hourlyPOJOS = new ArrayList<>();
        c_location = v.findViewById(R.id.currentloaction);
        w_mode = v.findViewById(R.id.weathermode);
        w_icon = v.findViewById(R.id.weathermodeicon);
        w_value = v.findViewById(R.id.weathervalue);
        hourRecycler = v.findViewById(R.id.recyclerHour);
        daysRecycler = v.findViewById(R.id.recyclerDays);
        hourlyPOJOS = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        manager = (LocationManager) Objects.requireNonNull(getActivity()).getSystemService(LOCATION_SERVICE);

        rippleBackground=(RippleBackground)v.findViewById(R.id.content);
        imageView =v.findViewById(R.id.centerImage);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                String latitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());
                String myLocation = WeatherUrls.location_key_url + latitude + "," + longitude;
                Toast.makeText(getContext(), myLocation, Toast.LENGTH_SHORT).show();
                StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, myLocation,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                                //rippleBackground.stopRippleAnimation();
                                //rippleBackground.setVisibility(View.GONE);
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    location_key = jsonObject.getString("Key");
                                    location_name = jsonObject.getString("LocalizedName");
                                    c_location.setText(location_name);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getContext(), ""+volleyError.toString(), Toast.LENGTH_SHORT).show();
                        Log.i("error",volleyError.toString());
                        String message = null;
                        if (volleyError instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                        } else if (volleyError instanceof AuthFailureError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                        } else if (volleyError instanceof NoConnectionError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof TimeoutError) {
                            message = "Connection TimeOut! Please check your internet connection.";
                        }
                    }
                });

                requestQueue.add(stringRequest);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String current_url = WeatherUrls.current_weather_base+location_key+WeatherUrls.current_weather_key;
                        String hourly_url = WeatherUrls.hourly_weather+location_key+WeatherUrls.current_weather_key;
                        String days_url = WeatherUrls.days_weather+location_key+WeatherUrls.current_weather_key;
                        new CurrentTask(current_url).execute();
                        //Toast.makeText(getContext(), ""+hourly_url, Toast.LENGTH_SHORT).show();
                        new HourlyTask(hourly_url).execute();
                        Toast.makeText(getContext(), ""+days_url, Toast.LENGTH_SHORT).show();
                        Log.i("daysurl",days_url);
                        new DaysTask(days_url).execute();

                    }
                },5000);
            }
        };
        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION }, 1);

        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300000, 5, locationListener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,300000,5,locationListener);
        return v;
    }

    @SuppressLint("StaticFieldLeak")
    class CurrentTask extends AsyncTask<String,Void,String> {

        String c_url;
        public CurrentTask(String current_url) {
            c_url = current_url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //rippleBackground.setVisibility(View.VISIBLE);
            //rippleBackground.startRippleAnimation();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url= new URL(c_url);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner =new Scanner(inputStream);
                if (scanner.hasNext()){
                    return scanner.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //rippleBackground.setVisibility(View.GONE);
            //rippleBackground.stopRippleAnimation();
            if (s!=null) {
                //Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String weather_mode = jsonObject.getString("WeatherText");
                    String icon_mode = jsonObject.getString("WeatherIcon");
                    JSONObject tem_object = jsonObject.getJSONObject("Temperature");
                    JSONObject metric_object = tem_object.getJSONObject("Metric");
                    String metric_value = metric_object.getString("Value");
                    String metric_unit = metric_object.getString("Unit");
                    w_value.setText(metric_value+"℃");
                    //Toast.makeText(getContext(), icon_mode, Toast.LENGTH_SHORT).show();
                    if (icon_mode.contains(icon_mode)) {
                        w_icon.setImageResource(R.drawable.s_07);
                    }
                    w_mode.setText(weather_mode);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("currentweather",e.toString());
                }
            }else{
                Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @SuppressLint("StaticFieldLeak")
    class HourlyTask extends AsyncTask<String,Void,String>{

        String h_url;

        public HourlyTask(String hourly_url) {
            h_url = hourly_url;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url= new URL(h_url);
                Log.i("hoururl",url.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner =new Scanner(inputStream);
                if (scanner.hasNext()){
                    return scanner.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getContext(), "Hour \n" + s, Toast.LENGTH_SHORT).show();
            try {
                JSONArray jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++) {
                    Log.i("hoururlssss", String.valueOf(jsonArray.length()));
                    JSONObject hourObject = jsonArray.getJSONObject(i);
                    String datetime = hourObject.getString("DateTime");
                    Log.i("hoururl",datetime);
                    String weathericon = hourObject.getString("WeatherIcon");
                    String iconPhrase = hourObject.getString("IconPhrase");
                    Log.i("hoururl",iconPhrase);
                    JSONObject tempObject = hourObject.getJSONObject("Temperature");
                    String value = tempObject.getString("Value");

                    hourlyPOJOS.add(new HourlyPOJO(datetime, weathericon, iconPhrase, value));

                    hourRecycler.setLayoutManager(new
                            LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
                    hourRecycler.setAdapter(new HourlyWeatherAdapter(getContext(), hourlyPOJOS));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    class DaysTask extends AsyncTask<String,Void,String>{

        String days_Url;
        public DaysTask(String days_url) {
            days_Url = days_url;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url= new URL(days_Url);
                Log.i("daysurl",url.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner =new Scanner(inputStream);
                if (scanner.hasNext()){
                    return scanner.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray daysArray = jsonObject.getJSONArray("DailyForecasts");
                    for (int i = 0; i < daysArray.length(); i++) {
                        JSONObject dayObject = daysArray.getJSONObject(i);
                        String day_date = dayObject.getString("Date");
                        JSONObject temp_Object = dayObject.getJSONObject("Temperature");
                        JSONObject min_Object = temp_Object.getJSONObject("Minimum");
                        String min_temp_value = min_Object.getString("Value");
                        JSONObject max_Object = temp_Object.getJSONObject("Maximum");
                        String max_temp_value = max_Object.getString("Value");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}