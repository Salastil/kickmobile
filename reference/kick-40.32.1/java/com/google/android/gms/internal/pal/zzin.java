package com.google.android.gms.internal.pal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzin extends zzgw implements zzip {
    zzin(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.signalsdk.ISignalSdkService");
    }

    @Override // com.google.android.gms.internal.pal.zzip
    public final void zze(Bundle bundle, zzim zzimVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzb(parcelZza, bundle);
        zzgy.zzc(parcelZza, zzimVar);
        zzw(1, parcelZza);
    }
}
