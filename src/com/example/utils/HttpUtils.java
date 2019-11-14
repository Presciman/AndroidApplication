package com.example.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

	
	
	public static byte[] httpConnGet(String uri){
		 try {
				URL url = new URL(uri);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
				// conn.addRequestProperty("flag", "exam");
				conn.setDoInput(true);
				// conn.setDoOutput(true);
				// OutputStream outStream = conn.getOutputStream();
				// outStream.write("name=lee".getBytes());
				InputStream in = conn.getInputStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream(); 
				byte[] buffer = new byte[1024];
				    while(true){
				    	int len = in.read(buffer);
				    	if(len == -1) break;
				    	out.write(buffer,0,len);
				    }
				    byte[] result = out.toByteArray();
				    return result;
				    //String txt = new String(result,"UTF-8");
				   // System.out.println(txt);
		      } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	}
	

}
