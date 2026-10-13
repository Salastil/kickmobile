package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapc extends zzaun implements zzavx {
    private static final zzapc zzg;
    private String zza = "";
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzapc zzapcVar = new zzapc();
        zzg = zzapcVar;
        zzaun.zzaD(zzapc.class, zzapcVar);
    }

    private zzapc() {
    }

    public static zzapb zza() {
        return (zzapb) zzg.zzay();
    }

    final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza = str;
    }

    final /* synthetic */ void zzc(int i) {
        this.zze = i;
    }

    final /* synthetic */ void zzd(zzapm zzapmVar) {
        this.zzf = zzapmVar.zza();
    }

    final /* synthetic */ void zzf(int i) {
        this.zzd = zzaor.zza(i);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zza", "zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzapc();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapb(bArr);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }
}
