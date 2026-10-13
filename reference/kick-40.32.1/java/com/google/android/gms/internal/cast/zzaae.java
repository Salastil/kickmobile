package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaae {
    private static final zzaae zza = new zzaae(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaae() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaae(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaae zza() {
        return zza;
    }

    static zzaae zzb(zzaae zzaaeVar, zzaae zzaaeVar2) {
        int i = zzaaeVar.zzb;
        int i2 = zzaaeVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaaeVar.zzc, 0);
        int[] iArr = zzaaeVar2.zzc;
        int i3 = zzaaeVar.zzb;
        int i4 = zzaaeVar2.zzb;
        System.arraycopy(iArr, 0, iArrCopyOf, 0, 0);
        Object[] objArrCopyOf = Arrays.copyOf(zzaaeVar.zzd, 0);
        Object[] objArr = zzaaeVar2.zzd;
        int i5 = zzaaeVar.zzb;
        int i6 = zzaaeVar2.zzb;
        System.arraycopy(objArr, 0, objArrCopyOf, 0, 0);
        return new zzaae(0, iArrCopyOf, objArrCopyOf, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaae)) {
            return false;
        }
        zzaae zzaaeVar = (zzaae) obj;
        int[] iArr = zzaaeVar.zzc;
        Object[] objArr = zzaaeVar.zzd;
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final void zzc() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzd(zzaap zzaapVar) throws IOException {
    }

    public final int zze() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzf() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    final void zzg(StringBuilder sb, int i) {
    }

    final zzaae zzh(zzaae zzaaeVar) {
        if (zzaaeVar.equals(zza)) {
            return this;
        }
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i = zzaaeVar.zzb;
        int[] iArr = this.zzc;
        int length = iArr.length;
        System.arraycopy(zzaaeVar.zzc, 0, iArr, 0, 0);
        Object[] objArr = zzaaeVar.zzd;
        Object[] objArr2 = this.zzd;
        int i2 = zzaaeVar.zzb;
        System.arraycopy(objArr, 0, objArr2, 0, 0);
        this.zzb = 0;
        return this;
    }
}
