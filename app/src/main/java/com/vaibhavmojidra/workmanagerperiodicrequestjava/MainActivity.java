package com.vaibhavmojidra.workmanagerperiodicrequestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.vaibhavmojidra.workmanagerperiodicrequestjava.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.startWork.setOnClickListener(v->{
            startPeriodicWork();
        });
    }

    private void startPeriodicWork() {
        WorkManager workManager=WorkManager.getInstance(this);
        PeriodicWorkRequest workRequest=new PeriodicWorkRequest.Builder(MyWorker.class,15, TimeUnit.MINUTES).build();
        workManager.enqueue(workRequest);
    }
}