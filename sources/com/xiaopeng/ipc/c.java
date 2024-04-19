package com.xiaopeng.ipc;

import android.app.Application;
/* compiled from: IPCContext.java */
/* loaded from: classes.dex */
public class c {
    private static volatile c a;
    private final Application b;
    private final d c;

    private c(Application application, d dVar) {
        this.b = application;
        this.c = dVar;
    }

    public static c a(c cVar) {
        if (cVar == null) {
            throw new RuntimeException("IPCContext should not be null!");
        }
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = cVar;
                }
            }
        }
        return a;
    }

    public static c a() {
        if (a == null) {
            throw new RuntimeException("IPCContext is null!");
        }
        return a;
    }

    public d b() {
        return this.c;
    }

    /* compiled from: IPCContext.java */
    /* loaded from: classes.dex */
    public static class a {
        private final Application a;
        private d b;

        public a(Application application) {
            this.a = application;
        }

        public a a(d dVar) {
            this.b = dVar;
            return this;
        }

        public c a() {
            if (this.a == null || this.b == null) {
                throw new IllegalArgumentException("IPCContext Builder with invalid arguments!");
            }
            return new c(this.a, this.b);
        }
    }
}
