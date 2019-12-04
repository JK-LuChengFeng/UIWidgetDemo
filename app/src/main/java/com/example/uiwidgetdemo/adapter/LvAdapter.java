package com.example.uiwidgetdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uiwidgetdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/3 aa:04
 */
public class LvAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;
    private LayoutInflater inflater;

    public LvAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){

            convertView = (View) inflater.inflate(R.layout.item_text,parent,false);
            holder = new ViewHolder();
            holder.tv_item = convertView.findViewById(R.id.item_tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_item.setText(data.get(position));

        return convertView;
    }


    class ViewHolder{
        private TextView tv_item;
    }

}
