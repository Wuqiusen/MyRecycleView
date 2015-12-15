package com.example.huson.myrecycleview;

/**
 * Created by huson on 2015/9/10.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

public class MyStationListAdapter extends
        RecyclerView.Adapter<MyStationListAdapter.ViewHolder> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private List<String> str;
    private LinearLayout.LayoutParams rl_line_params;
    private ViewHolder viewHolder;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public MyStationListAdapter(Context context, List<String> str1)
    {
        mInflater = LayoutInflater.from(context);
        str = str1;

    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (String)v.getTag(), v.getId());
        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        TextView mTxt;
        ImageView mImg;
        LinearLayout rl_line;
    }

    @Override
    public int getItemCount()
    {

        return str.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.item_recycleview,
                viewGroup, false);
        viewHolder = new ViewHolder(view);
        viewHolder.rl_line = (LinearLayout) view
                .findViewById(R.id.rl_line_detail);
        viewHolder.mTxt = (TextView) view
                .findViewById(R.id.id_index_gallery_item_text);
        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.id_index_gallery_item_image);
        view.setOnClickListener(this);//注册监听事件
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i)
    {
        rl_line_params = (LinearLayout.LayoutParams) viewHolder.rl_line.getLayoutParams();

        viewHolder.mTxt.setText(str.get(i).toString());

        viewHolder.itemView.setId(i);//保存tag，点击时获取



    }
    //定义点击接口
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String str1, int poi);
    }

}
