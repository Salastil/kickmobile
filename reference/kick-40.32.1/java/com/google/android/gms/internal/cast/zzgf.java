package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzgf extends IInterface {
    void zzb(Status status, zzgc zzgcVar) throws RemoteException;

    void zzc(Status status) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze(Status status) throws RemoteException;

    void zzf(Status status, List list) throws RemoteException;

    void zzg(Status status) throws RemoteException;

    void zzh(Status status, boolean z, zzfn zzfnVar) throws RemoteException;

    void zzi(Status status, zzfn zzfnVar) throws RemoteException;

    void zzj(PendingIntent pendingIntent) throws RemoteException;

    void zzk(Status status) throws RemoteException;

    void zzl(Status status, zzfp zzfpVar) throws RemoteException;

    void zzm(Status status) throws RemoteException;

    void zzn(Status status, zzfw zzfwVar) throws RemoteException;

    void zzo(Status status, zzfn zzfnVar) throws RemoteException;
}
