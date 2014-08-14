package com.cyberfuel.tarea1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PantallaOpciones extends Activity {

	final Context context = this;

	private static final String TAG = "Lab-Ulacit";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla_opciones);
	
		Button b1 = (Button) findViewById(R.id.op_1);
		Button b2 = (Button) findViewById(R.id.op_2);
		
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(TAG, "Ingreso al Boton 1");
				Intent intent = new Intent(PantallaOpciones.this,Howards.class);
				startActivity(intent);
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.i(TAG, "Ingreso al Boton 2 - Galeria");

				Intent intent = new Intent(getBaseContext(),Galeria.class);
				startActivity(intent);
				
				// - EMA AlertDialog alertDialog = new AlertDialog.Builder(PantallaOpciones.this).create();
				// Setting Dialog Title
				// - EMA alertDialog.setTitle("Alert Dialog");
				// Setting Dialog Message
				// - EMA alertDialog.setMessage("Aun no se encuentra Programado");
				// Setting Icon to Dialog
				// - EMA alertDialog.setIcon(R.drawable.tick);
				// Setting OK Button
				// - EMA alertDialog.setButton(RESULT_OK,"OK", new DialogInterface.OnClickListener() {
				// - EMA public void onClick(DialogInterface dialog, int which) {
					// Write your code here to execute after dialog closed
				// - EMA Toast.makeText(getApplicationContext(), "Gracias, te esperamos pronto", Toast.LENGTH_SHORT).show();
				// - EMA }
        //});
 
        // Showing Alert Message
       // alertDialog.show();
				
				
				
			}
		});		
	
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla_opciones, menu);
		return true;
	}

}
