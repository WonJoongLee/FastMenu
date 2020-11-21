package com.example.fastmenu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fastmenu.adapter.viewPager.FrameAdapter;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {

    private ViewPager viewPager;
    private FrameAdapter frameAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        viewPager = findViewById(R.id.menuViewpager);
        TabLayout tabLayout = findViewById(R.id.menuTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        frameAdapter = new FrameAdapter(getSupportFragmentManager());
        viewPager.setAdapter(frameAdapter);
    }
}
