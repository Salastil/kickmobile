package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$WideNavigationRailLayout$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WideNavigationRailKt$WideNavigationRailLayout$1$2 implements MeasurePolicy {
    final /* synthetic */ MutableIntState $actualMaxExpandedWidth$delegate;
    final /* synthetic */ Arrangement.Vertical $arrangement;
    final /* synthetic */ MutableIntState $currentWidth$delegate;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $header;
    final /* synthetic */ State<Dp> $itemMinHeight$delegate;
    final /* synthetic */ State<Dp> $itemVerticalSpacedBy$delegate;
    final /* synthetic */ State<Dp> $minWidth$delegate;
    final /* synthetic */ float $minimumA11ySize;
    final /* synthetic */ State<Dp> $widthFullRange$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    WideNavigationRailKt$WideNavigationRailLayout$1$2(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, float f, State<Dp> state, State<Dp> state2, State<Dp> state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State<Dp> state4) {
        this.$header = function2;
        this.$expanded = z;
        this.$minimumA11ySize = f;
        this.$minWidth$delegate = state;
        this.$itemMinHeight$delegate = state2;
        this.$widthFullRange$delegate = state3;
        this.$actualMaxExpandedWidth$delegate = mutableIntState;
        this.$currentWidth$delegate = mutableIntState2;
        this.$arrangement = vertical;
        this.$itemVerticalSpacedBy$delegate = state4;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x01eb A[PHI: r2
      0x01eb: PHI (r2v3 int) = (r2v2 int), (r2v6 int), (r2v6 int) binds: [B:53:0x01cf, B:49:0x01a3, B:50:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, androidx.compose.ui.layout.Placeable] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iM10123getMinWidthimpl;
        int height;
        int i;
        int i2;
        int i3;
        int iCoerceIn;
        int i4;
        final int iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(j);
        int size = list.size();
        int iM10123getMinWidthimpl2 = Constraints.m10123getMinWidthimpl(j);
        if (Constraints.m10123getMinWidthimpl(j) == 0) {
            iM10123getMinWidthimpl2 = RangesKt.coerceAtMost(measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.ExpandedRailMinWidth), Constraints.m10121getMaxWidthimpl(j));
            iM10123getMinWidthimpl = RangesKt.coerceAtMost(measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$6(this.$minWidth$delegate)), Constraints.m10121getMaxWidthimpl(j));
        } else {
            iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j);
        }
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, iM10123getMinWidthimpl, iM10120getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        int i5 = iM10123getMinWidthimpl;
        List<? extends Measurable> listSubList = list;
        long jM10111copyZbe2FdA$default = Constraints.m10111copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.$header != null) {
            int size2 = listSubList.size();
            int i6 = 0;
            while (true) {
                if (i6 < size2) {
                    Measurable measurable = listSubList.get(i6);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "header")) {
                        objectRef.element = measurable.mo8808measureBRTryo0(jM10111copyZbe2FdA$default);
                        if (size > 1) {
                            listSubList = listSubList.subList(1, size);
                        }
                        size--;
                        height = ((Placeable) objectRef.element).getHeight();
                        break;
                    }
                    i6++;
                } else {
                    ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            height = 0;
        }
        ArrayList arrayList = size > 0 ? new ArrayList() : null;
        int iM10121getMaxWidthimpl = Constraints.m10121getMaxWidthimpl(jM10111copyZbe2FdA$default) - measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.getWNRItemHorizontalPadding());
        if (!this.$expanded) {
            iM10121getMaxWidthimpl = i5;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iM10121getMaxWidthimpl, measureScope.mo1728roundToPx0680j_4(this.$minimumA11ySize));
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(Constraints.m10120getMaxHeightimpl(jM10111copyZbe2FdA$default), measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(this.$itemMinHeight$delegate)));
        if (arrayList != null) {
            float f = this.$minimumA11ySize;
            boolean z = this.$expanded;
            State<Dp> state = this.$itemMinHeight$delegate;
            int i7 = height;
            ArrayList arrayList2 = new ArrayList(listSubList.size());
            int size3 = listSubList.size();
            int i8 = 0;
            i2 = 0;
            int height2 = i7;
            while (i8 < size3) {
                Measurable measurable2 = listSubList.get(i8);
                List<? extends Measurable> list2 = listSubList;
                ArrayList arrayList3 = arrayList2;
                int i9 = size3;
                int i10 = -height2;
                boolean z2 = z;
                State<Dp> state2 = state;
                int i11 = i8;
                float f2 = f;
                int i12 = i5;
                Placeable placeableMo8808measureBRTryo0 = measurable2.mo8808measureBRTryo0(ConstraintsKt.m10136constrainN9IONVI(ConstraintsKt.m10141offsetNN6EwU$default(jM10111copyZbe2FdA$default, 0, i10, 1, null), Constraints.INSTANCE.m10130fitPrioritizingWidthZbe2FdA(measureScope.mo1728roundToPx0680j_4(f), iCoerceAtLeast, measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$9(state2)), iCoerceAtLeast2)));
                int measuredWidth = placeableMo8808measureBRTryo0.getMeasuredWidth();
                if (z2 && i2 < measuredWidth) {
                    i2 = measuredWidth + measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.getWNRItemHorizontalPadding());
                }
                height2 = placeableMo8808measureBRTryo0.getHeight();
                arrayList3.add(Boolean.valueOf(arrayList.add(placeableMo8808measureBRTryo0)));
                i8 = i11 + 1;
                listSubList = list2;
                z = z2;
                f = f2;
                i5 = i12;
                size3 = i9;
                state = state2;
            }
            i = i5;
        } else {
            i = i5;
            i2 = 0;
        }
        if (!this.$expanded) {
            i3 = i;
            if (WideNavigationRailKt.WideNavigationRailLayout$lambda$4(this.$actualMaxExpandedWidth$delegate) > 0) {
                iCoerceIn = RangesKt.coerceIn(measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$7(this.$widthFullRange$delegate)), i3, RangesKt.coerceAtLeast(WideNavigationRailKt.WideNavigationRailLayout$lambda$1(this.$currentWidth$delegate), i3));
                i4 = iCoerceIn;
            } else {
                i4 = i3;
            }
        } else {
            Placeable placeable = (Placeable) objectRef.element;
            int iMax = Math.max(i2, placeable != null ? placeable.getWidth() : 0);
            i3 = i;
            if (iMax <= i3 || iMax <= iM10123getMinWidthimpl2) {
                i4 = i3;
            } else {
                iCoerceIn = RangesKt.coerceAtMost(measureScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$7(this.$widthFullRange$delegate)), RangesKt.coerceAtMost(Math.max(iMax, iM10123getMinWidthimpl2), Constraints.m10121getMaxWidthimpl(j)));
                this.$actualMaxExpandedWidth$delegate.setIntValue(iCoerceIn);
                i4 = iCoerceIn;
            }
        }
        this.$currentWidth$delegate.setIntValue(i4);
        final ArrayList arrayList4 = arrayList;
        final Arrangement.Vertical vertical = this.$arrangement;
        final State<Dp> state3 = this.$itemVerticalSpacedBy$delegate;
        return MeasureScope.layout$default(measureScope, i4, iM10120getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$WideNavigationRailLayout$1$2$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt$WideNavigationRailLayout$1$2.measure_3p2s80s$lambda$3(objectRef, arrayList4, vertical, iM10120getMaxHeightimpl, state3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit measure_3p2s80s$lambda$3(Ref.ObjectRef objectRef, List list, Arrangement.Vertical vertical, int i, State state, Placeable.PlacementScope placementScope) {
        int height;
        if (objectRef.element == 0 || ((Placeable) objectRef.element).getHeight() <= 0) {
            height = 0;
        } else {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) objectRef.element, 0, 0, 0.0f, 4, null);
            height = ((Placeable) objectRef.element).getHeight() + placementScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WNRHeaderPadding);
        }
        if (list != null) {
            if (!Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                i -= height;
            }
            int[] iArr = new int[list.size()];
            List list2 = list;
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = ((Placeable) list.get(i2)).getHeight();
                if (i2 < list.size() - 1) {
                    iArr[i2] = iArr[i2] + placementScope.mo1728roundToPx0680j_4(WideNavigationRailKt.WideNavigationRailLayout$lambda$8(state));
                }
            }
            int[] iArr2 = new int[list.size()];
            vertical.arrange(placementScope, i, iArr, iArr2);
            if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                height = 0;
            }
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i3), 0, iArr2[i3] + height, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
