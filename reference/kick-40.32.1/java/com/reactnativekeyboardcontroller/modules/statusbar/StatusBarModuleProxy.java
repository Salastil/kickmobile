package com.reactnativekeyboardcontroller.modules.statusbar;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: StatusBarModuleProxy.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/reactnativekeyboardcontroller/modules/statusbar/StatusBarModuleProxy;", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "instance", "setHiddenMethod", "Ljava/lang/reflect/Method;", "setColorMethod", "setTranslucentMethod", "setStyleMethod", "getConstantsMethod", "setHidden", "", ViewProps.HIDDEN, "", "setColor", "color", "", "animated", "setTranslucent", "translucent", "setStyle", "style", "", "getConstants", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusBarModuleProxy {
    private Method getConstantsMethod;
    private Object instance;
    private Method setColorMethod;
    private Method setHiddenMethod;
    private Method setStyleMethod;
    private Method setTranslucentMethod;

    public StatusBarModuleProxy(ReactApplicationContext reactContext) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        try {
            Class<?> cls = Class.forName("com.facebook.react.modules.statusbar.StatusBarModule");
            this.instance = cls.getConstructor(ReactApplicationContext.class).newInstance(reactContext);
            this.setHiddenMethod = cls.getMethod("setHidden", Boolean.TYPE);
            this.setStyleMethod = cls.getMethod("setStyle", String.class);
            Object obj = null;
            this.getConstantsMethod = cls.getMethod("getConstants", null);
            try {
                Result.Companion companion = Result.INSTANCE;
                StatusBarModuleProxy statusBarModuleProxy = this;
                objM12684constructorimpl = Result.m12684constructorimpl(cls.getMethod("setColor", Double.TYPE, Boolean.TYPE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            this.setColorMethod = (Method) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
            try {
                Result.Companion companion3 = Result.INSTANCE;
                StatusBarModuleProxy statusBarModuleProxy2 = this;
                objM12684constructorimpl2 = Result.m12684constructorimpl(cls.getMethod("setTranslucent", Boolean.TYPE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                obj = objM12684constructorimpl2;
            }
            this.setTranslucentMethod = (Method) obj;
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Failed to initialize StatusBarModule via reflection", e);
        }
    }

    public final void setHidden(boolean hidden) {
        try {
            Method method = this.setHiddenMethod;
            if (method != null) {
                method.invoke(this.instance, Boolean.valueOf(hidden));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setHidden method", e);
        }
    }

    public final void setColor(double color, boolean animated) {
        try {
            Method method = this.setColorMethod;
            if (method != null) {
                method.invoke(this.instance, Double.valueOf(color), Boolean.valueOf(animated));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setColor method", e);
        }
    }

    public final void setTranslucent(boolean translucent) {
        try {
            Method method = this.setTranslucentMethod;
            if (method != null) {
                method.invoke(this.instance, Boolean.valueOf(translucent));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setTranslucent method", e);
        }
    }

    public final void setStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        try {
            Method method = this.setStyleMethod;
            if (method != null) {
                method.invoke(this.instance, style);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setStyle method", e);
        }
    }

    public final Map<String, Object> getConstants() {
        try {
            Method method = this.getConstantsMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, null) : null;
            if (TypeIntrinsics.isMutableMap(objInvoke)) {
                return (Map) objInvoke;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.getConstants method", e);
            return null;
        }
    }
}
