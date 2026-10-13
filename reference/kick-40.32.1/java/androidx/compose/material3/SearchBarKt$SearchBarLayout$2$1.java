package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1311measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        final Placeable placeableMo8808measureBRTryo0;
        int i;
        int iM10120getMaxHeightimpl;
        final float fFloatValue = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable3 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                break;
                            }
                            i4++;
                        }
                        Measurable measurable4 = measurable;
                        final int top = this.$unconsumedInsets.getTop(measureScope) + measureScope.mo1728roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i5 = measureScope.mo1728roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int iM10138constrainWidthK40F9xA = ConstraintsKt.m10138constrainWidthK40F9xA(j, measurable2.maxIntrinsicWidth(Constraints.m10120getMaxHeightimpl(j)));
                        int iM10137constrainHeightK40F9xA = ConstraintsKt.m10137constrainHeightK40F9xA(j, measurable2.minIntrinsicHeight(Constraints.m10121getMaxWidthimpl(j)));
                        int iRoundToInt = MathKt.roundToInt(Constraints.m10121getMaxWidthimpl(j) * 0.9f);
                        int iRoundToInt2 = MathKt.roundToInt(Constraints.m10120getMaxHeightimpl(j) * 0.9f);
                        final float fCalculatePredictiveBackMultiplier = SearchBarKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), fFloatValue, this.$finalBackProgress.getFloatValue());
                        int iLerp = MathHelpersKt.lerp(iM10138constrainWidthK40F9xA, iRoundToInt, fCalculatePredictiveBackMultiplier);
                        int i6 = top + iM10137constrainHeightK40F9xA;
                        int iLerp2 = MathHelpersKt.lerp(i6, iRoundToInt2, fCalculatePredictiveBackMultiplier);
                        int iM10121getMaxWidthimpl = Constraints.m10121getMaxWidthimpl(j);
                        int iM10120getMaxHeightimpl2 = Constraints.m10120getMaxHeightimpl(j);
                        int iLerp3 = MathHelpersKt.lerp(iLerp, iM10121getMaxWidthimpl, fFloatValue);
                        final int iLerp4 = MathHelpersKt.lerp(iLerp2, iM10120getMaxHeightimpl2, fFloatValue);
                        final int iLerp5 = MathHelpersKt.lerp(top, 0, fFloatValue);
                        final int iLerp6 = MathHelpersKt.lerp(0, i5, fFloatValue);
                        final Placeable placeableMo8808measureBRTryo1 = measurable2.mo8808measureBRTryo0(ConstraintsKt.Constraints(iLerp3, iM10121getMaxWidthimpl, iM10137constrainHeightK40F9xA, iM10137constrainHeightK40F9xA));
                        int width = placeableMo8808measureBRTryo1.getWidth();
                        final Placeable placeableMo8808measureBRTryo2 = measurable3.mo8808measureBRTryo0(Constraints.INSTANCE.m10131fixedJhjzzOo(width, iLerp4 - iLerp5));
                        if (measurable4 != null) {
                            if (Constraints.m10116getHasBoundedHeightimpl(j)) {
                                i = 0;
                                iM10120getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m10120getMaxHeightimpl(j) - (i6 + i5), 0);
                            } else {
                                i = 0;
                                iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(j);
                            }
                            placeableMo8808measureBRTryo0 = measurable4.mo8808measureBRTryo0(ConstraintsKt.Constraints(width, width, i, iM10120getMaxHeightimpl));
                        } else {
                            placeableMo8808measureBRTryo0 = null;
                        }
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        return MeasureScope.layout$default(measureScope, width, iLerp4, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$SearchBarLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchBarKt$SearchBarLayout$2$1.measure_3p2s80s$lambda$3(j, mutableState, measureScope, fFloatValue, fCalculatePredictiveBackMultiplier, mutableState2, iLerp4, placeableMo8808measureBRTryo2, iLerp5, placeableMo8808measureBRTryo1, top, placeableMo8808measureBRTryo0, iLerp6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i3++;
                    measureScope = measureScope;
                    j = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$3(long j, MutableState mutableState, MeasureScope measureScope, float f, float f2, MutableState mutableState2, int i, Placeable placeable, int i2, Placeable placeable2, int i3, Placeable placeable3, int i4, Placeable.PlacementScope placementScope) {
        int i5 = placementScope.mo1728roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin);
        int iM4594calculatePredictiveBackOffsetXrOvwMX4 = SearchBarKt.m4594calculatePredictiveBackOffsetXrOvwMX4(j, i5, (BackEventCompat) mutableState.getValue(), measureScope.getLayoutDirection(), f, f2);
        int iM4595calculatePredictiveBackOffsetYdzo92Q0 = SearchBarKt.m4595calculatePredictiveBackOffsetYdzo92Q0(j, i5, (BackEventCompat) mutableState.getValue(), (BackEventCompat) mutableState2.getValue(), i, placementScope.mo1728roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY), f2);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iM4594calculatePredictiveBackOffsetXrOvwMX4, iM4595calculatePredictiveBackOffsetYdzo92Q0 + i2, 0.0f, 4, null);
        int i6 = iM4595calculatePredictiveBackOffsetYdzo92Q0 + i3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iM4594calculatePredictiveBackOffsetXrOvwMX4, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iM4594calculatePredictiveBackOffsetXrOvwMX4, i6 + placeable2.getHeight() + i4, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
