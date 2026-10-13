package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.view.ViewGroup;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbj implements com.google.android.gms.cast.framework.internal.featurehighlight.zzg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzb;
    final /* synthetic */ zzbk zzc;

    zzbj(zzbk zzbkVar, Activity activity, com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar) {
        this.zza = activity;
        this.zzb = zzhVar;
        Objects.requireNonNull(zzbkVar);
        this.zzc = zzbkVar;
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zza() {
        if (this.zzc.zzc()) {
            final Activity activity = this.zza;
            com.google.android.gms.cast.framework.zzbd.zza(activity);
            this.zzb.zze(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzbk zzbkVar = this.zza.zzc;
                    if (zzbkVar.zzc()) {
                        ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzbkVar);
                        if (zzbkVar.zzb() != null) {
                            zzbkVar.zzb().onOverlayDismissed();
                        }
                        zzbkVar.zza();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zzb() {
        if (this.zzc.zzc()) {
            final Activity activity = this.zza;
            com.google.android.gms.cast.framework.zzbd.zza(activity);
            this.zzb.zzd(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzbk zzbkVar = this.zza.zzc;
                    if (zzbkVar.zzc()) {
                        ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzbkVar);
                        if (zzbkVar.zzb() != null) {
                            zzbkVar.zzb().onOverlayDismissed();
                        }
                        zzbkVar.zza();
                    }
                }
            });
        }
    }
}
