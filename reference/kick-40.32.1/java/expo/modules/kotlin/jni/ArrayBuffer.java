package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ArrayBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0082 J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0086 J\t\u0010\u001c\u001a\u00020\u0007H\u0086 J\t\u0010\u001d\u001a\u00020\rH\u0086 J%\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u001f0!¢\u0006\u0002\u0010\"J\u0013\u0010\u001e\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020$H\u0082 J(\u0010%\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u001f0!H\u0086@¢\u0006\u0002\u0010&J!\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0082 J%\u0010,\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u001f0!¢\u0006\u0002\u0010\"J(\u0010-\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u001f0!H\u0086@¢\u0006\u0002\u0010&JH\u0010.\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u001e\u0010/\u001a\u001a\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020'002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u001f0!H\u0082@¢\u0006\u0002\u00101J\f\u00102\u001a\u00020\u0007*\u00020\u0007H\u0002J\u0006\u00103\u001a\u00020\u0000J\b\u00104\u001a\u00020'H\u0004J\b\u00105\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lexpo/modules/kotlin/jni/ArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "mHybridData", "initHybrid", "buffer", "isValid", "", ContentDisposition.Parameters.Size, "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "isNativeBacked", "withJSBytes", "R", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "withJSBytesAsync", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lexpo/modules/kotlin/jni/ArrayBufferScopedAccessAsyncCallback;", "queueFailureCallback", "Lexpo/modules/kotlin/jni/ArrayBufferScopedAccessAsyncQueueFailureCallback;", "withMutableJSBytes", "withMutableJSBytesAsync", "withScopedJSBytesAsync", "schedule", "Lkotlin/Function3;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asScopedReadOnlyBuffer", "copy", "finalize", "getHybridDataForJNIDeallocator", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ArrayBuffer implements Destructible {
    private final HybridData mHybridData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private final native HybridData initHybrid(ByteBuffer buffer);

    private final native Object withJSBytes(JNIFunctionBody body) throws Throwable;

    private final native void withJSBytesAsync(JNIFunctionBody body, ArrayBufferScopedAccessAsyncCallback callback, ArrayBufferScopedAccessAsyncQueueFailureCallback queueFailureCallback);

    public final native boolean isNativeBacked();

    public final native short read2Byte(int position);

    public final native int read4Byte(int position);

    public final native long read8Byte(int position);

    public final native byte readByte(int position);

    public final native double readDouble(int position);

    public final native float readFloat(int position);

    public final native int size();

    public final native ByteBuffer toDirectBuffer();

    private ArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public ArrayBuffer(ByteBuffer byteBuffer) throws Exceptions.IllegalArgument {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        if (!byteBuffer.isDirect()) {
            throw new Exceptions.IllegalArgument("ArrayBuffers can only be created from direct ByteBuffers", null, 2, null);
        }
        this.mHybridData = initHybrid(byteBuffer);
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public final <R> R withJSBytes(final Function1<? super ByteBuffer, ? extends R> body) throws Throwable {
        Intrinsics.checkNotNullParameter(body, "body");
        return (R) withJSBytes(new JNIFunctionBody() { // from class: expo.modules.kotlin.jni.ArrayBuffer$$ExternalSyntheticLambda1
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return ArrayBuffer.withJSBytes$lambda$0(body, this, objArr);
            }
        });
    }

    static final Object withJSBytes$lambda$0(Function1 function1, ArrayBuffer arrayBuffer, Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
        return function1.invoke(arrayBuffer.asScopedReadOnlyBuffer((ByteBuffer) obj));
    }

    public final <R> Object withJSBytesAsync(final Function1<? super ByteBuffer, ? extends R> function1, Continuation<? super R> continuation) throws Throwable {
        if (isNativeBacked()) {
            return withJSBytes(function1);
        }
        return withScopedJSBytesAsync(new Function3() { // from class: expo.modules.kotlin.jni.ArrayBuffer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ArrayBuffer.withJSBytesAsync$lambda$0(this.f$0, (JNIFunctionBody) obj, (ArrayBufferScopedAccessAsyncCallback) obj2, (ArrayBufferScopedAccessAsyncQueueFailureCallback) obj3);
            }
        }, new Function1() { // from class: expo.modules.kotlin.jni.ArrayBuffer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArrayBuffer.withJSBytesAsync$lambda$1(function1, this, (ByteBuffer) obj);
            }
        }, continuation);
    }

    static final Unit withJSBytesAsync$lambda$0(ArrayBuffer arrayBuffer, JNIFunctionBody jniBody, ArrayBufferScopedAccessAsyncCallback callback, ArrayBufferScopedAccessAsyncQueueFailureCallback queueFailureCallback) {
        Intrinsics.checkNotNullParameter(jniBody, "jniBody");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(queueFailureCallback, "queueFailureCallback");
        arrayBuffer.withJSBytesAsync(jniBody, callback, queueFailureCallback);
        return Unit.INSTANCE;
    }

    static final Object withJSBytesAsync$lambda$1(Function1 function1, ArrayBuffer arrayBuffer, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return function1.invoke(arrayBuffer.asScopedReadOnlyBuffer(buffer));
    }

    public final <R> R withMutableJSBytes(final Function1<? super ByteBuffer, ? extends R> body) throws Throwable {
        Intrinsics.checkNotNullParameter(body, "body");
        return (R) withJSBytes(new JNIFunctionBody() { // from class: expo.modules.kotlin.jni.ArrayBuffer$$ExternalSyntheticLambda2
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return ArrayBuffer.withMutableJSBytes$lambda$0(body, objArr);
            }
        });
    }

    static final Object withMutableJSBytes$lambda$0(Function1 function1, Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
        return function1.invoke((ByteBuffer) obj);
    }

    public final <R> Object withMutableJSBytesAsync(Function1<? super ByteBuffer, ? extends R> function1, Continuation<? super R> continuation) throws Throwable {
        if (isNativeBacked()) {
            return withMutableJSBytes(function1);
        }
        return withScopedJSBytesAsync(new Function3() { // from class: expo.modules.kotlin.jni.ArrayBuffer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ArrayBuffer.withMutableJSBytesAsync$lambda$0(this.f$0, (JNIFunctionBody) obj, (ArrayBufferScopedAccessAsyncCallback) obj2, (ArrayBufferScopedAccessAsyncQueueFailureCallback) obj3);
            }
        }, function1, continuation);
    }

    static final Unit withMutableJSBytesAsync$lambda$0(ArrayBuffer arrayBuffer, JNIFunctionBody jniBody, ArrayBufferScopedAccessAsyncCallback callback, ArrayBufferScopedAccessAsyncQueueFailureCallback queueFailureCallback) {
        Intrinsics.checkNotNullParameter(jniBody, "jniBody");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(queueFailureCallback, "queueFailureCallback");
        arrayBuffer.withJSBytesAsync(jniBody, callback, queueFailureCallback);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> void withScopedJSBytesAsync$lambda$0$resumeException(CancellableContinuation<? super R> cancellableContinuation, Throwable th) {
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(th)));
    }

    private final ByteBuffer asScopedReadOnlyBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferOrder = byteBuffer.asReadOnlyBuffer().order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        return byteBufferOrder;
    }

    public final ArrayBuffer copy() {
        return INSTANCE.copyOf(this);
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }

    /* JADX INFO: compiled from: ArrayBuffer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/jni/ArrayBuffer$Companion;", "", "<init>", "()V", "allocate", "Lexpo/modules/kotlin/jni/ArrayBuffer;", ContentDisposition.Parameters.Size, "", "wrap", "byteBuffer", "Ljava/nio/ByteBuffer;", "copyOf", "other", "Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArrayBuffer allocate(int size) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size);
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new ArrayBuffer(byteBufferAllocateDirect);
        }

        public final ArrayBuffer wrap(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            return new ArrayBuffer(byteBuffer);
        }

        public final ArrayBuffer copyOf(ArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return (ArrayBuffer) other.withJSBytes(new Function1() { // from class: expo.modules.kotlin.jni.ArrayBuffer$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ArrayBuffer.Companion.copyOf$lambda$0((ByteBuffer) obj);
                }
            });
        }

        static final ArrayBuffer copyOf$lambda$0(ByteBuffer scopedBytes) {
            Intrinsics.checkNotNullParameter(scopedBytes, "scopedBytes");
            return ArrayBuffer.INSTANCE.copyOf(scopedBytes);
        }

        public final ArrayBuffer copyOf(JavaScriptArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final ArrayBuffer copyOf(NativeArrayBuffer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return copyOf(other.toDirectBuffer());
        }

        public final ArrayBuffer copyOf(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
            byteBuffer.rewind();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            byteBufferAllocateDirect.put(byteBuffer);
            byteBufferAllocateDirect.rewind();
            byteBuffer.rewind();
            Intrinsics.checkNotNull(byteBufferAllocateDirect);
            return new ArrayBuffer(byteBufferAllocateDirect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object withScopedJSBytesAsync(Function3<? super JNIFunctionBody, ? super ArrayBufferScopedAccessAsyncCallback, ? super ArrayBufferScopedAccessAsyncQueueFailureCallback, Unit> function3, final Function1<? super ByteBuffer, ? extends R> function1, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        try {
            function3.invoke(new JNIFunctionBody() { // from class: expo.modules.kotlin.jni.ArrayBuffer$withScopedJSBytesAsync$2$1
                @Override // expo.modules.kotlin.jni.JNIFunctionBody
                public final Object invoke(Object[] args) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    if (!cancellableContinuationImpl2.isActive()) {
                        return null;
                    }
                    Function1<ByteBuffer, R> function2 = function1;
                    Object obj = args[0];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
                    return function2.invoke((ByteBuffer) obj);
                }
            }, new ArrayBufferScopedAccessAsyncCallback() { // from class: expo.modules.kotlin.jni.ArrayBuffer$withScopedJSBytesAsync$2$callback$1
                @Override // expo.modules.kotlin.jni.ArrayBufferScopedAccessAsyncCallback
                public final void invoke(Object obj, Throwable th) {
                    CancellableContinuation<R> cancellableContinuation = cancellableContinuationImpl2;
                    if (th != null) {
                        ArrayBuffer.withScopedJSBytesAsync$lambda$0$resumeException(cancellableContinuation, th);
                    } else {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m12684constructorimpl(obj));
                    }
                }
            }, new ArrayBuffer$withScopedJSBytesAsync$2$queueFailureCallback$1(cancellableContinuationImpl2));
        } catch (Throwable th) {
            withScopedJSBytesAsync$lambda$0$resumeException(cancellableContinuationImpl2, th);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
