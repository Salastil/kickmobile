package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbb extends zza implements zzbc {
    zzbb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final int zze() throws RemoteException {
        Parcel parcelZzb = zzb(8, zza());
        int i = parcelZzb.readInt();
        parcelZzb.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.zzah zzf(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzbe zzbeVar, Map map) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zzc(parcelZza, castOptions);
        zzc.zze(parcelZza, zzbeVar);
        parcelZza.writeMap(map);
        Parcel parcelZzb = zzb(1, parcelZza);
        com.google.android.gms.cast.framework.zzah zzahVarZzb = com.google.android.gms.cast.framework.zzag.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzahVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.zzau zzg(String str, String str2, com.google.android.gms.cast.framework.zzbc zzbcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zze(parcelZza, zzbcVar);
        Parcel parcelZzb = zzb(2, parcelZza);
        com.google.android.gms.cast.framework.zzau zzauVarZzb = com.google.android.gms.cast.framework.zzat.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzauVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.zzak zzh(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzae zzaeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, castOptions);
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, zzaeVar);
        Parcel parcelZzb = zzb(3, parcelZza);
        com.google.android.gms.cast.framework.zzak zzakVarZzb = com.google.android.gms.cast.framework.zzaj.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzakVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.zzar zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, iObjectWrapper2);
        zzc.zze(parcelZza, iObjectWrapper3);
        Parcel parcelZzb = zzb(5, parcelZza);
        com.google.android.gms.cast.framework.zzar zzarVarZzb = com.google.android.gms.cast.framework.zzaq.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzarVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.media.internal.zzg zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzi zziVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, zziVar);
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        parcelZza.writeInt(0);
        parcelZza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelZza.writeInt(5);
        parcelZza.writeInt(333);
        parcelZza.writeInt(10000);
        Parcel parcelZzb = zzb(6, parcelZza);
        com.google.android.gms.cast.framework.media.internal.zzg zzgVarZzb = com.google.android.gms.cast.framework.media.internal.zzf.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzgVarZzb;
    }

    @Override // com.google.android.gms.internal.cast.zzbc
    public final com.google.android.gms.cast.framework.media.internal.zzg zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, com.google.android.gms.cast.framework.media.internal.zzi zziVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, iObjectWrapper2);
        zzc.zze(parcelZza, zziVar);
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        parcelZza.writeInt(0);
        parcelZza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        parcelZza.writeInt(5);
        parcelZza.writeInt(333);
        parcelZza.writeInt(10000);
        Parcel parcelZzb = zzb(7, parcelZza);
        com.google.android.gms.cast.framework.media.internal.zzg zzgVarZzb = com.google.android.gms.cast.framework.media.internal.zzf.zzb(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return zzgVarZzb;
    }
}
