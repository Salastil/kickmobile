package com.swmansion.gesturehandler.react;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerDetectorViewManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@ReactModule(name = RNGestureHandlerDetectorViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;", "Lcom/facebook/react/viewmanagers/RNGestureHandlerDetectorManagerInterface;", "<init>", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setHandlerTags", "", "view", "value", "Lcom/facebook/react/bridge/ReadableArray;", "setModuleId", "", "setVirtualChildren", "onDropViewInstance", "setPointerEvents", "pointerEventsStr", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerDetectorViewManager extends ViewGroupManager<RNGestureHandlerDetectorView> implements RNGestureHandlerDetectorManagerInterface<RNGestureHandlerDetectorView> {
    public static final String REACT_CLASS = "RNGestureHandlerDetector";
    private final ViewManagerDelegate<RNGestureHandlerDetectorView> mDelegate;

    public RNGestureHandlerDetectorViewManager() {
        super(null, 1, null);
        this.mDelegate = new RNGestureHandlerDetectorManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<RNGestureHandlerDetectorView> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RNGestureHandlerDetectorView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new RNGestureHandlerDetectorView(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerInterface
    public void setHandlerTags(RNGestureHandlerDetectorView view, ReadableArray value) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHandlerTags(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerInterface
    public void setModuleId(RNGestureHandlerDetectorView view, int value) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setModuleId(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerInterface
    public void setVirtualChildren(RNGestureHandlerDetectorView view, ReadableArray value) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVirtualChildren(value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(RNGestureHandlerDetectorView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.detachAllHandlers();
        super.onDropViewInstance(view);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerDetectorManagerInterface
    public void setPointerEvents(RNGestureHandlerDetectorView view, String pointerEventsStr) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPointerEvents(PointerEvents.INSTANCE.parsePointerEvents(pointerEventsStr));
    }
}
