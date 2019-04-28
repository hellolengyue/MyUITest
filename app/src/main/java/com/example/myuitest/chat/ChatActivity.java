package com.example.myuitest.chat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myuitest.R;
import com.example.myuitest.chat.frame.ContentModel;
import com.example.myuitest.chat.msgtype.SimpleImage;
import com.example.myuitest.chat.msgtype.SimpleImageViewBinder;
import com.example.myuitest.chat.msgtype.SimpleText;
import com.example.myuitest.chat.msgtype.SimpleTextViewBinder;
import com.example.myuitest.chat.msgtype.TimeBinder;
import com.example.myuitest.chat.msgtype.TimeSimple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.drakeet.multitype.Linker;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;
import static me.drakeet.multitype.MultiTypeAsserts.assertHasTheSameAdapter;

public class ChatActivity extends Activity {
    private static final String PATH1 = "http://img0.pconline.com.cn/pconline/1511/29/7257120_901_thumb.jpg";
    private static final String PATH2 = "http://img2.imgtn.bdimg.com/it/u=1122649470,955539824&fm=26&gp=0.jpg";
    private RecyclerView recyclerView;
    private EditText input;
    private Button send, receive;
    private List<ContentModel> items;
    private User other;
    private User yourself;
    private MultiTypeAdapter adapter;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.recyclerview);
        input = findViewById(R.id.input);
        send = findViewById(R.id.send);
        receive = findViewById(R.id.receive);

        adapter = new MultiTypeAdapter();
        //一对多，都有相同的父框架结构（头像、昵称、时间……等）
        adapter.register(ContentModel.class).to(
                new SimpleTextViewBinder(ContentModel.SEND_TYPE_OTHERS),//左边的布局（别人发的消息）
                new SimpleTextViewBinder(ContentModel.SEND_TYPE_YOURSELF),//右边的布局（自己发的消息）
                new SimpleImageViewBinder(ContentModel.SEND_TYPE_OTHERS),
                new SimpleImageViewBinder(ContentModel.SEND_TYPE_YOURSELF)
        ).withLinker(new Linker<ContentModel>() {
            @Override
            public int index(int position, @NonNull ContentModel model) {
                if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_TEXT && model.sendType == ContentModel.SEND_TYPE_OTHERS)
                    return 0;//左边的布局（别人发的消息）
                else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_TEXT && model.sendType == ContentModel.SEND_TYPE_YOURSELF)
                    return 1;//右边的布局（自己发的消息）
                else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_IMAGE && model.sendType == ContentModel.SEND_TYPE_OTHERS)
                    return 2;
                else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_IMAGE && model.sendType == ContentModel.SEND_TYPE_YOURSELF)
                    return 3;
                return 0;
            }
        });
        adapter.register(TimeSimple.class, new TimeBinder());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//new GridLayoutManager(this,2)
        recyclerView.setAdapter(adapter);
        assertHasTheSameAdapter(recyclerView, adapter);//断言 recyclerView 使用的是正确的 adapter，可选择性使用

        other = new User("other", PATH1);
        yourself = new User("包青天", PATH2);
        items = new ArrayList<>();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                if (lastTime == 0 || currentTime - lastTime > 5000){
                    //插入时间数据
                    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm");
                    String time = format.format(new Date(currentTime));
                    items.add(new TimeSimple(time));
                    lastTime = currentTime;
                }
                String text = input.getText().toString();
                if (text.equals("1")){
                items.add(new SimpleImage(yourself, ContentModel.SEND_TYPE_YOURSELF, PATH1));

                }else{
                items.add(new SimpleText(yourself, ContentModel.SEND_TYPE_YOURSELF, text));

                }
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
                assertAllRegistered(adapter, items);//断言所有使用的类型都已注册，需要在加载或更新数据之后调用，可选择性使用
                recyclerView.scrollToPosition(items.size() - 1);
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                if (lastTime == 0 || currentTime - lastTime > 5000){
                    //插入时间数据
                    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm");
                    String time = format.format(new Date(currentTime));
                    items.add(new TimeSimple(time));
                    lastTime = currentTime;
                }
                String text = input.getText().toString();
                if (text.equals("1")){
                    items.add(new SimpleImage(other, ContentModel.SEND_TYPE_OTHERS, PATH2));

                }else{
                    items.add(new SimpleText(other, ContentModel.SEND_TYPE_OTHERS, text));

                }

                adapter.setItems(items);
                adapter.notifyDataSetChanged();
                assertAllRegistered(adapter, items);//断言所有使用的类型都已注册，需要在加载或更新数据之后调用，可选择性使用
                recyclerView.scrollToPosition(items.size() - 1);
            }
        });

    }
}