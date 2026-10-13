package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvh extends zzaun implements zzavx {
    private static final zzvh zzg;
    private int zza;
    private zzvm zzd;
    private zzut zze;
    private zzuz zzf;

    static {
        zzvh zzvhVar = new zzvh();
        zzg = zzvhVar;
        zzaun.zzaD(zzvh.class, zzvhVar);
    }

    private zzvh() {
    }

    public static zzvg zzd() {
        return (zzvg) zzg.zzay();
    }

    public final zzvm zza() {
        zzvm zzvmVar = this.zzd;
        return zzvmVar == null ? zzvm.zzk() : zzvmVar;
    }

    public final boolean zzb() {
        return (this.zza & 2) != 0;
    }

    public final zzut zzc() {
        zzut zzutVar = this.zze;
        return zzutVar == null ? zzut.zzc() : zzutVar;
    }

    final /* synthetic */ void zze(zzvm zzvmVar) {
        this.zzd = zzvmVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzf(zzut zzutVar) {
        this.zze = zzutVar;
        this.zza |= 2;
    }

    final /* synthetic */ void zzg(zzuz zzuzVar) {
        this.zzf = zzuzVar;
        this.zza |= 4;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0002\u0003ဉ\u0001", new Object[]{"zza", "zzd", "zzf", "zze"});
        }
        if (i2 == 3) {
            return new zzvh();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzvg(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
