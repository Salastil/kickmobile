package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzd extends zzn {
    private final String zza;
    private final String zzb;
    private final String zzc;

    /* synthetic */ zzd(String str, String str2, String str3, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzn) {
            zzn zznVar = (zzn) obj;
            if (this.zza.equals(zznVar.zza()) && this.zzb.equals(zznVar.zzb()) && this.zzc.equals(zznVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        return this.zzc.hashCode() ^ (iHashCode * 1000003);
    }

    public final String toString() {
        String str = this.zza;
        int length = str.length();
        String str2 = this.zzb;
        int length2 = length + 41 + str2.length();
        String str3 = this.zzc;
        StringBuilder sb = new StringBuilder(length2 + 13 + str3.length() + 1);
        sb.append("Gen204LoggerData{palVersion=");
        sb.append(str);
        sb.append(", sdkVersion=");
        sb.append(str2);
        sb.append(", correlator=");
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.pal.zzn
    final String zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.zzn
    final String zzb() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.pal.zzn
    final String zzc() {
        return this.zzc;
    }
}
