package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import com.facebook.react.views.virtual.VirtualViewMode;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualViewContainerStateExperimental.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006!"}, d2 = {"Lcom/facebook/react/views/scroll/VirtualViewContainerStateExperimental;", "Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "scrollView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "horizontal", "", "virtualViews", "Lcom/facebook/react/views/scroll/IntervalTree;", "getVirtualViews", "()Lcom/facebook/react/views/scroll/IntervalTree;", "PV", "", "", "getPV", "()Ljava/util/Set;", "setPV", "(Ljava/util/Set;)V", "P", "getP", "setP", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "getV", "setV", "onChange", "", "virtualView", "Lcom/facebook/react/views/scroll/VirtualView;", "updateModes", "remove", "updateMode", "updateModesAll", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VirtualViewContainerStateExperimental extends VirtualViewContainerState {
    private Set<String> P;
    private Set<String> PV;
    private Set<String> V;
    private final boolean horizontal;
    private final IntervalTree virtualViews;

    /* JADX INFO: compiled from: VirtualViewContainerStateExperimental.kt */
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
    public VirtualViewContainerStateExperimental(ViewGroup scrollView) {
        super(scrollView);
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        boolean z = false;
        if (!(scrollView instanceof ReactScrollView) && (scrollView instanceof ReactHorizontalScrollView)) {
            z = true;
        }
        this.horizontal = z;
        this.virtualViews = new IntervalTree(z);
        this.PV = new LinkedHashSet();
        this.P = new LinkedHashSet();
        this.V = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    public IntervalTree getVirtualViews() {
        return this.virtualViews;
    }

    public final Set<String> getPV() {
        return this.PV;
    }

    public final void setPV(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.PV = set;
    }

    public final Set<String> getP() {
        return this.P;
    }

    public final void setP(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.P = set;
    }

    public final Set<String> getV() {
        return this.V;
    }

    public final void setV(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.V = set;
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    public void onChange(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        if (getVirtualViews().add(virtualView)) {
            if (VirtualViewContainerStateExperimentalKt.ENABLE_DEBUG_LOGS) {
                FLog.d("VirtualViewContainerStateExperimental:add", "virtualViewID=" + virtualView.getVirtualViewID());
            }
        } else if (VirtualViewContainerStateExperimentalKt.ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:update", "virtualViewID=" + virtualView.getVirtualViewID());
        }
        updateModes(virtualView);
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected void updateModes(VirtualView virtualView) {
        updateRects();
        if (virtualView != null) {
            updateMode(virtualView);
        } else {
            updateModesAll();
        }
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    public void remove(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        super.remove(virtualView);
        this.PV.remove(virtualView.getVirtualViewID());
        this.P.remove(virtualView.getVirtualViewID());
        this.V.remove(virtualView.getVirtualViewID());
    }

    private final void updateMode(VirtualView virtualView) {
        Rect containerRelativeRect = virtualView.getContainerRelativeRect();
        VirtualViewMode virtualViewMode = VirtualViewMode.Hidden;
        Rect emptyRect = getEmptyRect();
        if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getVisibleRect())) {
            emptyRect = getVisibleRect();
            virtualViewMode = VirtualViewMode.Visible;
        } else if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getPrerenderRect())) {
            virtualViewMode = VirtualViewMode.Prerender;
            emptyRect = getPrerenderRect();
        }
        virtualView.onModeChange(virtualViewMode, emptyRect);
        int i = WhenMappings.$EnumSwitchMapping$0[virtualViewMode.ordinal()];
        if (i == 1) {
            this.PV.add(virtualView.getVirtualViewID());
            this.P.remove(virtualView.getVirtualViewID());
            this.V.add(virtualView.getVirtualViewID());
        } else if (i == 2) {
            this.PV.add(virtualView.getVirtualViewID());
            this.P.add(virtualView.getVirtualViewID());
            this.V.remove(virtualView.getVirtualViewID());
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.PV.remove(virtualView.getVirtualViewID());
            this.P.remove(virtualView.getVirtualViewID());
            this.V.remove(virtualView.getVirtualViewID());
        }
    }

    private final void updateModesAll() {
        Set<String> setQuery = getVirtualViews().query(getVisibleRect());
        Set<String> setQuery2 = getVirtualViews().query(getPrerenderRect());
        if (VirtualViewContainerStateExperimentalKt.ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "V: " + this.V + ", P: " + this.P + ", PV: " + this.PV);
        }
        Set setMinus = SetsKt.minus((Set) setQuery2, (Iterable) setQuery);
        if (VirtualViewContainerStateExperimentalKt.ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "V': " + setQuery + ", P': " + setMinus + ", PV': " + setQuery2);
        }
        Set setMinus2 = SetsKt.minus((Set) setQuery, (Iterable) this.V);
        Set setMinus3 = SetsKt.minus(setMinus, (Iterable) this.P);
        Set<String> set = setQuery2;
        Set setMinus4 = SetsKt.minus((Set) this.PV, (Iterable) set);
        if (VirtualViewContainerStateExperimentalKt.ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:updateModes", "toV: " + setMinus2 + ", toP: " + setMinus3 + ", toH: " + setMinus4);
        }
        Iterator it = setMinus2.iterator();
        while (it.hasNext()) {
            VirtualView virtualView = getVirtualViews().getVirtualView((String) it.next());
            if (virtualView != null) {
                virtualView.onModeChange(VirtualViewMode.Visible, getVisibleRect());
            }
        }
        Iterator it2 = setMinus3.iterator();
        while (it2.hasNext()) {
            VirtualView virtualView2 = getVirtualViews().getVirtualView((String) it2.next());
            if (virtualView2 != null) {
                virtualView2.onModeChange(VirtualViewMode.Prerender, getPrerenderRect());
            }
        }
        Iterator it3 = setMinus4.iterator();
        while (it3.hasNext()) {
            VirtualView virtualView3 = getVirtualViews().getVirtualView((String) it3.next());
            if (virtualView3 != null) {
                virtualView3.onModeChange(VirtualViewMode.Hidden, getEmptyRect());
            }
        }
        this.V = setQuery;
        this.P = CollectionsKt.toMutableSet(setMinus);
        this.PV = CollectionsKt.toMutableSet(set);
    }
}
