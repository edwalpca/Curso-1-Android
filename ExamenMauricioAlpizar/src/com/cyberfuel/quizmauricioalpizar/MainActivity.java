package com.cyberfuel.quizmauricioalpizar;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int contador = 0;
	private int aleatorio = 0;
	private int es_primo = 0;    /* 0 = No Primo; 1 = Primo  */ 
	public static final int[] NUMERO_PRIMOS = new int[] {2,3,5,7};
	static private final int GET_TEXT_REQUEST_CODE = 1;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button btn_start = (Button) findViewById(R.id.btn_start);
     
        btn_start.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				aleatorio = deme_aleatorio();
				contador++;
				if (contador > 3){
					contador = 0;
					verificar_animacion();
				}			
				
				
				if ( (aleatorio == 2) ||  (aleatorio == 3) ||  (aleatorio == 5) ||  (aleatorio == 7) )
				// if (Arrays.asList(NUMERO_PRIMOS).contains(aleatorio))
					es_primo = 1;
				else
					es_primo = 0;
					
				
				

				
				if ((es_primo == 1) && (contador == 3)){
					animate();
				}else if ((es_primo == 0) && (contador == 3)){
					pacto_sangre();
				}else if ((es_primo == 1)){
					pacto_sangre();
				}
				
				TextView num_aleatorio = (TextView) findViewById(R.id.numero_aleatorio);
				num_aleatorio.setText("Aleatorio:" + Integer.toString(aleatorio));
					
				TextView textview = (TextView) findViewById(R.id.Contador);
				textview.setText("Contador:" + Integer.toString(contador));				
			
				
			}


		});
    }

    public void pacto_sangre(){
		Intent i = new Intent(MainActivity.this, Sangre.class);
		startActivityForResult(i, GET_TEXT_REQUEST_CODE);
    }
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void animate(){
    	 
    	  ImageView imgView = (ImageView)findViewById(R.id.imagen);
    	  imgView.setVisibility(ImageView.VISIBLE);
    	  imgView.setBackgroundResource(R.drawable.frame_animation);
    	  AnimationDrawable frame = (AnimationDrawable) imgView.getBackground();
    	  
    	  Button btn_start = (Button) findViewById(R.id.btn_start);
    	  
    	  if(frame.isRunning()){

    		  btn_start.setText("Comenzar el Baile");
    		  limpiar_actividad();
    		  
    		  frame.stop();
    		  Intent intent = new Intent(this, MediaPlayerService.class);
              stopService(intent);// Parada del servicio de MediaPlayer
    		  
    	  }else{

    		  btn_start.setText("Detener la Animación");
    		  frame.stop();
    		  frame.start();
    		  Intent intent = new Intent(this, MediaPlayerService.class); 
              startService(intent);// Inicio del servicio de MediaPlayer
              
      		
    		TextView num_aleatorio = (TextView) findViewById(R.id.numero_aleatorio);
    		num_aleatorio.setText("Aleatorio:");
    		TextView textview = (TextView) findViewById(R.id.Contador);
    		textview.setText("Contador:" + Integer.toString(contador));    	
              
              
    	  }
    	 }
    

    private void verificar_animacion(){
   	 	
  	  ImageView imgView = (ImageView)findViewById(R.id.imagen);
  	  imgView.setVisibility(ImageView.INVISIBLE);
  	  //imgView.setBackgroundResource(R.drawable.frame_animation);
  	  AnimationDrawable frame = (AnimationDrawable) imgView.getBackground();
  	  if(frame.isRunning()){
  		  frame.stop();
  		  Intent intent = new Intent(MainActivity.this, MediaPlayerService.class);
          stopService(intent);// Parada del servicio de MediaPlayer
  		  
  	  }
    }    
    
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		
		if (requestCode == GET_TEXT_REQUEST_CODE) { /* BY EMA */
		
			if (resultCode == RESULT_OK) {/* BY EMA */
				
				limpiar_actividad();
				
			}
			
		}
	}//protected void onActivityResult(int requestCode, int resultCode, Intent data)
    
    
    // Genera el numero aleatorio entre 1 y 10;
    private int deme_aleatorio(){

    	Random rand = new Random();
    	
    	int minumero = rand.nextInt(9)+1;
    	
    	return minumero;
    	
    }
    
    private void limpiar_actividad(){
    	
		contador = 0;
		TextView num_aleatorio = (TextView) findViewById(R.id.numero_aleatorio);
		num_aleatorio.setText("Aleatorio:");
		TextView textview = (TextView) findViewById(R.id.Contador);
		textview.setText("Contador:" + Integer.toString(contador));    	
    	ImageView imgView = (ImageView)findViewById(R.id.imagen);
    	imgView.setVisibility(ImageView.INVISIBLE);
    	
    	
    }
    
}

