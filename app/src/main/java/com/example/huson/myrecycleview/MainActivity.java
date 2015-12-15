package com.example.huson.myrecycleview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private SlidingDrawer mSlidingDrawer;
    private ImageView iv_hot_tag;
    private String str = "myRecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置方向
        mRecyclerView.setLayoutManager(linearLayoutManager);


        mSlidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        iv_hot_tag = (ImageView) findViewById(R.id.iv_hot_tag);
        mSlidingDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            public void onScrollStarted() {
            }

            public void onScrollEnded() {

            }

        });

        mSlidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            public void onDrawerOpened() {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                iv_hot_tag.setImageDrawable(getResources().getDrawable(R.mipmap.img_close_station));
            }

        });
        mSlidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            public void onDrawerClosed() {
                iv_hot_tag.setImageDrawable(getResources().getDrawable(R.mipmap.img_open_station));
            }
        });
        getData();

    }

    private void getData() {
        List<String> str1 = new ArrayList<String>();
        for (int i= 0; i<20; i++){
            str1.add(str + i);
        }
        MyStationListAdapter myStationListAdapter = new MyStationListAdapter(this, str1);
        mRecyclerView.setAdapter(myStationListAdapter);
        myStationListAdapter.setOnItemClickListener(new MyStationListAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String str1, int poi) {
                Toast.makeText(MainActivity.this, "我是" + str + poi + "点我干嘛？", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
