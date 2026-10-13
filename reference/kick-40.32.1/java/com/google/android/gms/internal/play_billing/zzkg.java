package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkg extends zzgp implements zzhs {
    private static final zzkg zzb;
    private int zzd;
    private int zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzs;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        zzkg zzkgVar = new zzkg();
        zzb = zzkgVar;
        zzgp.zzB(zzkg.class, zzkgVar);
    }

    private zzkg() {
    }

    static /* synthetic */ void zzG(zzkg zzkgVar, long j) {
        zzkgVar.zzd |= 512;
        zzkgVar.zzn = 926300087L;
    }

    static /* synthetic */ void zzH(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 4;
        zzkgVar.zzg = str;
    }

    static /* synthetic */ void zzI(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 1024;
        zzkgVar.zzo = str;
    }

    static /* synthetic */ void zzJ(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 8192;
        zzkgVar.zzr = str;
    }

    static /* synthetic */ void zzK(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 4096;
        zzkgVar.zzq = str;
    }

    static /* synthetic */ void zzL(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 2048;
        zzkgVar.zzp = str;
    }

    static /* synthetic */ void zzM(zzkg zzkgVar, int i) {
        zzkgVar.zzd |= 16384;
        zzkgVar.zzs = i;
    }

    static /* synthetic */ void zzN(zzkg zzkgVar, boolean z) {
        zzkgVar.zzd |= 64;
        zzkgVar.zzk = z;
    }

    static /* synthetic */ void zzO(zzkg zzkgVar, String str) {
        str.getClass();
        zzkgVar.zzd |= 1;
        zzkgVar.zze = str;
    }

    static /* synthetic */ void zzP(zzkg zzkgVar, String str) {
        zzkgVar.zzd |= 2;
        zzkgVar.zzf = str;
    }

    public static zzke zza() {
        return (zzke) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkg zzkgVar, int i) {
        zzkgVar.zzd |= 128;
        zzkgVar.zzl = i;
    }

    static /* synthetic */ void zze(zzkg zzkgVar, int i) {
        zzkgVar.zzd |= 256;
        zzkgVar.zzm = i;
    }

    static /* synthetic */ void zzf(zzkg zzkgVar, int i) {
        zzkgVar.zzd |= 8;
        zzkgVar.zzh = i;
    }

    static /* synthetic */ void zzg(zzkg zzkgVar, long j) {
        zzkgVar.zzd |= 16;
        zzkgVar.zzi = j;
    }

    static /* synthetic */ void zzh(zzkg zzkgVar, long j) {
        zzkgVar.zzd |= 32;
        zzkgVar.zzj = j;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzy(zzb, "\u0004\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003င\u0003\u0004ဂ\u0004\u0005ဈ\u0001\u0006ဂ\u0005\u0007ဇ\u0006\bင\u0007\tင\b\nဂ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r\u000fင\u000e", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzf", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i2 == 3) {
            return new zzkg();
        }
        zzkf zzkfVar = null;
        if (i2 == 4) {
            return new zzke(zzkfVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
