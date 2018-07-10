package com.android.alarmManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;
import static android.os.Build.VERSION.SDK_INT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.button1:{
                createAlarmActivity();
                break;
            }
            case R.id.button2:{
                createAlarmService();
                break;
            }
            case R.id.button3:{
                createAlarmReceiver();
                break;
            }
        }
    }

    private void createAlarmActivity() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmActivity.class);
        intent.setAction("Alarm Activity");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                100,intent,FLAG_CANCEL_CURRENT);
        if(SDK_INT < Build.VERSION_CODES.M) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 10 * 1000, pendingIntent);
        } else if (SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 10 * 1000, pendingIntent);
        }
    }

    private void createAlarmService() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmService.class);
        intent.setAction("Alarm Service");
        PendingIntent pendingIntent = PendingIntent.getService(this,
                100,intent,FLAG_CANCEL_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10*1000,pendingIntent);
    }

    private void createAlarmReceiver(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmBroadCastReceiver.class);
        intent.setAction("android.alarm.receiver");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                100,intent,FLAG_CANCEL_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10*1000,pendingIntent);
    }
}
