package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzauh implements zzavu {
    private static final zzauh zza = new zzauh();

    private zzauh() {
    }

    public static zzauh zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.pal.zzavu
    public final boolean zzb(Class cls) {
        return zzaun.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.pal.zzavu
    public final zzavt zzc(Class cls) {
        if (!zzaun.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            String.valueOf(name);
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(name)));
        }
        try {
            return (zzavt) zzaun.zzaC(cls.asSubclass(zzaun.class)).zzl(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            String.valueOf(name2);
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(name2)), e);
        }
    }
}
