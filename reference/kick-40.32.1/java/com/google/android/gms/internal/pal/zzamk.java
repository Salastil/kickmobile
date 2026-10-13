package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamk extends zzaun implements zzavx {
    private static final zzamk zzf;
    private int zza;
    private zzamm zzd;
    private int zze;

    static {
        zzamk zzamkVar = new zzamk();
        zzf = zzamkVar;
        zzaun.zzaD(zzamk.class, zzamkVar);
    }

    private zzamk() {
    }

    public static zzamj zzc() {
        return (zzamj) zzf.zzay();
    }

    public static zzamk zzd() {
        return zzf;
    }

    public final zzamm zza() {
        zzamm zzammVar = this.zzd;
        return zzammVar == null ? zzamm.zzc() : zzammVar;
    }

    public final int zzb() {
        return this.zze;
    }

    final /* synthetic */ void zze(zzamm zzammVar) {
        zzammVar.getClass();
        this.zzd = zzammVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzf(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzamk();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamj(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
