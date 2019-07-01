package com.example.myhome;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends Activity {
	
	  private static int TIME_OUT_GO = 3000;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.first);
	        new Handler().postDelayed(new Runnable() {
	            @Override
	            public void run() {
	                Intent intent = new Intent(MainActivity.this,First.class);
	                startActivity(intent);
	                finish();
	            }
	        },TIME_OUT_GO);


	 }
}
