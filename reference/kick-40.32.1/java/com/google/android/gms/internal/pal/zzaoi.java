package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoi extends zzaun implements zzavx {
    private static final zzaoi zze;
    private int zza;
    private zzaok zzd;

    static {
        zzaoi zzaoiVar = new zzaoi();
        zze = zzaoiVar;
        zzaun.zzaD(zzaoi.class, zzaoiVar);
    }

    private zzaoi() {
    }

    public static zzaoi zzb(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaoi) zzaun.zzaM(zze, zzatlVar, zzatyVar);
    }

    public static zzaoh zzc() {
        return (zzaoh) zze.zzay();
    }

    public final zzaok zza() {
        zzaok zzaokVar = this.zzd;
        return zzaokVar == null ? zzaok.zze() : zzaokVar;
    }

    final /* synthetic */ void zzd(zzaok zzaokVar) {
        zzaokVar.getClass();
        this.zzd = zzaokVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zza", "zzd"});
        }
        if (i2 == 3) {
            return new zzaoi();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaoh(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
