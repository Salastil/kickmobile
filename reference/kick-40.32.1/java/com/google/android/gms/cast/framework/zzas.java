package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzas extends com.google.android.gms.internal.cast.zza implements zzau {
    zzas(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final int zze() throws RemoteException {
        Parcel parcelZzb = zzb(17, zza());
        int i = parcelZzb.readInt();
        parcelZzb.recycle();
        return i;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcelZzb = zzb(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzb.readStrongBinder());
        parcelZzb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final String zzg() throws RemoteException {
        Parcel parcelZzb = zzb(2, zza());
        String string = parcelZzb.readString();
        parcelZzb.recycle();
        return string;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final String zzh() throws RemoteException {
        Parcel parcelZzb = zzb(3, zza());
        String string = parcelZzb.readString();
        parcelZzb.recycle();
        return string;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzb = zzb(5, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzj() throws RemoteException {
        Parcel parcelZzb = zzb(6, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzb = zzb(7, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzb = zzb(8, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzm() throws RemoteException {
        Parcel parcelZzb = zzb(9, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final boolean zzn() throws RemoteException {
        Parcel parcelZzb = zzb(10, zza());
        boolean zZza = com.google.android.gms.internal.cast.zzc.zza(parcelZzb);
        parcelZzb.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final int zzo() throws RemoteException {
        Parcel parcelZzb = zzb(18, zza());
        int i = parcelZzb.readInt();
        parcelZzb.recycle();
        return i;
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzp(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzq(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzr(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzs(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.cast.zzc.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzc(14, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzt(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.cast.framework.zzau
    public final void zzu(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(16, parcelZza);
    }
}
