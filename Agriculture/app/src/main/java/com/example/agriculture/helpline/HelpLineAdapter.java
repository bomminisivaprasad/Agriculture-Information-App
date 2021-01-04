package com.example.agriculture.helpline;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.Home;
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
                .inflate(R.layout.helpline_row_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHolder holder, int position) {
        final MyHelpLine myData = helpLines.get(position);
        holder.name.setText(myData.getName());
        holder.desi.setText(myData.getDesi());
        holder.work.setText(myData.getWork());
        holder.number.setText(myData.getMobile());
        holder.helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(ct,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) ct, new String[] {Manifest.permission.CALL_PHONE}, 1);
                }
                String requiredPermission = Manifest.permission.CALL_PHONE;
                int checkVal = ct.checkCallingOrSelfPermission(requiredPermission);
                if (checkVal==PackageManager.PERMISSION_GRANTED){
                    Uri u = Uri.parse("tel:"+myData.getMobile());
                    Intent callIntent = new Intent(Intent.ACTION_CALL,u);
                    ct.startActivity(callIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return helpLines.size();
    }

    public class HelpViewHolder extends RecyclerView.ViewHolder {
        TextView name, desi, work, number;
        Button helpline;

        public HelpViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hname);
            desi = itemView.findViewById(R.id.hdesignation);
            work = itemView.findViewById(R.id.hwork);
            number = itemView.findViewById(R.id.hphonenumber);
            helpline = itemView.findViewById(R.id.helplinecall);
        }
    }
}














