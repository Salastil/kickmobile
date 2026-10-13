package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapy extends zzaun implements zzavx {
    private static final zzapy zzd;
    private int zza;

    static {
        zzapy zzapyVar = new zzapy();
        zzd = zzapyVar;
        zzaun.zzaD(zzapy.class, zzapyVar);
    }

    private zzapy() {
    }

    public static zzapy zzb(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapy) zzaun.zzaM(zzd, zzatlVar, zzatyVar);
    }

    public static zzapy zzc() {
        return zzd;
    }

    public final int zza() {
        return this.zza;
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
            return new zzapy();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapx(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
