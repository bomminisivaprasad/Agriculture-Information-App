package com.example.agriculture.helpline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.R;

import java.util.ArrayList;

public class HelpLineAdapter extends RecyclerView.Adapter<HelpLineAdapter.HelpViewHolder> {
    Context ct;
    ArrayList<MyHelpLine> helpLines;
    public HelpLineAdapter(Context context, ArrayList<MyHelpLine> data) {
    ct = context;
    helpLines = data;
    }

    @NonNull
    @Override
    public HelpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HelpViewHolder(LayoutInflater.from(ct)
                .inflate(R.layout.helpline_row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHolder holder, int position) {
        final MyHelpLine myData = helpLines.get(position);
        holder.name.setText("Name : "+myData.getName());
        holder.desi.setText("Designation : "+myData.getDesi());
        holder.work.setText("Place of Work : "+myData.getWork());
        holder.number.setText("Phone Number : "+myData.getMobile());
    }

    @Override
    public int getItemCount() {
        return helpLines.size();
    }

    public class HelpViewHolder extends RecyclerView.ViewHolder {
        TextView name,desi,work,number;
        public HelpViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hname);
            desi = itemView.findViewById(R.id.hdesignation);
            work = itemView.findViewById(R.id.hwork);
            number = itemView.findViewById(R.id.hphonenumber);
        }
    }
}
