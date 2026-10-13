package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzha extends zzadu implements zzafd {
    private static final zzha zzp;
    private static volatile zzafj zzq;
    private int zzb;
    private long zzh;
    private long zzl;
    private zzaew zzm = zzaew.zza();
    private zzaew zzn = zzaew.zza();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzo = "";

    static {
        zzha zzhaVar = new zzha();
        zzp = zzhaVar;
        zzadu.zzcs(zzha.class, zzhaVar);
    }

    private zzha() {
    }

    public static zzgx zzt() {
        return (zzgx) zzp.zzcn();
    }

    public static zzha zzu() {
        return zzp;
    }

    final /* synthetic */ void zzA() {
        this.zzb &= -5;
        this.zzg = zzp.zzg;
    }

    final /* synthetic */ void zzB(long j) {
        this.zzb |= 8;
        this.zzh = j;
    }

    final /* synthetic */ void zzC(String str) {
        this.zzb |= 16;
        this.zzi = str;
    }

    final /* synthetic */ void zzD() {
        this.zzb &= -17;
        this.zzi = zzp.zzi;
    }

    final /* synthetic */ void zzE(String str) {
        this.zzb |= 32;
        this.zzj = str;
    }

    final /* synthetic */ void zzF() {
        this.zzb &= -33;
        this.zzj = zzp.zzj;
    }

    final /* synthetic */ void zzG(String str) {
        this.zzb |= 64;
        this.zzk = str;
    }

    final /* synthetic */ void zzH() {
        this.zzb &= -65;
        this.zzk = zzp.zzk;
    }

    final /* synthetic */ void zzI(long j) {
        this.zzb |= 128;
        this.zzl = j;
    }

    final /* synthetic */ Map zzJ() {
        if (!this.zzm.zze()) {
            this.zzm = this.zzm.zzc();
        }
        return this.zzm;
    }

    final /* synthetic */ Map zzK() {
        if (!this.zzn.zze()) {
            this.zzn = this.zzn.zzc();
        }
        return this.zzn;
    }

    final /* synthetic */ void zzL(String str) {
        this.zzb |= 256;
        this.zzo = str;
    }

    final /* synthetic */ void zzM() {
        this.zzb &= -257;
        this.zzo = zzp.zzo;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 8) != 0;
    }

    public final long zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 16) != 0;
    }

    public final String zzk() {
        return this.zzi;
    }

    public final boolean zzl() {
        return (this.zzb & 32) != 0;
    }

    public final String zzm() {
        return this.zzj;
    }

    public final boolean zzn() {
        return (this.zzb & 64) != 0;
    }

    public final String zzo() {
        return this.zzk;
    }

    public final boolean zzp() {
        return (this.zzb & 128) != 0;
    }

    public final long zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        return (this.zzb & 256) != 0;
    }

    public final String zzs() {
        return this.zzo;
    }

    final /* synthetic */ void zzv(String str) {
        this.zzb |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzw() {
        this.zzb &= -2;
        this.zze = zzp.zze;
    }

    final /* synthetic */ void zzx(String str) {
        this.zzb |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void zzy() {
        this.zzb &= -3;
        this.zzf = zzp.zzf;
    }

    final /* synthetic */ void zzz(String str) {
        this.zzb |= 4;
        this.zzg = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzp, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2\u000bဈ\b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzgy.zza, "zzn", zzgz.zza, "zzo"});
        }
        if (i2 == 3) {
            return new zzha();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzgx(bArr);
        }
        if (i2 == 5) {
            return zzp;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzq;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzha.class) {
            zzadqVar = zzq;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzp);
                zzq = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
