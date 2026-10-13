package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznr extends zzadu implements zzafd {
    private static final zznr zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private zzaef zze = zzcy();
    private String zzf = "";

    static {
        zznr zznrVar = new zznr();
        zzg = zznrVar;
        zzadu.zzcs(zznr.class, zznrVar);
    }

    private zznr() {
    }

    public static zznr zzb() {
        return zzg;
    }

    public final List zza() {
        return this.zze;
    }

    final /* synthetic */ void zzc(String str) {
        zzaef zzaefVar = this.zze;
        if (!zzaefVar.zza()) {
            this.zze = zzadu.zzcz(zzaefVar);
        }
        this.zze.add("");
    }

    final /* synthetic */ void zzd(String str) {
        this.zzb |= 1;
        this.zzf = "";
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    protected final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zznr();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zznq(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzh;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zznr.class) {
            zzadqVar = zzh;
            if (zzadqVar == null) {
                zzadqVar = new zzadq(zzg);
                zzh = zzadqVar;
            }
        }
        return zzadqVar;
    }
}
