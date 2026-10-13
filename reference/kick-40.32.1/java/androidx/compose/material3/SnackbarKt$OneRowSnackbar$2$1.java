package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        MeasureScope measureScope2 = measureScope;
        int i = measureScope2.mo1728roundToPx0680j_4(SnackbarTokens.INSTANCE.m6194getSingleLineContainerHeightD9Ej5fM());
        int iMin = Math.min(Constraints.m10121getMaxWidthimpl(j), measureScope2.mo1728roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
        String str = this.$actionTag;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                break;
            }
            i2++;
        }
        Measurable measurable3 = measurable;
        final Placeable placeableMo8808measureBRTryo0 = measurable3 != null ? measurable3.mo8808measureBRTryo0(j) : null;
        String str2 = this.$dismissActionTag;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                break;
            }
            i3++;
        }
        Measurable measurable4 = measurable2;
        final Placeable placeableMo8808measureBRTryo1 = measurable4 != null ? measurable4.mo8808measureBRTryo0(j) : null;
        int width = placeableMo8808measureBRTryo0 != null ? placeableMo8808measureBRTryo0.getWidth() : 0;
        int width2 = placeableMo8808measureBRTryo1 != null ? placeableMo8808measureBRTryo1.getWidth() : 0;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((iMin - width) - width2) - (width2 == 0 ? measureScope2.mo1728roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m10123getMinWidthimpl(j));
        String str3 = this.$textTag;
        int size3 = list2.size();
        int i4 = 0;
        while (i4 < size3) {
            Measurable measurable5 = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str3)) {
                final Placeable placeableMo8808measureBRTryo2 = measurable5.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(j, 0, iCoerceAtLeast, 0, 0, 9, null));
                final int iMaxOf = ComparisonsKt.maxOf(i, placeableMo8808measureBRTryo2.getHeight(), placeableMo8808measureBRTryo0 != null ? placeableMo8808measureBRTryo0.getHeight() : 0, placeableMo8808measureBRTryo1 != null ? placeableMo8808measureBRTryo1.getHeight() : 0);
                final int i5 = iMin - width2;
                final int i6 = i5 - width;
                return MeasureScope.layout$default(measureScope2, iMin, iMaxOf, null, new Function1() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SnackbarKt$OneRowSnackbar$2$1.measure_3p2s80s$lambda$3(placeableMo8808measureBRTryo2, iMaxOf, placeableMo8808measureBRTryo0, i6, placeableMo8808measureBRTryo1, i5, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            i4++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$3(Placeable placeable, int i, Placeable placeable2, int i2, Placeable placeable3, int i3, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, (i - placeable2.getHeight()) / 2, 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i3, (i - placeable3.getHeight()) / 2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
