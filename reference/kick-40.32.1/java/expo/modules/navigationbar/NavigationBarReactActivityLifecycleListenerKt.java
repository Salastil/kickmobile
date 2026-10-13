package expo.modules.navigationbar;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationBarReactActivityLifecycleListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00060\u0002R\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000¨\u0006\n"}, d2 = {"getBooleanAttribute", "", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attr", "", "defValue", "disableNavigationBarContrast", "", "Landroid/view/Window;", "expo-navigation-bar_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarReactActivityLifecycleListenerKt {
    public static final boolean getBooleanAttribute(Resources.Theme theme, int i, boolean z) {
        Intrinsics.checkNotNullParameter(theme, "<this>");
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, z);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static final void disableNavigationBarContrast(Window window) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            window.setNavigationBarColor(0);
        } else {
            window.setNavigationBarContrastEnforced(false);
        }
    }
}
