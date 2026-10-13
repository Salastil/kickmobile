package io.github.expo.modules.v2.async;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.github.expo.modules.v2.errors.ThrowableHelper;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Promise.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\rH\u0082\bJ;\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u001e\u0010\u0013\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lio/github/expo/modules/v2/async/Promise;", "", "id", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/async/AsyncContext;", "<init>", "(JLio/github/expo/modules/v2/async/AsyncContext;)V", "_settled", "", "get_settled$react_release$annotations", "()V", "settled", "", "launch", "Lkotlinx/coroutines/Job;", "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "buffered", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;ZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "resolve", "", "value", "reject", RumFeature.EVENT_THROWABLE_PROPERTY, "", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Promise {

    @Deprecated
    public static final String CANCELLED_CODE = "ERR_CANCELED";
    private static final Companion Companion = new Companion(null);
    private static final AtomicIntegerFieldUpdater<Promise> SETTLED;
    public volatile int _settled;
    private final AsyncContext context;
    private final long id;

    public static /* synthetic */ void get_settled$react_release$annotations() {
    }

    public Promise(long j, AsyncContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.id = j;
        this.context = context;
    }

    private final boolean settled() {
        return SETTLED.compareAndSet(this, 0, 1);
    }

    public final Job launch(TypeDescriptor type, boolean buffered, Function1<? super Continuation<Object>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(block, "block");
        AsyncContext asyncContext = this.context;
        try {
            asyncContext.inlineThread = Thread.currentThread();
            return BuildersKt__Builders_commonKt.launch$default(asyncContext.getExportScope(), null, null, new Promise$launch$1$1(this, block, type, buffered, null), 3, null);
        } finally {
            asyncContext.inlineThread = null;
        }
    }

    /* JADX INFO: compiled from: Promise.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/github/expo/modules/v2/async/Promise$Companion;", "", "<init>", "()V", "CANCELLED_CODE", "", "SETTLED", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "Lio/github/expo/modules/v2/async/Promise;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        AtomicIntegerFieldUpdater<Promise> atomicIntegerFieldUpdaterNewUpdater = AtomicIntegerFieldUpdater.newUpdater(Promise.class, "_settled");
        Intrinsics.checkNotNullExpressionValue(atomicIntegerFieldUpdaterNewUpdater, "newUpdater(...)");
        SETTLED = atomicIntegerFieldUpdaterNewUpdater;
    }

    public final void resolve(final Object value, final TypeDescriptor type, final boolean buffered) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (SETTLED.compareAndSet(this, 0, 1)) {
            this.context.postSettle$react_release(new Runnable() { // from class: io.github.expo.modules.v2.async.Promise$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Promise promise = this.f$0;
                    promise.context.resolveOnJSThread$react_release(promise.id, value, type, buffered);
                }
            });
        }
    }

    public final void reject(Throwable throwable) {
        final String strCodeOf;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (SETTLED.compareAndSet(this, 0, 1)) {
            if (throwable instanceof CancellationException) {
                strCodeOf = CANCELLED_CODE;
            } else {
                strCodeOf = ThrowableHelper.INSTANCE.codeOf(throwable);
            }
            final String strMessageOf = ThrowableHelper.INSTANCE.messageOf(throwable);
            final String strStackTraceToString = ExceptionsKt.stackTraceToString(throwable);
            this.context.postSettle$react_release(new Runnable() { // from class: io.github.expo.modules.v2.async.Promise$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Promise promise = this.f$0;
                    promise.context.rejectOnJSThread$react_release(promise.id, strCodeOf, strMessageOf, strStackTraceToString);
                }
            });
        }
    }
}
