package com.example.fastmenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fastmenu.adapter.viewPager.FrameBeverage;
import com.example.fastmenu.adapter.viewPager.FrameChicken;
import com.example.fastmenu.adapter.viewPager.FrameHamburger;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {

    private ViewPager viewPager;
    private FrameAdapter frameAdapter;
    private Intent givenCompanyName;
    private String companyName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        givenCompanyName = getIntent();
        companyName = givenCompanyName.getStringExtra("CompanyName");

        viewPager = findViewById(R.id.menuViewpager);
        TabLayout tabLayout = findViewById(R.id.menuTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        frameAdapter = new FrameAdapter(getSupportFragmentManager());
        viewPager.setAdapter(frameAdapter);
    }

    public class FrameAdapter extends FragmentPagerAdapter {

        public FrameAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: // 햄버거
                    FrameHamburger frameHamburger = new FrameHamburger();
                    frameHamburger.setCompanyName(companyName);
                    return frameHamburger;
                case 1:
                    FrameChicken frameChicken = new FrameChicken();
                    return frameChicken;
                case 2:
                    FrameBeverage frameBeverage = new FrameBeverage();
                    return frameBeverage;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            switch(position){
                case 0:
                    return "햄버거";
                case 1:
                    return "치킨";
                case 2:
                    return "음료수";
            }
            return null;
        }
    }

}
