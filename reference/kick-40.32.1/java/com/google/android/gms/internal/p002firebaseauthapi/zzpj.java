package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpj {
    public static final zzaau zza = zzaau.zza(new byte[0]);

    public static final zzaau zza(int i) {
        return zzaau.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzaau zzb(int i) {
        return zzaau.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
