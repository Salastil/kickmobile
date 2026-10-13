package com.google.ads.interactivemedia.pal;

import com.kick.mobile.kickivsplayerv2.BuildConfig;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzc extends zzm {
    private String zza;
    private String zzb;
    private String zzc;

    zzc() {
    }

    @Override // com.google.ads.interactivemedia.pal.zzm
    final zzm zza(String str) {
        this.zza = BuildConfig.PAL_SDK_VERSION;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzm
    final zzm zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzm
    final zzm zzc(String str) {
        if (str == null) {
            throw new NullPointerException("Null correlator");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.pal.zzm
    final zzn zzd() {
        String str;
        String str2;
        String str3 = this.zza;
        if (str3 != null && (str = this.zzb) != null && (str2 = this.zzc) != null) {
            return new zzd(str3, str, str2, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" palVersion");
        }
        if (this.zzb == null) {
            sb.append(" sdkVersion");
        }
        if (this.zzc == null) {
            sb.append(" correlator");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
