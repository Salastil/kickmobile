package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1 implements MeasurePolicy {
    final /* synthetic */ float $collapsedShadowElevation;
    final /* synthetic */ State<Float> $expandedProgress;
    final /* synthetic */ float $expandedShadowElevation;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Shape $toolbarShape;
    final /* synthetic */ float $toolbarToFabGap;

    FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1(State<Float> state, float f, int i, float f2, float f3, Shape shape) {
        this.$expandedProgress = state;
        this.$toolbarToFabGap = f;
        this.$fabPosition = i;
        this.$collapsedShadowElevation = f2;
        this.$expandedShadowElevation = f3;
        this.$toolbarShape = shape;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable = list.get(0);
        Measurable measurable2 = list.get(1);
        int i = measureScope.mo1728roundToPx0680j_4(FloatingToolbarKt.lerp(FloatingToolbarDefaults.INSTANCE.getFabSizeRange$material3(), 1.0f - this.$expandedProgress.getValue().floatValue()));
        final Placeable placeableMo8808measureBRTryo0 = measurable2.mo8808measureBRTryo0(Constraints.m10110copyZbe2FdA(j, i, i, i, i));
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(measureScope.mo1728roundToPx0680j_4(FloatingToolbarDefaults.INSTANCE.m4025getContainerSizeD9Ej5fM()));
        final Placeable placeableMo8808measureBRTryo1 = measurable.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(j, RangesKt.coerceIn(measureScope.mo1728roundToPx0680j_4(FloatingToolbarDefaults.INSTANCE.m4025getContainerSizeD9Ej5fM()), 0, Constraints.m10123getMinWidthimpl(j)), 0, 0, RangesKt.coerceIn((int) RangesKt.coerceAtLeast(iMaxIntrinsicHeight * this.$expandedProgress.getValue().floatValue(), 0.0f), 0, Constraints.m10120getMaxHeightimpl(j)), 6, null));
        int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j);
        int i2 = measureScope.mo1728roundToPx0680j_4(this.$toolbarToFabGap) + iMaxIntrinsicHeight + measureScope.mo1728roundToPx0680j_4(((Dp) FloatingToolbarDefaults.INSTANCE.getFabSizeRange$material3().getStart()).m10182unboximpl());
        final int width = (iM10123getMinWidthimpl - placeableMo8808measureBRTryo1.getWidth()) / 2;
        final int width2 = (iM10123getMinWidthimpl - placeableMo8808measureBRTryo0.getWidth()) / 2;
        final int height = FloatingToolbarVerticalFabPosition.m4084equalsimpl0(this.$fabPosition, FloatingToolbarVerticalFabPosition.INSTANCE.m4088getBottomdDJPGzU()) ? i2 - placeableMo8808measureBRTryo0.getHeight() : 0;
        final int height2 = FloatingToolbarVerticalFabPosition.m4084equalsimpl0(this.$fabPosition, FloatingToolbarVerticalFabPosition.INSTANCE.m4088getBottomdDJPGzU()) ? iMaxIntrinsicHeight - placeableMo8808measureBRTryo1.getHeight() : i2 - iMaxIntrinsicHeight;
        final float f = this.$collapsedShadowElevation;
        final float f2 = this.$expandedShadowElevation;
        final State<Float> state = this.$expandedProgress;
        final Shape shape = this.$toolbarShape;
        return MeasureScope.layout$default(measureScope, iM10123getMinWidthimpl, i2, null, new Function1() { // from class: androidx.compose.material3.FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1.measure_3p2s80s$lambda$0(f, f2, state, placeableMo8808measureBRTryo1, width, height2, placeableMo8808measureBRTryo0, width2, height, shape, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(float f, float f2, State state, Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, final Shape shape, Placeable.PlacementScope placementScope) {
        final float fM10211lerpMdfbLM = DpKt.m10211lerpMdfbLM(f, f2, RangesKt.coerceAtMost(((Number) state.getValue()).floatValue(), 1.0f));
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i, i2, 0.0f, new Function1() { // from class: androidx.compose.material3.FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingToolbarKt$VerticalFloatingToolbarWithFabLayout$3$1.measure_3p2s80s$lambda$0$0(fM10211lerpMdfbLM, shape, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0$0(float f, Shape shape, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo1734toPx0680j_4(f));
        graphicsLayerScope.setShape(shape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }
}
