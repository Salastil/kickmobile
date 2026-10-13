package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.views.virtual.VirtualViewMode;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualViewContainerStateClassic.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/views/scroll/VirtualViewContainerStateClassic;", "Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "scrollView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "virtualViews", "", "Lcom/facebook/react/views/scroll/VirtualView;", "getVirtualViews", "()Ljava/util/Collection;", "updateModes", "", "virtualView", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VirtualViewContainerStateClassic extends VirtualViewContainerState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean ENABLE_DEBUG_LOGS;
    private final Collection<VirtualView> virtualViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualViewContainerStateClassic(ViewGroup scrollView) {
        super(scrollView);
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.virtualViews = new LinkedHashSet();
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected Collection<VirtualView> getVirtualViews() {
        return this.virtualViews;
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainerState
    protected void updateModes(VirtualView virtualView) {
        getScrollView().getDrawingRect(getVisibleRect());
        if (getVisibleRect().isEmpty()) {
            if (ENABLE_DEBUG_LOGS) {
                FLog.d("VirtualViewContainerStateClassic:updateModes", "scrollView visibleRect is empty");
                return;
            }
            return;
        }
        getPrerenderRect().set(getVisibleRect());
        getPrerenderRect().inset((int) (((double) (-getPrerenderRect().width())) * getPrerenderRatio()), (int) (((double) (-getPrerenderRect().height())) * getPrerenderRatio()));
        for (VirtualView virtualView2 : virtualView != null ? CollectionsKt.listOf(virtualView) : CollectionsKt.toMutableSet(getVirtualViews())) {
            Rect containerRelativeRect = virtualView2.getContainerRelativeRect();
            VirtualViewMode virtualViewMode = VirtualViewMode.Hidden;
            Rect emptyRect = getEmptyRect();
            if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getVisibleRect())) {
                emptyRect = getVisibleRect();
                virtualViewMode = VirtualViewMode.Visible;
            } else if (VirtualViewContainerKt.rectsOverlap(containerRelativeRect, getPrerenderRect())) {
                virtualViewMode = VirtualViewMode.Prerender;
                emptyRect = getPrerenderRect();
            }
            virtualView2.onModeChange(virtualViewMode, emptyRect);
            if (ENABLE_DEBUG_LOGS) {
                FLog.d("VirtualViewContainerStateClassic:updateModes", "virtualView=" + virtualView2.getVirtualViewID() + " mode=" + virtualViewMode + "  rect=" + containerRelativeRect + " thresholdRect=" + emptyRect);
            }
        }
    }

    /* JADX INFO: compiled from: VirtualViewContainerStateClassic.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0080\bø\u0001\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/facebook/react/views/scroll/VirtualViewContainerStateClassic$Companion;", "", "<init>", "()V", "ENABLE_DEBUG_LOGS", "", "debugLog", "", "subtag", "", "block", "Lkotlin/Function0;", "debugLog$ReactAndroid", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void debugLog$ReactAndroid$default(Companion companion, String subtag, Function0 block, int i, Object obj) {
            if ((i & 2) != 0) {
                block = new Function0<String>() { // from class: com.facebook.react.views.scroll.VirtualViewContainerStateClassic$Companion$debugLog$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "";
                    }
                };
            }
            Intrinsics.checkNotNullParameter(subtag, "subtag");
            Intrinsics.checkNotNullParameter(block, "block");
            if (VirtualViewContainerStateClassic.ENABLE_DEBUG_LOGS) {
                FLog.d("VirtualViewContainerStateClassic:" + subtag, (String) block.invoke());
            }
        }

        public final void debugLog$ReactAndroid(String subtag, Function0<String> block) {
            Intrinsics.checkNotNullParameter(subtag, "subtag");
            Intrinsics.checkNotNullParameter(block, "block");
            if (VirtualViewContainerStateClassic.ENABLE_DEBUG_LOGS) {
                FLog.d("VirtualViewContainerStateClassic:" + subtag, block.invoke());
            }
        }
    }

    static {
        boolean z = ReactBuildConfig.DEBUG;
        ENABLE_DEBUG_LOGS = false;
    }
}
