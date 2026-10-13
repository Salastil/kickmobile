package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzafq {
    private static final byte[] zza = new byte[0];

    public static zzafp zza(zzaea zzaeaVar) throws GeneralSecurityException {
        zzwk zzwkVarZzf = zzaeaVar.zzf();
        if (zzwkVarZzf instanceof zzxw) {
            return new zzafn((zzxw) zzwkVarZzf);
        }
        if (zzwkVarZzf instanceof zzxf) {
            return new zzafm((zzxf) zzwkVarZzf);
        }
        if (zzwkVarZzf instanceof zzacz) {
            return new zzafo((zzacz) zzwkVarZzf);
        }
        String strValueOf = String.valueOf(zzwkVarZzf);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unsupported DEM parameters: ".concat(String.valueOf(strValueOf)));
    }
}
