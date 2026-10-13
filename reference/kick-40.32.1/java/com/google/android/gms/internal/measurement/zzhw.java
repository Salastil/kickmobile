package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhw extends zzadu implements zzafd {
    private static final zzhw zzk;
    private static volatile zzafj zzl;
    private int zzb;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzaef zzj = zzcy();

    static {
        zzhw zzhwVar = new zzhw();
        zzk = zzhwVar;
        zzadu.zzcs(zzhw.class, zzhwVar);
    }

    private zzhw() {
    }

    public static zzhv zzn() {
        return (zzhv) zzk.zzcn();
    }

    private final void zzz() {
        zzaef zzaefVar = this.zzj;
        if (zzaefVar.zza()) {
            return;
        }
        this.zzj = zzadu.zzcz(zzaefVar);
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

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 8) != 0;
    }

    public final float zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 16) != 0;
    }

    public final double zzk() {
        return this.zzi;
    }

    public final List zzl() {
        return this.zzj;
    }

    public final int zzm() {
        return this.zzj.size();
    }

    final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void zzq() {
        this.zzb &= -3;
        this.zzf = zzk.zzf;
    }

    final /* synthetic */ void zzr(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }

    final /* synthetic */ void zzs() {
        this.zzb &= -5;
        this.zzg = 0L;
    }

    final /* synthetic */ void zzt(double d) {
        this.zzb |= 16;
        this.zzi = d;
    }

    final /* synthetic */ void zzu() {
        this.zzb &= -17;
        this.zzi = 0.0d;
    }

    final /* synthetic */ void zzv(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzz();
        this.zzj.add(zzhwVar);
    }

    final /* synthetic */ void zzw(Iterable iterable) {
        zzz();
        zzacb.zzcg(iterable, this.zzj);
    }

    final /* synthetic */ void zzx() {
        this.zzj = zzcy();
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzk, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzhw.class});
        }
        if (i2 == 3) {
            return new zzhw();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzhv(bArr);
        }
        if (i2 == 5) {
            return zzk;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzl;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzhw.class) {
            zzadqVar = zzl;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzk);
                zzl = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
