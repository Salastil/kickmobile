package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgh extends zza implements IInterface {
    zzgh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.usagereporting.internal.IUsageReportingService");
    }

    public final void zze(zzgf zzgfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzgfVar);
        zzc(2, parcelZza);
    }

    public final void zzf(zzgg zzggVar, zzgf zzgfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzggVar);
        zzc.zze(parcelZza, zzgfVar);
        zzc(5, parcelZza);
    }
}
