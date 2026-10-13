package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzath extends zzatj {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzath(byte[] bArr, int i, int i2) {
        super(null);
        zzy(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzc(int i, int i2) {
        int iZzy = zzy(i, i2, this.zzd);
        return iZzy == 0 ? zzatl.zza : new zzath(this.zzb, this.zzc + i, iZzy);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzd(int i, int i2) {
        int iZzy = zzy(i, i2, this.zzd);
        return iZzy == 0 ? zzatl.zza : new zzath(this.zzb, this.zzc + i, iZzy);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc + i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb, this.zzc, this.zzd).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final void zzg(zzate zzateVar) throws IOException {
        ((zzatr) zzateVar).zzr(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final boolean zzh(zzatl zzatlVar) {
        return ((zzatlVar instanceof zzatk) || (zzatlVar instanceof zzath)) ? zzi(zzatlVar, 0, this.zzd) : zzatlVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.pal.zzatj
    final boolean zzi(zzatl zzatlVar, int i, int i2) {
        if (i2 > zzatlVar.zzb()) {
            int i3 = this.zzd;
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(i3).length());
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = i + i2;
        if (i4 <= zzatlVar.zzb()) {
            if (zzatlVar instanceof zzatk) {
                return zzatl.zzz(this.zzb, this.zzc, ((zzatk) zzatlVar).zzl(), i, i2);
            }
            if (zzatlVar instanceof zzath) {
                zzath zzathVar = (zzath) zzatlVar;
                return zzatl.zzz(this.zzb, this.zzc, zzathVar.zzb, zzathVar.zzc + i, i2);
            }
            zzatl zzatlVarZzd = zzatlVar.zzd(i, i4);
            int i5 = this.zzc;
            return zzatlVarZzd.equals(zzd(i5, i2 + i5));
        }
        int iZzb = zzatlVar.zzb();
        int length = String.valueOf(i).length();
        StringBuilder sb2 = new StringBuilder(length + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzb).length());
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
        return zzauz.zzb(i, this.zzb, this.zzc + i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatp zzk() {
        return zzatp.zzE(this.zzb, this.zzc, this.zzd, true);
    }

    final /* synthetic */ byte[] zzl() {
        return this.zzb;
    }

    final /* synthetic */ int zzm() {
        return this.zzc;
    }
}
