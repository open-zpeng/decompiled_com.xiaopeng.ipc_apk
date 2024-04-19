package com.xiaopeng.a.a;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public class a {
    public static int a = 2;
    public static String b = b();
    public static b c = new C0036a();
    public static boolean d = true;
    public static boolean e = false;

    /* compiled from: LogUtils.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static boolean a() {
        return d;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static boolean a(int i) {
        return a <= i && a();
    }

    public static void a(Object obj, String str) {
        if (a(2)) {
            a(2, obj, str, (Throwable) null, e);
        }
    }

    public static void b(Object obj, String str) {
        if (a(3)) {
            a(3, obj, str, (Throwable) null, e);
        }
    }

    public static void c(Object obj, String str) {
        if (a(6)) {
            a(6, obj, str, (Throwable) null, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(int r4, java.lang.Object r5, java.lang.String r6, java.lang.Throwable r7, boolean r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L20
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            if (r1 == 0) goto L14
            int r2 = r1.length
            r3 = 4
            if (r2 <= r3) goto L14
            r1 = r1[r3]
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L21
        L20:
            r1 = 0
        L21:
            if (r8 != 0) goto L25
            if (r7 == 0) goto L29
        L25:
            java.lang.String r6 = a(r0, r1, r6, r7, r8)
        L29:
            java.lang.String r5 = a(r5)
            if (r5 != 0) goto L38
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L39
            java.lang.String r0 = com.xiaopeng.a.a.a.b
            goto L39
        L38:
            r0 = r5
        L39:
            a(r4, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.a.a.a.a(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }

    private static void a(int i, String str, String str2) {
        c.a(i, str2, str, null);
    }

    private static String a(String str, int i, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (z) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (b != null) {
                sb.append("(C:");
                sb.append(b);
                sb.append(")");
            }
            sb.append("at (");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(")");
        }
        if (th != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    /* compiled from: LogUtils.java */
    /* renamed from: com.xiaopeng.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0036a implements b {
        private C0036a() {
        }

        @Override // com.xiaopeng.a.a.a.b
        public void a(int i, String str, String str2, String str3) {
            switch (i) {
                case 2:
                    Log.v(str2, str);
                    return;
                case 3:
                    Log.d(str2, str);
                    String str4 = "DEBUG: " + str;
                    return;
                case 4:
                    Log.i(str2, str);
                    String str5 = "INFO: " + str;
                    return;
                case 5:
                    Log.w(str2, str);
                    String str6 = "WARN: " + str;
                    return;
                case 6:
                    Log.e(str2, str);
                    String str7 = "ERROR: " + str;
                    return;
                default:
                    return;
            }
        }
    }

    private static String b() {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        return split[split.length - 1];
    }
}
