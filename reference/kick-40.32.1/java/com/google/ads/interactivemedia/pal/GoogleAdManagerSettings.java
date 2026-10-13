package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class GoogleAdManagerSettings {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    public static abstract class Builder {
        public abstract GoogleAdManagerSettings build();

        public abstract Builder disableFirstPartyIdentifiers(boolean z);

        public abstract Builder disableLimitedAdsStorage(boolean z);
    }

    public static Builder builder() {
        zze zzeVar = new zze();
        zzeVar.disableFirstPartyIdentifiers(false);
        zzeVar.disableLimitedAdsStorage(false);
        return zzeVar;
    }

    public abstract boolean disableFirstPartyIdentifiers();

    public abstract boolean disableLimitedAdsStorage();

    public abstract Builder toBuilder();
}
