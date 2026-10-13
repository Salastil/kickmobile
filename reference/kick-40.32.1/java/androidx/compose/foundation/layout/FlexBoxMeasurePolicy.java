package androidx.compose.foundation.layout;

import androidx.compose.runtime.State;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jl\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J+\u0010)\u001a\u00020\"*\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u0017*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b.\u0010/Jt\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010(\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001b04H\u0082\b¢\u0006\u0004\b5\u00106JW\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001f2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00109\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010:\u001a\u00020&H\u0002¢\u0006\u0004\b;\u0010<JP\u0010=\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&H\u0002JG\u0010B\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002¢\u0006\u0004\bD\u0010EJ_\u0010F\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010C\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\bG\u0010HJ@\u0010I\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010J\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002J$\u0010K\u001a\u00020&*\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010L\u001a\u00020\u0017H\u0002JH\u0010M\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010A\u001a\u00020&2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020&2\u0006\u0010N\u001a\u00020\u0017H\u0002J?\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020&2\u0006\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020VH\u0002¢\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010Z\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020&H\u0002J0\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010T\u001a\u00020&2\u0006\u0010]\u001a\u00020\u00172\u0006\u0010:\u001a\u00020&H\u0002J\"\u0010^\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010b\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J\"\u0010d\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010e\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J'\u0010f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bi\u0010jR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/compose/foundation/layout/FlexBoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "flexBoxConfigState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/layout/FlexBoxConfig;", "<init>", "(Landroidx/compose/runtime/State;)V", "resolvedFlexBoxConfig", "Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measureFlexBox", "flexBoxConfig", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "isHorizontal", "", "measureFlexBox-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/List;JZ)Landroidx/compose/ui/layout/MeasureResult;", "placeFlexItems", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lines", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/layout/FlexLine;", "Lkotlin/collections/ArrayList;", "items", "Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "layoutWidth", "", "layoutHeight", "mainAxisGap", "createFlexItem", "measurable", "createFlexItem-XsoA538", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;ZJ)Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", "needUpfrontCrossAxisCalculation", "needUpfrontCrossAxisCalculation-RMq0m1M", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;J)Z", "buildFlexLines", "crossAxisGap", "needsUpfrontCrossAxisCalculation", "updateTotalCrossSize", "Lkotlin/Function1;", "buildFlexLines-JlE-8fw", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JIIZLkotlin/jvm/functions/Function1;)Ljava/util/ArrayList;", "processFlexLine", "line", "currentLineHypotheticalMainAxisSize", "remainingCrossAxisSize", "processFlexLine-7gjidqw", "(Landroidx/compose/foundation/layout/FlexLine;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJI)V", "resolveFlexibleLengths", "startIndex", "endIndex", "hypotheticalLineSize", "containerMainAxisSize", "applyAlignContentStretch", "totalLinesCrossSize", "applyAlignContentStretch-WWvErGg", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JII)I", "measureFlexItems", "measureFlexItems-HjG58DU", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJ)I", "calculateLineCrossPositions", "totalCrossAxisSpace", "totalCrossAxisSize", "isReverse", "positionItemsOnMainAxis", "isMainAxisReverse", "calculateItemCrossPosition", "flexConfig", "itemBaseline", "lineMaxAboveBaseline", "itemCrossAxisSize", "lineCrossAxisSize", "containerAlignItems", "Landroidx/compose/foundation/layout/FlexAlignItems;", "calculateItemCrossPosition-sT6f14c", "(Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;IIIII)I", "isMainAxisReversedForLayout", "calculateLineCrossAxisSize", "measureItem", "item", "shouldStretch", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewProps.HEIGHT, "minIntrinsicHeight", ViewProps.WIDTH, "maxIntrinsicWidth", "maxIntrinsicHeight", "resolveFlexBoxConfig", "density", "Landroidx/compose/ui/unit/Density;", "resolveFlexBoxConfig-3p2s80s", "(Landroidx/compose/foundation/layout/FlexBoxConfig;Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlexBoxMeasurePolicy implements MeasurePolicy {
    private final State<FlexBoxConfig> flexBoxConfigState;
    private final ResolvedFlexBoxConfig resolvedFlexBoxConfig = new ResolvedFlexBoxConfig();

    /* JADX WARN: Multi-variable type inference failed */
    public FlexBoxMeasurePolicy(State<? extends FlexBoxConfig> state) {
        this.flexBoxConfigState = state;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0052  */
    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        LayoutOrientation layoutOrientation;
        boolean z;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m10123getMinWidthimpl(j), Constraints.m10122getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        ResolvedFlexBoxConfig resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s = m2155resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), measureScope, j);
        int direction = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        if (FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            layoutOrientation = LayoutOrientation.Horizontal;
        } else {
            int direction2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                layoutOrientation = LayoutOrientation.Horizontal;
            } else {
                layoutOrientation = LayoutOrientation.Vertical;
            }
        }
        long jM2319constructorimpl = OrientationIndependentConstraints.m2319constructorimpl(j, layoutOrientation);
        int direction3 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion3 = FlexDirection.INSTANCE;
        if (!FlexDirection.m2162equalsimpl0(direction3, FlexDirection.m2160constructorimpl(0))) {
            int direction4 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion4 = FlexDirection.INSTANCE;
            z = FlexDirection.m2162equalsimpl0(direction4, FlexDirection.m2160constructorimpl(2));
        }
        return m2151measureFlexBoxw1Onq5I(measureScope, resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s, list, jM2319constructorimpl, z);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:27:0x00da  */
    /* JADX INFO: renamed from: measureFlexBox-w1Onq5I, reason: not valid java name */
    private final MeasureResult m2151measureFlexBoxw1Onq5I(final MeasureScope measureScope, final ResolvedFlexBoxConfig resolvedFlexBoxConfig, List<? extends Measurable> list, long j, final boolean z) {
        int i;
        FlexLine flexLine;
        int i2;
        int i3;
        boolean z2;
        int i4;
        ArrayList<ResolvedFlexItemInfo> arrayList;
        int i5;
        FlexBoxMeasurePolicy flexBoxMeasurePolicy = this;
        ArrayList<ResolvedFlexItemInfo> arrayList2 = new ArrayList<>(list.size());
        long j2 = j;
        boolean zM2153needUpfrontCrossAxisCalculationRMq0m1M = flexBoxMeasurePolicy.m2153needUpfrontCrossAxisCalculationRMq0m1M(resolvedFlexBoxConfig, j2);
        int size = list.size();
        boolean z3 = zM2153needUpfrontCrossAxisCalculationRMq0m1M;
        int i6 = 0;
        boolean z4 = false;
        while (true) {
            i = 1;
            if (i6 >= size) {
                break;
            }
            ResolvedFlexItemInfo resolvedFlexItemInfoM2150createFlexItemXsoA538 = flexBoxMeasurePolicy.m2150createFlexItemXsoA538(measureScope, list.get(i6), z, j2);
            if (resolvedFlexItemInfoM2150createFlexItemXsoA538.getOrder() != 0) {
                z4 = true;
            }
            int iM2390getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfoM2150createFlexItemXsoA538.getAlignSelf();
            FlexAlignSelf.Companion companion = FlexAlignSelf.INSTANCE;
            if (FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m2111constructorimpl(5))) {
                z3 = true;
            } else {
                int iM2390getAlignSelf_ov7Qcc$foundation_layout2 = resolvedFlexItemInfoM2150createFlexItemXsoA538.getAlignSelf();
                FlexAlignSelf.Companion companion2 = FlexAlignSelf.INSTANCE;
                if (FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout2, FlexAlignSelf.m2111constructorimpl(4))) {
                    z3 = true;
                }
            }
            arrayList2.add(resolvedFlexItemInfoM2150createFlexItemXsoA538);
            i6++;
            flexBoxMeasurePolicy = this;
            j2 = j;
        }
        if (z4) {
            ArrayList<ResolvedFlexItemInfo> arrayList3 = arrayList2;
            if (arrayList3.size() > 1) {
                CollectionsKt.sortWith(arrayList3, new Comparator() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$measureFlexBox-w1Onq5I$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((ResolvedFlexItemInfo) t).getOrder()), Integer.valueOf(((ResolvedFlexItemInfo) t2).getOrder()));
                    }
                });
            }
        }
        final int iMainAxisGap = resolvedFlexBoxConfig.mainAxisGap();
        int iCrossAxisGap = resolvedFlexBoxConfig.crossAxisGap();
        final ArrayList<FlexLine> arrayList4 = new ArrayList<>(8);
        FlexLine flexLine2 = new FlexLine();
        int iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(j);
        ArrayList<ResolvedFlexItemInfo> arrayList5 = arrayList2;
        int i7 = iM10120getMaxHeightimpl;
        int i8 = 0;
        int hypotheticalMainSize = 0;
        int i9 = 0;
        int crossAxisSize = 0;
        FlexLine flexLine3 = flexLine2;
        int i10 = 0;
        for (int size2 = arrayList5.size(); i10 < size2; size2 = size2) {
            ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList5.get(i10);
            int wrap = resolvedFlexBoxConfig.getWrap();
            FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                int wrap2 = resolvedFlexBoxConfig.getWrap();
                FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                if (FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                    if (i10 <= i8 && resolvedFlexItemInfo.getHypotheticalMainSize() + hypotheticalMainSize > Constraints.m10121getMaxWidthimpl(j)) {
                        flexLine3.setStartIndex(i8);
                        flexLine3.setEndIndex(i10);
                        boolean z5 = z3;
                        int i11 = i9;
                        z2 = z5;
                        i4 = i10;
                        arrayList = arrayList2;
                        m2154processFlexLine7gjidqw(flexLine3, arrayList, resolvedFlexBoxConfig, hypotheticalMainSize - iMainAxisGap, z2, j, i7);
                        crossAxisSize += flexLine3.getCrossAxisSize();
                        flexLine3.setCrossStart(i11);
                        int crossAxisSize2 = flexLine3.getCrossAxisSize() + iCrossAxisGap + i11;
                        int crossAxisSize3 = i7 - (flexLine3.getCrossAxisSize() + iCrossAxisGap);
                        if (crossAxisSize3 < 0) {
                            crossAxisSize3 = 0;
                        }
                        arrayList4.add(flexLine3);
                        flexLine3 = new FlexLine();
                        hypotheticalMainSize = resolvedFlexItemInfo.getHypotheticalMainSize() + iMainAxisGap;
                        i5 = crossAxisSize2;
                        i7 = crossAxisSize3;
                        i8 = i4;
                    } else {
                        boolean z6 = z3;
                        i5 = i9;
                        z2 = z6;
                        i4 = i10;
                        arrayList = arrayList2;
                        hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + iMainAxisGap;
                    }
                } else {
                    boolean z7 = z3;
                    i5 = i9;
                    z2 = z7;
                    i4 = i10;
                    arrayList = arrayList2;
                    hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + iMainAxisGap;
                }
            } else if (i10 <= i8) {
                boolean z8 = z3;
                i5 = i9;
                z2 = z8;
                i4 = i10;
                arrayList = arrayList2;
                hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + iMainAxisGap;
            } else {
                boolean z9 = z3;
                i5 = i9;
                z2 = z9;
                i4 = i10;
                arrayList = arrayList2;
                hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + iMainAxisGap;
            }
            i10 = i4 + 1;
            int i12 = i5;
            z3 = z2;
            i9 = i12;
            arrayList2 = arrayList;
        }
        boolean z10 = z3;
        int i13 = i9;
        final ArrayList<ResolvedFlexItemInfo> arrayList6 = arrayList2;
        if (i8 < arrayList6.size()) {
            flexLine3.setStartIndex(i8);
            flexLine3.setEndIndex(arrayList6.size());
            m2154processFlexLine7gjidqw(flexLine3, arrayList6, resolvedFlexBoxConfig, hypotheticalMainSize - iMainAxisGap, z10, j, i7);
            crossAxisSize += flexLine3.getCrossAxisSize();
            flexLine3.setCrossStart(i13);
            arrayList4.add(flexLine3);
        }
        int i14 = crossAxisSize;
        if (arrayList4.size() == 1) {
            arrayList4.get(0).setCrossAxisSize(Math.max(arrayList4.get(0).getCrossAxisSize(), Constraints.m10122getMinHeightimpl(j)));
        }
        int iM2152measureFlexItemsHjG58DU = m2152measureFlexItemsHjG58DU(arrayList4, arrayList6, resolvedFlexBoxConfig, m2147applyAlignContentStretchWWvErGg(resolvedFlexBoxConfig, arrayList4, j, i14, iCrossAxisGap), z10, j);
        calculateLineCrossPositions(resolvedFlexBoxConfig, Math.max(iM2152measureFlexItemsHjG58DU, Constraints.m10122getMinHeightimpl(j)), arrayList4, iM2152measureFlexItemsHjG58DU, iCrossAxisGap);
        int wrap3 = resolvedFlexBoxConfig.getWrap();
        FlexWrap.Companion companion5 = FlexWrap.INSTANCE;
        int iMax = Math.max(totalCrossAxisSize(arrayList4, FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(2))), Constraints.m10122getMinHeightimpl(j));
        ArrayList<FlexLine> arrayList7 = arrayList4;
        if (!arrayList7.isEmpty()) {
            flexLine = arrayList7.get(0);
            int mainAxisSize = flexLine.getMainAxisSize();
            int lastIndex = CollectionsKt.getLastIndex(arrayList7);
            if (1 <= lastIndex) {
                while (true) {
                    FlexLine flexLine4 = arrayList7.get(i);
                    int mainAxisSize2 = flexLine4.getMainAxisSize();
                    if (mainAxisSize < mainAxisSize2) {
                        flexLine = flexLine4;
                        mainAxisSize = mainAxisSize2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            flexLine = null;
        }
        FlexLine flexLine5 = flexLine;
        int iMax2 = Math.max(flexLine5 != null ? flexLine5.getMainAxisSize() : Constraints.m10123getMinWidthimpl(j), Constraints.m10123getMinWidthimpl(j));
        int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j);
        int iM10121getMaxWidthimpl = Constraints.m10121getMaxWidthimpl(j);
        if (iMax2 < iM10123getMinWidthimpl) {
            iMax2 = iM10123getMinWidthimpl;
        }
        if (iMax2 <= iM10121getMaxWidthimpl) {
            iM10121getMaxWidthimpl = iMax2;
        }
        if (z) {
            int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(j);
            int iM10120getMaxHeightimpl2 = Constraints.m10120getMaxHeightimpl(j);
            if (iMax < iM10122getMinHeightimpl) {
                iMax = iM10122getMinHeightimpl;
            }
            if (iMax <= iM10120getMaxHeightimpl2) {
                iM10120getMaxHeightimpl2 = iMax;
            }
            i3 = iM10120getMaxHeightimpl2;
            i2 = iM10121getMaxWidthimpl;
        } else {
            int iM10122getMinHeightimpl2 = Constraints.m10122getMinHeightimpl(j);
            int iM10120getMaxHeightimpl3 = Constraints.m10120getMaxHeightimpl(j);
            if (iMax < iM10122getMinHeightimpl2) {
                iMax = iM10122getMinHeightimpl2;
            }
            if (iMax <= iM10120getMaxHeightimpl3) {
                iM10120getMaxHeightimpl3 = iMax;
            }
            i2 = iM10120getMaxHeightimpl3;
            i3 = iM10121getMaxWidthimpl;
        }
        final int i15 = i2;
        final int i16 = i3;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlexBoxMeasurePolicy.measureFlexBox_w1Onq5I$lambda$4(this.f$0, arrayList4, arrayList6, measureScope, resolvedFlexBoxConfig, i15, i16, iMainAxisGap, z, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit measureFlexBox_w1Onq5I$lambda$4(FlexBoxMeasurePolicy flexBoxMeasurePolicy, ArrayList arrayList, ArrayList arrayList2, MeasureScope measureScope, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z, Placeable.PlacementScope placementScope) {
        flexBoxMeasurePolicy.placeFlexItems(placementScope, arrayList, arrayList2, measureScope.getLayoutDirection(), resolvedFlexBoxConfig, i, i2, i3, z);
        return Unit.INSTANCE;
    }

    private final void placeFlexItems(Placeable.PlacementScope placementScope, ArrayList<FlexLine> arrayList, ArrayList<ResolvedFlexItemInfo> arrayList2, LayoutDirection layoutDirection, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z) {
        int crossPosition;
        int mainPosition;
        ArrayList<FlexLine> arrayList3 = arrayList;
        int size = arrayList3.size();
        for (int i4 = 0; i4 < size; i4++) {
            FlexLine flexLine = arrayList3.get(i4);
            positionItemsOnMainAxis(arrayList2, resolvedFlexBoxConfig, z ? i : i2, flexLine, i3, isMainAxisReversedForLayout(resolvedFlexBoxConfig, layoutDirection));
            int startIndex = flexLine.getStartIndex();
            int endIndex = flexLine.getEndIndex();
            if (startIndex < 0 || startIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex < 0 || endIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList2.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (startIndex < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(startIndex);
                if (z) {
                    crossPosition = resolvedFlexItemInfo.getMainPosition();
                } else {
                    crossPosition = resolvedFlexItemInfo.getCrossPosition();
                }
                int i5 = crossPosition;
                if (z) {
                    mainPosition = resolvedFlexItemInfo.getCrossPosition();
                } else {
                    mainPosition = resolvedFlexItemInfo.getMainPosition();
                }
                int i6 = mainPosition;
                Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i5, i6, 0.0f, 4, null);
                }
                startIndex++;
            }
        }
    }

    /* JADX INFO: renamed from: createFlexItem-XsoA538, reason: not valid java name */
    private final ResolvedFlexItemInfo m2150createFlexItemXsoA538(MeasureScope measureScope, Measurable measurable, boolean z, long j) {
        int maxContentSize$foundation_layout;
        Object parentData = measurable.getParentData();
        FlexBoxChildDataNode flexBoxChildDataNode = parentData instanceof FlexBoxChildDataNode ? (FlexBoxChildDataNode) parentData : null;
        ResolvedFlexItemInfo resolvedFlexItemInfo = new ResolvedFlexItemInfo();
        if (flexBoxChildDataNode != null) {
            resolvedFlexItemInfo.m2392prepareRMq0m1M(measureScope, j);
            flexBoxChildDataNode.getConfig().configure(resolvedFlexItemInfo);
        }
        resolvedFlexItemInfo.setMeasurable(measurable);
        int minMainAxisSize$foundation_layout = resolvedFlexItemInfo.getMinMainAxisSize$foundation_layout(z);
        if (FlexBasis.m2130isDpimpl$foundation_layout(resolvedFlexItemInfo.getBasis())) {
            maxContentSize$foundation_layout = measureScope.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(FlexBasis.m2127getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis())));
        } else if (!FlexBasis.m2131isPercentimpl$foundation_layout(resolvedFlexItemInfo.getBasis())) {
            maxContentSize$foundation_layout = FlexBasis.m2129isAutoimpl$foundation_layout(resolvedFlexItemInfo.getBasis()) ? resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z) : resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else if (Constraints.m10121getMaxWidthimpl(j) == Integer.MAX_VALUE || Float.isNaN(FlexBasis.m2127getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis()))) {
            maxContentSize$foundation_layout = resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else {
            maxContentSize$foundation_layout = (int) (Constraints.m10121getMaxWidthimpl(j) * FlexBasis.m2127getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis()));
        }
        resolvedFlexItemInfo.setFlexBaseSize(maxContentSize$foundation_layout);
        if (maxContentSize$foundation_layout >= minMainAxisSize$foundation_layout) {
            minMainAxisSize$foundation_layout = maxContentSize$foundation_layout;
        }
        resolvedFlexItemInfo.setHypotheticalMainSize(minMainAxisSize$foundation_layout);
        resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
        return resolvedFlexItemInfo;
    }

    /* JADX INFO: renamed from: needUpfrontCrossAxisCalculation-RMq0m1M, reason: not valid java name */
    private final boolean m2153needUpfrontCrossAxisCalculationRMq0m1M(ResolvedFlexBoxConfig resolvedFlexBoxConfig, long j) {
        int alignItems = resolvedFlexBoxConfig.getAlignItems();
        FlexAlignItems.Companion companion = FlexAlignItems.INSTANCE;
        if (!FlexAlignItems.m2101equalsimpl0(alignItems, FlexAlignItems.m2099constructorimpl(3))) {
            int alignItems2 = resolvedFlexBoxConfig.getAlignItems();
            FlexAlignItems.Companion companion2 = FlexAlignItems.INSTANCE;
            if (!FlexAlignItems.m2101equalsimpl0(alignItems2, FlexAlignItems.m2099constructorimpl(4))) {
                int wrap = resolvedFlexBoxConfig.getWrap();
                FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                    int wrap2 = resolvedFlexBoxConfig.getWrap();
                    FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                        return false;
                    }
                }
                int alignContent = resolvedFlexBoxConfig.getAlignContent();
                FlexAlignContent.Companion companion5 = FlexAlignContent.INSTANCE;
                if (!FlexAlignContent.m2088equalsimpl0(alignContent, FlexAlignContent.m2086constructorimpl(3)) || Constraints.m10120getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x009d  */
    /* JADX WARN: Code duplicated, block: B:8:0x004f  */
    /* JADX INFO: renamed from: buildFlexLines-JlE-8fw, reason: not valid java name */
    private final ArrayList<FlexLine> m2148buildFlexLinesJlE8fw(ResolvedFlexBoxConfig flexBoxConfig, ArrayList<ResolvedFlexItemInfo> items, long constraints, int mainAxisGap, int crossAxisGap, boolean needsUpfrontCrossAxisCalculation, Function1<? super Integer, Unit> updateTotalCrossSize) {
        ArrayList<FlexLine> arrayList = new ArrayList<>(8);
        FlexLine flexLine = new FlexLine();
        int iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(constraints);
        ArrayList<ResolvedFlexItemInfo> arrayList2 = items;
        int size = arrayList2.size();
        FlexLine flexLine2 = flexLine;
        int crossAxisSize = iM10120getMaxHeightimpl;
        int i = 0;
        int hypotheticalMainSize = 0;
        int crossAxisSize2 = 0;
        int crossAxisSize3 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(i2);
            int wrap = flexBoxConfig.getWrap();
            FlexWrap.Companion companion = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                int wrap2 = flexBoxConfig.getWrap();
                FlexWrap.Companion companion2 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                    hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
                } else if (i2 <= i && resolvedFlexItemInfo.getHypotheticalMainSize() + hypotheticalMainSize > Constraints.m10121getMaxWidthimpl(constraints)) {
                    flexLine2.setStartIndex(i);
                    flexLine2.setEndIndex(i2);
                    int i3 = crossAxisSize2;
                    m2154processFlexLine7gjidqw(flexLine2, items, flexBoxConfig, hypotheticalMainSize - mainAxisGap, needsUpfrontCrossAxisCalculation, constraints, crossAxisSize);
                    crossAxisSize3 += flexLine2.getCrossAxisSize();
                    flexLine2.setCrossStart(i3);
                    crossAxisSize2 = i3 + flexLine2.getCrossAxisSize() + crossAxisGap;
                    crossAxisSize -= flexLine2.getCrossAxisSize() + crossAxisGap;
                    if (crossAxisSize < 0) {
                        crossAxisSize = 0;
                    }
                    arrayList.add(flexLine2);
                    FlexLine flexLine3 = new FlexLine();
                    hypotheticalMainSize = resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
                    flexLine2 = flexLine3;
                    i = i2;
                } else {
                    hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
                }
            } else if (i2 <= i) {
                hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
            } else {
                hypotheticalMainSize += resolvedFlexItemInfo.getHypotheticalMainSize() + mainAxisGap;
            }
        }
        if (i < items.size()) {
            flexLine2.setStartIndex(i);
            flexLine2.setEndIndex(items.size());
            m2154processFlexLine7gjidqw(flexLine2, items, flexBoxConfig, hypotheticalMainSize - mainAxisGap, needsUpfrontCrossAxisCalculation, constraints, crossAxisSize);
            crossAxisSize3 += flexLine2.getCrossAxisSize();
            flexLine2.setCrossStart(crossAxisSize2);
            arrayList.add(flexLine2);
        }
        updateTotalCrossSize.invoke(Integer.valueOf(crossAxisSize3));
        return arrayList;
    }

    private final int resolveFlexibleLengths(boolean isHorizontal, ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, int startIndex, int endIndex, int hypotheticalLineSize, int containerMainAxisSize) {
        int i;
        boolean z;
        ArrayList<ResolvedFlexItemInfo> arrayList = items;
        int i2 = startIndex;
        int i3 = containerMainAxisSize;
        int i4 = endIndex - i2;
        int iMainAxisGap = i4 > 0 ? (i4 - 1) * flexBoxConfig.mainAxisGap() : 0;
        if (i3 == Integer.MAX_VALUE) {
            if (i2 < 0 || i2 > arrayList.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex < 0 || endIndex > arrayList.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (i2 < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList.get(i2);
                resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
                iMainAxisGap += resolvedFlexItemInfo.getTargetMainSize();
                i2++;
            }
            return iMainAxisGap;
        }
        boolean z2 = hypotheticalLineSize < i3;
        if (i2 < 0 || i2 > arrayList.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
        }
        if (endIndex < 0 || endIndex > arrayList.size()) {
            throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
        }
        int targetMainSize = 0;
        int flexBaseSize = 0;
        float shrink$foundation_layout = 0.0f;
        float grow$foundation_layout = 0.0f;
        int i5 = 0;
        float shrink$foundation_layout2 = 0.0f;
        for (int i6 = i2; i6 < endIndex; i6++) {
            ResolvedFlexItemInfo resolvedFlexItemInfo2 = arrayList.get(i6);
            float grow$foundation_layout2 = z2 ? resolvedFlexItemInfo2.getGrow() : resolvedFlexItemInfo2.getShrink();
            if (grow$foundation_layout2 == 0.0f || (!z2 && resolvedFlexItemInfo2.getFlexBaseSize() <= resolvedFlexItemInfo2.getHypotheticalMainSize())) {
                resolvedFlexItemInfo2.setTargetMainSize(resolvedFlexItemInfo2.getHypotheticalMainSize());
                resolvedFlexItemInfo2.setFrozen(true);
                targetMainSize += resolvedFlexItemInfo2.getTargetMainSize();
            } else {
                resolvedFlexItemInfo2.setFrozen(false);
                i5++;
                flexBaseSize += resolvedFlexItemInfo2.getFlexBaseSize();
                shrink$foundation_layout += grow$foundation_layout2;
                if (z2) {
                    grow$foundation_layout += resolvedFlexItemInfo2.getGrow();
                } else {
                    shrink$foundation_layout2 += resolvedFlexItemInfo2.getShrink() * resolvedFlexItemInfo2.getFlexBaseSize();
                }
            }
        }
        int targetMainSize2 = 0;
        float f = ((i3 - iMainAxisGap) - targetMainSize) - flexBaseSize;
        float f2 = 1.0f;
        if (z2) {
            float f3 = i3 - ((iMainAxisGap + targetMainSize) + flexBaseSize);
            if (shrink$foundation_layout < 1.0f) {
                float f4 = f * shrink$foundation_layout;
                if (Math.abs(f4) < Math.abs(f3)) {
                    f3 = f4;
                }
            }
            if (i2 < 0 || i2 > arrayList.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex < 0 || endIndex > arrayList.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
            }
            while (i2 < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo3 = arrayList.get(i2);
                if (!resolvedFlexItemInfo3.getIsFrozen()) {
                    int iRound = Math.round((grow$foundation_layout > 0.0f ? resolvedFlexItemInfo3.getGrow() / grow$foundation_layout : 0.0f) * f3);
                    f3 -= iRound;
                    grow$foundation_layout -= resolvedFlexItemInfo3.getGrow();
                    resolvedFlexItemInfo3.setTargetMainSize(resolvedFlexItemInfo3.getFlexBaseSize() + iRound);
                    targetMainSize2 += resolvedFlexItemInfo3.getTargetMainSize();
                }
                i2++;
            }
        } else {
            int i7 = 0;
            int targetMainSize3 = 0;
            boolean z3 = true;
            while (z3 && i7 < i4) {
                i7++;
                if (i5 != 0) {
                    float f5 = i3 - ((iMainAxisGap + targetMainSize) + flexBaseSize);
                    if (shrink$foundation_layout < f2) {
                        float f6 = f * shrink$foundation_layout;
                        if (Math.abs(f6) < Math.abs(f5)) {
                            f5 = f6;
                        }
                    }
                    float fAbs = Math.abs(f5);
                    if (i2 < 0 || i2 > arrayList.size()) {
                        throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
                    }
                    if (endIndex < 0 || endIndex > arrayList.size()) {
                        throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
                    }
                    int i8 = i2;
                    float f7 = fAbs;
                    float f8 = shrink$foundation_layout2;
                    z3 = false;
                    targetMainSize3 = 0;
                    while (i8 < endIndex) {
                        ResolvedFlexItemInfo resolvedFlexItemInfo4 = arrayList.get(i8);
                        if (resolvedFlexItemInfo4.getIsFrozen()) {
                            i = i4;
                            z = true;
                        } else {
                            float shrink$foundation_layout3 = resolvedFlexItemInfo4.getShrink() * resolvedFlexItemInfo4.getFlexBaseSize();
                            int iRound2 = Math.round((f8 > 0.0f ? shrink$foundation_layout3 / f8 : 0.0f) * f7);
                            int flexBaseSize2 = resolvedFlexItemInfo4.getFlexBaseSize() - iRound2;
                            i = i4;
                            float f9 = f7;
                            int minMainAxisSize$foundation_layout = resolvedFlexItemInfo4.getMinMainAxisSize$foundation_layout(isHorizontal);
                            if (flexBaseSize2 < minMainAxisSize$foundation_layout) {
                                z = true;
                                resolvedFlexItemInfo4.setFrozen(true);
                                float flexBaseSize3 = f9 - (resolvedFlexItemInfo4.getFlexBaseSize() - minMainAxisSize$foundation_layout);
                                f8 -= shrink$foundation_layout3;
                                resolvedFlexItemInfo4.setTargetMainSize(minMainAxisSize$foundation_layout);
                                i5--;
                                targetMainSize += minMainAxisSize$foundation_layout;
                                flexBaseSize -= resolvedFlexItemInfo4.getFlexBaseSize();
                                shrink$foundation_layout2 -= shrink$foundation_layout3;
                                shrink$foundation_layout -= resolvedFlexItemInfo4.getShrink();
                                f7 = flexBaseSize3;
                                z3 = true;
                            } else {
                                z = true;
                                f7 = f9 - iRound2;
                                f8 -= shrink$foundation_layout3;
                                resolvedFlexItemInfo4.setTargetMainSize(flexBaseSize2);
                                targetMainSize3 += resolvedFlexItemInfo4.getTargetMainSize();
                            }
                        }
                        i8++;
                        arrayList = items;
                        i4 = i;
                    }
                    arrayList = items;
                    i3 = containerMainAxisSize;
                    f2 = 1.0f;
                } else {
                    targetMainSize2 = 0;
                }
            }
            targetMainSize2 = targetMainSize3;
        }
        return iMainAxisGap + targetMainSize + targetMainSize2;
    }

    /* JADX INFO: renamed from: applyAlignContentStretch-WWvErGg, reason: not valid java name */
    private final int m2147applyAlignContentStretchWWvErGg(ResolvedFlexBoxConfig flexBoxConfig, ArrayList<FlexLine> lines, long constraints, int totalLinesCrossSize, int crossAxisGap) {
        int alignContent = flexBoxConfig.getAlignContent();
        FlexAlignContent.Companion companion = FlexAlignContent.INSTANCE;
        if (FlexAlignContent.m2088equalsimpl0(alignContent, FlexAlignContent.m2086constructorimpl(3)) && Constraints.m10122getMinHeightimpl(constraints) != Integer.MAX_VALUE && !lines.isEmpty() && lines.size() != 1) {
            int size = (lines.size() - 1) * crossAxisGap;
            int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(constraints);
            if (totalLinesCrossSize + size < iM10122getMinHeightimpl) {
                int i = (iM10122getMinHeightimpl - totalLinesCrossSize) - size;
                if (i < 0) {
                    i = 0;
                }
                int size2 = i / lines.size();
                ArrayList<FlexLine> arrayList = lines;
                int size3 = arrayList.size();
                int crossAxisSize = 0;
                for (int i2 = 0; i2 < size3; i2++) {
                    FlexLine flexLine = arrayList.get(i2);
                    flexLine.setCrossStart(crossAxisSize);
                    flexLine.setCrossAxisSize(flexLine.getCrossAxisSize() + size2);
                    crossAxisSize += flexLine.getCrossAxisSize() + crossAxisGap;
                    totalLinesCrossSize += size2;
                }
            }
        }
        return totalLinesCrossSize;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    private final void calculateLineCrossPositions(ResolvedFlexBoxConfig flexBoxConfig, int totalCrossAxisSpace, ArrayList<FlexLine> lines, int totalLinesCrossSize, int crossAxisGap) {
        int size;
        if (lines.isEmpty() || lines.size() == 1) {
            return;
        }
        int size2 = (totalCrossAxisSpace - totalLinesCrossSize) - ((lines.size() - 1) * crossAxisGap);
        int alignContent = flexBoxConfig.getAlignContent();
        FlexAlignContent.Companion companion = FlexAlignContent.INSTANCE;
        if (FlexAlignContent.m2088equalsimpl0(alignContent, FlexAlignContent.m2086constructorimpl(5))) {
            size = size2 / lines.size();
        } else {
            FlexAlignContent.Companion companion2 = FlexAlignContent.INSTANCE;
            size = FlexAlignContent.m2088equalsimpl0(alignContent, FlexAlignContent.m2086constructorimpl(4)) ? size2 / (lines.size() - 1) : 0;
        }
        int alignContent2 = flexBoxConfig.getAlignContent();
        FlexAlignContent.Companion companion3 = FlexAlignContent.INSTANCE;
        if (!FlexAlignContent.m2088equalsimpl0(alignContent2, FlexAlignContent.m2086constructorimpl(1))) {
            FlexAlignContent.Companion companion4 = FlexAlignContent.INSTANCE;
            if (FlexAlignContent.m2088equalsimpl0(alignContent2, FlexAlignContent.m2086constructorimpl(2))) {
                size2 /= 2;
            } else {
                FlexAlignContent.Companion companion5 = FlexAlignContent.INSTANCE;
                if (FlexAlignContent.m2088equalsimpl0(alignContent2, FlexAlignContent.m2086constructorimpl(5))) {
                    size2 = size / 2;
                } else {
                    int wrap = flexBoxConfig.getWrap();
                    FlexWrap.Companion companion6 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(2))) {
                        size2 = 0;
                    }
                }
            }
        } else {
            int wrap2 = flexBoxConfig.getWrap();
            FlexWrap.Companion companion7 = FlexWrap.INSTANCE;
            if (FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                size2 = 0;
            }
        }
        int wrap3 = flexBoxConfig.getWrap();
        FlexWrap.Companion companion8 = FlexWrap.INSTANCE;
        IntRange intRangeReversed = FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(2)) ? RangesKt.reversed(CollectionsKt.getIndices(lines)) : CollectionsKt.getIndices(lines);
        int first = intRangeReversed.getFirst();
        int last = intRangeReversed.getLast();
        int step = intRangeReversed.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            FlexLine flexLine = lines.get(first);
            flexLine.setCrossStart(size2);
            size2 += flexLine.getCrossAxisSize() + size + crossAxisGap;
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    private final int totalCrossAxisSize(ArrayList<FlexLine> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        int lastIndex = z ? 0 : CollectionsKt.getLastIndex(arrayList);
        return arrayList.get(lastIndex).getCrossStart() + arrayList.get(lastIndex).getCrossAxisSize();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    private final void positionItemsOnMainAxis(ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, int containerMainAxisSize, FlexLine line, int mainAxisGap, boolean isMainAxisReverse) {
        int i;
        IntRange intRangeUntil;
        int endIndex = line.getEndIndex() - line.getStartIndex();
        if (endIndex == 0) {
            return;
        }
        int mainAxisSize = containerMainAxisSize - line.getMainAxisSize();
        int justifyContent = flexBoxConfig.getJustifyContent();
        FlexJustifyContent.Companion companion = FlexJustifyContent.INSTANCE;
        if (FlexJustifyContent.m2173equalsimpl0(justifyContent, FlexJustifyContent.m2171constructorimpl(4))) {
            i = mainAxisSize / endIndex;
        } else {
            FlexJustifyContent.Companion companion2 = FlexJustifyContent.INSTANCE;
            if (!FlexJustifyContent.m2173equalsimpl0(justifyContent, FlexJustifyContent.m2171constructorimpl(3))) {
                FlexJustifyContent.Companion companion3 = FlexJustifyContent.INSTANCE;
                if (FlexJustifyContent.m2173equalsimpl0(justifyContent, FlexJustifyContent.m2171constructorimpl(5))) {
                    i = mainAxisSize / (endIndex + 1);
                } else {
                    i = 0;
                }
            } else if (endIndex > 1) {
                i = mainAxisSize / (endIndex - 1);
            } else {
                i = 0;
            }
        }
        int justifyContent2 = flexBoxConfig.getJustifyContent();
        FlexJustifyContent.Companion companion4 = FlexJustifyContent.INSTANCE;
        if (!FlexJustifyContent.m2173equalsimpl0(justifyContent2, FlexJustifyContent.m2171constructorimpl(1))) {
            FlexJustifyContent.Companion companion5 = FlexJustifyContent.INSTANCE;
            if (FlexJustifyContent.m2173equalsimpl0(justifyContent2, FlexJustifyContent.m2171constructorimpl(2))) {
                mainAxisSize /= 2;
            } else {
                FlexJustifyContent.Companion companion6 = FlexJustifyContent.INSTANCE;
                if (FlexJustifyContent.m2173equalsimpl0(justifyContent2, FlexJustifyContent.m2171constructorimpl(4))) {
                    mainAxisSize = i / 2;
                } else {
                    FlexJustifyContent.Companion companion7 = FlexJustifyContent.INSTANCE;
                    if (FlexJustifyContent.m2173equalsimpl0(justifyContent2, FlexJustifyContent.m2171constructorimpl(5))) {
                        mainAxisSize = i;
                    } else if (!isMainAxisReverse) {
                        mainAxisSize = 0;
                    }
                }
            }
        } else if (isMainAxisReverse) {
            mainAxisSize = 0;
        }
        if (isMainAxisReverse) {
            intRangeUntil = RangesKt.downTo(line.getEndIndex() - 1, line.getStartIndex());
        } else {
            intRangeUntil = RangesKt.until(line.getStartIndex(), line.getEndIndex());
        }
        int first = intRangeUntil.getFirst();
        int last = intRangeUntil.getLast();
        int step = intRangeUntil.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            ResolvedFlexItemInfo resolvedFlexItemInfo = items.get(first);
            resolvedFlexItemInfo.setMainPosition(mainAxisSize);
            mainAxisSize += resolvedFlexItemInfo.getTargetMainSize() + i + mainAxisGap;
            resolvedFlexItemInfo.setCrossPosition(line.getCrossStart() + m2149calculateItemCrossPositionsT6f14c(resolvedFlexItemInfo, resolvedFlexItemInfo.getBaseline(), line.getMaxAboveBaseline(), resolvedFlexItemInfo.getCrossAxisSize(), line.getCrossAxisSize(), flexBoxConfig.getAlignItems()));
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    /* JADX INFO: renamed from: calculateItemCrossPosition-sT6f14c, reason: not valid java name */
    private final int m2149calculateItemCrossPositionsT6f14c(ResolvedFlexItemInfo flexConfig, int itemBaseline, int lineMaxAboveBaseline, int itemCrossAxisSize, int lineCrossAxisSize, int containerAlignItems) {
        int iM2111constructorimpl;
        int iM2390getAlignSelf_ov7Qcc$foundation_layout = flexConfig.getAlignSelf();
        FlexAlignSelf.Companion companion = FlexAlignSelf.INSTANCE;
        if (!FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m2111constructorimpl(0))) {
            iM2111constructorimpl = flexConfig.getAlignSelf();
        } else {
            FlexAlignItems.Companion companion2 = FlexAlignItems.INSTANCE;
            if (!FlexAlignItems.m2101equalsimpl0(containerAlignItems, FlexAlignItems.m2099constructorimpl(0))) {
                FlexAlignItems.Companion companion3 = FlexAlignItems.INSTANCE;
                if (!FlexAlignItems.m2101equalsimpl0(containerAlignItems, FlexAlignItems.m2099constructorimpl(1))) {
                    FlexAlignItems.Companion companion4 = FlexAlignItems.INSTANCE;
                    if (!FlexAlignItems.m2101equalsimpl0(containerAlignItems, FlexAlignItems.m2099constructorimpl(2))) {
                        FlexAlignItems.Companion companion5 = FlexAlignItems.INSTANCE;
                        if (!FlexAlignItems.m2101equalsimpl0(containerAlignItems, FlexAlignItems.m2099constructorimpl(3))) {
                            FlexAlignItems.Companion companion6 = FlexAlignItems.INSTANCE;
                            if (!FlexAlignItems.m2101equalsimpl0(containerAlignItems, FlexAlignItems.m2099constructorimpl(4))) {
                                FlexAlignSelf.Companion companion7 = FlexAlignSelf.INSTANCE;
                                iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(1);
                            } else {
                                FlexAlignSelf.Companion companion8 = FlexAlignSelf.INSTANCE;
                                iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(5);
                            }
                        } else {
                            FlexAlignSelf.Companion companion9 = FlexAlignSelf.INSTANCE;
                            iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(4);
                        }
                    } else {
                        FlexAlignSelf.Companion companion10 = FlexAlignSelf.INSTANCE;
                        iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(3);
                    }
                } else {
                    FlexAlignSelf.Companion companion11 = FlexAlignSelf.INSTANCE;
                    iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(2);
                }
            } else {
                FlexAlignSelf.Companion companion12 = FlexAlignSelf.INSTANCE;
                iM2111constructorimpl = FlexAlignSelf.m2111constructorimpl(1);
            }
        }
        FlexAlignSelf.Companion companion13 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m2113equalsimpl0(iM2111constructorimpl, FlexAlignSelf.m2111constructorimpl(1))) {
            return 0;
        }
        FlexAlignSelf.Companion companion14 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m2113equalsimpl0(iM2111constructorimpl, FlexAlignSelf.m2111constructorimpl(2))) {
            return lineCrossAxisSize - itemCrossAxisSize;
        }
        FlexAlignSelf.Companion companion15 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m2113equalsimpl0(iM2111constructorimpl, FlexAlignSelf.m2111constructorimpl(3))) {
            return (lineCrossAxisSize - itemCrossAxisSize) / 2;
        }
        FlexAlignSelf.Companion companion16 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m2113equalsimpl0(iM2111constructorimpl, FlexAlignSelf.m2111constructorimpl(4))) {
            return 0;
        }
        FlexAlignSelf.Companion companion17 = FlexAlignSelf.INSTANCE;
        if (!FlexAlignSelf.m2113equalsimpl0(iM2111constructorimpl, FlexAlignSelf.m2111constructorimpl(5)) || itemBaseline == Integer.MIN_VALUE) {
            return 0;
        }
        return lineMaxAboveBaseline - itemBaseline;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0027  */
    private final boolean isMainAxisReversedForLayout(ResolvedFlexBoxConfig flexBoxConfig, LayoutDirection layoutDirection) {
        boolean z;
        int direction = flexBoxConfig.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        if (FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(2))) {
            z = true;
        } else {
            int direction2 = flexBoxConfig.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(3))) {
                z = true;
            } else {
                z = false;
            }
        }
        int direction3 = flexBoxConfig.getDirection();
        FlexDirection.Companion companion3 = FlexDirection.INSTANCE;
        if (!FlexDirection.m2162equalsimpl0(direction3, FlexDirection.m2160constructorimpl(0))) {
            int direction4 = flexBoxConfig.getDirection();
            FlexDirection.Companion companion4 = FlexDirection.INSTANCE;
            if (!FlexDirection.m2162equalsimpl0(direction4, FlexDirection.m2160constructorimpl(2))) {
                return z;
            }
        }
        if (layoutDirection == LayoutDirection.Rtl) {
            return !z;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0088  */
    /* JADX WARN: Code duplicated, block: B:20:0x0094  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s = m2155resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        int direction = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        int i2 = 0;
        if (!FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            int direction2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (!FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int iMainAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int iCrossAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.crossAxisGap();
                int size = list.size();
                int i3 = 0;
                int iMax = 0;
                int i4 = 0;
                while (i2 < size) {
                    IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
                    int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
                    int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(iMinIntrinsicHeight);
                    int wrap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                    FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                        int wrap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                        FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                        if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                            i4 += iMinIntrinsicHeight + iMainAxisGap;
                            iMax = Math.max(iMax, iMinIntrinsicWidth);
                        } else if (i4 != 0 || i4 + iMinIntrinsicHeight <= i) {
                            i4 += iMinIntrinsicHeight + iMainAxisGap;
                            iMax = Math.max(iMax, iMinIntrinsicWidth);
                        } else {
                            i3 += iMax + iCrossAxisGap;
                            iMax = iMinIntrinsicWidth;
                            i4 = iMinIntrinsicHeight + iMainAxisGap;
                        }
                    } else if (i4 != 0) {
                        i4 += iMinIntrinsicHeight + iMainAxisGap;
                        iMax = Math.max(iMax, iMinIntrinsicWidth);
                    } else {
                        i4 += iMinIntrinsicHeight + iMainAxisGap;
                        iMax = Math.max(iMax, iMinIntrinsicWidth);
                    }
                    i2++;
                }
                return i3 + iMax;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int wrap3 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
        FlexWrap.Companion companion5 = FlexWrap.INSTANCE;
        if (!FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(1))) {
            int wrap4 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
            FlexWrap.Companion companion6 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap4, FlexWrap.m2184constructorimpl(2))) {
                int size2 = list.size();
                int iMinIntrinsicWidth2 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    iMinIntrinsicWidth2 += list.get(i5).minIntrinsicWidth(i);
                }
                return iMinIntrinsicWidth2 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * iMainAxisGap2);
            }
        }
        int size3 = list.size();
        int iMax2 = 0;
        while (i2 < size3) {
            iMax2 = Math.max(iMax2, list.get(i2).minIntrinsicWidth(i));
            i2++;
        }
        return iMax2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:37:0x0103  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s = m2155resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        int direction = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        int i2 = 0;
        if (!FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            int direction2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (!FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int iMainAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int wrap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                    int wrap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                    FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                        int size = list.size();
                        int iMinIntrinsicHeight = 0;
                        for (int i3 = 0; i3 < size; i3++) {
                            iMinIntrinsicHeight += list.get(i3).minIntrinsicHeight(i);
                        }
                        return iMinIntrinsicHeight + (RangesKt.coerceAtLeast(list.size() - 1, 0) * iMainAxisGap);
                    }
                }
                int size2 = list.size();
                int iMax = 0;
                while (i2 < size2) {
                    iMax = Math.max(iMax, list.get(i2).minIntrinsicHeight(i));
                    i2++;
                }
                return iMax;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int iCrossAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.crossAxisGap();
        int size3 = list.size();
        int i4 = 0;
        int iMax2 = 0;
        int i5 = 0;
        while (i2 < size3) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE);
            int iMinIntrinsicHeight2 = intrinsicMeasurable.minIntrinsicHeight(iMinIntrinsicWidth);
            int wrap3 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
            FlexWrap.Companion companion5 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(1))) {
                int wrap4 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                FlexWrap.Companion companion6 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap4, FlexWrap.m2184constructorimpl(2))) {
                    i5 += iMinIntrinsicWidth + iMainAxisGap2;
                    iMax2 = Math.max(iMax2, iMinIntrinsicHeight2);
                } else if (i5 != 0 || i5 + iMinIntrinsicWidth <= i) {
                    i5 += iMinIntrinsicWidth + iMainAxisGap2;
                    iMax2 = Math.max(iMax2, iMinIntrinsicHeight2);
                } else {
                    i4 += iMax2 + iCrossAxisGap;
                    iMax2 = iMinIntrinsicHeight2;
                    i5 = iMinIntrinsicWidth + iMainAxisGap2;
                }
            } else if (i5 != 0) {
                i5 += iMinIntrinsicWidth + iMainAxisGap2;
                iMax2 = Math.max(iMax2, iMinIntrinsicHeight2);
            } else {
                i5 += iMinIntrinsicWidth + iMainAxisGap2;
                iMax2 = Math.max(iMax2, iMinIntrinsicHeight2);
            }
            i2++;
        }
        return i4 + iMax2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0088  */
    /* JADX WARN: Code duplicated, block: B:20:0x0094  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s = m2155resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        int direction = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        int i2 = 0;
        if (!FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            int direction2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (!FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int iMainAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int iCrossAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.crossAxisGap();
                int size = list.size();
                int i3 = 0;
                int iMax = 0;
                int i4 = 0;
                while (i2 < size) {
                    IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
                    int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
                    int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(iMaxIntrinsicHeight);
                    int wrap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                    FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                        int wrap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                        FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                        if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                            i4 += iMaxIntrinsicHeight + iMainAxisGap;
                            iMax = Math.max(iMax, iMaxIntrinsicWidth);
                        } else if (i4 != 0 || i4 + iMaxIntrinsicHeight <= i) {
                            i4 += iMaxIntrinsicHeight + iMainAxisGap;
                            iMax = Math.max(iMax, iMaxIntrinsicWidth);
                        } else {
                            i3 += iMax + iCrossAxisGap;
                            iMax = iMaxIntrinsicWidth;
                            i4 = iMaxIntrinsicHeight + iMainAxisGap;
                        }
                    } else if (i4 != 0) {
                        i4 += iMaxIntrinsicHeight + iMainAxisGap;
                        iMax = Math.max(iMax, iMaxIntrinsicWidth);
                    } else {
                        i4 += iMaxIntrinsicHeight + iMainAxisGap;
                        iMax = Math.max(iMax, iMaxIntrinsicWidth);
                    }
                    i2++;
                }
                return i3 + iMax;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int wrap3 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
        FlexWrap.Companion companion5 = FlexWrap.INSTANCE;
        if (!FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(1))) {
            int wrap4 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
            FlexWrap.Companion companion6 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap4, FlexWrap.m2184constructorimpl(2))) {
                int size2 = list.size();
                int iMaxIntrinsicWidth2 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    iMaxIntrinsicWidth2 += list.get(i5).maxIntrinsicWidth(i);
                }
                return iMaxIntrinsicWidth2 + (RangesKt.coerceAtLeast(list.size() - 1, 0) * iMainAxisGap2);
            }
        }
        int size3 = list.size();
        int iMax2 = 0;
        while (i2 < size3) {
            iMax2 = Math.max(iMax2, list.get(i2).maxIntrinsicWidth(i));
            i2++;
        }
        return iMax2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:37:0x0103  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        ResolvedFlexBoxConfig resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s = m2155resolveFlexBoxConfig3p2s80s(this.flexBoxConfigState.getValue(), intrinsicMeasureScope, ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        int direction = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        int i2 = 0;
        if (!FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            int direction2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (!FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                if (list.isEmpty()) {
                    return 0;
                }
                int iMainAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
                int wrap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap, FlexWrap.m2184constructorimpl(1))) {
                    int wrap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                    FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m2186equalsimpl0(wrap2, FlexWrap.m2184constructorimpl(2))) {
                        int size = list.size();
                        int iMaxIntrinsicHeight = 0;
                        for (int i3 = 0; i3 < size; i3++) {
                            iMaxIntrinsicHeight += list.get(i3).maxIntrinsicHeight(i);
                        }
                        return iMaxIntrinsicHeight + (RangesKt.coerceAtLeast(list.size() - 1, 0) * iMainAxisGap);
                    }
                }
                int size2 = list.size();
                int iMax = 0;
                while (i2 < size2) {
                    iMax = Math.max(iMax, list.get(i2).maxIntrinsicHeight(i));
                    i2++;
                }
                return iMax;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap2 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.mainAxisGap();
        int iCrossAxisGap = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.crossAxisGap();
        int size3 = list.size();
        int i4 = 0;
        int iMax2 = 0;
        int i5 = 0;
        while (i2 < size3) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE);
            int iMaxIntrinsicHeight2 = intrinsicMeasurable.maxIntrinsicHeight(iMaxIntrinsicWidth);
            int wrap3 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
            FlexWrap.Companion companion5 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(wrap3, FlexWrap.m2184constructorimpl(1))) {
                int wrap4 = resolvedFlexBoxConfigM2155resolveFlexBoxConfig3p2s80s.getWrap();
                FlexWrap.Companion companion6 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(wrap4, FlexWrap.m2184constructorimpl(2))) {
                    i5 += iMaxIntrinsicWidth + iMainAxisGap2;
                    iMax2 = Math.max(iMax2, iMaxIntrinsicHeight2);
                } else if (i5 != 0 || i5 + iMaxIntrinsicWidth <= i) {
                    i5 += iMaxIntrinsicWidth + iMainAxisGap2;
                    iMax2 = Math.max(iMax2, iMaxIntrinsicHeight2);
                } else {
                    i4 += iMax2 + iCrossAxisGap;
                    iMax2 = iMaxIntrinsicHeight2;
                    i5 = iMaxIntrinsicWidth + iMainAxisGap2;
                }
            } else if (i5 != 0) {
                i5 += iMaxIntrinsicWidth + iMainAxisGap2;
                iMax2 = Math.max(iMax2, iMaxIntrinsicHeight2);
            } else {
                i5 += iMaxIntrinsicWidth + iMainAxisGap2;
                iMax2 = Math.max(iMax2, iMaxIntrinsicHeight2);
            }
            i2++;
        }
        return i4 + iMax2;
    }

    /* JADX INFO: renamed from: resolveFlexBoxConfig-3p2s80s, reason: not valid java name */
    private final ResolvedFlexBoxConfig m2155resolveFlexBoxConfig3p2s80s(FlexBoxConfig flexBoxConfig, Density density, long constraints) {
        this.resolvedFlexBoxConfig.m2382prepare0kLqBqw(density, constraints);
        flexBoxConfig.configure(this.resolvedFlexBoxConfig);
        return this.resolvedFlexBoxConfig;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0022  */
    /* JADX INFO: renamed from: processFlexLine-7gjidqw, reason: not valid java name */
    private final void m2154processFlexLine7gjidqw(FlexLine line, ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, int currentLineHypotheticalMainAxisSize, boolean needsUpfrontCrossAxisCalculation, long constraints, int remainingCrossAxisSize) {
        boolean z;
        int direction = flexBoxConfig.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        if (!FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            int direction2 = flexBoxConfig.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            z = FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2));
        }
        line.setMainAxisSize(resolveFlexibleLengths(z, items, flexBoxConfig, line.getStartIndex(), line.getEndIndex(), currentLineHypotheticalMainAxisSize, Constraints.m10121getMaxWidthimpl(constraints)));
        if (needsUpfrontCrossAxisCalculation) {
            calculateLineCrossAxisSize(items, flexBoxConfig, line, remainingCrossAxisSize);
        }
    }

    /* JADX INFO: renamed from: measureFlexItems-HjG58DU, reason: not valid java name */
    private final int m2152measureFlexItemsHjG58DU(ArrayList<FlexLine> lines, ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, int totalLinesCrossSize, boolean needsUpfrontCrossAxisCalculation, long constraints) {
        boolean z;
        int iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(constraints);
        ArrayList<FlexLine> arrayList = lines;
        int size = arrayList.size();
        int i = 0;
        int i2 = totalLinesCrossSize;
        int crossAxisSize = iM10120getMaxHeightimpl;
        int i3 = 0;
        while (i3 < size) {
            FlexLine flexLine = arrayList.get(i3);
            int crossAxisSize2 = needsUpfrontCrossAxisCalculation ? flexLine.getCrossAxisSize() : i;
            int startIndex = flexLine.getStartIndex();
            int endIndex = flexLine.getEndIndex();
            if (startIndex < 0 || startIndex > items.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
            }
            if (endIndex >= 0 && endIndex <= items.size()) {
                int iMax = crossAxisSize2;
                int i4 = startIndex;
                while (i4 < endIndex) {
                    ResolvedFlexItemInfo resolvedFlexItemInfo = items.get(i4);
                    if (resolvedFlexItemInfo.getPlaceable() == null) {
                        int iM2390getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfo.getAlignSelf();
                        FlexAlignSelf.Companion companion = FlexAlignSelf.INSTANCE;
                        if (FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m2111constructorimpl(4))) {
                            z = true;
                        } else {
                            int iM2390getAlignSelf_ov7Qcc$foundation_layout2 = resolvedFlexItemInfo.getAlignSelf();
                            FlexAlignSelf.Companion companion2 = FlexAlignSelf.INSTANCE;
                            if (FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout2, FlexAlignSelf.m2111constructorimpl(i))) {
                                int alignItems = flexBoxConfig.getAlignItems();
                                FlexAlignItems.Companion companion3 = FlexAlignItems.INSTANCE;
                                if (!FlexAlignItems.m2101equalsimpl0(alignItems, FlexAlignItems.m2099constructorimpl(3))) {
                                    int alignContent = flexBoxConfig.getAlignContent();
                                    FlexAlignContent.Companion companion4 = FlexAlignContent.INSTANCE;
                                    if (FlexAlignContent.m2088equalsimpl0(alignContent, FlexAlignContent.m2086constructorimpl(3))) {
                                    }
                                }
                                z = true;
                            }
                            z = i;
                        }
                        int iMeasureItem = measureItem(resolvedFlexItemInfo, flexBoxConfig, z ? flexLine.getCrossAxisSize() : i, z, crossAxisSize);
                        if (!needsUpfrontCrossAxisCalculation) {
                            iMax = Math.max(iMax, iMeasureItem);
                        }
                        if (lines.size() == 1) {
                            iMax = Math.max(iMax, Constraints.m10122getMinHeightimpl(constraints));
                        }
                    } else if (!needsUpfrontCrossAxisCalculation) {
                        iMax = Math.max(iMax, resolvedFlexItemInfo.getCrossAxisSize());
                    }
                    i4++;
                    i = 0;
                }
                if (!needsUpfrontCrossAxisCalculation) {
                    flexLine.setCrossAxisSize(iMax);
                    i2 += iMax;
                }
                crossAxisSize = (crossAxisSize - flexLine.getCrossAxisSize()) - flexBoxConfig.crossAxisGap();
                if (crossAxisSize < 0) {
                    crossAxisSize = 0;
                }
                i3++;
                i = 0;
            } else {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return needsUpfrontCrossAxisCalculation ? totalLinesCrossSize : i2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009a  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:8:0x0027  */
    private final void calculateLineCrossAxisSize(ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, FlexLine line, int remainingCrossAxisSize) {
        boolean z;
        int crossAxisSize;
        int iMaxIntrinsicWidth;
        int direction = flexBoxConfig.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        if (FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            z = true;
        } else {
            int direction2 = flexBoxConfig.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                z = true;
            } else {
                z = false;
            }
        }
        int startIndex = line.getStartIndex();
        int endIndex = line.getEndIndex();
        if (startIndex < 0 || startIndex > items.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
        }
        if (endIndex >= 0 && endIndex <= items.size()) {
            int iMax = 0;
            int iMax2 = 0;
            int iMax3 = 0;
            while (startIndex < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = items.get(startIndex);
                if (resolvedFlexItemInfo.getHasBaseline()) {
                    measureItem(resolvedFlexItemInfo, flexBoxConfig, 0, false, remainingCrossAxisSize);
                    Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                    Intrinsics.checkNotNull(placeable);
                    int baseline = resolvedFlexItemInfo.getBaseline(placeable, flexBoxConfig);
                    resolvedFlexItemInfo.setBaseline(baseline);
                    iMax = Math.max(iMax, baseline);
                    iMax3 = Math.max(iMax3, resolvedFlexItemInfo.getCrossAxisSize() - baseline);
                    crossAxisSize = iMax + iMax3;
                } else {
                    int alignItems = flexBoxConfig.getAlignItems();
                    FlexAlignItems.Companion companion3 = FlexAlignItems.INSTANCE;
                    if (FlexAlignItems.m2101equalsimpl0(alignItems, FlexAlignItems.m2099constructorimpl(4))) {
                        int iM2390getAlignSelf_ov7Qcc$foundation_layout = resolvedFlexItemInfo.getAlignSelf();
                        FlexAlignSelf.Companion companion4 = FlexAlignSelf.INSTANCE;
                        if (FlexAlignSelf.m2113equalsimpl0(iM2390getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m2111constructorimpl(0))) {
                            measureItem(resolvedFlexItemInfo, flexBoxConfig, 0, false, remainingCrossAxisSize);
                            Placeable placeable2 = resolvedFlexItemInfo.getPlaceable();
                            Intrinsics.checkNotNull(placeable2);
                            int baseline2 = resolvedFlexItemInfo.getBaseline(placeable2, flexBoxConfig);
                            resolvedFlexItemInfo.setBaseline(baseline2);
                            iMax = Math.max(iMax, baseline2);
                            iMax3 = Math.max(iMax3, resolvedFlexItemInfo.getCrossAxisSize() - baseline2);
                            crossAxisSize = iMax + iMax3;
                        }
                    }
                    if (z) {
                        Measurable measurable = resolvedFlexItemInfo.getMeasurable();
                        if (measurable != null) {
                            iMaxIntrinsicWidth = measurable.maxIntrinsicHeight(resolvedFlexItemInfo.getTargetMainSize());
                        } else {
                            iMaxIntrinsicWidth = 0;
                        }
                    } else {
                        Measurable measurable2 = resolvedFlexItemInfo.getMeasurable();
                        if (measurable2 != null) {
                            iMaxIntrinsicWidth = measurable2.maxIntrinsicWidth(resolvedFlexItemInfo.getTargetMainSize());
                        } else {
                            iMaxIntrinsicWidth = 0;
                        }
                    }
                    resolvedFlexItemInfo.setCrossAxisSize(iMaxIntrinsicWidth);
                    crossAxisSize = resolvedFlexItemInfo.getCrossAxisSize();
                }
                iMax2 = Math.max(iMax2, crossAxisSize);
                startIndex++;
            }
            line.setMaxAboveBaseline(iMax);
            line.setCrossAxisSize(iMax2);
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + AbstractJsonLexerKt.END_LIST);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008d  */
    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    private final int measureItem(ResolvedFlexItemInfo item, ResolvedFlexBoxConfig flexBoxConfig, int lineCrossAxisSize, boolean shouldStretch, int remainingCrossAxisSize) {
        boolean z;
        long jM10129fitPrioritizingHeightZbe2FdA;
        int width;
        int targetMainSize;
        int direction = flexBoxConfig.getDirection();
        FlexDirection.Companion companion = FlexDirection.INSTANCE;
        int height = 0;
        if (FlexDirection.m2162equalsimpl0(direction, FlexDirection.m2160constructorimpl(0))) {
            z = true;
        } else {
            int direction2 = flexBoxConfig.getDirection();
            FlexDirection.Companion companion2 = FlexDirection.INSTANCE;
            if (FlexDirection.m2162equalsimpl0(direction2, FlexDirection.m2160constructorimpl(2))) {
                z = true;
            } else {
                z = false;
            }
        }
        if (shouldStretch && lineCrossAxisSize > 0) {
            Constraints.Companion companion3 = Constraints.INSTANCE;
            if (z) {
                targetMainSize = item.getTargetMainSize();
            } else {
                targetMainSize = lineCrossAxisSize > remainingCrossAxisSize ? remainingCrossAxisSize : lineCrossAxisSize;
            }
            if (!z) {
                lineCrossAxisSize = item.getTargetMainSize();
            } else if (lineCrossAxisSize > remainingCrossAxisSize) {
                lineCrossAxisSize = remainingCrossAxisSize;
            }
            jM10129fitPrioritizingHeightZbe2FdA = companion3.m10131fixedJhjzzOo(targetMainSize, lineCrossAxisSize);
        } else if (z) {
            jM10129fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m10130fitPrioritizingWidthZbe2FdA(item.getTargetMainSize(), item.getTargetMainSize(), 0, remainingCrossAxisSize);
        } else {
            jM10129fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m10129fitPrioritizingHeightZbe2FdA(0, remainingCrossAxisSize, item.getTargetMainSize(), item.getTargetMainSize());
        }
        Measurable measurable = item.getMeasurable();
        item.setPlaceable(measurable != null ? measurable.mo8808measureBRTryo0(jM10129fitPrioritizingHeightZbe2FdA) : null);
        if (z) {
            Placeable placeable = item.getPlaceable();
            if (placeable != null) {
                width = placeable.getHeight();
            } else {
                width = 0;
            }
        } else {
            Placeable placeable2 = item.getPlaceable();
            if (placeable2 != null) {
                width = placeable2.getWidth();
            } else {
                width = 0;
            }
        }
        item.setCrossAxisSize(width);
        if (z) {
            Placeable placeable3 = item.getPlaceable();
            if (placeable3 != null) {
                height = placeable3.getWidth();
            }
        } else {
            Placeable placeable4 = item.getPlaceable();
            if (placeable4 != null) {
                height = placeable4.getHeight();
            }
        }
        item.setMainAxisSize(height);
        return item.getCrossAxisSize();
    }
}
