package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends ConsentSettings.Builder {
    private Boolean zza;
    private Boolean zzb;
    private boolean zzc;
    private byte zzd;

    zza() {
    }

    zza(ConsentSettings consentSettings) {
        this.zza = consentSettings.zza();
        this.zzb = consentSettings.directedForChildOrUnknownAge();
        this.zzc = consentSettings.forceLimitedAds();
        this.zzd = (byte) 1;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings.Builder
    public final ConsentSettings build() {
        Boolean bool;
        if (this.zzd == 1 && (bool = this.zzb) != null) {
            return new zzb(this.zza, bool, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zzb == null) {
            sb.append(" directedForChildOrUnknownAge");
        }
        if (this.zzd == 0) {
            sb.append(" forceLimitedAds");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings.Builder
    public final ConsentSettings.Builder directedForChildOrUnknownAge(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null directedForChildOrUnknownAge");
        }
        this.zzb = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings.Builder
    public final ConsentSettings.Builder enableCookiesFor3pServerSideAdInsertion(Boolean bool) {
        this.zza = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.ConsentSettings.Builder
    public final ConsentSettings.Builder forceLimitedAds(boolean z) {
        this.zzc = z;
        this.zzd = (byte) 1;
        return this;
    }
}
