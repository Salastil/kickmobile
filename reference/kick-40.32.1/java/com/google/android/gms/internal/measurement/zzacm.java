package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacm extends zzacp {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzacm(byte[] bArr, int i, int i2) {
        super(null);
        zzn(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    public final zzacr zzc(int i, int i2) {
        int iZzn = zzn(i, i2, this.zzd);
        return iZzn == 0 ? zzacr.zza : new zzacm(this.zzb, this.zzc + i, iZzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    final void zze(zzacj zzacjVar) throws IOException {
        zzacjVar.zza(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final boolean zzf(zzacr zzacrVar) {
        boolean z = zzacrVar instanceof zzacq;
        if (!z && !(zzacrVar instanceof zzacm)) {
            return zzacrVar.zzf(this);
        }
        int i = this.zzd;
        if (i > zzacrVar.zzb()) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i).length());
            sb.append("Length too large: ");
            sb.append(i);
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i <= zzacrVar.zzb()) {
            if (z) {
                return zzacr.zzo(this.zzb, this.zzc, ((zzacq) zzacrVar).zzh(), 0, i);
            }
            if (zzacrVar instanceof zzacm) {
                zzacm zzacmVar = (zzacm) zzacrVar;
                return zzacr.zzo(this.zzb, this.zzc, zzacmVar.zzb, zzacmVar.zzc, i);
            }
            zzacr zzacrVarZzc = zzacrVar.zzc(0, i);
            int i2 = this.zzc;
            return zzacrVarZzc.equals(zzc(i2, i + i2));
        }
        int iZzb = zzacrVar.zzb();
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 27 + String.valueOf(iZzb).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iZzb);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzacr
    protected final int zzg(int i, int i2, int i3) {
        return zzaed.zzb(i, this.zzb, this.zzc, i3);
    }

    final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }

    final /* synthetic */ int zzi() {
        return this.zzc;
    }
}
