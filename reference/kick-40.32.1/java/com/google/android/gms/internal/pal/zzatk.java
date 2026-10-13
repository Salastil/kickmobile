package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatk extends zzatj {
    private final byte[] zzb;

    zzatk(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzy = zzy(i, i2, bArr.length);
        return iZzy == 0 ? zzatl.zza : new zzath(bArr, i, iZzy);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzd(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzy = zzy(i, i2, bArr.length);
        return iZzy == 0 ? zzatl.zza : new zzath(bArr, i, iZzy);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final void zzg(zzate zzateVar) throws IOException {
        byte[] bArr = this.zzb;
        ((zzatr) zzateVar).zzr(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final boolean zzh(zzatl zzatlVar) {
        if (zzatlVar instanceof zzatk) {
            return Arrays.equals(this.zzb, ((zzatk) zzatlVar).zzb);
        }
        return zzatlVar instanceof zzath ? zzi(zzatlVar, 0, this.zzb.length) : zzatlVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.pal.zzatj
    final boolean zzi(zzatl zzatlVar, int i, int i2) {
        if (i2 > zzatlVar.zzb()) {
            byte[] bArr = this.zzb;
            int length = String.valueOf(i2).length();
            int length2 = bArr.length;
            StringBuilder sb = new StringBuilder(length + 18 + String.valueOf(length2).length());
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 <= zzatlVar.zzb()) {
            if (zzatlVar instanceof zzatk) {
                return zzatl.zzz(this.zzb, 0, ((zzatk) zzatlVar).zzb, i, i2);
            }
            if (!(zzatlVar instanceof zzath)) {
                return zzatlVar.zzd(i, i3).equals(zzd(0, i2));
            }
            zzath zzathVar = (zzath) zzatlVar;
            return zzatl.zzz(this.zzb, 0, zzathVar.zzl(), zzathVar.zzm() + i, i2);
        }
        int iZzb = zzatlVar.zzb();
        int length3 = String.valueOf(i).length();
        StringBuilder sb2 = new StringBuilder(length3 + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzb).length());
        sb2.append("Ran off end of other: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(iZzb);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final int zzj(int i, int i2, int i3) {
        return zzauz.zzb(i, this.zzb, i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatp zzk() {
        byte[] bArr = this.zzb;
        return zzatp.zzE(bArr, 0, bArr.length, true);
    }

    final /* synthetic */ byte[] zzl() {
        return this.zzb;
    }
}
