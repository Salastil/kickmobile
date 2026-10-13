package com.facebook.react.views.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.util.AndroidVersion;
import com.facebook.react.views.common.UiModeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0006\u0010\n\u001a\u00020\f\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\f*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\f*\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0000\u001a\f\u0010\u0018\u001a\u00020\f*\u00020\u0011H\u0002\u001a\f\u0010\u0019\u001a\u00020\f*\u00020\u0011H\u0002\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\u0011H\u0000\u001a\f\u0010\u001b\u001a\u00020\f*\u00020\u0011H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"LightNavigationBarColor", "", "getLightNavigationBarColor", "()I", "DarkNavigationBarColor", "getDarkNavigationBarColor", "value", "", "isEdgeToEdgeFeatureFlagOn", "()Z", "setEdgeToEdgeFeatureFlagOn", "(Z)V", "", "updateEdgeToEdgeFeatureFlag", "activity", "Landroid/app/Activity;", "setStatusBarTranslucency", "Landroid/view/Window;", "isTranslucent", "setStatusBarVisibility", "isHidden", "setStatusBarStyle", "style", "", "statusBarHide", "statusBarShow", "enableEdgeToEdge", "disableEdgeToEdge", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WindowUtilKt {
    private static boolean isEdgeToEdgeFeatureFlagOn;
    private static final int LightNavigationBarColor = Color.argb(230, 255, 255, 255);
    private static final int DarkNavigationBarColor = Color.argb(128, 27, 27, 27);

    public static final int getLightNavigationBarColor() {
        return LightNavigationBarColor;
    }

    public static final int getDarkNavigationBarColor() {
        return DarkNavigationBarColor;
    }

    public static final boolean isEdgeToEdgeFeatureFlagOn() {
        return isEdgeToEdgeFeatureFlagOn;
    }

    public static final void setEdgeToEdgeFeatureFlagOn(boolean z) {
        isEdgeToEdgeFeatureFlagOn = z;
    }

    public static final void setEdgeToEdgeFeatureFlagOn() {
        isEdgeToEdgeFeatureFlagOn = true;
    }

    public static final void updateEdgeToEdgeFeatureFlag(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (AndroidVersion.isAtLeastTargetSdk35$ReactAndroid(activity)) {
            if (Build.VERSION.SDK_INT >= 36) {
                isEdgeToEdgeFeatureFlagOn = true;
            } else {
                TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16844442});
                Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
                try {
                    boolean z = !typedArrayObtainStyledAttributes.getBoolean(0, false);
                    typedArrayObtainStyledAttributes.recycle();
                    isEdgeToEdgeFeatureFlagOn = z;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
        }
        if (isEdgeToEdgeFeatureFlagOn) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            enableEdgeToEdge(window);
        }
    }

    public static final void setStatusBarTranslucency(Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (z) {
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.react.views.view.WindowUtilKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return WindowUtilKt.setStatusBarTranslucency$lambda$0(view, windowInsets);
                }
            });
        } else {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
        }
        ViewCompat.requestApplyInsets(window.getDecorView());
    }

    static final WindowInsets setStatusBarTranslucency$lambda$0(View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsets windowInsetsOnApplyWindowInsets = v.onApplyWindowInsets(insets);
        return windowInsetsOnApplyWindowInsets.replaceSystemWindowInsets(windowInsetsOnApplyWindowInsets.getSystemWindowInsetLeft(), 0, windowInsetsOnApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsOnApplyWindowInsets.getSystemWindowInsetBottom());
    }

    public static final void setStatusBarVisibility(Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (z) {
            statusBarHide(window);
        } else {
            statusBarShow(window);
        }
    }

    public static final void setStatusBarStyle(Window window, String str) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (Build.VERSION.SDK_INT > 30) {
            if (Intrinsics.areEqual("dark-content", str)) {
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.setSystemBarsAppearance(8, 8);
                    return;
                }
                return;
            }
            WindowInsetsController insetsController2 = window.getInsetsController();
            if (insetsController2 != null) {
                insetsController2.setSystemBarsAppearance(0, 8);
                return;
            }
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(Intrinsics.areEqual("dark-content", str) ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    private static final void statusBarHide(Window window) {
        if (window.getDecorView().isAttachedToWindow()) {
            if (isEdgeToEdgeFeatureFlagOn) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                windowInsetsControllerCompat.setSystemBarsBehavior(2);
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    window.getAttributes().layoutInDisplayCutoutMode = 1;
                    window.setDecorFitsSystemWindows(false);
                }
                window.addFlags(1024);
                window.clearFlags(2048);
            }
        }
    }

    private static final void statusBarShow(Window window) {
        if (window.getDecorView().isAttachedToWindow()) {
            if (isEdgeToEdgeFeatureFlagOn) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                windowInsetsControllerCompat.setSystemBarsBehavior(2);
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    window.getAttributes().layoutInDisplayCutoutMode = 0;
                    window.setDecorFitsSystemWindows(true);
                }
                window.addFlags(2048);
                window.clearFlags(1024);
            }
        }
    }

    public static final void enableEdgeToEdge(Window window) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        boolean z = false;
        WindowCompat.setDecorFitsSystemWindows(window, false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        Context context = window.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean zIsDarkMode = UiModeUtils.isDarkMode(context);
        window.setStatusBarColor(0);
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarColor(0);
            TypedArray typedArrayObtainStyledAttributes = window.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enforceNavigationBarContrast});
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(z2);
                if (z2) {
                    windowInsetsControllerCompat.setAppearanceLightNavigationBars(!zIsDarkMode);
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            if (Build.VERSION.SDK_INT >= 26 && !zIsDarkMode) {
                z = true;
            }
            window.setNavigationBarColor(z ? LightNavigationBarColor : DarkNavigationBarColor);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(z);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = Build.VERSION.SDK_INT >= 30 ? 3 : 1;
        }
    }

    public static final void disableEdgeToEdge(Window window) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        WindowCompat.setDecorFitsSystemWindows(window, true);
    }
}
