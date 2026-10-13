package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
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
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\"\u0010'\u001a\u00020(*\u00020)2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020*0!2\u0006\u0010+\u001a\u00020(H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\r\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "indicatorPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "topIconIndicatorToLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getIndicatorPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "()F", "F", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewProps.HEIGHT, "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0<Float> iconPositionProgress;
    private final Function0<Float> indicatorAnimationProgress;
    private final PaddingValues indicatorPadding;
    private final float itemHorizontalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;

    public /* synthetic */ AnimatedMeasurePolicy(int i, Function0 function0, Function0 function1, PaddingValues paddingValues, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, function1, paddingValues, f, f2, f3);
    }

    private AnimatedMeasurePolicy(int i, Function0<Float> function0, Function0<Float> function1, PaddingValues paddingValues, float f, float f2, float f3) {
        this.iconPosition = i;
        this.iconPositionProgress = function0;
        this.indicatorAnimationProgress = function1;
        this.indicatorPadding = paddingValues;
        this.topIconIndicatorToLabelVerticalPadding = f;
        this.startIconToLabelHorizontalPadding = f2;
        this.itemHorizontalPadding = f3;
    }

    /* JADX INFO: renamed from: getIconPosition--xw1Ddg, reason: not valid java name and from getter */
    public final int getIconPosition() {
        return this.iconPosition;
    }

    public final Function0<Float> getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    public final PaddingValues getIndicatorPadding() {
        return this.indicatorPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorToLabelVerticalPadding() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconToLabelHorizontalPadding() {
        return this.startIconToLabelHorizontalPadding;
    }

    /* JADX INFO: renamed from: getItemHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1311measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        float fFloatValue = this.indicatorAnimationProgress.invoke().floatValue();
        float fFloatValue2 = this.iconPositionProgress.invoke().floatValue();
        int i = 0;
        long jM10111copyZbe2FdA$default = Constraints.m10111copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(jM10111copyZbe2FdA$default);
                int size2 = list2.size();
                int i3 = i;
                while (i3 < size2) {
                    Measurable measurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                        Placeable placeableMo8808measureBRTryo1 = measurable2.mo8808measureBRTryo0(jM10111copyZbe2FdA$default);
                        PaddingValues paddingValues = this.indicatorPadding;
                        if (paddingValues instanceof DynamicPaddingValues) {
                            ((DynamicPaddingValues) paddingValues).setProgress(fFloatValue2);
                        }
                        float fM10168constructorimpl = Dp.m10168constructorimpl(PaddingKt.calculateStartPadding(this.indicatorPadding, measureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(this.indicatorPadding, measureScope.getLayoutDirection()));
                        float fM10168constructorimpl2 = Dp.m10168constructorimpl(this.indicatorPadding.getTop() + this.indicatorPadding.getBottom());
                        int width = placeableMo8808measureBRTryo0.getWidth();
                        int height = placeableMo8808measureBRTryo0.getHeight();
                        int width2 = placeableMo8808measureBRTryo0.getWidth() + placeableMo8808measureBRTryo1.getWidth() + measureScope.mo1728roundToPx0680j_4(this.startIconToLabelHorizontalPadding);
                        int iMax = Math.max(placeableMo8808measureBRTryo0.getHeight(), placeableMo8808measureBRTryo1.getHeight());
                        int iLerp = MathHelpersKt.lerp(width, width2, fFloatValue2) + measureScope.mo1728roundToPx0680j_4(fM10168constructorimpl);
                        int iRoundToInt = MathKt.roundToInt(iLerp * fFloatValue);
                        int iLerp2 = MathHelpersKt.lerp(height, iMax, fFloatValue2) + measureScope.mo1728roundToPx0680j_4(fM10168constructorimpl2);
                        int size3 = list2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                Placeable placeableMo8808measureBRTryo2 = measurable3.mo8808measureBRTryo0(ConstraintsKt.m10136constrainN9IONVI(jM10111copyZbe2FdA$default, Constraints.INSTANCE.m10131fixedJhjzzOo(iLerp, iLerp2)));
                                int size4 = list2.size();
                                int i5 = 0;
                                while (i5 < size4) {
                                    Measurable measurable4 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        return NavigationItemKt.m4433placeAnimatedLabelAndIconPXWvyXQ(measureScope, this.iconPosition, this.iconPositionProgress, placeableMo8808measureBRTryo1, placeableMo8808measureBRTryo0, placeableMo8808measureBRTryo2, measurable4.mo8808measureBRTryo0(ConstraintsKt.m10136constrainN9IONVI(jM10111copyZbe2FdA$default, Constraints.INSTANCE.m10131fixedJhjzzOo(iRoundToInt, iLerp2))), width, jM10111copyZbe2FdA$default, this.topIconIndicatorToLabelVerticalPadding, this.indicatorPadding, this.startIconToLabelHorizontalPadding, this.itemHorizontalPadding);
                                    }
                                    i5++;
                                    placeableMo8808measureBRTryo1 = placeableMo8808measureBRTryo1;
                                    width = width;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i4++;
                            placeableMo8808measureBRTryo1 = placeableMo8808measureBRTryo1;
                            width = width;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i3++;
                    measureScope = measureScope;
                    i = 0;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i2++;
            i = 0;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        int iMaxIntrinsicWidth2 = intrinsicMeasurable2.maxIntrinsicWidth(i);
                        int i4 = intrinsicMeasureScope.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(PaddingKt.calculateStartPadding(this.indicatorPadding, intrinsicMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(this.indicatorPadding, intrinsicMeasureScope.getLayoutDirection())));
                        if (NavigationItemIconPosition.m4416equalsimpl0(this.iconPosition, NavigationItemIconPosition.INSTANCE.m4421getTopxw1Ddg())) {
                            return Math.max(iMaxIntrinsicWidth2, iMaxIntrinsicWidth + i4 + intrinsicMeasureScope.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(this.itemHorizontalPadding * 2.0f)));
                        }
                        return iMaxIntrinsicWidth + iMaxIntrinsicWidth2 + i4 + intrinsicMeasureScope.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(this.startIconToLabelHorizontalPadding + this.itemHorizontalPadding));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
