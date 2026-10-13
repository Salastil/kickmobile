package com.google.ads.interactivemedia.pal;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzj {
    private final String zza;
    private final long zzb;

    public zzj(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (true == (obj instanceof zzj)) {
            zzj zzjVar = (zzj) obj;
            return true == Objects.equals(this.zza, zzjVar.zza) && this.zzb == zzjVar.zzb;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(this.zzb)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.zza);
        sb.append(this.zzb);
        return sb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }
}
