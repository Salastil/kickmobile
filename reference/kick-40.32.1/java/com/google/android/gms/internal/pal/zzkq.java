package com.google.android.gms.internal.pal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzkq extends zzgx implements zzkr {
    public zzkq() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.pal.zzgx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                zzgy.zzd(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzgy.zzd(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzgy.zzd(parcel);
                break;
            case 6:
                parcel.readInt();
                zzgy.zzd(parcel);
                break;
            case 7:
                parcel.readInt();
                zzgy.zzd(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzgy.zzd(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
