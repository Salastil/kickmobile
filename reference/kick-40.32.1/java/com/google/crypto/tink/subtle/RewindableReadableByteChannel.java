package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes8.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer = null;
    boolean canRewind = true;
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel baseChannel) {
        this.baseChannel = baseChannel;
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    public synchronized void rewind() throws IOException {
        if (!this.canRewind) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    private synchronized void setBufferLimit(int newLimit) {
        if (this.buffer.capacity() < newLimit) {
            int iPosition = this.buffer.position();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.buffer.capacity() * 2, newLimit));
            this.buffer.rewind();
            byteBufferAllocate.put(this.buffer);
            byteBufferAllocate.position(iPosition);
            this.buffer = byteBufferAllocate;
        }
        this.buffer.limit(newLimit);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (this.directRead) {
            return this.baseChannel.read(dst);
        }
        int iRemaining = dst.remaining();
        if (iRemaining == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            if (!this.canRewind) {
                this.directRead = true;
                return this.baseChannel.read(dst);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
            this.buffer = byteBufferAllocate;
            int i = this.baseChannel.read(byteBufferAllocate);
            this.buffer.flip();
            if (i > 0) {
                dst.put(this.buffer);
            }
            return i;
        }
        int iRemaining2 = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = this.buffer;
        if (iRemaining2 >= iRemaining) {
            int iLimit = byteBuffer2.limit();
            ByteBuffer byteBuffer3 = this.buffer;
            byteBuffer3.limit(byteBuffer3.position() + iRemaining);
            dst.put(this.buffer);
            this.buffer.limit(iLimit);
            if (!this.canRewind && !this.buffer.hasRemaining()) {
                this.buffer = null;
                this.directRead = true;
            }
            return iRemaining;
        }
        int iRemaining3 = byteBuffer2.remaining();
        int iPosition = this.buffer.position();
        int iLimit2 = this.buffer.limit();
        setBufferLimit((iRemaining - iRemaining3) + iLimit2);
        this.buffer.position(iLimit2);
        int i2 = this.baseChannel.read(this.buffer);
        this.buffer.flip();
        this.buffer.position(iPosition);
        dst.put(this.buffer);
        if (iRemaining3 == 0 && i2 < 0) {
            return -1;
        }
        int iPosition2 = this.buffer.position() - iPosition;
        if (!this.canRewind && !this.buffer.hasRemaining()) {
            this.buffer = null;
            this.directRead = true;
        }
        return iPosition2;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }
}
