package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzajk {
    private final Class zza;
    private final zzarq zzb;

    /* synthetic */ zzajk(Class cls, zzarq zzarqVar, byte[] bArr) {
        this.zza = cls;
        this.zzb = zzarqVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzajk)) {
            return false;
        }
        zzajk zzajkVar = (zzajk) obj;
        return zzajkVar.zza.equals(this.zza) && zzajkVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzarq zzarqVar = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String strValueOf = String.valueOf(zzarqVar);
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 21 + String.valueOf(strValueOf).length());
        sb.append(simpleName);
        sb.append(", object identifier: ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
