package com.google.android.gms.internal.pal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzhe extends IInterface {
    boolean zzb() throws RemoteException;

    boolean zzc() throws RemoteException;

    int zzd() throws RemoteException;

    String zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    String zzf(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    String zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, IObjectWrapper iObjectWrapper4) throws RemoteException;

    String zzj() throws RemoteException;

    void zzk(String str, String str2) throws RemoteException;

    boolean zzl(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(String str) throws RemoteException;

    IObjectWrapper zzo(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    String zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    String zzq(IObjectWrapper iObjectWrapper, byte[] bArr) throws RemoteException;

    String zzr(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    IObjectWrapper zzs(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
