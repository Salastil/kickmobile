package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrp extends zzyd implements zzzj {
    private static final zzrp zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzrp zzrpVar = new zzrp();
        zzf = zzrpVar;
        zzyd.zzG(zzrp.class, zzrpVar);
    }

    private zzrp() {
    }

    public static zzro zza() {
        return (zzro) zzf.zzB();
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzrp();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzro(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }

    final /* synthetic */ void zzc(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }
}
