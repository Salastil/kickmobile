package io.github.expo.modules.v2.async;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.modules.v2.args.Bridge;
import io.github.expo.modules.v2.args.Trampoline;
import io.github.expo.modules.v2.core.ExpoModulesV2;
import io.github.expo.modules.v2.errors.ThrowableHelper;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: AsyncContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0007J\b\u0010\u001e\u001a\u00020\u0018H\u0007J\u0015\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020 H\u0000¢\u0006\u0002\b%J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H'0)¢\u0006\u0002\b*H\u0080\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\b\u0010-\u001a\u00020\u0018H\u0007J/\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J/\u00104\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"Lio/github/expo/modules/v2/async/AsyncContext;", "", "scheduler", "Lio/github/expo/modules/v2/async/JSScheduler;", "<init>", "(Lio/github/expo/modules/v2/async/JSScheduler;)V", "getScheduler", "()Lio/github/expo/modules/v2/async/JSScheduler;", "dispatcher", "Lio/github/expo/modules/v2/async/JSDispatcher;", "getDispatcher", "()Lio/github/expo/modules/v2/async/JSDispatcher;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "exportScope", "getExportScope$react_release", "value", "", "runtimePointer", "getRuntimePointer$react_release", "()J", "attach", "", "pointer", "attach$react_release", "createPromise", "Lio/github/expo/modules/v2/async/Promise;", "id", "invalidate", "inlineSettle", "Ljava/lang/Runnable;", "inlineThread", "Ljava/lang/Thread;", "postSettle", "job", "postSettle$react_release", "inlineWindow", ExifInterface.GPS_DIRECTION_TRUE, ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "inlineWindow$react_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "drainInlineSettles", "resolveOnJSThread", "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "buffered", "", "resolveOnJSThread$react_release", "rejectOnJSThread", "code", "", "message", "stack", "rejectOnJSThread$react_release", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AsyncContext {
    private static final Companion Companion = new Companion(null);
    private final JSDispatcher dispatcher;
    private final CoroutineScope exportScope;
    private Runnable inlineSettle;
    private volatile Thread inlineThread;
    private volatile long runtimePointer;
    private final JSScheduler scheduler;
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncContext() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeReject(long j, long j2, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeResolve(long j, long j2, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeResolveBuffered(long j, long j2, int i);

    public AsyncContext(JSScheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        JSDispatcher jSDispatcher = new JSDispatcher(scheduler);
        this.dispatcher = jSDispatcher;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(jSDispatcher).plus(new CoroutineName("expo-modules-v2")));
        this.scope = CoroutineScope;
        this.exportScope = CoroutineScopeKt.plus(CoroutineScope, Dispatchers.getUnconfined());
    }

    public /* synthetic */ AsyncContext(DefaultJSScheduler defaultJSScheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultJSScheduler() : defaultJSScheduler);
    }

    public final JSScheduler getScheduler() {
        return this.scheduler;
    }

    public final JSDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: getExportScope$react_release, reason: from getter */
    public final CoroutineScope getExportScope() {
        return this.exportScope;
    }

    /* JADX INFO: renamed from: getRuntimePointer$react_release, reason: from getter */
    public final long getRuntimePointer() {
        return this.runtimePointer;
    }

    public final void attach$react_release(long pointer) {
        this.runtimePointer = pointer;
    }

    public final Promise createPromise(long id) {
        return new Promise(id, this);
    }

    public final void invalidate() {
        this.runtimePointer = 0L;
        CoroutineScopeKt.cancel(this.scope, new CancellationException("The JavaScript runtime was closed"));
        this.scheduler.close();
    }

    public final void postSettle$react_release(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (this.inlineThread == Thread.currentThread() && this.inlineSettle == null) {
            this.inlineSettle = job;
        } else {
            this.scheduler.post(job);
        }
    }

    public final <T> T inlineWindow$react_release(Function1<? super AsyncContext, ? extends T> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            this.inlineThread = Thread.currentThread();
            return body.invoke(this);
        } finally {
            this.inlineThread = null;
        }
    }

    public final void drainInlineSettles() {
        Runnable runnable = this.inlineSettle;
        if (runnable == null) {
            return;
        }
        this.inlineSettle = null;
        runnable.run();
    }

    public final void resolveOnJSThread$react_release(long id, Object value, TypeDescriptor type, boolean buffered) {
        Intrinsics.checkNotNullParameter(type, "type");
        long j = this.runtimePointer;
        if (j == 0) {
            return;
        }
        try {
            if (buffered) {
                try {
                    Companion.nativeResolveBuffered(j, id, Trampoline.writeResult(value, type));
                    return;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    rejectOnJSThread$react_release(id, ThrowableHelper.INSTANCE.codeOf(th2), ThrowableHelper.INSTANCE.messageOf(th2), ExceptionsKt.stackTraceToString(th2));
                    return;
                }
            }
            Companion.nativeResolve(j, id, Bridge.toJni(value, type));
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void rejectOnJSThread$react_release(long id, String code, String message, String stack) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        long j = this.runtimePointer;
        if (j == 0) {
            return;
        }
        Companion.nativeReject(j, id, code, message, stack);
    }

    /* JADX INFO: compiled from: AsyncContext.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0083 J#\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0083 J3\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0083 ¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/async/AsyncContext$Companion;", "", "<init>", "()V", "nativeResolveBuffered", "", "runtimePointer", "", "id", "payloadLength", "", "nativeResolve", "value", "nativeReject", "code", "", "message", "stack", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeReject(long runtimePointer, long id, String code, String message, String stack) {
            AsyncContext.nativeReject(runtimePointer, id, code, message, stack);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeResolve(long runtimePointer, long id, Object value) {
            AsyncContext.nativeResolve(runtimePointer, id, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeResolveBuffered(long runtimePointer, long id, int payloadLength) {
            AsyncContext.nativeResolveBuffered(runtimePointer, id, payloadLength);
        }

        private Companion() {
        }
    }

    static {
        ExpoModulesV2.INSTANCE.load();
    }
}
