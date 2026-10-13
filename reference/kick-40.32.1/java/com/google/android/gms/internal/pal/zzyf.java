package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyf extends zzwr {
    private final int zza;
    private final zzye zzb;

    /* synthetic */ zzyf(int i, zzye zzyeVar, byte[] bArr) {
        this.zza = i;
        this.zzb = zzyeVar;
    }

    public static zzyd zzb() {
        return new zzyd(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzyf)) {
            return false;
        }
        zzyf zzyfVar = (zzyf) obj;
        return zzyfVar.zza == this.zza && zzyfVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzyf.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = String.valueOf(strValueOf).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i).length() + 10);
        sb.append("AesGcmSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzb != zzye.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzye zzd() {
        return this.zzb;
    }
}
