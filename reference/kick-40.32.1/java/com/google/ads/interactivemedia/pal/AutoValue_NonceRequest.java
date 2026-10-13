package com.google.ads.interactivemedia.pal;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_NonceRequest extends NonceRequest {
    private final Boolean zza;
    private final Boolean zzb;
    private final Integer zzc;
    private final Integer zzd;
    private final Integer zze;
    private final Boolean zzf;
    private final Boolean zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;
    private final String zzm;
    private final PlatformSignalCollector zzn;
    private final Boolean zzo;
    private final Set zzp;
    private final String zzq;

    /* synthetic */ AutoValue_NonceRequest(Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, String str, String str2, String str3, String str4, String str5, String str6, PlatformSignalCollector platformSignalCollector, Boolean bool5, Set set, String str7, byte[] bArr) {
        this.zza = bool;
        this.zzb = bool2;
        this.zzc = num;
        this.zzd = num2;
        this.zze = num3;
        this.zzf = bool3;
        this.zzg = bool4;
        this.zzh = str;
        this.zzi = str2;
        this.zzj = str3;
        this.zzk = str4;
        this.zzl = str5;
        this.zzm = str6;
        this.zzn = platformSignalCollector;
        this.zzo = bool5;
        this.zzp = set;
        this.zzq = str7;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Boolean continuousPlayback() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String descriptionURL() {
        return this.zzh;
    }

    public final boolean equals(Object obj) {
        PlatformSignalCollector platformSignalCollector;
        if (obj == this) {
            return true;
        }
        if (obj instanceof NonceRequest) {
            NonceRequest nonceRequest = (NonceRequest) obj;
            Boolean bool = this.zza;
            if (bool != null ? bool.equals(nonceRequest.continuousPlayback()) : nonceRequest.continuousPlayback() == null) {
                Boolean bool2 = this.zzb;
                if (bool2 != null ? bool2.equals(nonceRequest.iconsSupported()) : nonceRequest.iconsSupported() == null) {
                    Integer num = this.zzc;
                    if (num != null ? num.equals(nonceRequest.zza()) : nonceRequest.zza() == null) {
                        Integer num2 = this.zzd;
                        if (num2 != null ? num2.equals(nonceRequest.videoPlayerHeight()) : nonceRequest.videoPlayerHeight() == null) {
                            Integer num3 = this.zze;
                            if (num3 != null ? num3.equals(nonceRequest.videoPlayerWidth()) : nonceRequest.videoPlayerWidth() == null) {
                                Boolean bool3 = this.zzf;
                                if (bool3 != null ? bool3.equals(nonceRequest.willAdPlayMuted()) : nonceRequest.willAdPlayMuted() == null) {
                                    Boolean bool4 = this.zzg;
                                    if (bool4 != null ? bool4.equals(nonceRequest.willAdAutoPlay()) : nonceRequest.willAdAutoPlay() == null) {
                                        if (this.zzh.equals(nonceRequest.descriptionURL()) && this.zzi.equals(nonceRequest.omidPartnerName()) && this.zzj.equals(nonceRequest.omidPartnerVersion()) && this.zzk.equals(nonceRequest.playerType()) && this.zzl.equals(nonceRequest.playerVersion()) && this.zzm.equals(nonceRequest.ppid()) && ((platformSignalCollector = this.zzn) != null ? platformSignalCollector.equals(nonceRequest.zzb()) : nonceRequest.zzb() == null) && this.zzo.equals(nonceRequest.skippablesSupported()) && this.zzp.equals(nonceRequest.supportedApiFrameworks()) && this.zzq.equals(nonceRequest.sessionId())) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Boolean iconsSupported() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String omidPartnerName() {
        return this.zzi;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String omidPartnerVersion() {
        return this.zzj;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String playerType() {
        return this.zzk;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String playerVersion() {
        return this.zzl;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String ppid() {
        return this.zzm;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final String sessionId() {
        return this.zzq;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public Boolean skippablesSupported() {
        return this.zzo;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Set<Integer> supportedApiFrameworks() {
        return this.zzp;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final NonceRequest.Builder toBuilder() {
        return new zzi(this);
    }

    public final String toString() {
        Set set = this.zzp;
        String strValueOf = String.valueOf(this.zzn);
        String string = set.toString();
        Boolean bool = this.zza;
        int length = String.valueOf(bool).length();
        Boolean bool2 = this.zzb;
        int length2 = String.valueOf(bool2).length();
        Integer num = this.zzc;
        int length3 = String.valueOf(num).length();
        Integer num2 = this.zzd;
        int length4 = String.valueOf(num2).length();
        Integer num3 = this.zze;
        int length5 = String.valueOf(num3).length();
        Boolean bool3 = this.zzf;
        int length6 = String.valueOf(bool3).length();
        Boolean bool4 = this.zzg;
        int length7 = String.valueOf(bool4).length();
        int length8 = String.valueOf(strValueOf).length();
        Boolean bool5 = this.zzo;
        int length9 = bool5.toString().length();
        int length10 = string.length();
        int i = length + 49 + length2 + 19 + length3 + 20 + length4 + 19 + length5 + 18 + length6;
        String str = this.zzi;
        String str2 = this.zzh;
        int length11 = i + 17 + length7 + 17 + str2.length() + 18 + str.length();
        String str3 = this.zzj;
        int length12 = length11 + 21 + str3.length();
        String str4 = this.zzk;
        int length13 = length12 + 13 + str4.length();
        String str5 = this.zzl;
        int length14 = length13 + 16 + str5.length();
        String str6 = this.zzm;
        int length15 = length14 + 7 + str6.length() + 26 + length8 + 22 + length9 + 25 + length10 + 12;
        String str7 = this.zzq;
        StringBuilder sb = new StringBuilder(length15 + str7.length() + 1);
        sb.append("NonceRequest{continuousPlayback=");
        sb.append(bool);
        sb.append(", iconsSupported=");
        sb.append(bool2);
        sb.append(", nonceLengthLimit=");
        sb.append(num);
        sb.append(", videoPlayerHeight=");
        sb.append(num2);
        sb.append(", videoPlayerWidth=");
        sb.append(num3);
        sb.append(", willAdPlayMuted=");
        sb.append(bool3);
        sb.append(", willAdAutoPlay=");
        sb.append(bool4);
        sb.append(", descriptionURL=");
        sb.append(str2);
        sb.append(", omidPartnerName=");
        sb.append(str);
        sb.append(", omidPartnerVersion=");
        sb.append(str3);
        sb.append(", playerType=");
        sb.append(str4);
        sb.append(", playerVersion=");
        sb.append(str5);
        sb.append(", ppid=");
        sb.append(str6);
        sb.append(", platformSignalCollector=");
        sb.append(strValueOf);
        sb.append(", skippablesSupported=");
        sb.append(bool5);
        sb.append(", supportedApiFrameworks=");
        sb.append(string);
        sb.append(", sessionId=");
        sb.append(str7);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Integer videoPlayerHeight() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Integer videoPlayerWidth() {
        return this.zze;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Boolean willAdAutoPlay() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Boolean willAdPlayMuted() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final Integer zza() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.pal.NonceRequest
    public final PlatformSignalCollector zzb() {
        return this.zzn;
    }

    public final int hashCode() {
        Boolean bool = this.zza;
        int iHashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.zzb;
        int iHashCode2 = bool2 == null ? 0 : bool2.hashCode();
        int i = iHashCode ^ 1000003;
        Integer num = this.zzc;
        int iHashCode3 = ((((i * 1000003) ^ iHashCode2) * 1000003) ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.zzd;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Integer num3 = this.zze;
        int iHashCode5 = (iHashCode4 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Boolean bool3 = this.zzf;
        int iHashCode6 = (iHashCode5 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Boolean bool4 = this.zzg;
        int iHashCode7 = (((((((((((((iHashCode6 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003) ^ this.zzh.hashCode()) * 1000003) ^ this.zzi.hashCode()) * 1000003) ^ this.zzj.hashCode()) * 1000003) ^ this.zzk.hashCode()) * 1000003) ^ this.zzl.hashCode()) * 1000003) ^ this.zzm.hashCode()) * 1000003;
        PlatformSignalCollector platformSignalCollector = this.zzn;
        return this.zzq.hashCode() ^ ((((((iHashCode7 ^ (platformSignalCollector != null ? platformSignalCollector.hashCode() : 0)) * 1000003) ^ this.zzo.hashCode()) * 1000003) ^ this.zzp.hashCode()) * 1000003);
    }
}
