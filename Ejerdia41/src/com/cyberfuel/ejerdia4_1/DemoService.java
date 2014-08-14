package com.cyberfuel.ejerdia4_1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DemoService extends Activity implements OnClickListener {

    private Button startServiceButton;
    private Button stopServiceButton;
    
    /*
     * llama al setContentView el cual infla el recurso R.layou.main y añade la jerarquìa de vistas a la actividad. 
     * A continuación se inicializan los atributos startServiceButton y stopServiceButton con las referencias de los botones
     * declarados en el archivo de layout. Y por último registra un OnClicklistener a cada botón que será quien decida
     * en base al botón pulsado cuando llamar al startService o al stopService
     */
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.startServiceButton = (Button) findViewById(R.id.startServiceButton);
        this.stopServiceButton  = (Button) findViewById(R.id.stopServiceButton);
        
        this.startServiceButton.setOnClickListener(this);
        this.stopServiceButton.setOnClickListener(this);
        
    }
    
    /*
     * Callback al que se llama cuando se pulsa un botón. En este caso hemos indicado que sea la actividad la que cumpla el rol 
     * de antender a todos los eventos onClick que se produzcan en las vistas. En este método dependiendo del botón que se
     * haya pulsado se iniciará o parará un servicio.
     */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
           case R.id.startServiceButton:
               Log.i("Demo", "se llama onClick del botón " + view.getId());
               Intent intent = new Intent(this, MediaPlayerService.class);
               startService(intent);
               
               break;      
           case R.id.stopServiceButton:
               Log.i("Demo", "se llama al onclick del botón" + view.getId());
               intent = new Intent(this, MediaPlayerService.class);
               stopService(intent);
               
               break;
        }
    }
    
}
