package com.cyberfuel.animacionframe;


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
    
    /*
     * Instancia un MediaPlayer pasándole el recurso que se quiere reproducir. A continuación se configura para que se reproduzca sin fin.
     * Se llama al método onCreate cuando se crea el servicio.
     */
        
    @Override
    public void onCreate() {
        super.onCreate();        
        mediaPlayer = MediaPlayer.create(this, R.raw.police);
        mediaPlayer.setLooping(true);
    }
    
    /*
     * Muestra un mensaje al usuario indicando que se inicia el servicio e inicia el reproductor.
     * 
     */
    
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Se inicia el servicio", Toast.LENGTH_LONG).show();
        mediaPlayer.start();        
    }
    
    /*
     * Muestra un mensaje al usuario indicando que se para el servicio y a continuación se para el reproductor.
     * 
     */
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Se para el servicio", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();                
    }
   
    
    
}
