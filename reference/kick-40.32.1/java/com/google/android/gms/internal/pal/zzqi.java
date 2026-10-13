package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqi implements zzpr {
    private final zzpr zza;
    private final Object zzb;

    private zzqi(zzpr zzprVar, Object obj) {
        zztf.zza(zzprVar, "log site key");
        this.zza = zzprVar;
        zztf.zza(obj, "log site qualifier");
        this.zzb = obj;
    }

    static zzpr zza(zzpr zzprVar, Object obj) {
        return new zzqi(zzprVar, obj);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqi)) {
            return false;
        }
        zzqi zzqiVar = (zzqi) obj;
        return this.zza.equals(zzqiVar.zza) && this.zzb.equals(zzqiVar.zzb);
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(length + 47 + string2.length() + 3);
        sb.append("SpecializedLogSiteKey{ delegate='");
        sb.append(string);
        sb.append("', qualifier='");
        sb.append(string2);
        sb.append("' }");
        return sb.toString();
    }
}
