package com.example.myuitest.chat.msgtype;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myuitest.R;
import com.example.myuitest.chat.frame.ChatFrameBinder;
import com.example.myuitest.chat.frame.ContentHolder;
import com.example.myuitest.chat.frame.ContentModel;

public class SimpleTextViewBinder extends ChatFrameBinder<SimpleText, SimpleTextViewBinder.ViewHolder> {

	public SimpleTextViewBinder(int sendType) {
		super(sendType);
	}

	@Override
	protected ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
		View root;
		Log.e("hel", "onCreateContentViewHolder: "+sendType );
		if (sendType == ContentModel.SEND_TYPE_OTHERS) root = inflater.inflate(R.layout.item_simple_text_left, parent, false);
		else root = inflater.inflate(R.layout.item_simple_text_right, parent, false);
		return new ViewHolder(root);
	}

	@Override
	protected void onBindContentViewHolder(ViewHolder holder, SimpleText simpleText) {
		holder.simpleText.setText(simpleText.text);
	}

	static class ViewHolder extends ContentHolder {

		private TextView simpleText;

		ViewHolder(View itemView) {
			super(itemView);
			simpleText = (TextView) itemView.findViewById(R.id.simple_text);
		}
	}
}