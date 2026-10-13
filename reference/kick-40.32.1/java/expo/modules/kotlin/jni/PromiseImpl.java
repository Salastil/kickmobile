package expo.modules.kotlin.jni;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromiseImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u001e\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001bH\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0017\u0010\"\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140$H\u0082\bJ$\u0010%\u001a\u00020\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "callback", "Lexpo/modules/kotlin/jni/JavaCallback;", "<init>", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "settled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasSettled", "", "getWasSettled$expo_modules_core_release", "()Z", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "fullFunctionName", "", "resolve", "", "value", "", "result", "", "", "", "", "", "reject", "code", "message", "cause", "", "checkIfWasSettled", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function0;", "decorateWithDebugInformation", "moduleName", "functionName", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PromiseImpl implements Promise {
    public static final int $stable = 8;
    private WeakReference<AppContext> appContextHolder;
    private final JavaCallback callback;
    private String fullFunctionName;
    private final AtomicBoolean settled;

    public PromiseImpl(JavaCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.settled = new AtomicBoolean(false);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void reject(CodedException codedException) {
        super.reject(codedException);
    }

    /* JADX INFO: renamed from: getCallback$expo_modules_core_release, reason: from getter */
    public final JavaCallback getCallback() {
        return this.callback;
    }

    public final boolean getWasSettled$expo_modules_core_release() {
        return this.settled.get();
    }

    private final void checkIfWasSettled(Function0<Unit> body) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                body.invoke();
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    public final void decorateWithDebugInformation(WeakReference<AppContext> appContextHolder, String moduleName, String functionName) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.appContextHolder = appContextHolder;
        this.fullFunctionName = moduleName + "." + functionName;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(value);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke();
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int result) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean result) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double result) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float result) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.settled.compareAndSet(false, true)) {
            try {
                this.callback.invoke(result);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) {
        if (this.settled.compareAndSet(false, true)) {
            try {
                JavaCallback javaCallback = this.callback;
                if (message == null) {
                    message = cause != null ? cause.getMessage() : null;
                    if (message == null) {
                        message = "unknown";
                    }
                }
                javaCallback.invoke(code, message);
            } catch (Throwable th) {
                this.settled.set(false);
                throw th;
            }
        }
    }
}
