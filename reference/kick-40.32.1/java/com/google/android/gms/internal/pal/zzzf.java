package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzf extends zzwr {
    private final zzze zza;
    private final String zzb;
    private final zzzd zzc;
    private final zzwr zzd;

    /* synthetic */ zzzf(zzze zzzeVar, String str, zzzd zzzdVar, zzwr zzwrVar, byte[] bArr) {
        this.zza = zzzeVar;
        this.zzb = str;
        this.zzc = zzzdVar;
        this.zzd = zzwrVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzzf)) {
            return false;
        }
        zzzf zzzfVar = (zzzf) obj;
        return zzzfVar.zzc.equals(this.zzc) && zzzfVar.zzd.equals(this.zzd) && zzzfVar.zzb.equals(this.zzb) && zzzfVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzzf.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzze zzzeVar = this.zza;
        zzwr zzwrVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzwrVar);
        String strValueOf3 = String.valueOf(zzzeVar);
        String str = this.zzb;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(strValueOf).length();
        StringBuilder sb = new StringBuilder(length + 64 + length2 + 27 + String.valueOf(strValueOf2).length() + 11 + String.valueOf(strValueOf3).length() + 1);
        sb.append("LegacyKmsEnvelopeAead Parameters (kekUri: ");
        sb.append(str);
        sb.append(", dekParsingStrategy: ");
        sb.append(strValueOf);
        sb.append(", dekParametersForNewKeys: ");
        sb.append(strValueOf2);
        sb.append(", variant: ");
        sb.append(strValueOf3);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zza != zzze.zzb;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzze zzc() {
        return this.zza;
    }

    public final zzwr zzd() {
        return this.zzd;
    }
}
