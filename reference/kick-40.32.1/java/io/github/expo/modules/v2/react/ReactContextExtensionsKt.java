package io.github.expo.modules.v2.react;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;
import io.github.expo.modules.v2.ExpoContext;
import io.github.expo.modules.v2.ExpoObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactContextExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lio/github/expo/modules/v2/ExpoObject;", "getReactContext", "(Lio/github/expo/modules/v2/ExpoObject;)Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContextOrNull", "getReactContextOrNull", "androidContext", "Landroid/content/Context;", "getAndroidContext", "(Lio/github/expo/modules/v2/ExpoObject;)Landroid/content/Context;", "androidContextOrNull", "getAndroidContextOrNull", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "(Lio/github/expo/modules/v2/ExpoObject;)Landroid/app/Activity;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReactContextExtensionsKt {
    public static final ReactApplicationContext getReactContext(ExpoObject expoObject) {
        ReactApplicationContext reactContext;
        Intrinsics.checkNotNullParameter(expoObject, "<this>");
        ExpoContext context = expoObject.getContext();
        ReactExpoContext reactExpoContext = context instanceof ReactExpoContext ? (ReactExpoContext) context : null;
        if (reactExpoContext != null && (reactContext = reactExpoContext.getReactContext()) != null) {
            return reactContext;
        }
        throw new IllegalStateException((expoObject.getClass().getName() + " belongs to a " + context.getClass().getName() + ", which has no ReactApplicationContext").toString());
    }

    public static final ReactApplicationContext getReactContextOrNull(ExpoObject expoObject) {
        Intrinsics.checkNotNullParameter(expoObject, "<this>");
        ExpoContext contextOrNull = expoObject.getContextOrNull();
        ReactExpoContext reactExpoContext = contextOrNull instanceof ReactExpoContext ? (ReactExpoContext) contextOrNull : null;
        if (reactExpoContext != null) {
            return reactExpoContext.getReactContext();
        }
        return null;
    }

    public static final Context getAndroidContext(ExpoObject expoObject) {
        Intrinsics.checkNotNullParameter(expoObject, "<this>");
        return getReactContext(expoObject);
    }

    public static final Context getAndroidContextOrNull(ExpoObject expoObject) {
        Intrinsics.checkNotNullParameter(expoObject, "<this>");
        return getReactContextOrNull(expoObject);
    }

    public static final Activity getCurrentActivity(ExpoObject expoObject) {
        Intrinsics.checkNotNullParameter(expoObject, "<this>");
        ReactApplicationContext reactContextOrNull = getReactContextOrNull(expoObject);
        if (reactContextOrNull != null) {
            return reactContextOrNull.getCurrentActivity();
        }
        return null;
    }
}
