package com.example.agriculture;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class Live_Update extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Live_Update() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_live__update, container, false);
        Button java, python, android, datascience, javascripts, aad, nsc, iimr, fp, pmk, b_sdt, b_agco,
                b_animal, b_agri, b_anim, b_fisheries, b_ysr;
        b_ysr = v.findViewById(R.id.ysr);
        b_ysr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "https://ysrrythubharosa.ap.gov.in/RBApp/index.html";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));

            }
        });
        b_fisheries = v.findViewById(R.id.fisheries);
        b_fisheries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "http://www.fisheries.ap.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });
        b_anim = v.findViewById(R.id.anim);
        b_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "https://ahd.aponline.gov.in/AHMS/Views/Home.aspx";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });
        b_agri = v.findViewById(R.id.agri);
        b_agri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "http://www.apagrisnet.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));

            }
        });
        b_animal = v.findViewById(R.id.animal);
        b_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "https://www.ap.gov.in/?page_id=291";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });
        b_agco = v.findViewById(R.id.agco);
        b_agco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "https://www.ap.gov.in/?page_id=289";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });
        b_sdt = v.findViewById(R.id.sdt);
        b_sdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String python = "https://www.ap.gov.in/?page_id=19754";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });

        java = v.findViewById(R.id.java);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String python = "https://angrau.ac.in/angrau/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(python));
            }
        });

        python = v.findViewById(R.id.python);
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String javas = "https://apseeds.ap.gov.in/Website/Index.aspx";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(javas));

            }
        });
        android = v.findViewById(R.id.android);
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String javas = "https://icar.org.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(javas));
            }
        });
        datascience = v.findViewById(R.id.datascience);
        datascience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String javas = "https://www.icrisat.org/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(javas));

            }
        });
        javascripts = v.findViewById(R.id.javascripts);
        javascripts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String javas = "https://seednet.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(javas));
            }
        });
        aad = v.findViewById(R.id.aad);
        aad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aad = "http://apagrisnet.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(aad));
            }
        });
        nsc = v.findViewById(R.id.nsc);
        nsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nsc = "https://www.indiaseeds.com/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(nsc));
            }
        });
        iimr = v.findViewById(R.id.iimr);
        iimr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iimr = "https://www.millets.res.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(iimr));
            }
        });
        fp = v.findViewById(R.id.fp);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fp = "http://apagrisnet.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(fp));
            }
        });
        pmk = v.findViewById(R.id.p);
        pmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pmk = "https://pmkisan.gov.in/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                builder.addDefaultShareMenuItem();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getContext(), Uri.parse(pmk));
            }
        });
        return v;
    }
}