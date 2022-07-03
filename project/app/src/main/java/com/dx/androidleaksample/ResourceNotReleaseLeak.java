package com.dx.androidleaksample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ResourceNotReleaseLeak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_not_release_leak);
    }
}