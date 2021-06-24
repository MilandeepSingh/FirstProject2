package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class Alarm extends AppCompatActivity {

    Button btnStart;
    EditText time;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        btnStart = findViewById(R.id.btn_start_alarm);
        time = findViewById(R.id.edt_time_alarm);
        //timePicker.setIs24HourView(true);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stt();
            }
        });

    }

    private void stt() {
        int i = 0;//Integer.parseInt(time.getText().toString());
        Toast.makeText(this, "Wake up in "+ i +" secs...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Br.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                5456, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i*1000), pendingIntent);

        Toast.makeText(this, "Wake up in "+ i +" secs...", Toast.LENGTH_SHORT).show();
    }
}
