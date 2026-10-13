package com.google.android.gms.internal.cast;

import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zzet implements CastRemoteDisplayApi {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastRemoteDisplayApiImpl");
    private final Api zzc;
    private VirtualDisplay zzd;
    private final zzfb zze = new zzel(this);

    public zzet(Api api) {
        this.zzc = api;
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zzb.d("startRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzem(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public final PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zzb.d("stopRemoteDisplay", new Object[0]);
        return googleApiClient.execute(new zzen(this, googleApiClient));
    }

    final /* synthetic */ void zza() {
        VirtualDisplay virtualDisplay = this.zzd;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = zzb;
                int displayId = virtualDisplay.getDisplay().getDisplayId();
                StringBuilder sb = new StringBuilder(String.valueOf(displayId).length() + 27);
                sb.append("releasing virtual display: ");
                sb.append(displayId);
                logger.d(sb.toString(), new Object[0]);
            }
            virtualDisplay.release();
        }
        this.zzd = null;
    }

    final /* synthetic */ Api zzc() {
        return this.zzc;
    }

    final /* synthetic */ VirtualDisplay zzd() {
        return this.zzd;
    }

    final /* synthetic */ void zze(VirtualDisplay virtualDisplay) {
        this.zzd = virtualDisplay;
    }

    final /* synthetic */ zzfb zzf() {
        return this.zze;
    }
}
