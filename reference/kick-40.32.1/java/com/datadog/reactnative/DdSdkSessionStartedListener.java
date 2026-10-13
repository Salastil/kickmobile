package com.datadog.reactnative;

import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkSessionStartedListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0013J3\u0010\u001c\u001a\u00020\u00132)\u0010\b\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\tH\u0007J/\u0010\u001d\u001a\u00020\u00132%\u0010\u000f\u001a!\u0012\u0017\u0012\u00150\u0010j\u0002`\u0012¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00130\tH\u0007J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0015H\u0007J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0015H\u0007J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0003J\u001d\u0010(\u001a\u0004\u0018\u00010\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R3\u0010\b\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u000f\u001a#\u0012\u0017\u0012\u00150\u0010j\u0002`\u0012¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0013\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006-"}, d2 = {"Lcom/datadog/reactnative/DdSdkSessionStartedListener;", "Lcom/datadog/android/rum/RumSessionListener;", "<init>", "()V", "lastSessionId", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "convertToNativeArray", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "array", "Lcom/facebook/react/bridge/NativeArray;", "exceptionHandler", "Ljava/lang/Exception;", "error", "Lkotlin/Exception;", "", "isNewArchitecture", "", "Ljava/lang/Boolean;", "onSessionStarted", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "isDiscarded", "setReactContext", "onRnSdkInitialized", "setConvertToNativeArray", "setExceptionHandler", "setIsNewArchitecture", "isNewArch", "setIsRnSdkInitialized", "value", "setUiThreadExecutor", "executor", "Lcom/datadog/reactnative/UiThreadExecutor;", "hasValidBridge", "trySendSessionStartedToJS", "sendSessionIdWithBridge", "buildBridgeArgs", "args", "([Ljava/lang/String;)Lcom/facebook/react/bridge/NativeArray;", "sendSessionIdWithEventEmitter", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdkSessionStartedListener implements RumSessionListener {
    private static final String BRIDGE_MODULE_METHOD = "__datadogOnMessageReceived";
    private static final String BRIDGE_MODULE_NAME = "DatadogInternalReactBridge";
    private static DdSdkSessionStartedListener instance;
    private static boolean isRnSdkInitialized;
    private Function1<? super String[], ? extends NativeArray> convertToNativeArray;
    private Function1<? super Exception, Unit> exceptionHandler;
    private Boolean isNewArchitecture;
    private String lastSessionId;
    private ReactContext reactContext;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static UiThreadExecutor uiThreadExecutor = new ReactUiThreadExecutor();

    public /* synthetic */ DdSdkSessionStartedListener(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DdSdkSessionStartedListener.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/reactnative/DdSdkSessionStartedListener$Companion;", "", "<init>", "()V", "BRIDGE_MODULE_NAME", "", "BRIDGE_MODULE_METHOD", "instance", "Lcom/datadog/reactnative/DdSdkSessionStartedListener;", "isRnSdkInitialized", "", "uiThreadExecutor", "Lcom/datadog/reactnative/UiThreadExecutor;", "getInstance", "invalidate", "", "resetIsRnSdkInitialized", "isRnSdkInitializedForTests", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DdSdkSessionStartedListener getInstance() {
            if (DdSdkSessionStartedListener.instance == null) {
                DdSdkSessionStartedListener.instance = new DdSdkSessionStartedListener(null);
            }
            DdSdkSessionStartedListener ddSdkSessionStartedListener = DdSdkSessionStartedListener.instance;
            Intrinsics.checkNotNull(ddSdkSessionStartedListener);
            return ddSdkSessionStartedListener;
        }

        public final void invalidate() {
            DdSdkSessionStartedListener.instance = null;
        }

        public final void resetIsRnSdkInitialized() {
            DdSdkSessionStartedListener.isRnSdkInitialized = false;
        }

        public final boolean isRnSdkInitializedForTests() {
            return DdSdkSessionStartedListener.isRnSdkInitialized;
        }
    }

    private DdSdkSessionStartedListener() {
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean isDiscarded) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.lastSessionId = sessionId;
        trySendSessionStartedToJS(sessionId);
    }

    public final void setReactContext(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final String str = this.lastSessionId;
        if (str == null) {
            return;
        }
        uiThreadExecutor.runOnUiThread(new Runnable() { // from class: com.datadog.reactnative.DdSdkSessionStartedListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.trySendSessionStartedToJS(str);
            }
        });
    }

    public final void onRnSdkInitialized() {
        isRnSdkInitialized = true;
        final String str = this.lastSessionId;
        if (str == null) {
            return;
        }
        uiThreadExecutor.runOnUiThread(new Runnable() { // from class: com.datadog.reactnative.DdSdkSessionStartedListener$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.trySendSessionStartedToJS(str);
            }
        });
    }

    public final void setConvertToNativeArray(Function1<? super String[], ? extends NativeArray> convertToNativeArray) {
        Intrinsics.checkNotNullParameter(convertToNativeArray, "convertToNativeArray");
        this.convertToNativeArray = convertToNativeArray;
    }

    public final void setExceptionHandler(Function1<? super Exception, Unit> exceptionHandler) {
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        this.exceptionHandler = exceptionHandler;
    }

    public final void setIsNewArchitecture(boolean isNewArch) {
        this.isNewArchitecture = Boolean.valueOf(isNewArch);
    }

    public final void setIsRnSdkInitialized(boolean value) {
        isRnSdkInitialized = value;
    }

    public final void setUiThreadExecutor(UiThreadExecutor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        uiThreadExecutor = executor;
    }

    private final boolean hasValidBridge() {
        CatalystInstance catalystInstance;
        ReactContext reactContext = this.reactContext;
        return (reactContext == null || (catalystInstance = reactContext.getCatalystInstance()) == null || isNewArchitecture() || catalystInstance.isDestroyed() || !reactContext.hasActiveReactInstance() || !isRnSdkInitialized) ? false : true;
    }

    private final boolean isNewArchitecture() {
        Boolean bool = this.isNewArchitecture;
        if (bool != null) {
            return bool.booleanValue();
        }
        this.isNewArchitecture = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trySendSessionStartedToJS(String sessionId) {
        if (hasValidBridge()) {
            sendSessionIdWithBridge(sessionId);
        } else {
            sendSessionIdWithEventEmitter(sessionId);
        }
    }

    private final void sendSessionIdWithBridge(String sessionId) {
        CatalystInstance catalystInstance;
        try {
            String[] strArr = {"RUMSessionStarted", sessionId};
            ReactContext reactContext = this.reactContext;
            if (reactContext == null || (catalystInstance = reactContext.getCatalystInstance()) == null) {
                return;
            }
            catalystInstance.callFunction(BRIDGE_MODULE_NAME, BRIDGE_MODULE_METHOD, buildBridgeArgs(strArr));
        } catch (Exception e) {
            Function1<? super Exception, Unit> function1 = this.exceptionHandler;
            if (function1 != null) {
                function1.invoke(e);
            }
        }
    }

    private final NativeArray buildBridgeArgs(String[] args) {
        Function1<? super String[], ? extends NativeArray> function1 = this.convertToNativeArray;
        if (function1 != null) {
            if (function1 != null) {
                return function1.invoke(args);
            }
            return null;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String str : args) {
            writableNativeArray.pushString(str);
        }
        return writableNativeArray;
    }

    private final void sendSessionIdWithEventEmitter(String sessionId) {
        ReactContext reactContext = this.reactContext;
        if (reactContext == null) {
            return;
        }
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("RUMSessionStarted", sessionId);
        } catch (Exception unused) {
        }
    }
}
