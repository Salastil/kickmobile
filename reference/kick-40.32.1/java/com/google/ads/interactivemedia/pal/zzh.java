package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzck;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzh extends zzt {
    private final zzck zza;
    private final zzck zzb;
    private final zzck zzc;
    private final zzck zzd;
    private final zzck zze;
    private final int zzf;

    /* synthetic */ zzh(zzck zzckVar, zzck zzckVar2, zzck zzckVar3, zzck zzckVar4, zzck zzckVar5, int i, byte[] bArr) {
        this.zza = zzckVar;
        this.zzb = zzckVar2;
        this.zzc = zzckVar3;
        this.zzd = zzckVar4;
        this.zze = zzckVar5;
        this.zzf = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzt) {
            zzt zztVar = (zzt) obj;
            if (this.zza.equals(zztVar.zza()) && this.zzb.equals(zztVar.zzb()) && this.zzc.equals(zztVar.zzc()) && this.zzd.equals(zztVar.zzd()) && this.zze.equals(zztVar.zze()) && this.zzf == zztVar.zzf()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzf ^ ((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        int length2 = string2.length();
        String string3 = this.zzc.toString();
        int length3 = string3.length();
        String string4 = this.zzd.toString();
        int length4 = string4.length();
        String string5 = this.zze.toString();
        int length5 = string5.length();
        int i = this.zzf;
        StringBuilder sb = new StringBuilder(length + 55 + length2 + 18 + length3 + 25 + length4 + 23 + length5 + 14 + String.valueOf(i).length() + 1);
        sb.append("NonceTimingData{nonceLoaderInitTime=");
        sb.append(string);
        sb.append(", nonceRequestTime=");
        sb.append(string2);
        sb.append(", nonceLoadedTime=");
        sb.append(string3);
        sb.append(", resourceFetchStartTime=");
        sb.append(string4);
        sb.append(", resourceFetchEndTime=");
        sb.append(string5);
        sb.append(", nonceLength=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final zzck zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final zzck zzb() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final zzck zzc() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final zzck zzd() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final zzck zze() {
        return this.zze;
    }

    @Override // com.google.ads.interactivemedia.pal.zzt
    final int zzf() {
        return this.zzf;
    }
}
