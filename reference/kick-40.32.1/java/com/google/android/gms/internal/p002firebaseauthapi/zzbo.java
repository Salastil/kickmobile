package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbo implements zzcm {
    private final InputStream zza;

    public static zzcm zza(byte[] bArr) {
        return new zzbo(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcm
    public final zzwe zza() throws IOException {
        try {
            return zzwe.zza(this.zza, zzalf.zza());
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcm
    public final zzxq zzb() throws IOException {
        try {
            return zzxq.zza(this.zza, zzalf.zza());
        } finally {
            this.zza.close();
        }
    }

    private zzbo(InputStream inputStream) {
        this.zza = inputStream;
    }
}
