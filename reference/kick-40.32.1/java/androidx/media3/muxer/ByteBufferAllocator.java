package androidx.media3.muxer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface ByteBufferAllocator {
    public static final ByteBufferAllocator DEFAULT = new ByteBufferAllocator() { // from class: androidx.media3.muxer.ByteBufferAllocator$$ExternalSyntheticLambda0
        @Override // androidx.media3.muxer.ByteBufferAllocator
        public final ByteBuffer allocate(int i) {
            return ByteBuffer.allocateDirect(i);
        }
    };

    ByteBuffer allocate(int i);
}
