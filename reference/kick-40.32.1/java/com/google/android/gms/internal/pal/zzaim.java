package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaim {
    public static final zzarq zza = zzarq.zza(new byte[0]);

    public static final zzarq zza(int i) {
        return zzarq.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzarq zzb(int i) {
        return zzarq.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
