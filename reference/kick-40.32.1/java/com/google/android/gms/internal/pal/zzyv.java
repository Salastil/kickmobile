package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyv extends zzwr {
    private final String zza;
    private final zzyu zzb;

    private zzyv(String str, zzyu zzyuVar) {
        this.zza = str;
        this.zzb = zzyuVar;
    }

    public static zzyv zzb(String str, zzyu zzyuVar) {
        return new zzyv(str, zzyuVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzyv)) {
            return false;
        }
        zzyv zzyvVar = (zzyv) obj;
        return zzyvVar.zza.equals(this.zza) && zzyvVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzyv.class, this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + string.length() + 1);
        sb.append("LegacyKmsAead Parameters (keyUri: ");
        sb.append(str);
        sb.append(", variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzb != zzyu.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    public final zzyu zzd() {
        return this.zzb;
    }
}
