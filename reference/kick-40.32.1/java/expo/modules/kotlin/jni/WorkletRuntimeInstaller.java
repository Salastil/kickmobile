package expo.modules.kotlin.jni;

import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.runtime.Runtime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletRuntimeInstaller.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ'\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/jni/WorkletRuntimeInstaller;", "", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "<init>", "(Lexpo/modules/kotlin/runtime/Runtime;)V", "getRuntime", "()Lexpo/modules/kotlin/runtime/Runtime;", "install", "Lexpo/modules/kotlin/jni/JSIContext;", "jsRuntimePointer", "", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WorkletRuntimeInstaller {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Runtime runtime;

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator);

    @JvmStatic
    public static final native long resolveUIRuntimePointer(JavaScriptObject javaScriptObject);

    public WorkletRuntimeInstaller(Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtime = runtime;
    }

    public final Runtime getRuntime() {
        return this.runtime;
    }

    public final JSIContext install(long jsRuntimePointer) {
        return install(UtilsKt.weak(this.runtime), jsRuntimePointer, this.runtime.getDeallocator());
    }

    /* JADX INFO: compiled from: WorkletRuntimeInstaller.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087 ¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/jni/WorkletRuntimeInstaller$Companion;", "", "<init>", "()V", "resolveUIRuntimePointer", "", "uiRuntimeHolder", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long resolveUIRuntimePointer(JavaScriptObject uiRuntimeHolder) {
            return WorkletRuntimeInstaller.resolveUIRuntimePointer(uiRuntimeHolder);
        }

        private Companion() {
        }
    }

    static {
        WorkletsSoLoader.INSTANCE.loadIfPresent();
    }
}
