package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.uiwidgetdemo.R;
import com.example.uiwidgetdemo.adapter.RvAdapter;
import com.example.uiwidgetdemo.adapter.RvAdapter2;
import com.example.uiwidgetdemo.bean.FruitBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create By JK_Liu on 2019/12/03
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RvAdapter adapter;
    private RvAdapter2 adapter2;
    private List<String> data = new ArrayList<>();
    private List<FruitBean> data2 = new ArrayList<>();

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

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

        for (int i = 0; i < 20; i++) {

            FruitBean fruitBean = new FruitBean(getRandomName("Apple"),R.drawable.aa);
            data2.add(fruitBean);
            FruitBean fruitBean2 = new FruitBean(getRandomName("Mango"),R.drawable.bb);
            data2.add(fruitBean2);
            FruitBean fruitBean3 = new FruitBean(getRandomName("Banana"),R.drawable.cc);
            data2.add(fruitBean3);
            FruitBean fruitBean4 = new FruitBean(getRandomName("Orange"),R.drawable.dd);
            data2.add(fruitBean4);
            FruitBean fruitBean5 = new FruitBean(getRandomName("Pear"),R.drawable.ee);
            data2.add(fruitBean5);

        }

    }

    private void initView() {
        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
//        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
//        rv.setLayoutManager(layoutManager);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        layoutManager2 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        rv.setLayoutManager(layoutManager2);
        adapter = new RvAdapter(data);
        adapter2 = new RvAdapter2(data2);
        rv.setAdapter(adapter2);
    }

    private String getRandomName(String name) {
        Random random = new Random();
        int nameLength = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nameLength ; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
