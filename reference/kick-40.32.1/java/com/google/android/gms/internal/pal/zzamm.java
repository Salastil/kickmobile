package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamm extends zzaun implements zzavx {
    private static final zzamm zzd;
    private int zza;

    static {
        zzamm zzammVar = new zzamm();
        zzd = zzammVar;
        zzaun.zzaD(zzamm.class, zzammVar);
    }

    private zzamm() {
    }

    public static zzaml zzb() {
        return (zzaml) zzd.zzay();
    }

    public static zzamm zzc() {
        return zzd;
    }

    public final int zza() {
        return this.zza;
    }

    final /* synthetic */ void zzd(int i) {
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzd, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (i2 == 3) {
            return new zzamm();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaml(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
