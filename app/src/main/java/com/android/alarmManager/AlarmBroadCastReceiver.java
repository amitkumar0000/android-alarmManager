package com.android.alarmManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmBroadCastReceiver extends BroadcastReceiver{
    String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null){
            Log.d(TAG,"Intent action:: "+intent.getAction());

            Intent intent1 = new Intent();
            intent1.setAction("JOB INTENT SERVICE");
            AlarmJobIntentService.enqueueWork(context,AlarmJobIntentService.class,1,intent1);
        }
    }
}
