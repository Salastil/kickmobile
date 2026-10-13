package io.github.expo.modules.v2.jsi;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import io.github.expo.kolibri.NativeObject;
import io.github.expo.modules.v2.ExpoContext;
import io.github.expo.modules.v2.ExpoObject;
import io.github.expo.modules.v2.async.AsyncContext;
import io.github.expo.modules.v2.modules.ModuleRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: JavaScriptRuntime.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u0000 22\u00020\u00012\u00060\u0002j\u0002`\u0003:\u00012B)\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0087 J\t\u0010 \u001a\u00020!H\u0087 J\t\u0010\"\u001a\u00020!H\u0087 J\u0013\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020%H\u0087 J\t\u0010&\u001a\u00020\u000bH\u0087 J\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020)H\u0016J\u0011\u0010\"\u001a\u00020!2\u0006\u0010\u0006\u001a\u000201H\u0082 J\u0011\u0010&\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u000201H\u0082 J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u0002012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0082 J\u0011\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u000201H\u0082 J\u001b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\u0006\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0082 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00063"}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", "Lio/github/expo/kolibri/NativeObject;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "asyncContext", "Lio/github/expo/modules/v2/async/AsyncContext;", "pointer", "Lio/github/expo/kolibri/NativePointer;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/ExpoContext;", "ownsContext", "", "<init>", "(Lio/github/expo/modules/v2/async/AsyncContext;JLio/github/expo/modules/v2/ExpoContext;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAsyncContext", "()Lio/github/expo/modules/v2/async/AsyncContext;", "getContext", "()Lio/github/expo/modules/v2/ExpoContext;", "jsThread", "Ljava/lang/Thread;", "value", "isClosed", "()Z", "moduleRegistry", "Lio/github/expo/modules/v2/modules/ModuleRegistry;", "getModuleRegistry", "()Lio/github/expo/modules/v2/modules/ModuleRegistry;", "evaluate", "Lio/github/expo/modules/v2/jsi/JavaScriptValue;", "script", "", "sourceURL", "global", "Lio/github/expo/modules/v2/jsi/JavaScriptObject;", "createObject", "jsObjectOf", "instance", "Lio/github/expo/modules/v2/ExpoObject;", "drainMicrotasks", "drainJobs", "runEventLoop", "", InstrumentationTags.TIMEOUT, "Lkotlin/time/Duration;", "until", "Lkotlin/Function0;", "runEventLoop-VtjQ1oo", "(JLkotlin/jvm/functions/Function0;)V", "close", "", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class JavaScriptRuntime extends NativeObject implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AsyncContext asyncContext;
    private final ExpoContext context;
    private volatile boolean isClosed;
    private final Thread jsThread;
    private final boolean ownsContext;

    public /* synthetic */ JavaScriptRuntime(AsyncContext asyncContext, long j, ExpoContext expoContext, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(asyncContext, j, expoContext, z);
    }

    private final native JavaScriptObject createObject(long pointer);

    private final native boolean drainMicrotasks(long pointer);

    private final native JavaScriptValue evaluate(long pointer, String script, String sourceURL);

    public static final JavaScriptRuntime getCurrent() {
        return INSTANCE.getCurrent();
    }

    private final native JavaScriptObject global(long pointer);

    private final native JavaScriptObject jsObjectOf(long pointer, ExpoObject instance);

    public final JavaScriptObject createObject() {
        return createObject(this.nativePointer);
    }

    public final boolean drainMicrotasks() {
        return drainMicrotasks(this.nativePointer);
    }

    public final JavaScriptValue evaluate(String script, String sourceURL) {
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(sourceURL, "sourceURL");
        return evaluate(this.nativePointer, script, sourceURL);
    }

    public final JavaScriptObject global() {
        return global(this.nativePointer);
    }

    public final JavaScriptObject jsObjectOf(ExpoObject instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        return jsObjectOf(this.nativePointer, instance);
    }

    public final AsyncContext getAsyncContext() {
        return this.asyncContext;
    }

    public final ExpoContext getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private JavaScriptRuntime(AsyncContext asyncContext, long j, ExpoContext context, boolean z) {
        super(j, null);
        Intrinsics.checkNotNullParameter(asyncContext, "asyncContext");
        Intrinsics.checkNotNullParameter(context, "context");
        this.asyncContext = asyncContext;
        this.context = context;
        this.ownsContext = z;
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "currentThread(...)");
        this.jsThread = threadCurrentThread;
        asyncContext.attach$react_release(j);
        CurrentRuntime.INSTANCE.set(new WeakReference<>(this));
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final ModuleRegistry getModuleRegistry() {
        return this.context.getModuleRegistry();
    }

    public static /* synthetic */ JavaScriptValue evaluate$default(JavaScriptRuntime javaScriptRuntime, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: evaluate");
        }
        if ((i & 2) != 0) {
            str2 = "<eval>";
        }
        return javaScriptRuntime.evaluate(str, str2);
    }

    public final boolean drainJobs() {
        int iDrainPending;
        boolean z = false;
        do {
            iDrainPending = this.asyncContext.getScheduler().drainPending();
            z = z || iDrainPending > 0;
            drainMicrotasks();
        } while (iDrainPending != 0);
        return z;
    }

    /* JADX INFO: renamed from: runEventLoop-VtjQ1oo$default, reason: not valid java name */
    public static /* synthetic */ void m12376runEventLoopVtjQ1oo$default(JavaScriptRuntime javaScriptRuntime, long j, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runEventLoop-VtjQ1oo");
        }
        if ((i & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(5, DurationUnit.SECONDS);
        }
        javaScriptRuntime.m12377runEventLoopVtjQ1oo(j, function0);
    }

    /* JADX INFO: renamed from: runEventLoop-VtjQ1oo, reason: not valid java name */
    public final void m12377runEventLoopVtjQ1oo(long timeout, Function0<Boolean> until) {
        Intrinsics.checkNotNullParameter(until, "until");
        long jM14181markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m14181markNowz9LOYto();
        while (true) {
            drainJobs();
            if (until.invoke().booleanValue()) {
                return;
            }
            long jM14092minusLRDsOJo = Duration.m14092minusLRDsOJo(timeout, TimeSource.Monotonic.ValueTimeMark.m14186elapsedNowUwyO8pc(jM14181markNowz9LOYto));
            if (Duration.m14063compareToLRDsOJo(jM14092minusLRDsOJo, Duration.INSTANCE.m14159getZEROUwyO8pc()) <= 0) {
                throw new IllegalStateException(("runEventLoop timed out after " + Duration.m14104toStringimpl(timeout) + " with the condition still unmet").toString());
            }
            this.asyncContext.getScheduler().awaitJob(Duration.m14077getInWholeNanosecondsimpl(jM14092minusLRDsOJo));
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.isClosed = true;
        if (Thread.currentThread() == this.jsThread) {
            WeakReference<JavaScriptRuntime> weakReferenceRaw = CurrentRuntime.INSTANCE.raw();
            if ((weakReferenceRaw != null ? weakReferenceRaw.get() : null) == this) {
                CurrentRuntime.INSTANCE.set(null);
            }
        }
        if (this.ownsContext) {
            this.context.close();
        }
        this.asyncContext.invalidate();
        destroy();
    }

    /* JADX INFO: compiled from: JavaScriptRuntime.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/github/expo/modules/v2/jsi/JavaScriptRuntime$Companion;", "", "<init>", "()V", "current", "Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", "getCurrent$annotations", "getCurrent", "()Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCurrent$annotations() {
        }

        private Companion() {
        }

        public final JavaScriptRuntime getCurrent() {
            return CurrentRuntime.INSTANCE.get();
        }
    }
}
