package com.pd.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Intent i;
    MediaController mc;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        init();
    }

    private void init() {
        button = (Button) findViewById( R.id.btn );
        button.setOnClickListener( this );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startAlarm();
                break;
        }
    }

    private void startAlarm() {
        editText = (EditText) findViewById( R.id.edt );
        int str = Integer.parseInt( editText.getText().toString() );
        i = new Intent( this.getApplicationContext(), BroadcastReceiver.class );
        pendingIntent = PendingIntent.getBroadcast( this.getApplicationContext(), 8674952, i, 0 );
        alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );
        alarmManager.set( AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (str * 1000), pendingIntent );

        Toast.makeText( this, "Alarm set in " + str + "seconds", Toast.LENGTH_SHORT ).show();
//        videoView = (VideoView) findViewById( R.id.videoview );
//        MediaController mc = new MediaController( MainActivity.this );
//        mc.setAnchorView( videoView );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (alarmManager != null) {
            alarmManager.cancel( pendingIntent );
        }
    }
}