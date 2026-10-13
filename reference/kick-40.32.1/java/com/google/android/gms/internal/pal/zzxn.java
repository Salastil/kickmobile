package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxn extends zzwr {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzxm zzd;

    /* synthetic */ zzxn(int i, int i2, int i3, zzxm zzxmVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzxmVar;
    }

    public static zzxl zzb() {
        return new zzxl(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxn)) {
            return false;
        }
        zzxn zzxnVar = (zzxn) obj;
        if (zzxnVar.zza == this.zza && zzxnVar.zzb == this.zzb) {
            int i = zzxnVar.zzc;
            if (zzxnVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzxn.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = String.valueOf(strValueOf).length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int length3 = String.valueOf(16).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i2).length() + 10);
        sb.append("AesEax Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte IV, 16-byte tag, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzd != zzxm.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final zzxm zze() {
        return this.zzd;
    }
}
