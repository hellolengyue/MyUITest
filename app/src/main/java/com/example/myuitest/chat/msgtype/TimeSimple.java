package com.example.myuitest.chat.msgtype;


import com.example.myuitest.chat.frame.ContentModel;

public class TimeSimple extends ContentModel {

	public String time;

	public TimeSimple(String time) {
		super(null,0,0);
		this.time = time;
	}
}