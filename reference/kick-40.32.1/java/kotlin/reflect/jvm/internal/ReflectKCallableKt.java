package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectKCallable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001c\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isBound", "", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "(Lkotlin/reflect/jvm/internal/ReflectKCallable;)Z", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReflectKCallableKt {
    public static final boolean isBound(ReflectKCallable<?> reflectKCallable) {
        Intrinsics.checkNotNullParameter(reflectKCallable, "<this>");
        return reflectKCallable.getRawBoundReceiver() != CallableReference.NO_RECEIVER;
    }
}
