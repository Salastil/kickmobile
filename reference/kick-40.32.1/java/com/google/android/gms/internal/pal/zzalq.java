package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalq extends zzalt {
    private final int zza;

    private zzalq(int i) {
        this.zza = i;
    }

    public static zzalq zzb(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            return new zzalq(i);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i * 8)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzalq) && ((zzalq) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzalq.class, Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34);
        sb.append("AesCmac PRF Parameters (");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        throw null;
    }

    public final int zzc() {
        return this.zza;
    }
}
