package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf extends GoogleAdManagerSettings {
    private final boolean zza;
    private final boolean zzb;

    /* synthetic */ zzf(boolean z, boolean z2, byte[] bArr) {
        this.zza = z;
        this.zzb = z2;
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings
    public final boolean disableFirstPartyIdentifiers() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings
    public final boolean disableLimitedAdsStorage() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleAdManagerSettings) {
            GoogleAdManagerSettings googleAdManagerSettings = (GoogleAdManagerSettings) obj;
            if (this.zza == googleAdManagerSettings.disableFirstPartyIdentifiers() && this.zzb == googleAdManagerSettings.disableLimitedAdsStorage()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((true != this.zza ? 1237 : 1231) ^ 1000003) * 1000003) ^ (true == this.zzb ? 1231 : 1237);
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings
    public final GoogleAdManagerSettings.Builder toBuilder() {
        return new zze(this);
    }

    public final String toString() {
        boolean z = this.zza;
        int length = String.valueOf(z).length();
        boolean z2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 80 + String.valueOf(z2).length() + 1);
        sb.append("GoogleAdManagerSettings{disableFirstPartyIdentifiers=");
        sb.append(z);
        sb.append(", disableLimitedAdsStorage=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
