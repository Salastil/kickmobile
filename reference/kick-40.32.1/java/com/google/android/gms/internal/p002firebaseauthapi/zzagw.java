package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagw extends zzaim {
    private String zza;
    private String zzb;
    private String zzc;
    private zzahp zzd;
    private String zze;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzaim zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null idToken");
        }
        this.zze = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzaim zzb(String str) {
        if (str == null) {
            throw new NullPointerException("Null providerId");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzaim zzc(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzaim zzd(String str) {
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzaim zza(zzahp zzahpVar) {
        if (zzahpVar == null) {
            throw new NullPointerException("Null tokenType");
        }
        this.zzd = zzahpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaim
    public final zzain zza() {
        if (this.zza == null || this.zzc == null || this.zzd == null || this.zze == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" providerId");
            }
            if (this.zzc == null) {
                sb.append(" token");
            }
            if (this.zzd == null) {
                sb.append(" tokenType");
            }
            if (this.zze == null) {
                sb.append(" idToken");
            }
            throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
        }
        return new zzagx(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    zzagw() {
    }
}
