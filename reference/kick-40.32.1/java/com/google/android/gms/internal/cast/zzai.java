package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzai extends zza implements IInterface {
    zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.devicesuggestions.internal.IDeviceSuggestionsService");
    }

    public final void zze(IStatusCallback iStatusCallback, zzah zzahVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iStatusCallback);
        zzc.zze(parcelZza, zzahVar);
        zzc(1, parcelZza);
    }

    public final void zzf(IStatusCallback iStatusCallback, zzah zzahVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iStatusCallback);
        zzc.zze(parcelZza, zzahVar);
        zzc(2, parcelZza);
    }

    public final void zzg(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iStatusCallback);
        zzc(3, parcelZza);
    }

    public final void zzh(IStatusCallback iStatusCallback) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iStatusCallback);
        zzc(4, parcelZza);
    }
}
