package com.example.myuitest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myuitest.chat.ChatActivity;
import com.example.myuitest.normal.NormalActivity;
import com.example.myuitest.titlelist.TitleListActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ListActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] array = {
                "NormalActivity",
                "ChatActivity",
                "ConcurrentLinkedQueue使用",
                "titleList"};
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(array))));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, NormalActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ChatActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, QueueActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, TitleListActivity.class));
                break;
        }
    }
}