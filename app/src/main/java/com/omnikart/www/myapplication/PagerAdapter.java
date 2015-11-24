package com.omnikart.www.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Yash Gupta on 23-11-2015.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0){
            case 0:
                return new Fragment1();

            case 1:
                return new Fragment2();

            case 2:
                return new Fragment3();

            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
