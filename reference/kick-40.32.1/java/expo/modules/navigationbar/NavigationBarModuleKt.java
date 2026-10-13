package expo.modules.navigationbar;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationBarModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0014\u0010\f\u001a\u00020\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u000e"}, d2 = {"LightNavigationBarColor", "", "getLightNavigationBarColor", "()I", "DarkNavigationBarColor", "getDarkNavigationBarColor", "setNavigationBarStyle", "", "Landroid/view/Window;", "hasLightBackground", "", "isContrastEnforced", "setNavigationBarHidden", ViewProps.HIDDEN, "expo-navigation-bar_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarModuleKt {
    private static final int LightNavigationBarColor = Color.argb(230, 255, 255, 255);
    private static final int DarkNavigationBarColor = Color.argb(128, 27, 27, 27);

    public static final int getLightNavigationBarColor() {
        return LightNavigationBarColor;
    }

    public static final int getDarkNavigationBarColor() {
        return DarkNavigationBarColor;
    }

    public static final void setNavigationBarStyle(Window window, boolean z, boolean z2) {
        int i;
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (!z2) {
                i = 0;
            } else if (z) {
                i = LightNavigationBarColor;
            } else {
                i = DarkNavigationBarColor;
            }
            window.setNavigationBarColor(i);
        } else {
            window.setNavigationBarContrastEnforced(z2);
        }
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(z);
    }

    public static final void setNavigationBarHidden(Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
        if (z) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
        }
    }
}
