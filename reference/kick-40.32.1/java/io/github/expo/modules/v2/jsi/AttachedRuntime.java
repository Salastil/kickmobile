package io.github.expo.modules.v2.jsi;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.github.expo.kolibri.NativePointer;
import io.github.expo.modules.v2.ExpoContext;
import io.github.expo.modules.v2.async.AsyncContext;
import io.github.expo.modules.v2.core.ExpoModulesV2;
import io.github.expo.modules.v2.modules.ModuleRegistry;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttachedRuntime.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/github/expo/modules/v2/jsi/AttachedRuntime;", "Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", "jsRuntimePointer", "", "asyncContext", "Lio/github/expo/modules/v2/async/AsyncContext;", "engineName", "", "globalName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/ExpoContext;", "ownsContext", "", "<init>", "(JLio/github/expo/modules/v2/async/AsyncContext;Ljava/lang/String;Ljava/lang/String;Lio/github/expo/modules/v2/ExpoContext;Z)V", "(JLio/github/expo/modules/v2/async/AsyncContext;Ljava/lang/String;Ljava/lang/String;Lio/github/expo/modules/v2/ExpoContext;)V", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AttachedRuntime extends JavaScriptRuntime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_ENGINE_NAME = "unknown";
    public static final String DEFAULT_GLOBAL_NAME = "expo";

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long nativeCreate(long j, ModuleRegistry moduleRegistry, AsyncContext asyncContext, String str, String str2);

    private AttachedRuntime(long j, AsyncContext asyncContext, String str, String str2, ExpoContext expoContext, boolean z) {
        super(asyncContext, NativePointer.m12237constructorimpl(INSTANCE.nativeCreate(j, expoContext.getModuleRegistry(), asyncContext, str, str2)), expoContext, z, null);
    }

    public /* synthetic */ AttachedRuntime(long j, AsyncContext asyncContext, String str, String str2, ExpoContext expoContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new AsyncContext(null, 1, null) : asyncContext, (i & 4) != 0 ? "unknown" : str, (i & 8) != 0 ? "expo" : str2, (i & 16) != 0 ? null : expoContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AttachedRuntime(long j, AsyncContext asyncContext, String engineName, String globalName, ExpoContext expoContext) {
        this(j, asyncContext, engineName, globalName, expoContext == null ? new ExpoContext() : expoContext, expoContext == null);
        Intrinsics.checkNotNullParameter(asyncContext, "asyncContext");
        Intrinsics.checkNotNullParameter(engineName, "engineName");
        Intrinsics.checkNotNullParameter(globalName, "globalName");
    }

    /* JADX INFO: compiled from: AttachedRuntime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/github/expo/modules/v2/jsi/AttachedRuntime$Companion;", "", "<init>", "()V", "DEFAULT_ENGINE_NAME", "", "DEFAULT_GLOBAL_NAME", "nativeCreate", "", "jsRuntimePointer", "registry", "Lio/github/expo/modules/v2/modules/ModuleRegistry;", "asyncContext", "Lio/github/expo/modules/v2/async/AsyncContext;", "engineName", "globalName", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeCreate(long jsRuntimePointer, ModuleRegistry registry, AsyncContext asyncContext, String engineName, String globalName) {
            return AttachedRuntime.nativeCreate(jsRuntimePointer, registry, asyncContext, engineName, globalName);
        }

        private Companion() {
        }
    }

    static {
        ExpoModulesV2.INSTANCE.load();
    }
}
