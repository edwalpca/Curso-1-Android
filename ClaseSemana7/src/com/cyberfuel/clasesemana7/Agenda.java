package com.cyberfuel.clasesemana7;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agenda extends Activity {
	
    EditText editNombre,editTelefono;
    private Button botonGuardar;
    private Button botonLlamar;
    private Button botonEliminarBD;
    private Button botonCerrar;  
       
    private SQLiteDatabase baseDatos;   
    private static final String TAG = "bdagenda";   
    private static final String nombreBD = "agenda";   
    private static final String tablaContacto = "contacto";  
      
    //guardamos en un String toda la creación de la tabla        
    private static final String crearTablaContacto = "create table if not exists "  
        + " contacto (codigo integer primary key autoincrement, "  
        + " nombre text not null, telefono text not null unique);";   
      
    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
      //Asignamos a cada objeto visual creado a su respectivo elemento de  main.xml           
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      editNombre   = (EditText) findViewById(R.id.txtNombre);   
      editTelefono = (EditText) findViewById(R.id.txtTelefono); 
      botonGuardar = (Button) findViewById(R.id.btGuardar);
      botonLlamar = (Button) findViewById(R.id.btLlamar);
      botonEliminarBD = (Button) findViewById(R.id.btEliminarBD);
      botonCerrar = (Button) findViewById(R.id.btCerrar); 
      
      
      
      //Guardar el contacto actual en la agenda
      botonGuardar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
          //Abrir la base de datos, se creará si no existe                     
          abrirBasedatos();
          //Insertar una fila o registro en la tabla "contacto"
          //si la inserción es correcta devolverá true     
          boolean resultado = insertarFila(editNombre.getText().toString(), editTelefono.getText().toString());
          if(resultado) 
        	  Toast.makeText(getApplicationContext(), "Contacto añadido correctamente", Toast.LENGTH_LONG).show();
          else 
            Toast.makeText(getApplicationContext(), "No se ha podido guardar el contacto" ,   Toast.LENGTH_LONG).show();                     
        }
      });
      
      
    
      //Llamar al contacto actual por teléfono
      botonLlamar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {        
          //Mostrar un mensaje de confirmación antes de realizar la llamada  
          AlertDialog.Builder alertDialog = new AlertDialog.Builder(Agenda.this);
          alertDialog.setMessage("¿Desea realizar la llamada al contacto?");
          alertDialog.setTitle("Llamar a contacto...");
          alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
          alertDialog.setCancelable(false);
          alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which){
              try 
              {                       
                EditText num=(EditText)findViewById(R.id.txtTelefono); 
                String number = "tel:" + num.getText().toString().trim();
                Toast.makeText(getApplicationContext(), 
                        "Llamando al " + num.getText().toString().trim(), Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number)); 
                startActivity(callIntent);
              } 
              catch (Exception e) 
              {
                  Toast.makeText(getApplicationContext(), 
                          "No se ha podido realizar la llamada", Toast.LENGTH_LONG).show();
              }
            } 
          }); 
          alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            {
              Toast.makeText(getApplicationContext(), "Llamada cancelada", Toast.LENGTH_LONG).show();
            } 
          }); 
          alertDialog.show();
        } 
      });
      
      
      
      //Eliminar la base de datos de la agenda
      botonEliminarBD.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
          //Mostrar un mensaje de confirmación antes de eliminar la base de datos  
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Agenda.this);
            alertDialog.setMessage("¿Desea eliminar la base de datos por completo?");
            alertDialog.setTitle("Eliminar agenda...");
            alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() 
            {
              public void onClick(DialogInterface dialog, int which) 
              {
                try 
                {  
                    Toast.makeText(getApplicationContext(), 
                            "Eliminando base de datos: " + nombreBD, Toast.LENGTH_LONG).show();
                    boolean resultado = deleteDatabase(nombreBD);
                    if(resultado) 
                      Toast.makeText(getApplicationContext(), 
                            "Base de datos eliminada correctamente", Toast.LENGTH_LONG).show();
                      else 
                        Toast.makeText(getApplicationContext(), 
                            "No se ha podido eliminar la base de datos", Toast.LENGTH_LONG).show();                  
                } 
                catch (Exception e) 
                {
                  Toast.makeText(getApplicationContext(), 
                          "No se ha podido eliminar la base de datos", Toast.LENGTH_LONG).show();
                }
              } 
            }); 
            alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() 
            {
              public void onClick(DialogInterface dialog, int which) 
              {
                Toast.makeText(getApplicationContext(), 
                        "Eliminación de base de datos cancelada", Toast.LENGTH_LONG).show();
              } 
            }); 
            alertDialog.show();
        }
      }); 
      
      
      //Cerrar aplicación Android
      botonCerrar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
            finish();
        }
      });  
    }
    
    
    //Procedimiento para abrir la base de datos
      //si no existe se creará, también se creará la tabla contacto        
      private void abrirBasedatos() {   
        try 
        {   
          baseDatos = openOrCreateDatabase(nombreBD, MODE_WORLD_WRITEABLE, null);   
          baseDatos.execSQL(crearTablaContacto);   
        }    
        catch (Exception e)
        {   
          Log.i(TAG, "Error al abrir o crear la base de datos" + e);   
        }   
      }  
      
      
      //Método que realiza la inserción de los datos en nuestra tabla  contacto                  
      private boolean insertarFila(String nombre, String telefono) {   
        ContentValues values = new ContentValues();   
        values.put("nombre",nombre );   
        values.put("telefono", telefono);
        Toast.makeText(getApplicationContext(), "Nombre: " + nombre + ", " +
                "teléfono: " + telefono, Toast.LENGTH_LONG).show();
        return (baseDatos.insert(tablaContacto, null, values) > 0);   
      }


}
