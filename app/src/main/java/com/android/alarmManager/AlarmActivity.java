package com.android.alarmManager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AlarmActivity extends AppCompatActivity {

    String TAG = "AlarmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();
        if(intent!=null) {
            Log.d(TAG, "Action:: " + intent.getAction());
        }

    }
}
