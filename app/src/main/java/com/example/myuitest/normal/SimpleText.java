package com.example.myuitest.normal;

public class SimpleText extends ContentModel {
	public String text;

	public SimpleText(String text) {
		super(ContentModel.TYPE_SIMPLE_TEXT);
		this.text = text;
	}
}