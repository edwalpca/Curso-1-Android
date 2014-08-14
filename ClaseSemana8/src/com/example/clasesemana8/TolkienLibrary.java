package com.example.clasesemana8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TolkienLibrary extends Activity {
	 
	 final public static String MyKey = "mikey";
	 
	 /** Called when the activity is first created. */
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 
	 super.onCreate(savedInstanceState);
	      
	 setContentView(R.layout.activity_main);
	 
	 
	      Button next = (Button) findViewById(R.id.Button02);
	      Button btnAgregar = (Button) findViewById(R.id.btn_agregar);
	      
	      
	      next.setOnClickListener(new View.OnClickListener() {
	 
	    	  
					 public void onClick(View view) {
	 
								 // Cargamos el Bundle con la coleccion de objetos quepasaremos
								 // a la siguiente vista
								 Bundle bundle = new Bundle();
								 bundle.putString(MyKey, "Esto lo hemos enviado desde la vista principal.");
	 

								 // Creamos la vista de Lista de objetos y le pasamos la
								 // colecci—n de objetos a mostrar
								 Intent myIntent = new Intent(view.getContext(), ControladorLista.class);
								           
								 myIntent.putExtras(bundle);
								 
								 startActivityForResult(myIntent, 0);
					}
	 
		});// next.setOnClickListener(new View.OnClickListener() {
	      
	      
	      btnAgregar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i_nuevoLibro = new Intent(getBaseContext(),NuevoLibro.class);
				startActivity(i_nuevoLibro);
				
				
			}
		});
	      
	      

	 }//public void onCreate(Bundle savedInstanceState) {
	 
	 
	 @Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {

						
			// TODO - Process the result only if this method received both a
			if (requestCode == 0) { /* BY EMA */
				// RESULT_OK result code and a recognized request code
				if (resultCode == 0) {/* BY EMA */
					// If so, update the Textview showing the user-entered text.
					 
					 
					 
					
				}
				
			}
	 }
	 
	 
	 
}