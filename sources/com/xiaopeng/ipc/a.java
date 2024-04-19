package com.xiaopeng.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaopeng.ipc.b;
/* compiled from: IPC.java */
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(String str, IpcMessage ipcMessage) throws RemoteException;

    void a(String str, b bVar) throws RemoteException;

    void b(String str, b bVar) throws RemoteException;

    /* compiled from: IPC.java */
    /* renamed from: com.xiaopeng.ipc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0037a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0037a() {
            attachInterface(this, "com.xiaopeng.ipc.IPC");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.xiaopeng.ipc.IPC");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    b(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.xiaopeng.ipc.IPC");
                    a(parcel.readString(), parcel.readInt() != 0 ? IpcMessage.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
