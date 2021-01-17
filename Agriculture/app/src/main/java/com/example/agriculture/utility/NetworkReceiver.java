package com.example.agriculture.utility;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agriculture.R;
import com.example.agriculture.utility.Common;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Common.isConnected(context)) {
            AppCompatActivity activity = (AppCompatActivity) context;
            View v = activity.findViewById(R.id.drawer_layout);
            Snackbar snackbar = Snackbar.make(v, "No Internet Connectivity", Snackbar.LENGTH_LONG);
            snackbar.setDuration(5000);
            snackbar.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onReceive(context, intent);
                }
            });
            snackbar.show();
        }

    }
}