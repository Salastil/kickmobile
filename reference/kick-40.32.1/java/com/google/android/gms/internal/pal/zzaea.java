package com.google.android.gms.internal.pal;

import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaea extends zzafh {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb = (Set) zzajo.zza(zzadw.zza);
    private final zzadv zzc;
    private final zzadx zzd;

    @Nullable
    private final zzady zze;
    private final zzadz zzf;
    private final zzwk zzg;

    @Nullable
    private final zzarq zzh;

    /* synthetic */ zzaea(zzadv zzadvVar, zzadx zzadxVar, zzady zzadyVar, zzwk zzwkVar, zzadz zzadzVar, zzarq zzarqVar, byte[] bArr) {
        this.zzc = zzadvVar;
        this.zzd = zzadxVar;
        this.zze = zzadyVar;
        this.zzg = zzwkVar;
        this.zzf = zzadzVar;
        this.zzh = zzarqVar;
    }

    public static zzadu zzb() {
        return new zzadu(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaea)) {
            return false;
        }
        zzaea zzaeaVar = (zzaea) obj;
        return Objects.equals(zzaeaVar.zzc, this.zzc) && Objects.equals(zzaeaVar.zzd, this.zzd) && Objects.equals(zzaeaVar.zze, this.zze) && Objects.equals(zzaeaVar.zzg, this.zzg) && Objects.equals(zzaeaVar.zzf, this.zzf) && Objects.equals(zzaeaVar.zzh, this.zzh);
    }

    public final int hashCode() {
        return Objects.hash(zzaea.class, this.zzc, this.zzd, this.zze, this.zzg, this.zzf, this.zzh);
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", this.zzc, this.zzd, this.zze, this.zzg, this.zzf, this.zzh);
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        throw null;
    }

    public final zzadv zzc() {
        return this.zzc;
    }

    public final zzadx zzd() {
        return this.zzd;
    }

    @Nullable
    public final zzady zze() {
        return this.zze;
    }

    public final zzwk zzf() {
        return this.zzg;
    }

    public final zzadz zzg() {
        return this.zzf;
    }

    @Nullable
    public final zzarq zzh() {
        return this.zzh;
    }
}
