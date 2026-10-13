package com.facebook.react.bridge;

import com.facebook.jni.HybridClassBase;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayBuffer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\t\u0010\u0014\u001a\u00020\u0005H\u0082 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/bridge/ArrayBuffer;", "Lcom/facebook/jni/HybridClassBase;", "buffer", "Ljava/nio/ByteBuffer;", "isOwningBytes", "", "<init>", "(Ljava/nio/ByteBuffer;Z)V", ContentDisposition.Parameters.Size, "", "(I)V", "()Z", "bytes", "getBytes", "()Ljava/nio/ByteBuffer;", "getSize", "()I", "checkBytesValid", "", "initHybrid", "isBytesValid", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArrayBuffer extends HybridClassBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteBuffer buffer;
    private final boolean isOwningBytes;

    public /* synthetic */ ArrayBuffer(ByteBuffer byteBuffer, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, z);
    }

    @JvmStatic
    public static final ArrayBuffer arrayBufferWithCopiedBytes(ArrayBuffer arrayBuffer) {
        return INSTANCE.arrayBufferWithCopiedBytes(arrayBuffer);
    }

    @JvmStatic
    public static final ArrayBuffer arrayBufferWithCopiedBytes(ByteBuffer byteBuffer) {
        return INSTANCE.arrayBufferWithCopiedBytes(byteBuffer);
    }

    @JvmStatic
    public static final ArrayBuffer arrayBufferWithCopiedBytes(byte[] bArr) {
        return INSTANCE.arrayBufferWithCopiedBytes(bArr);
    }

    @JvmStatic
    public static final ArrayBuffer arrayBufferWithLength(int i) {
        return INSTANCE.arrayBufferWithLength(i);
    }

    @JvmStatic
    public static final ArrayBuffer arrayBufferWithOwnedBytes(ByteBuffer byteBuffer) {
        return INSTANCE.arrayBufferWithOwnedBytes(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void initHybrid(ByteBuffer buffer, boolean isOwningBytes);

    private final native boolean isBytesValid();

    /* JADX INFO: renamed from: isOwningBytes, reason: from getter */
    public final boolean getIsOwningBytes() {
        return this.isOwningBytes;
    }

    private ArrayBuffer(ByteBuffer byteBuffer, boolean z) {
        this.buffer = byteBuffer;
        this.isOwningBytes = z;
    }

    public ArrayBuffer(int i) {
        this(INSTANCE.allocateDirect(i), true);
        initHybrid(this.buffer, this.isOwningBytes);
    }

    public final ByteBuffer getBytes() {
        checkBytesValid();
        return this.buffer;
    }

    public final int getSize() {
        checkBytesValid();
        return this.buffer.capacity();
    }

    private final void checkBytesValid() {
        if (!isBytesValid()) {
            throw new IllegalStateException("ArrayBuffer: the bytes of a non-owning ArrayBuffer were accessed after the method that received it returned. Copy them with ArrayBuffer.arrayBufferWithCopiedBytes() to use them later.".toString());
        }
    }

    /* JADX INFO: compiled from: ArrayBuffer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/bridge/ArrayBuffer$Companion;", "", "<init>", "()V", "arrayBufferWithLength", "Lcom/facebook/react/bridge/ArrayBuffer;", ContentDisposition.Parameters.Size, "", "arrayBufferWithCopiedBytes", "bytes", "", "source", "Ljava/nio/ByteBuffer;", "arrayBufferWithOwnedBytes", "buffer", "allocateDirect", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ArrayBuffer arrayBufferWithLength(int size) {
            return new ArrayBuffer(size);
        }

        @JvmStatic
        public final ArrayBuffer arrayBufferWithCopiedBytes(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            ArrayBuffer arrayBuffer = new ArrayBuffer(bytes.length);
            if (!(bytes.length == 0)) {
                arrayBuffer.getBytes().put(bytes);
                arrayBuffer.getBytes().rewind();
            }
            return arrayBuffer;
        }

        @JvmStatic
        public final ArrayBuffer arrayBufferWithCopiedBytes(ByteBuffer source) {
            Intrinsics.checkNotNullParameter(source, "source");
            int iRemaining = source.remaining();
            ArrayBuffer arrayBuffer = new ArrayBuffer(iRemaining);
            if (iRemaining > 0) {
                arrayBuffer.getBytes().put(source.duplicate());
                arrayBuffer.getBytes().rewind();
            }
            return arrayBuffer;
        }

        @JvmStatic
        public final ArrayBuffer arrayBufferWithCopiedBytes(ArrayBuffer source) {
            Intrinsics.checkNotNullParameter(source, "source");
            int size = source.getSize();
            ArrayBuffer arrayBuffer = new ArrayBuffer(size);
            if (size > 0) {
                ByteBuffer byteBufferDuplicate = source.getBytes().duplicate();
                byteBufferDuplicate.position(0);
                byteBufferDuplicate.limit(size);
                arrayBuffer.getBytes().put(byteBufferDuplicate);
                arrayBuffer.getBytes().rewind();
            }
            return arrayBuffer;
        }

        @JvmStatic
        public final ArrayBuffer arrayBufferWithOwnedBytes(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (!buffer.isDirect()) {
                throw new IllegalArgumentException("arrayBufferWithOwnedBytes requires a direct ByteBuffer".toString());
            }
            ArrayBuffer arrayBuffer = new ArrayBuffer(buffer, true, null);
            arrayBuffer.initHybrid(buffer, arrayBuffer.getIsOwningBytes());
            return arrayBuffer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ByteBuffer allocateDirect(int size) {
            if (size < 0) {
                throw new IllegalArgumentException(("ArrayBuffer size must not be negative, got " + size).toString());
            }
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocateDirect, "allocateDirect(...)");
            return byteBufferAllocateDirect;
        }
    }

    static {
        ReactNativeJniCommonSoLoader.staticInit();
    }
}
