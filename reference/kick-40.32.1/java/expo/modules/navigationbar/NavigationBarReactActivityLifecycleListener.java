package expo.modules.navigationbar;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationBarReactActivityLifecycleListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lexpo/modules/navigationbar/NavigationBarReactActivityLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "<init>", "()V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "expo-navigation-bar_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Resources.Theme theme = activity.getTheme();
        Window window = activity.getWindow();
        int i = Build.VERSION.SDK_INT < 29 ? R.attr.expoEnforceNavigationBarContrast : android.R.attr.enforceNavigationBarContrast;
        Intrinsics.checkNotNull(theme);
        if (!NavigationBarReactActivityLifecycleListenerKt.getBooleanAttribute(theme, i, true)) {
            Intrinsics.checkNotNull(window);
            NavigationBarReactActivityLifecycleListenerKt.disableNavigationBarContrast(window);
        }
        if (NavigationBarReactActivityLifecycleListenerKt.getBooleanAttribute(theme, R.attr.expoNavigationBarHidden, false)) {
            new WindowInsetsControllerCompat(window, window.getDecorView()).hide(WindowInsetsCompat.Type.navigationBars());
        }
    }
}
