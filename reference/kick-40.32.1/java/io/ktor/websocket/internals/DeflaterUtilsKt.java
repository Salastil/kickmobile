package io.ktor.websocket.internals;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.SourcesKt;

/* JADX INFO: compiled from: DeflaterUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Ljava/util/zip/Deflater;", "", "data", "deflateFully", "(Ljava/util/zip/Deflater;[B)[B", "Ljava/util/zip/Inflater;", "inflateFully", "(Ljava/util/zip/Inflater;[B)[B", "Lkotlinx/io/Sink;", "deflater", "Ljava/nio/ByteBuffer;", "buffer", "", "flush", "", "deflateTo", "(Lkotlinx/io/Sink;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Z)I", "PADDED_EMPTY_CHUNK", "[B", "EMPTY_CHUNK", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] data) {
        Intrinsics.checkNotNullParameter(deflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        deflater.setInput(data);
        Buffer buffer = new Buffer();
        Buffer buffer2 = buffer;
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            while (!deflater.needsInput()) {
                deflateTo(buffer2, deflater, byteBuffer, false);
            }
            while (deflateTo(buffer2, deflater, byteBuffer, true) != 0) {
            }
            Unit unit = Unit.INSTANCE;
            ktorDefaultPool.recycle(byteBufferBorrow);
            Buffer buffer3 = buffer;
            if (BytePacketUtilsKt.endsWith(buffer3, PADDED_EMPTY_CHUNK)) {
                byte[] byteArray = SourcesKt.readByteArray(buffer3, ((int) ByteReadPacketKt.getRemaining(buffer3)) - EMPTY_CHUNK.length);
                buffer3.close();
                return byteArray;
            }
            Buffer buffer4 = new Buffer();
            Buffer buffer5 = buffer4;
            BytePacketBuilderKt.writePacket(buffer5, buffer3);
            buffer5.writeByte((byte) 0);
            return SourcesKt.readByteArray(buffer4);
        } catch (Throwable th) {
            ktorDefaultPool.recycle(byteBufferBorrow);
            throw th;
        }
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] data) {
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrPlus = ArraysKt.plus(data, EMPTY_CHUNK);
        inflater.setInput(bArrPlus);
        Buffer buffer = new Buffer();
        Buffer buffer2 = buffer;
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            long length = ((long) bArrPlus.length) + inflater.getBytesRead();
            while (inflater.getBytesRead() < length) {
                byteBuffer.clear();
                byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                byteBuffer.flip();
                BytePacketBuilderExtensions_jvmKt.writeFully(buffer2, byteBuffer);
            }
            Unit unit = Unit.INSTANCE;
            return SourcesKt.readByteArray(buffer);
        } finally {
            ktorDefaultPool.recycle(byteBufferBorrow);
        }
    }

    private static final int deflateTo(Sink sink, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        int iDeflate;
        byteBuffer.clear();
        if (z) {
            iDeflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2);
        } else {
            iDeflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        }
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        BytePacketBuilderExtensions_jvmKt.writeFully(sink, byteBuffer);
        return iDeflate;
    }
}
