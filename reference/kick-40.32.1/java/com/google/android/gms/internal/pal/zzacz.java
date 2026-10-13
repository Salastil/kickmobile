package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacz extends zzadc {
    private final int zza;
    private final zzacy zzb;

    /* synthetic */ zzacz(int i, zzacy zzacyVar, byte[] bArr) {
        this.zza = i;
        this.zzb = zzacyVar;
    }

    public static zzacx zzb() {
        return new zzacx(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzacz)) {
            return false;
        }
        zzacz zzaczVar = (zzacz) obj;
        return zzaczVar.zza == this.zza && zzaczVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzacz.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = String.valueOf(strValueOf).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + String.valueOf(i).length() + 10);
        sb.append("AesSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zzb != zzacy.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzacy zzd() {
        return this.zzb;
    }
}
