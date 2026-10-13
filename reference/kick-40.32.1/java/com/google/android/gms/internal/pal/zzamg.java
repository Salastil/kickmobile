package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamg extends zzaun implements zzavx {
    private static final zzamg zzf;
    private int zza;
    private zzamk zzd;
    private zzaob zze;

    static {
        zzamg zzamgVar = new zzamg();
        zzf = zzamgVar;
        zzaun.zzaD(zzamg.class, zzamgVar);
    }

    private zzamg() {
    }

    public static zzamg zzc(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzamg) zzaun.zzaM(zzf, zzatlVar, zzatyVar);
    }

    public static zzamf zzd() {
        return (zzamf) zzf.zzay();
    }

    public final zzamk zza() {
        zzamk zzamkVar = this.zzd;
        return zzamkVar == null ? zzamk.zzd() : zzamkVar;
    }

    public final zzaob zzb() {
        zzaob zzaobVar = this.zze;
        return zzaobVar == null ? zzaob.zzf() : zzaobVar;
    }

    final /* synthetic */ void zze(zzamk zzamkVar) {
        zzamkVar.getClass();
        this.zzd = zzamkVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzf(zzaob zzaobVar) {
        zzaobVar.getClass();
        this.zze = zzaobVar;
        this.zza |= 2;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzamg();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzamf(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
