package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzks extends IInterface {
    void zzb(Status status) throws RemoteException;

    void zzc(Status status) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze(Status status) throws RemoteException;

    void zzf(Status status, @Nullable zzjh zzjhVar) throws RemoteException;

    void zzg(Status status) throws RemoteException;

    void zzh(Status status, @Nullable zzjl zzjlVar) throws RemoteException;

    void zzi(Status status, @Nullable zzjj zzjjVar) throws RemoteException;

    void zzj(Status status) throws RemoteException;

    void zzk(Status status, @Nullable zzjo zzjoVar) throws RemoteException;

    void zzl(Status status, @Nullable zzjh zzjhVar) throws RemoteException;

    void zzm(Status status, long j) throws RemoteException;

    void zzn(Status status) throws RemoteException;

    void zzo(Status status, @Nullable zzjs zzjsVar) throws RemoteException;

    void zzp(Status status) throws RemoteException;

    void zzq(Status status, long j) throws RemoteException;
}
