package com.facebook.react.uimanager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIManagerHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/uimanager/UIManagerHelper;", "", "<init>", "()V", "TAG", "", "PADDING_START_INDEX", "", "PADDING_END_INDEX", "PADDING_TOP_INDEX", "PADDING_BOTTOM_INDEX", "getUIManagerForReactTag", "Lcom/facebook/react/bridge/UIManager;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactContext;", "reactTag", "getUIManager", "uiManagerType", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcherForReactTag", "getReactContext", "view", "Landroid/view/View;", "getSurfaceId", "Landroid/content/Context;", "getDefaultTextInputPadding", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UIManagerHelper {
    public static final UIManagerHelper INSTANCE = new UIManagerHelper();
    public static final int PADDING_BOTTOM_INDEX = 3;
    public static final int PADDING_END_INDEX = 1;
    public static final int PADDING_START_INDEX = 0;
    public static final int PADDING_TOP_INDEX = 2;
    private static final String TAG = "UIManagerHelper";

    private UIManagerHelper() {
    }

    @JvmStatic
    public static final UIManager getUIManagerForReactTag(ReactContext context, int reactTag) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getUIManager(context, 2);
    }

    @JvmStatic
    public static final UIManager getUIManager(ReactContext context, int uiManagerType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!context.hasActiveReactInstance()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active React instance."));
            return null;
        }
        UIManager fabricUIManager = context.getFabricUIManager();
        if (fabricUIManager == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get UIManager because the instance hasn't been initialized yet."));
        }
        return fabricUIManager;
    }

    @JvmStatic
    public static final EventDispatcher getEventDispatcher(ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = context instanceof ThemedReactContext;
        Object reactApplicationContext = context;
        if (z) {
            reactApplicationContext = ((ThemedReactContext) context).getReactApplicationContext();
        }
        Intrinsics.checkNotNull(reactApplicationContext, "null cannot be cast to non-null type com.facebook.react.uimanager.events.EventDispatcherProvider");
        return ((EventDispatcherProvider) reactApplicationContext).getEventDispatcher();
    }

    @Deprecated(message = "reactTag is no longer needed", replaceWith = @ReplaceWith(expression = "getEventDispatcher(context)", imports = {}))
    @JvmStatic
    public static final EventDispatcher getEventDispatcherForReactTag(ReactContext context, int reactTag) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getEventDispatcher(context);
    }

    @Deprecated(message = "UIManagerType is no longer needed", replaceWith = @ReplaceWith(expression = "getEventDispatcher(context)", imports = {}))
    @JvmStatic
    public static final EventDispatcher getEventDispatcher(ReactContext context, int uiManagerType) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getEventDispatcher(context);
    }

    @JvmStatic
    public static final ReactContext getReactContext(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        return (ReactContext) context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final int getSurfaceId(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ReactRoot) {
            return ((ReactRoot) view).getRootViewTag();
        }
        Context context = view.getContext();
        if (!(context instanceof ThemedReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        int surfaceId = getSurfaceId(context);
        if (surfaceId == -1) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Fabric View [" + view.getId() + "] does not have SurfaceId associated with it"));
        }
        return surfaceId;
    }

    @JvmStatic
    public static final int getSurfaceId(Context context) {
        if (context instanceof ThemedReactContext) {
            return ((ThemedReactContext) context).getSurfaceId();
        }
        return -1;
    }

    @JvmStatic
    public static final float[] getDefaultTextInputPadding(Context context) {
        EditText editText = new EditText(context);
        EditText editText2 = editText;
        return new float[]{PixelUtil.toDIPFromPixel(ViewCompat.getPaddingStart(editText2)), PixelUtil.toDIPFromPixel(ViewCompat.getPaddingEnd(editText2)), PixelUtil.toDIPFromPixel(editText.getPaddingTop()), PixelUtil.toDIPFromPixel(editText.getPaddingBottom())};
    }
}
