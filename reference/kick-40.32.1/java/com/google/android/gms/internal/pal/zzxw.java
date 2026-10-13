package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxw extends zzwr {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzxv zzd;

    /* synthetic */ zzxw(int i, int i2, int i3, zzxv zzxvVar, byte[] bArr) {
        this.zza = i;
        this.zzd = zzxvVar;
    }

    public static zzxu zzb() {
        return new zzxu(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxw)) {
            return false;
        }
        zzxw zzxwVar = (zzxw) obj;
        if (zzxwVar.zza == this.zza) {
            int i = zzxwVar.zzb;
            int i2 = zzxwVar.zzc;
            if (zzxwVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzxw.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i).length() + 10);
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", 12-byte IV, 16-byte tag, and ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzd != zzxv.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzxv zzd() {
        return this.zzd;
    }
}
