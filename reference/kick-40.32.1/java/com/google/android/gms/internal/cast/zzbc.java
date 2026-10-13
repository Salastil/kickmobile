package com.google.android.gms.internal.cast;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzbc extends IInterface {
    int zze() throws RemoteException;

    com.google.android.gms.cast.framework.zzah zzf(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzbe zzbeVar, Map map) throws RemoteException;

    com.google.android.gms.cast.framework.zzau zzg(String str, String str2, com.google.android.gms.cast.framework.zzbc zzbcVar) throws RemoteException;

    com.google.android.gms.cast.framework.zzak zzh(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzae zzaeVar) throws RemoteException;

    com.google.android.gms.cast.framework.zzar zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    com.google.android.gms.cast.framework.media.internal.zzg zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzi zziVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException;

    com.google.android.gms.cast.framework.media.internal.zzg zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, com.google.android.gms.cast.framework.media.internal.zzi zziVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException;
}
