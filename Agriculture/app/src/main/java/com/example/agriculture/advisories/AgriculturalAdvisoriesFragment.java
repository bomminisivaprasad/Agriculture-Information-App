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

    LinearLayout cottoncrop,sugarcrop,wheatcrop,ricecrop,milletscrop,maizecrop,
            pulsescrop,sunfloweroil,jutecrop,
            tobaccocrop,teacrop,coffeecrop,vegcrop,
            groundnucrop,ragicrop;
    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agricultural_advisories, container, false);
        cottoncrop = v.findViewById(R.id.cottoncrop);
        sugarcrop = v.findViewById(R.id.sugarcanecrop);
        wheatcrop = v.findViewById(R.id.wheatcrop);
        ricecrop =v.findViewById(R.id.ricecrop);
        milletscrop =v.findViewById(R.id.milletscrop);
        maizecrop = v.findViewById(R.id.maizecrop);
        pulsescrop =v.findViewById(R.id.pulsecrop);
        sunfloweroil =v.findViewById(R.id.sunflowercrop);
        jutecrop =v.findViewById(R.id.jutecrop);
        tobaccocrop =v.findViewById(R.id.tobaccocrop);
        teacrop = v.findViewById(R.id.teacrop);
        coffeecrop =v.findViewById(R.id.coffeecrop);
        vegcrop =v.findViewById(R.id.vegetablecrop);
        groundnucrop =v.findViewById(R.id.groundnutcrop);
        ragicrop =v.findViewById(R.id.ragicrop);

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
        Switch s2 = v.findViewById(R.id.wheat);
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    wheatcrop.setVisibility(View.VISIBLE);
                } else {
                    wheatcrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s3 = v.findViewById(R.id.Rice);
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ricecrop.setVisibility(View.VISIBLE);
                } else {
                    ricecrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s4 = v.findViewById(R.id.Millets);
        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    milletscrop.setVisibility(View.VISIBLE);
                } else {
                    milletscrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s5 = v.findViewById(R.id.Maize);
        s5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    maizecrop.setVisibility(View.VISIBLE);
                } else {
                    maizecrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s6 = v.findViewById(R.id.Pulses);
        s6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    pulsescrop.setVisibility(View.VISIBLE);
                } else {
                    pulsescrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s7 = v.findViewById(R.id.sunflower);
        s7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    sunfloweroil.setVisibility(View.VISIBLE);
                } else {
                    sunfloweroil.setVisibility(View.GONE);
                }
            }
        });
        Switch s8 = v.findViewById(R.id.Jute);
        s8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    jutecrop.setVisibility(View.VISIBLE);
                } else {
                    jutecrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s9 = v.findViewById(R.id.Tobacco);
        s9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tobaccocrop.setVisibility(View.VISIBLE);
                } else {
                    tobaccocrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s10 = v.findViewById(R.id.Tea);
        s10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    teacrop.setVisibility(View.VISIBLE);
                } else {
                    teacrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s11= v.findViewById(R.id.Coffee);
        s11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    coffeecrop.setVisibility(View.VISIBLE);
                } else {
                    coffeecrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s12 = v.findViewById(R.id.Vegetables);
        s12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    vegcrop.setVisibility(View.VISIBLE);
                } else {
                    vegcrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s13 = v.findViewById(R.id.Groundnuts);
        s13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    groundnucrop.setVisibility(View.VISIBLE);
                } else {
                    groundnucrop.setVisibility(View.GONE);
                }
            }
        });
        Switch s14 = v.findViewById(R.id.Ragi);
        s14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ragicrop.setVisibility(View.VISIBLE);
                } else {
                    ragicrop.setVisibility(View.GONE);
                }
            }
        });

        return v;
    }
}