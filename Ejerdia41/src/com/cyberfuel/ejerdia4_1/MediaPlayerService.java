package com.cyberfuel.ejerdia4_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaPlayerService {
private MediaPlayer mediaPlayer;
    
    /*
     * Este método devuleve el canal de comunicación con el servicio. Normalmente se usará en servicio remotos.
     * Cuando un servicio que no ofrece una interfaz este método devuelve un null. 
     */
    
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
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
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
