package com.example.firstproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;

public class Br extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
         mp = MediaPlayer.create(context, R.raw.alarm_sound);
         mp.start();
    }
}
