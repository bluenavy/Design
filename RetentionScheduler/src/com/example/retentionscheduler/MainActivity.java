package com.example.retentionscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{
	
	//@SuppressWarnings("unused")
	private Button theButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theButton = (Button)findViewById(R.id.create);
        theButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v){
        //respond to click
    	if(v.getId()==theButton.getId()){
    	    //the button was clicked
    		Intent i=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}