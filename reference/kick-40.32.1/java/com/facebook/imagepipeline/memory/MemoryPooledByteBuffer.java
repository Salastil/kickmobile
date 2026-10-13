package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryPooledByteBuffer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038G@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!¨\u0006%"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBuffer;", "Lcom/facebook/common/memory/PooledByteBuffer;", "bufRef", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/memory/MemoryChunk;", ContentDisposition.Parameters.Size, "", "<init>", "(Lcom/facebook/common/references/CloseableReference;I)V", "closeableReference", "getCloseableReference$annotations", "()V", "getCloseableReference", "()Lcom/facebook/common/references/CloseableReference;", "setCloseableReference", "(Lcom/facebook/common/references/CloseableReference;)V", "read", "", "offset", "buffer", "", "bufferOffset", "length", "nativePtr", "", "getNativePtr", "()J", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "isClosed", "", "()Z", "close", "", "ensureValid", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MemoryPooledByteBuffer implements PooledByteBuffer {
    private CloseableReference<MemoryChunk> closeableReference;
    private final int size;

    public static /* synthetic */ void getCloseableReference$annotations() {
    }

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> bufRef, int i) {
        Intrinsics.checkNotNullParameter(bufRef, "bufRef");
        Preconditions.checkArgument(Boolean.valueOf(i >= 0 && i <= bufRef.get().getSize()));
        this.closeableReference = bufRef.mo11277clone();
        this.size = i;
    }

    public final CloseableReference<MemoryChunk> getCloseableReference() {
        return this.closeableReference;
    }

    public final void setCloseableReference(CloseableReference<MemoryChunk> closeableReference) {
        this.closeableReference = closeableReference;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        ensureValid();
        return this.size;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int offset) {
        CloseableReference<MemoryChunk> closeableReference;
        ensureValid();
        boolean z = true;
        Preconditions.checkArgument(Boolean.valueOf(offset >= 0));
        if (offset >= this.size) {
            z = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z));
        Preconditions.checkNotNull(this.closeableReference);
        closeableReference = this.closeableReference;
        Intrinsics.checkNotNull(closeableReference);
        return closeableReference.get().read(offset);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int offset, byte[] buffer, int bufferOffset, int length) {
        CloseableReference<MemoryChunk> closeableReference;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ensureValid();
        Preconditions.checkArgument(Boolean.valueOf(offset + length <= this.size));
        Preconditions.checkNotNull(this.closeableReference);
        closeableReference = this.closeableReference;
        Intrinsics.checkNotNull(closeableReference);
        return closeableReference.get().read(offset, buffer, bufferOffset, length);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long getNativePtr() throws UnsupportedOperationException {
        CloseableReference<MemoryChunk> closeableReference;
        ensureValid();
        Preconditions.checkNotNull(this.closeableReference);
        closeableReference = this.closeableReference;
        Intrinsics.checkNotNull(closeableReference);
        return closeableReference.get().getNativePtr();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized ByteBuffer getByteBuffer() {
        CloseableReference<MemoryChunk> closeableReference;
        Preconditions.checkNotNull(this.closeableReference);
        closeableReference = this.closeableReference;
        Intrinsics.checkNotNull(closeableReference);
        return closeableReference.get().getByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.closeableReference);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference.closeSafely(this.closeableReference);
        this.closeableReference = null;
    }

    public final synchronized void ensureValid() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
