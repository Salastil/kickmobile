package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzir extends Exception {
    private final int zza;

    public zzir(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 23);
        sb.append("Signal SDK error code: ");
        sb.append(i);
        super(sb.toString());
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }
}
