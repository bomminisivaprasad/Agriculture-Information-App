package com.example.agriculture.helpline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class HelpLineFragment extends Fragment {

    String[] district = {"Select Your District", "Srikakulam", "Vizianagaram","Visakhapatnam",
    "East Godavari","West Godavari","Krishna","Guntur","Prakasam","Nellore","Kurnool","Kadapa",
            "Chittoor","Anantapur"};
    Spinner sp;
    RecyclerView rv;
    TextView tv;
    JSONArray jsonArray;
    ArrayList<MyHelpLine> data;
    String json;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_help_line, container, false);

        sp = v.findViewById(R.id.helplinespinner);
        rv = v.findViewById(R.id.recyclerhelpline);
        tv = v.findViewById(R.id.nodata);
        tv.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
        data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, district);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(getContext(), "Not Selected", Toast.LENGTH_SHORT).show();
                        tv.setVisibility(View.VISIBLE);
                        rv.setVisibility(View.GONE);
                        break;
                    case 1:
                        Toast.makeText(getContext(), "" + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        visiblegone();
                        try {
                            InputStream is = getActivity().getAssets().open("srikakulam.json");
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();
                            json = new String(buffer, "UTF-8");
                            JSONObject jsonObject = new JSONObject(json);
                            jsonArray = jsonObject.getJSONArray("Srikakulam");
                            loopData();
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 2:
                        Toast.makeText(getContext(), "" + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        visiblegone();
                        try {
                            InputStream is = getActivity().getAssets().open("vizianagaram.json");
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();
                            json = new String(buffer, "UTF-8");
                            JSONObject jsonObject = new JSONObject(json);
                            jsonArray = jsonObject.getJSONArray("Vizianagaram");
                            loopData();
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        Toast.makeText(getContext(), "" + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        visiblegone();
                        try {
                            InputStream is = getActivity().getAssets().open("visakhapatnam.json");
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();
                            json = new String(buffer, "UTF-8");
                            JSONObject jsonObject = new JSONObject(json);
                            jsonArray = jsonObject.getJSONArray("Visakhapatnam");
                            loopData();
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tv.setVisibility(View.VISIBLE);
                rv.setVisibility(View.GONE);
            }
        });
        return v;
    }

    public void visiblegone() {
        data.clear();
        tv.setVisibility(View.GONE);
        rv.setVisibility(View.VISIBLE);
    }

    private void loopData() {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.optString("Employee Name");
                String phone = object.optString("Mobile Number");
                String designation = object.optString("Designation");
                String work = object.optString("Place of Working");
                data.add(new MyHelpLine(name, phone, designation, work));
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new HelpLineAdapter(getActivity(), data));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}