package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagx extends zzain {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzahp zzd;
    private final String zze;

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        return this.zze.hashCode() ^ ((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    public final zzahp zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    public final String zzf() {
        return this.zzc;
    }

    public final String toString() {
        return "RevokeTokenRequest{providerId=" + this.zza + ", tenantId=" + this.zzb + ", token=" + this.zzc + ", tokenType=" + String.valueOf(this.zzd) + ", idToken=" + this.zze + "}";
    }

    private zzagx(String str, String str2, String str3, zzahp zzahpVar, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzahpVar;
        this.zze = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzain) {
            zzain zzainVar = (zzain) obj;
            if (this.zza.equals(zzainVar.zzd()) && ((str = this.zzb) != null ? str.equals(zzainVar.zze()) : zzainVar.zze() == null) && this.zzc.equals(zzainVar.zzf()) && this.zzd.equals(zzainVar.zzb()) && this.zze.equals(zzainVar.zzc())) {
                return true;
            }
        }
        return false;
    }
}
