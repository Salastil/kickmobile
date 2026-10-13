package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaok extends zzaun implements zzavx {
    private static final zzaok zzf;
    private int zza;
    private int zzd;
    private int zze;

    static {
        zzaok zzaokVar = new zzaok();
        zzf = zzaokVar;
        zzaun.zzaD(zzaok.class, zzaokVar);
    }

    private zzaok() {
    }

    public static zzaoj zzd() {
        return (zzaoj) zzf.zzay();
    }

    public static zzaok zze() {
        return zzf;
    }

    public final zzaog zza() {
        zzaog zzaogVar;
        switch (this.zza) {
            case 0:
                zzaogVar = zzaog.KEM_UNKNOWN;
                break;
            case 1:
                zzaogVar = zzaog.DHKEM_X25519_HKDF_SHA256;
                break;
            case 2:
                zzaogVar = zzaog.DHKEM_P256_HKDF_SHA256;
                break;
            case 3:
                zzaogVar = zzaog.DHKEM_P384_HKDF_SHA384;
                break;
            case 4:
                zzaogVar = zzaog.DHKEM_P521_HKDF_SHA512;
                break;
            case 5:
                zzaogVar = zzaog.X_WING;
                break;
            case 6:
                zzaogVar = zzaog.ML_KEM768;
                break;
            case 7:
                zzaogVar = zzaog.ML_KEM1024;
                break;
            default:
                zzaogVar = null;
                break;
        }
        return zzaogVar == null ? zzaog.UNRECOGNIZED : zzaogVar;
    }

    public final zzaof zzb() {
        zzaof zzaofVar;
        int i = this.zzd;
        if (i == 0) {
            zzaofVar = zzaof.KDF_UNKNOWN;
        } else if (i == 1) {
            zzaofVar = zzaof.HKDF_SHA256;
        } else if (i != 2) {
            zzaofVar = i != 3 ? null : zzaof.HKDF_SHA512;
        } else {
            zzaofVar = zzaof.HKDF_SHA384;
        }
        return zzaofVar == null ? zzaof.UNRECOGNIZED : zzaofVar;
    }

    public final zzaoe zzc() {
        zzaoe zzaoeVar;
        int i = this.zze;
        if (i == 0) {
            zzaoeVar = zzaoe.AEAD_UNKNOWN;
        } else if (i == 1) {
            zzaoeVar = zzaoe.AES_128_GCM;
        } else if (i != 2) {
            zzaoeVar = i != 3 ? null : zzaoe.CHACHA20_POLY1305;
        } else {
            zzaoeVar = zzaoe.AES_256_GCM;
        }
        return zzaoeVar == null ? zzaoe.UNRECOGNIZED : zzaoeVar;
    }

    final /* synthetic */ void zzf(zzaog zzaogVar) {
        this.zza = zzaogVar.zza();
    }

    final /* synthetic */ void zzg(zzaof zzaofVar) {
        this.zzd = zzaofVar.zza();
    }

    final /* synthetic */ void zzh(zzaoe zzaoeVar) {
        this.zze = zzaoeVar.zza();
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zza", "zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaok();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzaoj(bArr);
        }
        if (i2 == 5) {
            return zzf;
        }
        throw null;
    }
}
