package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"io/ktor/websocket/UtilsKt__UtilsJvmKt", "io/ktor/websocket/UtilsKt__UtilsKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    public static final int flagAt(boolean z, int i) {
        return UtilsKt__UtilsKt.flagAt(z, i);
    }

    public static final Integer getOUTGOING_CHANNEL_CAPACITY() {
        return UtilsKt__UtilsJvmKt.getOUTGOING_CHANNEL_CAPACITY();
    }

    public static final byte xor(byte b, byte b2) {
        return UtilsKt__UtilsKt.xor(b, b2);
    }

    public static final void xor(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        UtilsKt__UtilsJvmKt.xor(byteBuffer, byteBuffer2);
    }
}
