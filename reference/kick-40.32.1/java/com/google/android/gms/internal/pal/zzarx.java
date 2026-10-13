package com.google.android.gms.internal.pal;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarx extends zzarv {
    private final zzasl zza = new zzasl(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzarx) && ((zzarx) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(String str, zzarv zzarvVar) {
        this.zza.put(str, zzarvVar);
    }

    public final Set zzb() {
        return this.zza.entrySet();
    }

    public final boolean zzc(String str) {
        return this.zza.containsKey(str);
    }

    public final zzarv zzh(String str) {
        return (zzarv) this.zza.get(str);
    }
}
