package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/ReturnType;", "", "converter", "Lexpo/modules/kotlin/types/JSTypeConverter;", "<init>", "(Lexpo/modules/kotlin/types/JSTypeConverter;)V", "convertToJS", "value", "cppType", "Lexpo/modules/kotlin/jni/ReturnType;", "getCppType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReturnType {
    public static final int $stable = 8;
    private final JSTypeConverter<?> converter;

    public ReturnType(JSTypeConverter<?> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.converter = converter;
    }

    public final Object convertToJS(Object value) {
        return this.converter.convertToJS(value);
    }

    public final expo.modules.kotlin.jni.ReturnType getCppType() {
        return this.converter.getReturnType();
    }
}
