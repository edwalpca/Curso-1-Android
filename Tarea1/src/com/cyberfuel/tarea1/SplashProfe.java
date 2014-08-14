package com.cyberfuel.tarea1;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashProfe extends Activity {

	
	private int SPLASH_DISPLAY_LENGTH = 1000;
	

	/**
	* Metodo en el cual se debe incluir dentro de run(){Tu codigo} el codigo que se quiere realizar una
	* vez ha finalizado el tiempo que se desea mostrar la actividad de splash
	* @return
	*/
	private Runnable getRunnableStartApp(){
	Runnable runnable = new Runnable(){
	public void run(){
		//al interior valida si deben insertarse registros e inserta las estaciones si no existen
		//EstacionesMetroBO estacionesMetroBO = BusinessContext.getBean(EstacionesMetroBO.class);
		//estacionesMetroBO.insertRecordsEstacionesMetro();
		Intent intent = new Intent(SplashProfe.this, PantallaOpciones.class);
		startActivity(intent);
		finish();
	}
	};
	return runnable;
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashprofe);
		
		
		Handler handler = new Handler();
		handler.postDelayed(getRunnableStartApp(), SPLASH_DISPLAY_LENGTH);

	
	}

	

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_profe, menu);
		return true;
	}

}
