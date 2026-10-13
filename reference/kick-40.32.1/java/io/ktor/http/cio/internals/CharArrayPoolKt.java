package io.ktor.http.cio.internals;

import io.ktor.utils.io.pool.DefaultPool;
import io.ktor.utils.io.pool.NoPoolImpl;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;

/* JADX INFO: compiled from: CharArrayPool.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\" \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "CHAR_ARRAY_POOL_SIZE", "I", "CHAR_BUFFER_ARRAY_LENGTH", "Lio/ktor/utils/io/pool/ObjectPool;", "", "CharArrayPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getCharArrayPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CharArrayPoolKt {
    public static final int CHAR_ARRAY_POOL_SIZE = 4096;
    public static final int CHAR_BUFFER_ARRAY_LENGTH = 2048;
    private static final ObjectPool<char[]> CharArrayPool;

    static {
        DefaultPool<char[]> defaultPool;
        if (CharArrayPoolJvmKt.isPoolingDisabled()) {
            defaultPool = new NoPoolImpl<char[]>() { // from class: io.ktor.http.cio.internals.CharArrayPoolKt$CharArrayPool$1
                @Override // io.ktor.utils.io.pool.ObjectPool
                public char[] borrow() {
                    return new char[2048];
                }
            };
        } else {
            defaultPool = new DefaultPool<char[]>() { // from class: io.ktor.http.cio.internals.CharArrayPoolKt$CharArrayPool$2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.ktor.utils.io.pool.DefaultPool
                public char[] produceInstance() {
                    return new char[2048];
                }
            };
        }
        CharArrayPool = defaultPool;
    }

    public static final ObjectPool<char[]> getCharArrayPool() {
        return CharArrayPool;
    }
}
