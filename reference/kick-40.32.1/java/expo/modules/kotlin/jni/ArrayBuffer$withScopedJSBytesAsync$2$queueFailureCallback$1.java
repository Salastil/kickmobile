package expo.modules.kotlin.jni;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: ArrayBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ArrayBuffer$withScopedJSBytesAsync$2$queueFailureCallback$1 implements ArrayBufferScopedAccessAsyncQueueFailureCallback, FunctionAdapter {
    final /* synthetic */ CancellableContinuation<R> $continuation;

    /* JADX WARN: Multi-variable type inference failed */
    ArrayBuffer$withScopedJSBytesAsync$2$queueFailureCallback$1(CancellableContinuation<? super R> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ArrayBufferScopedAccessAsyncQueueFailureCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, Intrinsics.Kotlin.class, "resumeException", "withScopedJSBytesAsync$lambda$0$resumeException(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Throwable;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // expo.modules.kotlin.jni.ArrayBufferScopedAccessAsyncQueueFailureCallback
    public final void invoke(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ArrayBuffer.withScopedJSBytesAsync$lambda$0$resumeException(this.$continuation, p0);
    }
}
