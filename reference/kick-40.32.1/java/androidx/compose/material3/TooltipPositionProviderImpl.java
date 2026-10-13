package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u001dJ%\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u001dJ%\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u001dJ-\u0010$\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J-\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b(\u0010&R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Landroidx/compose/material3/TooltipPositionProviderImpl;", "Landroidx/compose/ui/window/PopupPositionProvider;", "type", "Landroidx/compose/material3/TooltipAnchorPosition;", "tooltipAnchorSpacing", "", "windowContainerSize", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(IIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getType-lOKsHw4", "()I", "I", "getTooltipAnchorSpacing", "getWindowContainerSize-YbymL2g", "()J", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "leftPositioning", "leftPositioning-uHY26d4", "(Landroidx/compose/ui/unit/IntRect;JJ)J", "rightPositioning", "rightPositioning-uHY26d4", "abovePositioning", "abovePositioning-uHY26d4", "belowPositioning", "belowPositioning-uHY26d4", "startPositioning", "startPositioning-_JLpSYE", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/IntRect;JJ)J", "endPositioning", "endPositioning-_JLpSYE", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TooltipPositionProviderImpl implements PopupPositionProvider {
    private final int tooltipAnchorSpacing;
    private final int type;
    private final long windowContainerSize;

    public /* synthetic */ TooltipPositionProviderImpl(int i, int i2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j);
    }

    private TooltipPositionProviderImpl(int i, int i2, long j) {
        this.type = i;
        this.tooltipAnchorSpacing = i2;
        this.windowContainerSize = j;
    }

    /* JADX INFO: renamed from: getType-lOKsHw4, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    public final int getTooltipAnchorSpacing() {
        return this.tooltipAnchorSpacing;
    }

    /* JADX INFO: renamed from: getWindowContainerSize-YbymL2g, reason: not valid java name and from getter */
    public final long getWindowContainerSize() {
        return this.windowContainerSize;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo1701calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int i = this.type;
        if (TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5148getLeftlOKsHw4())) {
            return m5171leftPositioninguHY26d4(anchorBounds, popupContentSize, this.windowContainerSize);
        }
        if (TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5149getRightlOKsHw4())) {
            return m5172rightPositioninguHY26d4(anchorBounds, popupContentSize, this.windowContainerSize);
        }
        if (TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5145getAbovelOKsHw4())) {
            return m5166abovePositioninguHY26d4(anchorBounds, popupContentSize, this.windowContainerSize);
        }
        if (TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5146getBelowlOKsHw4())) {
            return m5167belowPositioninguHY26d4(anchorBounds, popupContentSize, this.windowContainerSize);
        }
        if (TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5150getStartlOKsHw4())) {
            return m5173startPositioning_JLpSYE(layoutDirection, anchorBounds, popupContentSize, this.windowContainerSize);
        }
        boolean zM5141equalsimpl0 = TooltipAnchorPosition.m5141equalsimpl0(i, TooltipAnchorPosition.INSTANCE.m5147getEndlOKsHw4());
        long j = this.windowContainerSize;
        if (zM5141equalsimpl0) {
            return m5168endPositioning_JLpSYE(layoutDirection, anchorBounds, popupContentSize, j);
        }
        return m5166abovePositioninguHY26d4(anchorBounds, popupContentSize, j);
    }

    /* JADX INFO: renamed from: leftPositioning-uHY26d4, reason: not valid java name */
    public final long m5171leftPositioninguHY26d4(IntRect anchorBounds, long popupContentSize, long windowSize) {
        int i = (int) (popupContentSize >> 32);
        int left = anchorBounds.getLeft() - (this.tooltipAnchorSpacing + i);
        if (left < 0) {
            left = (anchorBounds.getRight() + this.tooltipAnchorSpacing) - RangesKt.coerceAtLeast(((anchorBounds.getRight() + this.tooltipAnchorSpacing) + i) - ((int) (windowSize >> 32)), 0);
        }
        return IntOffset.m10290constructorimpl((((long) left) << 32) | (((long) (((anchorBounds.getTop() + anchorBounds.getBottom()) - ((int) (popupContentSize & 4294967295L))) / 2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: rightPositioning-uHY26d4, reason: not valid java name */
    public final long m5172rightPositioninguHY26d4(IntRect anchorBounds, long popupContentSize, long windowSize) {
        int right = anchorBounds.getRight() + this.tooltipAnchorSpacing;
        int i = (int) (popupContentSize >> 32);
        if (right + i > ((int) (windowSize >> 32))) {
            right = RangesKt.coerceAtLeast(anchorBounds.getLeft() - (i + this.tooltipAnchorSpacing), 0);
        }
        return IntOffset.m10290constructorimpl((((long) right) << 32) | (((long) (((anchorBounds.getTop() + anchorBounds.getBottom()) - ((int) (popupContentSize & 4294967295L))) / 2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: abovePositioning-uHY26d4, reason: not valid java name */
    public final long m5166abovePositioninguHY26d4(IntRect anchorBounds, long popupContentSize, long windowSize) {
        int i = (int) (popupContentSize >> 32);
        int left = anchorBounds.getLeft() + ((anchorBounds.getWidth() - i) / 2);
        if (left < 0) {
            left = anchorBounds.getLeft() - RangesKt.coerceAtLeast((anchorBounds.getLeft() + i) - ((int) (windowSize >> 32)), 0);
        } else if (left + i > ((int) (windowSize >> 32))) {
            left = RangesKt.coerceAtLeast(anchorBounds.getRight() - i, 0);
        }
        int top = (anchorBounds.getTop() - ((int) (popupContentSize & 4294967295L))) - this.tooltipAnchorSpacing;
        if (top < 0) {
            top = anchorBounds.getBottom() + this.tooltipAnchorSpacing;
        }
        return IntOffset.m10290constructorimpl((((long) left) << 32) | (((long) top) & 4294967295L));
    }

    /* JADX INFO: renamed from: belowPositioning-uHY26d4, reason: not valid java name */
    public final long m5167belowPositioninguHY26d4(IntRect anchorBounds, long popupContentSize, long windowSize) {
        int i = (int) (popupContentSize >> 32);
        int left = anchorBounds.getLeft() + ((anchorBounds.getWidth() - i) / 2);
        if (left < 0) {
            left = anchorBounds.getLeft() - RangesKt.coerceAtLeast((anchorBounds.getLeft() + i) - ((int) (windowSize >> 32)), 0);
        } else if (left + i > ((int) (windowSize >> 32))) {
            left = RangesKt.coerceAtLeast(anchorBounds.getRight() - i, 0);
        }
        int bottom = anchorBounds.getBottom() + this.tooltipAnchorSpacing;
        int i2 = (int) (popupContentSize & 4294967295L);
        if (bottom + i2 > ((int) (windowSize & 4294967295L))) {
            bottom = (anchorBounds.getTop() - i2) - this.tooltipAnchorSpacing;
        }
        return IntOffset.m10290constructorimpl((((long) left) << 32) | (((long) bottom) & 4294967295L));
    }

    /* JADX INFO: renamed from: startPositioning-_JLpSYE, reason: not valid java name */
    public final long m5173startPositioning_JLpSYE(LayoutDirection layoutDirection, IntRect anchorBounds, long popupContentSize, long windowSize) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return m5171leftPositioninguHY26d4(anchorBounds, popupContentSize, windowSize);
        }
        return m5172rightPositioninguHY26d4(anchorBounds, popupContentSize, windowSize);
    }

    /* JADX INFO: renamed from: endPositioning-_JLpSYE, reason: not valid java name */
    public final long m5168endPositioning_JLpSYE(LayoutDirection layoutDirection, IntRect anchorBounds, long popupContentSize, long windowSize) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return m5172rightPositioninguHY26d4(anchorBounds, popupContentSize, windowSize);
        }
        return m5171leftPositioninguHY26d4(anchorBounds, popupContentSize, windowSize);
    }
}
