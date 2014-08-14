package com.cyberfuel.animacionframe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button btn_start = (Button) findViewById(R.id.btn_start);
     
        btn_start.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				animate();
			}
		});
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void animate(){
    	  ImageView imgView = (ImageView)findViewById(R.id.imagen);
    	  imgView.setVisibility(ImageView.VISIBLE);
    	  imgView.setBackgroundResource(R.drawable.frame_animation);
    	 
    	  AnimationDrawable frame = (AnimationDrawable) imgView.getBackground();
    	  
    	  if(frame.isRunning()){
    		  frame.stop();

    		  Intent intent = new Intent(this, MediaPlayerService.class);
              stopService(intent);
    		  
    		  
    		  
    	  }else{
    		  frame.stop();
    		  frame.start();
    		  
    		  Intent intent = new Intent(this, MediaPlayerService.class);
              startService(intent);
    		  
    		  
    		  
    	  }
    	 }
    
    
}
