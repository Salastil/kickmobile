package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/DynamicCastException;", "Lexpo/modules/kotlin/exception/CodedException;", "type", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DynamicCastException extends CodedException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicCastException(KClass<?> type) {
        super("Could not cast dynamic value to '" + type.getQualifiedName() + "'.", null, 2, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicCastException(Class<?> type) {
        super("Could not cast dynamic value to '" + type.getCanonicalName() + "'.", null, 2, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
