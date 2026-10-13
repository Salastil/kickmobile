package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzanl extends zzaun implements zzavx {
    private static final zzanl zze;
    private int zza;
    private zzaot zzd;

    static {
        zzanl zzanlVar = new zzanl();
        zze = zzanlVar;
        zzaun.zzaD(zzanl.class, zzanlVar);
    }

    private zzanl() {
    }

    public static zzank zzb() {
        return (zzank) zze.zzay();
    }

    public static zzanl zzc() {
        return zze;
    }

    public final zzaot zza() {
        zzaot zzaotVar = this.zzd;
        return zzaotVar == null ? zzaot.zzg() : zzaotVar;
    }

    final /* synthetic */ void zzd(zzaot zzaotVar) {
        zzaotVar.getClass();
        this.zzd = zzaotVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzanl();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzank(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
