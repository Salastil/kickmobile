package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSPointerDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0015J(\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020%H\u0002J(\u0010&\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002J\"\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u001e\u0010-\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020,J(\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J(\u00101\u001a\u00020\u00152\u0006\u00100\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J*\u00102\u001a\u00020\u00152\b\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/facebook/react/uimanager/JSPointerDispatcher;", "", "rootViewGroup", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "lastHitPathByPointerId", "", "", "", "Lcom/facebook/react/uimanager/TouchTargetHelper$ViewTarget;", "lastEventCoordinatesByPointerId", "", "currentlyDownPointerIdsToHitPath", "hoveringPointerIds", "", "childHandlingNativeGesture", "primaryPointerId", "coalescingKey", "lastButtonState", "onChildStartedNativeGesture", "", "childView", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "convertMotionToRootFrame", "childMotion", "onChildEndedNativeGesture", "onUp", "activeTargetTag", "eventState", "Lcom/facebook/react/uimanager/events/PointerEvent$PointerEventState;", "incrementCoalescingKey", "getCoalescingKey", "", "onDown", "eventCoordsToScreenCoords", "eventCoords", "createEventState", "activePointerId", "clearHitPathForActivePointer", "", "handleMotionEvent", "isCapture", "handleHitStateDivergence", "targetTag", "onMove", "dispatchCancelEventForTarget", "targetView", "getChildOffsetRelativeToRoot", "Landroid/graphics/Rect;", "normalizeToRoot", "original", "rootX", "", "rootY", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JSPointerDispatcher {
    private static final float ONMOVE_EPSILON = 0.1f;
    private static final String TAG = "PointerEvents";
    private static final int UNSELECTED_VIEW_TAG = -1;
    private static final int UNSET_CHILD_VIEW_ID = -1;
    private static final int UNSET_POINTER_ID = -1;
    private int childHandlingNativeGesture;
    private int coalescingKey;
    private final Map<Integer, List<TouchTargetHelper.ViewTarget>> currentlyDownPointerIdsToHitPath;
    private final Set<Integer> hoveringPointerIds;
    private int lastButtonState;
    private Map<Integer, float[]> lastEventCoordinatesByPointerId;
    private Map<Integer, List<TouchTargetHelper.ViewTarget>> lastHitPathByPointerId;
    private int primaryPointerId;
    private final ViewGroup rootViewGroup;
    private static final Companion Companion = new Companion(null);
    private static final int[] rootScreenCoords = {0, 0};
    private static final Rect childCoords = new Rect(0, 0, 1, 1);

    public JSPointerDispatcher(ViewGroup rootViewGroup) {
        Intrinsics.checkNotNullParameter(rootViewGroup, "rootViewGroup");
        this.rootViewGroup = rootViewGroup;
        this.currentlyDownPointerIdsToHitPath = new HashMap();
        this.hoveringPointerIds = new HashSet();
        this.childHandlingNativeGesture = -1;
        this.primaryPointerId = -1;
    }

    public final void onChildStartedNativeGesture(View childView, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        if (this.childHandlingNativeGesture != -1 || childView == null) {
            return;
        }
        MotionEvent motionEventConvertMotionToRootFrame = convertMotionToRootFrame(childView, motionEvent);
        motionEventConvertMotionToRootFrame.setAction(3);
        handleMotionEvent(motionEventConvertMotionToRootFrame, eventDispatcher, false);
        this.childHandlingNativeGesture = childView.getId();
    }

    private final MotionEvent convertMotionToRootFrame(View childView, MotionEvent childMotion) {
        MotionEvent motionEventObtain = MotionEvent.obtain(childMotion);
        int[] iArr = new int[2];
        this.rootViewGroup.getLocationOnScreen(iArr);
        motionEventObtain.setLocation(childMotion.getRawX() - iArr[0], childMotion.getRawY() - iArr[1]);
        Intrinsics.checkNotNull(motionEventObtain);
        return motionEventObtain;
    }

    public final void onChildEndedNativeGesture() {
        this.childHandlingNativeGesture = -1;
    }

    private final void onUp(int activeTargetTag, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        int i;
        PointerEvent.PointerEventState pointerEventState;
        MotionEvent motionEvent2;
        EventDispatcher eventDispatcher2;
        int activePointerId = eventState.getActivePointerId();
        List<TouchTargetHelper.ViewTarget> listEmptyList = eventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Companion companion = Companion;
        if (companion.isAnyoneListeningForBubblingEvent(listEmptyList, PointerEventHelper.EVENT.UP, PointerEventHelper.EVENT.UP_CAPTURE)) {
            i = activeTargetTag;
            pointerEventState = eventState;
            motionEvent2 = motionEvent;
            eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_UP, i, eventState, motionEvent, ReactNativeFeatureFlags.cxxNativeAnimatedEnabled() ? eventState.getHitPathViewIdsForActivePointer() : null));
        } else {
            i = activeTargetTag;
            pointerEventState = eventState;
            motionEvent2 = motionEvent;
        }
        if (this.hoveringPointerIds.contains(Integer.valueOf(activePointerId))) {
            eventDispatcher2 = eventDispatcher;
        } else {
            if (companion.isAnyoneListeningForBubblingEvent(listEmptyList, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_OUT, i, pointerEventState, motionEvent2));
            }
            eventDispatcher2 = eventDispatcher;
            companion.dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent2, companion.filterByShouldDispatch(listEmptyList, PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, false), eventDispatcher2);
        }
        List<TouchTargetHelper.ViewTarget> listRemove = this.currentlyDownPointerIdsToHitPath.remove(Integer.valueOf(activePointerId));
        if (listRemove != null && companion.isAnyoneListeningForBubblingEvent(listEmptyList, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            List listFindHitPathIntersection = companion.findHitPathIntersection(listRemove, listEmptyList);
            if (!listFindHitPathIntersection.isEmpty()) {
                eventDispatcher2.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.CLICK, ((TouchTargetHelper.ViewTarget) listFindHitPathIntersection.get(0)).getViewId(), pointerEventState, motionEvent2));
            }
        }
        if (motionEvent2.getActionMasked() == 1) {
            this.primaryPointerId = -1;
        }
        this.hoveringPointerIds.remove(Integer.valueOf(activePointerId));
    }

    private final void incrementCoalescingKey() {
        this.coalescingKey = (this.coalescingKey + 1) % Integer.MAX_VALUE;
    }

    private final short getCoalescingKey() {
        return (short) (this.coalescingKey & 65535);
    }

    private final void onDown(int activeTargetTag, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        MotionEvent motionEvent2;
        List<TouchTargetHelper.ViewTarget> listEmptyList = eventState.getHitPathByPointerId().get(Integer.valueOf(eventState.getActivePointerId()));
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<TouchTargetHelper.ViewTarget> list = listEmptyList;
        incrementCoalescingKey();
        if (!this.hoveringPointerIds.contains(Integer.valueOf(eventState.getActivePointerId()))) {
            Companion companion = Companion;
            if (companion.isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                motionEvent2 = motionEvent;
                eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_OVER, activeTargetTag, eventState, motionEvent2));
            } else {
                motionEvent2 = motionEvent;
            }
            List listFilterByShouldDispatch = companion.filterByShouldDispatch(list, PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, false);
            CollectionsKt.reverse(listFilterByShouldDispatch);
            companion.dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, eventState, motionEvent2, listFilterByShouldDispatch, eventDispatcher);
        }
        Companion companion2 = Companion;
        if (companion2.isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            this.currentlyDownPointerIdsToHitPath.put(Integer.valueOf(eventState.getActivePointerId()), new ArrayList(list));
        }
        if (companion2.isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.DOWN, PointerEventHelper.EVENT.DOWN_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_DOWN, activeTargetTag, eventState, motionEvent, ReactNativeFeatureFlags.cxxNativeAnimatedEnabled() ? eventState.getHitPathViewIdsForActivePointer() : null));
        }
    }

    private final float[] eventCoordsToScreenCoords(float[] eventCoords) {
        ViewGroup viewGroup = this.rootViewGroup;
        int[] iArr = rootScreenCoords;
        viewGroup.getLocationOnScreen(iArr);
        return new float[]{eventCoords[0] + iArr[0], eventCoords[1] + iArr[1]};
    }

    static /* synthetic */ PointerEvent.PointerEventState createEventState$default(JSPointerDispatcher jSPointerDispatcher, int i, MotionEvent motionEvent, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return jSPointerDispatcher.createEventState(i, motionEvent, z);
    }

    private final PointerEvent.PointerEventState createEventState(int activePointerId, MotionEvent motionEvent, boolean clearHitPathForActivePointer) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            float[] fArr = new float[2];
            float[] fArr2 = {motionEvent.getX(i), motionEvent.getY(i)};
            List<TouchTargetHelper.ViewTarget> listFindTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(fArr2[0], fArr2[1], this.rootViewGroup, fArr);
            int pointerId = motionEvent.getPointerId(i);
            map.put(Integer.valueOf(pointerId), fArr);
            map2.put(Integer.valueOf(pointerId), listFindTargetPathAndCoordinatesForTouch);
            map3.put(Integer.valueOf(pointerId), fArr2);
            map4.put(Integer.valueOf(pointerId), eventCoordsToScreenCoords(fArr2));
        }
        if (clearHitPathForActivePointer) {
            map2.put(Integer.valueOf(activePointerId), CollectionsKt.emptyList());
        }
        return new PointerEvent.PointerEventState(this.primaryPointerId, activePointerId, this.lastButtonState, UIManagerHelper.getSurfaceId(this.rootViewGroup), map, map2, map3, map4, this.hoveringPointerIds);
    }

    public final void handleMotionEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher, boolean isCapture) {
        int viewId;
        View view;
        float[] fArr;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        if (this.childHandlingNativeGesture != -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 10 || motionEvent.getButtonState() == 0) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (actionMasked == 0) {
                this.primaryPointerId = motionEvent.getPointerId(0);
            } else if (actionMasked == 7) {
                this.hoveringPointerIds.add(Integer.valueOf(pointerId));
            }
            boolean z = isCapture && actionMasked == 10;
            PointerEvent.PointerEventState pointerEventStateCreateEventState = createEventState(pointerId, motionEvent, z);
            if (z) {
                Map<Integer, List<TouchTargetHelper.ViewTarget>> map = this.lastHitPathByPointerId;
                List<TouchTargetHelper.ViewTarget> list = map != null ? map.get(Integer.valueOf(pointerEventStateCreateEventState.getActivePointerId())) : null;
                List<TouchTargetHelper.ViewTarget> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                TouchTargetHelper.ViewTarget viewTarget = list.get(list.size() - 1);
                viewId = viewTarget.getViewId();
                view = viewTarget.getView();
            } else {
                List<TouchTargetHelper.ViewTarget> list3 = pointerEventStateCreateEventState.getHitPathByPointerId().get(Integer.valueOf(pointerId));
                List<TouchTargetHelper.ViewTarget> list4 = list3;
                if (list4 == null || list4.isEmpty()) {
                    return;
                }
                TouchTargetHelper.ViewTarget viewTarget2 = list3.get(0);
                viewId = viewTarget2.getViewId();
                view = viewTarget2.getView();
            }
            handleHitStateDivergence(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
            switch (actionMasked) {
                case 0:
                case 5:
                    onDown(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 1:
                case 6:
                    incrementCoalescingKey();
                    onUp(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 2:
                    onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 3:
                    dispatchCancelEventForTarget(view, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    handleHitStateDivergence(-1, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                case 4:
                case 8:
                default:
                    FLog.w(ReactConstants.TAG, "Motion Event was ignored. Action=" + actionMasked + " Target=" + viewId);
                    return;
                case 7:
                    float[] fArr2 = pointerEventStateCreateEventState.getEventCoordinatesByPointerId().get(Integer.valueOf(pointerId));
                    Map<Integer, float[]> map2 = this.lastEventCoordinatesByPointerId;
                    if (map2 == null || (fArr = map2.get(Integer.valueOf(pointerId))) == null) {
                        fArr = new float[]{0.0f, 0.0f};
                    }
                    if (fArr2 == null || !Companion.qualifiedMove(fArr2, fArr)) {
                        return;
                    } else {
                        onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    }
                    break;
                case 9:
                    return;
                case 10:
                    if (z) {
                        onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    }
                    break;
            }
            HashMap map3 = new HashMap(pointerEventStateCreateEventState.getEventCoordinatesByPointerId());
            this.lastEventCoordinatesByPointerId = map3;
            this.lastButtonState = motionEvent.getButtonState();
            Set setKeySet = map3.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            this.hoveringPointerIds.retainAll(setKeySet);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a  */
    private final void handleHitStateDivergence(int targetTag, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int activePointerId = eventState.getActivePointerId();
        if (targetTag == -1 || (arrayList = eventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId))) == null) {
            arrayList = new ArrayList();
        }
        List<TouchTargetHelper.ViewTarget> list = arrayList;
        Map<Integer, List<TouchTargetHelper.ViewTarget>> map = this.lastHitPathByPointerId;
        if (map != null) {
            if (!map.containsKey(Integer.valueOf(activePointerId)) || (arrayList2 = map.get(Integer.valueOf(activePointerId))) == null) {
                ArrayList arrayList3 = new ArrayList();
                arrayList2 = arrayList3;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
            } else if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
        } else {
            arrayList2 = new ArrayList();
        }
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (i < Math.min(list.size(), arrayList2.size()) && Intrinsics.areEqual(list.get((list.size() - 1) - i), arrayList2.get((arrayList2.size() - 1) - i))) {
            View view = list.get((list.size() - 1) - i).getView();
            if (!z2 && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.ENTER_CAPTURE)) {
                z2 = true;
            }
            if (!z && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.LEAVE_CAPTURE)) {
                z = true;
            }
            i++;
        }
        if (i < Math.max(list.size(), arrayList2.size())) {
            incrementCoalescingKey();
            if (!arrayList2.isEmpty()) {
                int viewId = arrayList2.get(0).getViewId();
                Companion companion = Companion;
                if (companion.isAnyoneListeningForBubblingEvent(arrayList2, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                    eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_OUT, viewId, eventState, motionEvent));
                }
                List listFilterByShouldDispatch = companion.filterByShouldDispatch(arrayList2.subList(0, arrayList2.size() - i), PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, z);
                if (!listFilterByShouldDispatch.isEmpty()) {
                    companion.dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, eventState, motionEvent, listFilterByShouldDispatch, eventDispatcher);
                }
            }
            Companion companion2 = Companion;
            if (companion2.isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_OVER, targetTag, eventState, motionEvent));
            }
            List listFilterByShouldDispatch2 = companion2.filterByShouldDispatch(list.subList(0, list.size() - i), PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, z2);
            if (!listFilterByShouldDispatch2.isEmpty()) {
                CollectionsKt.reverse(listFilterByShouldDispatch2);
                companion2.dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, eventState, motionEvent, listFilterByShouldDispatch2, eventDispatcher);
            }
        }
        HashMap map2 = new HashMap(eventState.getHitPathByPointerId());
        if (targetTag == -1) {
            map2.remove(Integer.valueOf(activePointerId));
        }
        this.lastHitPathByPointerId = map2;
    }

    private final void onMove(int targetTag, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List<TouchTargetHelper.ViewTarget> listEmptyList = eventState.getHitPathByPointerId().get(Integer.valueOf(eventState.getActivePointerId()));
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (Companion.isAnyoneListeningForBubblingEvent(listEmptyList, PointerEventHelper.EVENT.MOVE, PointerEventHelper.EVENT.MOVE_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_MOVE, targetTag, eventState, motionEvent, getCoalescingKey()));
        }
    }

    private final void dispatchCancelEventForTarget(View targetView, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Assertions.assertCondition(this.childHandlingNativeGesture == -1, "Expected to not have already sent a cancel for this gesture");
        List<TouchTargetHelper.ViewTarget> listEmptyList = eventState.getHitPathByPointerId().get(Integer.valueOf(eventState.getActivePointerId()));
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty() || targetView == null) {
            return;
        }
        if (Companion.isAnyoneListeningForBubblingEvent(listEmptyList, PointerEventHelper.EVENT.CANCEL, PointerEventHelper.EVENT.CANCEL_CAPTURE)) {
            int viewId = listEmptyList.get(0).getViewId();
            Rect childOffsetRelativeToRoot = getChildOffsetRelativeToRoot(targetView);
            ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(PointerEvent.INSTANCE.obtain(PointerEventHelper.POINTER_CANCEL, viewId, normalizeToRoot(eventState, childOffsetRelativeToRoot.left, childOffsetRelativeToRoot.top), motionEvent));
        }
        incrementCoalescingKey();
        this.primaryPointerId = -1;
    }

    private final Rect getChildOffsetRelativeToRoot(View childView) {
        Rect rect = childCoords;
        rect.set(0, 0, 1, 1);
        if (childView.getRootView() != this.rootViewGroup.getRootView()) {
            return rect;
        }
        this.rootViewGroup.offsetDescendantRectToMyCoords(childView, rect);
        return rect;
    }

    private final PointerEvent.PointerEventState normalizeToRoot(PointerEvent.PointerEventState original, float rootX, float rootY) {
        HashMap map = new HashMap(original.getOffsetByPointerId());
        HashMap map2 = new HashMap(original.getEventCoordinatesByPointerId());
        HashMap map3 = new HashMap(original.getScreenCoordinatesByPointerId());
        float[] fArr = {rootX, rootY};
        for (Object obj : map.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            ((Map.Entry) obj).setValue(fArr);
        }
        float[] fArr2 = {0.0f, 0.0f};
        for (Object obj2 : map2.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(obj2, "next(...)");
            ((Map.Entry) obj2).setValue(fArr2);
        }
        float[] fArrEventCoordsToScreenCoords = eventCoordsToScreenCoords(fArr);
        for (Object obj3 : map3.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(obj3, "next(...)");
            ((Map.Entry) obj3).setValue(fArrEventCoordsToScreenCoords);
        }
        return new PointerEvent.PointerEventState(original.getPrimaryPointerId(), original.getActivePointerId(), original.getLastButtonState(), original.getSurfaceId(), map, new HashMap(original.getHitPathByPointerId()), map2, map3, new HashSet(original.getHoveringPointerIds()));
    }

    /* JADX INFO: compiled from: JSPointerDispatcher.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J&\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0016H\u0002J6\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/react/uimanager/JSPointerDispatcher$Companion;", "", "<init>", "()V", "UNSELECTED_VIEW_TAG", "", "UNSET_POINTER_ID", "UNSET_CHILD_VIEW_ID", "ONMOVE_EPSILON", "", "TAG", "", "rootScreenCoords", "", "childCoords", "Landroid/graphics/Rect;", "findHitPathIntersection", "", "Lcom/facebook/react/uimanager/TouchTargetHelper$ViewTarget;", "hitsA", "hitsB", "isAnyoneListeningForBubblingEvent", "", "hitPath", "event", "Lcom/facebook/react/uimanager/events/PointerEventHelper$EVENT;", "captureEvent", "filterByShouldDispatch", "", "viewTargets", "bubble", "capture", "forceDispatch", "dispatchEventForViewTargets", "", "eventName", "eventState", "Lcom/facebook/react/uimanager/events/PointerEvent$PointerEventState;", "motionEvent", "Landroid/view/MotionEvent;", "dispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "qualifiedMove", "eventCoordinates", "", "lastEventCoordinates", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TouchTargetHelper.ViewTarget> findHitPathIntersection(List<TouchTargetHelper.ViewTarget> hitsA, List<TouchTargetHelper.ViewTarget> hitsB) {
            if (hitsA.isEmpty()) {
                return new ArrayList();
            }
            if (hitsB.isEmpty()) {
                return new ArrayList();
            }
            HashSet hashSet = new HashSet(hitsA);
            ArrayList arrayList = new ArrayList();
            for (TouchTargetHelper.ViewTarget viewTarget : hitsB) {
                if (hashSet.contains(viewTarget)) {
                    arrayList.add(viewTarget);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAnyoneListeningForBubblingEvent(List<TouchTargetHelper.ViewTarget> hitPath, PointerEventHelper.EVENT event, PointerEventHelper.EVENT captureEvent) {
            for (TouchTargetHelper.ViewTarget viewTarget : hitPath) {
                if (PointerEventHelper.isListening(viewTarget.getView(), event) || PointerEventHelper.isListening(viewTarget.getView(), captureEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TouchTargetHelper.ViewTarget> filterByShouldDispatch(List<TouchTargetHelper.ViewTarget> viewTargets, PointerEventHelper.EVENT bubble, PointerEventHelper.EVENT capture, boolean forceDispatch) {
            ArrayList arrayList = new ArrayList(viewTargets);
            if (forceDispatch) {
                return arrayList;
            }
            boolean z = false;
            for (int size = viewTargets.size() - 1; -1 < size; size--) {
                View view = viewTargets.get(size).getView();
                if (!z && !PointerEventHelper.isListening(view, capture) && !PointerEventHelper.isListening(view, bubble)) {
                    arrayList.remove(size);
                } else if (!z && PointerEventHelper.isListening(view, capture)) {
                    z = true;
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void dispatchEventForViewTargets(String eventName, PointerEvent.PointerEventState eventState, MotionEvent motionEvent, List<TouchTargetHelper.ViewTarget> viewTargets, EventDispatcher dispatcher) {
            Iterator<TouchTargetHelper.ViewTarget> it = viewTargets.iterator();
            while (it.hasNext()) {
                dispatcher.dispatchEvent(PointerEvent.INSTANCE.obtain(eventName, it.next().getViewId(), eventState, motionEvent));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean qualifiedMove(float[] eventCoordinates, float[] lastEventCoordinates) {
            return Math.abs(lastEventCoordinates[0] - eventCoordinates[0]) > 0.1f || Math.abs(lastEventCoordinates[1] - eventCoordinates[1]) > 0.1f;
        }
    }
}
