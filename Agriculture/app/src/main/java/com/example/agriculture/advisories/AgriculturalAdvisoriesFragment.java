package com.example.agriculture.advisories;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.agriculture.R;


public class AgriculturalAdvisoriesFragment extends Fragment {

    LinearLayout cottoncrop,sugarcrop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agricultural_advisories, container, false);
        cottoncrop = v.findViewById(R.id.cottoncrop);
        sugarcrop = v.findViewById(R.id.sugarcanecrop);

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s = v.findViewById(R.id.cotton);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cottoncrop.setVisibility(View.VISIBLE);
                } else {
                    cottoncrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s1 = v.findViewById(R.id.sugarcane);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    sugarcrop.setVisibility(View.VISIBLE);
                } else {
                    sugarcrop.setVisibility(View.GONE);
                }
            }
        });
        return v;
    }
}