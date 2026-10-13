package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzapd extends zzaun implements zzavx {
    private static final zzapd zze;
    private int zza;
    private zzauy zzd = zzaJ();

    static {
        zzapd zzapdVar = new zzapd();
        zze = zzapdVar;
        zzaun.zzaD(zzapd.class, zzapdVar);
    }

    private zzapd() {
    }

    public static zzapa zza() {
        return (zzapa) zze.zzay();
    }

    final /* synthetic */ void zzb(int i) {
        this.zza = i;
    }

    final /* synthetic */ void zzc(zzapc zzapcVar) {
        zzapcVar.getClass();
        zzauy zzauyVar = this.zzd;
        if (!zzauyVar.zza()) {
            this.zzd = zzaun.zzaK(zzauyVar);
        }
        this.zzd.add(zzapcVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzd", zzapc.class});
        }
        if (i2 == 3) {
            return new zzapd();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapa(bArr);
        }
        if (i2 == 5) {
            return zze;
        }
        throw null;
    }
}
