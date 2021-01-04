package com.example.agriculture.Mandi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agriculture.DisplayActivity;
import com.example.agriculture.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MandiAdapter extends RecyclerView.Adapter<MandiAdapter.HoldView> {
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
            Intent i = new Intent(ct, DisplayActivity.class);
            i.putExtra("region",list.get(pos).getRegion());
            i.putExtra("cdetails",list.get(pos).getContactDetails());
            i.putExtra("cnumber",list.get(pos).getContactNumber());
            i.putExtra("pend",list.get(pos).getEndProducts());
            i.putExtra("partner",list.get(pos).getPartner());
            i.putExtra("pitem",list.get(pos).getPrimaryItem());
            i.putExtra("pdetails",list.get(pos).getProductDetails());
            ct.startActivity(i);
        }
    }
}
