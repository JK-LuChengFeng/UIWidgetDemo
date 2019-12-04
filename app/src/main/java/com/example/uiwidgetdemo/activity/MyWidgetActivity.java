package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uiwidgetdemo.R;

/**
 * Create By JK_Liu on 2019/12/02
 */
public class MyWidgetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_back,btn_edit;
    private TextView tv_title;
    private TextView tv_headview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywidget);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        initView();
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                //返回
                Toast.makeText(MyWidgetActivity.this,"你点击了返回",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_edit:
                //编辑
                Toast.makeText(MyWidgetActivity.this,"你点击了编辑",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
