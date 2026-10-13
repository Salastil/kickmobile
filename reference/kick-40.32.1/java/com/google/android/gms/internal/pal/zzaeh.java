package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaeh extends zzaee {
    public static final zzaeh zza = new zzaeh("DHKEM_P256_HKDF_SHA256", 16);
    public static final zzaeh zzb = new zzaeh("DHKEM_P384_HKDF_SHA384", 17);
    public static final zzaeh zzc = new zzaeh("DHKEM_P521_HKDF_SHA512", 18);
    public static final zzaeh zzf = new zzaeh("DHKEM_X25519_HKDF_SHA256", 32);

    private zzaeh(String str, int i) {
        super(str, i, null);
    }
}
