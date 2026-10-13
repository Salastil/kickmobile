package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajy extends zzakp {
    private final int zza;
    private final int zzb;
    private final zzajx zzc;

    /* synthetic */ zzajy(int i, int i2, zzajx zzajxVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzajxVar;
    }

    public static zzajw zzb() {
        return new zzajw(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzajy)) {
            return false;
        }
        zzajy zzajyVar = (zzajy) obj;
        return zzajyVar.zza == this.zza && zzajyVar.zze() == zze() && zzajyVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzajy.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int length = String.valueOf(strValueOf).length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 16 + String.valueOf(i2).length() + 10);
        sb.append("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte tags, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzc != zzajx.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzajx zzajxVar = this.zzc;
        if (zzajxVar == zzajx.zzd) {
            return this.zzb;
        }
        if (zzajxVar == zzajx.zza || zzajxVar == zzajx.zzb || zzajxVar == zzajx.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzajx zzf() {
        return this.zzc;
    }
}
