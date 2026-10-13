package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwi {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzwh zza(String str) throws GeneralSecurityException {
        for (zzwh zzwhVar : zza) {
            if (zzwhVar.zza()) {
                return zzwhVar;
            }
        }
        String.valueOf(str);
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
