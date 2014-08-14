package com.cyberfue.gridgallery;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                
            	showDialog(position);
                
			
            }
        });
    }
    
    protected Dialog onCreateDialog(int id) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_image_adapter);
        dialog.setTitle("Galer�a de Im�genes");
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        final ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(ImageAdapter.image[id]);
        
        image.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
                
            	// showDialog(position);
				int duracion = Toast.LENGTH_SHORT;
			    Toast toast = Toast.makeText(getApplication(),"Me diste Click en la foto", duracion);
			    toast.show();
				toast.setGravity(Gravity.CENTER, 0, 0);                
			
            }
        });	
        
        return dialog;
    }
}
