package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzog implements Serializable {
    public static final /* synthetic */ int zzc = 0;
    private static final zzog zzd = new zzog(zznc.zzb, zzna.zzb);
    final zznd zza;
    final zznd zzb;

    private zzog(zznd zzndVar, zznd zzndVar2) {
        this.zza = zzndVar;
        this.zzb = zzndVar2;
        if (zzndVar.compareTo(zzndVar2) > 0 || zzndVar == zzna.zzb || zzndVar2 == zznc.zzb) {
            throw new IllegalArgumentException("Invalid range: ".concat(zze(zzndVar, zzndVar2)));
        }
    }

    public static zzog zza() {
        return zzd;
    }

    private static String zze(zznd zzndVar, zznd zzndVar2) {
        StringBuilder sb = new StringBuilder(16);
        zzndVar.zza(sb);
        sb.append("..");
        zzndVar2.zzb(sb);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzog) {
            zzog zzogVar = (zzog) obj;
            if (this.zza.equals(zzogVar.zza) && this.zzb.equals(zzogVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zze(this.zza, this.zzb);
    }

    public final boolean zzb() {
        return this.zza.equals(this.zzb);
    }

    public final zzog zzc(zzog zzogVar) {
        zznd zzndVar = this.zza;
        zznd zzndVar2 = zzogVar.zza;
        int iZzc = zzndVar.compareTo(zzndVar2);
        zznd zzndVar3 = this.zzb;
        zznd zzndVar4 = zzogVar.zzb;
        int iZzc2 = zzndVar3.compareTo(zzndVar4);
        if (iZzc >= 0 && iZzc2 <= 0) {
            return this;
        }
        if (iZzc <= 0 && iZzc2 >= 0) {
            return zzogVar;
        }
        if (iZzc < 0) {
            zzndVar = zzndVar2;
        }
        if (iZzc2 > 0) {
            zzndVar3 = zzndVar4;
        }
        zzls.zze(zzndVar.compareTo(zzndVar3) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, zzogVar);
        return new zzog(zzndVar, zzndVar3);
    }

    public final zzog zzd(zzog zzogVar) {
        zznd zzndVar = this.zza;
        zznd zzndVar2 = zzogVar.zza;
        int iZzc = zzndVar.compareTo(zzndVar2);
        zznd zzndVar3 = this.zzb;
        zznd zzndVar4 = zzogVar.zzb;
        int iZzc2 = zzndVar3.compareTo(zzndVar4);
        if (iZzc <= 0 && iZzc2 >= 0) {
            return this;
        }
        if (iZzc >= 0 && iZzc2 <= 0) {
            return zzogVar;
        }
        if (iZzc > 0) {
            zzndVar = zzndVar2;
        }
        if (iZzc2 < 0) {
            zzndVar3 = zzndVar4;
        }
        return new zzog(zzndVar, zzndVar3);
    }
}
