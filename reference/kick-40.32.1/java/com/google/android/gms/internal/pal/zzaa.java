package com.google.android.gms.internal.pal;

import androidx.compose.ui.autofill.AutofillUtils_androidKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaa extends zzaun implements zzavx {
    private static final zzaa zzi;
    private int zza;
    private boolean zzd;
    private int zze = AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzaa zzaaVar = new zzaa();
        zzi = zzaaVar;
        zzaun.zzaD(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    public static zzaa zzd() {
        return zzi;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaE(zzi, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzaa();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzz(bArr);
        }
        if (i2 == 5) {
            return zzi;
        }
        throw null;
    }
}
