package com.google.android.gms.internal.pal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhc extends zzgw implements zzhe {
    zzhc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzb() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzc() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final int zzd() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzf(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzc(parcelZza, iObjectWrapper);
        zzgy.zzc(parcelZza, iObjectWrapper2);
        zzgy.zzc(parcelZza, iObjectWrapper3);
        Parcel parcelZzu = zzu(14, parcelZza);
        String string = parcelZzu.readString();
        parcelZzu.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzc(parcelZza, iObjectWrapper);
        zzv(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, IObjectWrapper iObjectWrapper4) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzc(parcelZza, iObjectWrapper);
        zzgy.zzc(parcelZza, iObjectWrapper2);
        zzgy.zzc(parcelZza, iObjectWrapper3);
        zzgy.zzc(parcelZza, iObjectWrapper4);
        Parcel parcelZzu = zzu(17, parcelZza);
        String string = parcelZzu.readString();
        parcelZzu.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzj() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzk(String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzn(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final IObjectWrapper zzo(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzq(IObjectWrapper iObjectWrapper, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        zzgy.zzc(parcelZza, iObjectWrapper);
        parcelZza.writeByteArray(null);
        Parcel parcelZzu = zzu(12, parcelZza);
        String string = parcelZzu.readString();
        parcelZzu.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzr(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final IObjectWrapper zzs(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        throw null;
    }
}
