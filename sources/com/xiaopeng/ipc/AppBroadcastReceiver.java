package com.xiaopeng.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
/* loaded from: classes.dex */
public class AppBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        com.xiaopeng.a.a.a.b("AppBroadcastReceiver", "Action-->" + action);
        if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            a(context);
        }
    }

    private void a(Context context) {
        Intent intent = new Intent(context, IPCService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
