package com.example.agriculture.Mandi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agriculture.DisplayFragment;
import com.example.agriculture.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MandiFragment extends Fragment {
    DatabaseReference reference;
    RecyclerView rv;
    ArrayList<Pojo> pojos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mandi, container, false);
        rv = v.findViewById(R.id.rv);
        pojos = new ArrayList<Pojo>();
        reference = FirebaseDatabase.getInstance().getReference("mandi");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object object = dataSnapshot.getValue(Object.class);
                String json = new Gson().toJson(object);
                try {
                    JSONArray root = new JSONArray(json);
                    for (int i = 0; i < root.length(); i++) {
                        JSONObject jsonObject = root.getJSONObject(i);
                        String primaryItem = jsonObject.getString("Primary_Item");
                        String region = jsonObject.getString("Region");
                        String contactDetails = jsonObject.getString("Contact_Details");
                        String contactNumber = jsonObject.getString("Contact_No");
                        String partner = jsonObject.getString("Partner");
                        String productDetails = jsonObject.getString("Product_Details");
                        String endProducts = jsonObject.getString("End_Products");
                        Pojo pojo = new Pojo(primaryItem, region, contactDetails,contactNumber, partner, productDetails, endProducts);
                        pojos.add(pojo);
                    }
                    MandiAdapter adapter = new MandiAdapter(getActivity(), pojos);
                    rv.setAdapter(adapter);
                    rv.setLayoutManager(new LinearLayoutManager(getContext()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    private class MandiAdapter extends RecyclerView.Adapter<MandiAdapter.HoldView>{
        Context ct;
        ArrayList<Pojo> list;
        public MandiAdapter(FragmentActivity activity, ArrayList<Pojo> pojos) {
            ct = activity;
            list = pojos;
        }


        @NonNull
        @Override
        public HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HoldView(LayoutInflater.from(ct).inflate(R.layout.row_mandi,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull HoldView holder, int position) {
            holder.tv.setText(list.get(position).getRegion());
            holder.tv1.setText(list.get(position).getPartner());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class HoldView extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv,tv1;
            public HoldView(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.region);
                tv1 = itemView.findViewById(R.id.partner);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                DisplayFragment fragment = new DisplayFragment();
                Bundle bundle = new Bundle();
                bundle.putString("cdetails",list.get(pos).getContactDetails());
                bundle.putString("partner",list.get(pos).getPartner());
                bundle.putString("cnumber",list.get(pos).getContactNumber());
                bundle.putString("eproducts",list.get(pos).getEndProducts());
                bundle.putString("pitem",list.get(pos).getPrimaryItem());
                bundle.putString("pdetails",list.get(pos).getProductDetails());
                bundle.putString("region",list.get(pos).getRegion());
                fragment.setArguments(bundle);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_body,fragment).addToBackStack(null).commit();
            }
        }
    }
}