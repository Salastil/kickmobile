package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagu extends zzaii {
    private final String zza;
    private final String zzb;

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    final String zzb() {
        return this.zza;
    }

    public final String toString() {
        return "RecaptchaEnforcementState{provider=" + this.zza + ", enforcementState=" + this.zzb + "}";
    }

    zzagu(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaii) {
            zzaii zzaiiVar = (zzaii) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzaiiVar.zzb()) : zzaiiVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzaiiVar.zza()) : zzaiiVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
