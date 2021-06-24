package com.example.firstproject;

import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;
import  java.util.Calendar;
import android.widget.Toast;
import android.os.Bundle;

public class AlarmAppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_app);
        Button alarmButton=(Button) this.findViewById(R.id.alarm_button);
        alarmButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent=new Intent(AlarmAppActivity.this,ReminderActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(AlarmAppActivity.this,0,myIntent,PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND,1);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                Toast.makeText(AlarmAppActivity.this,"Alarm will start in a second",Toast.LENGTH_LONG).show();
            }
        });
    }
}
