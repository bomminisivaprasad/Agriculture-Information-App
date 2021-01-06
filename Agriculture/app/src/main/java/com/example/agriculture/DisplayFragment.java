package com.example.agriculture;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agriculture.Mandi.Pojo;
import com.example.agriculture.databinding.FragmentDisplayBinding;

import java.util.ArrayList;


public class DisplayFragment extends Fragment {
    FragmentDisplayBinding binding;
    ArrayList<Pojo> pojos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display,container,false);
       /* pojos = new ArrayList<>();
        int pos = 0;
        binding.tv.setText(pojos.get(pos).getPrimaryItem());
        binding.tv1.setText(pojos.get(pos).getContactDetails());
        binding.tv2.setText(pojos.get(pos).getContactNumber());
        binding.tv3.setText(pojos.get(pos).getEndProducts());
        binding.tv4.setText(pojos.get(pos).getPartner());
        binding.tv5.setText(pojos.get(pos).getProductDetails());
        binding.tv6.setText(pojos.get(pos).getRegion());*/


        return binding.getRoot();
    }
}