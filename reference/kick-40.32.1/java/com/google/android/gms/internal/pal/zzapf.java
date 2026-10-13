package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapf extends zzaun implements zzavx {
    private static final zzapf zzf;
    private static volatile zzawd zzg;
    private int zza;
    private int zzd;
    private zzaph zze;

    static {
        zzapf zzapfVar = new zzapf();
        zzf = zzapfVar;
        zzaun.zzaD(zzapf.class, zzapfVar);
    }

    private zzapf() {
    }

    public static zzapf zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzapf) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzape zzd() {
        return (zzape) zzf.zzay();
    }

    public static zzawd zze() {
        return (zzawd) zzf.zzl(7, null, null);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaph zzb() {
        zzaph zzaphVar = this.zze;
        return zzaphVar == null ? zzaph.zzd() : zzaphVar;
    }

    final /* synthetic */ void zzf(zzaph zzaphVar) {
        zzaphVar.getClass();
        this.zze = zzaphVar;
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
            return new zzapf();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzape(bArr);
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
        synchronized (zzapf.class) {
            zzaujVar = zzg;
            if (zzaujVar == null) {
                zzaujVar = new zzauj(zzf);
                zzg = zzaujVar;
            }
        }
        return zzaujVar;
    }
}
