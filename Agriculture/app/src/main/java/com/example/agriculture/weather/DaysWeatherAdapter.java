package com.example.agriculture.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.R;

import java.util.ArrayList;

public class DaysWeatherAdapter extends RecyclerView.Adapter<DaysWeatherAdapter.DaysViewHolder> {
    Context ct;
    ArrayList<DaysPOJO> daysPOJOArrayList;
    public DaysWeatherAdapter(Context context, ArrayList<DaysPOJO> daysPOJOS) {
    ct = context;
    daysPOJOArrayList = daysPOJOS;
    }

    @NonNull
    @Override
    public DaysWeatherAdapter.DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysViewHolder(LayoutInflater.from(ct).inflate(R.layout.day_row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DaysWeatherAdapter.DaysViewHolder holder, int position) {
        DaysPOJO daysPOJO = daysPOJOArrayList.get(position);

        String time = daysPOJO.daysDate;
        String[] separated = time.split("T");
        holder.daydate.setText(separated[1]);
        holder.minValue.setText(daysPOJO.minValue+"°F");
        holder.maxValue.setText(daysPOJO.maxValue+"°F");
    }

    @Override
    public int getItemCount() {
        return daysPOJOArrayList.size();
    }

    public class DaysViewHolder extends RecyclerView.ViewHolder{
        TextView daydate,minValue,maxValue;

        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);
            daydate = itemView.findViewById(R.id.daydate);
            minValue = itemView.findViewById(R.id.minvalue);
            maxValue = itemView.findViewById(R.id.maxvalue);
        }
    }
}
