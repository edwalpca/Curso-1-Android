package com.cyberfuel.quizmauricioalpizar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sangre extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sangre);
		
		Button boton = (Button) findViewById(R.id.btn_iniciar_kratos);
		boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent resultIntent = new Intent();
				setResult(MainActivity.RESULT_OK,resultIntent);
				finish();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sangre, menu);
		return true;
	}

}
