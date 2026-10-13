package com.google.android.gms.internal.cast;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
class zzxj extends zzxi {
    protected final byte[] zza;

    zzxj(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzxk) || zzc() != ((zzxk) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzxj)) {
            return obj.equals(this);
        }
        zzxj zzxjVar = (zzxj) obj;
        int iZzh = zzh();
        int iZzh2 = zzxjVar.zzh();
        if (iZzh != 0 && iZzh2 != 0 && iZzh != iZzh2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzxjVar.zzc()) {
            int iZzc2 = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 18 + String.valueOf(iZzc2).length());
            sb.append("Length too large: ");
            sb.append(iZzc);
            sb.append(iZzc2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iZzc > zzxjVar.zzc()) {
            int iZzc3 = zzxjVar.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzc).length() + 27 + String.valueOf(iZzc3).length());
            sb2.append("Ran off end of other: 0, ");
            sb2.append(iZzc);
            sb2.append(", ");
            sb2.append(iZzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzxjVar instanceof zzxj)) {
            return zzxjVar.zze(0, iZzc).equals(zze(0, iZzc));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzxjVar.zza;
        zzxjVar.zzd();
        int i = 0;
        int i2 = 0;
        while (i < iZzc) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    public final zzxk zze(int i, int i2) {
        zzi(0, i2, zzc());
        return i2 == 0 ? zzxk.zzb : new zzxg(this.zza, 0, i2);
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    final void zzf(zzxd zzxdVar) throws IOException {
        ((zzxn) zzxdVar).zzs(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.cast.zzxk
    protected final int zzg(int i, int i2, int i3) {
        return zzym.zzc(i, this.zza, 0, i3);
    }
}
