package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzama extends zzaun implements zzavx {
    private static final zzama zzf;
    private int zza;
    private int zzd;
    private zzamc zze;

    static {
        zzama zzamaVar = new zzama();
        zzf = zzamaVar;
        zzaun.zzaD(zzama.class, zzamaVar);
    }

    private zzama() {
    }

    public static zzama zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzama) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzalz zzd() {
        return (zzalz) zzf.zzay();
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzamc zzb() {
        zzamc zzamcVar = this.zze;
        return zzamcVar == null ? zzamc.zzc() : zzamcVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zzd = i;
    }

    final /* synthetic */ void zzf(zzamc zzamcVar) {
        zzamcVar.getClass();
        this.zze = zzamcVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzama();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzalz(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
