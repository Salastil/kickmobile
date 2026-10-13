package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaoq extends zzaun implements zzavx {
    private static final zzaoq zzf;
    private String zza = "";
    private zzatl zzd = zzatl.zza;
    private int zze;

    static {
        zzaoq zzaoqVar = new zzaoq();
        zzf = zzaoqVar;
        zzaun.zzaD(zzaoq.class, zzaoqVar);
    }

    private zzaoq() {
    }

    public static zzaop zzc() {
        return (zzaop) zzf.zzay();
    }

    public static zzaoq zzd() {
        return zzf;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzatl zzb() {
        return this.zzd;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }

    final /* synthetic */ void zzf(zzatl zzatlVar) {
        zzatlVar.getClass();
        this.zzd = zzatlVar;
    }

    public final int zzh() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i == 2) {
                i2 = 4;
            } else if (i != 3) {
                i2 = i != 4 ? 0 : 6;
            } else {
                i2 = 5;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    final /* synthetic */ void zzi(int i) {
        if (i == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zze = i - 2;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaoq();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaop(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
