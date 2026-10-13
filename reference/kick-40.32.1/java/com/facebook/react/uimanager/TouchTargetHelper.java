package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.touch.ReactHitSlopView;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchTargetHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u000212B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J2\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0007J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0003J8\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"H\u0002J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J0\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0007H\u0002J,\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"H\u0002J \u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/facebook/react/uimanager/TouchTargetHelper;", "", "<init>", "()V", "eventCoords", "", "tempPoint", "Landroid/graphics/PointF;", "matrixTransformCoords", "inverseMatrix", "Landroid/graphics/Matrix;", "findTargetTagForTouch", "", "eventX", "", "eventY", "viewGroup", "Landroid/view/ViewGroup;", "nativeViewId", "", "findTargetTagAndCoordinatesForTouch", "viewCoords", "nativeViewTag", "findTargetPathAndCoordinatesForTouch", "", "Lcom/facebook/react/uimanager/TouchTargetHelper$ViewTarget;", "findClosestReactAncestor", "Landroid/view/View;", "view", "findTouchTargetView", "allowReturnTouchTargetTypes", "Ljava/util/EnumSet;", "Lcom/facebook/react/uimanager/TouchTargetHelper$TouchTargetReturnType;", "pathAccumulator", "", "isTouchPointInView", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "isTouchPointInViewWithOverflowInset", "getChildPoint", "parent", "child", "outLocalPoint", "findTouchTargetViewWithPointerEvents", "getTouchTargetForView", "targetView", "viewX", "viewY", "TouchTargetReturnType", "ViewTarget", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TouchTargetHelper {
    public static final TouchTargetHelper INSTANCE = new TouchTargetHelper();
    private static final float[] eventCoords = new float[2];
    private static final PointF tempPoint = new PointF();
    private static final float[] matrixTransformCoords = new float[2];
    private static final Matrix inverseMatrix = new Matrix();

    /* JADX INFO: compiled from: TouchTargetHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/uimanager/TouchTargetHelper$TouchTargetReturnType;", "", "<init>", "(Ljava/lang/String;I)V", "SELF", "CHILD", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private enum TouchTargetReturnType {
        SELF,
        CHILD;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<TouchTargetReturnType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TouchTargetHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEvents.values().length];
            try {
                iArr[PointerEvents.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEvents.BOX_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEvents.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEvents.BOX_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TouchTargetHelper() {
    }

    @JvmStatic
    public static final int findTargetTagForTouch(float eventX, float eventY, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return findTargetTagAndCoordinatesForTouch(eventX, eventY, viewGroup, eventCoords, null);
    }

    @JvmStatic
    public static final int findTargetTagForTouch(float eventX, float eventY, ViewGroup viewGroup, int[] nativeViewId) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return findTargetTagAndCoordinatesForTouch(eventX, eventY, viewGroup, eventCoords, nativeViewId);
    }

    @JvmStatic
    public static final int findTargetTagAndCoordinatesForTouch(float eventX, float eventY, ViewGroup viewGroup, float[] viewCoords, int[] nativeViewTag) {
        View viewFindClosestReactAncestor;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewCoords, "viewCoords");
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        viewCoords[0] = eventX;
        viewCoords[1] = eventY;
        TouchTargetHelper touchTargetHelper = INSTANCE;
        View viewFindTouchTargetViewWithPointerEvents$default = findTouchTargetViewWithPointerEvents$default(touchTargetHelper, viewCoords, viewGroup, null, 4, null);
        if (viewFindTouchTargetViewWithPointerEvents$default == null || (viewFindClosestReactAncestor = touchTargetHelper.findClosestReactAncestor(viewFindTouchTargetViewWithPointerEvents$default)) == null) {
            return id;
        }
        if (nativeViewTag != null) {
            nativeViewTag[0] = viewFindClosestReactAncestor.getId();
        }
        return touchTargetHelper.getTouchTargetForView(viewFindClosestReactAncestor, viewCoords[0], viewCoords[1]);
    }

    @JvmStatic
    public static final List<ViewTarget> findTargetPathAndCoordinatesForTouch(float eventX, float eventY, ViewGroup viewGroup, float[] viewCoords) {
        int touchTargetForView;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewCoords, "viewCoords");
        UiThreadUtil.assertOnUiThread();
        viewCoords[0] = eventX;
        viewCoords[1] = eventY;
        ArrayList arrayList = new ArrayList();
        View viewFindTouchTargetViewWithPointerEvents = INSTANCE.findTouchTargetViewWithPointerEvents(viewCoords, viewGroup, arrayList);
        if (viewFindTouchTargetViewWithPointerEvents != null) {
            int i = 0;
            while (viewFindTouchTargetViewWithPointerEvents != null && viewFindTouchTargetViewWithPointerEvents.getId() <= 0) {
                Object parent = viewFindTouchTargetViewWithPointerEvents.getParent();
                viewFindTouchTargetViewWithPointerEvents = parent instanceof View ? (View) parent : null;
                i++;
            }
            if (i > 0 && i <= arrayList.size()) {
                arrayList.subList(i, arrayList.size());
            }
            if (viewFindTouchTargetViewWithPointerEvents != null && (touchTargetForView = INSTANCE.getTouchTargetForView(viewFindTouchTargetViewWithPointerEvents, viewCoords[0], viewCoords[1])) != viewFindTouchTargetViewWithPointerEvents.getId()) {
                arrayList.add(0, new ViewTarget(touchTargetForView, null));
            }
        }
        return arrayList;
    }

    private final View findClosestReactAncestor(View view) {
        while (view != null && view.getId() <= 0) {
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View findTouchTargetView(float[] eventCoords2, View view, EnumSet<TouchTargetReturnType> allowReturnTouchTargetTypes, List<ViewTarget> pathAccumulator) {
        if (allowReturnTouchTargetTypes.contains(TouchTargetReturnType.CHILD) && (view instanceof ViewGroup)) {
            if (!isTouchPointInView(eventCoords2[0], eventCoords2[1], view)) {
                if (view instanceof ReactOverflowViewWithInset) {
                    if (!isTouchPointInViewWithOverflowInset(eventCoords2[0], eventCoords2[1], view)) {
                        return null;
                    }
                    String overflow = ((ReactOverflowView) view).getOverflow();
                    if (Intrinsics.areEqual(ViewProps.HIDDEN, overflow) || Intrinsics.areEqual(ViewProps.SCROLL, overflow)) {
                        return null;
                    }
                }
                if (((ViewGroup) view).getClipChildren()) {
                    return null;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount() - 1;
            while (-1 < childCount) {
                View childAt = viewGroup.getChildAt(childCount);
                PointF pointF = tempPoint;
                float f = eventCoords2[0];
                float f2 = eventCoords2[1];
                Intrinsics.checkNotNull(childAt);
                TouchTargetHelper touchTargetHelper = this;
                if (touchTargetHelper.getChildPoint(f, f2, viewGroup, childAt, pointF)) {
                    float f3 = eventCoords2[0];
                    float f4 = eventCoords2[1];
                    eventCoords2[0] = pointF.x;
                    eventCoords2[1] = pointF.y;
                    View viewFindTouchTargetViewWithPointerEvents = touchTargetHelper.findTouchTargetViewWithPointerEvents(eventCoords2, childAt, pathAccumulator);
                    if (viewFindTouchTargetViewWithPointerEvents != null) {
                        return viewFindTouchTargetViewWithPointerEvents;
                    }
                    eventCoords2[0] = f3;
                    eventCoords2[1] = f4;
                }
                childCount--;
                this = touchTargetHelper;
            }
        }
        TouchTargetHelper touchTargetHelper2 = this;
        if (allowReturnTouchTargetTypes.contains(TouchTargetReturnType.SELF) && touchTargetHelper2.isTouchPointInView(eventCoords2[0], eventCoords2[1], view)) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isTouchPointInView(float x, float y, View view) {
        ReactHitSlopView reactHitSlopView = view instanceof ReactHitSlopView ? (ReactHitSlopView) view : null;
        Rect hitSlopRect = reactHitSlopView != null ? reactHitSlopView.getHitSlopRect() : null;
        if (hitSlopRect != null) {
            return x >= ((float) (-hitSlopRect.left)) && x < ((float) (view.getWidth() + hitSlopRect.right)) && y >= ((float) (-hitSlopRect.top)) && y < ((float) (view.getHeight() + hitSlopRect.bottom));
        }
        return x >= 0.0f && x < ((float) view.getWidth()) && y >= 0.0f && y < ((float) view.getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isTouchPointInViewWithOverflowInset(float x, float y, View view) {
        if (!(view instanceof ReactOverflowViewWithInset)) {
            return false;
        }
        Rect rect = ((ReactOverflowViewWithInset) view).getOverflowInset();
        return x >= ((float) rect.left) && x < ((float) (view.getWidth() - rect.right)) && y >= ((float) rect.top) && y < ((float) (view.getHeight() - rect.bottom));
    }

    private final boolean getChildPoint(float x, float y, ViewGroup parent, View child, PointF outLocalPoint) {
        float scrollX = (x + parent.getScrollX()) - child.getLeft();
        float scrollY = (y + parent.getScrollY()) - child.getTop();
        Object tag = child.getTag(R.id.skew_animation_matrix);
        Matrix matrix = tag instanceof Matrix ? (Matrix) tag : null;
        if (matrix == null) {
            matrix = child.getMatrix();
        }
        if (!matrix.isIdentity()) {
            Matrix matrix2 = inverseMatrix;
            if (!matrix.invert(matrix2)) {
                return false;
            }
            float[] fArr = matrixTransformCoords;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            matrix2.mapPoints(fArr);
            scrollX = fArr[0];
            scrollY = fArr[1];
        }
        outLocalPoint.set(scrollX, scrollY);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ View findTouchTargetViewWithPointerEvents$default(TouchTargetHelper touchTargetHelper, float[] fArr, View view, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return touchTargetHelper.findTouchTargetViewWithPointerEvents(fArr, view, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View findTouchTargetViewWithPointerEvents(float[] eventCoords2, View view, List<ViewTarget> pathAccumulator) {
        PointerEvents pointerEvents;
        if (view instanceof ReactPointerEventsView) {
            pointerEvents = ((ReactPointerEventsView) view).getPointerEvents();
        } else {
            pointerEvents = PointerEvents.AUTO;
        }
        if (!view.isEnabled()) {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
            if (i == 1) {
                pointerEvents = PointerEvents.BOX_NONE;
            } else if (i == 2) {
                pointerEvents = PointerEvents.NONE;
            }
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
        if (i2 == 2) {
            EnumSet<TouchTargetReturnType> enumSetOf = EnumSet.of(TouchTargetReturnType.SELF);
            Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
            View viewFindTouchTargetView = findTouchTargetView(eventCoords2, view, enumSetOf, pathAccumulator);
            if (viewFindTouchTargetView != null && pathAccumulator != null) {
                pathAccumulator.add(new ViewTarget(view.getId(), view));
            }
            return viewFindTouchTargetView;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                EnumSet<TouchTargetReturnType> enumSetOf2 = EnumSet.of(TouchTargetReturnType.CHILD);
                Intrinsics.checkNotNullExpressionValue(enumSetOf2, "of(...)");
                View viewFindTouchTargetView2 = findTouchTargetView(eventCoords2, view, enumSetOf2, pathAccumulator);
                if (viewFindTouchTargetView2 != null) {
                    if (pathAccumulator != null) {
                        pathAccumulator.add(new ViewTarget(view.getId(), view));
                    }
                    return viewFindTouchTargetView2;
                }
                if ((view instanceof ReactCompoundView) && isTouchPointInView(eventCoords2[0], eventCoords2[1], view) && ((ReactCompoundView) view).reactTagForTouch(eventCoords2[0], eventCoords2[1]) != view.getId()) {
                    if (pathAccumulator != null) {
                        pathAccumulator.add(new ViewTarget(view.getId(), view));
                    }
                }
            } else {
                if (pointerEvents != PointerEvents.AUTO) {
                    FLog.w(ReactConstants.TAG, "Unknown pointer event type: " + pointerEvents);
                }
                if (!(view instanceof ReactCompoundViewGroup) || !isTouchPointInView(eventCoords2[0], eventCoords2[1], view) || !((ReactCompoundViewGroup) view).interceptsTouchEvent(eventCoords2[0], eventCoords2[1])) {
                    EnumSet<TouchTargetReturnType> enumSetOf3 = EnumSet.of(TouchTargetReturnType.SELF, TouchTargetReturnType.CHILD);
                    Intrinsics.checkNotNullExpressionValue(enumSetOf3, "of(...)");
                    View viewFindTouchTargetView3 = findTouchTargetView(eventCoords2, view, enumSetOf3, pathAccumulator);
                    if (viewFindTouchTargetView3 != null && pathAccumulator != null) {
                        pathAccumulator.add(new ViewTarget(view.getId(), view));
                    }
                    return viewFindTouchTargetView3;
                }
                if (pathAccumulator != null) {
                    pathAccumulator.add(new ViewTarget(view.getId(), view));
                    return view;
                }
            }
            return view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getTouchTargetForView(View targetView, float viewX, float viewY) {
        if (targetView instanceof ReactCompoundView) {
            return ((ReactCompoundView) targetView).reactTagForTouch(viewX, viewY);
        }
        return targetView.getId();
    }

    /* JADX INFO: compiled from: TouchTargetHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/uimanager/TouchTargetHelper$ViewTarget;", "", RumEventMeta.VIEW_ID_KEY, "", "view", "Landroid/view/View;", "<init>", "(ILandroid/view/View;)V", "getViewId", "getView", "equals", "", "other", "hashCode", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ViewTarget {
        private final View view;
        private final int viewId;

        public ViewTarget(int i, View view) {
            this.viewId = i;
            this.view = view;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public final View getView() {
            return this.view;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewTarget) && ((ViewTarget) other).getViewId() == this.viewId;
        }

        public int hashCode() {
            return Integer.hashCode(this.viewId);
        }
    }
}
