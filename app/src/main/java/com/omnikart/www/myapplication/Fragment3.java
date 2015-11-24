package com.omnikart.www.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Yash Gupta on 23-11-2015.
 */
public class Fragment3 extends Fragment{
    Button bt_login;
    private SharedPreferences ex;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_three,container,false);
   Button bt_login=(Button) view.findViewById(R.id.button_login_first);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
                ex = getActivity().getSharedPreferences("com.omnikart.www.apptest.pref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = ex.edit();

                editor.putBoolean("key",true);
                editor.commit();
                Intent intent = new Intent(getActivity(),LoginPage.class);
                startActivity(intent);
            }
        });
        return view;
    }


    // bt_login = (Button) findViewbyId(R.id.);
}
