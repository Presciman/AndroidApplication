package com.example.models;

import android.graphics.Bitmap;

public class User {
	private String weixinId;
    public String getWeixinId() {
		return weixinId;
	}
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
	private String isShowTimeline;
	public String getIsShowTimeline() {
		return isShowTimeline;
	}
	public void setIsShowTimeline(String isShowTimeline) {
		this.isShowTimeline = isShowTimeline;
	}
	private String mobile;
	public String getMobile() {
		return mobile;
	}
	private Bitmap bmp;
	public void setBmp(Bitmap bmp){this.bmp = bmp;}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Bitmap getBmp(){
		return bmp;
	}
	private String avatar;
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
    private  String nickname;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	private int gender;
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	private String accountnumber;
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	private  String province;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	private  String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	 private  String signature;
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
 
    
}
