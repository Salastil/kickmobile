package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zzaov extends zzaun implements zzavx {
    private static final zzaov zzh;
    private int zze;
    private boolean zzf;
    private String zza = "";
    private String zzd = "";
    private String zzg = "";

    static {
        zzaov zzaovVar = new zzaov();
        zzh = zzaovVar;
        zzaun.zzaD(zzaov.class, zzaovVar);
    }

    private zzaov() {
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzh, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zza", "zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaov();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaou(bArr);
        }
        if (i2 == 5) {
            return zzh;
        }
        throw null;
    }
}
