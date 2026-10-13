package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzus extends zzyd implements zzzj {
    private static final zzus zzm;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private int zzk;
    private boolean zzl;

    static {
        zzus zzusVar = new zzus();
        zzm = zzusVar;
        zzyd.zzG(zzus.class, zzusVar);
    }

    private zzus() {
    }

    public static zzur zza() {
        return (zzur) zzm.zzB();
    }

    @Override // com.google.android.gms.internal.cast.zzyd
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzH(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzlo.zza(), "zzl"});
        }
        if (i2 == 3) {
            return new zzus();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzur(bArr);
        }
        if (i2 == 5) {
            return zzm;
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

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    final /* synthetic */ void zzf(String str) {
        str.getClass();
        this.zzb |= 8;
        this.zzg = str;
    }

    final /* synthetic */ void zzg(String str) {
        str.getClass();
        this.zzb |= 16;
        this.zzh = str;
    }

    final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zzb |= 32;
        this.zzi = str;
    }

    final /* synthetic */ void zzj(int i) {
        this.zzk = i - 1;
        this.zzb |= 128;
    }
}
