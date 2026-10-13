package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerRegistry.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J*\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\bJ*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\u000fJ\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010'\u001a\u00020(H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\b\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "<init>", "()V", "handlers", "Landroid/util/SparseArray;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "attachedTo", "", "handlersForView", "Ljava/util/ArrayList;", "observers", "", "", "Lkotlin/Function1;", "", "registerHandler", "handler", "observeHandler", "tag", "owner", "block", "cancelObservation", "cancelAllObservationsForOwner", "getHandler", "handlerTag", "attachHandlerToView", "", "viewTag", "actionType", "hostDetectorView", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerDetectorView;", "registerHandlerForViewWithTag", "detachHandlerInternal", "detachHandlerFromHostDetector", "dropHandler", "dropAllHandlers", "getHandlersForViewWithTag", "getHandlersForView", "view", "Landroid/view/View;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    private final SparseArray<GestureHandler> handlers = new SparseArray<>();
    private final SparseArray<Integer> attachedTo = new SparseArray<>();
    private final SparseArray<ArrayList<GestureHandler>> handlersForView = new SparseArray<>();
    private final Map<Integer, Map<Object, Function1<GestureHandler, Unit>>> observers = new LinkedHashMap();

    public final void registerHandler(final GestureHandler handler) {
        boolean z;
        Intrinsics.checkNotNullParameter(handler, "handler");
        synchronized (this) {
            this.handlers.put(handler.getTag(), handler);
            Map<Object, Function1<GestureHandler, Unit>> map = this.observers.get(Integer.valueOf(handler.getTag()));
            z = false;
            if (map != null && (!map.isEmpty())) {
                z = true;
            }
        }
        if (z) {
            final Function0 function0 = new Function0() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RNGestureHandlerRegistry.registerHandler$lambda$1(this.f$0, handler);
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                function0.invoke();
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
            }
        }
    }

    static final Unit registerHandler$lambda$1(RNGestureHandlerRegistry rNGestureHandlerRegistry, GestureHandler gestureHandler) {
        List list;
        Collection<Function1<GestureHandler, Unit>> collectionValues;
        synchronized (rNGestureHandlerRegistry) {
            Map<Object, Function1<GestureHandler, Unit>> map = rNGestureHandlerRegistry.observers.get(Integer.valueOf(gestureHandler.getTag()));
            list = (map == null || (collectionValues = map.values()) == null) ? null : CollectionsKt.toList(collectionValues);
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(gestureHandler);
        }
        return Unit.INSTANCE;
    }

    public final void observeHandler(int tag, Object owner, Function1<? super GestureHandler, Unit> block) {
        GestureHandler gestureHandler;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this) {
            Map<Integer, Map<Object, Function1<GestureHandler, Unit>>> map = this.observers;
            Integer numValueOf = Integer.valueOf(tag);
            LinkedHashMap linkedHashMap = map.get(numValueOf);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                map.put(numValueOf, linkedHashMap);
            }
            linkedHashMap.put(owner, block);
            gestureHandler = this.handlers.get(tag);
        }
        if (gestureHandler != null) {
            block.invoke(gestureHandler);
        }
    }

    public final synchronized void cancelObservation(int tag, Object owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Map<Object, Function1<GestureHandler, Unit>> map = this.observers.get(Integer.valueOf(tag));
        if (map == null) {
            return;
        }
        map.remove(owner);
        if (map.isEmpty()) {
            this.observers.remove(Integer.valueOf(tag));
        }
    }

    public final synchronized void cancelAllObservationsForOwner(Object owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Iterator<Map.Entry<Integer, Map<Object, Function1<GestureHandler, Unit>>>> it = this.observers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Map<Object, Function1<GestureHandler, Unit>>> next = it.next();
            next.getValue().remove(owner);
            if (next.getValue().isEmpty()) {
                it.remove();
            }
        }
    }

    public final synchronized GestureHandler getHandler(int handlerTag) {
        return this.handlers.get(handlerTag);
    }

    public static /* synthetic */ boolean attachHandlerToView$default(RNGestureHandlerRegistry rNGestureHandlerRegistry, int i, int i2, int i3, RNGestureHandlerDetectorView rNGestureHandlerDetectorView, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            rNGestureHandlerDetectorView = null;
        }
        return rNGestureHandlerRegistry.attachHandlerToView(i, i2, i3, rNGestureHandlerDetectorView);
    }

    public final synchronized boolean attachHandlerToView(int handlerTag, int viewTag, int actionType, RNGestureHandlerDetectorView hostDetectorView) {
        boolean z;
        GestureHandler gestureHandler = this.handlers.get(handlerTag);
        if (gestureHandler != null) {
            detachHandlerInternal(gestureHandler);
            gestureHandler.setActionType(actionType);
            gestureHandler.setHostDetectorView(hostDetectorView);
            registerHandlerForViewWithTag(viewTag, gestureHandler);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private final synchronized void registerHandlerForViewWithTag(int viewTag, GestureHandler handler) {
        if (this.attachedTo.get(handler.getTag()) != null) {
            throw new IllegalStateException(("Handler " + handler + " already attached").toString());
        }
        this.attachedTo.put(handler.getTag(), Integer.valueOf(viewTag));
        ArrayList<GestureHandler> arrayList = this.handlersForView.get(viewTag);
        if (arrayList == null) {
            ArrayList<GestureHandler> arrayList2 = new ArrayList<>(1);
            arrayList2.add(handler);
            this.handlersForView.put(viewTag, arrayList2);
        } else {
            synchronized (arrayList) {
                Boolean.valueOf(arrayList.add(handler));
            }
        }
    }

    private final synchronized void detachHandlerInternal(final GestureHandler handler) {
        Integer num = this.attachedTo.get(handler.getTag());
        if (num != null) {
            this.attachedTo.remove(handler.getTag());
            ArrayList<GestureHandler> arrayList = this.handlersForView.get(num.intValue());
            if (arrayList != null) {
                synchronized (arrayList) {
                    arrayList.remove(handler);
                }
                if (arrayList.size() == 0) {
                    this.handlersForView.remove(num.intValue());
                }
            }
        }
        if (handler.getView() != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    handler.cancel();
                }
            });
        }
    }

    public final synchronized void detachHandlerFromHostDetector(int handlerTag, RNGestureHandlerDetectorView hostDetectorView) {
        GestureHandler gestureHandler = this.handlers.get(handlerTag);
        if (gestureHandler != null) {
            if (!Intrinsics.areEqual(gestureHandler.getHostDetectorView(), hostDetectorView)) {
            } else {
                detachHandlerInternal(gestureHandler);
            }
        }
    }

    public final synchronized void dropHandler(int handlerTag) {
        GestureHandler gestureHandler = this.handlers.get(handlerTag);
        if (gestureHandler != null) {
            detachHandlerInternal(gestureHandler);
            this.handlers.remove(handlerTag);
        }
    }

    public final synchronized void dropAllHandlers() {
        this.handlers.clear();
        this.attachedTo.clear();
        this.handlersForView.clear();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerRegistry
    public synchronized ArrayList<GestureHandler> getHandlersForViewWithTag(int viewTag) {
        return this.handlersForView.get(viewTag);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerRegistry
    public synchronized ArrayList<GestureHandler> getHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return getHandlersForViewWithTag(view.getId());
    }
}
