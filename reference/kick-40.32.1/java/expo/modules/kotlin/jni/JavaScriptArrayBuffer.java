package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: JavaScriptArrayBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\t\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0086 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0086 J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\tH\u0086 J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\tH\u0086 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\tH\u0086 J\t\u0010\u0016\u001a\u00020\u0017H\u0086 J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0004J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "isValid", "", ContentDisposition.Parameters.Size, "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "copy", "Lexpo/modules/kotlin/jni/ArrayBuffer;", "finalize", "", "getHybridDataForJNIDeallocator", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaScriptArrayBuffer implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;

    public final native short read2Byte(int position);

    public final native int read4Byte(int position);

    public final native long read8Byte(int position);

    public final native byte readByte(int position);

    public final native double readDouble(int position);

    public final native float readFloat(int position);

    public final native int size();

    public final native ByteBuffer toDirectBuffer();

    private JavaScriptArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public final ArrayBuffer copy() {
        return ArrayBuffer.INSTANCE.copyOf(toDirectBuffer());
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
