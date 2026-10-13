package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakn {
    static {
        int i = zzapo.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzakt.zzc();
        zzakb.zzc();
        zzaki.zza(true);
        if (zzacp.zza()) {
            return;
        }
        zzajv.zza(true);
    }
}
