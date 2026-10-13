package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzu extends zzad {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzu(CastSession castSession, byte[] bArr) {
        Objects.requireNonNull(castSession);
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zzb(String str, String str2) {
        CastSession castSession = this.zza;
        if (castSession.zzj() == null || !castSession.zzj().zza()) {
            return;
        }
        ((zzbm) castSession.zzj()).zzs(str, str2, null).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzt
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zza.zze("joinApplication", task);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zzc(String str, LaunchOptions launchOptions) {
        CastSession castSession = this.zza;
        if (castSession.zzj() == null || !castSession.zzj().zza()) {
            return;
        }
        castSession.zzj().zzg(str, launchOptions).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzs
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zza.zze("launchApplication", task);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zzd(String str) {
        CastSession castSession = this.zza;
        if (castSession.zzj() == null || !castSession.zzj().zza()) {
            return;
        }
        castSession.zzj().zzh(str);
    }

    @Override // com.google.android.gms.cast.framework.zzae
    public final void zze(int i) {
        this.zza.zzf(i);
    }
}
