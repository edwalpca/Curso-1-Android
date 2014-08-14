package com.example.clasesemana8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
 
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosHelper extends SQLiteOpenHelper {
 
		 //La carpeta por defecto donde Android espera encontrar laBase de Datos de tu aplicación
		 private static String DB_PATH ="/data/data/com.example.clasesemana8/databases/";
	 	 //private static String DB_PATH ="/assets/";
		 private static String DB_NAME = "libro";
		 private SQLiteDatabase myDataBase;
 		 private final Context myContext;
 		 
 		 
 		 
 
		 /*     * Constructor
		        *
		        * Guarda una referencia al contexto para acceder a lacarpeta assets de la aplicación y a los recursos
		 * @param contexto
		 */
		 public BaseDatosHelper(Context contexto) {
		 
			 super(contexto, DB_NAME, null, 1);
			 this.myContext = contexto;
		 }
		 
 
		 /*
		      * Crea una base de datos vacía en el sistema y lasobreescribe con la que hemos puesto en Assets
		 */
		 public void crearDataBase() throws IOException{
		 
			 boolean dbExist = comprobarBaseDatos();
		 
			 if(dbExist){
				 //Si ya existe no hacemos nada
		         
			}else{
					//Si no existe, creamos una nueva Base de datos en lacarpeta por defecto de nuestra aplicación ,
					//de esta forma el Sistema nos permitirá sobreescribirla conla que tenemos en la carpeta Assets
					this.getReadableDatabase();
					
					try {
							
						copiarBaseDatos();
							
		           } catch (IOException e) {
		        	   
		        	   	throw new Error("Error al copiar la Base de Datos");
		        	   	
		           }
					
		         }
			 
		}
 
 
 
 
 
		 /*
		        * Comprobamos si la base de datos existe
		        * @return true si existe, false en otro caso
		 */
		 private boolean comprobarBaseDatos(){
			 
		         SQLiteDatabase checkDB = null;
		         
		         try{
		         
		        	 String myPath = DB_PATH + DB_NAME;
		            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		        
		         }catch(SQLiteException e){
		        	 
		        	 //No existe
		        	 
		         }
		 
		 		if(checkDB != null){
		        
		 			checkDB.close();
		         
		 		}
		 
		 	return checkDB != null ? true : false;
		 
		 }
		 
 
 /*
* Copia la base de datos desde la carpeta Assetssobre la base de datos vacía recién creada en la carpeta del sistema,
* desde donde es accesible
*/
 private void copiarBaseDatos() throws IOException{
 
	 //Abrimos la BBDD de la carpeta Assets como un InputStream
	 InputStream myInput = myContext.getAssets().open(DB_NAME);
 
	 //Carpeta de destino (donde hemos creado la BBDD vacia)
	 String outFileName = DB_PATH + DB_NAME;
 
	 //Abrimos la BBDD vacia como OutputStream
	 OutputStream myOutput = new FileOutputStream(outFileName);
 
	 //Transfiere los Bytes entre el Stream de entrada y el de Salida
	 byte[] buffer = new byte[1024];
	 int length;
	 while ((length = myInput.read(buffer))>0){
		 
		 	myOutput.write(buffer, 0, length);
		 	
      }
 
	 //Cerramos los ficheros abiertos
	 	myOutput.flush();
         myOutput.close();
         myInput.close();
         
 }
 
 /*
        * Abre la base de datos
        */
 public void abrirBaseDatos() throws SQLException{
	 
           String myPath = DB_PATH + DB_NAME;
           myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
 }
 
 
 /*
        * Cierra la base de datos
        */
 @Override
 public synchronized void close() {

	 if(myDataBase != null)
		
		 myDataBase.close();
	 	
	 	super.close();
}
 
 
@Override
public void onCreate(SQLiteDatabase db) {
	 //No usamos este método
}
 
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 //No usamos este método
 }
 
 //Podemos añadir métodos públicos que accedan al contenido de la base de datos,
 //para realizar consultas, u operaciones CRUD (create, read, update, delete)
 
 private final String TABLE_LIBROS = "Libros";
 private final String TABLE_KEY_ID = "_id";
 private final String TABLE_KEY_TITULO = "Titulo";
 private final String TABLE_KEY_AUTOR = "Autor";
 
 /*
        * Obtiene todos los libros desde la Base de Datos
 */
 public ArrayList<Libro> GetLibros(){
	 
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();
 
        Cursor c = myDataBase.query(TABLE_LIBROS, new String[] {TABLE_KEY_ID, TABLE_KEY_TITULO, TABLE_KEY_AUTOR}, null, null, null, null, null);
        
 
        //Iteramos a traves de los registros del cursor
        c.moveToFirst();
        
        while(c.isAfterLast() == false) {
        	
        	Libro libro = new Libro();
            libro.setTitulo(c.getString(1));
            libro.setAutor(c.getString(2));
            listaLibros.add(libro);
            c.moveToNext();
       }
        c.close();
 
        return listaLibros;
       }
}
 