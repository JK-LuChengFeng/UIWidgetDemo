package com.example.uiwidgetdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiwidgetdemo.R;
import com.example.uiwidgetdemo.bean.FruitBean;

import java.util.List;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/4 9:54
 */
public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.ViewHolder> {

    private List<FruitBean> data;

    public RvAdapter2(List<FruitBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imgtext,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FruitBean fruitBean = data.get(position);
        holder.iv.setImageResource(fruitBean.getImgId());
        holder.tv.setText(fruitBean.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_itemimg);
            tv = itemView.findViewById(R.id.tv_itemtext);
        }
    }


}
