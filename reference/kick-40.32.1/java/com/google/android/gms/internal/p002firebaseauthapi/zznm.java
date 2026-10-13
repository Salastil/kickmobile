package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.spec.EncodedKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznm extends EncodedKeySpec {
    @Override // java.security.spec.EncodedKeySpec
    public final String getFormat() {
        return "raw";
    }

    zznm(byte[] bArr) {
        super(bArr);
    }
}
