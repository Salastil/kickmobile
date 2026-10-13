package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzbb implements zzbi {
    public zzbi zza(byte[] bArr, int i, int i2) {
        zzu.zza(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            zza(bArr[i3]);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final zzbi zza(CharSequence charSequence, Charset charset) {
        byte[] bytes = charSequence.toString().getBytes(charset);
        return zza(bytes, 0, bytes.length);
    }

    zzbb() {
    }
}
