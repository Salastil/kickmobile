package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzar extends IInterface {
    void zze() throws RemoteException;

    int zzf(Intent intent, int i, int i2) throws RemoteException;

    IBinder zzg(Intent intent) throws RemoteException;

    void zzh() throws RemoteException;
}
