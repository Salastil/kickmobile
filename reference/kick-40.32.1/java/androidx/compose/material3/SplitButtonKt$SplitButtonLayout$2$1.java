package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SplitButtonKt$SplitButtonLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ float $spacing;

    SplitButtonKt$SplitButtonLayout$2$1(float f) {
        this.$spacing = f;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Integer num;
        long jM10111copyZbe2FdA$default = Constraints.m10111copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "LeadingButton")) {
                final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(jM10111copyZbe2FdA$default);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "TrailingButton")) {
                        final Placeable placeableMo8808measureBRTryo1 = measurable2.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(ConstraintsKt.m10141offsetNN6EwU$default(jM10111copyZbe2FdA$default, -(placeableMo8808measureBRTryo0.getWidth() + measureScope.mo1728roundToPx0680j_4(this.$spacing)), 0, 2, null), 0, 0, placeableMo8808measureBRTryo0.getHeight(), placeableMo8808measureBRTryo0.getHeight(), 3, null));
                        int i3 = 1;
                        List listListOf = CollectionsKt.listOf((Object[]) new Placeable[]{placeableMo8808measureBRTryo0, placeableMo8808measureBRTryo1});
                        int size3 = listListOf.size();
                        int width = 0;
                        for (int i4 = 0; i4 < size3; i4++) {
                            width += ((Placeable) listListOf.get(i4)).getWidth();
                        }
                        int i5 = width + measureScope.mo1728roundToPx0680j_4(this.$spacing);
                        if (listListOf.isEmpty()) {
                            num = null;
                        } else {
                            Integer numValueOf = Integer.valueOf(((Placeable) listListOf.get(0)).getHeight());
                            int lastIndex = CollectionsKt.getLastIndex(listListOf);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Integer numValueOf2 = Integer.valueOf(((Placeable) listListOf.get(i3)).getHeight());
                                    if (numValueOf2.compareTo(numValueOf) > 0) {
                                        numValueOf = numValueOf2;
                                    }
                                    if (i3 == lastIndex) {
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            num = numValueOf;
                        }
                        Integer num2 = num;
                        int iIntValue = num2 != null ? num2.intValue() : 0;
                        int iM10138constrainWidthK40F9xA = ConstraintsKt.m10138constrainWidthK40F9xA(j, i5);
                        int iM10137constrainHeightK40F9xA = ConstraintsKt.m10137constrainHeightK40F9xA(j, iIntValue);
                        final float f = this.$spacing;
                        return MeasureScope.layout$default(measureScope, iM10138constrainWidthK40F9xA, iM10137constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.SplitButtonKt$SplitButtonLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SplitButtonKt$SplitButtonLayout$2$1.measure_3p2s80s$lambda$4(placeableMo8808measureBRTryo0, placeableMo8808measureBRTryo1, f, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i2++;
                    measureScope = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$4(Placeable placeable, Placeable placeable2, float f, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, placeable.getWidth() + placementScope.mo1728roundToPx0680j_4(f), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
