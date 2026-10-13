package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaed extends zzaee {
    public static final zzaed zza = new zzaed("AES_128_GCM", 1);
    public static final zzaed zzb = new zzaed("AES_256_GCM", 2);
    public static final zzaed zzc = new zzaed("CHACHA20_POLY1305", 3);

    private zzaed(String str, int i) {
        super(str, i, null);
    }
}
