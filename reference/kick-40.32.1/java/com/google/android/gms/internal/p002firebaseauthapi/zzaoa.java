package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoa {
    private static final zzaoa zza = new zzaoa(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public final int zza() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzaky.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                ((Long) this.zzd[i3]).longValue();
                iZze = zzaky.zzd(i5 << 3) + 8;
            } else if (i6 == 2) {
                iZze = zzaky.zzc(i5, (zzakb) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzaky.zzd(i5 << 3) << 1) + ((zzaoa) this.zzd[i3]).zza();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzamd.zza());
                }
                ((Integer) this.zzd[i3]).intValue();
                iZze = zzaky.zzd(i5 << 3) + 4;
            }
            i2 += iZze;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzd += (zzaky.zzd(8) << 1) + zzaky.zzh(2, this.zzc[i2] >>> 3) + zzaky.zzc(3, (zzakb) this.zzd[i2]);
        }
        this.zze = iZzd;
        return iZzd;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public static zzaoa zzc() {
        return zza;
    }

    final zzaoa zza(zzaoa zzaoaVar) {
        if (zzaoaVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzaoaVar.zzb;
        zza(i);
        System.arraycopy(zzaoaVar.zzc, 0, this.zzc, this.zzb, zzaoaVar.zzb);
        System.arraycopy(zzaoaVar.zzd, 0, this.zzd, this.zzb, zzaoaVar.zzb);
        this.zzb = i;
        return this;
    }

    static zzaoa zza(zzaoa zzaoaVar, zzaoa zzaoaVar2) {
        int i = zzaoaVar.zzb + zzaoaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaoaVar.zzc, i);
        System.arraycopy(zzaoaVar2.zzc, 0, iArrCopyOf, zzaoaVar.zzb, zzaoaVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaoaVar.zzd, i);
        System.arraycopy(zzaoaVar2.zzd, 0, objArrCopyOf, zzaoaVar.zzb, zzaoaVar2.zzb);
        return new zzaoa(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzaoa zzd() {
        return new zzaoa();
    }

    private zzaoa() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaoa(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    private final void zza(int i) {
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

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzana.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zza(zzale zzaleVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzaleVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzb(zzale zzaleVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        for (int i = 0; i < this.zzb; i++) {
            int i2 = this.zzc[i];
            Object obj = this.zzd[i];
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                zzaleVar.zzb(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                zzaleVar.zza(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                zzaleVar.zza(i3, (zzakb) obj);
            } else if (i4 == 3) {
                zzaleVar.zzb(i3);
                ((zzaoa) obj).zzb(zzaleVar);
                zzaleVar.zza(i3);
            } else if (i4 == 5) {
                zzaleVar.zzb(i3, ((Integer) obj).intValue());
            } else {
                throw new RuntimeException(zzamd.zza());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaoa)) {
            return false;
        }
        zzaoa zzaoaVar = (zzaoa) obj;
        int i = this.zzb;
        if (i == zzaoaVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaoaVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzaoaVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }
}
