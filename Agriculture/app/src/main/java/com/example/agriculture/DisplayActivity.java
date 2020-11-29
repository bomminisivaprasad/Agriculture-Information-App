package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.agriculture.databinding.ActivityDisplayBinding;

public class DisplayActivity extends AppCompatActivity {
    ActivityDisplayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_display);
        binding.tv.setText(getIntent().getStringExtra("region"));
        binding.tv1.setText(getIntent().getStringExtra("pitem"));
        binding.tv2.setText(getIntent().getStringExtra("pdetails"));
        binding.tv3.setText(getIntent().getStringExtra("pend"));
        binding.tv4.setText(getIntent().getStringExtra("partner"));
        binding.tv5.setText(getIntent().getStringExtra("cdetails"));
        binding.tv6.setText(getIntent().getStringExtra("cnumber"));
    }
}