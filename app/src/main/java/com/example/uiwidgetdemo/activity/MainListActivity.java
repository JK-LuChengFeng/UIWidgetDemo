package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uiwidgetdemo.R;

/**
 * Create By JK_Liu on 2019/12/03
 */
public class MainListActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_simplelistview,btn_commenadpter,btn_girdview,btn_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

        initView();

    }

    private void initView() {
        btn_simplelistview = findViewById(R.id.btn_simplelistview);
        btn_simplelistview.setOnClickListener(this);
        btn_commenadpter = findViewById(R.id.btn_commenadpter);
        btn_commenadpter.setOnClickListener(this);
        btn_girdview = findViewById(R.id.btn_girdview);
        btn_girdview.setOnClickListener(this);
        btn_recyclerview = findViewById(R.id.btn_recyclerview);
        btn_recyclerview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_simplelistview:
                intent.setClass(MainListActivity.this,ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_commenadpter:
                intent.setClass(MainListActivity.this,CommenAdapterListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_girdview:
                intent.setClass(MainListActivity.this,GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recyclerview:
                intent.setClass(MainListActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
