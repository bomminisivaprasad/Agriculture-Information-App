package com.example.agriculture;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agriculture.Mandi.Pojo;
import com.example.agriculture.databinding.FragmentDisplayBinding;

import java.util.ArrayList;


public class DisplayFragment extends Fragment {
    FragmentDisplayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display,container,false);
        binding.cdetails.setText(getArguments().getString("cdetails"));
        binding.partner.setText(getArguments().getString("partner"));
        binding.cnumber.setText(getArguments().getString("cnumber"));
        binding.eproducts.setText(getArguments().getString("eproducts"));
        binding.pitem.setText(getArguments().getString("pitem"));
        binding.pdetails.setText(getArguments().getString("pdetails"));
        binding.region.setText(getArguments().getString("region"));
        return binding.getRoot();
    }
}