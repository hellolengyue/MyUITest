package com.example.myuitest.normal;

public class SimpleImage extends ContentModel {
	public int resId;

	public SimpleImage(int resId) {
		super(ContentModel.TYPE_SIMPLE_IMAGE);
		this.resId = resId;
	}
}