package com.google.ads.interactivemedia.pal;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NonceRequest {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    public static abstract class Builder {
        public abstract NonceRequest build();

        public abstract Builder continuousPlayback(Boolean bool);

        public abstract Builder descriptionURL(String str);

        public abstract Builder iconsSupported(Boolean bool);

        public abstract Builder nonceLengthLimit(Integer num);

        public abstract Builder omidPartnerName(String str);

        public abstract Builder omidPartnerVersion(String str);

        public abstract Builder platformSignalCollector(PlatformSignalCollector platformSignalCollector);

        public abstract Builder playerType(String str);

        public abstract Builder playerVersion(String str);

        public abstract Builder ppid(String str);

        public abstract Builder sessionId(String str);

        public abstract Builder skippablesSupported(Boolean bool);

        public abstract Builder supportedApiFrameworks(Set<Integer> set);

        public abstract Builder videoPlayerHeight(Integer num);

        public abstract Builder videoPlayerWidth(Integer num);

        public abstract Builder willAdAutoPlay(Boolean bool);

        public abstract Builder willAdPlayMuted(Boolean bool);
    }

    public static Builder builder() {
        zzi zziVar = new zzi();
        zziVar.willAdPlayMuted(null);
        zziVar.willAdAutoPlay(null);
        zziVar.continuousPlayback(null);
        zziVar.iconsSupported(false);
        zziVar.nonceLengthLimit(null);
        zziVar.videoPlayerHeight(null);
        zziVar.videoPlayerWidth(null);
        zziVar.platformSignalCollector(null);
        zziVar.descriptionURL("");
        zziVar.omidPartnerName("");
        zziVar.omidPartnerVersion("");
        zziVar.playerType("");
        zziVar.playerVersion("");
        zziVar.ppid("");
        zziVar.skippablesSupported(false);
        zziVar.supportedApiFrameworks(new TreeSet());
        zziVar.sessionId(UUID.randomUUID().toString());
        return zziVar;
    }

    public abstract Boolean continuousPlayback();

    public abstract String descriptionURL();

    public abstract Boolean iconsSupported();

    public abstract String omidPartnerName();

    public abstract String omidPartnerVersion();

    public abstract String playerType();

    public abstract String playerVersion();

    public abstract String ppid();

    public abstract String sessionId();

    public abstract Boolean skippablesSupported();

    public abstract Set<Integer> supportedApiFrameworks();

    public abstract Builder toBuilder();

    public abstract Integer videoPlayerHeight();

    public abstract Integer videoPlayerWidth();

    public abstract Boolean willAdAutoPlay();

    public abstract Boolean willAdPlayMuted();

    public abstract Integer zza();

    public abstract PlatformSignalCollector zzb();
}
