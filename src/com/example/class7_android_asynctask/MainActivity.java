package com.example.class7_android_asynctask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.utils.HttpUtils;

public class MainActivity extends Activity {
    Button mBtn;
    ImageView mImageView;
    
	
	private Button my_button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 my_button = (Button)findViewById(R.id.my_button);
		 my_button.setText( "Next" );    
		 my_button.setOnClickListener(new MyButtonListener());
		    
		    

		
		
		mBtn = (Button) findViewById(R.id.btn);
		mImageView = (ImageView) findViewById(R.id.image);
		mBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoadXmlTask task = new LoadXmlTask();
				String url = "http://139.129.212.78/examples/exam1.xml";
                task.execute(url);
				
			}
		});
	}

  
	class MyButtonListener implements OnClickListener{
		 @Override
		public void onClick(View v) {
		     // TODO Auto-generated method stub
		     Intent intent = new Intent(); 
		     intent.setClass(MainActivity.this, SingleModelActivity.class);
		     MainActivity.this.startActivity(intent);
		 }  
		    }
	
	
	public class LoadXmlTask extends AsyncTask<String,Integer, Bitmap>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mBtn.setText("øΩ±¥Õº∆¨÷–....");
			mBtn.setEnabled(false);
		}
        @Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			byte[] result = HttpUtils.httpConnGet(params[0]);
			Bitmap bmp = null;
			if(result != null){
				bmp = BitmapFactory.decodeByteArray(result, 0, result.length);
			}
			return bmp;
		}
		
		@Override
		protected void onPostExecute(Bitmap bmp) {
			// TODO Auto-generated method stub
			super.onPostExecute(bmp);
			if(bmp!=null){
				mImageView.setImageBitmap(bmp);
			}
			mBtn.setText("œ¬‘ÿÕº∆¨");
			mBtn.setEnabled(true);
		}
		
		
	}

	
	

}
