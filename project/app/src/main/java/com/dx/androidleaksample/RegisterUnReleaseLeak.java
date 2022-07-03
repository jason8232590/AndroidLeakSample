package com.dx.androidleaksample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterUnReleaseLeak extends AppCompatActivity {
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_un_release_leak);
        TestUtils.getInstance().setTestRegisterItf(new TestRegisterItf() {
            @Override
            public void doSomething() {
                System.out.println("xcqw start do something");
                count = 3;
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("xcqw real do something");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("xcqw end real do something");
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                System.out.println("xcqw end do something");

            }
        });
        findViewById(R.id.btDoSomething).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TestUtils.getInstance().getTestRegisterItf() != null) {
                    try {
                        TestUtils.getInstance().getTestRegisterItf().doSomething();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}