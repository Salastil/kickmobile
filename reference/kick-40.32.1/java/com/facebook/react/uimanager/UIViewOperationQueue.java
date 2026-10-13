package com.facebook.react.uimanager;

import android.view.View;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIViewOperationQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 G2\u00020\u0001:\u0002FGB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0004J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005J\u001e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\tJ\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001J(\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\rJ\u001e\u0010-\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020*J\u0016\u00100\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00101\u001a\u000202J&\u00104\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00101\u001a\u000202J\u0016\u00108\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005J\u000e\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\t2\u0006\u0010;\u001a\u00020<J\u001e\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\rJ\r\u0010B\u001a\u00020\tH\u0000¢\u0006\u0002\bCJ\r\u0010D\u001a\u00020\tH\u0000¢\u0006\u0002\bE¨\u0006H"}, d2 = {"Lcom/facebook/react/uimanager/UIViewOperationQueue;", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "minTimeLeftInFrameForNonBatchedOperationMs", "", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;I)V", "profileNextBatch", "", "getProfiledBatchPerfCounters", "", "", "", "isEmpty", "", "addRootView", "tag", "rootView", "Landroid/view/View;", "enqueueUIOperation", "operation", "Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;", "enqueueRemoveRootView", "rootViewTag", "enqueueSetJSResponder", "initialTag", "blockNativeResponder", "enqueueClearJSResponder", "enqueueDispatchCommand", "reactTag", "commandId", "commandArgs", "Lcom/facebook/react/bridge/ReadableArray;", "enqueueUpdateExtraData", "extraData", "enqueueCreateView", "themedContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "viewReactTag", "viewClassName", "initialProps", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "enqueueUpdateInstanceHandle", "instanceHandle", "enqueueUpdateProperties", "className", "props", "enqueueMeasure", "callback", "Lcom/facebook/react/bridge/Callback;", "enqueueMeasureInWindow", "enqueueFindTargetForTouch", "targetX", "", "targetY", "enqueueSendAccessibilityEvent", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "enqueueUIBlock", "block", "Lcom/facebook/react/uimanager/UIBlock;", "prependUIBlock", "dispatchViewUpdates", "batchId", "commitStartTime", "layoutTime", "resumeFrameCallback", "resumeFrameCallback$ReactAndroid", "pauseFrameCallback", "pauseFrameCallback$ReactAndroid", "UIOperation", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UIViewOperationQueue {
    public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;

    /* JADX INFO: compiled from: UIViewOperationQueue.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;", "", "execute", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface UIOperation {
        void execute();
    }

    public final void addRootView(int tag, View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    public final void dispatchViewUpdates(int batchId, long commitStartTime, long layoutTime) {
    }

    public final void enqueueClearJSResponder() {
    }

    public final void enqueueCreateView(ThemedReactContext themedContext, int viewReactTag, String viewClassName, ReactStylesDiffMap initialProps) {
        Intrinsics.checkNotNullParameter(themedContext, "themedContext");
        Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
    }

    @Deprecated(message = "Use enqueueDispatchCommand with a String commandId instead")
    public final void enqueueDispatchCommand(int reactTag, int commandId, ReadableArray commandArgs) {
    }

    public final void enqueueDispatchCommand(int reactTag, String commandId, ReadableArray commandArgs) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
    }

    public final void enqueueFindTargetForTouch(int reactTag, float targetX, float targetY, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void enqueueMeasure(int reactTag, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void enqueueMeasureInWindow(int reactTag, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void enqueueRemoveRootView(int rootViewTag) {
    }

    public final void enqueueSendAccessibilityEvent(int tag, int eventType) {
    }

    public final void enqueueSetJSResponder(int tag, int initialTag, boolean blockNativeResponder) {
    }

    public final void enqueueUIBlock(UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    protected final void enqueueUIOperation(UIOperation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
    }

    public final void enqueueUpdateExtraData(int reactTag, Object extraData) {
    }

    public final void enqueueUpdateInstanceHandle(int reactTag, long instanceHandle) {
    }

    public final void enqueueUpdateProperties(int reactTag, String className, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(props, "props");
    }

    public final boolean isEmpty() {
        return true;
    }

    public final void pauseFrameCallback$ReactAndroid() {
    }

    public final void prependUIBlock(UIBlock block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    public final void profileNextBatch() {
    }

    public final void resumeFrameCallback$ReactAndroid() {
    }

    public UIViewOperationQueue(ReactApplicationContext reactContext, int i) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("UIViewOperationQueue", LegacyArchitectureLogLevel.ERROR);
    }

    public final Map<String, Long> getProfiledBatchPerfCounters() {
        return new HashMap();
    }
}
