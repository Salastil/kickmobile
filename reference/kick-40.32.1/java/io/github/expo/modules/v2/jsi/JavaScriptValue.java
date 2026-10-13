package io.github.expo.modules.v2.jsi;

import io.github.expo.kolibri.NativeObject;
import io.github.expo.kolibri.NativePointer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: JavaScriptValue.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001$B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\t\u0010\b\u001a\u00020\tH\u0083 J\t\u0010\n\u001a\u00020\u000bH\u0087 J\t\u0010\f\u001a\u00020\u000bH\u0087 J\t\u0010\r\u001a\u00020\u000bH\u0087 J\t\u0010\u000e\u001a\u00020\u000bH\u0087 J\t\u0010\u000f\u001a\u00020\u000bH\u0087 J\t\u0010\u0010\u001a\u00020\u000bH\u0087 J\t\u0010\u0011\u001a\u00020\u000bH\u0087 J\t\u0010\u0012\u001a\u00020\u000bH\u0087 J\t\u0010\u0013\u001a\u00020\u000bH\u0087 J\t\u0010\u0014\u001a\u00020\u000bH\u0087 J\t\u0010\u0015\u001a\u00020\u0016H\u0087 J\t\u0010\u0017\u001a\u00020\u0018H\u0087 J\t\u0010\u0019\u001a\u00020\u001aH\u0087 J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0087 ¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0018H\u0016J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 ¢\u0006\u0002\u0010#J\u0011\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 ¨\u0006%"}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "Lio/github/expo/kolibri/NativeObject;", "pointer", "", "<init>", "(J)V", "kind", "Lio/github/expo/modules/v2/jsi/JavaScriptValue$Kind;", "kindCode", "", "isNull", "", "isUndefined", "isBool", "isNumber", "isString", "isSymbol", "isFunction", "isArray", "isObject", "getBool", "getDouble", "", "getString", "", "getObject", "Lio/github/expo/modules/v2/jsi/JavaScriptObject;", "getArray", "", "()[Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "getInt", "getLong", "getFloat", "", "toString", "(J)[Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "Kind", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JavaScriptValue extends NativeObject {
    private final native JavaScriptValue[] getArray(long pointer);

    private final native boolean getBool(long pointer);

    private final native double getDouble(long pointer);

    private final native JavaScriptObject getObject(long pointer);

    private final native String getString(long pointer);

    private final native boolean isArray(long pointer);

    private final native boolean isBool(long pointer);

    private final native boolean isFunction(long pointer);

    private final native boolean isNull(long pointer);

    private final native boolean isNumber(long pointer);

    private final native boolean isObject(long pointer);

    private final native boolean isString(long pointer);

    private final native boolean isSymbol(long pointer);

    private final native boolean isUndefined(long pointer);

    private final int kindCode() {
        return kindCode(this.nativePointer);
    }

    private final native int kindCode(long pointer);

    public final JavaScriptValue[] getArray() {
        return getArray(this.nativePointer);
    }

    public final boolean getBool() {
        return getBool(this.nativePointer);
    }

    public final double getDouble() {
        return getDouble(this.nativePointer);
    }

    public final JavaScriptObject getObject() {
        return getObject(this.nativePointer);
    }

    public final String getString() {
        return getString(this.nativePointer);
    }

    public final boolean isArray() {
        return isArray(this.nativePointer);
    }

    public final boolean isBool() {
        return isBool(this.nativePointer);
    }

    public final boolean isFunction() {
        return isFunction(this.nativePointer);
    }

    public final boolean isNull() {
        return isNull(this.nativePointer);
    }

    public final boolean isNumber() {
        return isNumber(this.nativePointer);
    }

    public final boolean isObject() {
        return isObject(this.nativePointer);
    }

    public final boolean isString() {
        return isString(this.nativePointer);
    }

    public final boolean isSymbol() {
        return isSymbol(this.nativePointer);
    }

    public final boolean isUndefined() {
        return isUndefined(this.nativePointer);
    }

    private JavaScriptValue(long j) {
        super(NativePointer.m12237constructorimpl(j), null);
    }

    /* JADX INFO: compiled from: JavaScriptValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptValue$Kind;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNDEFINED", "NULL", "BOOLEAN", "BIG_INT", "NUMBER", "STRING", "SYMBOL", "OBJECT", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Kind {
        UNDEFINED(0),
        NULL(1),
        BOOLEAN(2),
        BIG_INT(3),
        NUMBER(4),
        STRING(5),
        SYMBOL(6),
        OBJECT(7);

        private final int code;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        Kind(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: compiled from: JavaScriptValue.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptValue$Kind$Companion;", "", "<init>", "()V", "fromCode", "Lio/github/expo/modules/v2/jsi/JavaScriptValue$Kind;", "code", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Kind fromCode(int code) {
                Kind next;
                Iterator<Kind> it = Kind.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (next.getCode() != code);
                Kind kind = next;
                if (kind != null) {
                    return kind;
                }
                throw new IllegalStateException(("Unknown JavaScriptValue kind code: " + code).toString());
            }
        }
    }

    public final Kind kind() {
        return Kind.INSTANCE.fromCode(kindCode());
    }

    public final int getInt() {
        return (int) getDouble();
    }

    public final long getLong() {
        return (long) getDouble();
    }

    public final float getFloat() {
        return (float) getDouble();
    }

    public String toString() {
        return "JavaScriptValue(" + kind() + ")";
    }
}
