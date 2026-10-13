package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzhg {
    protected zzhe zza;

    protected zzhg() {
    }

    public final String zza(Context context, View view, Activity activity) throws RemoteException {
        return this.zza.zzf(ObjectWrapper.wrap(context), ObjectWrapper.wrap(null), ObjectWrapper.wrap(activity));
    }

    public final void zzb(MotionEvent motionEvent) throws RemoteException {
        this.zza.zzh(ObjectWrapper.wrap(motionEvent));
    }

    public final String zzc(Context context, String str, View view, Activity activity) throws RemoteException {
        return this.zza.zzi(ObjectWrapper.wrap(context), ObjectWrapper.wrap(""), ObjectWrapper.wrap(null), ObjectWrapper.wrap(activity));
    }

    @Deprecated
    public final String zzd(Context context, byte[] bArr) throws RemoteException {
        return this.zza.zzq(ObjectWrapper.wrap(context), null);
    }
}
