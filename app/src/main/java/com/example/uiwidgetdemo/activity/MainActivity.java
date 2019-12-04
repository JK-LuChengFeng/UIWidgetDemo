package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uiwidgetdemo.R;

/**
 * Create By JK_Liu on 2019/aa/27
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_widget,btn_layout,btn_widget2,btn_widget3,btn_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        btn_widget = findViewById(R.id.btn_widget);
        btn_widget.setOnClickListener(this);
        btn_layout = findViewById(R.id.btn_layout);
        btn_layout.setOnClickListener(this);
        btn_widget2 = findViewById(R.id.btn_widget2);
        btn_widget2.setOnClickListener(this);
        btn_widget3 = findViewById(R.id.btn_widget3);
        btn_widget3.setOnClickListener(this);
        btn_listview = findViewById(R.id.btn_listview);
        btn_listview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_widget:
                intent.setClass(MainActivity.this,WidgetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_layout:
                intent.setClass(MainActivity.this,LayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_widget2:
                intent.setClass(MainActivity.this,MyWidgetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_widget3:
                intent.setClass(MainActivity.this,MyWidget2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_listview:
                intent.setClass(MainActivity.this,MainListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
