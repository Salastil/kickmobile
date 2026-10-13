package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapw extends zzaun implements zzavx {
    private static final zzapw zze;
    private static volatile zzawd zzf;
    private int zza;
    private zzatl zzd = zzatl.zza;

    static {
        zzapw zzapwVar = new zzapw();
        zze = zzapwVar;
        zzaun.zzaD(zzapw.class, zzapwVar);
    }

    private zzapw() {
    }

    public static zzapw zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapw) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzapv zzd() {
        return (zzapv) zze.zzay();
    }

    public static zzawd zze() {
        return (zzawd) zze.zzl(7, null, null);
    }

    public final int zza() {
        return this.zza;
    }

    public final zzatl zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zzf(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzd = zzatlVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        zzawd zzaujVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzapw();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapv(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            throw null;
        }
        zzawd zzawdVar = zzf;
        if (zzawdVar != null) {
            return zzawdVar;
        }
        synchronized (zzapw.class) {
            zzaujVar = zzf;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zze);
                zzf = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
