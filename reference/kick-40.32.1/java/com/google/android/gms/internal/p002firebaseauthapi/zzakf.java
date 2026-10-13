package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzakf extends zzakj {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    protected final int zzb(int i, int i2, int i3) {
        return zzalw.zza(i, this.zzb, this.zzc, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final zzakb zza(int i, int i2) {
        int iZza = zza(i, i2, this.zzd);
        if (iZza == 0) {
            return zzakb.zza;
        }
        return new zzakf(this.zzb, this.zzc + i, iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final zzakn zzb() {
        return zzakn.zza(this.zzb, this.zzc, this.zzd, true);
    }

    zzakf(byte[] bArr, int i, int i2) {
        super();
        zza(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    final void zza(zzakc zzakcVar) throws IOException {
        zzakcVar.zza(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    protected final boolean zza(zzakb zzakbVar) {
        if ((zzakbVar instanceof zzakm) || (zzakbVar instanceof zzakf)) {
            return zza(zzakbVar, 0, zza());
        }
        return zzakbVar.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakj
    final boolean zza(zzakb zzakbVar, int i, int i2) {
        if (i2 > zzakbVar.zza()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zza());
        }
        if (i2 > zzakbVar.zza()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzakbVar.zza());
        }
        if (zzakbVar instanceof zzakm) {
            return zzakb.zza(this.zzb, this.zzc, ((zzakm) zzakbVar).zzb, 0, i2);
        }
        if (zzakbVar instanceof zzakf) {
            zzakf zzakfVar = (zzakf) zzakbVar;
            return zzakb.zza(this.zzb, this.zzc, zzakfVar.zzb, zzakfVar.zzc, i2);
        }
        zzakb zzakbVarZza = zzakbVar.zza(0, i2);
        int i3 = this.zzc;
        return zzakbVarZza.equals(zza(i3, i2 + i3));
    }
}
