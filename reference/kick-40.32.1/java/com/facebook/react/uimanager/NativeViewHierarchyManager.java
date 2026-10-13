package com.facebook.react.uimanager;

import android.view.View;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.yoga.YogaDirection;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeViewHierarchyManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\f\b\u0017\u0018\u0000 N2\u00020\u0001:\u0001NB\u0011\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0017J0\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0017J@\u0010\u001b\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\fH\u0017J*\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0017J;\u0010+\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010-H\u0011¢\u0006\u0004\b2\u00103J\u001a\u00104\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u000106H\u0017J\u0018\u00107\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00108\u001a\u00020\nH\u0017J\u0018\u00109\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00108\u001a\u00020\nH\u0005J\u0010\u0010:\u001a\u00020\u00102\u0006\u00108\u001a\u00020\nH\u0015J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\fH\u0017J\b\u0010=\u001a\u00020\fH\u0017J\u0018\u0010>\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010?\u001a\u00020-H\u0017J\u0018\u0010@\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010?\u001a\u00020-H\u0017J \u0010A\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0017J \u0010E\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u0012H\u0017J\b\u0010H\u001a\u00020\u0010H\u0017J\"\u0010I\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f2\b\u0010K\u001a\u0004\u0018\u000106H\u0017J\"\u0010I\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\f2\u0006\u0010J\u001a\u00020)2\b\u0010K\u001a\u0004\u0018\u000106H\u0017J\u0018\u0010L\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010M\u001a\u00020\fH\u0017¨\u0006O"}, d2 = {"Lcom/facebook/react/uimanager/NativeViewHierarchyManager;", "", "viewManagers", "Lcom/facebook/react/uimanager/ViewManagerRegistry;", "<init>", "(Lcom/facebook/react/uimanager/ViewManagerRegistry;)V", "manager", "Lcom/facebook/react/uimanager/RootViewManager;", "(Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/uimanager/RootViewManager;)V", "resolveView", "Landroid/view/View;", "tag", "", "resolveViewManager", "Lcom/facebook/react/uimanager/ViewManager;", "setLayoutAnimationEnabled", "", "enabled", "", "updateInstanceHandle", "instanceHandle", "", "updateProperties", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "updateViewExtraData", "extraData", "updateLayout", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, ViewProps.WIDTH, ViewProps.HEIGHT, "parentTag", ViewProps.LAYOUT_DIRECTION, "Lcom/facebook/yoga/YogaDirection;", "getInstanceHandle", "reactTag", "createView", "themedContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "className", "", "initialProps", "manageChildren", "indicesToRemove", "", "viewsToAdd", "", "Lcom/facebook/react/uimanager/ViewAtIndex;", "tagsToDelete", "manageChildren$ReactAndroid", "(I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V", "setChildren", "childrenTags", "Lcom/facebook/react/bridge/ReadableArray;", "addRootView", "view", "addRootViewGroup", "dropView", "removeRootView", "rootViewTag", "getRootViewNum", "measure", "outputBuffer", "measureInWindow", "findTargetTagForTouch", "touchX", "", "touchY", "setJSResponder", "initialReactTag", "blockNativeResponder", "clearJSResponder", "dispatchCommand", "commandId", "args", "sendAccessibilityEvent", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NativeViewHierarchyManager {
    @Deprecated(message = "Use new architecture instead.")
    public void setLayoutAnimationEnabled(boolean enabled) {
    }

    @Deprecated(message = "Please use updateLayout with YogaDirection parameter instead.")
    public void updateLayout(int tag, int x, int y, int width, int height) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public NativeViewHierarchyManager(ViewManagerRegistry viewManagers) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
    }

    @Deprecated(message = "Use new architecture instead.")
    public NativeViewHierarchyManager(ViewManagerRegistry viewManagers, RootViewManager manager) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
        Intrinsics.checkNotNullParameter(manager, "manager");
    }

    @Deprecated(message = "Use new architecture instead.")
    public final synchronized View resolveView(int tag) {
        return null;
    }

    @Deprecated(message = "Use new architecture instead.")
    public final synchronized ViewManager<?, ?> resolveViewManager(int tag) {
        return null;
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void updateInstanceHandle(int tag, long instanceHandle) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void updateProperties(int tag, ReactStylesDiffMap props) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void updateViewExtraData(int tag, Object extraData) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void updateLayout(int parentTag, int tag, int x, int y, int width, int height, YogaDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized long getInstanceHandle(int reactTag) {
        return 0L;
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void createView(ThemedReactContext themedContext, int tag, String className, ReactStylesDiffMap initialProps) {
        Intrinsics.checkNotNullParameter(themedContext, "themedContext");
        Intrinsics.checkNotNullParameter(className, "className");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void manageChildren$ReactAndroid(int tag, int[] indicesToRemove, ViewAtIndex[] viewsToAdd, int[] tagsToDelete) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void setChildren(int tag, ReadableArray childrenTags) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void addRootView(int tag, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Deprecated(message = "Use new architecture instead.")
    protected final synchronized void addRootViewGroup(int tag, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Deprecated(message = "Use new architecture instead.")
    protected synchronized void dropView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void removeRootView(int rootViewTag) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized int getRootViewNum() {
        return 0;
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void measure(int tag, int[] outputBuffer) {
        Intrinsics.checkNotNullParameter(outputBuffer, "outputBuffer");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void measureInWindow(int tag, int[] outputBuffer) {
        Intrinsics.checkNotNullParameter(outputBuffer, "outputBuffer");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized int findTargetTagForTouch(int reactTag, float touchX, float touchY) {
        return 0;
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void setJSResponder(int reactTag, int initialReactTag, boolean blockNativeResponder) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void clearJSResponder() {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void dispatchCommand(int reactTag, int commandId, ReadableArray args) {
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void dispatchCommand(int reactTag, String commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
    }

    @Deprecated(message = "Use new architecture instead.")
    public synchronized void sendAccessibilityEvent(int tag, int eventType) {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("NativeViewHierarchyManager", LegacyArchitectureLogLevel.ERROR);
    }
}
