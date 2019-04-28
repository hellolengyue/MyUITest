package com.example.myuitest.chat.msgtype;


import com.example.myuitest.chat.User;
import com.example.myuitest.chat.frame.ContentModel;

public class SimpleImage extends ContentModel {

	public String imagePath;

	public SimpleImage(User user, int sendType, String imagePath) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_IMAGE, sendType);
		this.imagePath = imagePath;
	}
}