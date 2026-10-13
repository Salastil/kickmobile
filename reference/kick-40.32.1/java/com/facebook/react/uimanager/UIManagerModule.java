package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.BlackHoleEventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.internal.LegacyArchitectureShadowNodeLogger;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: UIManagerModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release")
@ReactModule(name = UIManagerModule.NAME)
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0096\u0001\u0097\u0001\u0098\u0001B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB/\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000fJ\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\u0016H\u0017J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0012H\u0017J\b\u0010,\u001a\u00020*H\u0017J\u0012\u00103\u001a\u0004\u0018\u00010\u00122\u0006\u00104\u001a\u00020\u0012H\u0017J\b\u00105\u001a\u00020\u001fH\u0016J\u001f\u0010:\u001a\u00020\t\"\b\b\u0000\u0010;*\u00020<2\u0006\u0010=\u001a\u0002H;H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020AH\u0016J)\u0010:\u001a\u00020\t\"\b\b\u0000\u0010;*\u00020<2\u0006\u0010=\u001a\u0002H;2\b\u0010B\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u0010CJC\u0010D\u001a\u00020\t\"\n\b\u0000\u0010;*\u0004\u0018\u00010<2\u0006\u0010=\u001a\u0002H;2\u0006\u0010E\u001a\u00020\u00122\b\u0010B\u001a\u0004\u0018\u00010*2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016¢\u0006\u0002\u0010HJ\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\tH\u0017J \u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0016J0\u0010P\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0016J\u0018\u0010U\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\u0013H\u0016J*\u0010X\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\"\u0010Z\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010AH\u0017JB\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010`\u001a\u0004\u0018\u00010^2\b\u0010a\u001a\u0004\u0018\u00010^2\b\u0010b\u001a\u0004\u0018\u00010^H\u0017J\u0018\u0010c\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010d\u001a\u00020^H\u0017J\u0018\u0010e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010f\u001a\u00020gH\u0017J\u0018\u0010h\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010f\u001a\u00020gH\u0017J(\u0010i\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\t2\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020g2\u0006\u0010l\u001a\u00020gH\u0017J \u0010m\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010n\u001a\u00020^2\u0006\u0010f\u001a\u00020gH\u0017J \u0010o\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010p\u001a\u00020\t2\u0006\u0010f\u001a\u00020gH\u0017J\u0018\u0010q\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010r\u001a\u00020sH\u0017J\b\u0010t\u001a\u00020\u001fH\u0017J\"\u0010u\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010^H\u0017J\"\u0010y\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010v\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010^H\u0017J\"\u0010y\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010v\u001a\u00020\u00122\b\u0010x\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010z\u001a\u00020\u001f2\u0006\u0010{\u001a\u00020sH\u0017J \u0010|\u001a\u00020\u001f2\u0006\u0010}\u001a\u00020A2\u0006\u0010~\u001a\u00020g2\u0006\u0010\u007f\u001a\u00020gH\u0017J\u001a\u0010\u0084\u0001\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0017J\u0013\u0010\u0086\u0001\u001a\u00020\u001f2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0017J\u0013\u0010\u0089\u0001\u001a\u00020\u001f2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0017J\u0012\u0010\u008a\u0001\u001a\u00020\u001f2\u0007\u0010\u008b\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008b\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0017J\u0011\u0010\u008e\u0001\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\tH\u0016J4\u0010\u008f\u0001\u001a\u00020\u001f2\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020\tH\u0016J\u0013\u0010\u0093\u0001\u001a\u0004\u0018\u00010<2\u0006\u0010&\u001a\u00020\tH\u0016J$\u0010\u0094\u0001\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00122\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010*H\u0016J,\u0010\u0094\u0001\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00122\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010*H\u0016R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020.8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002070\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u0010\u0080\u0001\u001a\u00030\u0081\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/facebook/react/uimanager/UIManagerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/facebook/react/bridge/UIManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "viewManagerResolver", "Lcom/facebook/react/uimanager/ViewManagerResolver;", "minTimeLeftInFrameForNonBatchedOperationMs", "", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/ViewManagerResolver;I)V", "viewManagersList", "", "Lcom/facebook/react/uimanager/ViewManager;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;I)V", "mModuleConstants", "", "", "", "mCustomDirectEvents", "mViewManagerRegistry", "Lcom/facebook/react/uimanager/ViewManagerRegistry;", "mMemoryTrimCallback", "Lcom/facebook/react/uimanager/UIManagerModule$MemoryTrimCallback;", "mUIManagerListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/facebook/react/bridge/UIManagerListener;", "getName", "getConstants", "initialize", "", "onHostResume", "onHostPause", "onHostDestroy", "invalidate", "markActiveTouchForTag", "surfaceId", "reactTag", "sweepActiveTouchForTag", "getViewManagerRegistry_DO_NOT_USE", "getConstantsForViewManager", "Lcom/facebook/react/bridge/WritableMap;", "viewManagerName", "getDefaultEventTypes", "directEventNamesResolver", "Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "getDirectEventNamesResolver$annotations", "()V", "getDirectEventNamesResolver", "()Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "resolveCustomDirectEventName", "eventName", "profileNextBatch", "performanceCounters", "", "getPerformanceCounters", "()Ljava/util/Map;", "addRootView", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "rootView", "(Landroid/view/View;)I", "synchronouslyUpdateViewOnUIThread", "props", "Lcom/facebook/react/bridge/ReadableMap;", "initialProps", "(Landroid/view/View;Lcom/facebook/react/bridge/WritableMap;)I", "startSurface", "moduleName", "widthMeasureSpec", "heightMeasureSpec", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;II)I", "stopSurface", "removeRootView", "rootViewTag", "updateNodeSize", "nodeViewTag", "newWidth", "newHeight", "updateInsetsPadding", ViewProps.TOP, "left", ViewProps.BOTTOM, "right", "setViewLocalData", "tag", "data", "createView", "className", "updateView", "manageChildren", "viewTag", "moveFrom", "Lcom/facebook/react/bridge/ReadableArray;", "moveTo", "addChildTags", "addAtIndices", "removeFrom", "setChildren", "childrenTags", "measure", "callback", "Lcom/facebook/react/bridge/Callback;", "measureInWindow", "measureLayout", "ancestorTag", "errorCallback", "successCallback", "findSubviewIn", "point", "viewIsDescendantOf", "ancestorReactTag", "setJSResponder", "blockNativeResponder", "", "clearJSResponder", "dispatchViewManagerCommand", "commandId", "Lcom/facebook/react/bridge/Dynamic;", "commandArgs", "dispatchCommand", "setLayoutAnimationEnabledExperimental", "enabled", "configureNextLayoutAnimation", "config", FirebaseAnalytics.Param.SUCCESS, "error", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcher", "()Lcom/facebook/react/uimanager/events/EventDispatcher;", "sendAccessibilityEvent", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "addUIBlock", "block", "Lcom/facebook/react/uimanager/UIBlock;", "prependUIBlock", "addUIManagerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeUIManagerEventListener", "resolveRootTagFromReactTag", "invalidateNodeLayout", "updateRootLayoutSpecs", "rootTag", "offsetX", "offsetY", "resolveView", "receiveEvent", "event", "CustomEventNamesResolver", "MemoryTrimCallback", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UIManagerModule extends ReactContextBaseJavaModule implements LifecycleEventListener, UIManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG;
    public static final String NAME = "UIManager";
    public static final String TAG;
    private final Map<String, Object> mCustomDirectEvents;
    private final MemoryTrimCallback mMemoryTrimCallback;
    private final Map<String, Object> mModuleConstants;
    private final CopyOnWriteArrayList<UIManagerListener> mUIManagerListeners;
    private final ViewManagerRegistry mViewManagerRegistry;

    /* JADX INFO: compiled from: UIManagerModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "", "resolveCustomEventName", "", "eventName", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface CustomEventNamesResolver {
        String resolveCustomEventName(String eventName);
    }

    /* JADX INFO: compiled from: UIManagerModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/react/uimanager/UIManagerModule$MemoryTrimCallback;", "Landroid/content/ComponentCallbacks2;", "<init>", "()V", "onTrimMemory", "", FirebaseAnalytics.Param.LEVEL, "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class MemoryTrimCallback implements ComponentCallbacks2 {
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
        }
    }

    @JvmStatic
    public static final Map<String, Object> createConstants(List<? extends ViewManager<?, ?>> list, Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        return INSTANCE.createConstants(list, map, map2);
    }

    @JvmStatic
    public static final WritableMap getConstantsForViewManager(ViewManager<?, ?> viewManager, Map<String, ? extends Object> map) {
        return INSTANCE.getConstantsForViewManager(viewManager, map);
    }

    @Deprecated(message = "Use resolveCustomDirectEventName instead.")
    public static /* synthetic */ void getDirectEventNamesResolver$annotations() {
    }

    @Deprecated(message = "This method is a no-op stub. Use UIManagerListener or View Commands instead.")
    public void addUIBlock(UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @ReactMethod
    public void clearJSResponder() {
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap config, Callback success, Callback error) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.facebook.react.bridge.UIManager
    @Deprecated(message = "Use dispatchCommand(int, String, ReadableArray) instead.")
    public void dispatchCommand(int reactTag, int commandId, ReadableArray commandArgs) {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void dispatchCommand(int reactTag, String commandId, ReadableArray commandArgs) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
    }

    @ReactMethod
    public void findSubviewIn(int reactTag, ReadableArray point, Callback callback) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public void invalidateNodeLayout(int tag) {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void markActiveTouchForTag(int surfaceId, int reactTag) {
    }

    @ReactMethod
    public void measure(int reactTag, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @ReactMethod
    public void measureInWindow(int reactTag, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @ReactMethod
    public void measureLayout(int tag, int ancestorTag, Callback errorCallback, Callback successCallback) {
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Deprecated(message = "This method is a no-op stub. Use UIManagerListener or View Commands instead.")
    public void prependUIBlock(UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public void profileNextBatch() {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int surfaceId, int reactTag, String eventName, WritableMap event) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public void removeRootView(int rootViewTag) {
    }

    @ReactMethod
    public void setJSResponder(int reactTag, boolean blockNativeResponder) {
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean enabled) {
    }

    public void setViewLocalData(int tag, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.facebook.react.bridge.UIManager
    public void sweepActiveTouchForTag(int surfaceId, int reactTag) {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void synchronouslyUpdateViewOnUIThread(int reactTag, ReadableMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
    }

    public void updateInsetsPadding(int nodeViewTag, int top, int left, int bottom, int right) {
    }

    public void updateNodeSize(int nodeViewTag, int newWidth, int newHeight) {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void updateRootLayoutSpecs(int rootTag, int widthMeasureSpec, int heightMeasureSpec, int offsetX, int offsetY) {
    }

    @Deprecated(message = "This method will not be available in FabricUIManager class.")
    @ReactMethod
    public void viewIsDescendantOf(int reactTag, int ancestorReactTag, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIManagerModule(ReactApplicationContext reactContext, ViewManagerResolver viewManagerResolver, int i) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerResolver, "viewManagerResolver");
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactContext);
        this.mModuleConstants = INSTANCE.createConstants(viewManagerResolver);
        this.mCustomDirectEvents = UIManagerModuleConstants.directEventTypeConstants;
        this.mViewManagerRegistry = new ViewManagerRegistry(viewManagerResolver);
        reactContext.addLifecycleEventListener(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIManagerModule(ReactApplicationContext reactContext, List<? extends ViewManager<?, ?>> viewManagersList, int i) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagersList, "viewManagersList");
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactContext);
        HashMap mapNewHashMap = MapBuilder.newHashMap();
        this.mCustomDirectEvents = mapNewHashMap;
        this.mModuleConstants = INSTANCE.createConstants(viewManagersList, null, mapNewHashMap);
        this.mViewManagerRegistry = new ViewManagerRegistry(viewManagersList);
        if (ReactBuildConfig.DEBUG) {
            for (ViewManager<?, ?> viewManager : viewManagersList) {
                Class<? extends C> shadowNodeClass = viewManager.getShadowNodeClass();
                Intrinsics.checkNotNullExpressionValue(shadowNodeClass, "getShadowNodeClass(...)");
                String simpleName = viewManager.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                LegacyArchitectureShadowNodeLogger.assertUnsupportedViewManager(reactContext, shadowNodeClass, simpleName);
            }
        }
        reactContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        getReactApplicationContext().registerComponentCallbacks(this.mViewManagerRegistry);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        reactApplicationContext.unregisterComponentCallbacks(this.mMemoryTrimCallback);
        reactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        ViewManagerPropertyUpdater.clear();
    }

    @Deprecated(message = "Do not use this method as this will be removed in the near future.")
    /* JADX INFO: renamed from: getViewManagerRegistry_DO_NOT_USE, reason: from getter */
    public ViewManagerRegistry getMViewManagerRegistry() {
        return this.mViewManagerRegistry;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String viewManagerName) {
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ViewManager<?, ?> viewManagerIfExists = this.mViewManagerRegistry.getViewManagerIfExists(viewManagerName);
        if (viewManagerIfExists == null) {
            return null;
        }
        return INSTANCE.getConstantsForViewManager(viewManagerIfExists, this.mCustomDirectEvents);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap((Map<String, ? extends Object>) UIManagerModuleConstantsHelper.getDefaultExportableEventTypes());
    }

    public CustomEventNamesResolver getDirectEventNamesResolver() {
        return new CustomEventNamesResolver() { // from class: com.facebook.react.uimanager.UIManagerModule$directEventNamesResolver$1
            @Override // com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver
            public String resolveCustomEventName(String eventName) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                return this.this$0.resolveCustomDirectEventName(eventName);
            }
        };
    }

    @Override // com.facebook.react.bridge.UIManager
    @Deprecated(message = "This method is deprecated.")
    public String resolveCustomDirectEventName(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Object obj = this.mCustomDirectEvents.get(eventName);
        Map map = obj instanceof Map ? (Map) obj : null;
        return map != null ? (String) map.get("registrationName") : eventName;
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public Map<String, Long> getPerformanceCounters() {
        return new HashMap();
    }

    public <T extends View> int addRootView(T rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        return addRootView(rootView, null);
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int addRootView(T rootView, WritableMap initialProps) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Systrace.beginSection(0L, "UIManagerModule.addRootView");
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        Systrace.endSection(0L);
        return nextRootViewTag;
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int startSurface(T rootView, String moduleName, WritableMap initialProps, int widthMeasureSpec, int heightMeasureSpec) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.react.bridge.UIManager
    public void stopSurface(int surfaceId) {
        throw new UnsupportedOperationException();
    }

    @ReactMethod
    public void createView(int tag, String className, int rootViewTag, ReadableMap props) {
        Intrinsics.checkNotNullParameter(className, "className");
        if (DEBUG) {
            String str = "(UIManager.createView) tag: " + tag + ", class: " + className + ", props: " + props;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
    }

    @ReactMethod
    public void updateView(int tag, String className, ReadableMap props) {
        Intrinsics.checkNotNullParameter(className, "className");
        if (DEBUG) {
            String str = "(UIManager.updateView) tag: " + tag + ", class: " + className + ", props: " + props;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
    }

    @ReactMethod
    public void manageChildren(int viewTag, ReadableArray moveFrom, ReadableArray moveTo, ReadableArray addChildTags, ReadableArray addAtIndices, ReadableArray removeFrom) {
        if (DEBUG) {
            String str = "(UIManager.manageChildren) tag: " + viewTag + ", moveFrom: " + moveFrom + ", moveTo: " + moveTo + ", addTags: " + addChildTags + ", atIndices: " + addAtIndices + ", removeFrom: " + removeFrom;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
    }

    @ReactMethod
    public void setChildren(int viewTag, ReadableArray childrenTags) {
        Intrinsics.checkNotNullParameter(childrenTags, "childrenTags");
        if (DEBUG) {
            String str = "(UIManager.setChildren) tag: " + viewTag + ", children: " + childrenTags;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int reactTag, Dynamic commandId, ReadableArray commandArgs) {
        String strAsString;
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, 2);
        if (uIManager == null) {
            return;
        }
        if (commandId.getType() == ReadableType.Number) {
            uIManager.dispatchCommand(reactTag, commandId.asInt(), commandArgs);
        } else {
            if (commandId.getType() != ReadableType.String || (strAsString = commandId.asString()) == null) {
                return;
            }
            uIManager.dispatchCommand(reactTag, strAsString, commandArgs);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public EventDispatcher getEventDispatcher() {
        return BlackHoleEventDispatcher.INSTANCE;
    }

    @Override // com.facebook.react.bridge.UIManager
    @ReactMethod
    public void sendAccessibilityEvent(int reactTag, int eventType) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, 2);
        if (uIManager != null) {
            uIManager.sendAccessibilityEvent(reactTag, eventType);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public void addUIManagerEventListener(UIManagerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mUIManagerListeners.add(listener);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void removeUIManagerEventListener(UIManagerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mUIManagerListeners.remove(listener);
    }

    @Deprecated(message = "Use ViewUtil.isRootTag(int) to verify if a react Tag is a root or not.")
    public int resolveRootTagFromReactTag(int reactTag) {
        if (ViewUtil.isRootTag(reactTag)) {
            return reactTag;
        }
        return 0;
    }

    @Override // com.facebook.react.bridge.UIManager, com.facebook.react.fabric.interop.UIBlockViewResolver
    public View resolveView(int reactTag) {
        UiThreadUtil.assertOnUiThread();
        return null;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int reactTag, String eventName, WritableMap event) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, reactTag, eventName, event);
    }

    /* JADX INFO: compiled from: UIManagerModule.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JV\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J.\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/uimanager/UIManagerModule$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "DEBUG", "", "createConstants", "", "viewManagerResolver", "Lcom/facebook/react/uimanager/ViewManagerResolver;", "viewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "customBubblingEvents", "customDirectEvents", "getConstantsForViewManager", "Lcom/facebook/react/bridge/WritableMap;", "viewManager", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
            SystraceMessage.beginSection(0L, "CreateUIManagerConstants").arg("Lazy", (Object) true).flush();
            try {
                return UIManagerModuleConstantsHelper.internal_createConstants(viewManagerResolver);
            } finally {
                Systrace.endSection(0L);
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
            }
        }

        @JvmStatic
        public final Map<String, Object> createConstants(List<? extends ViewManager<?, ?>> viewManagers, Map<String, ? extends Object> customBubblingEvents, Map<String, ? extends Object> customDirectEvents) {
            Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
            SystraceMessage.beginSection(0L, "CreateUIManagerConstants").arg("Lazy", (Object) false).flush();
            try {
                if (!TypeIntrinsics.isMutableMap(customBubblingEvents)) {
                    customBubblingEvents = null;
                }
                if (!TypeIntrinsics.isMutableMap(customDirectEvents)) {
                    customDirectEvents = null;
                }
                return UIManagerModuleConstantsHelper.internal_createConstants(viewManagers, customBubblingEvents, customDirectEvents);
            } finally {
                Systrace.endSection(0L);
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
            }
        }

        @JvmStatic
        public final WritableMap getConstantsForViewManager(ViewManager<?, ?> viewManager, Map<String, ? extends Object> customDirectEvents) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            Intrinsics.checkNotNullParameter(customDirectEvents, "customDirectEvents");
            SystraceMessage.Builder builderBeginSection = SystraceMessage.beginSection(0L, "UIManagerModule.getConstantsForViewManager");
            String name = viewManager.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            builderBeginSection.arg("ViewManager", name).arg("Lazy", (Object) true).flush();
            try {
                if (!TypeIntrinsics.isMutableMap(customDirectEvents)) {
                    customDirectEvents = null;
                }
                return Arguments.makeNativeMap((Map<String, ? extends Object>) UIManagerModuleConstantsHelper.internal_createConstantsForViewManager(viewManager, null, null, null, customDirectEvents));
            } finally {
                SystraceMessage.endSection(0L).flush();
            }
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("UIManagerModule", "getSimpleName(...)");
        TAG = "UIManagerModule";
        DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.UI_MANAGER);
        LegacyArchitectureLogger.assertLegacyArchitecture("UIManagerModule", LegacyArchitectureLogLevel.ERROR);
    }
}
