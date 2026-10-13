package io.github.expo.modules.v2.jsi;

import io.github.expo.kolibri.NativeObject;
import io.github.expo.kolibri.NativeObjectKt;
import io.github.expo.kolibri.NativePointer;
import io.github.expo.modules.v2.ExpoObject;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: JavaScriptObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0087 J\t\u0010\b\u001a\u00020\u0007H\u0087 J\u000b\u0010\t\u001a\u0004\u0018\u00010\nH\u0087 J\u0011\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0087 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0087 J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0087 ¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087 ¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0018\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0083 J\u001b\u0010\u001a\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0083 J\u001d\u0010\u001b\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0083 J\u001d\u0010\u001c\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0083 J\u0011\u0010\u001d\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0087 J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0087 J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020!J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0011\u0010$\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0086\u0002J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0086\u0002J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020!H\u0086\u0002J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0086\u0002J\u001b\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0086\u0002J\u001b\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0086\u0002J\u001b\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0086\u0002J\u001b\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0086\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 ¢\u0006\u0002\u0010&J\u0013\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0082 J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 ¢\u0006\u0002\u0010'J\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0082 J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0082 J!\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0082 J!\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J!\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J#\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0082 J\u0019\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0082 ¨\u0006("}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptObject;", "Lio/github/expo/kolibri/NativeObject;", "pointer", "", "<init>", "(J)V", "isArray", "", "isArrayBuffer", "getArrayBufferViewBytes", "Ljava/nio/ByteBuffer;", "hasProperty", "name", "", "getProperty", "Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "getPropertyNames", "", "()[Ljava/lang/String;", "getArray", "()[Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "setBoolProperty", "", "value", "setDoubleProperty", "", "setStringProperty", "setJSValueProperty", "setObjectProperty", "unsetProperty", "nativeInstance", "Lio/github/expo/modules/v2/ExpoObject;", "setProperty", "", AbstractJsonLexerKt.NULL, "", "get", "set", "(J)[Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "(J)[Ljava/lang/String;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JavaScriptObject extends NativeObject {
    private final native JavaScriptValue[] getArray(long pointer);

    private final native ByteBuffer getArrayBufferViewBytes(long pointer);

    private final native JavaScriptValue getProperty(long pointer, String name);

    private final native String[] getPropertyNames(long pointer);

    private final native boolean hasProperty(long pointer, String name);

    private final native boolean isArray(long pointer);

    private final native boolean isArrayBuffer(long pointer);

    private final native ExpoObject nativeInstance(long pointer);

    private final native void setBoolProperty(long pointer, String name, boolean value);

    private final void setBoolProperty(String name, boolean value) {
        setBoolProperty(this.nativePointer, name, value);
    }

    private final native void setDoubleProperty(long pointer, String name, double value);

    private final void setDoubleProperty(String name, double value) {
        setDoubleProperty(this.nativePointer, name, value);
    }

    private final native void setJSValueProperty(long pointer, String name, long value);

    private final void setJSValueProperty(String name, JavaScriptValue value) {
        JavaScriptValue javaScriptValue = value;
        setJSValueProperty(this.nativePointer, name, NativeObjectKt.nativePointerOf(javaScriptValue));
        NativeObjectKt.reachabilityFenceOf(javaScriptValue);
    }

    private final native void setObjectProperty(long pointer, String name, long value);

    private final void setObjectProperty(String name, JavaScriptObject value) {
        JavaScriptObject javaScriptObject = value;
        setObjectProperty(this.nativePointer, name, NativeObjectKt.nativePointerOf(javaScriptObject));
        NativeObjectKt.reachabilityFenceOf(javaScriptObject);
    }

    private final native void setStringProperty(long pointer, String name, String value);

    private final void setStringProperty(String name, String value) {
        setStringProperty(this.nativePointer, name, value);
    }

    private final native void unsetProperty(long pointer, String name);

    public final JavaScriptValue[] getArray() {
        return getArray(this.nativePointer);
    }

    public final ByteBuffer getArrayBufferViewBytes() {
        return getArrayBufferViewBytes(this.nativePointer);
    }

    public final JavaScriptValue getProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getProperty(this.nativePointer, name);
    }

    public final String[] getPropertyNames() {
        return getPropertyNames(this.nativePointer);
    }

    public final boolean hasProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return hasProperty(this.nativePointer, name);
    }

    public final boolean isArray() {
        return isArray(this.nativePointer);
    }

    public final boolean isArrayBuffer() {
        return isArrayBuffer(this.nativePointer);
    }

    public final ExpoObject nativeInstance() {
        return nativeInstance(this.nativePointer);
    }

    public final void unsetProperty(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        unsetProperty(this.nativePointer, name);
    }

    private JavaScriptObject(long j) {
        super(NativePointer.m12237constructorimpl(j), null);
    }

    public final void setProperty(String name, boolean value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setBoolProperty(name, value);
    }

    public final void setProperty(String name, int value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setDoubleProperty(name, value);
    }

    public final void setProperty(String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setDoubleProperty(name, value);
    }

    public final void setProperty(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setStringProperty(name, value);
    }

    public final void setProperty(String name, JavaScriptValue value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setJSValueProperty(name, value);
    }

    public final void setProperty(String name, JavaScriptObject value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setObjectProperty(name, value);
    }

    public final void setProperty(String name, Void r2) {
        Intrinsics.checkNotNullParameter(name, "name");
        unsetProperty(name);
    }

    public final JavaScriptValue get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getProperty(name);
    }

    public final void set(String name, boolean value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, int value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, JavaScriptValue value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, JavaScriptObject value) {
        Intrinsics.checkNotNullParameter(name, "name");
        setProperty(name, value);
    }

    public final void set(String name, Void r2) {
        Intrinsics.checkNotNullParameter(name, "name");
        unsetProperty(name);
    }
}
