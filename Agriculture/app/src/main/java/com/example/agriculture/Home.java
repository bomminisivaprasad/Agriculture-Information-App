package com.example.agriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.agriculture.Mandi.MandiFragment;
import com.example.agriculture.advisories.AgriculturalAdvisoriesFragment;
import com.example.agriculture.faq.FAQFragment;
import com.example.agriculture.helpline.HelpLineFragment;
import com.example.agriculture.home.HomeFragment;
import com.example.agriculture.weather.WeatherFragments;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth auth;
    FragmentManager manager;
    FragmentTransaction transaction;
    LogINRegisterActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null){
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_body, fragment).commit();
        }
        activity = new LogINRegisterActivity();
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        auth = FirebaseAuth.getInstance();
        getSupportActionBar();


        if (ActivityCompat.checkSelfPermission(Home.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(Home.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Home.this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.CALL_PHONE}, 1);

        }
        ActionBarDrawerToggle drawerToggle =
                new ActionBarDrawerToggle(this,
                        drawerLayout,toolbar,
                        0,0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        drawerToggle.getDrawerArrowDrawable()
                .setColor(getResources().getColor(android.R.color.white));

        navigationView.setNavigationItemSelectedListener(Home.this);
        View headerview = navigationView.getHeaderView(0);
        TextView tv = headerview.findViewById(R.id.nTextView);
        tv.setText(auth.getCurrentUser().getEmail());
            }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        manager = getSupportFragmentManager();
        transaction =manager.beginTransaction();

        switch (item.getItemId()){
            case R.id.home:
                HomeFragment home =new HomeFragment();
                transaction.replace(R.id.main_body,home);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;

            case R.id.weather:
                WeatherFragments weather =new WeatherFragments();
                transaction.replace(R.id.main_body,weather);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.advisories:
                AgriculturalAdvisoriesFragment advisoriesFragment =new AgriculturalAdvisoriesFragment();
                transaction.replace(R.id.main_body,advisoriesFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.helpline:
                HelpLineFragment helpLineFragment =new HelpLineFragment();
                transaction.replace(R.id.main_body,helpLineFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.market_mandi:
                MandiFragment mandiFragment =new MandiFragment();
                transaction.replace(R.id.main_body,mandiFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.faq:
                FAQFragment faqFragment =new FAQFragment();
                transaction.replace(R.id.main_body,faqFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_update:
                Live_Update live_update =new Live_Update();
                transaction.replace(R.id.main_body,live_update);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.signout:
                auth.signOut();
                startActivity(new Intent(this,LogINRegisterActivity.class));
                finish();

        }
        return false;
    }

    public void tollFree(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setTitle("Kissan Call Center");
        builder.setMessage("Are you want to call Kisaan TollFree Number?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ActivityCompat.checkSelfPermission(Home.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Home.this, new String[] {Manifest.permission.CALL_PHONE}, 1);

                }
                Uri u = Uri.parse("tel:18001801551");
                Intent callIntent = new Intent(Intent.ACTION_CALL,u);
                startActivity(callIntent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
 }