package com.example.valentin.zaptowork.Settings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.valentin.zaptowork.R;

import static com.example.valentin.zaptowork.Utils.ActivityUtils.addFragmentToActivity;

public class SettingsActivity extends AppCompatActivity {

    SettingsFragment settingsFragment;

    SettingsPresenter settingsPresenter;

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
    }

}
