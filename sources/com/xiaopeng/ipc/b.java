package com.xiaopeng.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPCCallback.java */
/* loaded from: classes.dex */
public interface b extends IInterface {
    void a(IpcMessage ipcMessage) throws RemoteException;

    /* compiled from: IPCCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.ipc.IPCCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0038a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.xiaopeng.ipc.IPCCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaopeng.ipc.IPCCallback");
            a(parcel.readInt() != 0 ? IpcMessage.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IPCCallback.java */
        /* renamed from: com.xiaopeng.ipc.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0038a implements b {
            private IBinder a;

            C0038a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.xiaopeng.ipc.b
            public void a(IpcMessage ipcMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPCCallback");
                    if (ipcMessage != null) {
                        obtain.writeInt(1);
                        ipcMessage.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
