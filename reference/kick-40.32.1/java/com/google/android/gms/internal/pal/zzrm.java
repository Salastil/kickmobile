package com.google.android.gms.internal.pal;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrm extends zzro {
    private final zzqx zza;
    private final zzqx zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* synthetic */ zzrm(zzqx zzqxVar, zzqx zzqxVar2, byte[] bArr) {
        super(null);
        this.zza = zzqxVar;
        this.zzb = zzqxVar2;
        int iZza = zzqxVar2.zza();
        zztf.zzb(iZza <= 28, "metadata size too large");
        int[] iArr = new int[iZza];
        this.zzc = iArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            zzpz zzpzVarZzd = zzd(i);
            long jZzi = zzpzVarZzd.zzi() | j;
            if (jZzi == j) {
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        i3 = -1;
                        break;
                    } else if (zzpzVarZzd.equals(zzd(iArr[i3] & 31))) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    iArr[i3] = zzpzVarZzd.zzf() ? iArr[i3] | (1 << (i + 4)) : i;
                } else {
                    iArr[i2] = i;
                    i2++;
                }
            } else {
                iArr[i2] = i;
                i2++;
            }
            i++;
            j = jZzi;
        }
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzpz zzd(int i) {
        zzqx zzqxVar = this.zza;
        int iZza = zzqxVar.zza();
        return i >= iZza ? this.zzb.zzb(i - iZza) : zzqxVar.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final Object zze(int i) {
        zzqx zzqxVar = this.zza;
        int iZza = zzqxVar.zza();
        return i >= iZza ? this.zzb.zzc(i - iZza) : zzqxVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final void zza(zzre zzreVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzpz zzpzVarZzd = zzd(i2 & 31);
            if (zzpzVarZzd.zzf()) {
                zzreVar.zzb(zzpzVarZzd, new zzrl(this, zzpzVarZzd, i2, null), obj);
            } else {
                zzreVar.zza(zzpzVarZzd, zzpzVarZzd.zze(zze(i2)), obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final Set zzc() {
        return new zzrk(this);
    }

    final /* synthetic */ int[] zzf() {
        return this.zzc;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }
}
