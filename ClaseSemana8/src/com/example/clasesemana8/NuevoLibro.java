package com.example.clasesemana8;


import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoLibro extends Activity {
	
	
	EditText titulo,autor;
	
	
    private SQLiteDatabase baseDatos;   
    private static final String TAG = "";   
    private static final String nombreBD = "libro";   
    private static final String tabla_libros = "libros";  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_libro);
		
		
		
		Button btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
		Button btn_guardar 	= (Button) findViewById(R.id.btn_guardar);
		
		titulo   = (EditText) findViewById(R.id.txt_titulo);   
		autor 	= (EditText) findViewById(R.id.txt_autor); 
		
		
		
		btn_cancelar.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				finish();
				
			}
		} );
		
		

		btn_guardar.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				  abrirBasedatos();
		          //Insertar una fila o registro en la tabla "contacto"
		          //si la inserción es correcta devolverá true     
		          boolean resultado = sql_insertar(titulo.getText().toString(), autor.getText().toString());
		          if(resultado) 
		        	  Toast.makeText(getApplicationContext(), "Contacto añadido correctamente", Toast.LENGTH_LONG).show();
		          else 
		            Toast.makeText(getApplicationContext(), "No se ha podido guardar el contacto" ,   Toast.LENGTH_LONG).show();                     
		        }
		});
		
		
		
		
	};






		//Procedimiento para abrir la base de datos
		//si no existe se creará, también se creará la tabla contacto        
		private void abrirBasedatos() {   
		  try 
		  {   
		    baseDatos = openOrCreateDatabase(nombreBD, MODE_WORLD_WRITEABLE, null);   
		    baseDatos.execSQL(tabla_libros);   
		  }    
		  catch (Exception e)
		  {   
		    Log.i(TAG, "Error al abrir o crear la base de datos" + e);   
		  }   
		}
		
		
	      //Método que realiza la inserción de los datos en nuestra tabla  contacto                  
	      private boolean sql_insertar(String titulo, String autor) {   
	        ContentValues values = new ContentValues();   
	        values.put("Titulo",titulo );   
	        values.put("Autor", autor);
	        Toast.makeText(getApplicationContext(), "Titulo: " + titulo + ", " + "Autor: " + autor, Toast.LENGTH_LONG).show();
	        return (baseDatos.insert(tabla_libros, null, values) > 0);   
	      }
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nuevo_libro, menu);
		return true;
	}

}
