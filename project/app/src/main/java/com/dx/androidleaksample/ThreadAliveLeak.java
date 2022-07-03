package com.dx.androidleaksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadAliveLeak extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(mRunnable, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_alive_leak);
        mHandler.postDelayed(mRunnable, 2000);
    }

    private class MyThread extends Thread {

        @Override

        public void run() {
            super.run();


        }

    }

    /**
     * solution
     * */
    private static class MyHandler extends Handler{
        private WeakReference<ThreadAliveLeak> aliveLeakWeakReference;
        public MyHandler(ThreadAliveLeak activity){
            aliveLeakWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            ThreadAliveLeak activity = aliveLeakWeakReference.get();
            if(activity != null){
                //do something
            }
        }
    }

}