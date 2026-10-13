package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzir {
    private static final zzir zza = new zzir(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzir() {
        this(0, new int[8], new Object[8], true);
    }

    private zzir(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzir zzc() {
        return zza;
    }

    static zzir zze(zzir zzirVar, zzir zzirVar2) {
        int i = zzirVar.zzb + zzirVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzirVar.zzc, i);
        System.arraycopy(zzirVar2.zzc, 0, iArrCopyOf, zzirVar.zzb, zzirVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzirVar.zzd, i);
        System.arraycopy(zzirVar2.zzd, 0, objArrCopyOf, zzirVar.zzb, zzirVar2.zzb);
        return new zzir(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzir zzf() {
        return new zzir(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzir)) {
            return false;
        }
        zzir zzirVar = (zzir) obj;
        int i = this.zzb;
        if (i == zzirVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzirVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzirVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzy;
        int iZzz;
        int iZzy2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzy2 = zzfx.zzy(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzfp zzfpVar = (zzfp) this.zzd[i3];
                    int iZzy3 = zzfx.zzy(i7);
                    int iZzd = zzfpVar.zzd();
                    iZzy2 = iZzy3 + zzfx.zzy(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzy4 = zzfx.zzy(i5 << 3);
                    iZzy = iZzy4 + iZzy4;
                    iZzz = ((zzir) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzha("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzy2 = zzfx.zzy(i5 << 3) + 4;
                }
                i2 += iZzy2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzy = zzfx.zzy(i8);
                iZzz = zzfx.zzz(jLongValue);
            }
            iZzy2 = iZzy + iZzz;
            i2 += iZzy2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzy = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzfp zzfpVar = (zzfp) this.zzd[i2];
            int iZzy2 = zzfx.zzy(8);
            int iZzy3 = zzfx.zzy(16) + zzfx.zzy(i3);
            int iZzy4 = zzfx.zzy(24);
            int iZzd = zzfpVar.zzd();
            iZzy += iZzy2 + iZzy2 + iZzy3 + iZzy4 + zzfx.zzy(iZzd) + iZzd;
        }
        this.zze = iZzy;
        return iZzy;
    }

    final zzir zzd(zzir zzirVar) {
        if (zzirVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzirVar.zzb;
        zzm(i);
        System.arraycopy(zzirVar.zzc, 0, this.zzc, this.zzb, zzirVar.zzb);
        System.arraycopy(zzirVar.zzd, 0, this.zzd, this.zzb, zzirVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzht.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzji zzjiVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzjiVar.zzx(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzji zzjiVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzjiVar.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzjiVar.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzjiVar.zzd(i3, (zzfp) obj);
                } else if (i4 == 3) {
                    zzjiVar.zzG(i3);
                    ((zzir) obj).zzl(zzjiVar);
                    zzjiVar.zzh(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(new zzha("Protocol message tag had invalid wire type."));
                    }
                    zzjiVar.zzk(i3, ((Integer) obj).intValue());
                }
            }
        }
    }
}
