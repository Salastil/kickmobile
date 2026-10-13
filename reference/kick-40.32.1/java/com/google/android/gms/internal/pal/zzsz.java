package com.google.android.gms.internal.pal;

import androidx.media3.muxer.WebmConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsz extends zztd {
    private static final zztd zza = new zzsz();

    private zzsz() {
    }

    public static zztd zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.pal.zztd
    public final int zzb(zzta zztaVar, int i, String str, int i2, int i3, int i4) throws zztc {
        zzsv zzsvVarZza;
        char cCharAt = str.charAt(i4);
        zzqo zzqoVarZzb = zzqo.zzb(str, i3, i4, (cCharAt & ' ') == 0);
        zzqn zzqnVarZza = zzqn.zza(cCharAt);
        int i5 = i4 + 1;
        if (zzqnVarZza != null) {
            if (!zzqoVarZzb.zzi(zzqnVarZza)) {
                throw zztc.zza("invalid format specifier", str, i2, i5);
            }
            zzsvVarZza = zzsx.zza(i, zzqnVarZza, zzqoVarZzb);
        } else if (cCharAt == 't' || cCharAt == 'T') {
            if (!zzqoVarZzb.zzh(WebmConstants.MkvEbmlElement.BLOCK_GROUP, false)) {
                throw zztc.zza("invalid format specification", str, i2, i5);
            }
            int i6 = i4 + 2;
            if (i6 > str.length()) {
                throw zztc.zzb("truncated format specifier", str, i2);
            }
            zzst zzstVarZza = zzst.zza(str.charAt(i5));
            if (zzstVarZza == null) {
                throw zztc.zzb("illegal date/time conversion", str, i5);
            }
            zzsvVarZza = zzsu.zza(zzstVarZza, zzqoVarZzb, i);
            i5 = i6;
        } else {
            if (cCharAt != 'h' && cCharAt != 'H') {
                throw zztc.zza("invalid format specification", str, i2, i5);
            }
            if (!zzqoVarZzb.zzh(WebmConstants.MkvEbmlElement.BLOCK_GROUP, false)) {
                throw zztc.zza("invalid format specification", str, i2, i5);
            }
            zzsvVarZza = new zzsy(zzqoVarZzb, i, zzqoVarZzb);
        }
        zztaVar.zzk(i2, i5, zzsvVarZza);
        return i5;
    }
}
