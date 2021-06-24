package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        TextView response=(TextView)this.findViewById(R.id.response);
        MediaPlayer mp=MediaPlayer.create(ReminderActivity.this,R.raw.alarm_sound);
        ToggleButton b=(ToggleButton)findViewById(R.id.music);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.isChecked()){

                    mp.start();

                }
                else{
                    response.setText("Play the song");
                    mp.pause();
                }
            }
        });
    }
}