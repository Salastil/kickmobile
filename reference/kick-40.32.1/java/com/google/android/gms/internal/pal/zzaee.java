package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
class zzaee {
    protected final String zzd;
    protected final int zze;

    /* synthetic */ zzaee(String str, int i, byte[] bArr) {
        this.zzd = str;
        this.zze = i;
    }

    public final String toString() {
        return String.format("%s(0x%04x)", this.zzd, Integer.valueOf(this.zze));
    }
}
