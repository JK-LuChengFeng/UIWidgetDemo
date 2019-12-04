package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.uiwidgetdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By JK_Liu on 2019/12/03
 */
public class GridViewActivity extends AppCompatActivity {

    private GridView gv;

    private List<Map<String,Object>> data;
    private SimpleAdapter adapter;
    // 图片封装为一个数组
    private int[] icon = { R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher };
    //图片下的描述为一个数组
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置", "语音", "天气", "浏览器", "视频" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        initData();
        initView();

        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.item_gv_img,R.id.item_gv_tv};
        adapter = new SimpleAdapter(this, data, R.layout.item_gv, from, to);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"你点击了-->" + data.get(position).get("text"),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {

        data = new ArrayList<>();
        for (int i = 0; i < icon.length ; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            data.add(map);
        }
    }

    private void initView() {
        gv = findViewById(R.id.gv);
    }
}
