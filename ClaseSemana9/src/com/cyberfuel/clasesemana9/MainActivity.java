package com.cyberfuel.clasesemana9;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    
    class DownloadImageTask extends AsyncTask<String, Void, Drawable>{
           
    	final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

                  protected void onPreExecute()
                  {
                      progressDialog.setTitle("");
                      progressDialog.setMessage("Cargando imagen...");
                      progressDialog.show();
                  }

                  protected Drawable doInBackground(String... urls)
                  {
                      Log.d("DEBUG", "drawable");

                      return downloadImage(urls[0]);

                  }

                  protected void onPostExecute(Drawable imagen)
                  {

                      m_imageView.setImageDrawable(imagen);
                      progressDialog.dismiss();
                  }

				  /**
				   * Devuelve una imagen desde una URL
				   * @param url Url de la imagen
				   * @return Una imagen
				   */
                  private Drawable downloadImage(String imageUrl)
                  {
                      try
                      {
                          URL url = new URL(imageUrl);
                          InputStream is = (InputStream)url.getContent();
                          return Drawable.createFromStream(is, "src");
                      }
                      catch (MalformedURLException e)
                      {
                          e.printStackTrace();
                          return null;
                      }
                      catch (IOException e)
                      {
                          e.printStackTrace();
                          return null;
                      }
                  }
           }


   private Button btn;
   private ImageView m_imageView;
   private EditText inputUrl;
   
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
	   
       super.onCreate(savedInstanceState);
       
       setContentView(R.layout.activity_main);
       
       inputUrl = (EditText)findViewById(R.id.editText1);
       
       m_imageView = (ImageView)findViewById(R.id.imageView1);
       
       btn = (Button) findViewById(R.id.button1);
       
       
       btn.setOnClickListener(new OnClickListener(){
         //   @Override
            public void onClick(View arg0)
            {
                   String url=inputUrl.getText().toString();
                   if (url.length()>0)
                   {
                      new DownloadImageTask().execute(url);
                   }
             }
       });
   }

    
}
