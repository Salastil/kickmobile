package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapj extends zzaun implements zzavx {
    private static final zzapj zzf;
    private static volatile zzawd zzg;
    private int zza;
    private int zzd;
    private zzapl zze;

    static {
        zzapj zzapjVar = new zzapj();
        zzf = zzapjVar;
        zzaun.zzaD(zzapj.class, zzapjVar);
    }

    private zzapj() {
    }

    public static zzapj zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapj) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzapi zzd() {
        return (zzapi) zzf.zzay();
    }

    public static zzawd zze() {
        return (zzawd) zzf.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzapl zzb() {
        zzapl zzaplVar = this.zze;
        return zzaplVar == null ? zzapl.zze() : zzaplVar;
    }

    final /* synthetic */ void zzf(zzapl zzaplVar) {
        zzaplVar.getClass();
        this.zze = zzaplVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzapj();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapi(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        if (i2 != 6) {
            throw null;
        }
        zzawd zzawdVar = zzg;
        if (zzawdVar != null) {
            return zzawdVar;
        }
        synchronized (zzapj.class) {
            zzaujVar = zzg;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzf);
                zzg = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
