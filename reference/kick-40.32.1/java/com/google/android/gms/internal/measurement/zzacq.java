package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacq extends zzacp {
    private final byte[] zzb;

    zzacq(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final zzacr zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzn = zzn(0, i2, bArr.length);
        return iZzn == 0 ? zzacr.zza : new zzacm(bArr, 0, iZzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    final void zze(zzacj zzacjVar) throws IOException {
        byte[] bArr = this.zzb;
        zzacjVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final boolean zzf(zzacr zzacrVar) {
        boolean z = zzacrVar instanceof zzacq;
        if (z) {
            return Arrays.equals(this.zzb, ((zzacq) zzacrVar).zzb);
        }
        boolean z2 = zzacrVar instanceof zzacm;
        if (!z2) {
            return zzacrVar.zzf(this);
        }
        byte[] bArr = this.zzb;
        int iZzb = zzacrVar.zzb();
        int length = bArr.length;
        if (length > iZzb) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 18 + String.valueOf(length).length());
            sb.append("Length too large: ");
            sb.append(length);
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length <= zzacrVar.zzb()) {
            if (z) {
                return zzacr.zzo(bArr, 0, ((zzacq) zzacrVar).zzb, 0, length);
            }
            if (!z2) {
                return zzacrVar.zzc(0, length).equals(zzc(0, length));
            }
            zzacm zzacmVar = (zzacm) zzacrVar;
            return zzacr.zzo(bArr, 0, zzacmVar.zzh(), zzacmVar.zzi(), length);
        }
        int iZzb2 = zzacrVar.zzb();
        StringBuilder sb2 = new StringBuilder(String.valueOf(length).length() + 27 + String.valueOf(iZzb2).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(length);
        sb2.append(", ");
        sb2.append(iZzb2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final int zzg(int i, int i2, int i3) {
        return zzaed.zzb(i, this.zzb, 0, i3);
    }

    final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }
}
