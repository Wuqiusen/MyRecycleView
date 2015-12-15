#MYRECYCLEVIEW
##方向设置：
###layout
    <LinearLayout
             android:id="@+id/content_layout"
             android:layout_width="wrap_content"
             android:layout_height="match_parent"
             android:orientation="horizontal"垂直方向
             android:rotation="180">
             <android.support.v7.widget.RecyclerView
                 android:id="@+id/id_recyclerview_horizontal"
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:layout_centerVertical="true"
                 android:scrollbars="none"
                 android:background="#ff158844"

                 />


###MainActivity
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置方向
        mRecyclerView.setLayoutManager(linearLayoutManager);