package app.cyberfuel.clase_1_ejercicio;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaInicial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);
        // 
        Button b1 = (Button) findViewById(R.id.btn_principal);
        b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {

			   int duracion = Toast.LENGTH_SHORT;
		       Toast toast = Toast.makeText(getApplication(),"Dió Click en el botón", duracion);
		       toast.show();
		       
		       TextView tv = (TextView) findViewById(R.id.mensaje_principal);
		       tv.setText("Ohh! Me diste Click");   				
		       
			}//public void onClick(View v) {
        });// b1.setOnClickListener(new OnClickListener() {        
    
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantalla_inicial, menu);
        return true;
    }		
    
}
