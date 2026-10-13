package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ConsentSettings {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    public static abstract class Builder {
        public abstract ConsentSettings build();

        public abstract Builder directedForChildOrUnknownAge(Boolean bool);

        public abstract Builder enableCookiesFor3pServerSideAdInsertion(Boolean bool);

        public abstract Builder forceLimitedAds(boolean z);
    }

    public static Builder builder() {
        zza zzaVar = new zza();
        zzaVar.enableCookiesFor3pServerSideAdInsertion(null);
        zzaVar.directedForChildOrUnknownAge(false);
        zzaVar.forceLimitedAds(false);
        return zzaVar;
    }

    public abstract Boolean directedForChildOrUnknownAge();

    public abstract boolean forceLimitedAds();

    public abstract Builder toBuilder();

    abstract Boolean zza();
}
