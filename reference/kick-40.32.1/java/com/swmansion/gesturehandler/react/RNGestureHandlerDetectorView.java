package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerDetectorView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u0019J\"\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\fH\u0016J:\u0010*\u001a\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0002J\u0016\u00101\u001a\u00020\u00172\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0002J\b\u00103\u001a\u00020\u0017H\u0002J\u0012\u00104\u001a\u00020\u00172\n\u00105\u001a\u0006\u0012\u0002\b\u000306J\u0006\u00107\u001a\u00020\u0017J\u000e\u00108\u001a\u00020\u00172\u0006\u0010/\u001a\u000200J\u0012\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b*\u00020\u0019H\u0002J\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\u0019H\u0002J\u000e\u0010;\u001a\u0004\u0018\u00010<*\u00020=H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;", "Lcom/facebook/react/views/view/ReactViewGroup;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "handlersToAttach", "", "", "virtualChildrenToAttach", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView$VirtualChildren;", "nativeHandlers", "", "subscribedHandlers", "attachedHandlers", "subscribedVirtualHandlers", "", "moduleId", "setHandlerTags", "", "handlerTags", "Lcom/facebook/react/bridge/ReadableArray;", "onAttachedToWindow", "onDetachedFromWindow", "requestDisallowInterceptTouchEvent", "disallowIntercept", "", "setModuleId", "id", "setVirtualChildren", "newVirtualChildren", "addView", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "params", "Landroid/view/ViewGroup$LayoutParams;", "removeViewAt", "attachHandlers", "newHandlers", "viewTag", "actionType", "attachReadyHandler", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "attachVirtualChildren", "tryAttachNativeHandlersToChildView", "detachNativeGestureHandlers", "dispatchEvent", "event", "Lcom/facebook/react/uimanager/events/Event;", "detachAllHandlers", "recordHandlerIfNotPresent", "mapVirtualChildren", "toIntList", "tryFindGestureHandlerButton", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Landroid/view/ViewGroup;", "VirtualChildren", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerDetectorView extends ReactViewGroup {
    private Set<Integer> attachedHandlers;
    private List<Integer> handlersToAttach;
    private int moduleId;
    private Set<Integer> nativeHandlers;
    private Set<Integer> subscribedHandlers;
    private Map<Integer, Set<Integer>> subscribedVirtualHandlers;
    private List<VirtualChildren> virtualChildrenToAttach;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNGestureHandlerDetectorView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handlersToAttach = CollectionsKt.emptyList();
        this.virtualChildrenToAttach = CollectionsKt.emptyList();
        this.nativeHandlers = new LinkedHashSet();
        this.subscribedHandlers = new LinkedHashSet();
        this.attachedHandlers = new LinkedHashSet();
        this.subscribedVirtualHandlers = new LinkedHashMap();
        this.moduleId = -1;
    }

    private final ThemedReactContext getReactContext() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        return (ThemedReactContext) context;
    }

    /* JADX INFO: compiled from: RNGestureHandlerDetectorView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView$VirtualChildren;", "", "handlerTags", "", "", "viewTag", "<init>", "(Ljava/util/List;I)V", "getHandlerTags", "()Ljava/util/List;", "getViewTag", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VirtualChildren {
        private final List<Integer> handlerTags;
        private final int viewTag;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VirtualChildren copy$default(VirtualChildren virtualChildren, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = virtualChildren.handlerTags;
            }
            if ((i2 & 2) != 0) {
                i = virtualChildren.viewTag;
            }
            return virtualChildren.copy(list, i);
        }

        public final List<Integer> component1() {
            return this.handlerTags;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getViewTag() {
            return this.viewTag;
        }

        public final VirtualChildren copy(List<Integer> handlerTags, int viewTag) {
            Intrinsics.checkNotNullParameter(handlerTags, "handlerTags");
            return new VirtualChildren(handlerTags, viewTag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VirtualChildren)) {
                return false;
            }
            VirtualChildren virtualChildren = (VirtualChildren) other;
            return Intrinsics.areEqual(this.handlerTags, virtualChildren.handlerTags) && this.viewTag == virtualChildren.viewTag;
        }

        public int hashCode() {
            return (this.handlerTags.hashCode() * 31) + Integer.hashCode(this.viewTag);
        }

        public String toString() {
            return "VirtualChildren(handlerTags=" + this.handlerTags + ", viewTag=" + this.viewTag + ")";
        }

        public VirtualChildren(List<Integer> handlerTags, int i) {
            Intrinsics.checkNotNullParameter(handlerTags, "handlerTags");
            this.handlerTags = handlerTags;
            this.viewTag = i;
        }

        public final List<Integer> getHandlerTags() {
            return this.handlerTags;
        }

        public final int getViewTag() {
            return this.viewTag;
        }
    }

    public final void setHandlerTags(ReadableArray handlerTags) throws Exception {
        ArrayList arrayListEmptyList;
        ArrayList<Object> arrayList;
        if (handlerTags == null || (arrayList = handlerTags.toArrayList()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList<Object> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (Object obj : arrayList2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
                arrayList3.add(Integer.valueOf((int) ((Double) obj).doubleValue()));
            }
            arrayListEmptyList = arrayList3;
        }
        List<Integer> list = arrayListEmptyList;
        this.handlersToAttach = list;
        if (this.moduleId != -1) {
            attachHandlers$default(this, list, 0, 0, null, 14, null);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        if (this.moduleId != -1) {
            attachHandlers$default(this, this.handlersToAttach, 0, 0, null, 14, null);
            attachVirtualChildren(this.virtualChildrenToAttach);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        detachAllHandlers();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView;
        GestureHandlerOrchestrator orchestrator;
        RNGestureHandlerRegistry rNGestureHandlerRegistry;
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        if (!disallowIntercept || (rNGestureHandlerRootViewFindGestureHandlerRootView = RNGestureHandlerRootView.INSTANCE.findGestureHandlerRootView(this)) == null || (orchestrator = rNGestureHandlerRootViewFindGestureHandlerRootView.getOrchestrator()) == null || orchestrator.getIsHandlingTouch() || (rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId))) == null) {
            return;
        }
        Iterator<Integer> it = this.attachedHandlers.iterator();
        while (it.hasNext()) {
            GestureHandler handler = rNGestureHandlerRegistry.getHandler(it.next().intValue());
            if (handler != null) {
                if (handler.getView() == null) {
                    handler = null;
                }
                if (handler != null) {
                    handler.cancel();
                }
            }
        }
    }

    public final void setModuleId(int id) throws Exception {
        if (this.moduleId == id) {
            return;
        }
        this.moduleId = id;
        attachHandlers$default(this, this.handlersToAttach, 0, 0, null, 14, null);
        attachVirtualChildren(this.virtualChildrenToAttach);
    }

    public final void setVirtualChildren(ReadableArray newVirtualChildren) throws Exception {
        List<VirtualChildren> listMapVirtualChildren = newVirtualChildren != null ? mapVirtualChildren(newVirtualChildren) : null;
        if (listMapVirtualChildren == null) {
            listMapVirtualChildren = CollectionsKt.emptyList();
        }
        this.virtualChildrenToAttach = listMapVirtualChildren;
        if (this.moduleId != -1) {
            attachVirtualChildren(listMapVirtualChildren);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) throws Exception {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addView(child, index, params);
        if (!this.nativeHandlers.isEmpty()) {
            getChildCount();
        }
        tryAttachNativeHandlersToChildView(child);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        detachNativeGestureHandlers();
        super.removeViewAt(index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void attachHandlers$default(RNGestureHandlerDetectorView rNGestureHandlerDetectorView, List list, int i, int i2, Set set, int i3, Object obj) throws Exception {
        if ((i3 & 2) != 0) {
            i = rNGestureHandlerDetectorView.getId();
        }
        if ((i3 & 4) != 0) {
            i2 = 5;
        }
        if ((i3 & 8) != 0) {
            set = rNGestureHandlerDetectorView.subscribedHandlers;
        }
        rNGestureHandlerDetectorView.attachHandlers(list, i, i2, set);
    }

    private final void attachHandlers(List<Integer> newHandlers, final int viewTag, final int actionType, Set<Integer> subscribedHandlers) throws Exception {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        Set mutableSet = CollectionsKt.toMutableSet(subscribedHandlers);
        Iterator<Integer> it = newHandlers.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            mutableSet.remove(Integer.valueOf(iIntValue));
            if (!subscribedHandlers.contains(Integer.valueOf(iIntValue))) {
                rNGestureHandlerRegistry.observeHandler(iIntValue, this, new Function1() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerDetectorView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RNGestureHandlerDetectorView.attachHandlers$lambda$0(this.f$0, actionType, viewTag, (GestureHandler) obj);
                    }
                });
                subscribedHandlers.add(Integer.valueOf(iIntValue));
            }
        }
        Iterator it2 = mutableSet.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            rNGestureHandlerRegistry.cancelObservation(iIntValue2, this);
            if (this.attachedHandlers.contains(Integer.valueOf(iIntValue2))) {
                rNGestureHandlerRegistry.detachHandlerFromHostDetector(iIntValue2, this);
                this.attachedHandlers.remove(Integer.valueOf(iIntValue2));
            }
            subscribedHandlers.remove(Integer.valueOf(iIntValue2));
            this.nativeHandlers.remove(Integer.valueOf(iIntValue2));
        }
    }

    static final Unit attachHandlers$lambda$0(RNGestureHandlerDetectorView rNGestureHandlerDetectorView, int i, int i2, GestureHandler handler) throws Exception {
        Intrinsics.checkNotNullParameter(handler, "handler");
        rNGestureHandlerDetectorView.attachReadyHandler(handler, i, i2);
        return Unit.INSTANCE;
    }

    private final void attachReadyHandler(GestureHandler handler, int actionType, int viewTag) throws Exception {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        if (handler.wantsToAttachDirectlyToView() && actionType == 5) {
            getChildCount();
            this.nativeHandlers.add(Integer.valueOf(handler.getTag()));
            if (getChildCount() != 0) {
                View childAt = getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                tryAttachNativeHandlersToChildView(childAt);
                return;
            }
            return;
        }
        rNGestureHandlerRegistry.attachHandlerToView(handler.getTag(), viewTag, actionType, this);
        if (actionType == 6) {
            handler.setHostDetectorView(this);
        }
        this.attachedHandlers.add(Integer.valueOf(handler.getTag()));
    }

    private final void attachVirtualChildren(List<VirtualChildren> virtualChildrenToAttach) throws Exception {
        Set mutableSet = CollectionsKt.toMutableSet(this.subscribedVirtualHandlers.keySet());
        Iterator<VirtualChildren> it = virtualChildrenToAttach.iterator();
        while (it.hasNext()) {
            mutableSet.remove(Integer.valueOf(it.next().getViewTag()));
        }
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        Iterator it2 = mutableSet.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Number) it2.next()).intValue();
            Set<Integer> set = this.subscribedVirtualHandlers.get(Integer.valueOf(iIntValue));
            Intrinsics.checkNotNull(set);
            Iterator<Integer> it3 = set.iterator();
            while (it3.hasNext()) {
                int iIntValue2 = it3.next().intValue();
                rNGestureHandlerRegistry.cancelObservation(iIntValue2, this);
                if (this.attachedHandlers.contains(Integer.valueOf(iIntValue2))) {
                    rNGestureHandlerRegistry.detachHandlerFromHostDetector(iIntValue2, this);
                    this.attachedHandlers.remove(Integer.valueOf(iIntValue2));
                }
            }
            this.subscribedVirtualHandlers.remove(Integer.valueOf(iIntValue));
        }
        for (VirtualChildren virtualChildren : virtualChildrenToAttach) {
            if (!this.subscribedVirtualHandlers.containsKey(Integer.valueOf(virtualChildren.getViewTag()))) {
                this.subscribedVirtualHandlers.put(Integer.valueOf(virtualChildren.getViewTag()), new LinkedHashSet());
            }
            List<Integer> handlerTags = virtualChildren.getHandlerTags();
            int viewTag = virtualChildren.getViewTag();
            Set<Integer> set2 = this.subscribedVirtualHandlers.get(Integer.valueOf(virtualChildren.getViewTag()));
            Intrinsics.checkNotNull(set2);
            attachHandlers(handlerTags, viewTag, 6, set2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    private final void tryAttachNativeHandlersToChildView(View child) throws Exception {
        int id;
        if (this.nativeHandlers.isEmpty()) {
            return;
        }
        getChildCount();
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        if (child instanceof ReactSwipeRefreshLayout) {
            id = ((ReactSwipeRefreshLayout) child).getChildAt(0).getId();
        } else if (!(child instanceof ViewGroup)) {
            id = child.getId();
        } else {
            ViewGroup viewGroup = (ViewGroup) child;
            if (viewGroup.getChildCount() != 0) {
                RNGestureHandlerButtonViewManager.ButtonViewGroup buttonViewGroupTryFindGestureHandlerButton = tryFindGestureHandlerButton(viewGroup);
                id = buttonViewGroupTryFindGestureHandlerButton != null ? buttonViewGroupTryFindGestureHandlerButton.getId() : viewGroup.getId();
            } else {
                id = child.getId();
            }
        }
        Iterator<Integer> it = this.nativeHandlers.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (rNGestureHandlerRegistry.getHandler(iIntValue) != null) {
                rNGestureHandlerRegistry.attachHandlerToView(iIntValue, id, 5, this);
                this.attachedHandlers.add(Integer.valueOf(iIntValue));
            }
        }
    }

    private final void detachNativeGestureHandlers() {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            return;
        }
        Iterator<Integer> it = this.nativeHandlers.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (this.attachedHandlers.contains(Integer.valueOf(iIntValue))) {
                rNGestureHandlerRegistry.detachHandlerFromHostDetector(iIntValue, this);
                this.attachedHandlers.remove(Integer.valueOf(iIntValue));
            }
        }
    }

    public final void dispatchEvent(Event<?> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(getReactContext(), getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    public final void detachAllHandlers() {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry != null) {
            rNGestureHandlerRegistry.cancelAllObservationsForOwner(this);
            Iterator<Integer> it = this.attachedHandlers.iterator();
            while (it.hasNext()) {
                rNGestureHandlerRegistry.detachHandlerFromHostDetector(it.next().intValue(), this);
            }
        }
        this.attachedHandlers.clear();
        this.subscribedVirtualHandlers.clear();
        this.subscribedHandlers.clear();
        this.nativeHandlers.clear();
    }

    public final void recordHandlerIfNotPresent(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView = RNGestureHandlerRootView.INSTANCE.findGestureHandlerRootView(this);
        if (rNGestureHandlerRootViewFindGestureHandlerRootView != null) {
            rNGestureHandlerRootViewFindGestureHandlerRootView.recordHandlerIfNotPresent(handler);
        }
    }

    private final List<VirtualChildren> mapVirtualChildren(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            VirtualChildren virtualChildren = null;
            if (map != null) {
                ReadableArray array = map.getArray("handlerTags");
                List<Integer> intList = array != null ? toIntList(array) : null;
                if (intList == null) {
                    intList = CollectionsKt.emptyList();
                }
                virtualChildren = new VirtualChildren(intList, map.getInt("viewTag"));
            }
            arrayList.add(virtualChildren);
        }
        return CollectionsKt.filterNotNull(arrayList);
    }

    private final List<Integer> toIntList(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(readableArray.getInt(i)));
        }
        return arrayList;
    }

    private final RNGestureHandlerButtonViewManager.ButtonViewGroup tryFindGestureHandlerButton(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return null;
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof RNGestureHandlerButtonViewManager.ButtonViewGroup) {
            return (RNGestureHandlerButtonViewManager.ButtonViewGroup) childAt;
        }
        return null;
    }
}
