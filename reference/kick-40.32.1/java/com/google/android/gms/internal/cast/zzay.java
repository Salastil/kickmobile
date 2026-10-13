package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ModuleUnavailableException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzay {
    private static final Logger zza = new Logger("CastDynamiteModule");

    public static com.google.android.gms.cast.framework.zzah zza(Context context, CastOptions castOptions, zzbe zzbeVar, Map map) throws ModuleUnavailableException, RemoteException {
        return zzf(context).zzf(ObjectWrapper.wrap(context.getApplicationContext()), castOptions, zzbeVar, map);
    }

    public static com.google.android.gms.cast.framework.zzau zzb(Context context, String str, String str2, com.google.android.gms.cast.framework.zzbc zzbcVar) {
        try {
            return zzf(context).zzg(str, str2, zzbcVar);
        } catch (RemoteException | ModuleUnavailableException e) {
            zza.d(e, "Unable to call %s on %s.", "newSessionImpl", "zzbc");
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.zzak zzc(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzae zzaeVar) {
        if (iObjectWrapper == null) {
            return null;
        }
        try {
            return zzf(context).zzh(castOptions, iObjectWrapper, zzaeVar);
        } catch (RemoteException | ModuleUnavailableException e) {
            zza.d(e, "Unable to call %s on %s.", "newCastSessionImpl", "zzbc");
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.zzar zzd(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        if (iObjectWrapper != null && iObjectWrapper2 != null) {
            try {
                return zzf(service.getApplicationContext()).zzi(ObjectWrapper.wrap(service), iObjectWrapper, iObjectWrapper2);
            } catch (RemoteException | ModuleUnavailableException e) {
                zza.d(e, "Unable to call %s on %s.", "newReconnectionServiceImpl", "zzbc");
            }
        }
        return null;
    }

    public static com.google.android.gms.cast.framework.media.internal.zzg zze(Context context, AsyncTask asyncTask, com.google.android.gms.cast.framework.media.internal.zzi zziVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        try {
            zzbc zzbcVarZzf = zzf(context.getApplicationContext());
            return zzbcVarZzf.zze() >= 233700000 ? zzbcVarZzf.zzk(ObjectWrapper.wrap(context.getApplicationContext()), ObjectWrapper.wrap(asyncTask), zziVar, i, i2, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000) : zzbcVarZzf.zzj(ObjectWrapper.wrap(asyncTask), zziVar, i, i2, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000);
        } catch (RemoteException | ModuleUnavailableException e) {
            zza.d(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", "zzbc");
            return null;
        }
    }

    private static zzbc zzf(Context context) throws ModuleUnavailableException {
        try {
            IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (iBinderInstantiate == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return iInterfaceQueryLocalInterface instanceof zzbc ? (zzbc) iInterfaceQueryLocalInterface : new zzbb(iBinderInstantiate);
        } catch (DynamiteModule.LoadingException e) {
            throw new ModuleUnavailableException(e);
        }
    }
}
