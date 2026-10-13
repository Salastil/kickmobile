package androidx.camera.camera2.adapter;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: CoroutineAdapters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007\u001aA\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u0006*\u00020\n2\u001e\b\u0004\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\r\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0012\u001a>\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00130\f\u001a.\u0010\u0015\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001aH\u0010\u0015\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00130\f\u001a\u001e\u0010\u0018\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00122\u0006\u0010\u0019\u001a\u00020\u0017\u001a&\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"asListenableFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "Lkotlinx/coroutines/Job;", "tag", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "asVoidListenableFuture", "future", "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)Lcom/google/common/util/concurrent/ListenableFuture;", "propagateTo", "", FirebaseAnalytics.Param.DESTINATION, "Lkotlinx/coroutines/CompletableDeferred;", "R", ViewProps.TRANSFORM, "propagateCompletion", "completionCause", "", "completeFailing", "cause", "awaitUntil", "", "timeoutMillis", "", "(Lkotlinx/coroutines/Deferred;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CoroutineAdaptersKt {

    /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineAdapters.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.adapter.CoroutineAdaptersKt", f = "CoroutineAdapters.kt", i = {}, l = {199}, m = "awaitUntil", n = {}, s = {}, v = 1)
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineAdaptersKt.awaitUntil(null, 0L, this);
        }
    }

    static final Void asVoidListenableFuture$lambda$0(Object obj) {
        return null;
    }

    public static /* synthetic */ ListenableFuture asListenableFuture$default(Job job, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Job.asListenableFuture";
        }
        return asListenableFuture(job, obj);
    }

    public static final ListenableFuture<Void> asListenableFuture(final Job job, final Object obj) {
        Intrinsics.checkNotNullParameter(job, "<this>");
        ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CoroutineAdaptersKt.asListenableFuture$lambda$0(job, obj, completer);
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    static final Object asListenableFuture$lambda$0(Job job, Object obj, final CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(completer, "completer");
        job.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CoroutineAdaptersKt.asListenableFuture$lambda$0$0(completer, (Throwable) obj2);
            }
        });
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asListenableFuture$lambda$0$0(CallbackToFutureAdapter.Completer completer, Throwable th) {
        if (th != null) {
            if (th instanceof CancellationException) {
                completer.setCancelled();
            } else {
                completer.setException(th);
            }
        } else {
            completer.set(null);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ListenableFuture asListenableFuture$default(Deferred deferred, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(deferred, obj);
    }

    public static final <T> ListenableFuture<T> asListenableFuture(final Deferred<? extends T> deferred, final Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda5
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CoroutineAdaptersKt.asListenableFuture$lambda$1(deferred, obj, completer);
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    static final Object asListenableFuture$lambda$1(final Deferred deferred, Object obj, final CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(completer, "completer");
        deferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CoroutineAdaptersKt.asListenableFuture$lambda$1$0(completer, deferred, (Throwable) obj2);
            }
        });
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asListenableFuture$lambda$1$0(CallbackToFutureAdapter.Completer completer, Deferred deferred, Throwable th) {
        if (th != null) {
            if (th instanceof CancellationException) {
                completer.setCancelled();
            } else {
                completer.setException(th);
            }
        } else {
            completer.set(deferred.getCompleted());
        }
        return Unit.INSTANCE;
    }

    public static final <T> ListenableFuture<Void> asVoidListenableFuture(Deferred<? extends T> deferred) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        FutureChain<T> futureChainTransform = FutureChain.from(asListenableFuture$default((Deferred) deferred, (Object) null, 1, (Object) null)).transform(new Function() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return CoroutineAdaptersKt.asVoidListenableFuture$lambda$0(obj);
            }
        }, CameraXExecutors.directExecutor());
        Intrinsics.checkNotNullExpressionValue(futureChainTransform, "transform(...)");
        return futureChainTransform;
    }

    public static final <T> ListenableFuture<T> future(final CoroutineScope coroutineScope, final Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$future$resolver$1

            /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CoroutineAdaptersKt$future$resolver$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: CoroutineAdapters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
            @DebugMetadata(c = "androidx.camera.camera2.adapter.CoroutineAdaptersKt$future$resolver$1$1", f = "CoroutineAdapters.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
                final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(CallbackToFutureAdapter.Completer<T> completer, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$completer = completer;
                    this.$block = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$completer, this.$block, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CallbackToFutureAdapter.Completer completer;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CallbackToFutureAdapter.Completer<T> completer2 = this.$completer;
                        Function1<Continuation<? super T>, Object> function1 = this.$block;
                        this.L$0 = completer2;
                        this.label = 1;
                        Object objInvoke = function1.invoke(this);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objInvoke;
                        completer = completer2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        completer = completer3;
                    }
                    completer.set(obj);
                    return Unit.INSTANCE;
                }

                public final Object invokeSuspend$$forInline(Object obj) {
                    this.$completer.set((T) this.$block.invoke(this));
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                Intrinsics.checkNotNullParameter(completer, "completer");
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(completer, block, null), 3, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final <T> void propagateTo(final Deferred<? extends T> deferred, final CompletableDeferred<T> destination) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        deferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoroutineAdaptersKt.propagateTo$lambda$0(deferred, destination, (Throwable) obj);
            }
        });
    }

    static final Unit propagateTo$lambda$0(Deferred deferred, CompletableDeferred completableDeferred, Throwable th) {
        propagateCompletion(deferred, completableDeferred, th);
        return Unit.INSTANCE;
    }

    public static final <T, R> void propagateTo(final Deferred<? extends T> deferred, final CompletableDeferred<R> destination, final Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        deferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.adapter.CoroutineAdaptersKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoroutineAdaptersKt.propagateTo$lambda$1(deferred, destination, transform, (Throwable) obj);
            }
        });
    }

    static final Unit propagateTo$lambda$1(Deferred deferred, CompletableDeferred completableDeferred, Function1 function1, Throwable th) {
        propagateCompletion(deferred, completableDeferred, th, function1);
        return Unit.INSTANCE;
    }

    public static final <T> void propagateCompletion(Deferred<? extends T> deferred, CompletableDeferred<T> destination, Throwable th) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (th != null) {
            completeFailing(destination, th);
        } else {
            destination.complete(deferred.getCompleted());
        }
    }

    public static final <T, R> void propagateCompletion(Deferred<? extends T> deferred, CompletableDeferred<R> destination, Throwable th, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (th != null) {
            completeFailing(destination, th);
        } else {
            destination.complete(transform.invoke(deferred.getCompleted()));
        }
    }

    public static final <T> void completeFailing(CompletableDeferred<T> completableDeferred, Throwable cause) {
        Intrinsics.checkNotNullParameter(completableDeferred, "<this>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (cause instanceof CancellationException) {
            completableDeferred.cancel((CancellationException) cause);
        } else {
            completableDeferred.completeExceptionally(cause);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineAdapters.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.adapter.CoroutineAdaptersKt$awaitUntil$2", f = "CoroutineAdapters.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Deferred<T> $this_awaitUntil;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Deferred<? extends T> deferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_awaitUntil = deferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_awaitUntil, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$this_awaitUntil.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object awaitUntil(Deferred<? extends T> deferred, long j, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithTimeoutOrNull = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(deferred, null);
            anonymousClass1.label = 1;
            objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, anonymousClass2, anonymousClass1);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
        }
        return Boxing.boxBoolean(objWithTimeoutOrNull != null);
    }
}
