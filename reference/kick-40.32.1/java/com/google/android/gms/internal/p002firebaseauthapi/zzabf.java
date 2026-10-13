package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabf implements zzaga<zzait> {
    private final /* synthetic */ zzaiq zza;
    private final /* synthetic */ zzaht zzb;
    private final /* synthetic */ zzaeu zzc;
    private final /* synthetic */ zzaia zzd;
    private final /* synthetic */ zzagb zze;
    private final /* synthetic */ zzaba zzf;

    zzabf(zzaba zzabaVar, zzaiq zzaiqVar, zzaht zzahtVar, zzaeu zzaeuVar, zzaia zzaiaVar, zzagb zzagbVar) {
        this.zza = zzaiqVar;
        this.zzb = zzahtVar;
        this.zzc = zzaeuVar;
        this.zzd = zzaiaVar;
        this.zze = zzagbVar;
        Objects.requireNonNull(zzabaVar);
        this.zzf = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zze.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzait zzaitVar) {
        zzait zzaitVar2 = zzaitVar;
        if (this.zza.zzi("EMAIL")) {
            this.zzb.zzb(null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzb(this.zza.zzc());
        }
        if (this.zza.zzi("DISPLAY_NAME")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zzi("PHOTO_URL")) {
            this.zzb.zzc(null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            Preconditions.checkNotEmpty(Base64Utils.encode("redacted".getBytes()));
        }
        if (this.zza.zzi("delete_passkey")) {
            this.zzb.zza(zzah.zzg());
        }
        List<zzaig> listZze = zzaitVar2.zze();
        if (listZze == null) {
            listZze = new ArrayList<>();
        }
        this.zzb.zza(listZze);
        zzaeu zzaeuVar = this.zzc;
        zzaia zzaiaVar = this.zzd;
        Preconditions.checkNotNull(zzaiaVar);
        Preconditions.checkNotNull(zzaitVar2);
        String strZzc = zzaitVar2.zzc();
        String strZzd = zzaitVar2.zzd();
        if (!TextUtils.isEmpty(strZzc) && !TextUtils.isEmpty(strZzd)) {
            zzaiaVar = new zzaia(strZzd, strZzc, Long.valueOf(zzaitVar2.zza()), zzaiaVar.zze());
        }
        zzaeuVar.zza(zzaiaVar, this.zzb);
    }
}
