package com.example.myuitest.chat.msgtype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myuitest.R;

import me.drakeet.multitype.ItemViewBinder;

public class TimeBinder extends ItemViewBinder<TimeSimple, TimeBinder.ViewHolder> {

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		return new ViewHolder(inflater.inflate(R.layout.item_time,parent,false));
	}

	@Override
	protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull TimeSimple item) {
		holder.time.setText(item.time);
	}

	static class ViewHolder extends RecyclerView.ViewHolder {

		private TextView time;

		ViewHolder(View itemView) {
			super(itemView);
			time =  itemView.findViewById(R.id.time);
		}
	}
}