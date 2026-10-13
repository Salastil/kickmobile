package com.google.android.gms.internal.pal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjz extends zzgw implements IInterface {
    zzjz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzjx zze(zzjv zzjvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzb(parcelZza, zzjvVar);
        Parcel parcelZzu = zzu(1, parcelZza);
        zzjx zzjxVar = (zzjx) zzgy.zza(parcelZzu, zzjx.CREATOR);
        parcelZzu.recycle();
        return zzjxVar;
    }

    public final zzkg zzf(zzke zzkeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzb(parcelZza, zzkeVar);
        Parcel parcelZzu = zzu(3, parcelZza);
        zzkg zzkgVar = (zzkg) zzgy.zza(parcelZzu, zzkg.CREATOR);
        parcelZzu.recycle();
        return zzkgVar;
    }
}
