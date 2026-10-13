package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzko {
    final zzkr zza;
    final boolean zzb;

    private zzko(zzkr zzkrVar) {
        this.zza = zzkrVar;
        this.zzb = zzkrVar != null;
    }

    public static zzko zzb(Context context, String str, String str2) {
        zzkr zzkpVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.ads.dynamite").instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    IBinder iBinder = iBinderInstantiate;
                    if (iBinderInstantiate == null) {
                        zzkpVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzkpVar = iInterfaceQueryLocalInterface instanceof zzkr ? (zzkr) iInterfaceQueryLocalInterface : new zzkp(iBinderInstantiate);
                    }
                    zzkr zzkrVar = zzkpVar;
                    zzkpVar.zzj(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzko(zzkpVar);
                } catch (RemoteException | zzjt | NullPointerException | SecurityException unused) {
                    Log.d("GASS", "Cannot dynamite load clearcut");
                    return new zzko(new zzks());
                }
            } catch (Exception e) {
                throw new zzjt(e);
            }
        } catch (Exception e2) {
            throw new zzjt(e2);
        }
    }

    public static zzko zzc() {
        zzks zzksVar = new zzks();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzko(zzksVar);
    }

    public final zzkn zza(byte[] bArr) {
        return new zzkn(this, bArr, null);
    }
}
