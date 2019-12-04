package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.uiwidgetdemo.R;
import com.example.uiwidgetdemo.adapter.LvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By JK_Liu on 2019/12/03
 * ListView的简单使用
 */
public class ListViewActivity extends BaseActivity {

    private ListView lv;
    private List<String> data = new ArrayList<>();
    private LvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        initData();
        initView();

    }

    private void initData() {

        for (int i = 0; i < 20; i++) {
            data.add("张三" + i);
            data.add("李四" + i);
            data.add("王五" + i);
            data.add("赵六" + i);
            data.add("丁七" + i);
        }

    }

    private void initView() {
        lv = findViewById(R.id.lv);
        adapter = new LvAdapter(data,ListViewActivity.this);
        lv.setAdapter(adapter);
    }

}
