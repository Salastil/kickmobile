package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\"\u0010'\u001a\u00020\t*\u00020(2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010*\u001a\u00020\t*\u00020(2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010+\u001a\u00020\tH\u0016J\"\u0010,\u001a\u00020\t*\u00020(2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010-\u001a\u00020\t*\u00020(2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010+\u001a\u00020\tH\u0016JS\u0010.\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b6\u00107R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00068"}, d2 = {"Landroidx/compose/material3/TopAppBarMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "titleBottomPadding", "", ViewProps.HEIGHT, "Landroidx/compose/ui/unit/Dp;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScrolledOffset", "()Landroidx/compose/material3/internal/FloatProducer;", "getTitleVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getTitleBottomPadding", "()I", "getHeight-D9Ej5fM", "()F", "F", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minIntrinsicHeight", ViewProps.WIDTH, "maxIntrinsicWidth", "maxIntrinsicHeight", "placeTopAppBar", "layoutHeight", "maxLayoutHeight", "navigationIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "titlePlaceable", "actionIconsPlaceable", "titleBaseline", "placeTopAppBar-LfZho9M", "(Landroidx/compose/ui/layout/MeasureScope;JIILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ILandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TopAppBarMeasurePolicy implements MeasurePolicy {
    private final PaddingValues contentPadding;
    private final float height;
    private final FloatProducer scrolledOffset;
    private final int titleBottomPadding;
    private final Alignment.Horizontal titleHorizontalAlignment;
    private final Arrangement.Vertical titleVerticalArrangement;

    public /* synthetic */ TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(floatProducer, vertical, horizontal, i, f, paddingValues);
    }

    private TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f, PaddingValues paddingValues) {
        this.scrolledOffset = floatProducer;
        this.titleVerticalArrangement = vertical;
        this.titleHorizontalAlignment = horizontal;
        this.titleBottomPadding = i;
        this.height = f;
        this.contentPadding = paddingValues;
    }

    public final FloatProducer getScrolledOffset() {
        return this.scrolledOffset;
    }

    public final Arrangement.Vertical getTitleVerticalArrangement() {
        return this.titleVerticalArrangement;
    }

    public final Alignment.Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final int getTitleBottomPadding() {
        return this.titleBottomPadding;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getHeight() {
        return this.height;
    }

    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        int i2 = intrinsicMeasureScope.mo1728roundToPx0680j_4(this.height);
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num = numValueOf;
        return Math.max(i2, num != null ? num.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        int i2 = intrinsicMeasureScope.mo1728roundToPx0680j_4(this.height);
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num = numValueOf;
        return Math.max(i2, num != null ? num.intValue() : 0);
    }

    /* JADX INFO: renamed from: placeTopAppBar-LfZho9M, reason: not valid java name */
    private final MeasureResult m5201placeTopAppBarLfZho9M(MeasureScope measureScope, final long j, int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final int i3, PaddingValues paddingValues) {
        int i4 = measureScope.mo1728roundToPx0680j_4(paddingValues.getTop());
        int i5 = measureScope.mo1728roundToPx0680j_4(paddingValues.getBottom());
        final int i6 = measureScope.mo1728roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, measureScope.getLayoutDirection()));
        final int i7 = measureScope.mo1728roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, measureScope.getLayoutDirection()));
        final int i8 = (i + i4) - i5;
        return MeasureScope.layout$default(measureScope, Constraints.m10121getMaxWidthimpl(j), i, null, new Function1() { // from class: androidx.compose.material3.TopAppBarMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TopAppBarMeasurePolicy.placeTopAppBar_LfZho9M$lambda$0(placeable, i6, i8, placeable2, placeable3, j, i7, this, i3, i2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0067  */
    /* JADX WARN: Code duplicated, block: B:12:0x0070  */
    /* JADX WARN: Code duplicated, block: B:14:0x007d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0081  */
    /* JADX WARN: Code duplicated, block: B:17:0x0088  */
    /* JADX WARN: Code duplicated, block: B:19:0x0096  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    static final Unit placeTopAppBar_LfZho9M$lambda$0(Placeable placeable, int i, int i2, Placeable placeable2, Placeable placeable3, long j, int i3, TopAppBarMeasurePolicy topAppBarMeasurePolicy, int i4, int i5, Placeable.PlacementScope placementScope) {
        int iM10121getMaxWidthimpl;
        Arrangement.Vertical vertical;
        int height;
        int i6;
        int height2;
        int height3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, (i2 - placeable.getHeight()) / 2, 0.0f, 4, null);
        int iMax = Math.max(placementScope.mo1728roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeable.getWidth());
        int width = placeable3.getWidth();
        int iAlign = topAppBarMeasurePolicy.titleHorizontalAlignment.align(placeable2.getWidth(), Constraints.m10121getMaxWidthimpl(j), LayoutDirection.Ltr);
        if (iAlign >= iMax) {
            if (placeable2.getWidth() + iAlign > Constraints.m10121getMaxWidthimpl(j) - width) {
                iM10121getMaxWidthimpl = (Constraints.m10121getMaxWidthimpl(j) - width) - (placeable2.getWidth() + iAlign);
            }
            int i7 = iAlign;
            vertical = topAppBarMeasurePolicy.titleVerticalArrangement;
            if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                height = (i2 - placeable2.getHeight()) / 2;
            } else if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getBottom())) {
                i6 = topAppBarMeasurePolicy.titleBottomPadding;
                if (i6 == 0) {
                    height = i2 - placeable2.getHeight();
                } else {
                    height2 = i6 - (placeable2.getHeight() - i4);
                    height3 = placeable2.getHeight() + height2;
                    if (height3 > i5) {
                        height2 -= height3 - i5;
                    }
                    height = (i2 - placeable2.getHeight()) - Math.max(0, height2);
                }
            } else {
                height = 0;
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i7, height, 0.0f, 4, null);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, (Constraints.m10121getMaxWidthimpl(j) - placeable3.getWidth()) - i3, (i2 - placeable3.getHeight()) / 2, 0.0f, 4, null);
            return Unit.INSTANCE;
        }
        iM10121getMaxWidthimpl = iMax - iAlign;
        iAlign += i + iM10121getMaxWidthimpl;
        int i8 = iAlign;
        vertical = topAppBarMeasurePolicy.titleVerticalArrangement;
        if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
            height = (i2 - placeable2.getHeight()) / 2;
        } else if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getBottom())) {
            i6 = topAppBarMeasurePolicy.titleBottomPadding;
            if (i6 == 0) {
                height = i2 - placeable2.getHeight();
            } else {
                height2 = i6 - (placeable2.getHeight() - i4);
                height3 = placeable2.getHeight() + height2;
                if (height3 > i5) {
                    height2 -= height3 - i5;
                }
                height = (i2 - placeable2.getHeight()) - Math.max(0, height2);
            }
        } else {
            height = 0;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i8, height, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, (Constraints.m10121getMaxWidthimpl(j) - placeable3.getWidth()) - i3, (i2 - placeable3.getHeight()) / 2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        int i;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                        Placeable placeableMo8808measureBRTryo1 = measurable2.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                        float fCalculateStartPadding = PaddingKt.calculateStartPadding(this.contentPadding, measureScope.getLayoutDirection());
                        float fCalculateEndPadding = PaddingKt.calculateEndPadding(this.contentPadding, measureScope.getLayoutDirection());
                        int iMax = Math.max(measureScope.mo1728roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeableMo8808measureBRTryo0.getWidth());
                        if (Constraints.m10121getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            iCoerceAtLeast = Constraints.m10121getMaxWidthimpl(j);
                        } else {
                            iCoerceAtLeast = RangesKt.coerceAtLeast((((Constraints.m10121getMaxWidthimpl(j) - iMax) - placeableMo8808measureBRTryo1.getWidth()) - measureScope.mo1728roundToPx0680j_4(fCalculateStartPadding)) - measureScope.mo1728roundToPx0680j_4(fCalculateEndPadding), 0);
                        }
                        int i4 = iCoerceAtLeast;
                        int size3 = list2.size();
                        int i5 = 0;
                        while (i5 < size3) {
                            Measurable measurable3 = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                Placeable placeableMo8808measureBRTryo2 = measurable3.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(j, 0, i4, 0, 0, 12, null));
                                int i6 = placeableMo8808measureBRTryo2.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? placeableMo8808measureBRTryo2.get(AlignmentLineKt.getLastBaseline()) : 0;
                                float fInvoke = this.scrolledOffset.invoke();
                                int iRoundToInt = Float.isNaN(fInvoke) ? 0 : MathKt.roundToInt(fInvoke);
                                int iMax2 = Math.max(measureScope.mo1728roundToPx0680j_4(this.height), placeableMo8808measureBRTryo2.getHeight()) + measureScope.mo1728roundToPx0680j_4(this.contentPadding.getTop()) + measureScope.mo1728roundToPx0680j_4(this.contentPadding.getBottom());
                                if (Constraints.m10120getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                                    iCoerceAtLeast2 = iMax2;
                                    i = iCoerceAtLeast2;
                                } else {
                                    iCoerceAtLeast2 = RangesKt.coerceAtLeast(iRoundToInt + iMax2, 0);
                                    i = iMax2;
                                }
                                return this.m5201placeTopAppBarLfZho9M(measureScope, j, iCoerceAtLeast2, i, placeableMo8808measureBRTryo0, placeableMo8808measureBRTryo2, placeableMo8808measureBRTryo1, i6, this.contentPadding);
                            }
                            i5++;
                            this = this;
                            measureScope = measureScope;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i3++;
                    this = this;
                    measureScope = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMinIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMinIntrinsicWidth += list.get(i2).minIntrinsicWidth(i);
        }
        return iMinIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMaxIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMaxIntrinsicWidth += list.get(i2).maxIntrinsicWidth(i);
        }
        return iMaxIntrinsicWidth;
    }
}
