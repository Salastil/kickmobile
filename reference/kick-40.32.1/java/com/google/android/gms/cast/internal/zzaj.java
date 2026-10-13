package com.google.android.gms.cast.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzaj extends IInterface {
    void zzb(int i) throws RemoteException;

    void zzc(int i) throws RemoteException;

    void zzd(int i) throws RemoteException;

    void zze(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void zzf(int i) throws RemoteException;

    void zzg(int i) throws RemoteException;

    void zzh(int i) throws RemoteException;

    void zzi(int i) throws RemoteException;

    void zzj(String str, double d, boolean z) throws RemoteException;

    void zzk(zzac zzacVar) throws RemoteException;

    void zzl(zza zzaVar) throws RemoteException;

    void zzm(String str, String str2) throws RemoteException;

    void zzn(String str, byte[] bArr) throws RemoteException;

    void zzo(String str, long j, int i) throws RemoteException;

    void zzp(String str, long j) throws RemoteException;
}
