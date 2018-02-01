package com.lingsatuo.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lingsatuo.bmob.ObjectData;
import com.lingsatuo.bmob.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

public class PullListViewAdapter extends ArrayAdapter<ObjectData> {
    protected Context mContext;
    protected List<ObjectData> mDataList;
    protected boolean hasNoData;

    public PullListViewAdapter(Context context, List<ObjectData> objects) {
        super(context, 0, objects);
        this.mContext = context;
        this.mDataList = objects;
        if (this.mDataList == null || this.mDataList.isEmpty())
            hasNoData = true;
    }
    @Override
    public int getCount() {
        if (hasNoData)
            return 1;
        return (mDataList == null || mDataList.isEmpty()) ? 0 : mDataList.size();
    }

    @Override
    public ObjectData getItem(int position) {
        if (hasNoData)
            return null;
        return mDataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (hasNoData)
            return 0;
        return 1;
    }
    public void updateListView(List<ObjectData> dataList) {
        this.mDataList = dataList;
        hasNoData = (this.mDataList == null || this.mDataList.isEmpty());
        notifyDataSetChanged();
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
}