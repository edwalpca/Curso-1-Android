package com.example.clasesemana8;

import java.io.IOException;
import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ControladorLista extends ListActivity {
	

			private class LibroAdapter extends ArrayAdapter<Libro> {
			
				private ArrayList<Libro> items;
			
				public LibroAdapter(Context context, int textViewResourceId, ArrayList<Libro> items) {
					
						super(context, textViewResourceId, items);
						this.items = items;
			     }
				
			
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
				
					View v = convertView;
					
					if (v == null) {
					
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					   
						v = vi.inflate(R.layout.lista_item, null);
				    
				}
				
				Libro libro = items.get(position);
				
				if (libro != null) {
				
					TextView ttitulo = (TextView) v.findViewById(R.id.titulo);
				    TextView tautor = (TextView) v.findViewById(R.id.autor);
				    
					if (ttitulo != null) {
					             ttitulo.setText(libro.getTitulo());
					}
				
					if (tautor != null) {
					             tautor.setText(libro.getAutor());
					}
				}
				
				return v;
				    }
			  }


			BaseDatosHelper miBBDDHelper;


			public void crearBBDD() {
				
					miBBDDHelper = new BaseDatosHelper(this);
						
					try {
							miBBDDHelper.crearDataBase();
					     } catch (IOException ioe) {
					    	 	throw new Error("Unable to create database");
					     }
			  }

			/** Called when the activity is first created. */
			@Override
			public void onCreate(Bundle savedInstanceState) {
				
				super.onCreate(savedInstanceState);
			
				// Creamos la Base de datos
			    crearBBDD();
			
				// Obtenemos la lista de Libros
				 ArrayList<Libro> Libros = getItems();
				     
				// Entregamos la lista de Libros al adaptador de la lista en el Layout
				// Lista.xml
				   setListAdapter(new LibroAdapter(this, R.layout.lista_item, Libros));
				   
				   
				   

			}
			
			
			
			/*
			* Obtiene una lista de libros
			*
			* @returns ArrayList<Libro> libros
			*/
			public ArrayList<Libro> getItems() {
				
					//Abrimos una conexi—n
					miBBDDHelper.abrirBaseDatos();
					
					//Consultamos los datos
				    ArrayList<Libro> listaLibros = miBBDDHelper.GetLibros();
				    
				    //Cerramos la conexion
				    miBBDDHelper.close();
				    //Devolvemos los datos
					return listaLibros;
				}
			
			
			public void onListItemClick(ListView parent, View v, int position, long id) {
				 
			      Object o = getListAdapter().getItem(position);
					
				  Toast.makeText(this, Integer.toString(position) + " selected:" + o.toString(), Toast.LENGTH_LONG).show();

				  // alternatively, use 'position' with a string array defined in your class:
					//selection.setText(projectsAsStrings[position]);
				}			
	
			
}