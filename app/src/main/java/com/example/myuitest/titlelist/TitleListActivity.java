package com.example.myuitest.titlelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myuitest.R;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class TitleListActivity extends AppCompatActivity {
    private static final String PATH1 = "http://img0.pconline.com.cn/pconline/1511/29/7257120_901_thumb.jpg";
    private static final String PATH2 = "http://img2.imgtn.bdimg.com/it/u=1122649470,955539824&fm=26&gp=0.jpg";
    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private Items items;
    private List<CountryDetailBean.ResultBean> mGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_list);
        recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);//10=1*5*2
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                if (items.get(position) instanceof Parent) {
                    return 3 / 1;//一行占1个
                }
                if (items.get(position) instanceof Child) {
                    return 3 / 3;//一行占3个
                }
                return 3;//默认一行占1个
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MultiTypeAdapter();
        ParentViewBinder parentViewBinder = new ParentViewBinder();
        ChildViewBinder childViewBinder = new ChildViewBinder();
        adapter.register(Parent.class, parentViewBinder);
        adapter.register(Child.class, childViewBinder);
        recyclerView.setAdapter(adapter);
        parentViewBinder.setOnClickListener(new ParentViewBinder.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(TitleListActivity.this, "parentViewBinder:" + position + ((Parent)items.get(position)).name, Toast.LENGTH_SHORT).show();
            }
        });
        childViewBinder.setOnClickListener(new ChildViewBinder.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(TitleListActivity.this, "childViewBinder:" + position + ((Child)items.get(position)).name, Toast.LENGTH_SHORT).show();
            }
        });
        initData();

    }

    private void initData() {
        mGroups = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<CountryDetailBean.ResultBean.AnchorListBean> listBeans = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                listBeans.add(new CountryDetailBean.ResultBean.AnchorListBean(PATH2, "content" + i+j));
            }
            mGroups.add(new CountryDetailBean.ResultBean(PATH1, "title" + i, i, listBeans));
        }
        items = new Items();
        for (int i = 0; i < mGroups.size(); i++) {
            items.add(new Parent(mGroups.get(i).getImg(), mGroups.get(i).getName()));
            for (int j = 0; j < mGroups.get(i).getAnchorList().size(); j++) {
                items.add(new Child(mGroups.get(i).getAnchorList().get(j).getImage(), mGroups.get(i).getAnchorList().get(j).getUsername()));
            }
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
