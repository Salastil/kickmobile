package com.google.android.gms.internal.pal;

import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzur {
    private final ByteArrayInputStream zza;
    private int zzb;
    private int zzc;

    public zzur(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.zza = byteArrayInputStream;
        this.zzb = byteArrayInputStream.read();
        this.zzc = 8;
    }

    public final int zza(int i) {
        zzls.zzb(i >= 0 && i <= 32, "numBits must be >= 0 && <= 32");
        int i2 = 0;
        while (true) {
            int i3 = this.zzc;
            if (i <= i3) {
                int i4 = i3 - i;
                this.zzc = i4;
                int i5 = this.zzb;
                int i6 = (i5 >> i4) | i2;
                this.zzb = i5 & (255 >> (8 - i4));
                return i6;
            }
            i -= i3;
            i2 |= this.zzb << i;
            ByteArrayInputStream byteArrayInputStream = this.zza;
            zzls.zzg(byteArrayInputStream.available() != 0, "Reading past end of bytestream.");
            this.zzb = byteArrayInputStream.read();
            this.zzc = 8;
        }
    }

    public final int zzb() {
        return (this.zza.available() * 8) + this.zzc;
    }
}
