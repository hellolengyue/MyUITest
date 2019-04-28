package com.example.myuitest.normal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myuitest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.drakeet.multitype.MultiTypeAdapter;

public class NormalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RecyclerView recyclerView = new RecyclerView(this);

		/**
		 * 3、在 Activity 中加入 RecyclerView 和 List 并注册你的类型
		 */
		MultiTypeAdapter adapter = new MultiTypeAdapter();
		adapter.register(SimpleImage.class, new SimpleImageViewBinder());
		adapter.register(SimpleText.class, new SimpleTextViewBinder());
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		List<ContentModel> items = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			if (i%2==0){
				items.add(new SimpleImage(R.drawable.icon));
			}else{
				items.add(new SimpleText("不懂左右逢源，不喜趋炎附势，不会随波逐流"));
			}
		}
		adapter.setItems(items);
		adapter.notifyDataSetChanged();
		setContentView(recyclerView);
	}
}
