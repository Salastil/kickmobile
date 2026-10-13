package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSFormSheetHostManagerDelegate;
import com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetHostViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001f\u0010'\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020+0*H\u0016J&\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHostViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHost;", "Lcom/facebook/react/viewmanagers/RNSFormSheetHostManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "removeViewAt", "removeAllViews", "getChildCount", "getChildAt", "setIsOpen", "view", "value", "", "setDetents", "Lcom/facebook/react/bridge/ReadableArray;", "setPrefersGrabberVisible", "setPreferredCornerRadius", "", "setLargestUndimmedDetentIndex", "setInitialDetentIndex", "setPrefersScrollingExpandsWhenScrolledToEdge", "setPreventNativeDismiss", "setNativeContainerBackgroundColor", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHost;Ljava/lang/Integer;)V", "getExportedCustomDirectEventTypeConstants", "", "", "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "addEventEmitters", "onDropViewInstance", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ReactModule(name = FormSheetHostViewManager.REACT_CLASS)
public final class FormSheetHostViewManager extends ViewGroupManager<FormSheetHost> implements RNSFormSheetHostManagerInterface<FormSheetHost> {
    public static final String REACT_CLASS = "RNSFormSheetHost";
    private final ViewManagerDelegate<FormSheetHost> delegate;

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setLargestUndimmedDetentIndex(FormSheetHost view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setPrefersScrollingExpandsWhenScrolledToEdge(FormSheetHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setPreventNativeDismiss(FormSheetHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public FormSheetHostViewManager() {
        super(null, 1, null);
        this.delegate = new RNSFormSheetHostManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<FormSheetHost> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public FormSheetHost createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new FormSheetHost(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(FormSheetHost parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        parent.mountReactSubviewAt$react_native_screens_release(child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(FormSheetHost parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        parent.unmountReactSubview$react_native_screens_release(child);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(FormSheetHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountReactSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(FormSheetHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountAllReactSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(FormSheetHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getReactSubviewCount$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(FormSheetHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getReactSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setIsOpen(FormSheetHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOpen$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setDetents(FormSheetHost view, ReadableArray value) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null) {
            int size = value.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(Double.valueOf(value.getDouble(i)));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        view.setDetents$react_native_screens_release(arrayListEmptyList);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setPrefersGrabberVisible(FormSheetHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPrefersGrabberVisible$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setPreferredCornerRadius(FormSheetHost view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreferredCornerRadius$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setInitialDetentIndex(FormSheetHost view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setInitialDetentIndex$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface
    public void setNativeContainerBackgroundColor(FormSheetHost view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeContainerBackgroundColor$react_native_screens_release(value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(FormSheetNativeDismissEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetSyncFlushEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetWillAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetDidAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetWillDisappearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetDidDisappearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(FormSheetDetentChangedEvent.INSTANCE));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(FormSheetHost view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper$react_native_screens_release(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(FormSheetHost view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.onAfterUpdateTransaction$react_native_screens_release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, FormSheetHost view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(FormSheetHost view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy$react_native_screens_release();
        super.onDropViewInstance(view);
    }
}
