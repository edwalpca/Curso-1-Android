package com.cyberfuel.tarea1;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Galeria extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.galeria);
		
		final GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		
		gridview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				showDialog(position);
				
			}
			
			
		});
		
	}
	
    protected Dialog onCreateDialog(int id) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_image_adapter);
        dialog.setTitle("Galería de Imágenes");
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        final ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(ImageAdapter.image[id]);
        
        image.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
                
            	
				//int duracion = Toast.LENGTH_SHORT;
			    //Toast toast = Toast.makeText(getApplication(),"Me diste Click en la foto", duracion);
			    //toast.show();
				//toast.setGravity(Gravity.CENTER, 0, 0);  
        		dialog.hide();
			
            }
        });	
        
        return dialog;
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
