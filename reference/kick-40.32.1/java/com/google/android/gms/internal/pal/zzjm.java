package com.google.android.gms.internal.pal;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzjm implements zzjp {
    private static final zzbd zza;

    static {
        zzad zzadVarZzg = zzbd.zzg();
        zzadVarZzg.zzo(ExifInterface.LONGITUDE_EAST);
        zza = (zzbd) zzadVarZzg.zzal();
    }

    zzjm() {
    }

    @Override // com.google.android.gms.internal.pal.zzjp
    public final zzbd zza() {
        return zza;
    }
}
