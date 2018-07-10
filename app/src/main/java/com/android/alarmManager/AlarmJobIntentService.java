package com.android.alarmManager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class AlarmJobIntentService extends JobIntentService{
    String TAG = "AlarmJobIntentService";

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        if(intent!=null){
            Log.d(TAG,"Intent action:: "+intent.getAction());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
