package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzb extends ConsentSettings {
    private final Boolean zza;
    private final Boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzb(Boolean bool, Boolean bool2, boolean z, byte[] bArr) {
        this.zza = bool;
        this.zzb = bool2;
        this.zzc = z;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings
    public final Boolean directedForChildOrUnknownAge() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConsentSettings) {
            ConsentSettings consentSettings = (ConsentSettings) obj;
            Boolean bool = this.zza;
            if (bool != null ? bool.equals(consentSettings.zza()) : consentSettings.zza() == null) {
                if (this.zzb.equals(consentSettings.directedForChildOrUnknownAge()) && this.zzc == consentSettings.forceLimitedAds()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings
    public final boolean forceLimitedAds() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings
    public final ConsentSettings.Builder toBuilder() {
        return new zza(this);
    }

    public final String toString() {
        Boolean bool = this.zza;
        int length = String.valueOf(bool).length();
        Boolean bool2 = this.zzb;
        int length2 = bool2.toString().length();
        boolean z = this.zzc;
        StringBuilder sb = new StringBuilder(length + 87 + length2 + 18 + String.valueOf(z).length() + 1);
        sb.append("ConsentSettings{enableCookiesFor3pServerSideAdInsertion=");
        sb.append(bool);
        sb.append(", directedForChildOrUnknownAge=");
        sb.append(bool2);
        sb.append(", forceLimitedAds=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings
    final Boolean zza() {
        return this.zza;
    }

    public final int hashCode() {
        Boolean bool = this.zza;
        return (true != this.zzc ? 1237 : 1231) ^ (((((bool == null ? 0 : bool.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003);
    }
}
