package com.google.firebase.auth.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzl extends zzh {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzc;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.firebase.auth.internal.zzh
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.internal.zzh
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.internal.zzh
    public final String zzd() {
        return this.zza;
    }

    public final String toString() {
        return "AttestationResult{recaptchaV2Token=" + this.zza + ", playIntegrityToken=" + this.zzb + ", recaptchaEnterpriseToken=" + this.zzc + "}";
    }

    private zzl(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzh) {
            zzh zzhVar = (zzh) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzhVar.zzd()) : zzhVar.zzd() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzhVar.zzb()) : zzhVar.zzb() == null) {
                    String str3 = this.zzc;
                    if (str3 != null ? str3.equals(zzhVar.zzc()) : zzhVar.zzc() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
