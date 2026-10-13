package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000¨\u0006\u0002"}, d2 = {"toBoxedIfPrimitive", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ClassExtensionsKt {
    public static final Class<?> toBoxedIfPrimitive(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
            return Integer.class;
        }
        if (Intrinsics.areEqual(cls, Long.TYPE)) {
            return Long.class;
        }
        if (Intrinsics.areEqual(cls, Double.TYPE)) {
            return Double.class;
        }
        if (Intrinsics.areEqual(cls, Float.TYPE)) {
            return Float.class;
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
            return Boolean.class;
        }
        if (Intrinsics.areEqual(cls, Byte.TYPE)) {
            return Byte.class;
        }
        if (Intrinsics.areEqual(cls, Short.TYPE)) {
            return Short.class;
        }
        return Intrinsics.areEqual(cls, Character.TYPE) ? Character.class : cls;
    }
}
