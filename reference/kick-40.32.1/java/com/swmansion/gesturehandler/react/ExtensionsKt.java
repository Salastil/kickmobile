package com.swmansion.gesturehandler.react;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u000b\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"deviceEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "Lcom/facebook/react/bridge/ReactContext;", "getDeviceEventEmitter", "(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "isScreenReaderOn", "", "isHoverAction", "Landroid/view/MotionEvent;", "isButtonAction", "getPointerType", "", "pointerIndex", "minimumFrameTime", "", "Landroid/view/Display;", "getMinimumFrameTime", "(Landroid/view/Display;)F", "react-native-gesture-handler_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ExtensionsKt {
    public static final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        JavaScriptModule jSModule = reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        Intrinsics.checkNotNullExpressionValue(jSModule, "getJSModule(...)");
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
    }

    public static final Activity findActivity(Context context) {
        if (context instanceof ReactContext) {
            return ((ReactContext) context).getCurrentActivity();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static final boolean isScreenReaderOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
    }

    public static final boolean isHoverAction(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        return motionEvent.getAction() == 7 || motionEvent.getAction() == 9 || motionEvent.getAction() == 10;
    }

    public static final boolean isButtonAction(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        return motionEvent.getActionMasked() == 11 || motionEvent.getActionMasked() == 12;
    }

    public static final int getPointerType(MotionEvent motionEvent, int i) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        int toolType = motionEvent.getToolType(i);
        if (toolType == 1) {
            return 0;
        }
        int i2 = 2;
        if (toolType != 2) {
            if (toolType != 3) {
                i2 = 4;
                if (toolType != 4) {
                }
            }
            return i2;
        }
        return 1;
    }

    public static /* synthetic */ int getPointerType$default(MotionEvent motionEvent, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return getPointerType(motionEvent, i);
    }

    public static final float getMinimumFrameTime(Display display) {
        Intrinsics.checkNotNullParameter(display, "<this>");
        Display.Mode[] supportedModes = display.getSupportedModes();
        Intrinsics.checkNotNull(supportedModes);
        float refreshRate = 0.0f;
        for (Display.Mode mode : supportedModes) {
            if (mode.getRefreshRate() > refreshRate) {
                refreshRate = mode.getRefreshRate();
            }
        }
        if (refreshRate <= 0.0f) {
            refreshRate = display.getRefreshRate() > 0.0f ? display.getRefreshRate() : 60.0f;
        }
        return 1000.0f / refreshRate;
    }
}
