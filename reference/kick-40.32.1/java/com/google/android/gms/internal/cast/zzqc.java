package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqc extends zzyd implements zzzj {
    private static final zzqc zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzqc zzqcVar = new zzqc();
        zzf = zzqcVar;
        zzyd.zzG(zzqc.class, zzqcVar);
    }

    private zzqc() {
    }

    public static zzqb zza() {
        return (zzqb) zzf.zzB();
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
            return new zzqc();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzqb(bArr);
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

    final /* synthetic */ void zzd(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }
}
