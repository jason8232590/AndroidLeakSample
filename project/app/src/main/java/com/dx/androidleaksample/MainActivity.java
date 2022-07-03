package com.dx.androidleaksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * 1.handler,没有运行完成thread
 * 2.静态变量
 * 3.资源未释放
 * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvFirst = findViewById(R.id.tvOne);
        TextView tvSecond = findViewById(R.id.tvTwo);
        TextView tvThird = findViewById(R.id.tvThree);
        TextView tvFourth = findViewById(R.id.tvFourth);
        tvFirst.setOnClickListener(this);
        tvSecond.setOnClickListener(this);
        tvThird.setOnClickListener(this);
        tvFourth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tvOne:
                startActivity(intent.setClass(this, StaticFieldLeak.class));
                break;
            case R.id.tvTwo:
                startActivity(intent.setClass(this, ThreadAliveLeak.class));
                break;
            case R.id.tvThree:
                startActivity(intent.setClass(this, RegisterUnReleaseLeak.class));
                break;
            case R.id.tvFourth:
                break;
        }
    }
}