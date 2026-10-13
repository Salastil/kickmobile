package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaaa extends zzwr {
    private final zzzz zza;
    private final int zzb;

    private zzaaa(zzzz zzzzVar, int i) {
        this.zza = zzzzVar;
        this.zzb = i;
    }

    public static zzaaa zzb(zzzz zzzzVar, int i) throws GeneralSecurityException {
        if (i < 8 || i > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzaaa(zzzzVar, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaaa)) {
            return false;
        }
        zzaaa zzaaaVar = (zzaaa) obj;
        return zzaaaVar.zza == this.zza && zzaaaVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzaaa.class, this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(i).length() + 1);
        sb.append("X-AES-GCM Parameters (variant: ");
        sb.append(string);
        sb.append("salt_size_bytes: ");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        return this.zza != zzzz.zzb;
    }

    public final zzzz zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }
}
