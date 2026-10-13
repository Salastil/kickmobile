package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfn extends zzfm {
    private final byte[] zzb;

    zzfn(byte[] bArr) {
        super(null);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    protected final int zzc(int i, int i2, int i3) {
        return zzgv.zzb(i, this.zzb, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final int zzd() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    public final zzfp zze(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzj = zzj(0, i2, bArr.length);
        return iZzj == 0 ? zzfp.zza : new zzfj(bArr, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    protected final void zzf(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    final void zzg(zzfg zzfgVar) throws IOException {
        byte[] bArr = this.zzb;
        ((zzfu) zzfgVar).zzc(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfp
    protected final boolean zzh(zzfp zzfpVar) {
        boolean z = zzfpVar instanceof zzfn;
        if (z) {
            return Arrays.equals(this.zzb, ((zzfn) zzfpVar).zzb);
        }
        boolean z2 = zzfpVar instanceof zzfj;
        if (!z2) {
            return zzfpVar.zzh(this);
        }
        byte[] bArr = this.zzb;
        int iZzd = zzfpVar.zzd();
        int length = bArr.length;
        if (length > iZzd) {
            throw new IllegalArgumentException("Length too large: " + length + length);
        }
        if (length <= zzfpVar.zzd()) {
            if (z) {
                return zzfp.zzl(bArr, 0, ((zzfn) zzfpVar).zzb, 0, length);
            }
            if (!z2) {
                return zzfpVar.zze(0, length).equals(zze(0, length));
            }
            zzfj zzfjVar = (zzfj) zzfpVar;
            return zzfp.zzl(bArr, 0, zzfjVar.zzb, zzfjVar.zzc, length);
        }
        throw new IllegalArgumentException("Ran off end of other: 0, " + length + ", " + zzfpVar.zzd());
    }
}
