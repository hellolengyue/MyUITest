package com.example.myuitest.chat.msgtype;


import com.example.myuitest.chat.User;
import com.example.myuitest.chat.frame.ContentModel;

public class SimpleText extends ContentModel {
	public String text;

	public SimpleText(User user, int sendType, String text) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_TEXT, sendType);
		this.text = text;
	}
}