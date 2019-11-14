package com.example.class7_android_asynctask;

import java.io.UnsupportedEncodingException;

import com.example.models.User;
import com.example.utils.HttpUtils;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;
public class SingleModelActivity extends Activity {
     TextView mTxtNickname;
     TextView mTxtGender;
     TextView mTxtLine;
     TextView txt_area;
     TextView txt_sign;
     TextView txt_weixinId;
     ImageView img_avatar;
     User userG;
     Gson gson = new Gson();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_model);
		txt_weixinId = (TextView) findViewById(R.id.txt_weixinId);
		mTxtNickname = (TextView) findViewById(R.id.txt_nickname);
		mTxtGender = (TextView) findViewById(R.id.txt_gender);
		txt_sign = (TextView) findViewById(R.id.txt_sign);
		img_avatar =(ImageView) findViewById(R.id.img_avatar);
		
		LoadJSONTask task = new LoadJSONTask();
		task.execute("http://139.129.212.78/examples/exam1.json");
	}
	
	
	

	public class LoadJSONTask extends AsyncTask<String,Integer, String>{

	 
        @Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			byte[] result = HttpUtils.httpConnGet(params[0]);
			String  json  = null;
			if(result != null){
				try {
					json = new String(result,"GBK");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			User user = gson.fromJson(json, User.class);
			byte a[]=HttpUtils.httpConnGet(user.getAvatar());
			userG.setBmp(BitmapFactory.decodeByteArray(a,0,a.length));
			return json;
		}
		
		@Override
		protected void onPostExecute(String json) {
			// TODO Auto-generated method stub
			super.onPostExecute(json);
			if(json!=null){
				
				User user = new User();
				txt_weixinId.setText("微信号："+user.getWeixinId()+"\n");
				mTxtNickname.setText("昵称："+user.getNickname()+"\n");
				if(user.getGender()==1){
					mTxtGender.setText("性别：男"+"\n");
				}else{
					mTxtGender.setText("性别：女"+"\n");
				}
				img_avatar.setImageBitmap(userG.getBmp());
				txt_sign.setText("签名："+user.getSignature());
				
			}
		 
		}
		
		
	}


}
