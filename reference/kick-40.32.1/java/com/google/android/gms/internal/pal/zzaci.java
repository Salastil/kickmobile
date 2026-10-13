package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaci extends ThreadLocal {
    zzaci() {
    }

    @Nullable
    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzaqx.zza.zzb("AES/GCM-SIV/NoPadding");
            if (zzaba.zzb(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    @Nullable
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
