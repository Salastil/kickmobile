package com.google.android.gms.cast.framework;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzae extends IInterface {
    void zzb(String str, String str2) throws RemoteException;

    void zzc(String str, LaunchOptions launchOptions) throws RemoteException;

    void zzd(String str) throws RemoteException;

    void zze(int i) throws RemoteException;
}
