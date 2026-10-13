package expo.modules.updates.procedures;

import android.app.Activity;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.common.LifecycleState;
import expo.modules.updates.UpdatesController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestartReactAppExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"resolveReactHostForRestart", "Lcom/facebook/react/ReactHost;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "restart", "", "activity", "Landroid/app/Activity;", "reason", "", "expo-updates_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RestartReactAppExtensionsKt {
    public static final ReactHost resolveReactHostForRestart(Context context) {
        ReactHost reactHost;
        Intrinsics.checkNotNullParameter(context, "context");
        Object applicationContext = context.getApplicationContext();
        ReactApplication reactApplication = applicationContext instanceof ReactApplication ? (ReactApplication) applicationContext : null;
        return (reactApplication == null || (reactHost = reactApplication.getReactHost()) == null) ? UpdatesController.getInstance().getReactHost().get() : reactHost;
    }

    public static final void restart(ReactHost reactHost, Activity activity, String reason) {
        Intrinsics.checkNotNullParameter(reactHost, "<this>");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (reactHost.getLifecycleState() != LifecycleState.RESUMED && activity != null) {
            reactHost.onHostResume(activity);
        }
        reactHost.reload(reason);
    }
}
