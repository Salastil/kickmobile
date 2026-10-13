package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zze extends GoogleAdManagerSettings.Builder {
    private boolean zza;
    private boolean zzb;
    private byte zzc;

    zze() {
    }

    zze(GoogleAdManagerSettings googleAdManagerSettings) {
        this.zza = googleAdManagerSettings.disableFirstPartyIdentifiers();
        this.zzb = googleAdManagerSettings.disableLimitedAdsStorage();
        this.zzc = (byte) 3;
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings.Builder
    public final GoogleAdManagerSettings build() {
        if (this.zzc == 3) {
            return new zzf(this.zza, this.zzb, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzc & 1) == 0) {
            sb.append(" disableFirstPartyIdentifiers");
        }
        if ((this.zzc & 2) == 0) {
            sb.append(" disableLimitedAdsStorage");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings.Builder
    public final GoogleAdManagerSettings.Builder disableFirstPartyIdentifiers(boolean z) {
        this.zza = z;
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.GoogleAdManagerSettings.Builder
    public final GoogleAdManagerSettings.Builder disableLimitedAdsStorage(boolean z) {
        this.zzb = z;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }
}
