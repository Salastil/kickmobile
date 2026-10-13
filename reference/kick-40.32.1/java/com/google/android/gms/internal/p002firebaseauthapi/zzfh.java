package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfh extends zzdo {
    private final String zza;
    private final zza zzb;

    public final int hashCode() {
        return Objects.hash(zzfh.class, this.zza, this.zzb);
    }

    public final zza zzb() {
        return this.zzb;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zza(String str) {
            this.zzc = str;
        }
    }

    public static zzfh zza(String str, zza zzaVar) {
        return new zzfh(str, zzaVar);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + String.valueOf(this.zzb) + ")";
    }

    private zzfh(String str, zza zzaVar) {
        this.zza = str;
        this.zzb = zzaVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfh)) {
            return false;
        }
        zzfh zzfhVar = (zzfh) obj;
        return zzfhVar.zza.equals(this.zza) && zzfhVar.zzb.equals(this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcs
    public final boolean zza() {
        return this.zzb != zza.zzb;
    }
}
