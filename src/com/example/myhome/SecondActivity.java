package com.example.myhome;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class SecondActivity extends Activity{
	 //声明组件变量	
    Button btnGK,btnFJ,btnJD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.activity_main);
    	 btnJD=(Button)this.findViewById(R.id.button4);
    	 btnGK=(Button)this.findViewById(R.id.button5);
    	 btnFJ=(Button)this.findViewById(R.id.button6);
    	 btnFJ.setOnClickListener(new OnClickListener(){
          	@Override
          	public void onClick(View v){                     
                        Intent intent = new Intent(SecondActivity.this, GallaryTest.class);             
                        startActivity(intent);                      
          		}          		
          	}
          );	 
    	 btnGK.setOnClickListener(new OnClickListener(){
           	@Override
           	public void onClick(View v){                     
                         Intent intent = new Intent(SecondActivity.this, ScrollView.class);             
                         startActivity(intent);                      
           		}          		
           	}
           );	 
    	 btnJD.setOnClickListener(new OnClickListener(){
            	@Override
            	public void onClick(View v){                     
                          Intent intent = new Intent(SecondActivity.this, TextSwitcherTest.class);             
                          startActivity(intent);                      
            		}          		
            	}
            );	
    	 
}}
