package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxf extends zzwr {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzxe zze;
    private final zzxd zzf;

    /* synthetic */ zzxf(int i, int i2, int i3, int i4, zzxe zzxeVar, zzxd zzxdVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzxeVar;
        this.zzf = zzxdVar;
    }

    public static zzxc zzb() {
        return new zzxc(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxf)) {
            return false;
        }
        zzxf zzxfVar = (zzxf) obj;
        return zzxfVar.zza == this.zza && zzxfVar.zzb == this.zzb && zzxfVar.zzc == this.zzc && zzxfVar.zzd == this.zzd && zzxfVar.zze == this.zze && zzxfVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzxf.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzxd zzxdVar = this.zzf;
        String strValueOf = String.valueOf(this.zze);
        String strValueOf2 = String.valueOf(zzxdVar);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int i = this.zzc;
        int length3 = String.valueOf(i).length();
        int i2 = this.zzd;
        int length4 = String.valueOf(i2).length();
        int i3 = this.zza;
        int length5 = String.valueOf(i3).length();
        int i4 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 2 + length3 + 14 + length4 + 16 + length5 + 19 + String.valueOf(i4).length() + 15);
        sb.append("AesCtrHmacAead Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte IV, and ");
        sb.append(i2);
        sb.append("-byte tags, and ");
        sb.append(i3);
        sb.append("-byte AES key, and ");
        sb.append(i4);
        sb.append("-byte HMAC key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zze != zzxe.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzc;
    }

    public final zzxe zzg() {
        return this.zze;
    }

    public final zzxd zzh() {
        return this.zzf;
    }
}
