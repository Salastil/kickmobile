package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzbc extends IInterface {
    IObjectWrapper zzb() throws RemoteException;

    void zzc(Bundle bundle) throws RemoteException;

    void zzd(Bundle bundle) throws RemoteException;

    void zze(Bundle bundle) throws RemoteException;

    void zzf(Bundle bundle) throws RemoteException;

    void zzg(boolean z) throws RemoteException;

    void zzh(Bundle bundle) throws RemoteException;

    long zzi() throws RemoteException;
}
