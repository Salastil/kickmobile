package com.facebook.react.fabric.mounting;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.SparseArrayCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IViewGroupManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.systrace.Systrace;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SurfaceMountingManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u0087\u00012\u00020\u0001:\u0006\u0085\u0001\u0086\u0001\u0087\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\rH\u0007J\u000e\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0003J\u0015\u00105\u001a\u0002002\u0006\u00106\u001a\u00020!H\u0001¢\u0006\u0002\b7J\b\u00108\u001a\u000200H\u0003J\b\u00109\u001a\u000200H\u0007J \u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0003H\u0007J \u0010=\u001a\u0002002\u0006\u00104\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0003H\u0007JA\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u0013H\u0001¢\u0006\u0002\bHJ<\u0010I\u001a\u0002002\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u0013H\u0003J\u0016\u0010J\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BJ\u0016\u0010K\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BJ\u0016\u0010L\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BJ \u0010L\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\u0006\u0010M\u001a\u00020\u0013H\u0003J\"\u0010N\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020.2\b\u0010O\u001a\u0004\u0018\u00010PH\u0007J\"\u0010Q\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\b\u0010S\u001a\u0004\u0018\u00010TH\u0007J \u0010Q\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010R\u001a\u00020.2\b\u0010S\u001a\u0004\u0018\u00010TJ\u0016\u0010U\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u0003JH\u0010W\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u0003H\u0007J0\u0010^\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u0003H\u0007J0\u0010c\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0003H\u0007J\u001a\u0010h\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001d\u0010i\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010j\u001a\u00020FH\u0001¢\u0006\u0002\bkJ \u0010l\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\u0013H\u0007J\u0010\u0010o\u001a\u0002002\u0006\u0010p\u001a\u00020\u001cH\u0003J\u0010\u0010q\u001a\u0002002\u0006\u0010@\u001a\u00020\u0003H\u0007J2\u0010r\u001a\u0002002\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010G\u001a\u00020\u0013H\u0007J\u0017\u0010s\u001a\u0004\u0018\u00010F2\u0006\u0010@\u001a\u00020\u0003H\u0001¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0003H\u0007J\u0012\u0010v\u001a\u0004\u0018\u00010\u001c2\u0006\u0010@\u001a\u00020\u0003H\u0002J\u0018\u0010w\u001a\u0002002\u0006\u00104\u001a\u00020\u00032\u0006\u0010x\u001a\u00020yH\u0007J\u0006\u0010z\u001a\u000200JB\u0010{\u001a\u0002002\u0006\u0010@\u001a\u00020\u00032\u0006\u0010|\u001a\u00020.2\u0006\u0010}\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010~2\u0006\u0010\u007f\u001a\u00020\u00032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0001¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u0002002\u0006\u0010@\u001a\u00020\u0003J\u000f\u0010\u0084\u0001\u001a\u0002002\u0006\u0010@\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0002\b\u0003\u0018\u00010\"X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b$\u0010%R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010-0+8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/facebook/react/fabric/mounting/SurfaceMountingManager;", "", "surfaceId", "", "jsResponderHandler", "Lcom/facebook/react/touch/JSResponderHandler;", "viewManagerRegistry", "Lcom/facebook/react/uimanager/ViewManagerRegistry;", "rootViewManager", "Lcom/facebook/react/uimanager/RootViewManager;", "mountItemExecutor", "Lcom/facebook/react/fabric/mounting/MountingManager$MountItemExecutor;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(ILcom/facebook/react/touch/JSResponderHandler;Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/uimanager/RootViewManager;Lcom/facebook/react/fabric/mounting/MountingManager$MountItemExecutor;Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getSurfaceId", "()I", "value", "", "isStopped", "()Z", "isRootViewAttached", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "getContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "tagToViewState", "Landroidx/collection/MutableIntObjectMap;", "Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$ViewState;", "registryLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "onViewAttachMountItems", "Ljava/util/Queue;", "Lcom/facebook/react/fabric/mounting/mountitems/MountItem;", "Lcom/facebook/react/uimanager/ViewManager;", "Landroid/view/View;", "getRootViewManager$annotations", "()V", "erroneouslyReaddedReactTags", "", "viewsWithActiveTouches", "viewsToDeleteAfterTouchFinishes", "tagSetForStoppedSurface", "Landroidx/collection/SparseArrayCompat;", "tagToSynchronousMountProps", "", "", "attachRootView", "", "rootView", "themedReactContext", "getViewExists", "tag", "scheduleMountItemOnViewAttach", "item", "scheduleMountItemOnViewAttach$ReactAndroid", "executeMountItemsOnViewAttach", "stopSurface", "addViewAt", "parentTag", FirebaseAnalytics.Param.INDEX, "removeViewAt", "createView", "componentName", "reactTag", "props", "Lcom/facebook/react/bridge/ReadableMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "eventEmitterWrapper", "Lcom/facebook/react/fabric/events/EventEmitterWrapper;", "isLayoutable", "createView$ReactAndroid", "createViewUnsafe", "storeSynchronousMountPropsOverride", "updatePropsSynchronously", "updateProps", "shouldSkipSynchronousMountPropsOverride", "experimental_prefetchResources", "params", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "receiveCommand", "commandId", "commandArgs", "Lcom/facebook/react/bridge/ReadableArray;", "sendAccessibilityEvent", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "updateLayout", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, ViewProps.WIDTH, ViewProps.HEIGHT, "displayType", ViewProps.LAYOUT_DIRECTION, "updatePadding", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "updateOverflowInset", "overflowInsetLeft", "overflowInsetTop", "overflowInsetRight", "overflowInsetBottom", "updateState", "updateEventEmitter", "eventEmitter", "updateEventEmitter$ReactAndroid", "setJSResponder", "initialReactTag", "blockNativeResponder", "onViewStateDeleted", "viewState", "deleteView", "preallocateView", "getEventEmitter", "getEventEmitter$ReactAndroid", "getView", "getNullableViewState", "applyViewSnapshot", "bitmap", "Landroid/graphics/Bitmap;", "printSurfaceState", "dispatchEvent", "eventName", "canCoalesceEvent", "Lcom/facebook/react/bridge/WritableMap;", "eventCategory", "eventTimestamp", "", "dispatchEvent$ReactAndroid", "markActiveTouchForTag", "sweepActiveTouchForTag", "ViewState", "PendingViewEvent", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SurfaceMountingManager {
    private static final Companion Companion = new Companion(null);
    private static final String PROP_OPACITY = "opacity";
    private static final String PROP_TRANSFORM = "transform";
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES;
    private static final String TAG;
    private ThemedReactContext context;
    private final Set<Integer> erroneouslyReaddedReactTags;
    private volatile boolean isRootViewAttached;
    private volatile boolean isStopped;
    private JSResponderHandler jsResponderHandler;
    private MountingManager.MountItemExecutor mountItemExecutor;
    private final Queue<MountItem> onViewAttachMountItems;
    private final ReentrantReadWriteLock registryLock;
    private ViewManager<View, ?> rootViewManager;
    private final int surfaceId;
    private SparseArrayCompat<Object> tagSetForStoppedSurface;
    private final SparseArrayCompat<Map<String, Object>> tagToSynchronousMountProps;
    private final MutableIntObjectMap<ViewState> tagToViewState;
    private final ViewManagerRegistry viewManagerRegistry;
    private final Set<Integer> viewsToDeleteAfterTouchFinishes;
    private final Set<Integer> viewsWithActiveTouches;

    private static /* synthetic */ void getRootViewManager$annotations() {
    }

    public SurfaceMountingManager(int i, JSResponderHandler jsResponderHandler, ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager, MountingManager.MountItemExecutor mountItemExecutor, ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(jsResponderHandler, "jsResponderHandler");
        Intrinsics.checkNotNullParameter(viewManagerRegistry, "viewManagerRegistry");
        Intrinsics.checkNotNullParameter(rootViewManager, "rootViewManager");
        Intrinsics.checkNotNullParameter(mountItemExecutor, "mountItemExecutor");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.surfaceId = i;
        this.context = reactContext;
        this.tagToViewState = new MutableIntObjectMap<>(0, 1, null);
        this.registryLock = new ReentrantReadWriteLock();
        this.onViewAttachMountItems = new ArrayDeque();
        this.jsResponderHandler = jsResponderHandler;
        this.viewManagerRegistry = viewManagerRegistry;
        this.rootViewManager = rootViewManager;
        this.mountItemExecutor = mountItemExecutor;
        this.erroneouslyReaddedReactTags = new HashSet();
        this.viewsWithActiveTouches = new HashSet();
        this.viewsToDeleteAfterTouchFinishes = new HashSet();
        this.tagToSynchronousMountProps = new SparseArrayCompat<>(0, 1, null);
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    /* JADX INFO: renamed from: isStopped, reason: from getter */
    public final boolean getIsStopped() {
        return this.isStopped;
    }

    /* JADX INFO: renamed from: isRootViewAttached, reason: from getter */
    public final boolean getIsRootViewAttached() {
        return this.isRootViewAttached;
    }

    public final ThemedReactContext getContext() {
        return this.context;
    }

    public final void attachRootView(final View rootView, ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(themedReactContext, "themedReactContext");
        this.context = themedReactContext;
        if (this.isStopped) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to attach root view to a stopped surface"));
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.registryLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.tagToViewState.set(this.surfaceId, new ViewState(this.surfaceId, rootView, this.rootViewManager, true));
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            final ThemedReactContext themedReactContext2 = this.context;
            if (themedReactContext2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            GuardedRunnable guardedRunnable = new GuardedRunnable(rootView, themedReactContext2) { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager$attachRootView$runnable$1
                final /* synthetic */ View $rootView;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(themedReactContext2);
                }

                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    if (this.this$0.getIsStopped()) {
                        return;
                    }
                    if (this.$rootView.getId() == this.this$0.getSurfaceId()) {
                        ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, new IllegalViewOperationException("Race condition in addRootView detected. Trying to set an id of [" + this.this$0.getSurfaceId() + "] on the RootView, but that id has already been set. "));
                    } else if (this.$rootView.getId() != -1) {
                        FLog.e(SurfaceMountingManager.TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [" + this.$rootView.getId() + "] new tag: [" + this.this$0.getSurfaceId() + "]");
                        ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView."));
                    }
                    this.$rootView.setId(this.this$0.getSurfaceId());
                    KeyEvent.Callback callback = this.$rootView;
                    if (callback instanceof ReactRoot) {
                        ((ReactRoot) callback).setRootViewTag(this.this$0.getSurfaceId());
                    }
                    this.this$0.executeMountItemsOnViewAttach();
                    this.this$0.isRootViewAttached = true;
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                guardedRunnable.run();
            } else {
                UiThreadUtil.runOnUiThread(guardedRunnable);
            }
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final boolean getViewExists(int tag) {
        SparseArrayCompat<Object> sparseArrayCompat = this.tagSetForStoppedSurface;
        if (sparseArrayCompat != null && sparseArrayCompat.containsKey(tag)) {
            return true;
        }
        ReentrantReadWriteLock.ReadLock lock = this.registryLock.readLock();
        lock.lock();
        try {
            return this.tagToViewState.containsKey(tag);
        } finally {
            lock.unlock();
        }
    }

    public final void scheduleMountItemOnViewAttach$ReactAndroid(MountItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.onViewAttachMountItems.add(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeMountItemsOnViewAttach() {
        MountingManager.MountItemExecutor mountItemExecutor = this.mountItemExecutor;
        if (mountItemExecutor == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        mountItemExecutor.executeItems(this.onViewAttachMountItems);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0087 A[Catch: all -> 0x00a2, LOOP:0: B:9:0x003a->B:25:0x0087, LOOP_END, TryCatch #0 {all -> 0x00a2, blocks: (B:6:0x002b, B:9:0x003a, B:11:0x004a, B:13:0x0056, B:15:0x005f, B:17:0x006c, B:18:0x006f, B:20:0x0079, B:21:0x007c, B:22:0x007f, B:25:0x0087, B:26:0x008a), top: B:36:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008a A[EDGE_INSN: B:39:0x008a->B:26:0x008a BREAK  A[LOOP:0: B:9:0x003a->B:25:0x0087], SYNTHETIC] */
    public final void stopSurface() {
        FLog.e(TAG, "Stopping surface [" + this.surfaceId + "]");
        if (this.isStopped) {
            return;
        }
        this.isStopped = true;
        ReentrantReadWriteLock.ReadLock lock = this.registryLock.readLock();
        lock.lock();
        try {
            MutableIntObjectMap<ViewState> mutableIntObjectMap = this.tagToViewState;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ViewState viewState = (ViewState) objArr[(i << 3) + i3];
                                StateWrapper stateWrapper = viewState.getStateWrapper();
                                if (stateWrapper != null) {
                                    stateWrapper.destroyState();
                                }
                                viewState.setStateWrapper(null);
                                EventEmitterWrapper eventEmitter = viewState.getEventEmitter();
                                if (eventEmitter != null) {
                                    eventEmitter.destroy();
                                }
                                viewState.setEventEmitter(null);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            Runnable runnable = new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    SurfaceMountingManager.stopSurface$lambda$7(this.f$0);
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                runnable.run();
            } else {
                UiThreadUtil.runOnUiThread(runnable);
            }
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6 A[Catch: all -> 0x010e, LOOP:1: B:18:0x0058->B:31:0x00a6, LOOP_END, TryCatch #1 {all -> 0x010e, blocks: (B:26:0x0087, B:28:0x009a, B:33:0x00af, B:31:0x00a6), top: B:54:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00af A[EDGE_INSN: B:58:0x00af->B:33:0x00af BREAK  A[LOOP:1: B:18:0x0058->B:31:0x00a6], SYNTHETIC] */
    static final void stopSurface$lambda$7(SurfaceMountingManager surfaceMountingManager) throws Throwable {
        ReentrantReadWriteLock.WriteLock writeLock;
        ViewManagerRegistry viewManagerRegistry;
        if (ReactNativeFeatureFlags.enableViewRecycling() && (viewManagerRegistry = surfaceMountingManager.viewManagerRegistry) != null) {
            viewManagerRegistry.onSurfaceStopped(surfaceMountingManager.surfaceId);
        }
        SparseArrayCompat<Object> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
        surfaceMountingManager.tagSetForStoppedSurface = sparseArrayCompat;
        ReentrantReadWriteLock reentrantReadWriteLock = surfaceMountingManager.registryLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i = 0; i < readHoldCount; i++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock.writeLock();
        writeLock2.lock();
        try {
            ArrayList arrayList = new ArrayList(surfaceMountingManager.tagToViewState.get_size());
            MutableIntObjectMap<ViewState> mutableIntObjectMap = surfaceMountingManager.tagToViewState;
            int[] iArr = mutableIntObjectMap.keys;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    writeLock = writeLock2;
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                int i6 = (i2 << 3) + i5;
                                try {
                                    int i7 = iArr[i6];
                                    ViewState viewState = (ViewState) objArr[i6];
                                    SurfaceMountingManagerKt.set(sparseArrayCompat, i7, surfaceMountingManager);
                                    arrayList.add(viewState);
                                } catch (Throwable th) {
                                    th = th;
                                    for (int i8 = 0; i8 < readHoldCount; i8++) {
                                        lock.lock();
                                    }
                                    writeLock.unlock();
                                    throw th;
                                }
                            }
                            j >>= i3;
                            i5++;
                            i3 = i3;
                        }
                        if (i4 != i3) {
                            break;
                        }
                        if (i2 != length) {
                            break;
                        }
                        i2++;
                        writeLock2 = writeLock;
                    } else if (i2 != length) {
                        break;
                        break;
                    } else {
                        i2++;
                        writeLock2 = writeLock;
                    }
                }
            } else {
                writeLock = writeLock2;
            }
            surfaceMountingManager.tagToViewState.clear();
            Unit unit = Unit.INSTANCE;
            for (int i9 = 0; i9 < readHoldCount; i9++) {
                lock.lock();
            }
            writeLock.unlock();
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                surfaceMountingManager.onViewStateDeleted((ViewState) next);
            }
            surfaceMountingManager.jsResponderHandler = null;
            surfaceMountingManager.rootViewManager = null;
            surfaceMountingManager.mountItemExecutor = null;
            surfaceMountingManager.context = null;
            surfaceMountingManager.onViewAttachMountItems.clear();
            surfaceMountingManager.tagToSynchronousMountProps.clear();
            FLog.e(TAG, "Surface [" + surfaceMountingManager.surfaceId + "] was stopped on SurfaceMountingManager.");
        } catch (Throwable th2) {
            th = th2;
            writeLock = writeLock2;
        }
    }

    public final void addViewAt(final int parentTag, final int tag, final int index) {
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(parentTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag: [" + parentTag + "] for addViewAt"));
            return;
        }
        final View view = nullableViewState.getView();
        if (view == null) {
            throw new IllegalStateException(("Unable to find parentView for tag " + parentTag).toString());
        }
        if (!(view instanceof ViewGroup)) {
            String str = "Unable to add a view into a non-ViewGroup " + view.getClass().getSimpleName() + " when inserting [" + tag + "] into parent [" + parentTag + "]";
            FLog.e(TAG, str);
            throw new IllegalStateException(str);
        }
        ViewState nullableViewState2 = getNullableViewState(tag);
        if (nullableViewState2 == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag: [" + tag + "] for addViewAt"));
            return;
        }
        View view2 = nullableViewState2.getView();
        if (view2 == null) {
            throw new IllegalStateException(("Unable to find view for viewState " + nullableViewState2 + " and tag " + tag).toString());
        }
        boolean z = SHOW_CHANGED_VIEW_HIERARCHIES;
        if (z) {
            FLog.e(TAG, "addViewAt: [" + tag + "] -> [" + parentTag + "] idx: " + index + " BEFORE");
            Companion.logViewHierarchy((ViewGroup) view, false);
        }
        ViewParent parent = view2.getParent();
        if (parent != null) {
            boolean z2 = parent instanceof ViewGroup;
            int id = z2 ? ((ViewGroup) parent).getId() : -1;
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + tag + "] into parent [" + parentTag + "]: View already has a parent: [" + id + "] Parent: " + parent.getClass().getSimpleName() + " View: " + view2.getClass().getSimpleName()));
            if (z2) {
                ((ViewGroup) parent).removeView(view2);
            }
            this.erroneouslyReaddedReactTags.add(Integer.valueOf(tag));
        }
        try {
            Companion.getViewGroupManager(nullableViewState).addView(view, view2, index);
            if (z) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceMountingManager.addViewAt$lambda$10(tag, parentTag, index, view);
                    }
                });
            }
        } catch (IllegalStateException e) {
            throw new IllegalStateException("addViewAt: failed to insert view [" + tag + "] into parent [" + parentTag + "] at index " + index, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new IllegalStateException("addViewAt: failed to insert view [" + tag + "] into parent [" + parentTag + "] at index " + index, e2);
        }
    }

    static final void addViewAt$lambda$10(int i, int i2, int i3, View view) {
        FLog.e(TAG, "addViewAt: [" + i + "] -> [" + i2 + "] idx: " + i3 + " AFTER");
        Companion.logViewHierarchy((ViewGroup) view, false);
    }

    public final void removeViewAt(final int tag, final int parentTag, int index) {
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        if (this.erroneouslyReaddedReactTags.contains(Integer.valueOf(tag))) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("removeViewAt tried to remove a React View that was actually reused. This indicates a bug in the Differ (specifically instruction ordering). [" + tag + "]"));
            return;
        }
        ViewState nullableViewState = getNullableViewState(parentTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag: [" + parentTag + "] for removeViewAt"));
            return;
        }
        final View view = nullableViewState.getView();
        if (view == null) {
            throw new IllegalStateException(("Unable to find parentView for tag " + parentTag).toString());
        }
        if (!(view instanceof ViewGroup)) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Unable to remove a view from a non-ViewGroup " + view.getClass().getSimpleName() + " when removing [" + tag + "] from parent [" + parentTag + "]"));
            return;
        }
        int i = 0;
        if (SHOW_CHANGED_VIEW_HIERARCHIES) {
            FLog.e(TAG, "removeViewAt: [" + tag + "] -> [" + parentTag + "] idx: " + index + " BEFORE");
            Companion.logViewHierarchy((ViewGroup) view, false);
        }
        IViewGroupManager viewGroupManager = Companion.getViewGroupManager(nullableViewState);
        View childAt = viewGroupManager.getChildAt(view, index);
        int id = childAt != null ? childAt.getId() : -1;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = index;
        if (id != tag) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                } else if (viewGroup.getChildAt(i).getId() == tag) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                FLog.e(TAG, "removeViewAt: [" + tag + "] -> [" + parentTag + "] @" + index + ": view already removed from parent! Children in parent: " + childCount);
                return;
            }
            Companion.logViewHierarchy(viewGroup, true);
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to remove view [" + tag + "] of parent [" + parentTag + "] at index " + index + ", but got view tag " + id + " - actual index of view: " + i));
            intRef.element = i;
        }
        try {
            viewGroupManager.removeViewAt(view, intRef.element);
            if (SHOW_CHANGED_VIEW_HIERARCHIES) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceMountingManager.removeViewAt$lambda$12(tag, parentTag, intRef, view);
                    }
                });
            }
        } catch (RuntimeException e) {
            int childCount2 = viewGroupManager.getChildCount(view);
            ViewGroup viewGroup2 = (ViewGroup) view;
            Companion.logViewHierarchy(viewGroup2, true);
            throw new IllegalStateException("Cannot remove child at index " + intRef.element + " from parent ViewGroup [" + viewGroup2.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
        }
    }

    static final void removeViewAt$lambda$12(int i, int i2, Ref.IntRef intRef, View view) {
        FLog.e(TAG, "removeViewAt: [" + i + "] -> [" + i2 + "] idx: " + intRef.element + " AFTER");
        Companion.logViewHierarchy((ViewGroup) view, false);
    }

    public final void createView$ReactAndroid(String componentName, int reactTag, ReadableMap props, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean isLayoutable) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(props, "props");
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if ((nullableViewState != null ? nullableViewState.getView() : null) != null) {
            return;
        }
        createViewUnsafe(componentName, reactTag, props, stateWrapper, eventEmitterWrapper, isLayoutable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void createViewUnsafe(String componentName, int reactTag, ReadableMap props, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean isLayoutable) {
        Systrace.beginSection(0L, "SurfaceMountingManager::createViewUnsafe(" + componentName + ")");
        try {
            ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(props);
            ViewState viewState = new ViewState(reactTag, null, null, false, 14, null);
            viewState.setCurrentProps(reactStylesDiffMap);
            viewState.setStateWrapper(stateWrapper);
            viewState.setEventEmitter(eventEmitterWrapper);
            ReentrantReadWriteLock reentrantReadWriteLock = this.registryLock;
            ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
            int i = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                lock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                this.tagToViewState.set(reactTag, viewState);
                Unit unit = Unit.INSTANCE;
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
                if (isLayoutable) {
                    ViewManagerRegistry viewManagerRegistry = this.viewManagerRegistry;
                    ViewManager<?, ?> viewManager = viewManagerRegistry != null ? viewManagerRegistry.get(componentName) : null;
                    Intrinsics.checkNotNull(viewManager, "null cannot be cast to non-null type com.facebook.react.uimanager.ViewManager<android.view.View, *>");
                    ThemedReactContext themedReactContext = this.context;
                    if (themedReactContext != null) {
                        viewState.setView(viewManager.createView(reactTag, themedReactContext, reactStylesDiffMap, stateWrapper, this.jsResponderHandler));
                        viewState.setViewManager(viewManager);
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                }
                Systrace.endSection(0L);
            } catch (Throwable th) {
                while (i < readHoldCount) {
                    lock.lock();
                    i++;
                }
                writeLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            Systrace.endSection(0L);
            throw th2;
        }
    }

    public final void storeSynchronousMountPropsOverride(int reactTag, ReadableMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
        if (ReactNativeFeatureFlags.overrideBySynchronousMountPropsAtMountingAndroid()) {
            Companion companion = Companion;
            Map<? extends String, ? extends Object> animatedPropsMap = companion.getAnimatedPropsMap(props);
            LinkedHashMap linkedHashMap = this.tagToSynchronousMountProps.get(reactTag);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            companion.clearAnimatedNullPropsMapKeys(props, linkedHashMap);
            linkedHashMap.putAll(animatedPropsMap);
            boolean zIsEmpty = linkedHashMap.isEmpty();
            SparseArrayCompat<Map<String, Object>> sparseArrayCompat = this.tagToSynchronousMountProps;
            if (!zIsEmpty) {
                SurfaceMountingManagerKt.set(sparseArrayCompat, reactTag, linkedHashMap);
            } else {
                sparseArrayCompat.remove(reactTag);
            }
        }
    }

    public final void updatePropsSynchronously(int reactTag, ReadableMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
        updateProps(reactTag, props, true);
    }

    public final void updateProps(int reactTag, ReadableMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
        updateProps(reactTag, props, false);
    }

    private final void updateProps(int reactTag, ReadableMap props, boolean shouldSkipSynchronousMountPropsOverride) {
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for updateProps"));
            return;
        }
        if (ReactNativeFeatureFlags.overrideBySynchronousMountPropsAtMountingAndroid() && !shouldSkipSynchronousMountPropsOverride && this.tagToSynchronousMountProps.containsKey(reactTag)) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.merge(props);
            Map<String, Object> map = this.tagToSynchronousMountProps.get(reactTag);
            if (map == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Companion.overridePropsReadableMap(map, writableNativeMap);
            nullableViewState.setCurrentProps(new ReactStylesDiffMap(writableNativeMap));
        } else {
            nullableViewState.setCurrentProps(new ReactStylesDiffMap(props));
        }
        View view = nullableViewState.getView();
        if (view == null) {
            return;
        }
        ViewManager<View, ?> viewManager = nullableViewState.getViewManager();
        if (viewManager == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        viewManager.updateProperties(view, nullableViewState.getCurrentProps());
    }

    @UnstableReactNativeAPI
    public final void experimental_prefetchResources(int surfaceId, String componentName, MapBuffer params) {
        ViewManagerRegistry viewManagerRegistry;
        ViewManager<?, ?> viewManager;
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        if (this.isStopped || (viewManagerRegistry = this.viewManagerRegistry) == null || (viewManager = viewManagerRegistry.get(componentName)) == null) {
            return;
        }
        ThemedReactContext themedReactContext = this.context;
        if (themedReactContext == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        viewManager.experimental_prefetchResources(surfaceId, themedReactContext, params);
    }

    @Deprecated(message = "")
    public final void receiveCommand(int reactTag, int commandId, ReadableArray commandArgs) {
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            throw new RetryableMountingLayerException("Unable to find viewState for tag " + reactTag + " for commandId " + commandId);
        }
        ViewManager<View, ?> viewManager = nullableViewState.getViewManager();
        if (viewManager == null) {
            throw new RetryableMountingLayerException("Unable to find viewManager for tag " + reactTag);
        }
        View view = nullableViewState.getView();
        if (view == null) {
            throw new RetryableMountingLayerException("Unable to find viewState view for tag " + reactTag);
        }
        viewManager.receiveCommand(view, commandId, commandArgs);
    }

    public final void receiveCommand(int reactTag, String commandId, ReadableArray commandArgs) {
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            throw new RetryableMountingLayerException("Unable to find viewState for tag " + reactTag + " for commandId " + commandId);
        }
        ViewManager<View, ?> viewManager = nullableViewState.getViewManager();
        if (viewManager == null) {
            throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + reactTag);
        }
        View view = nullableViewState.getView();
        if (view == null) {
            throw new RetryableMountingLayerException("Unable to find viewState view for tag " + reactTag);
        }
        viewManager.receiveCommand(view, commandId, commandArgs);
    }

    public final void sendAccessibilityEvent(int reactTag, int eventType) {
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        View view = nullableViewState != null ? nullableViewState.getView() : null;
        if (view == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for sendAccessibilityEvent"));
            return;
        }
        view.sendAccessibilityEvent(eventType);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    public final void updateLayout(int reactTag, int parentTag, int x, int y, int width, int height, int displayType, int layoutDirection) {
        View view;
        IViewGroupManager iViewGroupManager;
        int i;
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for updateLayout"));
            return;
        }
        if (nullableViewState.getIsRoot() || (view = nullableViewState.getView()) == null) {
            return;
        }
        int i2 = 1;
        if (layoutDirection == 1) {
            i2 = 0;
        } else if (layoutDirection != 2) {
            i2 = 2;
        }
        view.setLayoutDirection(i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        ViewState nullableViewState2 = getNullableViewState(parentTag);
        if (nullableViewState2 == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + parentTag + " for updateLayout"));
        } else {
            if (nullableViewState2.getViewManager() != null) {
                NativeModule viewManager = nullableViewState2.getViewManager();
                Intrinsics.checkNotNull(viewManager, "null cannot be cast to non-null type com.facebook.react.uimanager.IViewGroupManager<*>");
                iViewGroupManager = (IViewGroupManager) viewManager;
            }
            if (iViewGroupManager != null || !iViewGroupManager.needsCustomLayoutForChildren()) {
                view.layout(x, y, width + x, height + y);
            }
            i = displayType == 0 ? 4 : 0;
            if (view.getVisibility() != i) {
                view.setVisibility(i);
            }
        }
        iViewGroupManager = null;
        if (iViewGroupManager != null) {
            view.layout(x, y, width + x, height + y);
        } else {
            view.layout(x, y, width + x, height + y);
        }
        if (displayType == 0) {
        }
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    public final void updatePadding(int reactTag, int left, int top, int right, int bottom) {
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for updatePadding"));
            return;
        }
        if (nullableViewState.getIsRoot()) {
            return;
        }
        View view = nullableViewState.getView();
        if (view == null) {
            throw new IllegalStateException(("Unable to find View for tag: " + reactTag).toString());
        }
        ViewManager<View, ?> viewManager = nullableViewState.getViewManager();
        if (viewManager == null) {
            throw new IllegalStateException(("Unable to find ViewManager for view: " + nullableViewState).toString());
        }
        viewManager.setPadding(view, left, top, right, bottom);
    }

    public final void updateOverflowInset(int reactTag, int overflowInsetLeft, int overflowInsetTop, int overflowInsetRight, int overflowInsetBottom) {
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for updateOverflowInset"));
            return;
        }
        if (nullableViewState.getIsRoot()) {
            return;
        }
        KeyEvent.Callback view = nullableViewState.getView();
        if (view == null) {
            throw new IllegalStateException(("Unable to find View for tag: " + reactTag).toString());
        }
        if (view instanceof ReactOverflowViewWithInset) {
            ((ReactOverflowViewWithInset) view).setOverflowInset(overflowInsetLeft, overflowInsetTop, overflowInsetRight, overflowInsetBottom);
        }
    }

    public final void updateState(int reactTag, StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for updateState"));
            return;
        }
        StateWrapper stateWrapper2 = nullableViewState.getStateWrapper();
        nullableViewState.setStateWrapper(stateWrapper);
        ViewManager<View, ?> viewManager = nullableViewState.getViewManager();
        if (viewManager == null) {
            throw new IllegalStateException(("Unable to find ViewManager for tag: " + reactTag).toString());
        }
        View view = nullableViewState.getView();
        if (view == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Object objUpdateState = viewManager.updateState(view, nullableViewState.getCurrentProps(), stateWrapper);
        if (objUpdateState != null) {
            viewManager.updateExtraData(view, objUpdateState);
        }
        if (stateWrapper2 != null) {
            stateWrapper2.destroyState();
        }
    }

    public final void updateEventEmitter$ReactAndroid(int reactTag, EventEmitterWrapper eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.registryLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            MutableIntObjectMap<ViewState> mutableIntObjectMap = this.tagToViewState;
            ViewState viewState = mutableIntObjectMap.get(reactTag);
            if (viewState == null) {
                ViewState viewState2 = new ViewState(reactTag, null, null, false, 14, null);
                mutableIntObjectMap.set(reactTag, viewState2);
                viewState = viewState2;
            }
            ViewState viewState3 = viewState;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            EventEmitterWrapper eventEmitter2 = viewState3.getEventEmitter();
            synchronized (viewState3) {
                viewState3.setEventEmitter(eventEmitter);
                Queue<PendingViewEvent> pendingEventQueue = viewState3.getPendingEventQueue();
                if (pendingEventQueue != null) {
                    Iterator<T> it = pendingEventQueue.iterator();
                    while (it.hasNext()) {
                        ((PendingViewEvent) it.next()).dispatch(eventEmitter);
                    }
                }
                viewState3.setPendingEventQueue(null);
                Unit unit = Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(eventEmitter2, eventEmitter) || eventEmitter2 == null) {
                return;
            }
            eventEmitter2.destroy();
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void setJSResponder(int reactTag, int initialReactTag, boolean blockNativeResponder) {
        View view;
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        JSResponderHandler jSResponderHandler = this.jsResponderHandler;
        if (jSResponderHandler == null) {
            return;
        }
        View view2 = 0;
        if (!blockNativeResponder) {
            jSResponderHandler.setJSResponder(initialReactTag, null);
            return;
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState != null) {
            view = nullableViewState.getView();
        }
        if (view2 == 0) {
            view2 = view;
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for setJSResponder"));
            return;
        }
        if (initialReactTag != reactTag && (view2 instanceof ViewParent)) {
            jSResponderHandler.setJSResponder(initialReactTag, (ViewParent) view2);
            return;
        }
        if (nullableViewState.getIsRoot()) {
            SoftAssertions.assertUnreachable("Cannot block native responder on [" + reactTag + "] that is a root view");
        }
        jSResponderHandler.setJSResponder(initialReactTag, view2.getParent());
    }

    private final void onViewStateDeleted(ViewState viewState) {
        StateWrapper stateWrapper = viewState.getStateWrapper();
        if (stateWrapper != null) {
            stateWrapper.destroyState();
        }
        viewState.setStateWrapper(null);
        EventEmitterWrapper eventEmitter = viewState.getEventEmitter();
        if (eventEmitter != null) {
            eventEmitter.destroy();
        }
        viewState.setEventEmitter(null);
        ViewManager<View, ?> viewManager = viewState.getViewManager();
        if (viewState.getIsRoot() || viewManager == null) {
            return;
        }
        View view = viewState.getView();
        if (view == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        viewManager.onDropViewInstance(view);
    }

    public final void deleteView(int reactTag) {
        UiThreadUtil.assertOnUiThread();
        if (this.isStopped) {
            return;
        }
        if (ReactNativeFeatureFlags.overrideBySynchronousMountPropsAtMountingAndroid() && this.tagToSynchronousMountProps.containsKey(reactTag)) {
            this.tagToSynchronousMountProps.remove(reactTag);
        }
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SURFACE_MOUNTING_MANAGER_MISSING_VIEWSTATE, new ReactNoCrashSoftException("Unable to find viewState for tag " + reactTag + " for deleteView"));
            return;
        }
        if (this.viewsWithActiveTouches.contains(Integer.valueOf(reactTag))) {
            this.viewsToDeleteAfterTouchFinishes.add(Integer.valueOf(reactTag));
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.registryLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.tagToViewState.remove(reactTag);
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            onViewStateDeleted(nullableViewState);
        } catch (Throwable th) {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void preallocateView(String componentName, int reactTag, ReadableMap props, StateWrapper stateWrapper, boolean isLayoutable) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(props, "props");
        UiThreadUtil.assertOnUiThread();
        if (!this.isStopped && getNullableViewState(reactTag) == null) {
            createViewUnsafe(componentName, reactTag, props, stateWrapper, null, isLayoutable);
        }
    }

    public final EventEmitterWrapper getEventEmitter$ReactAndroid(int reactTag) {
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState != null) {
            return nullableViewState.getEventEmitter();
        }
        return null;
    }

    public final View getView(int reactTag) {
        View view;
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState != null && (view = nullableViewState.getView()) != null) {
            return view;
        }
        throw new IllegalViewOperationException("Unable to find view for tag " + reactTag + ". Surface " + this.surfaceId + " stopped: " + this.isStopped + ", rootViewAttached: " + this.isRootViewAttached);
    }

    private final ViewState getNullableViewState(int reactTag) {
        ReentrantReadWriteLock.ReadLock lock = this.registryLock.readLock();
        lock.lock();
        try {
            return this.tagToViewState.get(reactTag);
        } finally {
            lock.unlock();
        }
    }

    public final void applyViewSnapshot(int tag, Bitmap bitmap) {
        View view;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ViewState nullableViewState = getNullableViewState(tag);
        if (nullableViewState == null || (view = nullableViewState.getView()) == null) {
            return;
        }
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        view.setBackground(new BitmapDrawable(resources, bitmap));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00d0 A[Catch: all -> 0x00da, LOOP:0: B:6:0x0033->B:28:0x00d0, LOOP_END, TryCatch #0 {all -> 0x00da, blocks: (B:3:0x0025, B:6:0x0033, B:8:0x0043, B:10:0x004f, B:12:0x0058, B:14:0x0066, B:16:0x006c, B:18:0x0072, B:21:0x007c, B:22:0x0084, B:24:0x00c4, B:28:0x00d0, B:29:0x00d4), top: B:35:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4 A[EDGE_INSN: B:38:0x00d4->B:29:0x00d4 BREAK  A[LOOP:0: B:6:0x0033->B:28:0x00d0], SYNTHETIC] */
    public final void printSurfaceState() {
        FLog.e(TAG, "Views created for surface " + this.surfaceId + ServerSentEventKt.COLON);
        ReentrantReadWriteLock.ReadLock lock = this.registryLock.readLock();
        lock.lock();
        try {
            MutableIntObjectMap<ViewState> mutableIntObjectMap = this.tagToViewState;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8;
                        int i3 = 8 - ((~(i - length)) >>> 31);
                        int i4 = 0;
                        while (i4 < i3) {
                            if ((255 & j) < 128) {
                                ViewState viewState = (ViewState) objArr[(i << 3) + i4];
                                ViewManager<View, ?> viewManager = viewState.getViewManager();
                                String name = viewManager != null ? viewManager.getName() : null;
                                View view = viewState.getView();
                                View view2 = view != null ? (View) view.getParent() : null;
                                Integer numValueOf = view2 != null ? Integer.valueOf(view2.getId()) : null;
                                FLog.e(TAG, "<" + name + " id=" + viewState.getReactTag() + " parentTag=" + numValueOf + " isRoot=" + viewState.getIsRoot() + " />");
                            }
                            j >>= i2;
                            i4++;
                            i2 = i2;
                        }
                        if (i3 != i2) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public final void dispatchEvent$ReactAndroid(int reactTag, String eventName, boolean canCoalesceEvent, WritableMap params, int eventCategory, long eventTimestamp) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ViewState nullableViewState = getNullableViewState(reactTag);
        if (nullableViewState == null) {
            FLog.i(TAG, "Unable to invoke event: %s for reactTag: %d", eventName, Integer.valueOf(reactTag));
            return;
        }
        EventEmitterWrapper eventEmitter = nullableViewState.getEventEmitter();
        if (eventEmitter == null) {
            synchronized (nullableViewState) {
                eventEmitter = nullableViewState.getEventEmitter();
                if (eventEmitter == null) {
                    LinkedList pendingEventQueue = nullableViewState.getPendingEventQueue();
                    if (pendingEventQueue == null) {
                        LinkedList linkedList = new LinkedList();
                        nullableViewState.setPendingEventQueue(linkedList);
                        pendingEventQueue = linkedList;
                    }
                    pendingEventQueue.add(new PendingViewEvent(eventName, params, eventCategory, canCoalesceEvent, eventTimestamp));
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        EventEmitterWrapper eventEmitterWrapper = eventEmitter;
        if (nullableViewState.getPendingEventQueue() != null) {
            synchronized (nullableViewState) {
                Unit unit2 = Unit.INSTANCE;
            }
            nullableViewState.getPendingEventQueue();
        }
        if (canCoalesceEvent) {
            eventEmitterWrapper.dispatchUnique(eventName, params, eventTimestamp);
        } else {
            eventEmitterWrapper.dispatch(eventName, params, eventCategory, eventTimestamp);
        }
    }

    public final void markActiveTouchForTag(int reactTag) {
        this.viewsWithActiveTouches.add(Integer.valueOf(reactTag));
    }

    public final void sweepActiveTouchForTag(int reactTag) {
        this.viewsWithActiveTouches.remove(Integer.valueOf(reactTag));
        if (this.viewsToDeleteAfterTouchFinishes.contains(Integer.valueOf(reactTag))) {
            this.viewsToDeleteAfterTouchFinishes.remove(Integer.valueOf(reactTag));
            deleteView(reactTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SurfaceMountingManager.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u00100\u001a\u000201H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$ViewState;", "", "reactTag", "", "view", "Landroid/view/View;", "viewManager", "Lcom/facebook/react/uimanager/ViewManager;", "isRoot", "", "<init>", "(ILandroid/view/View;Lcom/facebook/react/uimanager/ViewManager;Z)V", "getReactTag", "()I", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "getViewManager", "()Lcom/facebook/react/uimanager/ViewManager;", "setViewManager", "(Lcom/facebook/react/uimanager/ViewManager;)V", "()Z", "currentProps", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "getCurrentProps", "()Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "setCurrentProps", "(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "eventEmitter", "Lcom/facebook/react/fabric/events/EventEmitterWrapper;", "getEventEmitter", "()Lcom/facebook/react/fabric/events/EventEmitterWrapper;", "setEventEmitter", "(Lcom/facebook/react/fabric/events/EventEmitterWrapper;)V", "pendingEventQueue", "Ljava/util/Queue;", "Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$PendingViewEvent;", "getPendingEventQueue", "()Ljava/util/Queue;", "setPendingEventQueue", "(Ljava/util/Queue;)V", "toString", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class ViewState {
        private ReactStylesDiffMap currentProps;
        private volatile EventEmitterWrapper eventEmitter;
        private final boolean isRoot;
        private volatile Queue<PendingViewEvent> pendingEventQueue;
        private final int reactTag;
        private StateWrapper stateWrapper;
        private View view;
        private ViewManager<View, ?> viewManager;

        public ViewState(int i, View view, ViewManager<View, ?> viewManager, boolean z) {
            this.reactTag = i;
            this.view = view;
            this.viewManager = viewManager;
            this.isRoot = z;
        }

        public /* synthetic */ ViewState(int i, View view, ViewManager viewManager, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : view, (i2 & 4) != 0 ? null : viewManager, (i2 & 8) != 0 ? false : z);
        }

        public final int getReactTag() {
            return this.reactTag;
        }

        public final View getView() {
            return this.view;
        }

        public final void setView(View view) {
            this.view = view;
        }

        public final ViewManager<View, ?> getViewManager() {
            return this.viewManager;
        }

        public final void setViewManager(ViewManager<View, ?> viewManager) {
            this.viewManager = viewManager;
        }

        /* JADX INFO: renamed from: isRoot, reason: from getter */
        public final boolean getIsRoot() {
            return this.isRoot;
        }

        public final ReactStylesDiffMap getCurrentProps() {
            return this.currentProps;
        }

        public final void setCurrentProps(ReactStylesDiffMap reactStylesDiffMap) {
            this.currentProps = reactStylesDiffMap;
        }

        public final StateWrapper getStateWrapper() {
            return this.stateWrapper;
        }

        public final void setStateWrapper(StateWrapper stateWrapper) {
            this.stateWrapper = stateWrapper;
        }

        public final EventEmitterWrapper getEventEmitter() {
            return this.eventEmitter;
        }

        public final void setEventEmitter(EventEmitterWrapper eventEmitterWrapper) {
            this.eventEmitter = eventEmitterWrapper;
        }

        public final Queue<PendingViewEvent> getPendingEventQueue() {
            return this.pendingEventQueue;
        }

        public final void setPendingEventQueue(Queue<PendingViewEvent> queue) {
            this.pendingEventQueue = queue;
        }

        public String toString() {
            ViewManager<View, ?> viewManager = this.viewManager;
            boolean z = viewManager == null;
            return "ViewState [" + this.reactTag + "] - isRoot: " + this.isRoot + " - props: " + this.currentProps + " - viewManager: " + viewManager + " - isLayoutOnly: " + z;
        }
    }

    /* JADX INFO: compiled from: SurfaceMountingManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$PendingViewEvent;", "", "eventName", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "eventCategory", "", "canCoalesceEvent", "", "eventTimestamp", "", "<init>", "(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;IZJ)V", "dispatch", "", "eventEmitter", "Lcom/facebook/react/fabric/events/EventEmitterWrapper;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class PendingViewEvent {
        private final boolean canCoalesceEvent;
        private final int eventCategory;
        private final String eventName;
        private final long eventTimestamp;
        private final WritableMap params;

        public PendingViewEvent(String eventName, WritableMap writableMap, int i, boolean z, long j) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.params = writableMap;
            this.eventCategory = i;
            this.canCoalesceEvent = z;
            this.eventTimestamp = j;
        }

        public final void dispatch(EventEmitterWrapper eventEmitter) {
            Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
            boolean z = this.canCoalesceEvent;
            String str = this.eventName;
            if (z) {
                eventEmitter.dispatchUnique(str, this.params, this.eventTimestamp);
            } else {
                eventEmitter.dispatch(str, this.params, this.eventCategory, this.eventTimestamp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SurfaceMountingManager.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J$\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0015H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$Companion;", "", "<init>", "()V", "TAG", "", "SHOW_CHANGED_VIEW_HIERARCHIES", "", "PROP_TRANSFORM", "PROP_OPACITY", "logViewHierarchy", "", "parent", "Landroid/view/ViewGroup;", "recurse", "overridePropsReadableMap", "patchMap", "", "outputReadableMap", "Lcom/facebook/react/bridge/WritableMap;", "getAnimatedPropsMap", "", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "clearAnimatedNullPropsMapKeys", "outputMap", "getViewGroupManager", "Lcom/facebook/react/uimanager/IViewGroupManager;", "Landroid/view/View;", "viewState", "Lcom/facebook/react/fabric/mounting/SurfaceMountingManager$ViewState;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logViewHierarchy(ViewGroup parent, boolean recurse) {
            int id = parent.getId();
            FLog.e(SurfaceMountingManager.TAG, "  <ViewGroup tag=" + id + " class=" + parent.getClass() + ">");
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                FLog.e(SurfaceMountingManager.TAG, "     <View idx=" + i + " tag=" + parent.getChildAt(i).getId() + " class=" + parent.getChildAt(i).getClass() + ">");
            }
            FLog.e(SurfaceMountingManager.TAG, "  </ViewGroup tag=" + id + ">");
            if (recurse) {
                FLog.e(SurfaceMountingManager.TAG, "Displaying Ancestors:");
                for (ViewParent parent2 = parent.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                    int id2 = viewGroup != null ? viewGroup.getId() : -1;
                    FLog.e(SurfaceMountingManager.TAG, "<ViewParent tag=" + id2 + " class=" + parent2.getClass() + ">");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void overridePropsReadableMap(Map<String, ? extends Object> patchMap, WritableMap outputReadableMap) {
            for (Map.Entry<String, ? extends Object> entry : patchMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (outputReadableMap.hasKey(key)) {
                    if (Intrinsics.areEqual(key, "transform")) {
                        ReadableType type = outputReadableMap.getType(key);
                        if (type == ReadableType.Array || type == ReadableType.Null) {
                            boolean z = value instanceof List;
                        }
                        WritableNativeArray writableNativeArray = new WritableNativeArray();
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
                        for (Object obj : (List) value) {
                            if (obj instanceof Map) {
                                WritableNativeMap writableNativeMap = new WritableNativeMap();
                                for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                                    String str = (String) entry2.getKey();
                                    Object value2 = entry2.getValue();
                                    if (value2 instanceof String) {
                                        writableNativeMap.putString(str, (String) value2);
                                    } else if (value2 instanceof Number) {
                                        writableNativeMap.putDouble(str, ((Number) value2).doubleValue());
                                    }
                                }
                                writableNativeArray.pushMap(writableNativeMap);
                            }
                        }
                        outputReadableMap.putArray(key, writableNativeArray);
                    } else if (Intrinsics.areEqual(key, "opacity")) {
                        ReadableType type2 = outputReadableMap.getType(key);
                        if (type2 == ReadableType.Number || type2 == ReadableType.Null) {
                            boolean z2 = value instanceof Number;
                        }
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Number");
                        outputReadableMap.putDouble(key, ((Number) value).doubleValue());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Object> getAnimatedPropsMap(ReadableMap readableMap) {
            ReadableArray array;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (readableMap.hasKey("transform") && readableMap.getType("transform") == ReadableType.Array && (array = readableMap.getArray("transform")) != null) {
                ArrayList arrayList = new ArrayList(array.size());
                int size = array.size();
                for (int i = 0; i < size; i++) {
                    ReadableMap map = array.getMap(i);
                    if (map != null) {
                        arrayList.add(map.toHashMap());
                    }
                }
                linkedHashMap.put("transform", arrayList);
            }
            if (readableMap.hasKey("opacity") && readableMap.getType("opacity") == ReadableType.Number) {
                linkedHashMap.put("opacity", Double.valueOf(readableMap.getDouble("opacity")));
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearAnimatedNullPropsMapKeys(ReadableMap readableMap, Map<String, Object> outputMap) {
            if (readableMap.hasKey("transform") && readableMap.getType("transform") == ReadableType.Null) {
                outputMap.remove("transform");
            }
            if (readableMap.hasKey("opacity") && readableMap.getType("opacity") == ReadableType.Null) {
                outputMap.remove("opacity");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IViewGroupManager<View> getViewGroupManager(ViewState viewState) {
            NativeModule viewManager = viewState.getViewManager();
            if (viewManager == null) {
                throw new IllegalStateException(("Unable to find ViewManager for view: " + viewState).toString());
            }
            Intrinsics.checkNotNull(viewManager, "null cannot be cast to non-null type com.facebook.react.uimanager.IViewGroupManager<android.view.View>");
            return (IViewGroupManager) viewManager;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SurfaceMountingManager", "getSimpleName(...)");
        TAG = "SurfaceMountingManager";
        boolean z = ReactBuildConfig.DEBUG;
        SHOW_CHANGED_VIEW_HIERARCHIES = false;
    }
}
