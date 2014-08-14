package com.cyberfuel.tarea1;


import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class ListaOpciones extends ListActivity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.lista_opciones,
				getResources().getStringArray(R.array.op_menu_principal)));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
	 	
			
		});	
		
		View view = getLayoutInflater().inflate(R.layout.lista_opciones,null,false);	
		TextView vlist = (TextView) view.findViewById(R.id.lista_op);
		lv.addView(view);
		setContentView(lv);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_opciones, menu);
		return true;
	}

}
