package com.example.fastmenu.adapter.viewPager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
                return frameHamburger;
            case 1:
                FrameChicken frameChicken = new FrameChicken();
                return frameChicken;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "햄버거";
            case 1:
                return "치킨";
        }
        return null;
    }
}
