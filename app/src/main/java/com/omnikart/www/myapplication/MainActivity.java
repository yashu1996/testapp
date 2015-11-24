package com.omnikart.www.myapplication;

import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    ViewPager mViewPager;
   // boolean clicked = true;
  // public static final String PREFS="examplepref";
    private SharedPreferences e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        e = getSharedPreferences("com.omnikart.www.apptest.pref",Context.MODE_PRIVATE);
       Boolean c = e.getBoolean("key",false);
        if(c == true){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

    }
    else{

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mViewPager =(ViewPager) findViewById(R.id.pager_title_strip);
            PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
            mViewPager.setAdapter(padapter);
        }

    }




}
