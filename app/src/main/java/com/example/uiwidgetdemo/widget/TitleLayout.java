package com.example.uiwidgetdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uiwidgetdemo.R;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/2 15:57
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener {

    private Button btn_back, btn_edit;
    private TextView tv_title;

    private TitleBackListener titleBackListener;
    private TitleEditListener titleEditListener;


    public TitleLayout(Context context) {
        this(context, null);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mytitle, this);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);
        tv_title = findViewById(R.id.tv_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                //返回
                titleBackListener.Back();
                break;
            case R.id.btn_edit:
                //编辑
                titleEditListener.Edit();
                break;
            default:
                break;
        }
    }

    //返回
    public interface TitleBackListener {
        void Back();
    }

    //编辑
    public interface TitleEditListener {
        void Edit();
    }

    public void setTitleContent(String title){
        tv_title.setText(title);
    }

    public void setOnBackListener(TitleBackListener titleBackListener){
        this.titleBackListener = titleBackListener;
    }

    public void setOnEditListener(TitleEditListener titleEditListener){
        this.titleEditListener = titleEditListener;
    }
}
