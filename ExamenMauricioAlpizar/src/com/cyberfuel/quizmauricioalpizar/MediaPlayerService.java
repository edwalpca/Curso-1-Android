package com.cyberfuel.quizmauricioalpizar;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MediaPlayerService extends Service {
	
    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
    
        
    @Override
    public void onCreate() {
        super.onCreate();        
        mediaPlayer = MediaPlayer.create(this, R.raw.guanacasteco);
        mediaPlayer.setLooping(true);
    }
    
    
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Se inicia el servicio", Toast.LENGTH_LONG).show();
        mediaPlayer.start();        
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Se para el servicio", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();                
    }
  
    
    
}
