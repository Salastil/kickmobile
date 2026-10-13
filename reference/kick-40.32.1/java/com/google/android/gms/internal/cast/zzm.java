package com.google.android.gms.internal.cast;

import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzm extends SessionTransferCallback {
    final /* synthetic */ zzn zza;

    public zzm(zzn zznVar) {
        Objects.requireNonNull(zznVar);
        this.zza = zznVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferFailed(int i, int i2) {
        int i3 = zzn.zza;
        zzn.zzb.d("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i), Integer.valueOf(i2));
        zzn zznVar = this.zza;
        zznVar.zze();
        zznVar.zzj().zzd(zznVar.zzk().zzg(zznVar.zzm(), i, i2), 232);
        zznVar.zzp(false);
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferred(int i, SessionState sessionState) {
        int i2 = zzn.zza;
        zzn.zzb.d("onTransferred with type = %d", Integer.valueOf(i));
        zzn zznVar = this.zza;
        zznVar.zze();
        zznVar.zzj().zzd(zznVar.zzk().zzf(zznVar.zzm(), i), WebmConstants.MkvEbmlElement.TIMESTAMP);
        zznVar.zzp(false);
        zznVar.zzn(null);
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferring(int i) {
        int i2 = zzn.zza;
        zzn.zzb.d("onTransferring with type = %d", Integer.valueOf(i));
        zzn zznVar = this.zza;
        zznVar.zzp(true);
        zznVar.zze();
        zznVar.zzj().zzd(zznVar.zzk().zzf(zznVar.zzm(), i), 230);
    }
}
