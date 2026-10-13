package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamq extends zzaun implements zzavx {
    private static final zzamq zzf;
    private int zza;
    private zzams zzd;
    private int zze;

    static {
        zzamq zzamqVar = new zzamq();
        zzf = zzamqVar;
        zzaun.zzaD(zzamq.class, zzamqVar);
    }

    private zzamq() {
    }

    public static zzamq zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzamq) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzamp zzd() {
        return (zzamp) zzf.zzay();
    }

    public final zzams zza() {
        zzams zzamsVar = this.zzd;
        return zzamsVar == null ? zzams.zzc() : zzamsVar;
    }

    public final int zzb() {
        return this.zze;
    }

    final /* synthetic */ void zze(zzams zzamsVar) {
        zzamsVar.getClass();
        this.zzd = zzamsVar;
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
            return new zzamq();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamp(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
