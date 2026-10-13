package com.google.android.gms.internal.pal;

import android.util.Base64;
import android.util.Log;
import com.google.ads.interactivemedia.pal.NonceLoaderException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzcd implements zzcc {
    private final zzvw zza;

    zzcd(zzvw zzvwVar) {
        this.zza = zzvwVar;
    }

    @Override // com.google.android.gms.internal.pal.zzcc
    public final String zza(String str) throws NonceLoaderException {
        try {
            return Base64.encodeToString(this.zza.zza(str.getBytes(StandardCharsets.UTF_8), new byte[0]), 10);
        } catch (IllegalArgumentException | GeneralSecurityException e) {
            Log.e("NonceGenerator", "Failed to encrypt the string.", e);
            throw new NonceLoaderException(204, e);
        }
    }
}
