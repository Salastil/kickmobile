package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzana extends zzaun implements zzavx {
    private static final zzana zze;
    private int zza;
    private int zzd;

    static {
        zzana zzanaVar = new zzana();
        zze = zzanaVar;
        zzaun.zzaD(zzana.class, zzanaVar);
    }

    private zzana() {
    }

    public static zzana zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzana) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzamz zzd() {
        return (zzamz) zze.zzay();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zze(int i) {
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zza"});
        }
        if (i2 == 3) {
            return new zzana();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamz(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
