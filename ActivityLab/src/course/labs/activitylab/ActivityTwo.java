package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	// Lifecycle counters
	protected int mCreate = 0;
	protected int mStart  = 0;
	protected int mResume  = 0;
	protected int mRestart  = 0;	



	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				 finish();
			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);				
		}

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onCreate method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		this.mCreate = this.mCreate +1;
		this.displayCounts();			

	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onStart method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		this.mStart = this.mStart +1;
		this.displayCounts();		



	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onResume method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		this.mResume = this.mResume +1;
		this.displayCounts();			




	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onPause method");



	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onStop method");

		



	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onRestart method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		this.mRestart = this.mRestart +1;
		this.displayCounts();			
		



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit Entered the
		Log.i(TAG,"Entered the onDestroy method");
		

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);	
		
	}

	// Updates the displayed counters
	public void displayCounts() {

		   TextView mTvCreate 	= (TextView) findViewById(R.id.mTvCreate);
		   TextView mTvStart 	= (TextView) findViewById(R.id.mTvStart);
		   TextView mTvResume 	= (TextView) findViewById(R.id.mTvResume);
		   TextView mTvRestart 	= (TextView) findViewById(R.id.mTvRestart);
			
			mTvCreate.setText("onCreate() calls: " + this.mCreate);
			mTvStart.setText("onStart() calls: " + this.mStart);
			mTvResume.setText("onResume() calls: " + this.mResume);
			mTvRestart.setText("onRestart() calls: " + this.mRestart);
	
	}
}
