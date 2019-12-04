package com.example.uiwidgetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.uiwidgetdemo.R;

/**
 * Create By JK_Liu on 2019/aa/27
 */
public class WidgetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_showornot,btn_proadd,btn_alert;
    private ProgressBar probar_circle,probar_horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        initView();

    }

    private void initView() {
        btn_proadd = findViewById(R.id.btn_proadd);
        btn_proadd.setOnClickListener(this);
        btn_showornot = findViewById(R.id.btn_showornot);
        btn_showornot.setOnClickListener(this);
        probar_circle = findViewById(R.id.probar_circle);
        probar_horizontal = findViewById(R.id.probar_horizontal);
        btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showornot:
                showOrNot();
                break;
            case R.id.btn_proadd:
                int prograss = probar_horizontal.getProgress();
                prograss += 10;
                probar_horizontal.setProgress(prograss);
                break;
            case R.id.btn_alert:
                showAlert();
                break;
            default:
                break;
        }
    }

    private void showOrNot() {
        if (probar_circle.getVisibility() == View.GONE){
            probar_circle.setVisibility(View.VISIBLE);
        }else {
            probar_circle.setVisibility(View.GONE);
        }
    }

    private void showAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(WidgetActivity.this);
        alertDialog.setTitle("This is AlertDialog");
        alertDialog.setMessage("msg tips");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WidgetActivity.this,"you click yes",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WidgetActivity.this,"you click no",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertDialog.show();


    }

}
