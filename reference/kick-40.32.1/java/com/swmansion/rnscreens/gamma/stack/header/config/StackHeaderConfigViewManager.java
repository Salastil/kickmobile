package com.swmansion.rnscreens.gamma.stack.header.config;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementRawUpdate;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuItemIconSource;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuMapper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderConfigViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = StackHeaderConfigViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001>B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u001a\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u001f\u0010,\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010-J\u001f\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010-J\u001a\u00100\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u00101\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00105\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00106\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0018\u00109\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010<\u001a\u00020=H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "Lcom/facebook/react/viewmanagers/RNSStackHeaderConfigAndroidManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "addEventEmitters", "", "view", "getDelegate", "needsCustomLayoutForChildren", "", "addView", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "removeViewAt", "removeAllViews", "getChildCount", "getChildAt", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "onDropViewInstance", "setType", "value", "setTitle", "setHidden", "setTransparent", "setBackButtonHidden", "setBackButtonTintColorNormal", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;Ljava/lang/Integer;)V", "setBackButtonTintColorPressed", "setBackButtonTintColorFocused", "setBackButtonDrawableIconResourceName", "setBackButtonImageIconResource", "Lcom/facebook/react/bridge/ReadableMap;", "setScrollFlagScroll", "setScrollFlagEnterAlways", "setScrollFlagEnterAlwaysCollapsed", "setScrollFlagExitUntilCollapsed", "setScrollFlagSnap", "setToolbarMenuGroupDividerEnabled", "setToolbarMenu", "Lcom/facebook/react/bridge/Dynamic;", "updateToolbarMenuElements", "updates", "Lcom/facebook/react/bridge/ReadableArray;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StackHeaderConfigViewManager extends ViewGroupManager<StackHeaderConfig> implements RNSStackHeaderConfigAndroidManagerInterface<StackHeaderConfig> {
    public static final String REACT_CLASS = "RNSStackHeaderConfigAndroid";
    private static final String TAG = "StackHeaderConfigViewManager";
    private final ViewManagerDelegate<StackHeaderConfig> delegate;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public StackHeaderConfigViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackHeaderConfigAndroidManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackHeaderConfig createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackHeaderConfig(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, StackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<StackHeaderConfig> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(StackHeaderConfig parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof StackHeaderSubview)) {
            throw new IllegalArgumentException(("[RNScreens] StackHeaderConfig can only have children of type StackHeaderSubview. Received " + child + " instead.").toString());
        }
        parent.addConfigSubview$react_native_screens_release((StackHeaderSubview) child);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(StackHeaderConfig parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof StackHeaderSubview)) {
            throw new IllegalArgumentException(("[RNScreens] StackHeaderConfig can only have children of type StackHeaderSubview. Attempted to remove " + view + " instead.").toString());
        }
        parent.removeConfigSubview$react_native_screens_release((StackHeaderSubview) view);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(StackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeConfigSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(StackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeAllConfigSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(StackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewsCount$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(StackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(StackHeaderConfig view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper$react_native_screens_release(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(StackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.resolveBackButtonIconIfNeeded$react_native_screens_release();
        view.resolveToolbarMenuItemIconsIfNeeded$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(StackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.tearDown$react_native_screens_release();
        super.onDropViewInstance(view);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setType(StackHeaderConfig view, String value) {
        StackHeaderType stackHeaderType;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null) {
            int iHashCode = value.hashCode();
            if (iHashCode != -1078030475) {
                if (iHashCode != 102742843) {
                    if (iHashCode == 109548807 && value.equals("small")) {
                        stackHeaderType = StackHeaderType.SMALL;
                        view.setType$react_native_screens_release(stackHeaderType);
                        return;
                    }
                } else if (value.equals("large")) {
                    stackHeaderType = StackHeaderType.LARGE;
                    view.setType$react_native_screens_release(stackHeaderType);
                    return;
                }
            } else if (value.equals("medium")) {
                stackHeaderType = StackHeaderType.MEDIUM;
                view.setType$react_native_screens_release(stackHeaderType);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid StackHeaderConfig type: " + value + ".");
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setTitle(StackHeaderConfig view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null) {
            value = "";
        }
        view.setTitle$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setHidden(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHidden$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setTransparent(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTransparent$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonHidden(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonHidden$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonTintColorNormal(StackHeaderConfig view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonTintColorNormal$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonTintColorPressed(StackHeaderConfig view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonTintColorPressed$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonTintColorFocused(StackHeaderConfig view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonTintColorFocused$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonDrawableIconResourceName(StackHeaderConfig view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonDrawableIconResourceName$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonImageIconResource(StackHeaderConfig view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonImageIconUri$react_native_screens_release(value != null ? value.getString("uri") : null);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagScroll(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagScroll$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagEnterAlways(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagEnterAlways$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagEnterAlwaysCollapsed(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagEnterAlwaysCollapsed$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagExitUntilCollapsed(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagExitUntilCollapsed$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagSnap(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagSnap$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setToolbarMenuGroupDividerEnabled(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setToolbarMenuGroupDividerEnabled$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setToolbarMenu(StackHeaderConfig view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        StackHeaderToolbarMenuMapper stackHeaderToolbarMenuMapper = StackHeaderToolbarMenuMapper.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Pair<StackHeaderToolbarMenuConfig, Map<String, StackHeaderToolbarMenuItemIconSource>> menu = stackHeaderToolbarMenuMapper.parseMenu(context, value);
        StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfigComponent1 = menu.component1();
        Map<String, StackHeaderToolbarMenuItemIconSource> mapComponent2 = menu.component2();
        view.setToolbarMenu$react_native_screens_release(stackHeaderToolbarMenuConfigComponent1);
        view.setToolbarMenuItemIconSourceMap$react_native_screens_release(mapComponent2);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void updateToolbarMenuElements(StackHeaderConfig view, ReadableArray updates) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(updates, "updates");
        ArrayList arrayList = new ArrayList(updates.size());
        int size = updates.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = updates.getMap(i);
            if (map == null) {
                Log.w(TAG, "[RNScreens] Skipping toolbar menu update at index " + i + ": not an object.");
            } else {
                String string = map.getString("id");
                if (string == null) {
                    Log.w(TAG, "[RNScreens] Skipping toolbar menu update at index " + i + ": missing 'id'.");
                } else {
                    StackHeaderToolbarMenuMapper stackHeaderToolbarMenuMapper = StackHeaderToolbarMenuMapper.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    arrayList.add(new StackHeaderToolbarMenuElementRawUpdate(string, stackHeaderToolbarMenuMapper.parseMenuElementOptions(context, map), StackHeaderToolbarMenuMapper.INSTANCE.parseMenuElementIconSource(map)));
                }
            }
        }
        view.dispatchMenuElementUpdates$react_native_screens_release(arrayList);
    }
}
