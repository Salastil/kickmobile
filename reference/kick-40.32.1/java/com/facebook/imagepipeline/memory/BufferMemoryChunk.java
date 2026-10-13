package com.facebook.imagepipeline.memory;

import android.util.Log;
import io.ktor.http.ContentDisposition;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferMemoryChunk.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\t\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J(\u0010$\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\"\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011¨\u0006&"}, d2 = {"Lcom/facebook/imagepipeline/memory/BufferMemoryChunk;", "Lcom/facebook/imagepipeline/memory/MemoryChunk;", "Ljava/io/Closeable;", ContentDisposition.Parameters.Size, "", "<init>", "(I)V", "getSize", "()I", "value", "Ljava/nio/ByteBuffer;", "byteBuffer", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "uniqueId", "", "getUniqueId", "()J", "close", "", "isClosed", "", "write", "memoryOffset", "byteArray", "", "byteArrayOffset", "count", "read", "", "offset", "copy", "other", "otherOffset", "nativePtr", "getNativePtr", "doCopy", "Companion", "simple_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "BufferMemoryChunk";
    private final int size;
    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(getSize());
    private final long uniqueId = System.identityHashCode(this);

    public BufferMemoryChunk(int i) {
        this.size = i;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.size;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.byteBuffer = null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return getByteBuffer() == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int memoryOffset, byte[] byteArray, int byteArrayOffset, int count) {
        int iAdjustByteCount;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (isClosed()) {
            throw new IllegalStateException("Check failed.");
        }
        if (getByteBuffer() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        iAdjustByteCount = MemoryChunkUtil.adjustByteCount(memoryOffset, count, getSize());
        MemoryChunkUtil.checkBounds(memoryOffset, byteArray.length, byteArrayOffset, iAdjustByteCount, getSize());
        ByteBuffer byteBuffer = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.position(memoryOffset);
        ByteBuffer byteBuffer2 = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer2);
        byteBuffer2.put(byteArray, byteArrayOffset, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int memoryOffset, byte[] byteArray, int byteArrayOffset, int count) {
        int iAdjustByteCount;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (isClosed()) {
            throw new IllegalStateException("Check failed.");
        }
        if (getByteBuffer() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        iAdjustByteCount = MemoryChunkUtil.adjustByteCount(memoryOffset, count, getSize());
        MemoryChunkUtil.checkBounds(memoryOffset, byteArray.length, byteArrayOffset, iAdjustByteCount, getSize());
        ByteBuffer byteBuffer = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.position(memoryOffset);
        ByteBuffer byteBuffer2 = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer2);
        byteBuffer2.get(byteArray, byteArrayOffset, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int offset) {
        ByteBuffer byteBuffer;
        if (isClosed()) {
            throw new IllegalStateException("Check failed.");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (offset >= getSize()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (getByteBuffer() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        byteBuffer = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer);
        return byteBuffer.get(offset);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int offset, MemoryChunk other, int otherOffset, int count) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.getUniqueId() == getUniqueId()) {
            Log.w(TAG, "Copying from BufferMemoryChunk " + Long.toHexString(getUniqueId()) + " to BufferMemoryChunk " + Long.toHexString(other.getUniqueId()) + " which are the same ");
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (other.getUniqueId() < getUniqueId()) {
            synchronized (other) {
                synchronized (this) {
                    doCopy(offset, other, otherOffset, count);
                    Unit unit = Unit.INSTANCE;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            return;
        }
        synchronized (this) {
            synchronized (other) {
                doCopy(offset, other, otherOffset, count);
                Unit unit3 = Unit.INSTANCE;
            }
            Unit unit4 = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    private final void doCopy(int offset, MemoryChunk other, int otherOffset, int count) {
        if (!(other instanceof BufferMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks".toString());
        }
        if (isClosed()) {
            throw new IllegalStateException("Check failed.");
        }
        BufferMemoryChunk bufferMemoryChunk = (BufferMemoryChunk) other;
        if (bufferMemoryChunk.isClosed()) {
            throw new IllegalStateException("Check failed.");
        }
        if (getByteBuffer() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        MemoryChunkUtil.checkBounds(offset, bufferMemoryChunk.getSize(), otherOffset, count, getSize());
        ByteBuffer byteBuffer = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.position(offset);
        ByteBuffer byteBuffer2 = bufferMemoryChunk.getByteBuffer();
        if (byteBuffer2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        byteBuffer2.position(otherOffset);
        byte[] bArr = new byte[count];
        ByteBuffer byteBuffer3 = getByteBuffer();
        Intrinsics.checkNotNull(byteBuffer3);
        byteBuffer3.get(bArr, 0, count);
        byteBuffer2.put(bArr, 0, count);
    }
}
