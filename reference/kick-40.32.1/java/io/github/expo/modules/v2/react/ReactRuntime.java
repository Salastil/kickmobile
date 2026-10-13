package io.github.expo.modules.v2.react;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import io.github.expo.kolibri.NativePointer;
import io.github.expo.modules.v2.async.AsyncContext;
import io.github.expo.modules.v2.jsi.JavaScriptRuntime;
import io.github.expo.modules.v2.modules.ModuleRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactRuntime.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/github/expo/modules/v2/react/ReactRuntime;", "Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/react/ReactExpoContext;", "ownsContext", "", "jsRuntimePointer", "", "asyncContext", "Lio/github/expo/modules/v2/async/AsyncContext;", "globalName", "", "<init>", "(Lio/github/expo/modules/v2/react/ReactExpoContext;ZJLio/github/expo/modules/v2/async/AsyncContext;Ljava/lang/String;)V", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactRuntime extends JavaScriptRuntime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_GLOBAL_NAME = "expo";
    private final ReactApplicationContext reactContext;

    public /* synthetic */ ReactRuntime(ReactExpoContext reactExpoContext, boolean z, long j, AsyncContext asyncContext, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactExpoContext, z, j, asyncContext, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long nativeCreate(long j, ModuleRegistry moduleRegistry, AsyncContext asyncContext, String str);

    private ReactRuntime(ReactExpoContext reactExpoContext, boolean z, long j, AsyncContext asyncContext, String str) {
        super(asyncContext, NativePointer.m12237constructorimpl(INSTANCE.nativeCreate(j, reactExpoContext.getModuleRegistry(), asyncContext, str)), reactExpoContext, z, null);
        this.reactContext = reactExpoContext.getReactContext();
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    /* JADX INFO: compiled from: ReactRuntime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/github/expo/modules/v2/react/ReactRuntime$Companion;", "", "<init>", "()V", "DEFAULT_GLOBAL_NAME", "", "attach", "Lio/github/expo/modules/v2/react/ReactRuntime;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "globalName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/react/ReactExpoContext;", "nativeCreate", "", "jsRuntimePointer", "registry", "Lio/github/expo/modules/v2/modules/ModuleRegistry;", "asyncContext", "Lio/github/expo/modules/v2/async/AsyncContext;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeCreate(long jsRuntimePointer, ModuleRegistry registry, AsyncContext asyncContext, String globalName) {
            return ReactRuntime.nativeCreate(jsRuntimePointer, registry, asyncContext, globalName);
        }

        private Companion() {
        }

        public static /* synthetic */ ReactRuntime attach$default(Companion companion, ReactApplicationContext reactApplicationContext, String str, ReactExpoContext reactExpoContext, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "expo";
            }
            if ((i & 4) != 0) {
                reactExpoContext = null;
            }
            return companion.attach(reactApplicationContext, str, reactExpoContext);
        }

        public final ReactRuntime attach(ReactApplicationContext reactContext, String globalName, ReactExpoContext context) {
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            Intrinsics.checkNotNullParameter(globalName, "globalName");
            if (context != null && context.getReactContext() != reactContext) {
                throw new IllegalArgumentException("The ReactExpoContext wraps a different ReactApplicationContext than the one to attach to".toString());
            }
            JavaScriptContextHolder javaScriptContextHolder = reactContext.getJavaScriptContextHolder();
            if (javaScriptContextHolder == null) {
                throw new IllegalArgumentException("ReactContext.javaScriptContextHolder is null — there is no jsi::Runtime to attach to".toString());
            }
            long context2 = javaScriptContextHolder.getContext();
            if (context2 == 0) {
                throw new IllegalArgumentException("ReactContext.javaScriptContextHolder holds a null runtime".toString());
            }
            ReactJSScheduler reactJSScheduler = new ReactJSScheduler(reactContext);
            final ReactRuntime reactRuntime = new ReactRuntime(context == null ? new ReactExpoContext(reactContext) : context, context == null, context2, new AsyncContext(reactJSScheduler), globalName, null);
            reactJSScheduler.setDrainMicrotasks$react_release(new Function0() { // from class: io.github.expo.modules.v2.react.ReactRuntime$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ReactRuntime.Companion.attach$lambda$3(reactRuntime);
                }
            });
            return reactRuntime;
        }

        static final Unit attach$lambda$3(ReactRuntime reactRuntime) {
            reactRuntime.drainMicrotasks();
            return Unit.INSTANCE;
        }
    }

    static {
        ExpoModulesV2React.INSTANCE.ensureLoaded();
    }
}
