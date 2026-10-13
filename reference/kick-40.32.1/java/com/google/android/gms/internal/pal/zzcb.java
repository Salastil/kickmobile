package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzcb extends zzby {
    private final String zza;
    private final String zzb;
    private final boolean zzc;

    zzcb(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("Null advertisingId");
        }
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzby) {
            zzby zzbyVar = (zzby) obj;
            if (this.zza.equals(zzbyVar.zza()) && this.zzb.equals(zzbyVar.zzb()) && this.zzc == zzbyVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.zzc ? 1237 : 1231) ^ ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003);
    }

    public final String toString() {
        boolean z = this.zzc;
        int length = String.valueOf(z).length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 76 + length + 1);
        sb.append("AdvertisingIdInfo{advertisingId=");
        sb.append(str);
        sb.append(", advertisingIdType=");
        sb.append(this.zzb);
        sb.append(", isLimitAdTracking=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzby
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzby
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzby
    public final boolean zzc() {
        return this.zzc;
    }
}
