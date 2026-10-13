package com.facebook.react.modules.deviceinfo;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.layout.WindowMetricsCalculator;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.WindowUtilKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfoModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "DeviceInfo")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\r\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/modules/deviceinfo/DeviceInfoModule;", "Lcom/facebook/fbreact/specs/NativeDeviceInfoSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "fontScale", "", "previousDisplayMetrics", "Lcom/facebook/react/bridge/ReadableMap;", "getWindowDisplayMetrics", "Landroid/util/DisplayMetrics;", "getWindowDisplayMetrics$ReactAndroid", "getDisplayMetricsWritableMap", "Lcom/facebook/react/bridge/WritableMap;", "getDisplayMetricsWritableMap$ReactAndroid", "getPhysicalPixelsWritableMap", "displayMetrics", "getTypedExportedConstants", "", "", "", "onHostResume", "", "onHostPause", "onHostDestroy", "emitUpdateDimensionsEvent", "invalidate", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    public static final String NAME = "DeviceInfo";
    private float fontScale;
    private ReadableMap previousDisplayMetrics;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.fontScale = reactContext.getResources().getConfiguration().fontScale;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactContext);
        reactContext.addLifecycleEventListener(this);
    }

    public final DisplayMetrics getWindowDisplayMetrics$ReactAndroid() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setTo(getReactApplicationContext().getResources().getDisplayMetrics());
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity != null) {
            try {
                Rect bounds = WindowMetricsCalculator.INSTANCE.getOrCreate().computeCurrentWindowMetrics(currentActivity).getBounds();
                if (WindowUtilKt.isEdgeToEdgeFeatureFlagOn()) {
                    displayMetrics.widthPixels = bounds.width();
                    displayMetrics.heightPixels = bounds.height();
                    return displayMetrics;
                }
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(currentActivity.getWindow().getDecorView());
                if (rootWindowInsets != null) {
                    Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                    Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
                    displayMetrics.widthPixels = bounds.width() - (insets.left + insets.right);
                    displayMetrics.heightPixels = bounds.height() - (insets.top + insets.bottom);
                }
            } catch (NoSuchMethodError e) {
                ReactSoftExceptionLogger.logSoftException("DeviceInfo", new ReactNoCrashSoftException("WindowMetrics API is unavailable; falling back to resource display metrics.", e));
                return displayMetrics;
            }
        }
        return displayMetrics;
    }

    public final WritableMap getDisplayMetricsWritableMap$ReactAndroid() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("windowPhysicalPixels", getPhysicalPixelsWritableMap(getWindowDisplayMetrics$ReactAndroid()));
        writableNativeMap.putMap("screenPhysicalPixels", getPhysicalPixelsWritableMap(DisplayMetricsHolder.getScreenDisplayMetrics()));
        return writableNativeMap;
    }

    private final WritableMap getPhysicalPixelsWritableMap(DisplayMetrics displayMetrics) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(ViewProps.WIDTH, displayMetrics.widthPixels);
        writableNativeMap.putInt(ViewProps.HEIGHT, displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", displayMetrics.density);
        writableNativeMap.putDouble("fontScale", this.fontScale);
        writableNativeMap.putDouble("densityDpi", displayMetrics.densityDpi);
        return writableNativeMap;
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceInfoSpec
    public Map<String, Object> getTypedExportedConstants() {
        WritableMap displayMetricsWritableMap$ReactAndroid = getDisplayMetricsWritableMap$ReactAndroid();
        this.previousDisplayMetrics = displayMetricsWritableMap$ReactAndroid.copy();
        return MapsKt.mapOf(TuplesKt.to("Dimensions", displayMetricsWritableMap$ReactAndroid.toHashMap()), TuplesKt.to("isEdgeToEdge", Boolean.valueOf(WindowUtilKt.isEdgeToEdgeFeatureFlagOn())));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        Configuration configuration;
        Resources resources = getReactApplicationContext().getResources();
        Float fValueOf = (resources == null || (configuration = resources.getConfiguration()) == null) ? null : Float.valueOf(configuration.fontScale);
        if (fValueOf == null || Intrinsics.areEqual(fValueOf, this.fontScale)) {
            return;
        }
        this.fontScale = fValueOf.floatValue();
        emitUpdateDimensionsEvent();
    }

    public final void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext.hasActiveReactInstance()) {
            WritableMap displayMetricsWritableMap$ReactAndroid = getDisplayMetricsWritableMap$ReactAndroid();
            ReadableMap readableMap = this.previousDisplayMetrics;
            if (readableMap == null) {
                this.previousDisplayMetrics = displayMetricsWritableMap$ReactAndroid.copy();
                return;
            } else {
                if (Intrinsics.areEqual(displayMetricsWritableMap$ReactAndroid, readableMap)) {
                    return;
                }
                this.previousDisplayMetrics = displayMetricsWritableMap$ReactAndroid.copy();
                reactApplicationContext.emitDeviceEvent("didUpdateDimensions", displayMetricsWritableMap$ReactAndroid);
                return;
            }
        }
        ReactSoftExceptionLogger.logSoftException("DeviceInfo", new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        getReactApplicationContext().removeLifecycleEventListener(this);
    }
}
