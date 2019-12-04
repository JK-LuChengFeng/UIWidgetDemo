package com.example.uiwidgetdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JK_Liu
 * @description: 封装通用的ListViewAdapter
 * @date :2019/12/3 13:46
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    public CommonAdapter(Context mContext, List<T> mDatas, int layoutId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return this.mDatas != null?this.mDatas.size():0;
    }

    public T getItem(int position) {
        return this.mDatas.get(position);
    }

    public long getItemId(int position) {
        return (long)position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(this.mContext, convertView, this.layoutId, parent, position);
        this.convert(holder, this.getItem(position), position);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, T bean, int position);

    public void setDatas(List<T> list) {
        if(this.mDatas != null) {
            if(null != list) {
                List<T> temp = new ArrayList();
                temp.addAll(list);
                this.mDatas.clear();
                this.mDatas.addAll(temp);
            } else {
                this.mDatas.clear();
            }
        } else {
            this.mDatas = list;
        }

        this.notifyDataSetChanged();
    }

    public void remove(int i) {
        if(null != this.mDatas && this.mDatas.size() > i && i > -1) {
            this.mDatas.remove(i);
            this.notifyDataSetChanged();
        }

    }

    public void addDatas(List<T> list) {
        if(null != list) {
            List<T> temp = new ArrayList();
            temp.addAll(list);
            if(this.mDatas != null) {
                this.mDatas.addAll(temp);
            } else {
                this.mDatas = temp;
            }

            this.notifyDataSetChanged();
        }

    }

    public List<T> getDatas() {
        return this.mDatas;
    }

}
