package com.pd.alarmmanager;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create( context, R.raw.padayappabgm );
        mp.start();

        Vibrator vib = (Vibrator) context.getSystemService( context.VIBRATOR_SERVICE );
        vib.vibrate( 3000 );
        Toast.makeText( context, "ALARM..", Toast.LENGTH_SHORT ).show();


    }
}
