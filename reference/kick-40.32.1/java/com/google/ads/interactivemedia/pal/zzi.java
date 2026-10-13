package com.google.ads.interactivemedia.pal;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzi extends NonceRequest.Builder {
    private Boolean zza;
    private Boolean zzb;
    private Integer zzc;
    private Integer zzd;
    private Integer zze;
    private Boolean zzf;
    private Boolean zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private PlatformSignalCollector zzn;
    private Boolean zzo;
    private Set zzp;
    private String zzq;

    zzi() {
    }

    zzi(NonceRequest nonceRequest) {
        this.zza = nonceRequest.continuousPlayback();
        this.zzb = nonceRequest.iconsSupported();
        this.zzc = nonceRequest.zza();
        this.zzd = nonceRequest.videoPlayerHeight();
        this.zze = nonceRequest.videoPlayerWidth();
        this.zzf = nonceRequest.willAdPlayMuted();
        this.zzg = nonceRequest.willAdAutoPlay();
        this.zzh = nonceRequest.descriptionURL();
        this.zzi = nonceRequest.omidPartnerName();
        this.zzj = nonceRequest.omidPartnerVersion();
        this.zzk = nonceRequest.playerType();
        this.zzl = nonceRequest.playerVersion();
        this.zzm = nonceRequest.ppid();
        this.zzn = nonceRequest.zzb();
        this.zzo = nonceRequest.skippablesSupported();
        this.zzp = nonceRequest.supportedApiFrameworks();
        this.zzq = nonceRequest.sessionId();
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest build() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Boolean bool;
        Set set;
        String str6;
        String str7 = this.zzh;
        if (str7 != null && (str = this.zzi) != null && (str2 = this.zzj) != null && (str3 = this.zzk) != null && (str4 = this.zzl) != null && (str5 = this.zzm) != null && (bool = this.zzo) != null && (set = this.zzp) != null && (str6 = this.zzq) != null) {
            return new AutoValue_NonceRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, str7, str, str2, str3, str4, str5, this.zzn, bool, set, str6, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zzh == null) {
            sb.append(" descriptionURL");
        }
        if (this.zzi == null) {
            sb.append(" omidPartnerName");
        }
        if (this.zzj == null) {
            sb.append(" omidPartnerVersion");
        }
        if (this.zzk == null) {
            sb.append(" playerType");
        }
        if (this.zzl == null) {
            sb.append(" playerVersion");
        }
        if (this.zzm == null) {
            sb.append(" ppid");
        }
        if (this.zzo == null) {
            sb.append(" skippablesSupported");
        }
        if (this.zzp == null) {
            sb.append(" supportedApiFrameworks");
        }
        if (this.zzq == null) {
            sb.append(" sessionId");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder continuousPlayback(Boolean bool) {
        this.zza = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder descriptionURL(String str) {
        if (str == null) {
            throw new NullPointerException("Null descriptionURL");
        }
        this.zzh = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder iconsSupported(Boolean bool) {
        this.zzb = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder nonceLengthLimit(Integer num) {
        this.zzc = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder omidPartnerName(String str) {
        if (str == null) {
            throw new NullPointerException("Null omidPartnerName");
        }
        this.zzi = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder omidPartnerVersion(String str) {
        if (str == null) {
            throw new NullPointerException("Null omidPartnerVersion");
        }
        this.zzj = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder platformSignalCollector(PlatformSignalCollector platformSignalCollector) {
        this.zzn = platformSignalCollector;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder playerType(String str) {
        if (str == null) {
            throw new NullPointerException("Null playerType");
        }
        this.zzk = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder playerVersion(String str) {
        if (str == null) {
            throw new NullPointerException("Null playerVersion");
        }
        this.zzl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder ppid(String str) {
        if (str == null) {
            throw new NullPointerException("Null ppid");
        }
        this.zzm = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder sessionId(String str) {
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.zzq = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder skippablesSupported(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null skippablesSupported");
        }
        this.zzo = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder supportedApiFrameworks(Set<Integer> set) {
        if (set == null) {
            throw new NullPointerException("Null supportedApiFrameworks");
        }
        this.zzp = set;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder videoPlayerHeight(Integer num) {
        this.zzd = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder videoPlayerWidth(Integer num) {
        this.zze = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder willAdAutoPlay(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest.Builder
    public final NonceRequest.Builder willAdPlayMuted(Boolean bool) {
        this.zzf = bool;
        return this;
    }
}
