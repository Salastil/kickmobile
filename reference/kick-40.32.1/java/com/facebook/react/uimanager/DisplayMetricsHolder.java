package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayMetricsHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\u001d"}, d2 = {"Lcom/facebook/react/uimanager/DisplayMetricsHolder;", "", "<init>", "()V", "INITIALIZATION_MISSING_MESSAGE", "", "screenDisplayMetrics", "Landroid/util/DisplayMetrics;", "getScreenDisplayMetrics$annotations", "getScreenDisplayMetrics", "setScreenDisplayMetrics", "", "displayMetrics", "initDisplayMetricsIfNotInitialized", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "initDisplayMetrics", "getStatusBarHeightPx", "", "activity", "Landroid/app/Activity;", "getStatusBarHeightPx$ReactAndroid", "getEncodedScreenSizeWithoutVerticalInsets", "", "encodeFloatsToLong", ViewProps.WIDTH, "", ViewProps.HEIGHT, "encodeFloatsToLong$ReactAndroid", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DisplayMetricsHolder {
    private static final String INITIALIZATION_MISSING_MESSAGE = "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics";
    public static final DisplayMetricsHolder INSTANCE = new DisplayMetricsHolder();
    private static DisplayMetrics screenDisplayMetrics;

    @JvmStatic
    private static /* synthetic */ void getScreenDisplayMetrics$annotations() {
    }

    private DisplayMetricsHolder() {
    }

    @JvmStatic
    public static final DisplayMetrics getScreenDisplayMetrics() {
        DisplayMetrics displayMetrics = screenDisplayMetrics;
        if (displayMetrics == null) {
            throw new IllegalStateException(INITIALIZATION_MISSING_MESSAGE.toString());
        }
        Intrinsics.checkNotNull(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
        return displayMetrics;
    }

    @JvmStatic
    public static final void setScreenDisplayMetrics(DisplayMetrics displayMetrics) {
        screenDisplayMetrics = displayMetrics;
    }

    @JvmStatic
    public static final void initDisplayMetricsIfNotInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (screenDisplayMetrics != null) {
            return;
        }
        initDisplayMetrics(context);
    }

    @JvmStatic
    public static final void initDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        try {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics2);
        } catch (Exception unused) {
        }
        displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
        screenDisplayMetrics = displayMetrics2;
    }

    public final int getStatusBarHeightPx$ReactAndroid(Activity activity) {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) == null) {
            return 0;
        }
        return rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    @JvmStatic
    public static final long getEncodedScreenSizeWithoutVerticalInsets(Activity activity) {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) == null) {
            return 0L;
        }
        Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        int i = insets.top + insets.bottom;
        DisplayMetricsHolder displayMetricsHolder = INSTANCE;
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        DisplayMetrics displayMetrics = screenDisplayMetrics;
        if (displayMetrics == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        float fPxToDp = pixelUtil.pxToDp(displayMetrics.widthPixels);
        PixelUtil pixelUtil2 = PixelUtil.INSTANCE;
        DisplayMetrics displayMetrics2 = screenDisplayMetrics;
        if (displayMetrics2 != null) {
            return displayMetricsHolder.encodeFloatsToLong$ReactAndroid(fPxToDp, pixelUtil2.pxToDp(displayMetrics2.heightPixels - i));
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final long encodeFloatsToLong$ReactAndroid(float width, float height) {
        return (((long) Float.floatToRawIntBits(width)) << 32) | ((long) Float.floatToRawIntBits(height));
    }
}
