package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpm extends zzqx {
    private Object[] zza = new Object[8];
    private int zzb = 0;

    zzpm() {
    }

    private final int zzh(zzpz zzpzVar) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i + i].equals(zzpzVar)) {
                return i;
            }
        }
        return -1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i = 0; i < this.zzb; i++) {
            sb.append(" '");
            sb.append(zzb(i));
            sb.append("': ");
            sb.append(zzc(i));
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final zzpz zzb(int i) {
        if (i < this.zzb) {
            return (zzpz) this.zza[i + i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final Object zzc(int i) {
        if (i < this.zzb) {
            return this.zza[i + i + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final Object zzd(zzpz zzpzVar) {
        int iZzh = zzh(zzpzVar);
        if (iZzh != -1) {
            return zzpzVar.zze(this.zza[iZzh + iZzh + 1]);
        }
        return null;
    }

    final void zze(zzpz zzpzVar, Object obj) {
        int iZzh;
        if (!zzpzVar.zzf() && (iZzh = zzh(zzpzVar)) != -1) {
            zztf.zza(obj, "metadata value");
            this.zza[iZzh + iZzh + 1] = obj;
            return;
        }
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i + i > length) {
            this.zza = Arrays.copyOf(objArr, length + length);
        }
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        zztf.zza(zzpzVar, "metadata key");
        objArr2[i2 + i2] = zzpzVar;
        Object[] objArr3 = this.zza;
        int i3 = this.zzb;
        zztf.zza(obj, "metadata value");
        objArr3[i3 + i3 + 1] = obj;
        this.zzb++;
    }

    final void zzf(zzpz zzpzVar) {
        int i;
        int iZzh = zzh(zzpzVar);
        if (iZzh >= 0) {
            int i2 = iZzh + iZzh;
            int i3 = i2 + 2;
            while (true) {
                i = this.zzb;
                if (i3 >= i + i) {
                    break;
                }
                Object obj = this.zza[i3];
                if (!obj.equals(zzpzVar)) {
                    Object[] objArr = this.zza;
                    objArr[i2] = obj;
                    objArr[i2 + 1] = objArr[i3 + 1];
                    i2 += 2;
                }
                i3 += 2;
            }
            this.zzb = i - ((i3 - i2) >> 1);
            while (i2 < i3) {
                this.zza[i2] = null;
                i2++;
            }
        }
    }
}
