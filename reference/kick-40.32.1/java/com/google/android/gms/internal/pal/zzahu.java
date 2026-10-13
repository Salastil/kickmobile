package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahu extends zzwk {
    private final zzajf zza;

    public zzahu(zzajf zzajfVar) {
        this.zza = zzajfVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzahu)) {
            return false;
        }
        zzajf zzajfVar = ((zzahu) obj).zza;
        zzajf zzajfVar2 = this.zza;
        return zzajfVar2.zzc().zzc().equals(zzajfVar.zzc().zzc()) && zzajfVar2.zzc().zza().equals(zzajfVar.zzc().zza()) && zzajfVar2.zzc().zzb().equals(zzajfVar.zzc().zzb());
    }

    public final int hashCode() {
        zzajf zzajfVar = this.zza;
        return Objects.hash(zzajfVar.zzc(), zzajfVar.zzd());
    }

    public final String toString() {
        String str;
        zzajf zzajfVar = this.zza;
        String strZza = zzajfVar.zzc().zza();
        int iOrdinal = zzajfVar.zzc().zzc().ordinal();
        if (iOrdinal == 1) {
            str = "TINK";
        } else if (iOrdinal == 2) {
            str = "LEGACY";
        } else if (iOrdinal != 3) {
            str = iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY";
        } else {
            str = "RAW";
        }
        return String.format("(typeUrl=%s, outputPrefixType=%s)", strZza, str);
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        throw null;
    }

    public final zzajf zzb() {
        return this.zza;
    }
}
