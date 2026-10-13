package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class ReconnectionService extends Service {
    private static final Logger zza = new Logger("ReconnectionService");
    private zzar zzb;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzar zzarVar = this.zzb;
        if (zzarVar != null) {
            try {
                return zzarVar.zzg(intent);
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "onBind", "zzar");
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzar zzarVarZzd = com.google.android.gms.internal.cast.zzay.zzd(this, sharedInstance.getSessionManager().zzd(), sharedInstance.zzc().zza());
        this.zzb = zzarVarZzd;
        if (zzarVarZzd != null) {
            try {
                zzarVarZzd.zze();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "onCreate", "zzar");
            }
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzar zzarVar = this.zzb;
        if (zzarVar != null) {
            try {
                zzarVar.zzh();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "onDestroy", "zzar");
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        zzar zzarVar = this.zzb;
        if (zzarVar != null) {
            try {
                return zzarVar.zzf(intent, i, i2);
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "onStartCommand", "zzar");
            }
        }
        return 2;
    }
}
