package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.uiwidgetdemo.R;
import com.example.uiwidgetdemo.widget.TitleLayout;

/**
 * Create By JK_Liu on 2019/12/02
 */
public class MyWidget2Activity extends AppCompatActivity {

    private TitleLayout titleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywidget2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        initView();
        initListenet();

    }

    private void initView() {
        titleLayout = findViewById(R.id.mytitlelayout);
        titleLayout.setTitleContent("这是个标题啊");
    }

    private void initListenet() {

        //返回
        titleLayout.setOnBackListener(new TitleLayout.TitleBackListener() {
            @Override
            public void Back() {
                MyWidget2Activity.this.finish();
            }
        });

        //编辑
        titleLayout.setOnEditListener(new TitleLayout.TitleEditListener() {
            @Override
            public void Edit() {
                Toast.makeText(MyWidget2Activity.this,"你点击了返回按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }




}
