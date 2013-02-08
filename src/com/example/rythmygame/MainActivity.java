package com.example.rythmygame;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Integer cpt1, cpt2, cpt3, cpt4;
	private TextView tvCpt1, tvCpt2, tvCpt3, tvCpt4, tvInfo;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvCpt1 = (TextView) findViewById(R.id.tvCpt1);
		tvInfo = (TextView) findViewById(R.id.tvInfo);
		
		cpt1 = 5; cpt2 = 0; cpt3 = 0; cpt4 = 0;
		mHandler = new Handler();
		mHandler.postDelayed(updateCompteur1, 1000);
		
	}
	
	private Runnable updateCompteur1 = new Runnable(){
		public void run(){
			cpt1--;
			
			if(cpt1 < -2){
				tvInfo.setText("Raté !!!");
			} else {
				if(cpt1 >= 0){tvCpt1.setText(String.valueOf(cpt1));}
				mHandler.postDelayed(this, 1000);
			}
		}
		
		
	};
	
	public void onClickButton1(View view){
		if(cpt1 <= 0 && cpt1 >= -2){
			cpt1 = 5;
			tvCpt1.setText(String.valueOf(cpt1));
			updateCompteur1.run();
		} else {
			tvInfo.setText("Raté !!!");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
