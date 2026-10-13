package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaby implements zzaga<zzahq> {
    private final /* synthetic */ zzaga zza;
    private final /* synthetic */ zzaia zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaeu zzd;
    private final /* synthetic */ zzabv zze;

    zzaby(zzabv zzabvVar, zzaga zzagaVar, zzaia zzaiaVar, String str, zzaeu zzaeuVar) {
        this.zza = zzagaVar;
        this.zzb = zzaiaVar;
        this.zzc = str;
        this.zzd = zzaeuVar;
        Objects.requireNonNull(zzabvVar);
        this.zze = zzabvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzd.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzahq zzahqVar) {
        List<zzaht> listZza = zzahqVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzaht zzahtVar = listZza.get(0);
        zzaiq zzaiqVar = new zzaiq();
        zzaiqVar.zzd(this.zzb.zzc()).zza(this.zzc);
        zzaba.zza(this.zze.zza, this.zzd, this.zzb, zzahtVar, zzaiqVar, this.zza);
    }
}
