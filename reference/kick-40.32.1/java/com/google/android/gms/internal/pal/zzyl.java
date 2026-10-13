package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyl extends zzwr {
    private final zzyk zza;

    private zzyl(zzyk zzykVar) {
        this.zza = zzykVar;
    }

    public static zzyl zzb(zzyk zzykVar) {
        return new zzyl(zzykVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzyl) && ((zzyl) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzyl.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 39);
        sb.append("ChaCha20Poly1305 Parameters (variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zza != zzyk.zzc;
    }

    public final zzyk zzc() {
        return this.zza;
    }
}
