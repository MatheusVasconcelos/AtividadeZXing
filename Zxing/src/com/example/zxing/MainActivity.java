package com.example.zxing;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final int REQUEST_CODE = 0;
	private TextView txResult;
	
	@Bind(R.id.txResult)
	TextView mTxtResult;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  ButterKnife.bind(this);
	}
	
	
	public void callZXing(View view){
		Intent it = new Intent(MainActivity.this, com.google.zxing.client.android.CaptureActivity.class);
		startActivityForResult(it, REQUEST_CODE);
	}
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(REQUEST_CODE == requestCode && RESULT_OK == resultCode){
			txResult.setText("RESULTADO: "+data.getStringExtra("SCAN_RESULT")+" ("+data.getStringExtra("SCAN_FORMAT")+")");
		}
	}
}
