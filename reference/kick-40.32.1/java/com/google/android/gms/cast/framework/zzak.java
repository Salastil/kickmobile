package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzak extends IInterface {
    void zze(Bundle bundle) throws RemoteException;

    void zzf(int i) throws RemoteException;

    void zzg(ConnectionResult connectionResult) throws RemoteException;

    void zzh(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void zzi(int i) throws RemoteException;

    void zzj(boolean z, int i) throws RemoteException;
}
