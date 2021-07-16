package com.vaibhavmojidra.workmanagerperiodicrequestjava;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWorker extends Worker {

    public MyWorker(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Result doWork() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
        String time=simpleDateFormat.format(new Date());
        Log.i("MyTag","Time: "+time);
        return Result.success();
    }
}
