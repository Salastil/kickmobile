package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.reflection.WindowExtensionsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u001a\u009a\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00112/\u0010*\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0002\b/\u0012\u0004\u0012\u0002000+H\u0000¢\u0006\u0004\b1\u00102\u001aB\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a4\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b052\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006A"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "shouldRunItemAnimation", WindowExtensionsConstants.LAYOUT_PACKAGE, "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-pIk1_oM", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;ZLkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Code duplicated, block: B:153:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:170:0x0430  */
    /* JADX INFO: renamed from: measureLazyList-pIk1_oM, reason: not valid java name */
    public static final LazyListMeasureResult m2479measureLazyListpIk1_oM(int i, final LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, boolean z4, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, boolean z5, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int i13;
        int iMax;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        final boolean z6;
        int i20;
        int i21;
        Integer numValueOf;
        int i22 = i3;
        if (!(i22 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j);
            int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM10123getMinWidthimpl, iM10122getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long jM2540getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m2540getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m10337equalsimpl0(jM2540getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m10344getZeroYbymL2g())) {
                    iM10123getMinWidthimpl = ConstraintsKt.m10138constrainWidthK40F9xA(j, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM10122getMinHeightimpl = ConstraintsKt.m10137constrainHeightK40F9xA(j, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM10123getMinWidthimpl), Integer.valueOf(iM10122getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -i22, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
        }
        int i23 = i6;
        if (i23 >= i) {
            i23 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int iRound = Math.round(f);
        int i24 = i9 - iRound;
        if (i23 == 0 && i24 < 0) {
            iRound += i24;
            i24 = 0;
        }
        int i25 = iRound;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i26 = -i22;
        int i27 = (i5 < 0 ? i5 : 0) + i26;
        int mainAxisSizeWithSpacings = i24 + i27;
        int iMax2 = 0;
        while (mainAxisSizeWithSpacings < 0 && i23 > 0) {
            int i28 = i23 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            LazyListMeasuredItem lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i28, 0L, 2, null);
            arrayDeque2.add(0, lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default);
            iMax2 = Math.max(iMax2, lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default.getCrossAxisSize());
            mainAxisSizeWithSpacings = lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings;
            i23 = i28;
            arrayDeque = arrayDeque2;
            i27 = i27;
            i26 = i26;
        }
        int i29 = mainAxisSizeWithSpacings;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i30 = i26;
        int i31 = i27;
        int i32 = iMax2;
        if (i29 < i31) {
            i25 -= i31 - i29;
            i10 = i31;
        } else {
            i10 = i29;
        }
        int i33 = i25;
        int i34 = i10 - i31;
        int i35 = i2 + i4;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i35, 0);
        int mainAxisSizeWithSpacings2 = -i34;
        int i36 = i23;
        int i37 = 0;
        boolean z7 = false;
        while (i37 < arrayDeque3.size()) {
            if (mainAxisSizeWithSpacings2 >= iCoerceAtLeast) {
                arrayDeque3.remove(i37);
                Unit unit = Unit.INSTANCE;
                z7 = true;
            } else {
                i36++;
                mainAxisSizeWithSpacings2 += ((LazyListMeasuredItem) arrayDeque3.get(i37)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i37);
                i37++;
            }
        }
        int mainAxisSizeWithSpacings3 = mainAxisSizeWithSpacings2;
        int i38 = i32;
        boolean z8 = z7;
        int i39 = i23;
        int i40 = i35;
        int i41 = i36;
        int mainAxisSizeWithSpacings4 = i34;
        while (i41 < i && (mainAxisSizeWithSpacings3 < iCoerceAtLeast || mainAxisSizeWithSpacings3 <= 0 || arrayDeque3.isEmpty())) {
            int i42 = i38;
            int i43 = iCoerceAtLeast;
            int i44 = i40;
            int i45 = i39;
            LazyListMeasuredItem lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i41, 0L, 2, null);
            int i46 = i41;
            mainAxisSizeWithSpacings3 += lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings3 <= i31 && i46 != i - 1) {
                mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                Unit unit2 = Unit.INSTANCE;
                i38 = i42;
                z8 = true;
                i39 = i46 + 1;
            } else {
                int iMax3 = Math.max(i42, lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque3.add(lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default2));
                i39 = i45;
                i38 = iMax3;
            }
            i41 = i46 + 1;
            iCoerceAtLeast = i43;
            i40 = i44;
        }
        int i47 = i40;
        int i48 = i41;
        int i49 = i39;
        int iMax4 = i38;
        if (mainAxisSizeWithSpacings3 < i2) {
            int i50 = i2 - mainAxisSizeWithSpacings3;
            int i51 = mainAxisSizeWithSpacings3 + i50;
            int i52 = i49;
            int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i50;
            while (mainAxisSizeWithSpacings5 < i22 && i52 > 0) {
                i52--;
                int i53 = mainAxisSizeWithSpacings5;
                LazyListMeasuredItem lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i52, 0L, 2, null);
                arrayDeque3.add(0, lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default3);
                iMax4 = Math.max(iMax4, lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                mainAxisSizeWithSpacings5 = i53 + lazyListMeasuredItemM2485getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i48 = i48;
                i22 = i3;
            }
            i11 = i48;
            int i54 = mainAxisSizeWithSpacings5;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i50 + i33;
            if (i54 < 0) {
                i13 += i54;
                iMax = iMax4;
                i14 = i51 + i54;
                i16 = i52;
                i15 = 0;
            } else {
                iMax = iMax4;
                i14 = i51;
                i16 = i52;
                i15 = i54;
            }
        } else {
            i11 = i48;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i33;
            iMax = iMax4;
            i14 = mainAxisSizeWithSpacings3;
            i15 = mainAxisSizeWithSpacings4;
            i16 = i49;
        }
        float f2 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i13) || Math.abs(Math.round(f)) < Math.abs(i13)) ? f : i13;
        float f3 = f - f2;
        float f4 = 0.0f;
        if (z4 && i13 > i33 && f3 <= 0.0f) {
            f4 = (i13 - i33) + f3;
        }
        float f5 = f4;
        if ((i15 >= 0 ? 1 : i12) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i55 = -i15;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            while (true) {
                if (i12 >= size) {
                    i17 = i15;
                    i18 = i55;
                    break;
                }
                i18 = i55;
                int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque3.get(i12)).getMainAxisSizeWithSpacings();
                if (i15 == 0 || mainAxisSizeWithSpacings6 > i15) {
                    i17 = i15;
                    break;
                }
                i17 = i15;
                if (i12 == CollectionsKt.getLastIndex(arrayDeque3)) {
                    break;
                }
                i15 = i17 - mainAxisSizeWithSpacings6;
                i12++;
                lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.get(i12);
                i55 = i18;
            }
            i19 = i17;
        } else {
            i19 = i15;
            i18 = i55;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> listCreateItemsBeforeList = createItemsBeforeList(i16, lazyListMeasuredItemProvider2, i8, list);
        int size2 = listCreateItemsBeforeList.size();
        for (int i56 = 0; i56 < size2; i56++) {
            iMax = Math.max(iMax, listCreateItemsBeforeList.get(i56).getCrossAxisSize());
        }
        ArrayDeque arrayDeque4 = arrayDeque3;
        List<LazyListMeasuredItem> listCreateItemsAfterList = createItemsAfterList(arrayDeque4, lazyListMeasuredItemProvider2, i, i8, list);
        int size3 = listCreateItemsAfterList.size();
        for (int i57 = 0; i57 < size3; i57++) {
            iMax = Math.max(iMax, listCreateItemsAfterList.get(i57).getCrossAxisSize());
        }
        boolean z9 = Intrinsics.areEqual(lazyListMeasuredItem2, arrayDeque3.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty();
        int iM10138constrainWidthK40F9xA = ConstraintsKt.m10138constrainWidthK40F9xA(j, z ? iMax : i14);
        if (z) {
            iMax = i14;
        }
        int iM10137constrainHeightK40F9xA = ConstraintsKt.m10137constrainHeightK40F9xA(j, iMax);
        float f6 = f2;
        int i58 = i11;
        int i59 = i14;
        final List<LazyListMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque4, listCreateItemsBeforeList, listCreateItemsAfterList, iM10138constrainWidthK40F9xA, iM10137constrainHeightK40F9xA, i59, i2, i18, z, vertical, horizontal, z2, density);
        if (!ComposeFoundationFlags.isSkipItemPlacementAnimationFixEnabled || z5) {
            lazyLayoutItemAnimator.onMeasured((int) f6, iM10138constrainWidthK40F9xA, iM10137constrainHeightK40F9xA, listCalculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i19, i59, coroutineScope, graphicsContext);
            z6 = z4;
            i20 = i59;
        } else {
            z6 = z4;
            i20 = i59;
        }
        int iM10138constrainWidthK40F9xA2 = iM10138constrainWidthK40F9xA;
        if (z6) {
            i21 = iM10137constrainHeightK40F9xA;
        } else {
            long jM2540getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m2540getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m10337equalsimpl0(jM2540getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m10344getZeroYbymL2g())) {
                i21 = iM10137constrainHeightK40F9xA;
            } else {
                int i60 = z ? iM10137constrainHeightK40F9xA : iM10138constrainWidthK40F9xA2;
                iM10138constrainWidthK40F9xA2 = ConstraintsKt.m10138constrainWidthK40F9xA(j, Math.max(iM10138constrainWidthK40F9xA2, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                int iM10137constrainHeightK40F9xA2 = ConstraintsKt.m10137constrainHeightK40F9xA(j, Math.max(iM10137constrainHeightK40F9xA, (int) (jM2540getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i61 = z ? iM10137constrainHeightK40F9xA2 : iM10138constrainWidthK40F9xA2;
                if (i61 != i60) {
                    int size4 = listCalculateItemsOffsets.size();
                    for (int i62 = 0; i62 < size4; i62++) {
                        listCalculateItemsOffsets.get(i62).updateMainAxisLayoutSize(i61);
                    }
                }
                i21 = iM10137constrainHeightK40F9xA2;
            }
        }
        int i63 = iM10138constrainWidthK40F9xA2;
        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
        int index = lazyListMeasuredItem3 != null ? lazyListMeasuredItem3.getIndex() : 0;
        LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
        final List listApplyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem4 != null ? lazyListMeasuredItem4.getIndex() : 0, listCalculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i63, i21, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, ((Integer) obj).intValue(), 0L, 2, null);
            }
        });
        Integer numValueOf2 = null;
        if (z9) {
            LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) listCalculateItemsOffsets);
            if (lazyListMeasuredItem5 != null) {
                numValueOf = Integer.valueOf(lazyListMeasuredItem5.getIndex());
            } else {
                numValueOf = null;
            }
        } else {
            LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
            if (lazyListMeasuredItem6 != null) {
                numValueOf = Integer.valueOf(lazyListMeasuredItem6.getIndex());
            } else {
                numValueOf = null;
            }
        }
        if (z9) {
            LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateItemsOffsets);
            if (lazyListMeasuredItem7 != null) {
                numValueOf2 = Integer.valueOf(lazyListMeasuredItem7.getIndex());
            }
        } else {
            LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
            if (lazyListMeasuredItem8 != null) {
                numValueOf2 = Integer.valueOf(lazyListMeasuredItem8.getIndex());
            }
        }
        return new LazyListMeasureResult(lazyListMeasuredItem2, i19, i58 < i || i20 > i2, f6, function3.invoke(Integer.valueOf(i63), Integer.valueOf(i21), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList_pIk1_oM$lambda$8(mutableState, listCalculateItemsOffsets, listApplyStickyItems, z6, (Placeable.PlacementScope) obj);
            }
        }), f5, z8, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), LazyLayoutMeasuredItemKt.updatedVisibleItems(numValueOf != null ? numValueOf.intValue() : 0, numValueOf2 != null ? numValueOf2.intValue() : 0, listCalculateItemsOffsets, listApplyStickyItems), i30, i47, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
    }

    static final Unit measureLazyList_pIk1_oM$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList_pIk1_oM$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m2558attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider3;
        int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i2, i - 1);
        int index = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= iMin) {
            int i3 = index;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i3, 0L, 2, null));
                if (i3 == iMin) {
                    break;
                }
                i3++;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > iMin) {
            iMin = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size = list2.size();
        int i4 = 0;
        while (i4 < size) {
            int iIntValue = list2.get(i4).intValue();
            if (iIntValue > iMin) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
                arrayList.add(LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider3, iIntValue, 0L, 2, null));
            } else {
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
            }
            i4++;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider3;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            int i4 = i3;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i4, 0L, 2, null));
                if (i4 == iMax) {
                    break;
                }
                i4--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i5 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m2485getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, iIntValue, 0L, 2, null));
                }
                if (i5 < 0) {
                    break;
                }
                size = i5;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size2 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        size2 = (i6 - size2) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(size2, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int mainAxisSizeWithSpacings = i5;
            for (int i8 = 0; i8 < size3; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i8);
                mainAxisSizeWithSpacings -= lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem2.position(mainAxisSizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size4 = list.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i9 = 0; i9 < size4; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i9);
                lazyListMeasuredItem3.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i10 = 0; i10 < size5; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i10);
                lazyListMeasuredItem4.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem4.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList_pIk1_oM$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyListMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyListMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
