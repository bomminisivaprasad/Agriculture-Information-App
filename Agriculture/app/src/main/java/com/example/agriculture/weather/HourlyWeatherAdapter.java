package com.example.agriculture.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.R;

import java.util.ArrayList;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.HourlyViewHolder> {
    Context ct;
    ArrayList<HourlyPOJO> hourlyPOJOArrayList;
    public HourlyWeatherAdapter(Context context, ArrayList<HourlyPOJO> hourlyPOJOS) {
        ct = context;
        hourlyPOJOArrayList = hourlyPOJOS;
    }

    @NonNull
    @Override
    public HourlyWeatherAdapter.HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HourlyViewHolder(LayoutInflater.from(ct).inflate(R.layout.hourly_row_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyWeatherAdapter.HourlyViewHolder holder, int position) {
            HourlyPOJO hourlyPOJO = hourlyPOJOArrayList.get(position);
            String time = hourlyPOJO.dateTime;
            String[] separated = time.split("T");
            holder.h_Time.setText(separated[1]);
            holder.h_Temp.setText(hourlyPOJO.value+"°F");
    }

    @Override
    public int getItemCount() {
        return hourlyPOJOArrayList.size();
    }

    public static class HourlyViewHolder extends RecyclerView.ViewHolder {
        TextView h_Time,h_Temp;
        ImageView h_Mode;
        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            h_Mode = itemView.findViewById(R.id.hourweatherIconMode);
            h_Temp = itemView.findViewById(R.id.hourWeatherTemp);
            h_Time = itemView.findViewById(R.id.hourWeatherTime);
        }
    }
}
