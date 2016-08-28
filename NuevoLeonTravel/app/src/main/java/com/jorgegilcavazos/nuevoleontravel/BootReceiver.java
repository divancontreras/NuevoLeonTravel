package com.jorgegilcavazos.nuevoleontravel;

import android.app.job.JobInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BootReceiver", "started");
        Intent myIntent = new Intent(context, LocationJobService.class);
        context.startService(myIntent);
    }
}
