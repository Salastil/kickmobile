package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzy extends com.google.android.gms.cast.zzp {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzy(CastSession castSession, byte[] bArr) {
        Objects.requireNonNull(castSession);
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zza() {
        CastSession castSession = this.zza;
        if (castSession.zzi() == null) {
            return;
        }
        try {
            if (castSession.zzk() != null) {
                castSession.zzk().zzb();
            }
            castSession.zzi().zze(null);
        } catch (RemoteException e) {
            CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnected", "zzak");
        }
        CastSession castSession2 = this.zza;
        if (castSession2.zzl() != null) {
            castSession2.zzl().zza();
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzb(int i) {
        CastSession castSession = this.zza;
        if (castSession.zzi() == null) {
            return;
        }
        try {
            castSession.zzi().zzg(new ConnectionResult(i));
        } catch (RemoteException e) {
            CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnectionFailed", "zzak");
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzc(int i) {
        CastSession castSession = this.zza;
        if (castSession.zzi() == null) {
            return;
        }
        try {
            castSession.zzi().zzf(i);
        } catch (RemoteException e) {
            CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnectionSuspended", "zzak");
        }
    }

    @Override // com.google.android.gms.cast.zzp
    public final void zzd(int i) {
        CastSession castSession = this.zza;
        if (castSession.zzi() == null) {
            return;
        }
        try {
            castSession.zzi().zzg(new ConnectionResult(i));
        } catch (RemoteException e) {
            CastSession.zzb.d(e, "Unable to call %s on %s.", "onDisconnected", "zzak");
        }
    }
}
