package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhb extends RemoteCreator {
    private static final zzhb zza = new zzhb();

    private zzhb() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static zzhe zza(Context context, Executor executor, zzk zzkVar) {
        zzhe zzheVarZzb = null;
        if (zzkVar.zzd() && GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12800000) == 0) {
            zzheVarZzb = zza.zzb(context, executor, zzkVar);
        }
        return zzheVarZzb == null ? new zzha(context, executor, zzkVar) : zzheVarZzb;
    }

    private final zzhe zzb(Context context, Executor executor, zzk zzkVar) {
        try {
            IBinder iBinderZze = ((zzhf) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(executor), zzkVar.zzaq());
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return iInterfaceQueryLocalInterface instanceof zzhe ? (zzhe) iInterfaceQueryLocalInterface : new zzhc(iBinderZze);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException | IllegalArgumentException | LinkageError unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return iInterfaceQueryLocalInterface instanceof zzhf ? (zzhf) iInterfaceQueryLocalInterface : new zzhf(iBinder);
    }
}
