package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

import com.example.uiwidgetdemo.R;
import com.example.uiwidgetdemo.adapter.CommonAdapter;
import com.example.uiwidgetdemo.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By JK_Liu on 2019/12/03
 * ListView 使用通用的Adapter
 */
public class CommenAdapterListViewActivity extends AppCompatActivity {

    private ListView lv_commen;
    List<String> data = new ArrayList<>();
    private CommonAdapter<String> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commenadapter_listview);

        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            data.add("张三" + i);
            data.add("李四" + i);
            data.add("王五" + i);
            data.add("赵六" + i);
            data.add("丁七" + i);
        }
        commonAdapter.setDatas(data);
    }

    private void initView() {
        lv_commen = findViewById(R.id.lv_commen);
        commonAdapter = new CommonAdapter<String>(CommenAdapterListViewActivity.this,data,R.layout.item_text) {
            @Override
            public void convert(ViewHolder viewHolder, String bean, int position) {
                viewHolder.setText(R.id.item_tv,bean);
            }
        };
        lv_commen.setAdapter(commonAdapter);

        //设置listview 进入动画
        Animation translate = new TranslateAnimation(800,0,0,0);
        translate.setDuration(300);
        translate.setInterpolator(new DecelerateInterpolator());
        LayoutAnimationController lac = new LayoutAnimationController(translate);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lv_commen.setLayoutAnimation(lac);
        lv_commen.startLayoutAnimation();

        //设置listview 退出动画
        Animation translate2 = new TranslateAnimation(0,800,0,0);
        translate2.setDuration(300);
        translate2.setInterpolator(new DecelerateInterpolator());
        translate2.setFillAfter(true);
        LayoutAnimationController lac2 = new LayoutAnimationController(translate2);
        lac2.setOrder(LayoutAnimationController.ORDER_REVERSE);
        lv_commen.setLayoutAnimation(lac2);
        lv_commen.startLayoutAnimation();


    }
}
