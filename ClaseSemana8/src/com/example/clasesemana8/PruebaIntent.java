package com.example.clasesemana8;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PruebaIntent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba_intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prueba_intent, menu);
		return true;
	}

}
