package expo.modules.ui;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import expo.modules.kotlin.views.ShadowNodeProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class HostView$MaybeMatchContentsLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $safeHeightPx;
    final /* synthetic */ int $safeWidthPx;
    final /* synthetic */ HostView this$0;

    HostView$MaybeMatchContentsLayout$2$1(HostView hostView, int i, int i2, Density density) {
        this.this$0 = hostView;
        this.$safeWidthPx = i;
        this.$safeHeightPx = i2;
        this.$density = density;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return super.maxIntrinsicHeight(intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return super.maxIntrinsicWidth(intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return super.minIntrinsicHeight(intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return super.minIntrinsicWidth(intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1311measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        int iM10121getMaxWidthimpl;
        int iM10120getMaxHeightimpl;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean zBooleanValue = this.this$0.getProps().getUseViewportSizeMeasurement().getValue().booleanValue();
        int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j);
        if (zBooleanValue && (Constraints.m10121getMaxWidthimpl(j) == Integer.MAX_VALUE || Constraints.m10121getMaxWidthimpl(j) == 0)) {
            iM10121getMaxWidthimpl = this.$safeWidthPx;
        } else {
            iM10121getMaxWidthimpl = Constraints.m10121getMaxWidthimpl(j);
        }
        int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(j);
        if (zBooleanValue && (Constraints.m10120getMaxHeightimpl(j) == Integer.MAX_VALUE || Constraints.m10120getMaxHeightimpl(j) == 0)) {
            iM10120getMaxHeightimpl = this.$safeHeightPx;
        } else {
            iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(j);
        }
        long jConstraints = ConstraintsKt.Constraints(iM10123getMinWidthimpl, iM10121getMaxWidthimpl, iM10122getMinHeightimpl, iM10120getMaxHeightimpl);
        List<? extends Measurable> list = measurables;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo8808measureBRTryo0(jConstraints));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        Iterator it2 = arrayList3.iterator();
        Integer num = null;
        if (it2.hasNext()) {
            numValueOf = Integer.valueOf(((Placeable) it2.next()).getWidth());
            while (it2.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((Placeable) it2.next()).getWidth());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        Iterator it3 = arrayList3.iterator();
        if (it3.hasNext()) {
            Integer numValueOf3 = Integer.valueOf(((Placeable) it3.next()).getHeight());
            loop1: while (true) {
                num = numValueOf3;
                do {
                    if (!it3.hasNext()) {
                        break loop1;
                    }
                    numValueOf3 = Integer.valueOf(((Placeable) it3.next()).getHeight());
                } while (num.compareTo(numValueOf3) >= 0);
            }
        }
        Integer num3 = num;
        int iIntValue2 = num3 != null ? num3.intValue() : 0;
        if (zBooleanValue && (Constraints.m10121getMaxWidthimpl(j) == 0 || Constraints.m10120getMaxHeightimpl(j) == 0)) {
            Density density = this.$density;
            HostView hostView = this.this$0;
            double dMo1731toDpu2uoSUM = density.mo1731toDpu2uoSUM(iIntValue);
            double dMo1731toDpu2uoSUM2 = density.mo1731toDpu2uoSUM(iIntValue2);
            ShadowNodeProxy shadowNodeProxy = hostView.getShadowNodeProxy();
            if (Constraints.m10121getMaxWidthimpl(j) != 0) {
                dMo1731toDpu2uoSUM = Double.NaN;
            }
            if (Constraints.m10120getMaxHeightimpl(j) != 0) {
                dMo1731toDpu2uoSUM2 = Double.NaN;
            }
            shadowNodeProxy.setViewSize(dMo1731toDpu2uoSUM, dMo1731toDpu2uoSUM2);
        }
        return MeasureScope.layout$default(Layout, iIntValue, iIntValue2, null, new Function1() { // from class: expo.modules.ui.HostView$MaybeMatchContentsLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HostView$MaybeMatchContentsLayout$2$1.measure_3p2s80s$lambda$5(arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit measure_3p2s80s$lambda$5(List list, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Placeable.PlacementScope.placeRelative$default(layout, (Placeable) it.next(), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
