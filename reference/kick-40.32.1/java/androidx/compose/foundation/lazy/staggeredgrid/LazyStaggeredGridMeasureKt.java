package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", ViewProps.POSITION, "Lkotlin/Function2;", "calculateExtraItems", ViewProps.FILTER, "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", ViewProps.TRANSFORM, "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m2597measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int iM2596maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo != null ? lazyStaggeredGridLayoutInfo.getVisibleItemsInfo() : null, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length || (iM2596maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    iM2596maxInRangejy6DScQ = i6 == 0 ? 0 : m2596maxInRangejy6DScQ(iArr, SpanRange.m2607constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = iM2596maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    /* JADX WARN: Code duplicated, block: B:265:0x0597  */
    /* JADX WARN: Code duplicated, block: B:308:0x0681  */
    /* JADX WARN: Code duplicated, block: B:309:0x0689  */
    /* JADX WARN: Code duplicated, block: B:312:0x069b  */
    /* JADX WARN: Code duplicated, block: B:315:0x06ac A[LOOP:29: B:311:0x0699->B:315:0x06ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:319:0x06b5  */
    /* JADX WARN: Code duplicated, block: B:320:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:323:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:324:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:328:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:356:0x0776  */
    /* JADX WARN: Code duplicated, block: B:386:0x0894  */
    /* JADX WARN: Code duplicated, block: B:389:0x089d A[LOOP:27: B:385:0x0892->B:389:0x089d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:392:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:394:0x08aa A[LOOP:28: B:391:0x08a2->B:394:0x08aa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:490:0x08a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:491:0x08af A[EDGE_INSN: B:491:0x08af->B:396:0x08af BREAK  A[LOOP:27: B:385:0x0892->B:389:0x089d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x08ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x06af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x06b1 A[EDGE_INSN: B:495:0x06b1->B:317:0x06b1 BREAK  A[LOOP:29: B:311:0x0699->B:315:0x06ac], SYNTHETIC] */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        char c;
        int i2;
        int iIndexOf;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int[] iArr4;
        int i6;
        String str;
        int i7;
        int iM10138constrainWidthK40F9xA;
        int iM10120getMaxHeightimpl;
        List listEmptyList;
        int mainAxisSizeWithSpacings;
        ArrayList arrayList;
        float f;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        List<Integer> list;
        ArrayList arrayList2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        ArrayList arrayList3;
        List<LazyStaggeredGridItemInfo> approachVisibleItems;
        int size;
        int i13;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3;
        int lane;
        int[] positions;
        int i14;
        int i15;
        int i16;
        int[] gaps;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        final LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints());
            int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, iM10123getMinWidthimpl, iM10122getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long jM2540getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m2540getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m10337equalsimpl0(jM2540getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m10344getZeroYbymL2g())) {
                    iM10123getMinWidthimpl = ConstraintsKt.m10138constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM10122getMinHeightimpl = ConstraintsKt.m10137constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, iM10123getMinWidthimpl, iM10122getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m10334constructorimpl((((long) Constraints.m10122getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())) & 4294967295L) | (((long) Constraints.m10123getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints())) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str2 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i17 = 0; i17 < laneCount; i17++) {
            arrayDequeArr[i17] = new ArrayDeque(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z3 = false;
        while (true) {
            if (!measure$lambda$0$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext2)) {
                c = ' ';
                i2 = 0;
                iIndexOf = -1;
                break;
            }
            iIndexOf = indexOfMaxValue(iArrCopyOf);
            c = ' ';
            int i18 = iArrCopyOf[iIndexOf];
            int length = iArrCopyOf2.length;
            for (int i19 = 0; i19 < length; i19++) {
                if (iArrCopyOf[i19] != iArrCopyOf[iIndexOf]) {
                    int i20 = iArrCopyOf2[i19];
                    int i21 = iArrCopyOf2[iIndexOf];
                    if (i20 < i21) {
                        iArrCopyOf2[i19] = i21;
                    }
                }
            }
            i2 = 0;
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i18, iIndexOf);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM2591getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex, iIndexOf);
            int i22 = (int) (jM2591getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
            boolean z4 = z3;
            int i23 = (int) (jM2591getSpanRangelOCCd4c >> 32);
            int i24 = i22 - i23;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex, i24 != 1 ? -2 : i23);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM2591getSpanRangelOCCd4c);
            int iM2596maxInRangejy6DScQ = m2596maxInRangejy6DScQ(iArrCopyOf2, jM2591getSpanRangelOCCd4c);
            int[] gaps2 = i24 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            boolean z5 = z4;
            while (i23 < i22) {
                iArrCopyOf[i23] = iFindPreviousItemIndex;
                int mainAxisSizeWithSpacings2 = iM2596maxInRangejy6DScQ + lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i23]);
                iArrCopyOf2[i23] = mainAxisSizeWithSpacings2;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings2 <= 0) {
                    z5 = true;
                }
                i23++;
            }
            arrayDequeArr = arrayDequeArr2;
            z3 = z5;
        }
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        boolean z6 = z3;
        int i25 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i26 = iArrCopyOf2[i2];
        if (i26 < i25) {
            offsetBy(iArrCopyOf2, i25 - i26);
            i3 = i - (i25 - i26);
        } else {
            i3 = i;
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i27 = -1;
        if (iIndexOf == -1) {
            iIndexOf = ArraysKt.indexOf(iArrCopyOf, i2);
        }
        if (iIndexOf != -1 && measure$lambda$0$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext2, iArrCopyOf2, iIndexOf) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = iArrCopyOf.length;
            int[] iArr5 = new int[length2];
            int i28 = 0;
            while (i28 < length2) {
                iArr5[i28] = i27;
                i28++;
                i27 = -1;
            }
            int length3 = iArrCopyOf2.length;
            int[] iArr6 = new int[length3];
            for (int i29 = 0; i29 < length3; i29++) {
                iArr6[i29] = iArrCopyOf2[iIndexOf];
            }
            return measure(lazyStaggeredGridMeasureContext2, i3, iArr5, iArr6, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(...)");
        int length4 = iArrCopyOf2.length;
        int[] iArr7 = new int[length4];
        for (int i30 = 0; i30 < length4; i30++) {
            iArr7[i30] = -iArrCopyOf2[i30];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i25;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        boolean z7 = z6;
        for (int i31 = -1; iIndexOfMinValue$default != i31 && laneCount2 < lazyStaggeredGridMeasureContext2.getLaneCount(); i31 = -1) {
            int i32 = iArrCopyOf3[iIndexOfMinValue$default];
            iIndexOfMinValue$default = indexOfMinValue(iArrCopyOf3, i32);
            laneCount2++;
            if (i32 >= 0) {
                int i33 = i3;
                long jM2591getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i32, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(i32, jM2591getSpanRangelOCCd4c2);
                ArrayDeque[] arrayDequeArr4 = arrayDequeArr3;
                int[] iArr8 = iArrCopyOf;
                int[] iArr9 = iArrCopyOf2;
                int i34 = (int) (jM2591getSpanRangelOCCd4c2 & 4294967295L);
                int i35 = itemCount;
                int i36 = (int) (jM2591getSpanRangelOCCd4c2 >> c);
                int i37 = i34 - i36;
                lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(i32, i37 != 1 ? -2 : i36);
                int iM2596maxInRangejy6DScQ2 = m2596maxInRangejy6DScQ(iArr7, jM2591getSpanRangelOCCd4c2);
                for (int i38 = i36; i38 < i34; i38++) {
                    iArr7[i38] = lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + iM2596maxInRangejy6DScQ2;
                    iArrCopyOf3[i38] = i32;
                    arrayDequeArr4[i38].addLast(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2);
                }
                if (iM2596maxInRangejy6DScQ2 < mainAxisSpacing && iArr7[i36] <= mainAxisSpacing) {
                    lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2.setVisible(false);
                    z7 = true;
                }
                laneCount2 = i37 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : laneCount2;
                arrayDequeArr3 = arrayDequeArr4;
                i3 = i33;
                iArrCopyOf = iArr8;
                iArrCopyOf2 = iArr9;
                itemCount = i35;
            }
        }
        int i39 = i3;
        ArrayDeque[] arrayDequeArr5 = arrayDequeArr3;
        int[] iArr10 = iArrCopyOf;
        int[] iArr11 = iArrCopyOf2;
        int i40 = itemCount;
        loop9: while (true) {
            int i41 = 0;
            while (true) {
                if (i41 >= length4) {
                    for (int i42 = 0; i42 < laneCount; i42++) {
                        if (!arrayDequeArr5[i42].isEmpty()) {
                            i4 = i40;
                            i5 = 1;
                            break loop9;
                        }
                    }
                    break;
                }
                int i43 = iArr7[i41];
                if (i43 < iCoerceAtLeast || i43 <= 0) {
                    break;
                }
                i41++;
            }
            i5 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr7, 0, 1, null);
            int iMaxOrThrow = ArraysKt.maxOrThrow(iArrCopyOf3) + 1;
            i4 = i40;
            if (iMaxOrThrow >= i4) {
                break;
            }
            int i44 = length4;
            String str3 = str2;
            ArrayDeque[] arrayDequeArr6 = arrayDequeArr5;
            int i45 = iCoerceAtLeast;
            boolean z8 = z7;
            int i46 = i39;
            long jM2591getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iMaxOrThrow, iIndexOfMinValue$default2);
            int[] iArr12 = iArrCopyOf3;
            int i47 = (int) (jM2591getSpanRangelOCCd4c3 & 4294967295L);
            int i48 = (int) (jM2591getSpanRangelOCCd4c3 >> c);
            int i49 = i47 - i48;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iMaxOrThrow, i49 != 1 ? -2 : i48);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iMaxOrThrow, jM2591getSpanRangelOCCd4c3);
            int iM2596maxInRangejy6DScQ3 = m2596maxInRangejy6DScQ(iArr7, jM2591getSpanRangelOCCd4c3);
            if (i49 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iMaxOrThrow);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            for (int i50 = i48; i50 < i47; i50++) {
                if (gaps != null) {
                    gaps[i50] = iM2596maxInRangejy6DScQ3 - iArr7[i50];
                }
                iArr12[i50] = iMaxOrThrow;
                iArr7[i50] = iM2596maxInRangejy6DScQ3 + lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr6[i50].addLast(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iMaxOrThrow, gaps);
            if (iM2596maxInRangejy6DScQ3 < mainAxisSpacing && iArr7[i48] <= mainAxisSpacing) {
                lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            iArrCopyOf3 = iArr12;
            iCoerceAtLeast = i45;
            i40 = i4;
            str2 = str3;
            z7 = z8;
            arrayDequeArr5 = arrayDequeArr6;
            length4 = i44;
            i39 = i46;
        }
        int i51 = 0;
        while (i51 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr5[i51];
            while (arrayDeque.size() > i5 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i5 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr11[i51] = iArr11[i51] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i51]));
                i5 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr10[i51] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i51++;
            i5 = 1;
        }
        for (int i52 : iArrCopyOf3) {
            if (i52 == i4 - 1) {
                offsetBy(iArr7, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
        }
        int i53 = 0;
        while (true) {
            if (i53 < length4) {
                if (iArr7[i53] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i4 = i4;
                    i7 = i39;
                    i39 = i7;
                    iArr4 = iArr10;
                    iArr3 = iArr11;
                    iCoerceAtLeast = iCoerceAtLeast;
                    i6 = length4;
                    str = str2;
                    break;
                }
                i53++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr7[indexOfMaxValue(iArr7)];
                iArr3 = iArr11;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr7, mainAxisAvailableSize);
                boolean z9 = false;
                loop31: while (true) {
                    int length5 = iArr3.length;
                    int i54 = 0;
                    while (true) {
                        if (i54 >= length5) {
                            iArr4 = iArr10;
                            break loop31;
                        }
                        if (iArr3[i54] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i54++;
                        length4 = length4;
                        iArr10 = iArr10;
                        i39 = i39;
                    }
                    int iIndexOfMinValue$default3 = indexOfMinValue$default(iArr3, 0, 1, null);
                    int iIndexOfMaxValue = indexOfMaxValue(iArr10);
                    if (iIndexOfMinValue$default3 != iIndexOfMaxValue) {
                        if (iArr3[iIndexOfMinValue$default3] == iArr3[iIndexOfMaxValue]) {
                            iIndexOfMinValue$default3 = iIndexOfMaxValue;
                        } else {
                            z9 = true;
                        }
                    }
                    int i55 = iArr10[iIndexOfMinValue$default3];
                    if (i55 == -1) {
                        i55 = i4;
                    }
                    int iFindPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i55, iIndexOfMinValue$default3);
                    if (iFindPreviousItemIndex2 < 0) {
                        iArr4 = iArr10;
                        if ((!z9 && !measure$lambda$0$misalignedStart(iArr4, lazyStaggeredGridMeasureContext2, iArr3, iIndexOfMinValue$default3)) || !z) {
                            break;
                        }
                        lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                        int length6 = iArr4.length;
                        int[] iArr13 = new int[length6];
                        for (int i56 = 0; i56 < length6; i56++) {
                            iArr13[i56] = -1;
                        }
                        int length7 = iArr3.length;
                        int[] iArr14 = new int[length7];
                        for (int i57 = 0; i57 < length7; i57++) {
                            iArr14[i57] = iArr3[iIndexOfMinValue$default3];
                        }
                        return measure(lazyStaggeredGridMeasureContext2, i39, iArr13, iArr14, false);
                    }
                    int i58 = i39;
                    int[] iArr15 = iArr10;
                    boolean z10 = z9;
                    int i59 = mainAxisAvailableSize;
                    long jM2591getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex2, iIndexOfMinValue$default3);
                    int i60 = i4;
                    int i61 = length4;
                    int i62 = (int) (jM2591getSpanRangelOCCd4c4 & 4294967295L);
                    int i63 = iCoerceAtLeast;
                    String str4 = str2;
                    int i64 = (int) (jM2591getSpanRangelOCCd4c4 >> c);
                    int i65 = i62 - i64;
                    lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex2, i65 != 1 ? -2 : i64);
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iFindPreviousItemIndex2, jM2591getSpanRangelOCCd4c4);
                    int iM2596maxInRangejy6DScQ4 = m2596maxInRangejy6DScQ(iArr3, jM2591getSpanRangelOCCd4c4);
                    int[] gaps4 = i65 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex2) : null;
                    while (i64 < i62) {
                        if (iArr3[i64] != iM2596maxInRangejy6DScQ4) {
                            z10 = true;
                        }
                        arrayDequeArr5[i64].addFirst(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ4);
                        iArr15[i64] = iFindPreviousItemIndex2;
                        iArr3[i64] = iM2596maxInRangejy6DScQ4 + lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i64]);
                        i64++;
                    }
                    mainAxisAvailableSize = i59;
                    str2 = str4;
                    z9 = z10;
                    length4 = i61;
                    iCoerceAtLeast = i63;
                    i4 = i60;
                    iArr10 = iArr15;
                    i39 = i58;
                }
                i6 = length4;
                str = str2;
                if (z9 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i39, iArr4, iArr3, false);
                }
                i7 = i39 + mainAxisAvailableSize;
                int i66 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i66 >= 0) {
                    break;
                }
                i7 += i66;
                offsetBy(iArr7, i66);
                offsetBy(iArr3, -i66);
                break;
            }
        }
        float fScrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(measureScope.isLookingAhead());
        float f2 = (MathKt.getSign(Math.round(fScrollToBeConsumed$foundation)) != MathKt.getSign(i7) || Math.abs(Math.round(fScrollToBeConsumed$foundation)) < Math.abs(i7)) ? fScrollToBeConsumed$foundation : i7;
        float f3 = fScrollToBeConsumed$foundation - f2;
        float f4 = 0.0f;
        if (measureScope.isLookingAhead() && i7 > i39 && f3 <= 0.0f) {
            f4 = (i7 - i39) + f3;
        }
        float f5 = f4;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, str);
        int length8 = iArrCopyOf4.length;
        for (int i67 = 0; i67 < length8; i67++) {
            iArrCopyOf4[i67] = -iArrCopyOf4[i67];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i68 = 0; i68 < laneCount; i68++) {
                ArrayDeque arrayDeque2 = arrayDequeArr5[i68];
                int size2 = arrayDeque2.size();
                int i69 = 0;
                while (i69 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i69);
                    int[] gaps5 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings3 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[i68]);
                    if (i69 == CollectionsKt.getLastIndex(arrayDeque2) || (i16 = iArr3[i68]) == 0 || i16 < mainAxisSizeWithSpacings3) {
                        break;
                    }
                    iArr3[i68] = i16 - mainAxisSizeWithSpacings3;
                    i69++;
                    iArr4[i68] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i69)).getIndex();
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM10138constrainWidthK40F9xA = Constraints.m10121getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        } else {
            iM10138constrainWidthK40F9xA = ConstraintsKt.m10138constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding);
        }
        int i70 = iM10138constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM10120getMaxHeightimpl = ConstraintsKt.m10137constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding);
        } else {
            iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        }
        int i71 = iM10120getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? i71 : i70, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i72 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int i73 = -1;
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            int i74 = size3;
            ArrayList arrayList4 = null;
            while (true) {
                int i75 = i74 - 1;
                int iIntValue = pinnedItems.get(i74).intValue();
                int lane2 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue);
                int i76 = i72;
                if (lane2 == -2 || lane2 == i73) {
                    int i77 = 0;
                    while (true) {
                        if (i77 < laneCount) {
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[i77].firstOrNull();
                            if ((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > iIntValue) {
                                i77++;
                            } else {
                                i72 = i76;
                            }
                        } else {
                            long jM2591getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue, jM2591getSpanRangelOCCd4c5);
                            int mainAxisSizeWithSpacings4 = i76 - lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                            lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ5.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                            arrayList4.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ5);
                            i72 = mainAxisSizeWithSpacings4;
                        }
                    }
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[lane2].firstOrNull();
                    if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) > iIntValue) {
                        long jM2591getSpanRangelOCCd4c6 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue, jM2591getSpanRangelOCCd4c6);
                        int mainAxisSizeWithSpacings5 = i76 - lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                        lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ6.position(mainAxisSizeWithSpacings5, 0, afterContentPadding);
                        arrayList4.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ6);
                        i72 = mainAxisSizeWithSpacings5;
                    } else {
                        i72 = i76;
                    }
                }
                if (i75 < 0) {
                    break;
                }
                iArrCopyOf4 = iArrCopyOf4;
                i74 = i75;
                i73 = -1;
            }
            listEmptyList = arrayList4;
        } else {
            iArrCopyOf4 = iArrCopyOf4;
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int[] iArr16 = iArrCopyOf4;
        List list2 = listEmptyList;
        int i78 = iCoerceAtLeast;
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr5, iArr16, afterContentPadding, i25, i78);
        int i79 = iArr16[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (!measureScope.isLookingAhead() || lazyStaggeredGridMeasureContext2.getApproachVisibleItems() == null || lazyStaggeredGridMeasureContext2.getApproachVisibleItems().isEmpty()) {
            beforeContentPadding = beforeContentPadding;
            list2 = list2;
            listCalculateVisibleItems = listCalculateVisibleItems;
            mainAxisSizeWithSpacings = i79;
            arrayList = null;
        } else {
            List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
            int size4 = approachVisibleItems2.size() - 1;
            while (true) {
                if (-1 >= size4) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (approachVisibleItems2.get(size4).getIndex() > index2 && (size4 == 0 || approachVisibleItems2.get(size4 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = approachVisibleItems2.get(size4);
                    break;
                }
                size4--;
            }
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext2.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo4.getIndex(), i4 - 1))) {
                int i80 = index;
                mainAxisSizeWithSpacings = i79;
                arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size5 = arrayList.size();
                        int i81 = 0;
                        while (true) {
                            if (i81 < size5) {
                                ArrayList arrayList5 = arrayList;
                                if (((LazyStaggeredGridMeasuredItem) arrayList.get(i81)).getIndex() == i80) {
                                    arrayList = arrayList5;
                                } else {
                                    i81++;
                                    arrayList = arrayList5;
                                }
                            } else {
                                arrayList3 = arrayList;
                                if (arrayList3 == null) {
                                    arrayList = new ArrayList();
                                } else {
                                    arrayList = arrayList3;
                                }
                                approachVisibleItems = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
                                size = approachVisibleItems.size();
                                i13 = 0;
                                while (true) {
                                    if (i13 < size) {
                                        lazyStaggeredGridItemInfo2 = null;
                                        break;
                                    }
                                    lazyStaggeredGridItemInfo2 = approachVisibleItems.get(i13);
                                    i15 = i13;
                                    if (lazyStaggeredGridItemInfo2.getIndex() == i80) {
                                        break;
                                    }
                                    i13 = i15 + 1;
                                }
                                lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                                if (lazyStaggeredGridItemInfo3 != null) {
                                    lane = lazyStaggeredGridItemInfo3.getLane();
                                } else {
                                    lane = 0;
                                }
                                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ7 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(i80, lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i80, lane));
                                arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ7);
                                positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                                if (positions.length > lane) {
                                    i14 = positions[lane];
                                } else {
                                    i14 = 0;
                                }
                                lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ7.position(mainAxisSizeWithSpacings, i14, afterContentPadding);
                                mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ7.getMainAxisSizeWithSpacings();
                            }
                        }
                    } else {
                        arrayList3 = arrayList;
                        if (arrayList3 == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = arrayList3;
                        }
                        approachVisibleItems = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
                        size = approachVisibleItems.size();
                        i13 = 0;
                        while (true) {
                            if (i13 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = approachVisibleItems.get(i13);
                            i15 = i13;
                            if (lazyStaggeredGridItemInfo2.getIndex() == i80) {
                                break;
                                break;
                            }
                            i13 = i15 + 1;
                        }
                        lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo3 != null) {
                            lane = lazyStaggeredGridItemInfo3.getLane();
                        } else {
                            lane = 0;
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ8 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(i80, lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i80, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ8);
                        positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                        if (positions.length > lane) {
                            i14 = positions[lane];
                        } else {
                            i14 = 0;
                        }
                        lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ8.position(mainAxisSizeWithSpacings, i14, afterContentPadding);
                        mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ8.getMainAxisSizeWithSpacings();
                    }
                    if (i80 == iMin) {
                        break;
                    }
                    i80++;
                    beforeContentPadding = beforeContentPadding;
                    list2 = list2;
                    listCalculateVisibleItems = listCalculateVisibleItems;
                }
            } else {
                beforeContentPadding = beforeContentPadding;
                list2 = list2;
                listCalculateVisibleItems = listCalculateVisibleItems;
                mainAxisSizeWithSpacings = i79;
                arrayList = null;
            }
        }
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size6 = pinnedItems2.size();
        int i82 = 0;
        ArrayList arrayListEmptyList = null;
        while (i82 < size6) {
            int iIntValue2 = pinnedItems2.get(i82).intValue();
            int i83 = i4;
            if (iIntValue2 >= i83) {
                arrayList2 = arrayList;
                list = pinnedItems2;
            } else {
                if (arrayList != null) {
                    int size7 = arrayList.size();
                    list = pinnedItems2;
                    int i84 = 0;
                    while (true) {
                        if (i84 < size7) {
                            arrayList2 = arrayList;
                            if (((LazyStaggeredGridMeasuredItem) arrayList.get(i84)).getIndex() != iIntValue2) {
                                i84++;
                                arrayList = arrayList2;
                            }
                        }
                    }
                } else {
                    list = pinnedItems2;
                }
                arrayList2 = arrayList;
                int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                if (lane3 != -2 && lane3 != -1) {
                    if (iArrCopyOf3[lane3] < iIntValue2) {
                        long jM2591getSpanRangelOCCd4c7 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ9 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue2, jM2591getSpanRangelOCCd4c7);
                        lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ9.position(mainAxisSizeWithSpacings, 0, afterContentPadding);
                        mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ9.getMainAxisSizeWithSpacings();
                        arrayListEmptyList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ9);
                    }
                } else {
                    int length9 = iArrCopyOf3.length;
                    int i85 = 0;
                    while (true) {
                        if (i85 >= length9) {
                            long jM2591getSpanRangelOCCd4c8 = lazyStaggeredGridMeasureContext2.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = new ArrayList();
                            }
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ10 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue2, jM2591getSpanRangelOCCd4c8);
                            lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ10.position(mainAxisSizeWithSpacings, 0, afterContentPadding);
                            mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ10.getMainAxisSizeWithSpacings();
                            arrayListEmptyList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ10);
                        } else if (iArrCopyOf3[i85] < iIntValue2) {
                            i85++;
                        }
                    }
                }
                i82++;
                size6 = size6;
                pinnedItems2 = list;
                arrayList = arrayList2;
                i4 = i83;
            }
            i82++;
            size6 = size6;
            pinnedItems2 = list;
            arrayList = arrayList2;
            i4 = i83;
        }
        int i86 = i4;
        ArrayList arrayList6 = arrayList;
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        final ArrayList arrayList7 = new ArrayList();
        arrayList7.addAll(list2);
        arrayList7.addAll(listCalculateVisibleItems);
        if (arrayList6 != null) {
            arrayList7.addAll(arrayList6);
        }
        arrayList7.addAll(arrayListEmptyList);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f2, i70, i71, arrayList7, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (!measureScope.isLookingAhead()) {
            long jM2540getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().m2540getMinSizeToFitDisappearingItemsYbymL2g();
            f = f5;
            if (!IntSize.m10337equalsimpl0(jM2540getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m10344getZeroYbymL2g())) {
                int i87 = lazyStaggeredGridMeasureContext2.getIsVertical() ? i71 : i70;
                int iM10138constrainWidthK40F9xA2 = ConstraintsKt.m10138constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(i70, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                int iM10137constrainHeightK40F9xA = ConstraintsKt.m10137constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(i71, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i88 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM10137constrainHeightK40F9xA : iM10138constrainWidthK40F9xA2;
                if (i88 != i87) {
                    int size8 = arrayList7.size();
                    for (int i89 = 0; i89 < size8; i89++) {
                        ((LazyStaggeredGridMeasuredItem) arrayList7.get(i89)).updateMainAxisLayoutSize(i88);
                    }
                }
                i8 = iM10138constrainWidthK40F9xA2;
                i9 = iM10137constrainHeightK40F9xA;
            }
            i10 = i6;
            i11 = 0;
            while (true) {
                if (i11 < i10) {
                    for (int i90 : iArrCopyOf3) {
                        if (i90 < i86 - 1) {
                            z2 = false;
                            final boolean reverseLayout = lazyStaggeredGridMeasureContext2.getReverseLayout();
                            final long contentOffset = lazyStaggeredGridMeasureContext2.getContentOffset();
                            final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                            return new LazyStaggeredGridMeasureResult(iArr4, iArr3, f2, MeasureScope.layout$default(measureScope, i8, i9, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext3, arrayList7, reverseLayout, contentOffset, measureScope, (Placeable.PlacementScope) obj);
                                }
                            }, 4, null), f, z2, lazyStaggeredGridMeasureContext3.getIsVertical(), z7, lazyStaggeredGridMeasureContext3.getResolvedSlots(), lazyStaggeredGridMeasureContext3.getItemProvider().getSpanProvider(), measureScope, i86, listCalculateVisibleItems, IntSize.m10334constructorimpl((((long) i9) & 4294967295L) | (((long) i8) << c)), i25, i78, lazyStaggeredGridMeasureContext3.getBeforeContentPadding(), lazyStaggeredGridMeasureContext3.getAfterContentPadding(), lazyStaggeredGridMeasureContext3.getMainAxisSpacing(), lazyStaggeredGridMeasureContext3.getCoroutineScope(), null);
                        }
                    }
                    break;
                }
                if (iArr7[i11] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    break;
                }
                i11++;
            }
            z2 = true;
            final boolean reverseLayout2 = lazyStaggeredGridMeasureContext2.getReverseLayout();
            final long contentOffset2 = lazyStaggeredGridMeasureContext2.getContentOffset();
            final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext2;
            return new LazyStaggeredGridMeasureResult(iArr4, iArr3, f2, MeasureScope.layout$default(measureScope, i8, i9, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext4, arrayList7, reverseLayout2, contentOffset2, measureScope, (Placeable.PlacementScope) obj);
                }
            }, 4, null), f, z2, lazyStaggeredGridMeasureContext4.getIsVertical(), z7, lazyStaggeredGridMeasureContext4.getResolvedSlots(), lazyStaggeredGridMeasureContext4.getItemProvider().getSpanProvider(), measureScope, i86, listCalculateVisibleItems, IntSize.m10334constructorimpl((((long) i9) & 4294967295L) | (((long) i8) << c)), i25, i78, lazyStaggeredGridMeasureContext4.getBeforeContentPadding(), lazyStaggeredGridMeasureContext4.getAfterContentPadding(), lazyStaggeredGridMeasureContext4.getMainAxisSpacing(), lazyStaggeredGridMeasureContext4.getCoroutineScope(), null);
        }
        f = f5;
        i8 = i70;
        i9 = i71;
        i10 = i6;
        i11 = 0;
        while (true) {
            if (i11 < i10) {
                while (i12 < r1) {
                    if (i90 < i86 - 1) {
                        z2 = false;
                        final boolean reverseLayout3 = lazyStaggeredGridMeasureContext2.getReverseLayout();
                        final long contentOffset3 = lazyStaggeredGridMeasureContext2.getContentOffset();
                        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext5 = lazyStaggeredGridMeasureContext2;
                        return new LazyStaggeredGridMeasureResult(iArr4, iArr3, f2, MeasureScope.layout$default(measureScope, i8, i9, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext5, arrayList7, reverseLayout3, contentOffset3, measureScope, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null), f, z2, lazyStaggeredGridMeasureContext5.getIsVertical(), z7, lazyStaggeredGridMeasureContext5.getResolvedSlots(), lazyStaggeredGridMeasureContext5.getItemProvider().getSpanProvider(), measureScope, i86, listCalculateVisibleItems, IntSize.m10334constructorimpl((((long) i9) & 4294967295L) | (((long) i8) << c)), i25, i78, lazyStaggeredGridMeasureContext5.getBeforeContentPadding(), lazyStaggeredGridMeasureContext5.getAfterContentPadding(), lazyStaggeredGridMeasureContext5.getMainAxisSpacing(), lazyStaggeredGridMeasureContext5.getCoroutineScope(), null);
                    }
                }
                break;
                break;
            }
            if (iArr7[i11] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                break;
                break;
            }
            i11++;
        }
        z2 = true;
        final boolean reverseLayout4 = lazyStaggeredGridMeasureContext2.getReverseLayout();
        final long contentOffset4 = lazyStaggeredGridMeasureContext2.getContentOffset();
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext6 = lazyStaggeredGridMeasureContext2;
        return new LazyStaggeredGridMeasureResult(iArr4, iArr3, f2, MeasureScope.layout$default(measureScope, i8, i9, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext6, arrayList7, reverseLayout4, contentOffset4, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null), f, z2, lazyStaggeredGridMeasureContext6.getIsVertical(), z7, lazyStaggeredGridMeasureContext6.getResolvedSlots(), lazyStaggeredGridMeasureContext6.getItemProvider().getSpanProvider(), measureScope, i86, listCalculateVisibleItems, IntSize.m10334constructorimpl((((long) i9) & 4294967295L) | (((long) i8) << c)), i25, i78, lazyStaggeredGridMeasureContext6.getBeforeContentPadding(), lazyStaggeredGridMeasureContext6.getAfterContentPadding(), lazyStaggeredGridMeasureContext6.getMainAxisSpacing(), lazyStaggeredGridMeasureContext6.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final boolean z, final long j, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, z, j, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m2558attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m2605getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length; i6++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i4].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i4) {
                        long jM2607constructorimpl = SpanRange.m2607constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM2596maxInRangejy6DScQ = m2596maxInRangejy6DScQ(iArr, jM2607constructorimpl);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSize() + iM2596maxInRangejy6DScQ >= i2 && iM2596maxInRangejy6DScQ <= i3) {
                            lazyStaggeredGridMeasuredItemRemoveFirst.position(iM2596maxInRangejy6DScQ, i7, i);
                            arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        }
                        int i8 = (int) (jM2607constructorimpl & 4294967295L);
                        for (int i9 = (int) (jM2607constructorimpl >> 32); i9 < i8; i9++) {
                            iArr[i9] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM2596maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8 A[LOOP:3: B:35:0x0098->B:39:0x00a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac A[EDGE_INSN: B:62:0x00ac->B:41:0x00ac BREAK  A[LOOP:3: B:35:0x0098->B:39:0x00a8], SYNTHETIC] */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        List<LazyStaggeredGridItemInfo> approachVisibleItems;
        int size;
        int i3;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3;
        int lane;
        if (z && lazyStaggeredGridMeasureContext.getApproachVisibleItems() != null && !lazyStaggeredGridMeasureContext.getApproachVisibleItems().isEmpty()) {
            List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
            int size2 = approachVisibleItems2.size();
            while (true) {
                size2--;
                if (-1 >= size2) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (approachVisibleItems2.get(size2).getIndex() > i && (size2 == 0 || approachVisibleItems2.get(size2 - 1).getIndex() <= i)) {
                    lazyStaggeredGridItemInfo = approachVisibleItems2.get(size2);
                    break;
                }
            }
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo4.getIndex(), i2 - 1))) {
                ArrayList arrayList = null;
                while (true) {
                    if (arrayList == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        approachVisibleItems = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
                        size = approachVisibleItems.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = approachVisibleItems.get(i3);
                            if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                break;
                                break;
                            }
                            i3++;
                        }
                        lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo3 != null) {
                            lane = lazyStaggeredGridItemInfo3.getLane();
                        } else {
                            lane = 0;
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ);
                        int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    } else {
                        int size3 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (arrayList.get(i4).getIndex() != index) {
                                    i4++;
                                }
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                approachVisibleItems = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
                                size = approachVisibleItems.size();
                                i3 = 0;
                                while (true) {
                                    if (i3 < size) {
                                        lazyStaggeredGridItemInfo2 = null;
                                        break;
                                    }
                                    lazyStaggeredGridItemInfo2 = approachVisibleItems.get(i3);
                                    if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                        break;
                                    }
                                    i3++;
                                }
                                lazyStaggeredGridItemInfo3 = lazyStaggeredGridItemInfo2;
                                if (lazyStaggeredGridItemInfo3 != null) {
                                    lane = lazyStaggeredGridItemInfo3.getLane();
                                } else {
                                    lane = 0;
                                }
                                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                                arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2);
                                int[] positions2 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                                function2.invoke(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2, Integer.valueOf(positions2.length > lane ? positions2[lane] : 0));
                            }
                        }
                    }
                    if (index == iMin) {
                        return arrayList;
                    }
                    index++;
                }
            }
        }
        return null;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function2, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function2.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM2591getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue, jM2591getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function2.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM2591getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m2591getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2600getAndMeasurejy6DScQ(iIntValue2, jM2591getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM2600getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m2595forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m2596maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, boolean z, long j, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).m2603placeGMOY1bU(placementScope, z, j, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
