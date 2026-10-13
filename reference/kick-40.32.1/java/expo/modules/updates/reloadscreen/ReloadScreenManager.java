package expo.modules.updates.reloadscreen;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.datadog.android.webview.WebViewTracking;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ReloadScreenManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "", "<init>", "()V", "currentConfiguration", "Lexpo/modules/updates/reloadscreen/ReloadScreenConfiguration;", "currentReloadScreen", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updates/reloadscreen/ReloadScreenView;", "currentActivity", "Landroid/app/Activity;", "isShowing", "", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "reloadListener", "Lcom/facebook/react/bridge/ReactMarker$MarkerListener;", "setConfiguration", "", "options", "Lexpo/modules/updates/reloadscreen/ReloadScreenOptions;", WebViewTracking.SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY, "activity", WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "showReloadScreen", "hideReloadScreen", "removeView", "reloadScreen", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReloadScreenManager {
    private WeakReference<Activity> currentActivity;
    private ReloadScreenConfiguration currentConfiguration;
    private WeakReference<ReloadScreenView> currentReloadScreen;
    private boolean isShowing;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final ReactMarker.MarkerListener reloadListener = new ReactMarker.MarkerListener() { // from class: expo.modules.updates.reloadscreen.ReloadScreenManager$$ExternalSyntheticLambda0
        @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
        public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
            ReloadScreenManager.reloadListener$lambda$0(this.f$0, reactMarkerConstants, str, i);
        }
    };

    static final void reloadListener$lambda$0(ReloadScreenManager reloadScreenManager, ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name == ReactMarkerConstants.RUN_JS_BUNDLE_END && reloadScreenManager.isShowing) {
            BuildersKt__Builders_commonKt.launch$default(reloadScreenManager.scope, null, null, new ReloadScreenManager$reloadListener$1$1(reloadScreenManager, null), 3, null);
        }
    }

    public final void setConfiguration(ReloadScreenOptions options) {
        this.currentConfiguration = ReloadScreenConfiguration.INSTANCE.fromOptions(options);
    }

    public static /* synthetic */ void show$default(ReloadScreenManager reloadScreenManager, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = null;
        }
        reloadScreenManager.show(activity);
    }

    public final void show(Activity activity) {
        if (this.isShowing) {
            return;
        }
        ReactMarker.addListener(this.reloadListener);
        if (activity == null) {
            WeakReference<Activity> weakReference = this.currentActivity;
            activity = weakReference != null ? weakReference.get() : null;
        }
        if (activity == null) {
            return;
        }
        showReloadScreen(activity);
        this.isShowing = true;
    }

    public final void hide() {
        if (this.isShowing) {
            hideReloadScreen();
            this.isShowing = false;
        }
    }

    private final void showReloadScreen(Activity activity) {
        ReloadScreenConfiguration reloadScreenConfigurationFromOptions = this.currentConfiguration;
        if (reloadScreenConfigurationFromOptions == null) {
            reloadScreenConfigurationFromOptions = ReloadScreenConfiguration.INSTANCE.fromOptions(null);
        }
        ReloadScreenView reloadScreenView = new ReloadScreenView(activity, null, 0, 6, null);
        reloadScreenView.updateConfiguration(reloadScreenConfigurationFromOptions);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.addView(reloadScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.currentReloadScreen = new WeakReference<>(reloadScreenView);
    }

    private final void hideReloadScreen() {
        final ReloadScreenView reloadScreenView;
        WeakReference<ReloadScreenView> weakReference = this.currentReloadScreen;
        if (weakReference == null || (reloadScreenView = weakReference.get()) == null) {
            return;
        }
        ReloadScreenConfiguration reloadScreenConfiguration = this.currentConfiguration;
        if (reloadScreenConfiguration != null && reloadScreenConfiguration.getFade()) {
            reloadScreenView.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: expo.modules.updates.reloadscreen.ReloadScreenManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.removeView(reloadScreenView);
                }
            }).start();
        } else {
            removeView(reloadScreenView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeView(ReloadScreenView reloadScreen) {
        ViewParent parent = reloadScreen.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(reloadScreen);
        }
        this.currentReloadScreen = null;
        ReactMarker.removeListener(this.reloadListener);
    }
}
