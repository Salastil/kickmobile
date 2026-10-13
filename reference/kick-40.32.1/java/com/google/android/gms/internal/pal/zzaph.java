package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaph extends zzaun implements zzavx {
    private static final zzaph zzd;
    private String zza = "";

    static {
        zzaph zzaphVar = new zzaph();
        zzd = zzaphVar;
        zzaun.zzaD(zzaph.class, zzaphVar);
    }

    private zzaph() {
    }

    public static zzaph zzb(zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        return (zzaph) zzaun.zzaM(zzd, zzatlVar, zzatyVar);
    }

    public static zzapg zzc() {
        return (zzapg) zzd.zzay();
    }

    public static zzaph zzd() {
        return zzd;
    }

    public final String zza() {
        return this.zza;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzd, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (i2 == 3) {
            return new zzaph();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzapg(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
