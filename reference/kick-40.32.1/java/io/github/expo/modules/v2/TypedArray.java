package io.github.expo.modules.v2;

import com.facebook.react.uimanager.ViewProps;
import io.github.expo.modules.v2.jsi.JavaScriptObject;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypedArray.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lio/github/expo/modules/v2/TypedArray;", "", "jsObject", "Lio/github/expo/modules/v2/jsi/JavaScriptObject;", "bytes", "Ljava/nio/ByteBuffer;", "<init>", "(Lio/github/expo/modules/v2/jsi/JavaScriptObject;Ljava/nio/ByteBuffer;)V", "getJsObject", "()Lio/github/expo/modules/v2/jsi/JavaScriptObject;", "byteLength", "", "getByteLength", "()I", "toDirectBuffer", "read", "", "buffer", "", ViewProps.POSITION, ContentDisposition.Parameters.Size, "write", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TypedArray {
    private final ByteBuffer bytes;
    private final JavaScriptObject jsObject;

    public TypedArray(JavaScriptObject jsObject, ByteBuffer bytes) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.jsObject = jsObject;
        this.bytes = bytes;
    }

    public final JavaScriptObject getJsObject() {
        return this.jsObject;
    }

    public final int getByteLength() {
        return this.bytes.capacity();
    }

    public final ByteBuffer toDirectBuffer() {
        ByteBuffer byteBufferOrder = this.bytes.duplicate().order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        return byteBufferOrder;
    }

    public final void read(byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer directBuffer = toDirectBuffer();
        directBuffer.position(position);
        directBuffer.get(buffer, 0, size);
    }

    public final void write(byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer directBuffer = toDirectBuffer();
        directBuffer.position(position);
        directBuffer.put(buffer, 0, size);
    }
}
