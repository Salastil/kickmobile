package expo.modules.ui.state;

import android.util.Log;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.runtime.WorkletRuntime;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletCallback.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/state/WorkletCallback;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "<init>", "()V", "worklet", "Lexpo/modules/kotlin/jni/worklets/Worklet;", "getWorklet", "()Lexpo/modules/kotlin/jni/worklets/Worklet;", "setWorklet", "(Lexpo/modules/kotlin/jni/worklets/Worklet;)V", "invoke", "", "arguments", "", "", "([Ljava/lang/Object;)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WorkletCallback extends SharedObject {
    public static final int $stable = 8;
    private Worklet worklet;

    public WorkletCallback() {
        super(null, 1, null);
    }

    public final Worklet getWorklet() {
        return this.worklet;
    }

    public final void setWorklet(Worklet worklet) {
        this.worklet = worklet;
    }

    public final void invoke(Object... arguments) {
        WorkletRuntime uiRuntime;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Worklet worklet = this.worklet;
        if (worklet == null) {
            Log.w("ExpoUI", "WorkletCallback.invoke: worklet is nil, the callback will not run.");
            return;
        }
        AppContext appContext = getAppContext();
        if (appContext == null || (uiRuntime = appContext.getUiRuntime()) == null) {
            Log.w("ExpoUI", "WorkletCallback.invoke: UI worklet runtime is not available, the callback will not run.");
        } else {
            worklet.execute(uiRuntime, Arrays.copyOf(arguments, arguments.length));
        }
    }
}
