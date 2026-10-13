package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqn {
    private final boolean zza;
    private final List zzb;
    private final zzacr zzc;
    private final String zzd;
    private final String zze;
    private final List zzf;
    private final List zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final zznf zzk;

    public zzqn(boolean z, List enabledBackings, zzacr secret, String dirPath, String gmsCoreDirPath, List includeStaticConfigPackages, List excludeStaticConfigPackages, boolean z2, boolean z3, boolean z4, zznf clientFlags) {
        Intrinsics.checkNotNullParameter(enabledBackings, "enabledBackings");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        Intrinsics.checkNotNullParameter(gmsCoreDirPath, "gmsCoreDirPath");
        Intrinsics.checkNotNullParameter(includeStaticConfigPackages, "includeStaticConfigPackages");
        Intrinsics.checkNotNullParameter(excludeStaticConfigPackages, "excludeStaticConfigPackages");
        Intrinsics.checkNotNullParameter(clientFlags, "clientFlags");
        this.zza = z;
        this.zzb = enabledBackings;
        this.zzc = secret;
        this.zzd = dirPath;
        this.zze = gmsCoreDirPath;
        this.zzf = includeStaticConfigPackages;
        this.zzg = excludeStaticConfigPackages;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = clientFlags;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqn)) {
            return false;
        }
        zzqn zzqnVar = (zzqn) obj;
        return this.zza == zzqnVar.zza && Intrinsics.areEqual(this.zzb, zzqnVar.zzb) && Intrinsics.areEqual(this.zzc, zzqnVar.zzc) && Intrinsics.areEqual(this.zzd, zzqnVar.zzd) && Intrinsics.areEqual(this.zze, zzqnVar.zze) && Intrinsics.areEqual(this.zzf, zzqnVar.zzf) && Intrinsics.areEqual(this.zzg, zzqnVar.zzg) && this.zzh == zzqnVar.zzh && this.zzi == zzqnVar.zzi && this.zzj == zzqnVar.zzj && Intrinsics.areEqual(this.zzk, zzqnVar.zzk);
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.zza), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj));
    }

    public final String toString() {
        boolean z = this.zza;
        int length = String.valueOf(z).length();
        List list = this.zzb;
        int length2 = String.valueOf(list).length();
        zzacr zzacrVar = this.zzc;
        int length3 = String.valueOf(zzacrVar).length();
        String str = this.zzd;
        int length4 = String.valueOf(str).length();
        String str2 = this.zze;
        int length5 = String.valueOf(str2).length();
        List list2 = this.zzf;
        int length6 = String.valueOf(list2).length();
        List list3 = this.zzg;
        int length7 = String.valueOf(list3).length();
        boolean z2 = this.zzh;
        int length8 = String.valueOf(z2).length();
        boolean z3 = this.zzi;
        int length9 = String.valueOf(z3).length();
        boolean z4 = this.zzj;
        int length10 = String.valueOf(z4).length();
        zznf zznfVar = this.zzk;
        StringBuilder sb = new StringBuilder(length + 59 + length2 + 9 + length3 + 10 + length4 + 17 + length5 + 30 + length6 + 30 + length7 + 24 + length8 + 26 + length9 + 20 + length10 + 14 + String.valueOf(zznfVar).length() + 1);
        sb.append("SharedStorageInfo(shouldUseSharedStorage=");
        sb.append(z);
        sb.append(", enabledBackings=");
        sb.append(list);
        sb.append(", secret=");
        sb.append(zzacrVar);
        sb.append(", dirPath=");
        sb.append(str);
        sb.append(", gmsCoreDirPath=");
        sb.append(str2);
        sb.append(", includeStaticConfigPackages=");
        sb.append(list2);
        sb.append(", excludeStaticConfigPackages=");
        sb.append(list3);
        sb.append(", hasStorageInfoFromGms=");
        sb.append(z2);
        sb.append(", allowEmptySnapshotToken=");
        sb.append(z3);
        sb.append(", enableCommitV2Api=");
        sb.append(z4);
        sb.append(", clientFlags=");
        sb.append(zznfVar);
        sb.append(")");
        return sb.toString();
    }

    public final zzacr zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zzi;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final zznf zzf() {
        return this.zzk;
    }

    public final int zzg(zzabz androidBacking, String staticPackageName) {
        Intrinsics.checkNotNullParameter(androidBacking, "androidBacking");
        Intrinsics.checkNotNullParameter(staticPackageName, "staticPackageName");
        if (!this.zzh) {
            return 14;
        }
        Intrinsics.checkNotNullParameter(androidBacking, "androidBacking");
        if (!this.zza || !this.zzb.contains(androidBacking)) {
            return 3;
        }
        if (this.zzc.zzb() == 0) {
            return 4;
        }
        List list = this.zzf;
        if (list.isEmpty() || list.contains(staticPackageName)) {
            return this.zzg.contains(staticPackageName) ? 6 : 0;
        }
        return 5;
    }
}
