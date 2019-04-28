package com.example.myuitest.chat.msgtype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myuitest.R;
import com.example.myuitest.chat.frame.ChatFrameBinder;
import com.example.myuitest.chat.frame.ContentHolder;
import com.example.myuitest.chat.frame.ContentModel;

public class SimpleImageViewBinder extends ChatFrameBinder<SimpleImage, SimpleImageViewBinder.ViewHolder> {

	public SimpleImageViewBinder(int sendType) {
		super(sendType);
	}

	@Override
	protected ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
		View root;
		if (sendType == ContentModel.SEND_TYPE_OTHERS) root = inflater.inflate(R.layout.item_simple_image_left, parent, false);
		else root = inflater.inflate(R.layout.item_simple_image_right, parent, false);
		return new ViewHolder(root);
	}

	@Override
	protected void onBindContentViewHolder(ViewHolder holder, SimpleImage simpleImage) {
		Glide.with(holder.simpleImage.getContext()).load(simpleImage.imagePath).into(holder.simpleImage);
	}

	static class ViewHolder extends ContentHolder {

		private ImageView simpleImage;

		ViewHolder(View itemView) {
			super(itemView);
			simpleImage = (ImageView) itemView.findViewById(R.id.simple_image);
		}
	}
}