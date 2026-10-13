package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaah extends zzwr {
    private final zzaag zza;

    private zzaah(zzaag zzaagVar) {
        this.zza = zzaagVar;
    }

    public static zzaah zzb() {
        return new zzaah(zzaag.zzc);
    }

    public static zzaah zzc(zzaag zzaagVar) {
        return new zzaah(zzaagVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzaah) && ((zzaah) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzaah.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 40);
        sb.append("XChaCha20Poly1305 Parameters (variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zza != zzaag.zzc;
    }

    public final zzaag zzd() {
        return this.zza;
    }
}
