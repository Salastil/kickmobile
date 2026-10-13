package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarq {
    private final byte[] zza;

    private zzarq(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzarq zza(byte[] bArr) {
        if (bArr != null) {
            return new zzarq(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzarq) {
            return Arrays.equals(((zzarq) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String strZza = zzarg.zza(this.zza);
        StringBuilder sb = new StringBuilder(strZza.length() + 7);
        sb.append("Bytes(");
        sb.append(strZza);
        sb.append(")");
        return sb.toString();
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final int zzc() {
        return this.zza.length;
    }
}
