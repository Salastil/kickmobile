package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.AnimatedShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aG\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0001¢\u0006\u0002\u0010\u0014\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u0015"}, d2 = {"hasRoundedCornerShapes", "", "Landroidx/compose/material3/ListItemShapes;", "getHasRoundedCornerShapes$annotations", "(Landroidx/compose/material3/ListItemShapes;)V", "getHasRoundedCornerShapes", "(Landroidx/compose/material3/ListItemShapes;)Z", "hasCornerBasedShapes", "getHasCornerBasedShapes$annotations", "getHasCornerBasedShapes", "shapeForInteraction", "Landroidx/compose/ui/graphics/Shape;", "selected", "pressed", "focused", "hovered", "dragged", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/material3/ListItemShapes;ZZZZZLandroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ListItemDefaultsKt {
    private static /* synthetic */ void getHasCornerBasedShapes$annotations(ListItemShapes listItemShapes) {
    }

    private static /* synthetic */ void getHasRoundedCornerShapes$annotations(ListItemShapes listItemShapes) {
    }

    private static final boolean getHasRoundedCornerShapes(ListItemShapes listItemShapes) {
        return (listItemShapes.getShape() instanceof RoundedCornerShape) && (listItemShapes.getSelectedShape() instanceof RoundedCornerShape) && (listItemShapes.getPressedShape() instanceof RoundedCornerShape) && (listItemShapes.getFocusedShape() instanceof RoundedCornerShape) && (listItemShapes.getHoveredShape() instanceof RoundedCornerShape) && (listItemShapes.getDraggedShape() instanceof RoundedCornerShape);
    }

    private static final boolean getHasCornerBasedShapes(ListItemShapes listItemShapes) {
        return (listItemShapes.getShape() instanceof CornerBasedShape) && (listItemShapes.getSelectedShape() instanceof CornerBasedShape) && (listItemShapes.getPressedShape() instanceof CornerBasedShape) && (listItemShapes.getFocusedShape() instanceof CornerBasedShape) && (listItemShapes.getHoveredShape() instanceof CornerBasedShape) && (listItemShapes.getDraggedShape() instanceof CornerBasedShape);
    }

    public static final Shape shapeForInteraction(ListItemShapes listItemShapes, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        Shape shape;
        composer.startReplaceGroup(2080718032);
        ComposerKt.sourceInformation(composer, "C(shapeForInteraction)N(selected,pressed,focused,hovered,dragged,animationSpec):ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2080718032, i, -1, "androidx.compose.material3.shapeForInteraction (ListItemDefaults.kt:1059)");
        }
        if (z2) {
            shape = listItemShapes.getPressedShape();
        } else if (z5) {
            shape = listItemShapes.getDraggedShape();
        } else if (z) {
            shape = listItemShapes.getSelectedShape();
        } else if (z3) {
            shape = listItemShapes.getFocusedShape();
        } else if (z4) {
            shape = listItemShapes.getHoveredShape();
        } else {
            shape = listItemShapes.getShape();
        }
        if (getHasRoundedCornerShapes(listItemShapes)) {
            composer.startReplaceGroup(1703365676);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(-1884714849, listItemShapes);
            ComposerKt.sourceInformation(composer, "1071@53732L65");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.RoundedCornerShape");
            Shape shapeRememberAnimatedShape = AnimatedShapeKt.rememberAnimatedShape((RoundedCornerShape) shape, finiteAnimationSpec, composer, (i >> 15) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape;
        }
        if (getHasCornerBasedShapes(listItemShapes)) {
            composer.startReplaceGroup(1703498542);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(-1884710563, listItemShapes);
            ComposerKt.sourceInformation(composer, "1073@53866L63");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            Shape shapeRememberAnimatedShape2 = AnimatedShapeKt.rememberAnimatedShape((CornerBasedShape) shape, finiteAnimationSpec, composer, (i >> 15) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape2;
        }
        composer.startReplaceGroup(1703594642);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shape;
    }
}
