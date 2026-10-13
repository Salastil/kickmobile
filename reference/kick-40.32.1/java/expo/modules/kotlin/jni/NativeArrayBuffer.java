package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.exception.Exceptions;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeArrayBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "Use ArrayBuffer instead", replaceWith = @ReplaceWith(expression = "ArrayBuffer", imports = {}))
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0082 J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\t\u0010\u001c\u001a\u00020\u0007H\u0086 J\u0006\u0010\u001d\u001a\u00020\u0000J\b\u0010\u001e\u001a\u00020\u001fH\u0004J\b\u0010 \u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "mHybridData", "initHybrid", "buffer", "isValid", "", ContentDisposition.Parameters.Size, "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "copy", "finalize", "", "getHybridDataForJNIDeallocator", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeArrayBuffer implements Destructible {
    private final HybridData mHybridData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private final native HybridData initHybrid(ByteBuffer buffer);

    public final native short read2Byte(int position);

    public final native int read4Byte(int position);

    public final native long read8Byte(int position);

    public final native byte readByte(int position);

    public final native double readDouble(int position);

    public final native float readFloat(int position);

    public final native int size();

    public final native ByteBuffer toDirectBuffer();

    private NativeArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public NativeArrayBuffer(ByteBuffer byteBuffer) throws Exceptions.IllegalArgument {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        if (!byteBuffer.isDirect()) {
            throw new Exceptions.IllegalArgument("ArrayBuffers can only be created from direct ByteBuffers", null, 2, null);
        }
        this.mHybridData = initHybrid(byteBuffer);
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public final NativeArrayBuffer copy() {
        return INSTANCE.copyOf(this);
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }

    /* JADX INFO: compiled from: NativeArrayBuffer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/jni/NativeArrayBuffer$Companion;", "", "<init>", "()V", "allocate", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", ContentDisposition.Parameters.Size, "", "wrap", "byteBuffer", "Ljava/nio/ByteBuffer;", "copyOf", "other", "Lexpo/modules/kotlin/jni/ArrayBuffer;", "Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NativeArrayBuffer allocate(int size) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new NativeArrayBuffer(byteBufferAllocateDirect);
        }

        public final NativeArrayBuffer wrap(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            return new NativeArrayBuffer(byteBuffer);
        }

        public final NativeArrayBuffer copyOf(ArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final NativeArrayBuffer copyOf(JavaScriptArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final NativeArrayBuffer copyOf(NativeArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final NativeArrayBuffer copyOf(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            byteBufferAllocateDirect.put(byteBuffer);
            byteBufferAllocateDirect.rewind();
            byteBuffer.rewind();
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new NativeArrayBuffer(byteBufferAllocateDirect);
        }
    }
}
