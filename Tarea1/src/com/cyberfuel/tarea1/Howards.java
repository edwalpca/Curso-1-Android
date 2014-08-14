package com.cyberfuel.tarea1;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//import java.util.Random; // Importacion de la libreria Random
import com.cyberfuel.tarea1.MiAleatorio;

public class Howards extends Activity {

	private static final String TAG = "Lab-Ulacit";	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howards);
        
        Log.i(TAG, "Creado Actividad de howards");
        
        Button b1 = (Button) findViewById(R.id.btn_candidato);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.i(TAG, "Selecionando Aleatorio");
				
				String[] partidos 	 = new String[] {"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};
				
				String[] imagenes 	 = getResources().getStringArray(R.array.imgs_arreglo);
		
				MiAleatorio numero = new MiAleatorio();
				int n = numero.deme_numero();

				int duracion = Toast.LENGTH_SHORT;
			    Toast toast = Toast.makeText(getApplication(),"Procesando Información", duracion);
			    toast.show();
				toast.setGravity(Gravity.CENTER, 0, 0);
				
				// Para Setear el nombre el Partido
			   TextView NombrePartido = (TextView) findViewById(R.id.nombre_partido);
			   NombrePartido.setText("-" + partidos[n] + "-"); 

				// Para Setear la imange del Partido
			   ImageView ImagenPartido = (ImageView) findViewById(R.id.imagen_partido);
			   
			   int imageId = getResources().getIdentifier(imagenes[n], "drawable","com.cyberfuel.tarea1");			   
			   ImagenPartido.setImageResource(imageId);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.howards, menu);
        
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.howards,menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }
    
    
	 @Override
	 public boolean onMenuItemSelected(int featureId, MenuItem item) {
	      
		 //Toast.makeText(getApplicationContext(), item.getTitle() + " menu seleccionado", Toast.LENGTH_SHORT).show();
		 
		 switch (item.getItemId()) {
		 	case R.id.menu_item1:
		 		Intent intmenu = new Intent(getBaseContext(),AcercaDe.class);
		 		startActivity(intmenu);
		 		break;
		 }// switch (item.getItemId()) {

		 return true;
	 }    
    
}
