package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzk extends zzaun implements zzavx {
    private static final zzk zzl;
    private int zza;
    private int zzd;
    private boolean zzg;
    private zzaa zzi;
    private zzac zzj;
    private boolean zzk;
    private boolean zze = true;
    private String zzf = "unknown_host";
    private boolean zzh = true;

    static {
        zzk zzkVar = new zzk();
        zzl = zzkVar;
        zzaun.zzaD(zzk.class, zzkVar);
    }

    private zzk() {
    }

    public static zzj zzg() {
        return (zzj) zzl.zzay();
    }

    public final boolean zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    @Deprecated
    public final boolean zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        return this.zzh;
    }

    public final zzaa zze() {
        zzaa zzaaVar = this.zzi;
        return zzaaVar == null ? zzaa.zzd() : zzaaVar;
    }

    public final zzac zzf() {
        zzac zzacVar = this.zzj;
        return zzacVar == null ? zzac.zzd() : zzacVar;
    }

    final /* synthetic */ void zzh(String str) {
        this.zza |= 4;
        this.zzf = "h.3.2.2/n.android.3.2.2";
    }

    final /* synthetic */ void zzi(boolean z) {
        this.zza |= 8;
        this.zzg = false;
    }

    final /* synthetic */ void zzj(boolean z) {
        this.zza |= 16;
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zza", "zzd", zzl.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzk();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzj(bArr);
        }
        if (i2 == 5) {
            return zzl;
        }
        throw null;
    }

    public final int zzm() {
        int iZza = zzm.zza(this.zzd);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    final /* synthetic */ void zzn(int i) {
        this.zzd = 1;
        this.zza = 1 | this.zza;
    }
}
