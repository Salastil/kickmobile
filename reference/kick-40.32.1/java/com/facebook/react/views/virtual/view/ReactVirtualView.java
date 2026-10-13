package com.facebook.react.views.virtual.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.scroll.VirtualView;
import com.facebook.react.views.scroll.VirtualViewContainer;
import com.facebook.react.views.scroll.VirtualViewContainerState;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.virtual.VirtualViewMode;
import com.facebook.react.views.virtual.VirtualViewModeChangeEmitter;
import com.facebook.react.views.virtual.VirtualViewRenderState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactVirtualView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001VB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010+\u001a\u00020,H\u0014J\r\u0010-\u001a\u00020,H\u0001¢\u0006\u0002\b.J0\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020#H\u0014JR\u00105\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#H\u0016J(\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020#H\u0014J\b\u0010A\u001a\u00020,H\u0014J\r\u0010B\u001a\u00020,H\u0010¢\u0006\u0002\bCJ\u0018\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0018\u0010I\u001a\u00020,2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020,H\u0002J\n\u0010N\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010O\u001a\u00020,H\u0002J\u0012\u0010P\u001a\u0004\u0018\u00010\u001b2\u0006\u0010Q\u001a\u00020&H\u0002J!\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020(2\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020(0UH\u0082\bR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u0004\u0018\u00010(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010D\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010*¨\u0006W"}, d2 = {"Lcom/facebook/react/views/virtual/view/ReactVirtualView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/facebook/react/views/scroll/VirtualView;", "Landroid/view/View$OnLayoutChangeListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mode", "Lcom/facebook/react/views/virtual/VirtualViewMode;", "getMode$ReactAndroid", "()Lcom/facebook/react/views/virtual/VirtualViewMode;", "setMode$ReactAndroid", "(Lcom/facebook/react/views/virtual/VirtualViewMode;)V", "modeChangeEmitter", "Lcom/facebook/react/views/virtual/VirtualViewModeChangeEmitter;", "getModeChangeEmitter$ReactAndroid", "()Lcom/facebook/react/views/virtual/VirtualViewModeChangeEmitter;", "setModeChangeEmitter$ReactAndroid", "(Lcom/facebook/react/views/virtual/VirtualViewModeChangeEmitter;)V", "renderState", "Lcom/facebook/react/views/virtual/VirtualViewRenderState;", "getRenderState$ReactAndroid", "()Lcom/facebook/react/views/virtual/VirtualViewRenderState;", "setRenderState$ReactAndroid", "(Lcom/facebook/react/views/virtual/VirtualViewRenderState;)V", "scrollView", "Lcom/facebook/react/views/scroll/VirtualViewContainer;", "lastContainerRelativeRect", "Landroid/graphics/Rect;", "lastClippingRect", "containerRelativeRect", "getContainerRelativeRect", "()Landroid/graphics/Rect;", "offsetX", "", "offsetY", "hadLayout", "", "nativeId", "", "getNativeId$ReactAndroid", "()Ljava/lang/String;", "onAttachedToWindow", "", "doAttachedToWindow", "doAttachedToWindow$ReactAndroid", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onLayoutChange", "v", "Landroid/view/View;", "oldLeft", "oldTop", "oldRight", "oldBottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "recycleView", "recycleView$ReactAndroid", "virtualViewID", "getVirtualViewID", "onModeChange", "newMode", "thresholdRect", "updateClippingRect", "excludedViews", "", "updateParentOffset", "reportRectChangeToContainer", "getScrollView", "cleanupLayoutListeners", "traverseParentStack", "addListeners", "debugLog", "subtag", "block", "Lkotlin/Function0;", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactVirtualView extends ReactViewGroup implements VirtualView, View.OnLayoutChangeListener {
    private static final Companion Companion = new Companion(null);
    private static final boolean ENABLE_DEBUG_LOGS;
    private final Rect containerRelativeRect;
    private boolean hadLayout;
    private final Rect lastClippingRect;
    private final Rect lastContainerRelativeRect;
    private VirtualViewMode mode;
    private VirtualViewModeChangeEmitter modeChangeEmitter;
    private int offsetX;
    private int offsetY;
    private VirtualViewRenderState renderState;
    private VirtualViewContainer scrollView;

    /* JADX INFO: compiled from: ReactVirtualView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VirtualViewMode.values().length];
            try {
                iArr[VirtualViewMode.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VirtualViewMode.Prerender.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VirtualViewMode.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactVirtualView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.renderState = VirtualViewRenderState.Unknown;
        this.lastContainerRelativeRect = new Rect();
        this.lastClippingRect = new Rect();
        this.containerRelativeRect = new Rect();
    }

    /* JADX INFO: renamed from: getMode$ReactAndroid, reason: from getter */
    public final VirtualViewMode getMode() {
        return this.mode;
    }

    public final void setMode$ReactAndroid(VirtualViewMode virtualViewMode) {
        this.mode = virtualViewMode;
    }

    /* JADX INFO: renamed from: getModeChangeEmitter$ReactAndroid, reason: from getter */
    public final VirtualViewModeChangeEmitter getModeChangeEmitter() {
        return this.modeChangeEmitter;
    }

    public final void setModeChangeEmitter$ReactAndroid(VirtualViewModeChangeEmitter virtualViewModeChangeEmitter) {
        this.modeChangeEmitter = virtualViewModeChangeEmitter;
    }

    /* JADX INFO: renamed from: getRenderState$ReactAndroid, reason: from getter */
    public final VirtualViewRenderState getRenderState() {
        return this.renderState;
    }

    public final void setRenderState$ReactAndroid(VirtualViewRenderState virtualViewRenderState) {
        Intrinsics.checkNotNullParameter(virtualViewRenderState, "<set-?>");
        this.renderState = virtualViewRenderState;
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public Rect getContainerRelativeRect() {
        return this.containerRelativeRect;
    }

    public final String getNativeId$ReactAndroid() {
        Object tag = getTag(R.id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        doAttachedToWindow$ReactAndroid();
    }

    public final void doAttachedToWindow$ReactAndroid() {
        this.scrollView = getScrollView();
        if (this.hadLayout) {
            updateParentOffset();
            reportRectChangeToContainer();
        }
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:doAttachedToWindow", "");
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.hadLayout = true;
        if (changed) {
            Rect containerRelativeRect = getContainerRelativeRect();
            int i = this.offsetX;
            int i2 = this.offsetY;
            containerRelativeRect.set(left + i, top + i2, right + i, bottom + i2);
            if (ENABLE_DEBUG_LOGS) {
                FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:onLayout", "containerRelativeRect=" + getContainerRelativeRect());
            }
            reportRectChangeToContainer();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (oldLeft == left && oldTop == top) {
            return;
        }
        updateParentOffset();
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:onLayoutChange", "containerRelativeRect=" + getContainerRelativeRect());
        }
        reportRectChangeToContainer();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        getContainerRelativeRect().set(getLeft() + this.offsetX, getTop() + this.offsetY, getRight() + this.offsetX, getBottom() + this.offsetY);
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:onSizeChanged", "container=" + getContainerRelativeRect());
        }
        reportRectChangeToContainer();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        recycleView$ReactAndroid();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void recycleView$ReactAndroid() {
        VirtualViewContainerState virtualViewContainerState;
        cleanupLayoutListeners();
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer != null && (virtualViewContainerState = virtualViewContainer.getVirtualViewContainerState()) != null) {
            virtualViewContainerState.remove(this);
        }
        this.scrollView = null;
        this.mode = null;
        this.modeChangeEmitter = null;
        this.hadLayout = false;
        this.lastContainerRelativeRect.setEmpty();
        this.lastClippingRect.setEmpty();
        getContainerRelativeRect().setEmpty();
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public String getVirtualViewID() {
        String nativeId$ReactAndroid = getNativeId$ReactAndroid();
        if (nativeId$ReactAndroid == null) {
            nativeId$ReactAndroid = "unknown";
        }
        return nativeId$ReactAndroid + ":::" + getId();
    }

    @Override // com.facebook.react.views.scroll.VirtualView
    public void onModeChange(VirtualViewMode newMode, Rect thresholdRect) {
        VirtualViewModeChangeEmitter virtualViewModeChangeEmitter;
        VirtualViewModeChangeEmitter virtualViewModeChangeEmitter2;
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        Intrinsics.checkNotNullParameter(thresholdRect, "thresholdRect");
        if (this.modeChangeEmitter == null || this.scrollView == null) {
            return;
        }
        if (newMode == VirtualViewMode.Visible) {
            updateClippingRect(null);
        }
        VirtualViewMode virtualViewMode = this.mode;
        if (newMode == virtualViewMode) {
            if (ENABLE_DEBUG_LOGS) {
                FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:onModeChange", "no change " + newMode);
                return;
            }
            return;
        }
        this.mode = newMode;
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:onModeChange", virtualViewMode + "->" + newMode);
        }
        if (virtualViewMode == VirtualViewMode.Visible) {
            updateClippingRect(null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[newMode.ordinal()];
        if (i == 1) {
            if ((virtualViewMode == null || virtualViewMode == VirtualViewMode.Hidden || this.renderState != VirtualViewRenderState.Rendered) && (virtualViewModeChangeEmitter = this.modeChangeEmitter) != null) {
                virtualViewModeChangeEmitter.emitModeChange(VirtualViewMode.Visible, getContainerRelativeRect(), thresholdRect, true);
                return;
            }
            return;
        }
        if (i == 2) {
            if (virtualViewMode == VirtualViewMode.Visible || (virtualViewModeChangeEmitter2 = this.modeChangeEmitter) == null) {
                return;
            }
            virtualViewModeChangeEmitter2.emitModeChange(VirtualViewMode.Prerender, getContainerRelativeRect(), thresholdRect, false);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        VirtualViewModeChangeEmitter virtualViewModeChangeEmitter3 = this.modeChangeEmitter;
        if (virtualViewModeChangeEmitter3 != null) {
            virtualViewModeChangeEmitter3.emitModeChange(VirtualViewMode.Hidden, getContainerRelativeRect(), thresholdRect, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.views.view.ReactViewGroup, com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set<Integer> excludedViews) {
        if (get_removeClippedSubviews()) {
            if (this.scrollView == null) {
                super.updateClippingRect(excludedViews);
                return;
            }
            Rect clippingRect$ReactAndroid = getClippingRect();
            if (clippingRect$ReactAndroid == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            VirtualViewContainer virtualViewContainer = this.scrollView;
            if (virtualViewContainer == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Intrinsics.checkNotNull(virtualViewContainer, "null cannot be cast to non-null type com.facebook.react.uimanager.ReactClippingViewGroup");
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) virtualViewContainer;
            if (reactClippingViewGroup.get_removeClippedSubviews()) {
                reactClippingViewGroup.getClippingRect(clippingRect$ReactAndroid);
            } else {
                ((View) reactClippingViewGroup).getDrawingRect(clippingRect$ReactAndroid);
            }
            clippingRect$ReactAndroid.intersect(getContainerRelativeRect());
            clippingRect$ReactAndroid.offset(-getContainerRelativeRect().left, -getContainerRelativeRect().top);
            if (Intrinsics.areEqual(this.lastClippingRect, clippingRect$ReactAndroid)) {
                return;
            }
            updateClippingToRect$ReactAndroid(clippingRect$ReactAndroid, excludedViews);
            this.lastClippingRect.set(clippingRect$ReactAndroid);
        }
    }

    private final void updateParentOffset() {
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer == null) {
            return;
        }
        this.offsetX = 0;
        this.offsetY = 0;
        for (ViewParent parent = getParent(); parent != null && !Intrinsics.areEqual(parent, virtualViewContainer); parent = parent.getParent()) {
            if (parent instanceof View) {
                View view = (View) parent;
                this.offsetX += view.getLeft();
                this.offsetY += view.getTop();
            }
        }
        getContainerRelativeRect().set(getLeft() + this.offsetX, getTop() + this.offsetY, getRight() + this.offsetX, getBottom() + this.offsetY);
    }

    private final void reportRectChangeToContainer() {
        VirtualViewContainerState virtualViewContainerState;
        if (Intrinsics.areEqual(this.lastContainerRelativeRect, getContainerRelativeRect())) {
            if (ENABLE_DEBUG_LOGS) {
                FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:reportRectChangeToContainer", "no rect change " + getContainerRelativeRect());
                return;
            }
            return;
        }
        VirtualViewContainer virtualViewContainer = this.scrollView;
        if (virtualViewContainer != null) {
            if (virtualViewContainer != null && (virtualViewContainerState = virtualViewContainer.getVirtualViewContainerState()) != null) {
                virtualViewContainerState.onChange(this);
            }
            this.lastContainerRelativeRect.set(getContainerRelativeRect());
        }
    }

    private final VirtualViewContainer getScrollView() {
        return traverseParentStack(true);
    }

    private final void cleanupLayoutListeners() {
        traverseParentStack(false);
    }

    private final VirtualViewContainer traverseParentStack(boolean addListeners) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof VirtualViewContainer) {
                return (VirtualViewContainer) parent;
            }
            if (parent instanceof ReactRoot) {
                return null;
            }
            if (parent instanceof View) {
                View view = (View) parent;
                ReactVirtualView reactVirtualView = this;
                view.removeOnLayoutChangeListener(reactVirtualView);
                if (addListeners) {
                    view.addOnLayoutChangeListener(reactVirtualView);
                }
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: ReactVirtualView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/views/virtual/view/ReactVirtualView$Companion;", "", "<init>", "()V", "ENABLE_DEBUG_LOGS", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        boolean z = ReactBuildConfig.DEBUG;
        ENABLE_DEBUG_LOGS = false;
    }

    static /* synthetic */ void debugLog$default(ReactVirtualView reactVirtualView, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<String>() { // from class: com.facebook.react.views.virtual.view.ReactVirtualView.debugLog.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + reactVirtualView.getVirtualViewID() + "]:" + str, (String) function0.invoke());
        }
    }

    private final void debugLog(String subtag, Function0<String> block) {
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("ReactVirtualView:[" + getVirtualViewID() + "]:" + subtag, block.invoke());
        }
    }
}
