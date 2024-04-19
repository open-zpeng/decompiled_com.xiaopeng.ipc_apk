package com.xiaopeng.ipc.a;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaopeng.ipc.IpcMessage;
import com.xiaopeng.ipc.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: IPCModel.java */
/* loaded from: classes.dex */
public class b implements com.xiaopeng.ipc.a.a {
    private Map<String, com.xiaopeng.ipc.b> a = new ConcurrentHashMap();
    private List<HashMap<String, IpcMessage>> b = Collections.synchronizedList(new ArrayList());
    private ExecutorService c = Executors.newSingleThreadExecutor();
    private Handler d = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.ipc.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            super.handleMessage(message);
            if (message.what == 1 && (i = message.arg1) <= 5) {
                int i2 = i + 1;
                String str = (String) message.obj;
                if (TextUtils.isEmpty(str) || ((com.xiaopeng.ipc.b) b.this.a.get(str)) != null) {
                    return;
                }
                b.this.a(str);
                if (i2 <= 5) {
                    b.this.a(str, i2);
                }
            }
        }
    };

    @Override // com.xiaopeng.ipc.a.a
    public void a(String str, com.xiaopeng.ipc.b bVar) {
        if (TextUtils.isEmpty(str)) {
            com.xiaopeng.a.a.a.c("IPCModel", "IPC registerClient:appId can not be null!");
            return;
        }
        this.a.put(str, bVar);
        if (!this.b.isEmpty()) {
            this.c.execute(new a(str, bVar));
        }
        com.xiaopeng.a.a.a.b("IPCModel", "IPC registerClient:appId-->" + str + "; Now clientMap size-->" + this.a.size());
    }

    @Override // com.xiaopeng.ipc.a.a
    public void b(String str, com.xiaopeng.ipc.b bVar) {
        if (TextUtils.isEmpty(str)) {
            com.xiaopeng.a.a.a.c("IPCModel", "IPC unregisterClient:appId can not be null!");
        } else if (!this.a.containsKey(str)) {
            com.xiaopeng.a.a.a.c("IPCModel", "IPC unregisterClient:appId has not been registered!");
        } else {
            this.a.remove(str);
            com.xiaopeng.a.a.a.b("IPCModel", "IPC unregisterClient:appId-->" + str + "; Now clientMap size-->" + this.a.size());
        }
    }

    @Override // com.xiaopeng.ipc.a.a
    public void a(String str, IpcMessage ipcMessage) {
        if (TextUtils.isEmpty(str)) {
            com.xiaopeng.a.a.a.c("IPCModel", "IPC data:appId can not be null!");
        } else if (str.contains(";")) {
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                com.xiaopeng.a.a.a.b("IPCModel", "id = " + split[i]);
                a(split[i], ipcMessage, true);
            }
        } else {
            a(str, ipcMessage, true);
        }
    }

    private void a(String str, IpcMessage ipcMessage, boolean z) {
        boolean z2;
        if (!this.b.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= this.b.size()) {
                    z2 = false;
                    break;
                } else if (this.b.get(i).containsKey(str)) {
                    HashMap<String, IpcMessage> hashMap = new HashMap<>();
                    hashMap.put(str, ipcMessage);
                    com.xiaopeng.a.a.a.a("IPCModel", "add map = " + hashMap.toString());
                    if (this.b.size() >= 200) {
                        this.b.remove(0);
                    }
                    this.b.add(hashMap);
                    z2 = true;
                } else {
                    i++;
                }
            }
            com.xiaopeng.a.a.a.a("IPCModel", str + ", isHasShouldSend = " + z2);
            if (!z2) {
                b(str, ipcMessage, z);
                return;
            } else if (this.d.hasMessages(1)) {
                return;
            } else {
                a(str);
                a(str, 0);
                return;
            }
        }
        b(str, ipcMessage, z);
    }

    private void b(String str, IpcMessage ipcMessage, boolean z) {
        boolean z2;
        com.xiaopeng.ipc.b bVar = this.a.get(str);
        if (bVar != null) {
            z2 = bVar.asBinder().pingBinder();
            if (!z2) {
                this.a.remove(str);
            }
        } else {
            z2 = false;
        }
        if (bVar == null || !z2) {
            com.xiaopeng.a.a.a.b("IPCModel", "IPC data:appId--> " + str + " has not been registered!");
            HashMap<String, IpcMessage> hashMap = new HashMap<>();
            hashMap.put(str, ipcMessage);
            this.b.add(hashMap);
            a(str);
            if (z) {
                a(str, 0);
                return;
            }
            return;
        }
        try {
            bVar.a(ipcMessage);
        } catch (RemoteException e) {
            e.printStackTrace();
            com.xiaopeng.a.a.a.c("IPCModel", "IPC data:callback to client error! e-->" + e.getMessage());
        }
    }

    /* compiled from: IPCModel.java */
    /* loaded from: classes.dex */
    private class a implements Runnable {
        private String b;
        private com.xiaopeng.ipc.b c;

        public a(String str, com.xiaopeng.ipc.b bVar) {
            this.b = str;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaopeng.a.a.a.a("IPCModel", this.b + " start send time = " + System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append("before shouldSendList.size = ");
            sb.append(b.this.b.size());
            com.xiaopeng.a.a.a.a("IPCModel", sb.toString());
            int i = 0;
            while (i < b.this.b.size()) {
                HashMap hashMap = (HashMap) b.this.b.get(i);
                if (hashMap.containsKey(this.b)) {
                    try {
                        if (!this.c.asBinder().isBinderAlive()) {
                            b.this.a.remove(this.b);
                            com.xiaopeng.a.a.a.c("IPCModel", "The binder is not alive.");
                            break;
                        }
                        this.c.a((IpcMessage) hashMap.get(this.b));
                        b.this.b.remove(i);
                    } catch (RemoteException e) {
                        b.this.a.remove(this.b);
                        com.xiaopeng.a.a.a.c("IPCModel", "Callback onReceive error: " + e.getMessage());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        com.xiaopeng.a.a.a.c("IPCModel", "IPC data:callback to client error! e-->" + e2.getMessage());
                    }
                } else {
                    i++;
                }
            }
            com.xiaopeng.a.a.a.a("IPCModel", "after shouldSendList.size = " + b.this.b.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.setAction("com.xiaopeng.ipc.AgentService");
        intent.setPackage(str);
        c.a().b().a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        com.xiaopeng.a.a.a.b("IPCModel", "scheduleStartClient for appId-->" + str);
        Message obtainMessage = this.d.obtainMessage(1);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        this.d.sendMessageDelayed(obtainMessage, 200L);
    }
}
