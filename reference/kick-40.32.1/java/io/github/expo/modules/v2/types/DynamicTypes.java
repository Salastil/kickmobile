package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.jsi.JavaScriptObject;
import io.github.expo.modules.v2.jsi.JavaScriptValue;
import io.github.expo.modules.v2.records.RecordRegistry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DynamicTypes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/github/expo/modules/v2/types/DynamicTypes;", "", "<init>", "()V", "UNKNOWN", "", "kindOf", "value", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DynamicTypes {
    public static final DynamicTypes INSTANCE = new DynamicTypes();
    public static final int UNKNOWN = -1;

    private DynamicTypes() {
    }

    @JvmStatic
    public static final int kindOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof String) {
            return CppType.INSTANCE.m12443getSTRINGz4oZPQ();
        }
        if (value instanceof Integer) {
            return CppType.INSTANCE.m12433getINTz4oZPQ();
        }
        if (value instanceof Double) {
            return CppType.INSTANCE.m12429getDOUBLEz4oZPQ();
        }
        if (value instanceof Boolean) {
            return CppType.INSTANCE.m12421getBOOLEANz4oZPQ();
        }
        if (value instanceof List) {
            return CppType.INSTANCE.m12437getLISTz4oZPQ();
        }
        if (value instanceof Map) {
            return CppType.INSTANCE.m12440getMAPz4oZPQ();
        }
        if (value instanceof Long) {
            return CppType.INSTANCE.m12438getLONGz4oZPQ();
        }
        if (value instanceof Float) {
            return CppType.INSTANCE.m12431getFLOATz4oZPQ();
        }
        if (value instanceof double[]) {
            return CppType.INSTANCE.m12430getDOUBLE_ARRAYz4oZPQ();
        }
        if (value instanceof int[]) {
            return CppType.INSTANCE.m12434getINT_ARRAYz4oZPQ();
        }
        if (value instanceof long[]) {
            return CppType.INSTANCE.m12439getLONG_ARRAYz4oZPQ();
        }
        if (value instanceof float[]) {
            return CppType.INSTANCE.m12432getFLOAT_ARRAYz4oZPQ();
        }
        if (value instanceof boolean[]) {
            return CppType.INSTANCE.m12422getBOOLEAN_ARRAYz4oZPQ();
        }
        if (value instanceof byte[]) {
            return CppType.INSTANCE.m12428getBYTE_ARRAYz4oZPQ();
        }
        if (value instanceof JavaScriptValue) {
            return CppType.INSTANCE.m12436getJS_VALUEz4oZPQ();
        }
        if (value instanceof JavaScriptObject) {
            return CppType.INSTANCE.m12435getJS_OBJECTz4oZPQ();
        }
        if (value instanceof Unit) {
            return CppType.INSTANCE.m12444getUNITz4oZPQ();
        }
        if (RecordRegistry.INSTANCE.typeFor$react_release(value.getClass()) != null) {
            return CppType.INSTANCE.m12441getRECORDz4oZPQ();
        }
        return -1;
    }
}
