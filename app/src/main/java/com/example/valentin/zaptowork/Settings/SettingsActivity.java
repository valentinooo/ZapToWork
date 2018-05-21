package com.example.valentin.zaptowork.Settings;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.valentin.zaptowork.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

import static com.example.valentin.zaptowork.Utils.ActivityUtils.addFragmentToActivity;

public class SettingsActivity extends AppCompatActivity {

    SettingsFragment settingsFragment;

    SettingsPresenter settingsPresenter;

    Button checkConnectivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setttings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(settingsFragment == null){
            settingsFragment= settingsFragment.newInstance();
            addFragmentToActivity(getFragmentManager(),settingsFragment,R.id.content_layout);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        checkConnectivityButton =(Button) findViewById(R.id.button_id);
        checkConnectivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(IsReachable(getApplicationContext()))
                    checkConnectivityButton.setVisibility(View.GONE);
                else
                    finish();

            }
        });
    }

    public boolean IsReachable(Context context) {
        // First, check we have any sort of connectivity
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
        boolean isReachable = false;

        if (netInfo != null && netInfo.isConnected()) {
            // Some sort of connection is open, check if server is reachable
            try {
                URL url = new URL("http://www.google.com");
                //URL url = new URL("http://10.0.2.2");
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setRequestProperty("User-Agent", "Android Application");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(10 * 1000);
                urlc.connect();
                isReachable = (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                //Log.e(TAG, e.getMessage());
            }
        }

        return isReachable;
    }

}
