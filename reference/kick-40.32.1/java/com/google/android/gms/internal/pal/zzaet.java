package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaet {
    static {
        int i = zzapo.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzafc.zzc();
        zzafg.zzc();
        zzwp.zza();
        zzada.zza();
        if (zzacp.zza()) {
            return;
        }
        zzadt.zza(true);
        zzagl.zza(true);
    }
}
