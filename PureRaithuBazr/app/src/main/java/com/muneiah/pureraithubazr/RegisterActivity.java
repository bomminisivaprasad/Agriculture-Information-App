package com.muneiah.pureraithubazr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class RegisterActivity extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPage);
        viewPager.setAdapter(new RegisterForAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(RegisterActivity.this, "welcome "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public class RegisterForAdapter extends FragmentPagerAdapter{

        String tit[]={"Former","Other"};
        public RegisterForAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return  new FormerRegiserFragment();
            }
            if (position==1){
                return  new UserRegisterFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tit.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tit[position];
        }
    }
}
