package com.cyberfuel.clasesemana7;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class ListadoContactos extends Activity {
	
	
    private SQLiteDatabase baseDatos;   
    private static final String TAG = "bdagenda";   
    private static final String nombreBD = "agenda";   
    private static final String tablaContacto = "contacto";  	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listado_contactos);
		
		
		
		
		
		
	}
	
	
    //Procedimiento para abrir la base de datos
    //si no existe se creará, también se creará la tabla contacto        
    private void abrirBasedatos() {   
      try 
      {   
        baseDatos = openOrCreateDatabase(nombreBD, MODE_WORLD_WRITEABLE, null);   
        //baseDatos.execSQL(crearTablaContacto);   
      }    
      catch (Exception e)
      {   
        Log.i(TAG, "Error al abrir o crear la base de datos" + e);   
      }   
    }  	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listado_contactos, menu);
		return true;
	}

}
