package com.xiaopeng.ipc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.UserHandle;
import com.xiaopeng.ipc.c;
/* loaded from: classes.dex */
public class App extends Application {
    private static App a;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a = this;
        c.a(new c.a(this).a(new d() { // from class: com.xiaopeng.ipc.App.1
            @Override // com.xiaopeng.ipc.d
            public ComponentName a(Intent intent) {
                return Build.VERSION.SDK_INT >= 26 ? App.a.startForegroundServiceAsUser(intent, UserHandle.CURRENT) : App.a.startServiceAsUser(intent, UserHandle.CURRENT);
            }
        }).a());
        com.xiaopeng.a.a.a.a(true);
    }
}
