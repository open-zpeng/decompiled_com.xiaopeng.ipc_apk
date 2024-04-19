package com.xiaopeng.ipc;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.s;
import com.xiaopeng.ipc.a;
/* loaded from: classes.dex */
public class IPCService extends Service {
    private com.xiaopeng.ipc.b.a a;
    private a.AbstractBinderC0037a b = new a.AbstractBinderC0037a() { // from class: com.xiaopeng.ipc.IPCService.1
        @Override // com.xiaopeng.ipc.a
        public void a(String str, b bVar) throws RemoteException {
            com.xiaopeng.a.a.a.b("IPCService", "registerClient client-->" + bVar + "; appId-->" + str);
            IPCService.this.a.a(str, bVar);
        }

        @Override // com.xiaopeng.ipc.a
        public void b(String str, b bVar) throws RemoteException {
            com.xiaopeng.a.a.a.b("IPCService", "unregisterClient client-->" + bVar + "; appId-->" + str);
            IPCService.this.a.b(str, bVar);
        }

        @Override // com.xiaopeng.ipc.a
        public void a(String str, IpcMessage ipcMessage) throws RemoteException {
            com.xiaopeng.a.a.a.b("IPCService", "data message-->" + ipcMessage + "; appId-->" + str);
            IPCService.this.a.a(str, ipcMessage);
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        com.xiaopeng.a.a.a.b("IPCService", "onCreate");
        super.onCreate();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        com.xiaopeng.a.a.a.b("IPCService", "onStartCommand");
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.xiaopeng.a.a.a.b("IPCService", "onBind");
        return this.b;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        com.xiaopeng.a.a.a.b("IPCService", "onRebind");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.xiaopeng.a.a.a.b("IPCService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.xiaopeng.a.a.a.b("IPCService", "onDestroy");
        super.onDestroy();
    }

    private void a() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("XPENG", "IPC", 3);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).createNotificationChannel(notificationChannel);
        startForeground(100, new s.b(this, notificationChannel.getId()).a((CharSequence) "Xmart").b("IPC application is running").a(3).a("service").b());
    }

    private void b() {
        this.a = new com.xiaopeng.ipc.b.b();
        a();
    }
}
