package com.xiaopeng.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new Parcelable.Creator<IpcMessage>() { // from class: com.xiaopeng.ipc.IpcMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    };
    String a;
    int b;
    Bundle c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IpcMessage() {
    }

    protected IpcMessage(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeBundle(this.c);
    }
}
