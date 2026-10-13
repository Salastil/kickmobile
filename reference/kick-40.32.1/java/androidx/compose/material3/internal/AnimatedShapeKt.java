package androidx.compose.material3.internal;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ShapeWithHorizontalCenterOptically;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: AnimatedShape.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"rememberAnimatedShape", "Landroidx/compose/ui/graphics/Shape;", "state", "Landroidx/compose/material3/internal/AnimatedShapeState;", "(Landroidx/compose/material3/internal/AnimatedShapeState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "currentShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/internal/AnimatedCornerBasedShapeState;", "(Landroidx/compose/material3/internal/AnimatedCornerBasedShapeState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnimatedShapeKt {
    private static final Shape rememberAnimatedShape(final AnimatedShapeState animatedShapeState, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1383367813, "C(rememberAnimatedShape)N(state)91@3725L7,94@3773L1468:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1383367813, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:90)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        animatedShapeState.setDensity(density);
        ComposerKt.sourceInformationMarkerStart(composer, 2023399447, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(animatedShapeState)) || (i & 6) == 4) | composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ShapeWithHorizontalCenterOptically() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$1$1

                /* JADX INFO: renamed from: clampedRange$delegate, reason: from kotlin metadata */
                private final MutableState clampedRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RangesKt.rangeTo(0.0f, 1.0f), null, 2, null);

                public final ClosedFloatingPointRange<Float> getClampedRange() {
                    return (ClosedFloatingPointRange) this.clampedRange.getValue();
                }

                public final void setClampedRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    this.clampedRange.setValue(closedFloatingPointRange);
                }

                @Override // androidx.compose.material3.ShapeWithHorizontalCenterOptically
                public float offset() {
                    float fFloatValue = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5305topStartTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue();
                    float fFloatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5304topEndTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue();
                    return (((fFloatValue + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5303bottomStartTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f) - ((fFloatValue2 + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5302bottomEndTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f)) * 0.11f;
                }

                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo1614createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density2) {
                    animatedShapeState.m5309setSizeuvyYCjk(size);
                    setClampedRange(RangesKt.rangeTo(0.0f, Float.intBitsToFloat((int) (4294967295L & size)) / 2.0f));
                    return animatedShapeState.getShape().copy(CornerSizeKt.CornerSize(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5305topStartTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()), CornerSizeKt.CornerSize(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5304topEndTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()), CornerSizeKt.CornerSize(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5302bottomEndTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()), CornerSizeKt.CornerSize(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m5303bottomStartTmRCtEA$default(animatedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue())).mo1614createOutlinePq9zytI(size, layoutDirection, density2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        AnimatedShapeKt$rememberAnimatedShape$1$1 animatedShapeKt$rememberAnimatedShape$1$1 = (AnimatedShapeKt$rememberAnimatedShape$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animatedShapeKt$rememberAnimatedShape$1$1;
    }

    public static final Shape rememberAnimatedShape(final RoundedCornerShape roundedCornerShape, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -288714613, "C(rememberAnimatedShape)N(currentShape,animationSpec)135@5413L90,137@5523L59,139@5599L33,139@5588L44,140@5668L177,140@5637L208,147@5858L28:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-288714613, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:133)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1718135941, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChanged = composer.changed(finiteAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new AnimatedShapeState(roundedCornerShape, finiteAnimationSpec);
            composer.updateRememberedValue(objRememberedValue);
        }
        AnimatedShapeState animatedShapeState = (AnimatedShapeState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1718139430, "CC(remember):AnimatedShape.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final Channel channel = (Channel) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1718141836, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(roundedCornerShape)) || (i & 6) == 4) | composer.changedInstance(channel);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnimatedShapeKt.rememberAnimatedShape$lambda$3$0(channel, roundedCornerShape);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) objRememberedValue3, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1718144188, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(channel) | composer.changed(animatedShapeState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function2) new AnimatedShapeKt$rememberAnimatedShape$3$1(channel, animatedShapeState, null);
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(animatedShapeState, channel, (Function2) objRememberedValue4, composer, 0);
        Shape shapeRememberAnimatedShape = rememberAnimatedShape(animatedShapeState, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapeRememberAnimatedShape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberAnimatedShape$lambda$3$0(Channel channel, RoundedCornerShape roundedCornerShape) {
        channel.mo12563trySendJP2dKIU(roundedCornerShape);
        return Unit.INSTANCE;
    }

    private static final Shape rememberAnimatedShape(final AnimatedCornerBasedShapeState animatedCornerBasedShapeState, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1796061591, "C(rememberAnimatedShape)N(state)197@7783L7,200@7831L1401:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1796061591, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:196)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        animatedCornerBasedShapeState.setDensity(density);
        ComposerKt.sourceInformationMarkerStart(composer, 561670306, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(animatedCornerBasedShapeState)) || (i & 6) == 4) | composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ShapeWithHorizontalCenterOptically() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$4$1

                /* JADX INFO: renamed from: clampedRange$delegate, reason: from kotlin metadata */
                private final MutableState clampedRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RangesKt.rangeTo(0.0f, 1.0f), null, 2, null);

                public final ClosedFloatingPointRange<Float> getClampedRange() {
                    return (ClosedFloatingPointRange) this.clampedRange.getValue();
                }

                public final void setClampedRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    this.clampedRange.setValue(closedFloatingPointRange);
                }

                @Override // androidx.compose.material3.ShapeWithHorizontalCenterOptically
                public float offset() {
                    float fFloatValue = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5294topStartTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue();
                    float fFloatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5293topEndTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue();
                    return (((fFloatValue + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5292bottomStartTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f) - ((fFloatValue2 + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5291bottomEndTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f)) * 0.11f;
                }

                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo1614createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density2) {
                    animatedCornerBasedShapeState.m5298setSizeuvyYCjk(size);
                    setClampedRange(RangesKt.rangeTo(0.0f, Float.intBitsToFloat((int) (4294967295L & size)) / 2.0f));
                    return RoundedCornerShapeKt.RoundedCornerShape(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5294topStartTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5293topEndTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5291bottomEndTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedCornerBasedShapeState.m5292bottomStartTmRCtEA$default(animatedCornerBasedShapeState, 0L, null, 3, null)), getClampedRange())).floatValue()).mo1614createOutlinePq9zytI(size, layoutDirection, density2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        AnimatedShapeKt$rememberAnimatedShape$4$1 animatedShapeKt$rememberAnimatedShape$4$1 = (AnimatedShapeKt$rememberAnimatedShape$4$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animatedShapeKt$rememberAnimatedShape$4$1;
    }

    public static final Shape rememberAnimatedShape(final CornerBasedShape cornerBasedShape, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 282475599, "C(rememberAnimatedShape)N(currentShape,animationSpec)240@9402L121,244@9543L57,246@9617L33,246@9606L44,247@9686L177,247@9655L208,254@9876L28:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(282475599, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:238)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 876115752, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChanged = composer.changed(finiteAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new AnimatedCornerBasedShapeState(cornerBasedShape, finiteAnimationSpec);
            composer.updateRememberedValue(objRememberedValue);
        }
        AnimatedCornerBasedShapeState animatedCornerBasedShapeState = (AnimatedCornerBasedShapeState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 876120200, "CC(remember):AnimatedShape.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final Channel channel = (Channel) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 876122544, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(cornerBasedShape)) || (i & 6) == 4) | composer.changedInstance(channel);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnimatedShapeKt.rememberAnimatedShape$lambda$8$0(channel, cornerBasedShape);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) objRememberedValue3, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 876124896, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(channel) | composer.changed(animatedCornerBasedShapeState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function2) new AnimatedShapeKt$rememberAnimatedShape$6$1(channel, animatedCornerBasedShapeState, null);
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(animatedCornerBasedShapeState, channel, (Function2) objRememberedValue4, composer, 0);
        Shape shapeRememberAnimatedShape = rememberAnimatedShape(animatedCornerBasedShapeState, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapeRememberAnimatedShape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberAnimatedShape$lambda$8$0(Channel channel, CornerBasedShape cornerBasedShape) {
        channel.mo12563trySendJP2dKIU(cornerBasedShape);
        return Unit.INSTANCE;
    }
}
