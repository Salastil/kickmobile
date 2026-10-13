package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/DynamicPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "collapsedPaddingValues", "expandedPaddingValues", "isExpanded", "", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "getCollapsedPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "getExpandedPaddingValues", "value", "", "progress", "getProgress", "()F", "setProgress", "(F)V", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicPaddingValues implements PaddingValues {
    public static final int $stable = 0;
    private final PaddingValues collapsedPaddingValues;
    private final PaddingValues expandedPaddingValues;
    private float progress;

    public DynamicPaddingValues(PaddingValues paddingValues, PaddingValues paddingValues2, boolean z) {
        this.collapsedPaddingValues = paddingValues;
        this.expandedPaddingValues = paddingValues2;
        this.progress = z ? 1.0f : 0.0f;
    }

    public final PaddingValues getCollapsedPaddingValues() {
        return this.collapsedPaddingValues;
    }

    public final PaddingValues getExpandedPaddingValues() {
        return this.expandedPaddingValues;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float f) {
        this.progress = RangesKt.coerceIn(f, 0.0f, 1.0f);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public float getBottom() {
        return DpKt.m10211lerpMdfbLM(this.collapsedPaddingValues.getBottom(), this.expandedPaddingValues.getBottom(), this.progress);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo2300calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return DpKt.m10211lerpMdfbLM(this.collapsedPaddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection), this.expandedPaddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection), this.progress);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo2301calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return DpKt.m10211lerpMdfbLM(this.collapsedPaddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection), this.expandedPaddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection), this.progress);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float getTop() {
        return DpKt.m10211lerpMdfbLM(this.collapsedPaddingValues.getTop(), this.expandedPaddingValues.getTop(), this.progress);
    }
}
