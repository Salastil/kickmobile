package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualViewContainer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010\u001d\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020\u001aH\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\fH$R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "", "scrollView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "prerenderRatio", "", "getPrerenderRatio", "()D", "virtualViews", "", "Lcom/facebook/react/views/scroll/VirtualView;", "getVirtualViews", "()Ljava/util/Collection;", "emptyRect", "Landroid/graphics/Rect;", "getEmptyRect", "()Landroid/graphics/Rect;", "visibleRect", "getVisibleRect", "prerenderRect", "getPrerenderRect", "getScrollView", "()Landroid/view/ViewGroup;", "onChange", "", "virtualView", "remove", "updateState", "updateRects", "updateModes", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class VirtualViewContainerState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Rect emptyRect;
    private final double prerenderRatio;
    private final Rect prerenderRect;
    private final ViewGroup scrollView;
    private final Rect visibleRect;

    @JvmStatic
    public static final VirtualViewContainerState create(ViewGroup viewGroup) {
        return INSTANCE.create(viewGroup);
    }

    protected abstract Collection<VirtualView> getVirtualViews();

    protected abstract void updateModes(VirtualView virtualView);

    protected final double getPrerenderRatio() {
        return this.prerenderRatio;
    }

    protected final Rect getEmptyRect() {
        return this.emptyRect;
    }

    protected final Rect getVisibleRect() {
        return this.visibleRect;
    }

    protected final Rect getPrerenderRect() {
        return this.prerenderRect;
    }

    protected final ViewGroup getScrollView() {
        return this.scrollView;
    }

    /* JADX INFO: compiled from: VirtualViewContainer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/views/scroll/VirtualViewContainerState$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "scrollView", "Landroid/view/ViewGroup;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VirtualViewContainerState create(ViewGroup scrollView) {
            Intrinsics.checkNotNullParameter(scrollView, "scrollView");
            if (ReactNativeFeatureFlags.enableVirtualViewContainerStateExperimental()) {
                return new VirtualViewContainerStateExperimental(scrollView);
            }
            return new VirtualViewContainerStateClassic(scrollView);
        }
    }

    public VirtualViewContainerState(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.prerenderRatio = ReactNativeFeatureFlags.virtualViewPrerenderRatio();
        this.emptyRect = new Rect();
        this.visibleRect = new Rect();
        this.prerenderRect = new Rect();
        this.scrollView = scrollView;
    }

    public void onChange(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        getVirtualViews().add(virtualView);
        updateModes(virtualView);
    }

    public void remove(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        getVirtualViews().remove(virtualView);
    }

    public final void updateState() {
        updateModes$default(this, null, 1, null);
    }

    protected final void updateRects() {
        this.scrollView.getDrawingRect(this.visibleRect);
        boolean zIsEmpty = this.visibleRect.isEmpty();
        Rect rect = this.prerenderRect;
        if (zIsEmpty) {
            rect.set(this.visibleRect);
            return;
        }
        rect.set(this.visibleRect);
        Rect rect2 = this.prerenderRect;
        rect2.inset((int) (((double) (-rect2.width())) * this.prerenderRatio), (int) (((double) (-this.prerenderRect.height())) * this.prerenderRatio));
    }

    public static /* synthetic */ void updateModes$default(VirtualViewContainerState virtualViewContainerState, VirtualView virtualView, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateModes");
        }
        if ((i & 1) != 0) {
            virtualView = null;
        }
        virtualViewContainerState.updateModes(virtualView);
    }
}
