package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakm extends zzakp {
    private final int zza;
    private final int zzb;
    private final zzakl zzc;
    private final zzakk zzd;

    /* synthetic */ zzakm(int i, int i2, zzakl zzaklVar, zzakk zzakkVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzaklVar;
        this.zzd = zzakkVar;
    }

    public static zzakj zzb() {
        return new zzakj(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakm)) {
            return false;
        }
        zzakm zzakmVar = (zzakm) obj;
        return zzakmVar.zza == this.zza && zzakmVar.zze() == zze() && zzakmVar.zzc == this.zzc && zzakmVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzakm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzakk zzakkVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzakkVar);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int i = this.zzb;
        int length3 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 2 + length3 + 16 + String.valueOf(i2).length() + 10);
        sb.append("HMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte tags, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzc != zzakl.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzakl zzaklVar = this.zzc;
        if (zzaklVar == zzakl.zzd) {
            return this.zzb;
        }
        if (zzaklVar == zzakl.zza || zzaklVar == zzakl.zzb || zzaklVar == zzakl.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzakl zzf() {
        return this.zzc;
    }

    public final zzakk zzg() {
        return this.zzd;
    }
}
