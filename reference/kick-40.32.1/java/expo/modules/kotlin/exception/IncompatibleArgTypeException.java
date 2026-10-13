package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B-\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB-\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\nB-\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/exception/IncompatibleArgTypeException;", "Lexpo/modules/kotlin/exception/CodedException;", "argumentType", "Lkotlin/reflect/KClass;", "desiredType", "cause", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Ljava/lang/Throwable;)V", "Ljava/lang/Class;", "(Lkotlin/reflect/KClass;Ljava/lang/Class;Ljava/lang/Throwable;)V", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Throwable;)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IncompatibleArgTypeException extends CodedException {
    public static final int $stable = 8;

    public /* synthetic */ IncompatibleArgTypeException(KClass kClass, KClass kClass2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((KClass<?>) kClass, (KClass<?>) kClass2, (i & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompatibleArgTypeException(KClass<?> argumentType, KClass<?> desiredType, Throwable th) {
        super("Argument type '" + argumentType + "' is not compatible with expected type '" + desiredType + "'.", th);
        Intrinsics.checkNotNullParameter(argumentType, "argumentType");
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
    }

    public /* synthetic */ IncompatibleArgTypeException(KClass kClass, Class cls, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((KClass<?>) kClass, (Class<?>) cls, (i & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompatibleArgTypeException(KClass<?> argumentType, Class<?> desiredType, Throwable th) {
        super("Argument type '" + argumentType + "' is not compatible with expected type '" + desiredType.getSimpleName() + "'.", th);
        Intrinsics.checkNotNullParameter(argumentType, "argumentType");
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
    }

    public /* synthetic */ IncompatibleArgTypeException(Class cls, Class cls2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Class<?>) cls, (Class<?>) cls2, (i & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompatibleArgTypeException(Class<?> argumentType, Class<?> desiredType, Throwable th) {
        super("Argument type '" + argumentType.getSimpleName() + "' is not compatible with expected type '" + desiredType.getSimpleName() + "'.", th);
        Intrinsics.checkNotNullParameter(argumentType, "argumentType");
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
    }
}
