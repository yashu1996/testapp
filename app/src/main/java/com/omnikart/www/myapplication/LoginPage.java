package com.omnikart.www.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.logging.Log;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class LoginPage extends ActionBarActivity {

    public static EditText etuser ;
    public static EditText etpass ;
    public Button login;
    public Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etuser = (EditText) findViewById(R.id.editText_username);
        etpass = (EditText) findViewById(R.id.editText_password);
        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etuser.getText()+"";
                String password = etpass.getText()+"";
                Networking n = new Networking();
                n.execute("https://testing.omnikart.com/index.php?route=module/login",Networking.NETWORK_STATE_LOGIN);
                Toast.makeText(getApplicationContext(),"login button clicked",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public static class Networking extends AsyncTask{

        private static int NETWORK_STATE_LOGIN = 1;
        @Override
        protected Object doInBackground(Object[] params) {
            getJson((String)params[0],(int)params[1]);
            return null;
        }
    }

    private static void getJson(String url, int state){
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        String username = etuser.getText()+"";
        String password = etpass.getText()+"";
        postParameters.add(new BasicNameValuePair("username",username));
        postParameters.add(new BasicNameValuePair("password",password));

        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer("");
        try{
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postParameters);
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);

            bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line="" ;
            String LineSeperator = System.getProperty("line.seperator");
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + LineSeperator);
            }
            bufferedReader.close();


        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

