package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaf extends com.google.android.gms.internal.cast.zza implements zzah {
    zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final Bundle zze() throws RemoteException {
        Parcel parcelZzb = zzb(1, zza());
        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.zzc.zzb(parcelZzb, Bundle.CREATOR);
        parcelZzb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzf(zzac zzacVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.cast.zzc.zze(parcelZza, zzacVar);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final zzaw zzg() throws RemoteException {
        zzaw zzavVar;
        Parcel parcelZzb = zzb(5, zza());
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzavVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            zzavVar = iInterfaceQueryLocalInterface instanceof zzaw ? (zzaw) iInterfaceQueryLocalInterface : new zzav(strongBinder);
        }
        parcelZzb.recycle();
        return zzavVar;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final zzao zzh() throws RemoteException {
        zzao zzanVar;
        Parcel parcelZzb = zzb(6, zza());
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzanVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            zzanVar = iInterfaceQueryLocalInterface instanceof zzao ? (zzao) iInterfaceQueryLocalInterface : new zzan(strongBinder);
        }
        parcelZzb.recycle();
        return zzanVar;
    }

    @Override // com.google.android.gms.cast.framework.zzah
    public final void zzi(String str, Map map) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeMap(map);
        zzc(11, parcelZza);
    }
}
