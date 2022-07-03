package com.dx.androidleaksample;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class StaticFieldLeak extends AppCompatActivity {
    public static Context leakContext;
    public static Context leakContextTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_field_leak);
        leakContext = this;
        leakContextTwo = this;
    }
}