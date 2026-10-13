package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.RemoteMediaPlayer;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzap extends zzau implements zzar {
    zzap(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(5, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zzb(int i, String str, String str2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(1, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(10, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(902, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(12, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        Parcel parcelZzv = zzv(3, parcelZzu);
        Bundle bundle = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(8, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzh(int i, String str, String str2, String str3) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        Parcel parcelZzv = zzv(4, parcelZzu);
        Bundle bundle = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzi(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzaw.zzb(parcelZzu, bundle);
        Parcel parcelZzv = zzv(11, parcelZzu);
        Bundle bundle2 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final Bundle zzj(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzb(parcelZzu, bundle2);
        Parcel parcelZzv = zzv(901, parcelZzu);
        Bundle bundle3 = (Bundle) zzaw.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzk(int i, String str, Bundle bundle, zzx zzxVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzxVar);
        zzx(1501, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzl(int i, String str, Bundle bundle, zzz zzzVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzzVar);
        zzx(1801, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzm(Bundle bundle, zzac zzacVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzacVar);
        zzx(2001, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzn(int i, String str, Bundle bundle, zzae zzaeVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaeVar);
        zzx(1601, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzo(int i, String str, Bundle bundle, zzag zzagVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(18);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzagVar);
        zzw(1301, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzp(int i, String str, Bundle bundle, zzai zzaiVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaiVar);
        zzx(1901, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzq(int i, String str, Bundle bundle, zzak zzakVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(25);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzakVar);
        zzx(RemoteMediaPlayer.STATUS_CANCELED, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzr(int i, String str, Bundle bundle, zzam zzamVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzamVar);
        zzx(1401, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzs(int i, String str, Bundle bundle, zzao zzaoVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(24);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzaoVar);
        zzx(1701, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zzt(int i, String str, Bundle bundle, zzat zzatVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(12);
        parcelZzu.writeString(str);
        zzaw.zzb(parcelZzu, bundle);
        zzaw.zzc(parcelZzu, zzatVar);
        zzw(1201, parcelZzu);
    }
}
