package com.google.android.gms.internal.pal;

import org.bouncycastle.jcajce.spec.XDHParameterSpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadv {
    public static final zzadv zza = new zzadv("NIST_P256");
    public static final zzadv zzb = new zzadv("NIST_P384");
    public static final zzadv zzc = new zzadv("NIST_P521");
    public static final zzadv zzd = new zzadv(XDHParameterSpec.X25519);
    private final String zze;

    private zzadv(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
