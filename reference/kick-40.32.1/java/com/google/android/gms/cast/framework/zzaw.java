package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzaw extends IInterface {
    IObjectWrapper zze() throws RemoteException;

    void zzf(zzay zzayVar) throws RemoteException;

    void zzg(zzay zzayVar) throws RemoteException;

    void zzh(zzam zzamVar) throws RemoteException;

    void zzi(zzam zzamVar) throws RemoteException;

    void zzj(boolean z, boolean z2) throws RemoteException;

    IObjectWrapper zzk() throws RemoteException;

    int zzl() throws RemoteException;

    void zzm(Bundle bundle) throws RemoteException;
}
